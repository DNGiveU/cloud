package com.ngiveu.cloud.gateway.feign;

import com.ngiveu.cloud.common.vo.UserVO;
import com.ngiveu.cloud.gateway.feign.fallback.UserServiceFallbackImpl;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author gaz
 * @date 2017/10/31
 */
@FeignClient(name = "cloud-upms-service", fallback = UserServiceFallbackImpl.class)
public interface UserService {
    /**
     * 通过用户名查询用户、角色信息
     *
     * @param username 用户名
     * @return UserVo
     */
    @GetMapping("/user/findUserByUsername/{username}")
    UserVO findUserByUsername(@PathVariable("username") String username);
}
