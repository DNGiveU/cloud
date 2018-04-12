package com.ngiveu.cloud.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import zipkin.server.EnableZipkinServer;

/**
 * @author gaz
 * @date 2017-12-29 13:02:29
 * zipkin 链路追踪
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableZipkinServer
public class CloudZipkinElkApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudZipkinElkApplication.class, args);
    }
}
