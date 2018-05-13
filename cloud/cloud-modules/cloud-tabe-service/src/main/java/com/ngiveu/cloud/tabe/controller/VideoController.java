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
import com.ngiveu.cloud.tabe.entity.Video;
import com.ngiveu.cloud.tabe.service.IVideoService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author gaz
 * @since 2018-05-13
 */
@RestController
@RequestMapping("/video")
public class VideoController extends BaseController {
    @Autowired private IVideoService videoService;

    /**
    * 通过ID查询
    *
    * @param id ID
    * @return Video
    */
    @GetMapping("/{id}")
    public Video get(@PathVariable Integer id) {
        return videoService.selectById(id);
    }


    /**
    * 分页查询信息
    *
    * @param params 分页对象
    * @return 分页对象
    */
    @RequestMapping("/page")
    public Page<Video> page(@RequestParam Map<String, Object> params) {
        params.put(CommonConstant.DEL_FLAG, CommonConstant.STATUS_NORMAL);
        return videoService.selectPage(new Query<>(params), new EntityWrapper<>());
    }

    /**
     * 添加
     * @param  video  实体
     * @return success/false
     */
    @PostMapping
    public Boolean add(@RequestBody Video video) {
        return videoService.insert(video);
    }

    /**
     * 删除
     * @param id ID
     * @return success/false
     */
    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Integer id) {
        Video video = new Video();
        video.setId(id);
        video.setUpdateTime(new Date());
        video.setDelFlag(CommonConstant.STATUS_DEL);
        return videoService.updateById(video);
    }

    /**
     * 编辑
     * @param  video  实体
     * @return success/false
     */
    @PutMapping
    public Boolean edit(@RequestBody Video video) {
        video.setUpdateTime(new Date());
        return videoService.updateById(video);
    }
}
