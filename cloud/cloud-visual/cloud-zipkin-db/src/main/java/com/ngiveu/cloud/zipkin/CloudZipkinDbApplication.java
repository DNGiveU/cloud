package com.ngiveu.cloud.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import zipkin.server.EnableZipkinServer;

/**
 * @author gaz
 * @date 2018-01-24
 * zipkin mysql 存储实现
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableZipkinServer
public class CloudZipkinDbApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudZipkinDbApplication.class, args);
    }
}
