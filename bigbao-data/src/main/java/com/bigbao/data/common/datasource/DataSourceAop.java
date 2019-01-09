package com.bigbao.data.common.datasource;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(0)
@Component
public class DataSourceAop {


    @Before("execution(* com.bigbao.data.service.impl.*.*(..))")
    public void before(JoinPoint jp) {
        String methodName = jp.getSignature().getName();

        if (StringUtils.startsWithAny(methodName, "get", "select", "find","query")) {
            DBContextHolder.slave();
        }else {
            DBContextHolder.master();
        }
    }
}
