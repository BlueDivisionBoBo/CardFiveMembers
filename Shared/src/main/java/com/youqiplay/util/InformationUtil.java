package com.youqiplay.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhouyongbo on 2016/12/12.
 */
public class InformationUtil {
    //发送请求
    public static String getURLRequest(String url, String method, Map<String,String> map, Map<String,String> mapherte){
        StringBuffer sbf = new StringBuffer();
        String resultName = null;
        String pm = "";
        try {
            for (Map.Entry<String, String> entry : map.entrySet()){
                pm = pm+entry.getKey()+"="+entry.getValue()+"&";
            }
            if (!"".equals(pm)){
                pm = pm.substring(0,pm.length()-1);
            }
            if ("GET".equals(method.toUpperCase())){
                url = url +"?"+pm;
            }
            URL rUrl = new URL(url);
            System.out.println(rUrl.toString());
            HttpURLConnection connection = (HttpURLConnection) rUrl.openConnection();
            connection.setRequestMethod(method.toUpperCase());
            for (Map.Entry<String, String> entry : mapherte.entrySet()){
                connection.setRequestProperty(entry.getKey(), entry.getValue());
            }
            if("POST".equals(method.toUpperCase())){
                connection.setDoOutput(true);
                connection.getOutputStream().write(pm.getBytes());
            }
            InputStream is = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                sbf.append(strRead);
                sbf.append("\r\n");
            }
            reader.close();
            resultName = sbf.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultName;
    }

    //将汉字转换unicode码
    public static String chinaToUnicode(String str){
        String result="";
        for (int i = 0; i < str.length(); i++){
            int chr1 = (char) str.charAt(i);
            if(chr1>=19968&&chr1<=171941){//汉字范围 \u4e00-\u9fa5 (中文)
                result+="\\u" + Integer.toHexString(chr1);
            }else{
                result+=str.charAt(i);
            }
        }
        return result;
    }
    //将unicode码转换汉字
    public static String convert(String utfString){
        StringBuilder sb = new StringBuilder();
        int i = -1;
        int pos = 0;
        while((i=utfString.indexOf("\\u", pos)) != -1){
            sb.append(utfString.substring(pos, i));
            if(i+5 < utfString.length()){
                pos = i+6;
                sb.append((char)Integer.parseInt(utfString.substring(i+2, i+6), 16));
            }
        }
        return sb.toString();
    }

    public static String infoUtil(HttpServletRequest request,String baiduMapKey,String baiduMapUrl){
        //地理位置信息
        String ip = "127.0.0.1";
        if (request.getHeader("x-forwarded-for") == null) {
            ip =  request.getRemoteAddr();
        }else {
            ip = request.getHeader("x-forwarded-for");
        }

        Map<String,String> map = new HashMap<String,String>();
        map.put("ak",baiduMapKey);
       // map.put("ip", ip);
        map.put("coor","bd09ll");
        String get = InformationUtil.getURLRequest(baiduMapUrl, "GET", map, new HashMap<String, String>());
        if (get==null)  return null;
        JSONObject jsonObject = JSON.parseObject(get);
        if (jsonObject!=null){
            String address = null ;
            JSONObject content = (JSONObject) jsonObject.get("content");
            if (content!=null){
                Object obj = content.get("address");
                address = obj.toString();
            }
            return address;
        }
        return null;
    }
}
