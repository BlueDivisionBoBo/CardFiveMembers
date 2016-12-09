package com.youqiplay.repository;

import com.youqiplay.entity.StaffUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by zhouyongbo on 2016/12/9.
 */
public interface StaffRepository extends JpaRepository<StaffUser, Integer> {


    @Query("select o from StaffUser o where (o.account = ?1 or o.phone = ?1 ) and o.password = ?2 ")
    StaffUser login(String name, String password);
}
