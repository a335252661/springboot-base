package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/1/16
 */
@Controller
public class IndexController {

    //返回文本
    @RequestMapping("hello")
    @ResponseBody
    public String hello(ModelAndView mav, HttpServletRequest request){
        return "hello!!";
    }

    //返回页面
    @RequestMapping("")
    public String index(ModelAndView mav, HttpServletRequest request){
        return "views/index";
    }

}