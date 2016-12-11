package com.youqiplay.user;

import org.springframework.data.domain.Page;

/**
 * Created by zhouyongbo on 2016/12/8.
 */
public interface IStaffUserService {
    StaffUserShow login(String name,String password);


    PPN getPPn(String name);

    Page<StaffUserShow> getUsers(ConditionShow conditionShow);

    StaffUserShow getUser(Integer uid);
}
