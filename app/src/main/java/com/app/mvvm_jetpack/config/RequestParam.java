package com.app.mvvm_jetpack.config;

import com.app.network.OpenNetwork;

import java.util.HashMap;

/**
 * @author:create by ys
 * 时间:2021/7/9 17
 * 邮箱 894417048@qq.com
 */
public class RequestParam {

    public static String keySign = "cca907773de845a491a3b1163ec7794a";
    public static String showApidID = "699962";

    private HashMap<String,Object> map = new HashMap<>();

    private static RequestParam params;

    public static RequestParam getInstance() {
        if (params == null){
            synchronized (RequestParam.class){
                if (params == null){
                    params = new RequestParam();
                    params.map.put("showapi_appid",showApidID);
                    params.map.put("showapi_sign",keySign);
                }
            }
        }
        return params;
    }

    public void setMap(String key,Object o){
        map.put(key,o);
    }

    public HashMap<String, Object> getMap() {
        return map;
    }
}