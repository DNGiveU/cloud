package com.ngiveu.cloud.admin.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ngiveu.cloud.admin.model.entity.SysUser;
import com.ngiveu.cloud.admin.service.SysUserService;
import com.ngiveu.cloud.common.vo.UserVO;

/**
 * 
 * @author gaz
 * @date 2018年4月22日
 */
@RestController
@RequestMapping("/api/user")
public class UserApiController {

	@Autowired
	private SysUserService userService;
	
	/**
     * 根据用户ID集合获取用户信息集合
     * @param userIds
     * @return
     * @author gaz
     */
    @GetMapping("listUsersByIds")
    public List<UserVO> listUsersByIds(@RequestParam Set<Integer> userIds) {
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
