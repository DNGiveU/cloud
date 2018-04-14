package com.ngiveu.cloud.tabe.controller;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.ngiveu.cloud.common.constant.CommonConstant;
import com.ngiveu.cloud.common.util.Query;
import com.ngiveu.cloud.common.web.BaseController;
import com.ngiveu.cloud.tabe.entity.Link;
import com.ngiveu.cloud.tabe.service.ILinkService;

/**
 * <p>
 * 第三方链接 前端控制器
 * </p>
 *
 * @author gaz
 * @since 2018-04-09
 */
@RestController
@RequestMapping("/link")
public class LinkController extends BaseController {
    @Autowired
    private ILinkService linkService;

    /**
    * 通过ID查询
    *
    * @param id ID
    * @return Link
    */
    @GetMapping("/{id}")
    public Link get(@PathVariable Integer id) {
        return linkService.selectById(id);
    }


    /**
    * 分页查询信息
    *
    * @param params 分页对象
    * @return 分页对象
    */
    @RequestMapping("/page")
    public Page page(@RequestParam Map<String, Object> params) {
        params.put(CommonConstant.DEL_FLAG, CommonConstant.STATUS_NORMAL);
        return linkService.selectPage(new Query<>(params), new EntityWrapper<>());
    }

    /**
     * 添加
     * @param  link  实体
     * @return success/false
     */
    @PostMapping
    public Boolean add(@RequestBody Link link) {
        return linkService.insert(link);
    }

    /**
     * 删除
     * @param id ID
     * @return success/false
     */
    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Integer id) {
        Link link = new Link();
        link.setId(id);
        link.setLinkUpdateTime(new Date());
        link.setDelFlag(CommonConstant.STATUS_DEL);
        return linkService.updateById(link);
    }

    /**
     * 编辑
     * @param  link  实体
     * @return success/false
     */
    @PutMapping
    public Boolean edit(@RequestBody Link link) {
        link.setLinkUpdateTime(new Date());
        return linkService.updateById(link);
    }
}
