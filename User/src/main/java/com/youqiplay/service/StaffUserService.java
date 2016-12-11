package com.youqiplay.service;

import com.youqiplay.entity.StaffUser;
import com.youqiplay.repository.StaffRepository;
import com.youqiplay.user.ConditionShow;
import com.youqiplay.user.IStaffUserService;
import com.youqiplay.user.PPN;
import com.youqiplay.user.StaffUserShow;
import com.youqiplay.util.StaffUserShowEX;
import com.youqiplay.util.YYMD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhouyongbo on 2016/12/9.
 */
@Service
public class StaffUserService implements IStaffUserService{

    @Autowired
    private StaffRepository staffRepository;

    @Override
    public StaffUserShow login(String name, String password) {
        String passwordS = YYMD5.decodeMD5(password);
//        String pPn = staffRepository.getPPn(name);
//        String passwordSs = YYMD5.EncryptionStr(passwordS + pPn);
        StaffUser login = staffRepository.login(name, passwordS);
        if (login == null )return null;
        return new StaffUserShowEX(login);
    }

    @Override
    public PPN getPPn(String name) {
        String pPn = staffRepository.getPPn(name);
        if (pPn == null ){
            return null ;
        }
        String s = null;
        try{
           s = YYMD5.subStrMD5(pPn);
        }catch (Exception e){
            e.printStackTrace();
        }
        if (s == null ){
            return null ;
        }
        YYMD5 yymd5 = new YYMD5();
        PPN ppn = new PPN();
        ppn.setPpn(s);
        ppn.setPpnSub(yymd5.getSUBMD5());
        return ppn;
    }

    @Override
    public Page<StaffUserShow> getUsers(ConditionShow conditionShow) {
        Integer currentPage = conditionShow.getCurrentPage();
        Integer pageSize = conditionShow.getPageSize();
        currentPage = conditionShow.getCurrentPage() == null ? 1 : currentPage;
        currentPage = currentPage <= 0 ? 1 : currentPage;
        pageSize = pageSize == null ? 10 : pageSize;
        pageSize = pageSize <= 0 ? 10 : pageSize;
        Pageable p = new PageRequest(currentPage - 1, pageSize);

        Page<StaffUser> users = staffRepository.getUsers(conditionShow.getName(), conditionShow.getPhone(), p);
        List<StaffUser> content = users.getContent();
        List<StaffUserShow> staffUserShows = new ArrayList<StaffUserShow>();
        for (StaffUser staffUser:content){
            staffUserShows.add(new StaffUserShowEX(staffUser));
        }
        return new PageImpl<StaffUserShow>(staffUserShows,p,users.getTotalElements());
    }

    @Override
    public StaffUserShow getUser(Integer uid) {
        StaffUser user = staffRepository.getUser(uid);
        if (user == null){
            return null;
        }
        return new StaffUserShowEX(user);
    }
}
