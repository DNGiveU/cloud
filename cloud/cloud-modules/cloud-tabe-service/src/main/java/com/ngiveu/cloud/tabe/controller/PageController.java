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
import com.ngiveu.cloud.common.constant.CommonConstant;
import com.ngiveu.cloud.common.util.Query;
import com.ngiveu.cloud.common.web.BaseController;
import com.ngiveu.cloud.tabe.entity.Page;
import com.ngiveu.cloud.tabe.service.IPageService;

/**
 * <p>
 * 页面(用于静态页面,如: 关于本站/申请友链等待) 前端控制器
 * </p>
 *
 * @author gaz
 * @since 2018-04-09
 */
@RestController
@RequestMapping("/page")
public class PageController extends BaseController {
    @Autowired
    private IPageService pageService;

    /**
    * 通过ID查询
    *
    * @param id ID
    * @return Page
    */
    @GetMapping("/{id}")
    public Page get(@PathVariable Integer id) {
        return pageService.selectById(id);
    }


    /**
    * 分页查询信息
    *
    * @param params 分页对象
    * @return 分页对象
    */
    @RequestMapping("/page")
    public com.baomidou.mybatisplus.plugins.Page page(@RequestParam Map<String, Object> params) {
        params.put(CommonConstant.DEL_FLAG, CommonConstant.STATUS_NORMAL);
        return pageService.selectPage(new Query<>(params), new EntityWrapper<>());
    }

    /**
     * 添加
     * @param  page  实体
     * @return success/false
     */
    @PostMapping
    public Boolean add(@RequestBody Page page) {
        return pageService.insert(page);
    }

    /**
     * 删除
     * @param id ID
     * @return success/false
     */
    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Integer id) {
        Page page = new Page();
        page.setId(id);
        page.setPageUpdateTime(new Date());
        page.setDelFlag(CommonConstant.STATUS_DEL);
        return pageService.updateById(page);
    }

    /**
     * 编辑
     * @param  page  实体
     * @return success/false
     */
    @PutMapping
    public Boolean edit(@RequestBody Page page) {
        page.setPageUpdateTime(new Date());
        return pageService.updateById(page);
    }
}
