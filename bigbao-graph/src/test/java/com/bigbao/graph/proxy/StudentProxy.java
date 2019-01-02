package com.bigbao.graph.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class StudentProxy implements Person,InvocationHandler {

    private Student student = new Student();

    @Override
    public void say() {
        System.out.println("哈哈");
        student.say();
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("嘿嘿");
        System.out.println(proxy.getClass());
        return method.invoke(student,args);
    }
}
