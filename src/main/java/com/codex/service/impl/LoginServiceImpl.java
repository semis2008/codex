package com.codex.service.impl;

import com.codex.common.Constants;
import com.codex.dao.UserMapper;
import com.codex.model.User;
import com.codex.model.UserStatus;
import com.codex.request.LoginPostReq;
import com.codex.request.RegistSubmitReq;
import com.codex.response.BaseResponse;
import com.codex.service.LoginService;
import com.codex.util.SHAUtil;
import com.codex.util.StringUtil;
import com.codex.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by ningwang4 on 16/9/1.
 */
@Service("LoginService")
public class LoginServiceImpl implements LoginService{

    @Autowired
    private UserMapper userMapper;

    public BaseResponse loginPost(LoginPostReq req, HttpServletRequest request) throws Exception{
        BaseResponse response = new BaseResponse();
        User user = userMapper.queryUserByName(req.getUserName());
        if(user==null) {
            response.setRetcode(Constants.CODE_FAIL);
            response.setRetdesc("username or password is wrong!");
            return response;
        }
        //校验密码
        String inputPass = UserUtil.getPassEncrypt(req.getPassWord());
        if(user.getPassWord().equals(inputPass)) {
            response.setRetdesc("login success！");
            //写入session
            WebUtils.setSessionAttribute(request,Constants.LOGIN_USER,user);
        }
        return response;
    }

    public BaseResponse regist(RegistSubmitReq req) throws Exception {
        BaseResponse response = new BaseResponse();
        User user = userMapper.queryUserByName(req.getUserName());
        if(user!=null) {
            response.setRetcode(Constants.CODE_FAIL);
            response.setRetdesc("The username your entered already exist!");
            return response;
        }
        //新增用户
        user = new User();
        user.setUserName(req.getUserName());
        user.setPassWord(UserUtil.getPassEncrypt(req.getPassWord()));
        user.setUserKey(UserUtil.getUserKey());
        user.setPhone(req.getPhone());
        user.setStatus(UserStatus.LIMIT.getStatus());
        Integer res = userMapper.insertUser(user);
//        if(res!=1) {
//            response.setRetcode(Constants.CODE_FAIL);
//            response.setRetdesc("Regist User Fail:DB Fail!");
//            return response;
//        }
        return response;
    }
}
