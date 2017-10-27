package com.caiwei.framework.common.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author longhairen
 * @create 2017/10/27 0027 下午 5:20
 */
@Component
public class SpringContextHolder implements ApplicationContextAware {

        private static ApplicationContext applicationContext = null;

        @Override
        public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
            if(SpringContextHolder.applicationContext == null){
                SpringContextHolder.applicationContext  = applicationContext;
            }
        }

        //获取applicationContext
        public static ApplicationContext getApplicationContext() {
            return applicationContext;
        }

        //通过name获取 Bean.
        public static Object getBean(String name){
            return getApplicationContext().getBean(name);
        }

        //通过class获取Bean.
        public static <T> T getBean(Class<T> clazz){
            return getApplicationContext().getBean(clazz);
        }

        //通过name,以及Clazz返回指定的Bean
        public static <T> T getBean(String name,Class<T> clazz){
            return getApplicationContext().getBean(name, clazz);
        }
}
