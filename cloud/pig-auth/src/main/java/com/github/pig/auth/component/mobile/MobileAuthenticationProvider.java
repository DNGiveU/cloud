package com.github.pig.auth.component.mobile;

import com.github.pig.auth.feign.UserService;
import com.github.pig.auth.util.UserDetailsImpl;
import com.github.pig.common.vo.UserVO;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author lengleng
 * @date 2018/1/9
 * 手机号登录校验逻辑
 */
public class MobileAuthenticationProvider implements AuthenticationProvider {
    private UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        MobileAuthenticationToken mobileAuthenticationToken = (MobileAuthenticationToken) authentication;
        UserVO userVo = userService.findUserByMobile((String) mobileAuthenticationToken.getPrincipal());

        if (userVo == null) {
            throw new UsernameNotFoundException("手机号不存在:" + mobileAuthenticationToken.getPrincipal());
        }

        UserDetailsImpl userDetails = buildUserDeatils(userVo);

        MobileAuthenticationToken authenticationToken = new MobileAuthenticationToken(userDetails, userDetails.getAuthorities());
        authenticationToken.setDetails(mobileAuthenticationToken.getDetails());
        return authenticationToken;
    }

    private UserDetailsImpl buildUserDeatils(UserVO userVo) {
        return new UserDetailsImpl(userVo);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return MobileAuthenticationToken.class.isAssignableFrom(authentication);
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
