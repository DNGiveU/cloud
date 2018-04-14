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
import com.ngiveu.cloud.tabe.entity.Article;
import com.ngiveu.cloud.tabe.service.IArticleService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author gaz
 * @since 2018-04-09
 */
@RestController
@RequestMapping("/article")
public class ArticleController extends BaseController {
    @Autowired
    private IArticleService articleService;

    /**
    * 通过ID查询
    *
    * @param id ID
    * @return Article
    */
    @GetMapping("/{id}")
    public Article get(@PathVariable Integer id) {
        return articleService.selectById(id);
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
        return articleService.selectPage(new Query<>(params), new EntityWrapper<>());
    }

    /**
     * 添加
     * @param  article  实体
     * @return success/false
     */
    @PostMapping
    public Boolean add(@RequestBody Article article) {
        return articleService.insert(article);
    }

    /**
     * 删除
     * @param id ID
     * @return success/false
     */
    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Integer id) {
        Article article = new Article();
        article.setId(id);
        article.setArticleUpdateTime(new Date());
        article.setDelFlag(CommonConstant.STATUS_DEL);
        return articleService.updateById(article);
    }

    /**
     * 编辑
     * @param  article  实体
     * @return success/false
     */
    @PutMapping
    public Boolean edit(@RequestBody Article article) {
        article.setArticleUpdateTime(new Date());
        return articleService.updateById(article);
    }
}
