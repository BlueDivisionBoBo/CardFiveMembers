package com.youqiplay.service;

import com.youqiplay.entity.StaffUser;
import com.youqiplay.repository.StaffRepository;
import com.youqiplay.user.IStaffUserService;
import com.youqiplay.user.PPN;
import com.youqiplay.user.StaffUserShow;
import com.youqiplay.util.StaffUserShowEX;
import com.youqiplay.util.YYMD5;
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
}
