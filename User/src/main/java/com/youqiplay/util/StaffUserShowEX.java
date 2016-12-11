package com.youqiplay.util;

import com.youqiplay.entity.StaffUser;
import com.youqiplay.user.StaffUserShow;

/**
 * Created by zhouyongbo on 2016/12/7.
 */
public class StaffUserShowEX  extends StaffUserShow{

    public StaffUserShowEX(StaffUser staffUser) {
            this.setId(staffUser.getId());
            this.setName(staffUser.getName());
            this.setImage(staffUser.getImage());
            this.setPp(staffUser.getPp());
            this.setPhone(staffUser.getPhone());
            this.setAccount(staffUser.getAccount());
            this.setPassword(staffUser.getPassword());
            this.setLevel(staffUser.getLevel());
            this.setModifyDate(staffUser.getModifyDate());
            this.setModifyUser(staffUser.getModifyUser());
            this.setCreateUser(staffUser.getCreateUser());
            this.setCreateDate(staffUser.getCreateDate());
            this.setIsEnable(staffUser.getIsEnable());
    }


}
