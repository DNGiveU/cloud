package com.ngiveu.cloud.tabe.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

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
public class Category extends Model<Category> {

    private static final long serialVersionUID = 1L;

    /**
     * 自然主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 类别父级ID
     */
    @TableField("category_pid")
    private Integer categoryPid;
    /**
     * 类别名称
     */
    @TableField("category_name")
    private String categoryName;
    /**
     * 类别描述
     */
    @TableField("category_description")
    private String categoryDescription;
    /**
     * 类别描述
     */
    @TableField("category_order")
    private Integer categoryOrder;
    /**
     * 类别图标
     */
    @TableField("category_icon")
    private String categoryIcon;
    /**
     * 类别状态
     */
    @TableField("category_status")
    private Integer categoryStatus;

    @TableField("update_time")
    private Date updateTime;
    @TableField("del_flag")
    private String delFlag;


    public Integer getCategoryPid() {
        return categoryPid;
    }

    public void setCategoryPid(Integer categoryPid) {
        this.categoryPid = categoryPid;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    public Integer getCategoryOrder() {
        return categoryOrder;
    }

    public void setCategoryOrder(Integer categoryOrder) {
        this.categoryOrder = categoryOrder;
    }

    public String getCategoryIcon() {
        return categoryIcon;
    }

    public void setCategoryIcon(String categoryIcon) {
        this.categoryIcon = categoryIcon;
    }

    public Integer getCategoryStatus() {
        return categoryStatus;
    }

    public void setCategoryStatus(Integer categoryStatus) {
        this.categoryStatus = categoryStatus;
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
        return "Category{" +
        ", categoryId=" + id +
        ", categoryPid=" + categoryPid +
        ", categoryName=" + categoryName +
        ", categoryDescription=" + categoryDescription +
        ", categoryOrder=" + categoryOrder +
        ", categoryIcon=" + categoryIcon +
        ", categoryStatus=" + categoryStatus +
        "}";
    }
}
