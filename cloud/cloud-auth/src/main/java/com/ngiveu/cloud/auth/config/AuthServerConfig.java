package com.ngiveu.cloud.auth.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author lengleng
 * @date 2017/10/28
 */
@Configuration
@ConfigurationProperties(prefix = "cloud.auth")
public class AuthServerConfig {
    private String clientId;
    private String clientSecret;
    private String scope;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
}
