package org.spring.springboot.myaop;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;

@Slf4j
public class TimeCsAdvice implements Advice {

    @Override
    public void invoke(Object object, Method method, Object[] args) throws Exception {
        long stime = System.currentTimeMillis();
        Object ret = method.invoke(object, args);
        long useTime = System.currentTimeMillis() - stime;
        log.info("record: {}, {}. time used: {} ", method.getName(), method.getName(), useTime);
        System.out.println("record: " + object.getClass().getName() + "." + method.getName() + " time used" + useTime);
    }
}
