package com.youqiplay.repository;

import com.youqiplay.entity.LoginInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by zhouyongbo on 2016/12/12.
 */
@Repository
public interface LoginInfoRepository extends JpaRepository<LoginInfo, Integer> {
    @Query("select o from LoginInfo o where o.uid = ?1 and o.date = (select max(date) from LoginInfo t where t.uid = ?1 ) ")
    LoginInfo findTopLoginInfoByUidByAndDateDesc(int uid);
}
