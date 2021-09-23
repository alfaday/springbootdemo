package com.alfaday.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("contextInitialized done -----------------------------");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
