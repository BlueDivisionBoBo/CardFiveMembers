package com.youqiplay.service;

import com.youqiplay.entity.StaffUser;
import com.youqiplay.repository.StaffRepository;
import com.youqiplay.user.IStaffUserService;
import com.youqiplay.user.StaffUserShow;
import com.youqiplay.util.StaffUserShowEX;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhouyongbo on 2016/12/9.
 */
@Service
public class StaffUserService implements IStaffUserService{

    @Autowired
    private StaffRepository staffRepository;

    @Override
    public StaffUserShow login(String name, String password) {
        StaffUser login = staffRepository.login(name, password);
        if (login == null )return null;
        return new StaffUserShowEX(login);
    }
}
