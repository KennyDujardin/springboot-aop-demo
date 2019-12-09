package org.spring.springboot.proxy;

import org.spring.springboot.service.KtvService;
import org.spring.springboot.service.impl.KtvServiceImpl;

import javax.security.auth.kerberos.KerberosTicket;

public class ProxyMain {

    public static void main(String[] args) {

        KtvService pb = new KtvServiceImpl();
        KtvService proxy = new StaticProxy(pb);

        proxy.methodSing();
        System.out.println("------------------------");





    }

}
