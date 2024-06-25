package com.dao;

import com.entity.YouxibiaoqianEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YouxibiaoqianVO;
import com.entity.view.YouxibiaoqianView;


/**
 * 游戏标签
 * 
 * @author 
 * @email 
 * @date 2024-04-07 18:29:18
 */
public interface YouxibiaoqianDao extends BaseMapper<YouxibiaoqianEntity> {
	
	List<YouxibiaoqianVO> selectListVO(@Param("ew") Wrapper<YouxibiaoqianEntity> wrapper);
	
	YouxibiaoqianVO selectVO(@Param("ew") Wrapper<YouxibiaoqianEntity> wrapper);
	
	List<YouxibiaoqianView> selectListView(@Param("ew") Wrapper<YouxibiaoqianEntity> wrapper);

	List<YouxibiaoqianView> selectListView(Pagination page,@Param("ew") Wrapper<YouxibiaoqianEntity> wrapper);

	
	YouxibiaoqianView selectView(@Param("ew") Wrapper<YouxibiaoqianEntity> wrapper);
	

}
