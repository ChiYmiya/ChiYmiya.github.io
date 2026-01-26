package com.entity.vo;

import com.entity.TousuchuliEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 投诉处理
 * @author 
 * @email 
 * @date 2024-04-07 18:29:18
 */
public class TousuchuliVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
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
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
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
