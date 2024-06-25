package com.entity.vo;

import com.entity.YonghutousuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 用户投诉
 * @author 
 * @email 
 * @date 2024-04-07 18:29:18
 */
public class YonghutousuVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 封面
	 */
	
	private String fengmian;
		
	/**
	 * 状态
	 */
	
	private String zhuangtai;
		
	/**
	 * 投诉原因
	 */
	
	private String tousuyuanyin;
		
	/**
	 * 投诉日期
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date tousuriqi;
		
	/**
	 * 账号
	 */
	
	private String zhanghao;
		
	/**
	 * 昵称
	 */
	
	private String nicheng;
		
	/**
	 * 手机
	 */
	
	private String shouji;
		
	/**
	 * 用户id
	 */
	
	private Long userid;
				
	
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
	 * 设置：状态
	 */
	 
	public void setZhuangtai(String zhuangtai) {
		this.zhuangtai = zhuangtai;
	}
	
	/**
	 * 获取：状态
	 */
	public String getZhuangtai() {
		return zhuangtai;
	}
				
	
	/**
	 * 设置：投诉原因
	 */
	 
	public void setTousuyuanyin(String tousuyuanyin) {
		this.tousuyuanyin = tousuyuanyin;
	}
	
	/**
	 * 获取：投诉原因
	 */
	public String getTousuyuanyin() {
		return tousuyuanyin;
	}
				
	
	/**
	 * 设置：投诉日期
	 */
	 
	public void setTousuriqi(Date tousuriqi) {
		this.tousuriqi = tousuriqi;
	}
	
	/**
	 * 获取：投诉日期
	 */
	public Date getTousuriqi() {
		return tousuriqi;
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
				
	
	/**
	 * 设置：手机
	 */
	 
	public void setShouji(String shouji) {
		this.shouji = shouji;
	}
	
	/**
	 * 获取：手机
	 */
	public String getShouji() {
		return shouji;
	}
				
	
	/**
	 * 设置：用户id
	 */
	 
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	
	/**
	 * 获取：用户id
	 */
	public Long getUserid() {
		return userid;
	}
			
}
