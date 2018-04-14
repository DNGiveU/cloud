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
import com.ngiveu.cloud.tabe.entity.Options;
import com.ngiveu.cloud.tabe.service.IOptionsService;

/**
 * <p>
 * SEO设置 前端控制器
 * </p>
 *
 * @author gaz
 * @since 2018-04-09
 */
@RestController
@RequestMapping("/options")
public class OptionsController extends BaseController {
    @Autowired
    private IOptionsService optionsService;

    /**
    * 通过ID查询
    *
    * @param id ID
    * @return Options
    */
    @GetMapping("/{id}")
    public Options get(@PathVariable Integer id) {
        return optionsService.selectById(id);
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
        return optionsService.selectPage(new Query<>(params), new EntityWrapper<>());
    }

    /**
     * 添加
     * @param  options  实体
     * @return success/false
     */
    @PostMapping
    public Boolean add(@RequestBody Options options) {
        return optionsService.insert(options);
    }

    /**
     * 删除
     * @param id ID
     * @return success/false
     */
    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Integer id) {
        Options options = new Options();
        options.setId(id);
        options.setUpdateTime(new Date());
        options.setDelFlag(CommonConstant.STATUS_DEL);
        return optionsService.updateById(options);
    }

    /**
     * 编辑
     * @param  options  实体
     * @return success/false
     */
    @PutMapping
    public Boolean edit(@RequestBody Options options) {
        options.setUpdateTime(new Date());
        return optionsService.updateById(options);
    }
}
