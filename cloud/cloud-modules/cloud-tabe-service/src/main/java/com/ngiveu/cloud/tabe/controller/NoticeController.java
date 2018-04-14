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
import com.ngiveu.cloud.tabe.entity.Notice;
import com.ngiveu.cloud.tabe.service.INoticeService;

/**
 * <p>
 * 通知 前端控制器
 * </p>
 *
 * @author gaz
 * @since 2018-04-09
 */
@RestController
@RequestMapping("/notice")
public class NoticeController extends BaseController {
    @Autowired
    private INoticeService noticeService;

    /**
    * 通过ID查询
    *
    * @param id ID
    * @return Notice
    */
    @GetMapping("/{id}")
    public Notice get(@PathVariable Integer id) {
        return noticeService.selectById(id);
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
        return noticeService.selectPage(new Query<>(params), new EntityWrapper<>());
    }

    /**
     * 添加
     * @param  notice  实体
     * @return success/false
     */
    @PostMapping
    public Boolean add(@RequestBody Notice notice) {
        return noticeService.insert(notice);
    }

    /**
     * 删除
     * @param id ID
     * @return success/false
     */
    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Integer id) {
        Notice notice = new Notice();
        notice.setId(id);
        notice.setNoticeUpdateTime(new Date());
        notice.setDelFlag(CommonConstant.STATUS_DEL);
        return noticeService.updateById(notice);
    }

    /**
     * 编辑
     * @param  notice  实体
     * @return success/false
     */
    @PutMapping
    public Boolean edit(@RequestBody Notice notice) {
        notice.setNoticeUpdateTime(new Date());
        return noticeService.updateById(notice);
    }
}
