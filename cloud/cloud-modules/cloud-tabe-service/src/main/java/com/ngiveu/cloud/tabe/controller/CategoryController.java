package com.ngiveu.cloud.tabe.controller;
import java.util.Date;
import java.util.List;
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
import com.ngiveu.cloud.tabe.entity.Category;
import com.ngiveu.cloud.tabe.service.ICategoryService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author gaz
 * @since 2018-04-09
 */
@RestController
@RequestMapping("/category")
public class CategoryController extends BaseController {
    @Autowired private ICategoryService categoryService;

    /**
    * 通过ID查询
    *
    * @param id ID
    * @return Category
    */
    @GetMapping("/{id}")
    public Category get(@PathVariable Integer id) {
        return categoryService.selectById(id);
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
        return categoryService.selectPage(new Query<>(params), new EntityWrapper<>());
    }
    
    /**
     * 获取全部类别
     * @return
     * @author gaz
     */
    @GetMapping("/list")
    public List<Category> list() {
    	return this.categoryService.selectList(null);
    }

    /**
     * 添加
     * @param  category  实体
     * @return success/false
     */
    @PostMapping
    public Boolean add(@RequestBody Category category) {
        return categoryService.insert(category);
    }

    /**
     * 删除
     * @param id ID
     * @return success/false
     */
    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Integer id) {
        Category category = new Category();
        category.setId(id);
        category.setUpdateTime(new Date());
        category.setDelFlag(CommonConstant.STATUS_DEL);
        return categoryService.updateById(category);
    }

    /**
     * 编辑
     * @param  category  实体
     * @return success/false
     */
    @PutMapping
    public Boolean edit(@RequestBody Category category) {
        category.setUpdateTime(new Date());
        return categoryService.updateById(category);
    }
}
