package com.example.demo.utils;

import java.util.UUID;

public class RandomUtil {
    public static final String productId(){
       // String sb = System.currentTimeMillis()/1000+"";
        String sb = getUUID32();
        return sb;
    }
    public static String getUUID32(){
        String uuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
        return uuid;
//  return UUID.randomUUID().toString().replace("-", "").toLowerCase();
    }


    public static void  main(String[] args) {
        //测试
        for(int i = 0;i<13;i++){

            System.out.println(productId());
        }
    }

}
