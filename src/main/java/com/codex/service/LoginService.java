package com.codex.service;

import com.codex.request.LoginPostReq;
import com.codex.request.RegistSubmitReq;
import com.codex.response.BaseResponse;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by ningwang4 on 16/9/1.
 */
public interface LoginService {

    BaseResponse loginPost(LoginPostReq req, HttpServletRequest request) throws Exception;

    BaseResponse regist(RegistSubmitReq req) throws Exception;
}
