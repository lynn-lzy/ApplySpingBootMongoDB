package com.fivefu.apply.entity;

import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author DELL
 * @since 2020-01-08
 */
public class DbApplyCount implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @TableField("applyName")
    private String applyName;

    private Integer applycount;
    
    private String tjtime;

    private LocalDateTime createtime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApplyName() {
        return applyName;
    }

    public void setApplyName(String applyName) {
        this.applyName = applyName;
    }

    public Integer getApplycount() {
        return applycount;
    }

    public void setApplycount(Integer applycount) {
        this.applycount = applycount;
    }

    public String getTjtime() {
		return tjtime;
	}

	public void setTjtime(String tjtime) {
		this.tjtime = tjtime;
	}

	public LocalDateTime getCreatetime() {
        return createtime;
    }

    public void setCreatetime(LocalDateTime createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        return "DbApplyCount{" +
        "id=" + id +
        ", applyName=" + applyName +
        ", applycount=" + applycount +
        ", tjtime=" + tjtime +
        ", createtime=" + createtime +
        "}";
    }
}
