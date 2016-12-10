package com.youqiplay.util;

import org.springframework.beans.factory.annotation.Value;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by zhouyongbo on 2016/12/10.
 */
public class YYMD5 {
    private final static String MD5 = "MD5";

    @Value("${com.youqiplay.MD5}")
    private Integer SUBMD5;


    public Integer getSUBMD5() {
        if (SUBMD5 == null || SUBMD5<0 || SUBMD5>32 ){
            SUBMD5 = 15;
        }
        return SUBMD5;
    }

    public void setSUBMD5(Integer SUBMD5) {
        this.SUBMD5 = SUBMD5;
    }

    /**
     * 采用加密算法加密字符串数据
     * @param str       需要加密的数据
     * @param algorithm 采用的加密算法
     * @return 字节数据
     */
    public static byte[] EncryptionStrBytes(String str, String algorithm) {
        // 加密之后所得字节数组
        byte[] bytes = null;
        try {
            // 获取MD5算法实例 得到一个md5的消息摘要
            MessageDigest md = MessageDigest.getInstance(algorithm);
            //添加要进行计算摘要的信息
            md.update(str.getBytes());
            //得到该摘要
            bytes = md.digest();
        } catch (NoSuchAlgorithmException e) {
            System.out.println("加密算法: " + algorithm + " 不存在: ");
        }
        return null == bytes ? null : bytes;
    }


    /**
     * 把字节数组转化成字符串返回
     *
     * @param bytes
     * @return
     */
    public static String BytesConvertToHexString(byte[] bytes) {
        StringBuffer sb = new StringBuffer();
        for (byte aByte : bytes) {
            String s = Integer.toHexString(0xff & aByte);
            if (s.length() == 1) {
                sb.append("0" + s);
            } else {
                sb.append(s);
            }
        }
        return sb.toString();
    }

    /**
     * 采用加密算法加密字符串数据
     * @param str 需要加密的数据
     * @return 字节数据
     */
    public static String EncryptionStr(String str) {
        // 加密之后所得字节数组
        byte[] bytes = EncryptionStrBytes(str, MD5);
        return BytesConvertToHexString(bytes);
    }


    public static String subStrMD5(String md5Str) {
        String s = EncryptionStr(md5Str);
        YYMD5 yymd5 = new YYMD5();
        Integer submd5 = yymd5.getSUBMD5();
        return s.substring(0, submd5);
    }


    public static String decodeMD5(String md5SStr){
        YYMD5 yymd5 = new YYMD5();
        String substring = md5SStr.substring(0, yymd5.getSUBMD5());
        int subIndex = 32 - substring.length();
        String s = substring + md5SStr.substring(md5SStr.length() - subIndex, md5SStr.length());
        System.out.println(s.length());
        return (s);
    }

}
