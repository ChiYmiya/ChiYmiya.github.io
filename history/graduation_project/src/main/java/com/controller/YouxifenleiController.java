package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.YouxifenleiEntity;
import com.entity.view.YouxifenleiView;

import com.service.YouxifenleiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 游戏分类
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-07 18:29:18
 */
@RestController
@RequestMapping("/youxifenlei")
public class YouxifenleiController {
    @Autowired
    private YouxifenleiService youxifenleiService;




    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YouxifenleiEntity youxifenlei,
		HttpServletRequest request){
        EntityWrapper<YouxifenleiEntity> ew = new EntityWrapper<YouxifenleiEntity>();

		PageUtils page = youxifenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, youxifenlei), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YouxifenleiEntity youxifenlei, 
		HttpServletRequest request){
        EntityWrapper<YouxifenleiEntity> ew = new EntityWrapper<YouxifenleiEntity>();

		PageUtils page = youxifenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, youxifenlei), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YouxifenleiEntity youxifenlei){
       	EntityWrapper<YouxifenleiEntity> ew = new EntityWrapper<YouxifenleiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( youxifenlei, "youxifenlei")); 
        return R.ok().put("data", youxifenleiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YouxifenleiEntity youxifenlei){
        EntityWrapper< YouxifenleiEntity> ew = new EntityWrapper< YouxifenleiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( youxifenlei, "youxifenlei")); 
		YouxifenleiView youxifenleiView =  youxifenleiService.selectView(ew);
		return R.ok("查询游戏分类成功").put("data", youxifenleiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YouxifenleiEntity youxifenlei = youxifenleiService.selectById(id);
        return R.ok().put("data", youxifenlei);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YouxifenleiEntity youxifenlei = youxifenleiService.selectById(id);
        return R.ok().put("data", youxifenlei);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YouxifenleiEntity youxifenlei, HttpServletRequest request){
        if(youxifenleiService.selectCount(new EntityWrapper<YouxifenleiEntity>().eq("youxifenlei", youxifenlei.getYouxifenlei()))>0) {
            return R.error("游戏分类已存在");
        }
    	//ValidatorUtils.validateEntity(youxifenlei);
        youxifenleiService.insert(youxifenlei);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YouxifenleiEntity youxifenlei, HttpServletRequest request){
        if(youxifenleiService.selectCount(new EntityWrapper<YouxifenleiEntity>().eq("youxifenlei", youxifenlei.getYouxifenlei()))>0) {
            return R.error("游戏分类已存在");
        }
    	//ValidatorUtils.validateEntity(youxifenlei);
        youxifenleiService.insert(youxifenlei);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YouxifenleiEntity youxifenlei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(youxifenlei);
        if(youxifenleiService.selectCount(new EntityWrapper<YouxifenleiEntity>().ne("id", youxifenlei.getId()).eq("youxifenlei", youxifenlei.getYouxifenlei()))>0) {
            return R.error("游戏分类已存在");
        }
        youxifenleiService.updateById(youxifenlei);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        youxifenleiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
