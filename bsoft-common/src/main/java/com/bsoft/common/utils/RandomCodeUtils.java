package com.bsoft.common.utils;

public class RandomCodeUtils {
    public static int getRandomCode(){
        return (int)((Math.random()*9+1)*100000);
    }
}
