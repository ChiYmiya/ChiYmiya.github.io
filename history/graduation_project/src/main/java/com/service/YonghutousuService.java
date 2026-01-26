package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YonghutousuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YonghutousuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YonghutousuView;


/**
 * 用户投诉
 *
 * @author 
 * @email 
 * @date 2024-04-07 18:29:18
 */
public interface YonghutousuService extends IService<YonghutousuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YonghutousuVO> selectListVO(Wrapper<YonghutousuEntity> wrapper);
   	
   	YonghutousuVO selectVO(@Param("ew") Wrapper<YonghutousuEntity> wrapper);
   	
   	List<YonghutousuView> selectListView(Wrapper<YonghutousuEntity> wrapper);
   	
   	YonghutousuView selectView(@Param("ew") Wrapper<YonghutousuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YonghutousuEntity> wrapper);

   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<YonghutousuEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<YonghutousuEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<YonghutousuEntity> wrapper);



}

