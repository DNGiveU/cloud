package com.ngiveu.cloud.admin.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.baomidou.mybatisplus.plugins.Page;
import com.luhuiguo.fastdfs.domain.StorePath;
import com.luhuiguo.fastdfs.service.FastFileStorageClient;
import com.ngiveu.cloud.admin.model.dto.UserDTO;
import com.ngiveu.cloud.admin.model.dto.UserInfo;
import com.ngiveu.cloud.admin.model.entity.SysUser;
import com.ngiveu.cloud.admin.model.entity.SysUserRole;
import com.ngiveu.cloud.admin.service.SysUserService;
import com.ngiveu.cloud.common.bean.config.FdfsPropertiesConfig;
import com.ngiveu.cloud.common.constant.CommonConstant;
import com.ngiveu.cloud.common.util.Query;
import com.ngiveu.cloud.common.util.R;
import com.ngiveu.cloud.common.vo.UserVO;
import com.ngiveu.cloud.common.web.BaseController;
import com.xiaoleilu.hutool.io.FileUtil;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * @author lengleng
 * @date 2017/10/28
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {
    private static final PasswordEncoder ENCODER = new BCryptPasswordEncoder();
    @Autowired
    private FastFileStorageClient fastFileStorageClient;
    @Autowired
    private SysUserService userService;
    @Autowired
    private FdfsPropertiesConfig fdfsPropertiesConfig;


    /**
     * 获取当前用户信息（角色、权限）
     * 并且异步初始化用户部门信息
     *
     * @param userVo 当前用户信息
     * @return 用户名
     */
    @GetMapping("/info")
    public R<UserInfo> user(UserVO userVo) {
    	System.out.println(userVo);
        UserInfo userInfo = userService.findUserInfo(userVo);
        return new R<>(userInfo);
    }

    /**
     * 通过ID查询当前用户信息
     *
     * @param id ID
     * @return 用户信息
     */
    @GetMapping("/{id}")
    public UserVO user(@PathVariable Integer id) {
        return userService.selectUserVoById(id);
    }

    /**
     * 删除用户信息
     *
     * @param id ID
     * @return R
     */
    @ApiOperation(value = "删除用户", notes = "根据ID删除用户")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer", paramType = "path")
    @DeleteMapping("/{id}")
    public R<Boolean> userDel(@PathVariable Integer id) {
        SysUser sysUser = userService.selectById(id);
        return new R<>(userService.deleteUserById(sysUser));
    }

    /**
     * 添加用户
     *
     * @param userDto 用户信息
     * @return success/false
     */
    @PostMapping
    public R<Boolean> user(@RequestBody UserDTO userDto) {
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(userDto, sysUser);
        sysUser.setDelFlag(CommonConstant.STATUS_NORMAL);
        sysUser.setPassword(ENCODER.encode(userDto.getPassword()));
        userService.insert(sysUser);
        SysUserRole userRole = new SysUserRole();
        userRole.setUserId(sysUser.getUserId());
        userRole.setRoleId(userDto.getRole());
        return new R<>(userRole.insert());
    }

    /**
     * 更新用户信息
     *
     * @param userDto 用户信息
     * @return R
     */
    @PutMapping
    public R<Boolean> userUpdate(@RequestBody UserDTO userDto) {
        SysUser user = userService.selectById(userDto.getUserId());
        return new R<>(userService.updateUser(userDto, user.getUsername()));
    }

    /**
     * 通过用户名查询用户及其角色信息
     *
     * @param username 用户名
     * @return UseVo 对象
     */
    @GetMapping("/findUserByUsername/{username}")
    public UserVO findUserByUsername(@PathVariable String username) {
    	return userService.findUserByUsername(username);
    }

    /**
     * 通过手机号查询用户及其角色信息
     *
     * @param mobile 手机号
     * @return UseVo 对象
     */
    @GetMapping("/findUserByMobile/{mobile}")
    public UserVO findUserByMobile(@PathVariable String mobile) {
        return userService.findUserByMobile(mobile);
    }

    /**
     * 通过OpenId查询
     *
     * @param openId openid
     * @return 对象
     */
    @GetMapping("/findUserByOpenId/{openId}")
    public UserVO findUserByOpenId(@PathVariable String openId) {
        return userService.findUserByOpenId(openId);
    }

    /**
     * 分页查询用户
     *
     * @param params 参数集
     * @return 用户集合
     */
    @RequestMapping("/userPage")
    public Page userPage(@RequestParam Map<String, Object> params) {
        return userService.selectWithRolePage(new Query(params));
    }

    /**
     * 上传用户头像
     * (多机部署有问题，建议使用独立的文件服务器)
     *
     * @param file 资源
     * @return filename map
     */
    @PostMapping("/upload")
    public Map<String, String> upload(@RequestParam("file") MultipartFile file) {
        String fileExt = FileUtil.extName(file.getOriginalFilename());
        Map<String, String> resultMap = new HashMap<>(1);
        try {
            StorePath storePath = fastFileStorageClient.uploadFile(file.getBytes(), fileExt);
            resultMap.put("filename", fdfsPropertiesConfig.getFileHost() + storePath.getFullPath());
        } catch (IOException e) {
            logger.error("文件上传异常", e);
            throw new RuntimeException(e);
        }
        return resultMap;
    }

    /**
     * 修改个人信息
     *
     * @param userDto userDto
     * @param userVo  登录用户信息
     * @return success/false
     */
    @PutMapping("/editInfo")
    public R<Boolean> editInfo(@RequestBody UserDTO userDto, UserVO userVo) {
        return new R<>(userService.updateUserInfo(userDto, userVo.getUsername()));
    }
    
    /**
     * 根据用户ID集合获取用户信息集合
     * @param userIds
     * @return
     * @author gaz
     */
    @GetMapping("listUsersByIds")
    public List<UserVO> listUsersByIds(@RequestParam List<Integer> userIds) {
    	List<SysUser> sysUsers = this.userService.selectBatchIds(userIds);
    	List<UserVO> userVOs = new ArrayList<UserVO>(sysUsers.size());
    	for (SysUser user : sysUsers) {
    		UserVO vo = new UserVO();
    		vo.setUserId(user.getUserId());
    		vo.setUsername(user.getUsername());
    		vo.setAvatar(user.getAvatar());
    		userVOs.add(vo);
    	}
    	return userVOs;
    }
}
