package com.ngiveu.cloud.tabe.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author gaz
 * @since 2018-04-09
 */
public class Tag extends Model<Tag> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("tag_name")
    private String tagName;
    @TableField("tag_description")
    private String tagDescription;
    @TableField("tag_status")
    private Integer tagStatus;
    @TableField("update_time")
    private Date updateTime;
    @TableField("del_flag")
    private String delFlag;

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getTagDescription() {
        return tagDescription;
    }

    public void setTagDescription(String tagDescription) {
        this.tagDescription = tagDescription;
    }

    public Integer getTagStatus() {
        return tagStatus;
    }

    public void setTagStatus(Integer tagStatus) {
        this.tagStatus = tagStatus;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    public String toString() {
        return "Tag{" +
        ", tagId=" + id +
        ", tagName=" + tagName +
        ", tagDescription=" + tagDescription +
        ", tagStatus=" + tagStatus +
        "}";
    }
}
