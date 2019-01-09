package com.bigbao.data.common.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.Map;


@Configuration
public class DataSourceConfig {

    @Bean
    @ConfigurationProperties("spring.datasource.master")
    public DataSource masterDataSource(){
        return new DruidDataSource();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.slave1")
    public DataSource slave1DataSource(){
        return new DruidDataSource();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.slave2")
    public DataSource slave2DataSource(){
        return new DruidDataSource();
    }

    @Bean
    public DataSource dynamicDataSource(@Qualifier("masterDataSource") DataSource masterDataSource,
                                        @Qualifier("slave1DataSource") DataSource slave1DataSource,
                                        @Qualifier("slave2DataSource") DataSource slave2DataSource){
        Map<Object,Object> targetDataSource = Maps.newHashMap();
        targetDataSource.put(DBTypeEnum.MASTER,masterDataSource);
        targetDataSource.put(DBTypeEnum.SLAVE1,slave1DataSource);
        targetDataSource.put(DBTypeEnum.SLAVE2,slave2DataSource);
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        dynamicDataSource.setDefaultTargetDataSource(masterDataSource);
        dynamicDataSource.setTargetDataSources(targetDataSource);
        return dynamicDataSource;
    }
}
