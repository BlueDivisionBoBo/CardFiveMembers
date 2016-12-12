package com.youqiplay.repository;

import com.youqiplay.entity.StaffUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by zhouyongbo on 2016/12/9.
 */
public interface StaffRepository extends JpaRepository<StaffUser, Integer> {


    @Query("select o from StaffUser o where (o.account = ?1 or o.phone = ?1 ) and o.password = MD5(concat(?2,o.pp)) ")
    StaffUser login(String name, String password);

    @Query("select o.pp from StaffUser o where o.account = ?1 or o.phone = ?1 ")
    String getPPn(String name);

    @Query("select o from StaffUser o where (?1 is null or o.name like concat('%',?1,'%') ) " +
            " and (?2 is null or o.phone like concat('%',?2,'%') )" +
            " and o.level = 2")
    Page<StaffUser> getUsers(String name, String phone, Pageable p);

    @Query(" select o from StaffUser o where o.id = ?1")
    StaffUser getUser(Integer uid);

    @Query(" select o from StaffUser o where o.account = ?1 or o.phone = ?1")
    StaffUser getUserName(String name);
}
