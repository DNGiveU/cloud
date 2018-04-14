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
import com.ngiveu.cloud.tabe.entity.Tag;
import com.ngiveu.cloud.tabe.service.ITagService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author gaz
 * @since 2018-04-09
 */
@RestController
@RequestMapping("/tag")
public class TagController extends BaseController {
    @Autowired
    private ITagService tagService;

    /**
    * 通过ID查询
    *
    * @param id ID
    * @return Tag
    */
    @GetMapping("/{id}")
    public Tag get(@PathVariable Integer id) {
        return tagService.selectById(id);
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
        return tagService.selectPage(new Query<>(params), new EntityWrapper<>());
    }

    /**
     * 添加
     * @param  tag  实体
     * @return success/false
     */
    @PostMapping
    public Boolean add(@RequestBody Tag tag) {
        return tagService.insert(tag);
    }

    /**
     * 删除
     * @param id ID
     * @return success/false
     */
    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Integer id) {
        Tag tag = new Tag();
        tag.setId(id);
        tag.setUpdateTime(new Date());
        tag.setDelFlag(CommonConstant.STATUS_DEL);
        return tagService.updateById(tag);
    }

    /**
     * 编辑
     * @param  tag  实体
     * @return success/false
     */
    @PutMapping
    public Boolean edit(@RequestBody Tag tag) {
        tag.setUpdateTime(new Date());
        return tagService.updateById(tag);
    }
}
