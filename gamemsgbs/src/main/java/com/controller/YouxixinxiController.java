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

import com.entity.YouxixinxiEntity;
import com.entity.view.YouxixinxiView;

import com.service.YouxixinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 游戏信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-07 18:29:18
 */
@RestController
@RequestMapping("/youxixinxi")
public class YouxixinxiController {
    @Autowired
    private YouxixinxiService youxixinxiService;

    @Autowired
    private StoreupService storeupService;



    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YouxixinxiEntity youxixinxi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			youxixinxi.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<YouxixinxiEntity> ew = new EntityWrapper<YouxixinxiEntity>();

		PageUtils page = youxixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, youxixinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YouxixinxiEntity youxixinxi, 
		HttpServletRequest request){
        EntityWrapper<YouxixinxiEntity> ew = new EntityWrapper<YouxixinxiEntity>();

		PageUtils page = youxixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, youxixinxi), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YouxixinxiEntity youxixinxi){
       	EntityWrapper<YouxixinxiEntity> ew = new EntityWrapper<YouxixinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( youxixinxi, "youxixinxi")); 
        return R.ok().put("data", youxixinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YouxixinxiEntity youxixinxi){
        EntityWrapper< YouxixinxiEntity> ew = new EntityWrapper< YouxixinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( youxixinxi, "youxixinxi")); 
		YouxixinxiView youxixinxiView =  youxixinxiService.selectView(ew);
		return R.ok("查询游戏信息成功").put("data", youxixinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YouxixinxiEntity youxixinxi = youxixinxiService.selectById(id);
		youxixinxi.setClicknum(youxixinxi.getClicknum()+1);
		youxixinxi.setClicktime(new Date());
		youxixinxiService.updateById(youxixinxi);
        youxixinxi = youxixinxiService.selectView(new EntityWrapper<YouxixinxiEntity>().eq("id", id));
        return R.ok().put("data", youxixinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YouxixinxiEntity youxixinxi = youxixinxiService.selectById(id);
		youxixinxi.setClicknum(youxixinxi.getClicknum()+1);
		youxixinxi.setClicktime(new Date());
		youxixinxiService.updateById(youxixinxi);
        youxixinxi = youxixinxiService.selectView(new EntityWrapper<YouxixinxiEntity>().eq("id", id));
        return R.ok().put("data", youxixinxi);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        YouxixinxiEntity youxixinxi = youxixinxiService.selectById(id);
        if(type.equals("1")) {
        	youxixinxi.setThumbsupnum(youxixinxi.getThumbsupnum()+1);
        } else {
        	youxixinxi.setCrazilynum(youxixinxi.getCrazilynum()+1);
        }
        youxixinxiService.updateById(youxixinxi);
        return R.ok("投票成功");
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YouxixinxiEntity youxixinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(youxixinxi);
        youxixinxiService.insert(youxixinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @IgnoreAuth
    @RequestMapping("/add")
    public R add(@RequestBody YouxixinxiEntity youxixinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(youxixinxi);
        youxixinxiService.insert(youxixinxi);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YouxixinxiEntity youxixinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(youxixinxi);
        youxixinxiService.updateById(youxixinxi);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<YouxixinxiEntity> list = new ArrayList<YouxixinxiEntity>();
        for(Long id : ids) {
            YouxixinxiEntity youxixinxi = youxixinxiService.selectById(id);
            youxixinxi.setSfsh(sfsh);
            youxixinxi.setShhf(shhf);
            list.add(youxixinxi);
        }
        youxixinxiService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        youxixinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,YouxixinxiEntity youxixinxi, HttpServletRequest request,String pre){
        EntityWrapper<YouxixinxiEntity> ew = new EntityWrapper<YouxixinxiEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicknum");
        params.put("order", "desc");
		PageUtils page = youxixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, youxixinxi), params), params));
        return R.ok().put("data", page);
    }


    /**
     * 协同算法（按收藏推荐）
     */
    @RequestMapping("/autoSort2")
    public R autoSort2(@RequestParam Map<String, Object> params,YouxixinxiEntity youxixinxi, HttpServletRequest request){
        String userId = request.getSession().getAttribute("userId").toString();
        String inteltypeColumn = "youxifenlei";
        List<StoreupEntity> storeups = storeupService.selectList(new EntityWrapper<StoreupEntity>().eq("type", 1).eq("userid", userId).eq("tablename", "youxixinxi").orderBy("addtime", false));
        List<String> inteltypes = new ArrayList<String>();
        Integer limit = params.get("limit")==null?10:Integer.parseInt(params.get("limit").toString());
        List<YouxixinxiEntity> youxixinxiList = new ArrayList<YouxixinxiEntity>();
        //去重
        if(storeups!=null && storeups.size()>0) {
            for(StoreupEntity s : storeups) {
                youxixinxiList.addAll(youxixinxiService.selectList(new EntityWrapper<YouxixinxiEntity>().eq(inteltypeColumn, s.getInteltype())));
            }
        }
        EntityWrapper<YouxixinxiEntity> ew = new EntityWrapper<YouxixinxiEntity>();
        params.put("sort", "id");
        params.put("order", "desc");
        PageUtils page = youxixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, youxixinxi), params), params));
        List<YouxixinxiEntity> pageList = (List<YouxixinxiEntity>)page.getList();
        if(youxixinxiList.size()<limit) {
            int toAddNum = (limit-youxixinxiList.size())<=pageList.size()?(limit-youxixinxiList.size()):pageList.size();
            for(YouxixinxiEntity o1 : pageList) {
                boolean addFlag = true;
                for(YouxixinxiEntity o2 : youxixinxiList) {
                    if(o1.getId().intValue()==o2.getId().intValue()) {
                        addFlag = false;
                        break;
                    }
                }
                if(addFlag) {
                    youxixinxiList.add(o1);
                    if(--toAddNum==0) break;
                }
            }
        } else if(youxixinxiList.size()>limit) {
            youxixinxiList = youxixinxiList.subList(0, limit);
        }
        page.setList(youxixinxiList);
        return R.ok().put("data", page);
    }




    /**
     * （按值统计）
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}")
    public R value(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        EntityWrapper<YouxixinxiEntity> ew = new EntityWrapper<YouxixinxiEntity>();
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
            ew.eq("zhanghao", (String)request.getSession().getAttribute("username"));
		}
        List<Map<String, Object>> result = youxixinxiService.selectValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * （按值统计(多)）
     */
    @RequestMapping("/valueMul/{xColumnName}")
    public R valueMul(@PathVariable("xColumnName") String xColumnName,@RequestParam String yColumnNameMul, HttpServletRequest request) {
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        EntityWrapper<YouxixinxiEntity> ew = new EntityWrapper<YouxixinxiEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("yonghu")) {
            ew.eq("zhanghao", (String)request.getSession().getAttribute("username"));
        }
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = youxixinxiService.selectValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }

    /**
     * （按值统计）时间统计类型
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}/{timeStatType}")
    public R valueDay(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        params.put("timeStatType", timeStatType);
        EntityWrapper<YouxixinxiEntity> ew = new EntityWrapper<YouxixinxiEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("yonghu")) {
            ew.eq("zhanghao", (String)request.getSession().getAttribute("username"));
        }
        List<Map<String, Object>> result = youxixinxiService.selectTimeStatValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * （按值统计）时间统计类型(多)
     */
    @RequestMapping("/valueMul/{xColumnName}/{timeStatType}")
    public R valueMulDay(@PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,@RequestParam String yColumnNameMul,HttpServletRequest request) {
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("timeStatType", timeStatType);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        EntityWrapper<YouxixinxiEntity> ew = new EntityWrapper<YouxixinxiEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("yonghu")) {
            ew.eq("zhanghao", (String)request.getSession().getAttribute("username"));
        }
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = youxixinxiService.selectTimeStatValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }

    /**
     * 分组统计
     */
    @RequestMapping("/group/{columnName}")
    public R group(@PathVariable("columnName") String columnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("column", columnName);
        EntityWrapper<YouxixinxiEntity> ew = new EntityWrapper<YouxixinxiEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("yonghu")) {
            ew.eq("zhanghao", (String)request.getSession().getAttribute("username"));
        }
        List<Map<String, Object>> result = youxixinxiService.selectGroup(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }







}
