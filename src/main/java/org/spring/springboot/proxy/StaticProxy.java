package org.spring.springboot.proxy;

import org.spring.springboot.service.KtvService;

public class StaticProxy implements KtvService {

    private KtvService target;

    public StaticProxy(KtvService target) {
        super();
        this.target = target;
    }

    @Override
    public void methodSing() {
        long sTime = System.currentTimeMillis();
        this.target.methodSing();
        long useTime = System.currentTimeMillis() - sTime;
        System.out.println("record: " + this.target.getClass() + ". time used" + useTime);
    }

    @Override
    public void methodDance() {

    }
}
