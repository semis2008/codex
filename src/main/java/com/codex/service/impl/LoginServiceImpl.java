package com.codex.service.impl;

import com.codex.request.LoginPostReq;
import com.codex.response.BaseResponse;
import com.codex.service.LoginService;
import org.springframework.stereotype.Service;

/**
 * Created by ningwang4 on 16/9/1.
 */
@Service("LoginService")
public class LoginServiceImpl implements LoginService{

    public BaseResponse loginPost(LoginPostReq req) {
        BaseResponse response = new BaseResponse();


        return response;
    }
}
