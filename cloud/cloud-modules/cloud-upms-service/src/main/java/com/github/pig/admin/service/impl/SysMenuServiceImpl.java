package com.github.pig.admin.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.pig.admin.common.util.TreeUtil;
import com.github.pig.admin.mapper.SysMenuMapper;
import com.github.pig.admin.model.dto.MenuTree;
import com.github.pig.admin.model.entity.SysMenu;
import com.github.pig.admin.service.SysMenuService;
import com.ngiveu.cloud.common.constant.CommonConstant;
import com.ngiveu.cloud.common.util.Assert;
import com.ngiveu.cloud.common.vo.MenuVO;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <p>
 * 菜单权限表 服务实现类
 * </p>
 *
 * @author lengleng
 * @since 2017-10-29
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {
    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Override
    @Cacheable(value = "menu_details", key = "#role  + '_menu'")
    public Set<MenuVO> findMenuByRole(String role) {
        return sysMenuMapper.findMenuByRoleName(role);
    }

    @Override
    public String[] findPermission(String[] roles) {
        Set<MenuVO> menuVoSet = new HashSet<>();
        for (String role : roles) {
            Set<MenuVO> menuVos = findMenuByRole(role);
            menuVoSet.addAll(menuVos);
        }

        Set<String> permissions = new HashSet<>();
        for (MenuVO menuVo : menuVoSet) {
            if (StringUtils.isNotEmpty(menuVo.getPermission())) {
                String permission = menuVo.getPermission();
                permissions.add(permission);
            }
        }

        return permissions.toArray(new String[permissions.size()]);
    }

    @Override
    @CacheEvict(value = "menu_details", key = "#role + '_menu'")
    public Boolean deleteMenu(Integer id, String role) {
        Assert.isNull(id, "菜单ID不能为空");
        // 删除当前节点
        SysMenu condition1 = new SysMenu();
        condition1.setMenuId(id);
        condition1.setDelFlag(CommonConstant.STATUS_DEL);
        this.updateById(condition1);

        // 删除父节点为当前节点的节点
        SysMenu conditon2 = new SysMenu();
        conditon2.setParentId(id);
        SysMenu sysMenu = new SysMenu();
        sysMenu.setDelFlag(CommonConstant.STATUS_DEL);
        return this.update(sysMenu, new EntityWrapper<>(conditon2));
    }

    @Override
    @CacheEvict(value = "menu_details", key = "#role + '_menu'")
    public Boolean updateMenuById(SysMenu sysMenu, String role) {
        return this.updateById(sysMenu);
    }

    /**
     * 返回角色的菜单
     *
     * @param roleName 角色
     * @return 菜单列表
     */
    @Override
    public List<MenuTree> findUserMenuTree(String roleName) {
        // 获取符合条件得菜单
        Set<MenuVO> all = findMenuByRole(roleName);
        final List<MenuTree> menuTreeList = new ArrayList<>();
        all.stream().forEach((menuVo -> {
            if (CommonConstant.MENU.equals(menuVo.getType())) {
                menuTreeList.add(new MenuTree(menuVo));
            }
        }));
        return TreeUtil.bulid(menuTreeList, -1);
    }
}
