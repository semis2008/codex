package com.codex.service;

import com.codex.request.LoginPostReq;
import com.codex.response.BaseResponse;

/**
 * Created by ningwang4 on 16/9/1.
 */
public interface LoginService {

    BaseResponse loginPost(LoginPostReq req);
}
