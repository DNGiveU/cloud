package com.ngiveu.cloud.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author gaz
 * @date 2017年10月27日13:59:05
 */
@EnableAsync
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.ngiveu.cloud.admin", "com.ngiveu.cloud.common.bean"})
public class CloudAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudAdminApplication.class, args);
    }
}