package com.codex.intercepor;

/*
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license
 * agreements. See the NOTICE file distributed with this work for additional information regarding
 * copyright ownership. The ASF licenses this file to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License. You may obtain a
 * copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */


import com.codex.common.Constants;
import com.codex.model.User;
import com.codex.util.UserUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.List;


public class LoginInterceptor extends HandlerInterceptorAdapter {


    private List<String> excludedUrls = Collections.emptyList();

    private static Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        String requestUri = request.getRequestURI();
        logger.info("request uri:" + requestUri);
        if (requestUri != null &&  requestUri.contains(".") ) {
            return true;
        }
        for (String url : excludedUrls) {
            if (requestUri.endsWith(url)) {
                return true;
            }
        }
        User loginUser = UserUtil.getLoginUser(request);
        if (loginUser != null) {
            //TODO 权限校验
            boolean res = true;
            if(res) {
                request.setAttribute(Constants.LOGIN_USER,loginUser);
                return true;
            }else{
                response.sendRedirect(Constants.CODEX_PREFIX + "/403");
                return false;
            }
        }
        response.sendRedirect(Constants.CODEX_PREFIX + "/login");
        return false;
    }

    /**
     * @param excludedUrls void
     * @brief
     */
    public void setExcludedUrls(List<String> excludedUrls) {
        this.excludedUrls = excludedUrls;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        if (modelAndView != null) {
            User loginUser = UserUtil.getLoginUser(request);
            modelAndView.addObject("loginUser", loginUser);
            modelAndView.addObject("BIPrefix", "/bi/");
        }
        super.postHandle(request, response, handler, modelAndView);
    }

}
