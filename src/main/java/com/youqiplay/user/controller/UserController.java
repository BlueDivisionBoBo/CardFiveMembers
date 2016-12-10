package com.youqiplay.user.controller;

import com.youqiplay.shared.ObjectResult;
import com.youqiplay.user.IStaffUserService;
import com.youqiplay.user.PPN;
import com.youqiplay.user.StaffUserShow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * Created by zhouyongbo on 2016/12/7.
 */
@RestController
@RequestMapping("/api")
public class UserController {


    @Autowired
    IStaffUserService iStaffUserService;




    @RequestMapping(value = "/user/login",method = RequestMethod.GET)
    public ObjectResult login(@RequestParam(value = "name") String name,
                              @RequestParam(value = "password") String password,
                              @RequestParam(value = "date") String date,
                          //    @CookieValue(value = "uid",required = false) CookieValue cookieValue,
                              HttpServletRequest servletRequest,
                              HttpServletResponse servletResponse){

        //验证通过 将
//        session.setAttribute("");//设置
//        servletRequest.setAttribute();

     //   servletRequest.setAttribute();
      //  Cookie cookie = new Cookie("token", token);
//        if (cookieValue!=null){
//            String value = cookieValue.value();
//            Object attribute = servletRequest.getSession().getAttribute(value);
//            if(attribute!=null){
//                return new ObjectResult("true","登录成功");
//            }else {
//                return new ObjectResult("false","请重新登录");
//            }
//        }
        StaffUserShow login = iStaffUserService.login(name, password);
        if (login!=null){
            int seconds = 60*60*24;
            HttpSession session = servletRequest.getSession();
            String uuid = UUID.randomUUID().toString();
           // String uuid = "aaa";
            session.setAttribute(uuid,login);
            session.setMaxInactiveInterval(seconds);
            Cookie cookie = new Cookie("uid",uuid);
             //1天的秒数
            cookie.setMaxAge(seconds);  //cookie默认保存1天
            cookie.setPath("/"); //设置路径，这个路径即该工程下都可以访问该cookie  // 如果不设置路径，那么只有设置该cookie路径及其子路径可以访问
            servletResponse.addCookie(cookie);
            return new ObjectResult("true","登录成功");
        }else {
            return new ObjectResult("false","帐号或者密码不正确");
        }

    }

    @RequestMapping(value = "/ppn",method = RequestMethod.GET)
    public ObjectResult getPPn(@RequestParam("name") String name){
        PPN ppn = iStaffUserService.getPPn(name);
        if (ppn == null ){
            return new ObjectResult("fasle","帐号或者密码错误,请重新输入");
        }
        return new ObjectResult("true",ppn);
    }
}
