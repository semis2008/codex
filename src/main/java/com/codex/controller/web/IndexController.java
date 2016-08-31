package com.codex.controller.web;


import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class IndexController {

    /**
     * 登陆页面
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/login")
    private ModelAndView login() throws Exception {
        return new ModelAndView("login");

    }

    @RequestMapping(value = "/love")
    private ModelAndView love() throws Exception {
        return new ModelAndView("ourlove");

    }

}