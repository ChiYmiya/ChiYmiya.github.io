package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YouxibiaoqianEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YouxibiaoqianVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YouxibiaoqianView;


/**
 * 游戏标签
 *
 * @author 
 * @email 
 * @date 2024-04-07 18:29:18
 */
public interface YouxibiaoqianService extends IService<YouxibiaoqianEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YouxibiaoqianVO> selectListVO(Wrapper<YouxibiaoqianEntity> wrapper);
   	
   	YouxibiaoqianVO selectVO(@Param("ew") Wrapper<YouxibiaoqianEntity> wrapper);
   	
   	List<YouxibiaoqianView> selectListView(Wrapper<YouxibiaoqianEntity> wrapper);
   	
   	YouxibiaoqianView selectView(@Param("ew") Wrapper<YouxibiaoqianEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YouxibiaoqianEntity> wrapper);

   	

}

