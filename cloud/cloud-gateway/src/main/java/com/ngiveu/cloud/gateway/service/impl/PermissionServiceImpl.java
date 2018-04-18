package com.ngiveu.cloud.gateway.service.impl;

import com.baomidou.mybatisplus.toolkit.StringUtils;
import com.ngiveu.cloud.common.vo.MenuVO;
import com.ngiveu.cloud.gateway.feign.MenuService;
import com.ngiveu.cloud.gateway.service.PermissionService;
import com.xiaoleilu.hutool.collection.CollectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author lengleng
 * @date 2017/10/28
 */
@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private MenuService menuService;

    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    /**
     * 路由访问权限过滤
     * 获取用户菜单可以访问的URL做匹配.如果当前访问URL存在用户菜单URL中则可以访问.否则返回CloudAccessDeniedHandler
     */
    @Override
    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        //ele-admin options 跨域配置，现在处理是通过前端配置代理，不使用这种方式，存在风险
//        if (HttpMethod.OPTIONS.name().equalsIgnoreCase(request.getMethod())) {
//            return true;
//        }
        Object principal = authentication.getPrincipal();
        @SuppressWarnings("unchecked")
		List<SimpleGrantedAuthority> grantedAuthorityList = (List<SimpleGrantedAuthority>) authentication.getAuthorities();
        boolean hasPermission = false;

        if (principal != null) {
            if (CollectionUtil.isEmpty(grantedAuthorityList)) {
                return hasPermission;
            }

            Set<MenuVO> urls = new HashSet<>();
            for (SimpleGrantedAuthority authority : grantedAuthorityList) {
                urls.addAll(menuService.findMenuByRole(authority.getAuthority()));
            }

            // 判断是否有URL访问权限
            for (MenuVO menu : urls) {
                if (StringUtils.isNotEmpty(menu.getUrl()) && antPathMatcher.match(menu.getUrl(), request.getRequestURI())
                        && request.getMethod().equalsIgnoreCase(menu.getMethod())) {
                    hasPermission = true;
                    break;
                }
            }
        }
        return hasPermission;
    }
}
