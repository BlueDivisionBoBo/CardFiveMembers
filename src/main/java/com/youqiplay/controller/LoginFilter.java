package com.youqiplay.controller;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by Administrator on 2016/12/8.
 */
@Component("myFilter")
public class LoginFilter implements Filter {
    FilterConfig config;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.config = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
//        UUID uuid = new UUID(10,5);
//        long mostSignificantBits = uuid.getMostSignificantBits();
        //UUID uuid = UUID.randomUUID();
       // System.out.println(uuid);
        HttpServletRequest rq = (HttpServletRequest) request;
        HttpServletResponse rp = (HttpServletResponse) response;
        String servletPath = rq.getServletPath();
        if (servletPath.endsWith("do")){
            Cookie[] cookies = rq.getCookies();
            if (cookies !=null){
                String mycookVlue = null;
                for (Cookie cookie : cookies){
                    if ("youqitoken".equalsIgnoreCase(cookie.getName())) {
                        mycookVlue = cookie.getValue();
                    }
                }
                HttpSession session = rq.getSession();
                Object attribute = session.getAttribute(mycookVlue);
                if (attribute == null ){
                    Cookie cookie = new Cookie("youqitoken", null);
                    cookie.setMaxAge(0);
                    rp.addCookie(cookie);
                    rp.sendRedirect("/");
                    return;
                }
            }else {
                rp.sendRedirect("/");
                return;
            }

        }
//        doFilter(request,response,chain);
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }

//    public static void main(String[] args) {
//        UUID uuid = UUID.randomUUID();
//        System.out.println(uuid);
//    }
}
