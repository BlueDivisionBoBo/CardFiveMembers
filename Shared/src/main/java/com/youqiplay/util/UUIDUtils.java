package com.youqiplay.util;

import java.util.Random;
import java.util.UUID;

/**
 * Created by zhouyongbo on 2016/12/11.
 */
public class UUIDUtils {

    public static String  UUIDSub(){
        return UUID.randomUUID().toString();
    }


    public static int PPN(int n){
        int lpowS= (int) Math.pow(10, n);
        int lpowE=  (int)Math.pow(10, n+1);
        Random random = new Random();
        return lpowS+random.nextInt(lpowE-lpowS);
    }


    public static void main(String[] args) {

        System.out.println();
    }
}
