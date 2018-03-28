package com.liquibase_demo.config.liquibase;


import liquibase.exception.LiquibaseException;
import liquibase.integration.spring.SpringLiquibase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;


public class AsyncSpringLiquibase extends SpringLiquibase {

    private final Logger log = LoggerFactory.getLogger(AsyncSpringLiquibase.class);

     /**
       * @Author: enHui.Chen
       * @Description: 在处理master文件之前的方法
       * @Data 2018/3/22 0022
       */
    @Override
    public void afterPropertiesSet() throws LiquibaseException {
        log.info("Starting Liquibase synchronously");
        initDb();
    }

    protected void initDb() throws LiquibaseException {
        StopWatch watch = new StopWatch();
        watch.start();
        super.afterPropertiesSet();
        watch.stop();
        log.info("Started Liquibase in {} ms", watch.getTotalTimeMillis());
    }
}
