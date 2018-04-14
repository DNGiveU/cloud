package com.ngiveu.cloud.tabe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * tabe 入口文件
 * 
 * @author gaz
 * @date 2018-04-05
 */
@ComponentScan(basePackages = {"com.ngiveu.cloud.common.bean", "com.ngiveu.cloud.tabe"})
@EnableDiscoveryClient
@SpringBootApplication
public class CloudTabeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudTabeApplication.class, args);
	}
}
