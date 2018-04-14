package com.ngiveu.cloud.tabe.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 页面(用于静态页面,如: 关于本站/申请友链等待)
 * </p>
 *
 * @author gaz
 * @since 2018-04-09
 */
public class Page extends Model<Page> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("page_key")
    private String pageKey;
    @TableField("page_title")
    private String pageTitle;
    @TableField("page_content")
    private String pageContent;
    @TableField("page_create_time")
    private Date pageCreateTime;
    @TableField("page_update_time")
    private Date pageUpdateTime;
    @TableField("page_view_count")
    private Integer pageViewCount;
    @TableField("page_comment_count")
    private Integer pageCommentCount;
    @TableField("page_status")
    private Integer pageStatus;
    @TableField("del_flag")
    private String delFlag;

    public String getPageKey() {
        return pageKey;
    }

    public void setPageKey(String pageKey) {
        this.pageKey = pageKey;
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }

    public String getPageContent() {
        return pageContent;
    }

    public void setPageContent(String pageContent) {
        this.pageContent = pageContent;
    }

    public Date getPageCreateTime() {
        return pageCreateTime;
    }

    public void setPageCreateTime(Date pageCreateTime) {
        this.pageCreateTime = pageCreateTime;
    }

    public Date getPageUpdateTime() {
        return pageUpdateTime;
    }

    public void setPageUpdateTime(Date pageUpdateTime) {
        this.pageUpdateTime = pageUpdateTime;
    }

    public Integer getPageViewCount() {
        return pageViewCount;
    }

    public void setPageViewCount(Integer pageViewCount) {
        this.pageViewCount = pageViewCount;
    }

    public Integer getPageCommentCount() {
        return pageCommentCount;
    }

    public void setPageCommentCount(Integer pageCommentCount) {
        this.pageCommentCount = pageCommentCount;
    }

    public Integer getPageStatus() {
        return pageStatus;
    }

    public void setPageStatus(Integer pageStatus) {
        this.pageStatus = pageStatus;
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

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    public String toString() {
        return "Page{" +
        ", pageId=" + id +
        ", pageKey=" + pageKey +
        ", pageTitle=" + pageTitle +
        ", pageContent=" + pageContent +
        ", pageCreateTime=" + pageCreateTime +
        ", pageUpdateTime=" + pageUpdateTime +
        ", pageViewCount=" + pageViewCount +
        ", pageCommentCount=" + pageCommentCount +
        ", pageStatus=" + pageStatus +
        "}";
    }
}
