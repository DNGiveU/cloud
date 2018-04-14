package com.ngiveu.cloud.tabe.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * SEO设置
 * </p>
 *
 * @author gaz
 * @since 2018-04-09
 */
public class Options extends Model<Options> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("option_site_title")
    private String optionSiteTitle;
    @TableField("option_site_descrption")
    private String optionSiteDescrption;
    @TableField("option_meta_descrption")
    private String optionMetaDescrption;
    @TableField("option_meta_keyword")
    private String optionMetaKeyword;
    @TableField("option_aboutsite_avatar")
    private String optionAboutsiteAvatar;
    @TableField("option_aboutsite_title")
    private String optionAboutsiteTitle;
    @TableField("option_aboutsite_content")
    private String optionAboutsiteContent;
    @TableField("option_aboutsite_wechat")
    private String optionAboutsiteWechat;
    @TableField("option_aboutsite_qq")
    private String optionAboutsiteQq;
    @TableField("option_aboutsite_github")
    private String optionAboutsiteGithub;
    @TableField("option_aboutsite_weibo")
    private String optionAboutsiteWeibo;
    @TableField("option_tongji")
    private String optionTongji;
    @TableField("option_status")
    private Integer optionStatus;
    @TableField("update_time")
    private Date updateTime;
    @TableField("del_flag")
    private String delFlag;

    public String getOptionSiteTitle() {
        return optionSiteTitle;
    }

    public void setOptionSiteTitle(String optionSiteTitle) {
        this.optionSiteTitle = optionSiteTitle;
    }

    public String getOptionSiteDescrption() {
        return optionSiteDescrption;
    }

    public void setOptionSiteDescrption(String optionSiteDescrption) {
        this.optionSiteDescrption = optionSiteDescrption;
    }

    public String getOptionMetaDescrption() {
        return optionMetaDescrption;
    }

    public void setOptionMetaDescrption(String optionMetaDescrption) {
        this.optionMetaDescrption = optionMetaDescrption;
    }

    public String getOptionMetaKeyword() {
        return optionMetaKeyword;
    }

    public void setOptionMetaKeyword(String optionMetaKeyword) {
        this.optionMetaKeyword = optionMetaKeyword;
    }

    public String getOptionAboutsiteAvatar() {
        return optionAboutsiteAvatar;
    }

    public void setOptionAboutsiteAvatar(String optionAboutsiteAvatar) {
        this.optionAboutsiteAvatar = optionAboutsiteAvatar;
    }

    public String getOptionAboutsiteTitle() {
        return optionAboutsiteTitle;
    }

    public void setOptionAboutsiteTitle(String optionAboutsiteTitle) {
        this.optionAboutsiteTitle = optionAboutsiteTitle;
    }

    public String getOptionAboutsiteContent() {
        return optionAboutsiteContent;
    }

    public void setOptionAboutsiteContent(String optionAboutsiteContent) {
        this.optionAboutsiteContent = optionAboutsiteContent;
    }

    public String getOptionAboutsiteWechat() {
        return optionAboutsiteWechat;
    }

    public void setOptionAboutsiteWechat(String optionAboutsiteWechat) {
        this.optionAboutsiteWechat = optionAboutsiteWechat;
    }

    public String getOptionAboutsiteQq() {
        return optionAboutsiteQq;
    }

    public void setOptionAboutsiteQq(String optionAboutsiteQq) {
        this.optionAboutsiteQq = optionAboutsiteQq;
    }

    public String getOptionAboutsiteGithub() {
        return optionAboutsiteGithub;
    }

    public void setOptionAboutsiteGithub(String optionAboutsiteGithub) {
        this.optionAboutsiteGithub = optionAboutsiteGithub;
    }

    public String getOptionAboutsiteWeibo() {
        return optionAboutsiteWeibo;
    }

    public void setOptionAboutsiteWeibo(String optionAboutsiteWeibo) {
        this.optionAboutsiteWeibo = optionAboutsiteWeibo;
    }

    public String getOptionTongji() {
        return optionTongji;
    }

    public void setOptionTongji(String optionTongji) {
        this.optionTongji = optionTongji;
    }

    public Integer getOptionStatus() {
        return optionStatus;
    }

    public void setOptionStatus(Integer optionStatus) {
        this.optionStatus = optionStatus;
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
        return "Options{" +
        ", optionId=" + id +
        ", optionSiteTitle=" + optionSiteTitle +
        ", optionSiteDescrption=" + optionSiteDescrption +
        ", optionMetaDescrption=" + optionMetaDescrption +
        ", optionMetaKeyword=" + optionMetaKeyword +
        ", optionAboutsiteAvatar=" + optionAboutsiteAvatar +
        ", optionAboutsiteTitle=" + optionAboutsiteTitle +
        ", optionAboutsiteContent=" + optionAboutsiteContent +
        ", optionAboutsiteWechat=" + optionAboutsiteWechat +
        ", optionAboutsiteQq=" + optionAboutsiteQq +
        ", optionAboutsiteGithub=" + optionAboutsiteGithub +
        ", optionAboutsiteWeibo=" + optionAboutsiteWeibo +
        ", optionTongji=" + optionTongji +
        ", optionStatus=" + optionStatus +
        "}";
    }
}
