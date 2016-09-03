package com.codex.web;


import com.codex.common.Constants;
import com.codex.request.LoginPostReq;
import com.codex.response.BaseResponse;
import com.codex.service.LoginService;


import com.codex.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class LoginController {

    @Autowired
    @Qualifier(value = "LoginService")
    private LoginService loginService;

    /**
     * 登陆页面
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/loginPost",method = RequestMethod.POST)
    @ResponseBody
    private BaseResponse loginPost(@RequestBody LoginPostReq req) throws Exception {
        BaseResponse response = new BaseResponse();
        if (StringUtil.isEmpty(req.getPassWord()) || StringUtil.isEmpty(req.getUserName())) {
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