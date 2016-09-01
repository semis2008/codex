package com.codex.web;


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

    @RequestMapping(value = "/regist")
    private ModelAndView regist() throws Exception {
        return new ModelAndView("regist");

    }

    @RequestMapping(value = "/comming")
    private ModelAndView comming() throws Exception {
        return new ModelAndView("comming");

    }
    @RequestMapping(value = "/alipay")
    private ModelAndView alipay() throws Exception {
        return new ModelAndView("alipay/index");

    }
}