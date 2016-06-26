package com.mycompany.spring.cache.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mycompany.spring.cache.CustomerDao;

public class App {

    private static final Logger log = LoggerFactory.getLogger(App.class);

    public static void main(final String[] args) {

        /*
         * // with out proxy object
         * CustomerDaoImpl cusImpl = new CustomerDaoImpl();
         * log.debug("WithOut Proxy it will be called thrice");
         * log.debug("Result : {}", cusImpl.findByLastName("dummy"));
         * log.debug("Result : {}", cusImpl.findByLastName("dummy"));
         * log.debug("Result : {}", cusImpl.findByLastName("dummy"));
         */

        // Post construct

        // JdkDynamicAopProxy

        // self invoke some method in the same targer object

        // @Cacheble methods is not public

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        log.debug("Finding the customer bean : ");
        CustomerDao obj = (CustomerDao) context.getBean("customerDao");
        log.debug("Result : {}", obj.findByLastName("dummy"));
        log.debug("Result : {}", obj.findByLastName("dummy"));
        log.debug("Result : {}", obj.findByLastName("dummy"));

        // shut down the Spring context so that Ehcache got chance to shut down as well
        ((ConfigurableApplicationContext) context).close();
    }
}