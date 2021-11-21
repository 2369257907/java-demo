package com.guo.controller;

import com.sun.deploy.net.HttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello(Model model, HttpServletRequest request){
        Cookie[] cookies =  request.getCookies();
        String name = "";
        if(cookies != null){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("myusername")){
                    name = cookie.getValue();
                }
            }
        }
        model.addAttribute("name",name);
        return "hello";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/index")
    public String index(Model model, @RequestParam("name") String name, HttpServletResponse response){
        Cookie cookie = new Cookie("myusername",name);
        System.out.println(name);
        response.addCookie(cookie);
        model.addAttribute("name",name);

        return "hello";
    }


}
