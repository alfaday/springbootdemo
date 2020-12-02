package com;

import com.dll.application.SpringbootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * 外部tomcat启动springboot的启动类
 */
public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        // 传入SpringBoot的主程序类
        return builder.sources(SpringbootApplication.class);
    }
}
