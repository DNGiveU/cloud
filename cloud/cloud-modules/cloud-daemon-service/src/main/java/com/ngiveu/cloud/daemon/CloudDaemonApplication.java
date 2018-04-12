package com.ngiveu.cloud.daemon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author gaz
 * @date 2018年02月07日20:35:35
 * 分布式任务调度模块
 */
@EnableDiscoveryClient
@SpringBootApplication
public class CloudDaemonApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudDaemonApplication.class, args);
    }

}
