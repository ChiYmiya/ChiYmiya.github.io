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

import com.entity.YouxibiaoqianEntity;
import com.entity.view.YouxibiaoqianView;

import com.service.YouxibiaoqianService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 游戏标签
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-07 18:29:18
 */
@RestController
@RequestMapping("/youxibiaoqian")
public class YouxibiaoqianController {
    @Autowired
    private YouxibiaoqianService youxibiaoqianService;




    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YouxibiaoqianEntity youxibiaoqian,
		HttpServletRequest request){
        EntityWrapper<YouxibiaoqianEntity> ew = new EntityWrapper<YouxibiaoqianEntity>();

		PageUtils page = youxibiaoqianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, youxibiaoqian), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YouxibiaoqianEntity youxibiaoqian, 
		HttpServletRequest request){
        EntityWrapper<YouxibiaoqianEntity> ew = new EntityWrapper<YouxibiaoqianEntity>();

		PageUtils page = youxibiaoqianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, youxibiaoqian), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YouxibiaoqianEntity youxibiaoqian){
       	EntityWrapper<YouxibiaoqianEntity> ew = new EntityWrapper<YouxibiaoqianEntity>();
      	ew.allEq(MPUtil.allEQMapPre( youxibiaoqian, "youxibiaoqian")); 
        return R.ok().put("data", youxibiaoqianService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YouxibiaoqianEntity youxibiaoqian){
        EntityWrapper< YouxibiaoqianEntity> ew = new EntityWrapper< YouxibiaoqianEntity>();
 		ew.allEq(MPUtil.allEQMapPre( youxibiaoqian, "youxibiaoqian")); 
		YouxibiaoqianView youxibiaoqianView =  youxibiaoqianService.selectView(ew);
		return R.ok("查询游戏标签成功").put("data", youxibiaoqianView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YouxibiaoqianEntity youxibiaoqian = youxibiaoqianService.selectById(id);
        return R.ok().put("data", youxibiaoqian);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YouxibiaoqianEntity youxibiaoqian = youxibiaoqianService.selectById(id);
        return R.ok().put("data", youxibiaoqian);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YouxibiaoqianEntity youxibiaoqian, HttpServletRequest request){
        if(youxibiaoqianService.selectCount(new EntityWrapper<YouxibiaoqianEntity>().eq("biaoqian", youxibiaoqian.getBiaoqian()))>0) {
            return R.error("标签已存在");
        }
    	//ValidatorUtils.validateEntity(youxibiaoqian);
        youxibiaoqianService.insert(youxibiaoqian);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YouxibiaoqianEntity youxibiaoqian, HttpServletRequest request){
        if(youxibiaoqianService.selectCount(new EntityWrapper<YouxibiaoqianEntity>().eq("biaoqian", youxibiaoqian.getBiaoqian()))>0) {
            return R.error("标签已存在");
        }
    	//ValidatorUtils.validateEntity(youxibiaoqian);
        youxibiaoqianService.insert(youxibiaoqian);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YouxibiaoqianEntity youxibiaoqian, HttpServletRequest request){
        //ValidatorUtils.validateEntity(youxibiaoqian);
        if(youxibiaoqianService.selectCount(new EntityWrapper<YouxibiaoqianEntity>().ne("id", youxibiaoqian.getId()).eq("biaoqian", youxibiaoqian.getBiaoqian()))>0) {
            return R.error("标签已存在");
        }
        youxibiaoqianService.updateById(youxibiaoqian);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        youxibiaoqianService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
