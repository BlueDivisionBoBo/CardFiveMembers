package com.youqiplay.user.controller;

import com.youqiplay.Constant;
import com.youqiplay.shared.ObjectResult;
import com.youqiplay.user.ConditionShow;
import com.youqiplay.user.IStaffUserService;
import com.youqiplay.user.PPN;
import com.youqiplay.user.StaffUserShow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.UUID;

/**
 * Created by zhouyongbo on 2016/12/7.
 */
@RestController
@RequestMapping("/api")
public class UserController {


    @Autowired
    IStaffUserService iStaffUserService;

    @Value("${youqiplay.cookie}")
    private String cookieName;

    /**
     * 登录
     * @param name
     * @param password
     * @param date
     * @param servletRequest
     * @param servletResponse
     * @return
     */
    @RequestMapping(value = "/user/login",method = RequestMethod.GET)
    public ObjectResult login(@RequestParam(value = "name") String name,
                              @RequestParam(value = "password") String password,
                              @RequestParam(value = "date") String date,
                          //    @CookieValue(value = "uid",required = false) CookieValue cookieValue,
                              HttpServletRequest servletRequest,
                              HttpServletResponse servletResponse){
        StaffUserShow login = iStaffUserService.login(name, password);
        if (login!=null){
            int seconds = 60*60*24;
            HttpSession session = servletRequest.getSession();
            String uuid = UUID.randomUUID().toString();
           // String uuid = "aaa";
            session.setAttribute(uuid,login);
            session.setMaxInactiveInterval(seconds);
            Cookie cookie = new Cookie("youqitoken",uuid);
             //1天的秒数
            cookie.setMaxAge(seconds);  //cookie默认保存1天
            cookie.setPath("/"); //设置路径，这个路径即该工程下都可以访问该cookie  // 如果不设置路径，那么只有设置该cookie路径及其子路径可以访问
            servletResponse.addCookie(cookie);
            return new ObjectResult("true","登录成功");
        }else {
            return new ObjectResult("false","帐号或者密码不正确");
        }

    }

    /**
     * 请求保护
     * @param name
     * @return
     */
    @RequestMapping(value = "/ppn",method = RequestMethod.GET)
    public ObjectResult getPPn(@RequestParam("name") String name){
        PPN ppn = iStaffUserService.getPPn(name);
        if (ppn == null ){
            return new ObjectResult("fasle","帐号或者密码错误,请重新输入");
        }
        return new ObjectResult("true",ppn);
    }


    /**
     * 请求用户列表
     * @return
     */
    @RequestMapping(value = "/users.do",method = RequestMethod.GET)
    public ObjectResult getUsers( @RequestParam(value = "currentPage", required = false) Integer currentPage,
                                  @RequestParam(value = "pageSize", required = false) Integer pageSize,
                                  @RequestParam(value = "name", required = false) String name,
                                  @RequestParam(value = "phone", required = false) String phone,
                                  @CookieValue(value = "youqitoken",required = false) CookieValue cookieValue){
        ConditionShow conditionShow = new ConditionShow();
        conditionShow.setCurrentPage(currentPage);
        conditionShow.setPageSize(pageSize);
        conditionShow.setName(name);
        conditionShow.setPhone(phone);
        Page<StaffUserShow> staffUserShow = iStaffUserService.getUsers(conditionShow);
        return new ObjectResult("true",staffUserShow);
    }


//    /**
//     * 用户详情
//     * @param uid
//     * @param cookieValue
//     * @return
//     */
//    @RequestMapping(value = "/${uid}/user.do",method = RequestMethod.GET)
//    public ObjectResult getUser(@PathVariable("uid")Integer uid,
//                                @CookieValue(value = "youqitoken",required = false) CookieValue cookieValue){
//        StaffUserShow staffUserShow = iStaffUserService.getUser(uid);
//        if (staffUserShow == null ){
//            return new ObjectResult("fasle","没有该用户信息");
//        }else {
//            return new ObjectResult("true",staffUserShow);
//        }
//    }


//    /**
//     * 添加用户
//     * @param staffUserShow
//     * @param cookieValue
//     * @return
//     */
//    @RequestMapping(value = "/user",method = RequestMethod.POST)
//    public ObjectResult addUser(@RequestBody StaffUserShow staffUserShow,
//                                @CookieValue(value = "youqitoken",required = false) CookieValue cookieValue){
//        return null;
//    }
//
//
//    /**
//     * 修改用户
//     * @param staffUserShow
//     * @param cookieValue
//     * @return
//     */
//    @RequestMapping(value = "/user",method = RequestMethod.PUT)
//    public ObjectResult updateUser(@RequestBody StaffUserShow staffUserShow,
//                                   @CookieValue(value = "youqitoken",required = false) CookieValue cookieValue){
//        return null;
//    }

}
