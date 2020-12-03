package com.alfaday.test;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Test {

    private Map<String,String> map;

    private LoadingCache<String, String> cache;

    private String loadKey(String key){
        System.out.println("load key=" + key);
        if(map.containsKey(key)){
            return map.get(key);
        }
        return "0";
    }


    public void init(){
        System.out.println("init----");
        map = new HashMap<>();
        map.put("a","1");
        map.put("b","2");
        map.put("c","3");

        cache = CacheBuilder.newBuilder()
                // 最多缓存1000个用户业务权限
                .maximumSize(3)
                .expireAfterWrite(2, TimeUnit.SECONDS)
                // 移除缓存entry时的listener，暂时不需要
                //.removalListener(MY_LISTENER)
                .build(new CacheLoader<String, String>() {
                    @Override
                    public String load(String userName) {
                        return loadKey(userName);
                    }
                });
    }

    public static void main(String[] args) throws Exception{
        Test test = new Test();
        test.init();
        int i = 0;
        while (i < 3){
            i++;
            String a = test.cache.get("a");
            System.out.println("cache v=" + a);
            Thread.sleep(1000*3);


        }

    }

}
