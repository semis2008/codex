package com.codex.web;


import com.codex.common.Constants;
import com.codex.request.LoginPostReq;
import com.codex.response.BaseResponse;
import com.codex.service.LoginService;
import com.sun.tools.javac.code.Attribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    /**
     * 登陆页面
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/loginPost")
    private BaseResponse loginPost(@RequestBody LoginPostReq req) throws Exception {
        BaseResponse response = new BaseResponse();
        if (StringUtils.isEmpty(req.getPassWord()) || StringUtils.isEmpty(req.getUserName())) {
            response.setRetcode(Constants.CODE_PARAMETER_ERROR);
            response.setRetdesc("username or password can`t be null!");
            return response;
        }
        try {
            response = loginService.loginPost(req);
        } catch (Exception e) {
            e.printStackTrace();
            response.setRetcode(Constants.CODE_EXCEPTION);
            response.setRetdesc("system error!");
            return response;
        }
        return response;
    }

}