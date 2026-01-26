package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 投诉处理
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-04-07 18:29:18
 */
@TableName("tousuchuli")
public class TousuchuliEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public TousuchuliEntity() {
		
	}
	
	public TousuchuliEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
    @TableId(type = IdType.AUTO)
    private Long id;
	/**
	 * 标题
	 */
					
	private String biaoti;
	
	/**
	 * 封面
	 */
					
	private String fengmian;
	
	/**
	 * 处理描述
	 */
					
	private String chulimiaoshu;
	
	/**
	 * 处理日期
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date chuliriqi;
	
	/**
	 * 账号
	 */
					
	private String zhanghao;
	
	/**
	 * 昵称
	 */
					
	private String nicheng;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：标题
	 */
	public void setBiaoti(String biaoti) {
		this.biaoti = biaoti;
	}
	/**
	 * 获取：标题
	 */
	public String getBiaoti() {
		return biaoti;
	}
	/**
	 * 设置：封面
	 */
	public void setFengmian(String fengmian) {
		this.fengmian = fengmian;
	}
	/**
	 * 获取：封面
	 */
	public String getFengmian() {
		return fengmian;
	}
	/**
	 * 设置：处理描述
	 */
	public void setChulimiaoshu(String chulimiaoshu) {
		this.chulimiaoshu = chulimiaoshu;
	}
	/**
	 * 获取：处理描述
	 */
	public String getChulimiaoshu() {
		return chulimiaoshu;
	}
	/**
	 * 设置：处理日期
	 */
	public void setChuliriqi(Date chuliriqi) {
		this.chuliriqi = chuliriqi;
	}
	/**
	 * 获取：处理日期
	 */
	public Date getChuliriqi() {
		return chuliriqi;
	}
	/**
	 * 设置：账号
	 */
	public void setZhanghao(String zhanghao) {
		this.zhanghao = zhanghao;
	}
	/**
	 * 获取：账号
	 */
	public String getZhanghao() {
		return zhanghao;
	}
	/**
	 * 设置：昵称
	 */
	public void setNicheng(String nicheng) {
		this.nicheng = nicheng;
	}
	/**
	 * 获取：昵称
	 */
	public String getNicheng() {
		return nicheng;
	}

}
