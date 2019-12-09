package org.spring.springboot.myaop;

import java.lang.reflect.Method;

public interface Advice {

    //
    void invoke(Object object, Method method, Object[] args) throws Exception;
}
