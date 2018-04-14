package com.ngiveu.cloud.tabe.common.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.plugins.PerformanceInterceptor;

/**
 * mybatis-plus配置 http://mp.baomidou.com/
 * @author gaz
 * @date 2018年4月5日
 */
@Configuration
@MapperScan(basePackages = "con.ngiveu.cloud.tabe.mapper")
public class MybatisPlusConfig {

	/**
	 * mybatis-plus 分页配置
	 * 如果需要使用缓存则使用CachePainationInterceptor
	 * @return
	 * @author gaz
	 */
	@Bean
	public PaginationInterceptor paginationInterceptor() {
		return new PaginationInterceptor();
	}
	
	/**
	 * 性能分析拦截器，用于输出每条 SQL 语句及其执行时间
	 * 开发环境使用
	 * @return
	 * @author gaz
	 */
	@Bean
	@Profile(value = {"dev"})
	public PerformanceInterceptor performanceInterceptor() {
		PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
		performanceInterceptor.setFormat(true);
		// SQL 执行最大时长，超过自动停止运行，有助于发现问题。
		performanceInterceptor.setMaxTime(100);
		return performanceInterceptor;
	}
}
