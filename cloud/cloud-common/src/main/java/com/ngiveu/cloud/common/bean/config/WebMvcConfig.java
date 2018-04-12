package com.ngiveu.cloud.common.bean.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.ngiveu.cloud.common.bean.resolver.TokenArgumentResolver;

import java.util.List;

/**
 * @author lengleng
 * @date 2017/12/21
 * mvc配置
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new TokenArgumentResolver());
    }
}
