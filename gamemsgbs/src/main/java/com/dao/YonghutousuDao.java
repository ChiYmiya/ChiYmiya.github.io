package com.dao;

import com.entity.YonghutousuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YonghutousuVO;
import com.entity.view.YonghutousuView;


/**
 * 用户投诉
 * 
 * @author 
 * @email 
 * @date 2024-04-07 18:29:18
 */
public interface YonghutousuDao extends BaseMapper<YonghutousuEntity> {
	
	List<YonghutousuVO> selectListVO(@Param("ew") Wrapper<YonghutousuEntity> wrapper);
	
	YonghutousuVO selectVO(@Param("ew") Wrapper<YonghutousuEntity> wrapper);
	
	List<YonghutousuView> selectListView(@Param("ew") Wrapper<YonghutousuEntity> wrapper);

	List<YonghutousuView> selectListView(Pagination page,@Param("ew") Wrapper<YonghutousuEntity> wrapper);

	
	YonghutousuView selectView(@Param("ew") Wrapper<YonghutousuEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<YonghutousuEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<YonghutousuEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<YonghutousuEntity> wrapper);



}
