package com.bigbao.graph.proxy;

import org.junit.Test;

import java.lang.reflect.Proxy;

public class ProxyDemo {

    @Test
    public void testA(){
        Person p = new StudentProxy();
        p.say();
        System.out.println("****************");
        Person p2 = (Person) Proxy.newProxyInstance(Person.class.getClassLoader()
                , new Class[]{Person.class}
                ,new StudentProxy());
        p2.say();
    }
}
