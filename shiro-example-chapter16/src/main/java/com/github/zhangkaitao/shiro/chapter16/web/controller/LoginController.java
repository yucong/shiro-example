package com.github.zhangkaitao.shiro.chapter16.web.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-2-15
 * <p>Version: 1.0
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/login"    )
    public String showLoginForm(HttpServletRequest req, Model model) {
        
    	/*String error = null;
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        token.setRememberMe(true);
        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
        	e.printStackTrace();
            error = "用户名/密码错误";
        } catch (IncorrectCredentialsException e) {
        	e.printStackTrace();
            error = "用户名/密码错误";
        } catch (AuthenticationException e) {
        	e.printStackTrace();
            //其他错误，比如锁定，如果想单独处理请单独catch处理
            error = "其他错误：" + e.getMessage();
        }*/
    	
    	
    	
    	String exceptionClassName = (String)req.getAttribute("shiroLoginFailure");
    	String error = null;
        if(UnknownAccountException.class.getName().equals(exceptionClassName)) {
            error = "用户名/密码错误";
        } else if(IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
            error = "用户名/密码错误";
        } else if(exceptionClassName != null) {
            error = "其他错误：" + exceptionClassName;
        }
        
        
        model.addAttribute("error", error);
        if(error != null) {
        	System.out.println("登录出错,error:" + error);
        } 
        return "login";
    }


}
