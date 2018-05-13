package com.ngiveu.cloud.tabe.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author gaz
 * @since 2018-05-13
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Video extends Model<Video> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 删除标识
     */
    @TableField("del_flag")
    private String delFlag;
    /**
     * 视频名称
     */
    @TableField("video_name")
    private String videoName;
    /**
     * 视频链接
     */
    @TableField("video_url")
    private String videoUrl;
    /**
     * 视频介绍
     */
    @TableField("video_introducation")
    private String videoIntroducation;
    /**
     * 视频作者
     */
    @TableField("video_author")
    private String videoAuthor;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;
    /**
     * 更新时间
     */
    @TableField("update_time")
    private Date updateTime;
    /**
     * 创建人
     */
    @TableField("create_by")
    private Integer createBy;
    /**
     * 更新人
     */
    @TableField("update_by")
    private Integer updateBy;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
