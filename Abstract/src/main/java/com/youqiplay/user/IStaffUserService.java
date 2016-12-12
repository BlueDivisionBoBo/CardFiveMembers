package com.youqiplay.user;

import org.springframework.data.domain.Page;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zhouyongbo on 2016/12/8.
 */
public interface IStaffUserService {
    StaffUserShow login(String name, String password, HttpServletRequest servletRequest,
                        String baiduMapKey, String baiduMapUrl, String loginDate,String verificationCode);


    PPN getPPn(String name);

    Page<StaffUserShow> getUsers(ConditionShow conditionShow);

    StaffUserShow getUser(Integer uid);

    StaffUserShow getUserName(String name);
}
