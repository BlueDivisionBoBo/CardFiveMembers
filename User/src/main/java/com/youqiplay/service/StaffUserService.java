package com.youqiplay.service;

import com.youqiplay.entity.LoginInfo;
import com.youqiplay.entity.StaffUser;
import com.youqiplay.repository.LoginInfoRepository;
import com.youqiplay.repository.StaffRepository;
import com.youqiplay.user.ConditionShow;
import com.youqiplay.user.IStaffUserService;
import com.youqiplay.user.PPN;
import com.youqiplay.user.StaffUserShow;
import com.youqiplay.util.BeanShift;
import com.youqiplay.util.InformationUtil;
import com.youqiplay.util.StaffUserShowEX;
import com.youqiplay.util.YYMD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by zhouyongbo on 2016/12/9.
 */
@Service
public class StaffUserService implements IStaffUserService{

    @Autowired
    private StaffRepository staffRepository;


    @Autowired
    private LoginInfoRepository loginInfoRepository;

    @Override
    public StaffUserShow login(String name, String password, HttpServletRequest request, String baiduMapKey,
                               String baiduMapUrl, String loginDate,String verificationCode) {
        String passwordS = YYMD5.decodeMD5(password);
//        String pPn = staffRepository.getPPn(name);
//        String passwordSs = YYMD5.EncryptionStr(passwordS + pPn);
        StaffUser login = staffRepository.login(name, passwordS);
        if (login == null )return null;
        StaffUserShow staffUserShow = new StaffUserShow();
        BeanShift.beanTransform(login,staffUserShow);
        if( staffUserShow.getImage() == null ){
            staffUserShow.setImage("images/banner.jpg");
        }
        Object attribute = request.getSession().getAttribute(login.getName() + login.getPhone());
//        if (attribute == null && attribute == verificationCode){ //无验证;
//            verificationCode = "false";//需要校验 是否需要验证码
//        }else if (attribute == null && verificationCode)
        //登录成功之前的校验
        String  address = InformationUtil.infoUtil(request, baiduMapKey, baiduMapUrl);

        if (!"true".equals(verificationCode)){ // 无验证码 或者验证通过
            LoginInfo loginInfo  = loginInfoRepository.findTopLoginInfoByUidByAndDateDesc(login.getId());
            if (loginInfo == null ){//不用发送验证码
                staffUserShow.setVerificationCode("true");
            }else {//做时间与地点的校验
                if (loginDate == null )loginDate = "0";
                long l = new Date().getTime() - loginInfo.getDate().getTime();
                int i = Integer.valueOf(loginDate) * 3600 * 24 * 1000;
                if(l> i){//超过时间限制 手机验证
                    staffUserShow.setVerificationCode("false");
                    return staffUserShow;
                }
                if (address !=null && !address.equals(loginInfo.getAddress())){
                    staffUserShow.setVerificationCode("false");
                    return staffUserShow;
                }
            }
        }

        //登录成功之后
        if (address != null) {
            LoginInfo loginInfoSucess = new LoginInfo(0,login.getId(),new Date(),address,1);//来源暂时默认为1
            loginInfoRepository.save(loginInfoSucess);
        }
        return staffUserShow;
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
        StaffUserShow staffUserShow = new StaffUserShow();
        BeanShift.beanTransform(user,staffUserShow);
        if( staffUserShow.getImage() == null ){
            staffUserShow.setImage("images/banner.jpg");
        }
        return staffUserShow;
    }

    @Override
    public StaffUserShow getUserName(String name) {
        StaffUser userName = staffRepository.getUserName(name);
        if (userName == null ){
            return null;
        }else {
            StaffUserShow staffUserShow = new StaffUserShow();
            BeanShift.beanTransform(userName,staffUserShow);
            return staffUserShow;
        }
    }
}
