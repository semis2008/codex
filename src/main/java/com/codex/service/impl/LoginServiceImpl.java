package com.codex.service.impl;

import com.codex.common.Constants;
import com.codex.dao.UserMapper;
import com.codex.model.User;
import com.codex.request.LoginPostReq;
import com.codex.response.BaseResponse;
import com.codex.service.LoginService;
import com.codex.util.SHAUtil;
import com.codex.util.StringUtil;
import com.codex.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ningwang4 on 16/9/1.
 */
@Service("LoginService")
public class LoginServiceImpl implements LoginService{

    @Autowired
    private UserMapper userMapper;

    public BaseResponse loginPost(LoginPostReq req) throws Exception{
        BaseResponse response = new BaseResponse();
        User user = userMapper.queryUserByName(req.getUserName());
        if(user==null) {
            response.setRetcode(Constants.CODE_FAIL);
            response.setRetdesc("The user name your entered does not exist!");
            return response;
        }
        //校验密码
        String inputPass = UserUtil.getPassEncrypt(req.getPassWord());
        if(user.getPassWord().equals(inputPass)) {
            response.setRetdesc("login success！");
        }
        return response;
    }
}
