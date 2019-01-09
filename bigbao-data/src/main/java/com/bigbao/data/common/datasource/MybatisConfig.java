package com.bigbao.data.common.datasource;

import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;

@EnableTransactionManagement
@Configuration
public class MybatisConfig extends MybatisAutoConfiguration {

    @Resource(name= "dynamicDataSource")
    private DataSource dynamicDataSource;

    public MybatisConfig(MybatisProperties properties, ObjectProvider<Interceptor[]> interceptorsProvider,
                                ResourceLoader resourceLoader, ObjectProvider<DatabaseIdProvider> databaseIdProvider,
                                ObjectProvider<List<ConfigurationCustomizer>> configurationCustomizersProvider) {
        super(properties, interceptorsProvider, resourceLoader, databaseIdProvider, configurationCustomizersProvider);
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        //SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        //sqlSessionFactoryBean.setDataSource(dynamicDataSource);
        //sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:com/bigbao/data/dao/mapper/*.xml"));
        //sqlSessionFactoryBean.setVfs(SpringBootVFS.class);
        //sqlSessionFactoryBean.setTypeAliasesPackage("com/bigbao/data/beans");
        //return sqlSessionFactoryBean.getObject();
        return super.sqlSessionFactory(dynamicDataSource);
    }

    @Bean
    public PlatformTransactionManager platformTransactionManager() {
        return new DataSourceTransactionManager(dynamicDataSource);
    }

    @Bean
    @Autowired
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    /*@Bean(name="dynamicSqlSessionTemplate")
    @Autowired
    public DynamicSqlSessionTemplate findDynamicSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate){
        DynamicSqlSessionTemplate temple = new DynamicSqlSessionTemplate(sqlSessionTemplate);
        return temple;
    }*/

}
