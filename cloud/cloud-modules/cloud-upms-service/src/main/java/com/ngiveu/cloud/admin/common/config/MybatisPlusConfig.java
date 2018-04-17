package com.ngiveu.cloud.admin.common.config;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.plugins.PerformanceInterceptor;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author lengleng
 * @date 2017/10/29
 */
@Configuration
@MapperScan("com.ngiveu.cloud.admin.mapper")
public class MybatisPlusConfig {
    /**
     * 分页插件
     *
     * @return PaginationInterceptor
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
    
    /**
     * 性能插件
     * @return
     * @author gaz
     */
    @Bean
    @Profile(value = {"dev"})
    public PerformanceInterceptor performanceInterceptor() {
    	PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
    	performanceInterceptor.setFormat(true);
    	performanceInterceptor.setMaxTime(2000);
    	return performanceInterceptor;
    }

    /**
     * 数据权限插件
     *
     * @return DataScopeInterceptor
     */
//    @Bean
//    public DataScopeInterceptor dataScopeInterceptor() {
//        return new DataScopeInterceptor();
//    }
}