package org.spring.springboot.myaopdemo;

import org.spring.springboot.myaop.*;
import org.spring.springboot.service.KtvService;
import org.spring.springboot.service.impl.KtvServiceImpl;

import java.lang.reflect.Method;

public class MyAOPMain {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {

        //使用者提供的增强切入点
        Advice advice = new TimeCsAdvice();
        PointCut pointCut = new PointCut("org\\.spring\\.springboot\\.service\\.impl\\..*", "method.*");
        //methodA,methodB, methodC => method.*
        Aspect aspect = new Aspect();
        aspect.setAdvice(advice);
        aspect.setPointCut(pointCut);
        //此时用户需要做的已经完成，接下来需要框架
//        KtvService ktvService = new KtvServiceImpl();
//        ktvService.methodDance();//这样跑没有AOP效果

        //使用AOP。必须使用IOC
        //手写简化的IOC

        IocContainer iocContainer = new IocContainer();
        iocContainer.addBeanDefinition("ktv", KtvServiceImpl.class);
        iocContainer.setAspect(aspect);

        KtvService ktvService = (KtvService) iocContainer.getBean("ktv");
        ktvService.methodDance();
        //此时还是不行



    }
}
