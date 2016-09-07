package com.codex.web;


import com.codex.common.Constants;
import com.codex.request.LoginPostReq;
import com.codex.request.RegistSubmitReq;
import com.codex.response.BaseResponse;
import com.codex.service.LoginService;


import com.codex.util.StringUtil;
import com.codex.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
public class LoginController {

    @Autowired
    @Qualifier(value = "LoginService")
    private LoginService loginService;

    /**
     * 登陆
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/loginPost",method = RequestMethod.POST)
    @ResponseBody
    private BaseResponse loginPost(@RequestBody LoginPostReq req, HttpServletRequest request, HttpServletResponse httpServletResponse) throws Exception {
        BaseResponse response = new BaseResponse();
        if (StringUtil.isEmpty(req.getPassWord()) || StringUtil.isEmpty(req.getUserName())) {
            response.setRetcode(Constants.CODE_PARAMETER_ERROR);
            response.setRetdesc("username or password can`t be null!");
            return response;
        }
        try {
            response = loginService.loginPost(req,request);
            if(response.getRetcode()==Constants.CODE_SUCCESS) {
                //写cookie
                String sessionStr = UUIDUtil.getUUID();
                sessionStr = sessionStr.replaceAll("\r\n", "");
                Cookie cookie = new Cookie(Constants.SESSION_KEY, sessionStr);
                cookie.setMaxAge(7*24*86400);
                cookie.setPath("/");
                httpServletResponse.addCookie(cookie);
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.setRetcode(Constants.CODE_EXCEPTION);
            response.setRetdesc("system error!");
            return response;
        }
        return response;
    }

    /**
     * 用户注册
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/registSubmit",method = RequestMethod.POST)
    @ResponseBody
    private BaseResponse registSubmit(@RequestBody RegistSubmitReq req) throws Exception {
        BaseResponse response = new BaseResponse();
        if (StringUtil.isEmpty(req.getPassWord()) || StringUtil.isEmpty(req.getUserName())||StringUtil.isEmpty(req.getPhone())) {
            response.setRetcode(Constants.CODE_PARAMETER_ERROR);
            response.setRetdesc("parameter can`t be null!");
            return response;
        }
        try {
            response = loginService.regist(req);
        } catch (Exception e) {
            e.printStackTrace();
            response.setRetcode(Constants.CODE_EXCEPTION);
            response.setRetdesc("system error!");
            return response;
        }
        return response;
    }


    /**
     * 用户登出
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/logout",method = RequestMethod.POST)
    @ResponseBody
    private BaseResponse logout(HttpServletRequest req) throws Exception {
        BaseResponse response = new BaseResponse();
        try {
            WebUtils.setSessionAttribute(req,Constants.LOGIN_USER,null);
        } catch (Exception e) {
            e.printStackTrace();
            response.setRetcode(Constants.CODE_EXCEPTION);
            response.setRetdesc("system error!");
            return response;
        }
        return response;
    }

}