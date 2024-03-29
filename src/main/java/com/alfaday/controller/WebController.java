package com.alfaday.controller;

import com.alfaday.aop.LogAnnotation;
import com.alfaday.service.UserService;
import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigService;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Controller
public class WebController {

    private static final Logger logger = LoggerFactory.getLogger(WebController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    private Map<String,String> map;

    //guava缓存类
    private LoadingCache<String, String> cache = CacheBuilder.newBuilder()
            // 最多缓存1000个用户业务权限
            .maximumSize(3)
            .expireAfterWrite(10, TimeUnit.SECONDS)
            // 移除缓存entry时的listener，暂时不需要
            //.removalListener(MY_LISTENER)
            .build(new CacheLoader<String, String>() {
                @Override
                public String load(String userName) {
                    return loadKey(userName);
                }
            });

    @ResponseBody
    @RequestMapping("/view")
    public String getView(){
        logger.info("req1 in!");
        return "{\"name\":\"网站\", \"num\":3, \"sites\": [{ \"name\":\"Google\", \"info\":[ \"Android\", \"Google 搜索\", \"Google 翻译\" ] },{ \"name\":\"Runoob\", \"info\":[ \"菜鸟教程\", \"菜鸟工具\", \"菜鸟微信\" ] }, { \"name\":\"Taobao\", \"info\":[ \"淘宝\", \"网购\" ] } ]}";
    }

    @RequestMapping("/view2")
    public String getView2(){
        return "index2.html";
    }

    @LogAnnotation
    @ResponseBody
    @RequestMapping(value = "/view3",method = RequestMethod.GET)
    public String getView3(String name) throws Exception{
        logger.debug("debug req in");
        logger.info("req3 in!");
        userService.getUser(1L);
        cache.get(name);
        return "response=" + name;
    }

    @PostConstruct
    public void init(){
        System.out.println("init----");
        map = new HashMap<>();
        map.put("a","1");
        map.put("b","2");
        map.put("c","3");
        logger.info("WebController init");
    }

    @ResponseBody
    @RequestMapping(value = "/redis")
    public String setGet(){
        ValueOperations<String, Object> ops = redisTemplate.opsForValue();
        Boolean aBoolean = ops.setIfAbsent("test-info", "test-value");
        return "ret=" + aBoolean;
    }


    private String loadKey(String key){
        logger.info("load key=" + key);
        if(map.containsKey(key)){
            return map.get(key);
        }
        return "0";
    }

    @ApolloConfigChangeListener("application")
    private void anotherOnChange(ConfigChangeEvent changeEvent) {
        logger.info( "Namespace=" +changeEvent.getNamespace());
        for(String key : changeEvent.changedKeys()){
            logger.info("key={},old value={},new value={}",
                    key,
                    changeEvent.getChange(key).getOldValue(),
                    changeEvent.getChange(key).getNewValue());
        }
    }


    public void configTest(){
        Config config = ConfigService.getConfig("application");
        String key = "timeout";
        String someDefaultValue = "";
        String value = config.getProperty(key, someDefaultValue);

    }


}
