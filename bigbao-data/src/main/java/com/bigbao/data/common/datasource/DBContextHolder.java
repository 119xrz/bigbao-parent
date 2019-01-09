package com.bigbao.data.common.datasource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicInteger;

public class DBContextHolder {

    private final static Logger log = LoggerFactory.getLogger(DBContextHolder.class);

    private final static ThreadLocal<DBTypeEnum> contextHolder = new ThreadLocal<>();

    private final static AtomicInteger counter = new AtomicInteger(-1);

    public static void set(DBTypeEnum dbType){
        contextHolder.set(dbType);
    }

    public static DBTypeEnum get(){
        return contextHolder.get();
    }

    public static void master(){
        set(DBTypeEnum.MASTER);
        log.info("数据库切换为master");
    }

    public static void slave(){
        int index = counter.incrementAndGet()%2;
        if(counter.get() > 9999){
            counter.set(-1);
        }
        if(index == 0){
            set(DBTypeEnum.SLAVE1);
        }else{
            set(DBTypeEnum.SLAVE2);
        }
        log.info("数据库切换为slave");
    }

    public static void clear() {
        contextHolder.remove();
    }
}
