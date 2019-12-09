package org.spring.springboot.myaop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class AopInvocationHandler implements InvocationHandler {

    private Object target;
    private Aspect aspect;

    public AopInvocationHandler(Object target, Aspect aspect) {
        super();
        this.target = target;
        this.aspect = aspect;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //判断当前方法是否需要增强
        if (method.getName().matches(this.aspect.getPointCut().getMethodPattern())) {
            this.aspect.getAdvice().invoke(target, method, args);
        }

        //不需要增强
        return method.invoke(target,args);
    }
}
