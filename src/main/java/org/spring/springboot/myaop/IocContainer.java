package org.spring.springboot.myaop;

import freemarker.ext.beans.HashAdapter;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class IocContainer {

    private Map<String, Class<?>> beanDefinitionMap = new HashMap<>();

    //    用户的切面可能会有多个，此时添加一个
    private Aspect aspect;

    public Aspect getAspect() {
        return aspect;
    }

    public void setAspect(Aspect aspect) {
        this.aspect = aspect;
    }

    public void addBeanDefinition(String beanName, Class<?> beanClass) {
        this.beanDefinitionMap.put(beanName, beanClass);
    }

    public Object getBean(String beanName) throws InstantiationException, IllegalAccessException {
        Object bean = creatInstance(beanName);
        bean = proxyEnhance(bean);//让切面对其增强，对此对象外面包裹一层，外面要调用时候，对对象先包裹下。那么外界就会得到包裹的对象。使用代理增强
        return bean;
    }

    private Object proxyEnhance(Object bean) {

        if (bean.getClass().getName().matches(this.aspect.getPointCut().getClassPattern())) {
            return Proxy.newProxyInstance(bean.getClass().getClassLoader(), bean.getClass().getInterfaces(), new AopInvocationHandler(bean,aspect)); //invocationHandler 需要在单独写一个类
        }

        return bean;
    }

    private Object creatInstance(String beanName) throws IllegalAccessException, InstantiationException {
        return this.beanDefinitionMap.get(beanName).newInstance();
    }

}
