package com.ngiveu.cloud.mc.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * @author lengleng
 * @date 2018/1/16
 * 阿里大鱼短息服务配置
 */
@Configuration
@ConditionalOnExpression("!'${sms.aliyun}'.isEmpty()")
@ConfigurationProperties(prefix = "sms.aliyun")
public class SmsAliyunPropertiesConfig {
    /**
     * 应用ID
     */
    private String accessKey;

    /**
     * 应用秘钥
     */
    private String secretKey;

    /**
     * 短信模板配置
     */
    private Map<String, String> channels;

	public String getAccessKey() {
		return accessKey;
	}

	public void setAccessKey(String accessKey) {
		this.accessKey = accessKey;
	}

	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	public Map<String, String> getChannels() {
		return channels;
	}

	public void setChannels(Map<String, String> channels) {
		this.channels = channels;
	}
}
