package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.YouxibiaoqianDao;
import com.entity.YouxibiaoqianEntity;
import com.service.YouxibiaoqianService;
import com.entity.vo.YouxibiaoqianVO;
import com.entity.view.YouxibiaoqianView;

@Service("youxibiaoqianService")
public class YouxibiaoqianServiceImpl extends ServiceImpl<YouxibiaoqianDao, YouxibiaoqianEntity> implements YouxibiaoqianService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YouxibiaoqianEntity> page = this.selectPage(
                new Query<YouxibiaoqianEntity>(params).getPage(),
                new EntityWrapper<YouxibiaoqianEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YouxibiaoqianEntity> wrapper) {
		  Page<YouxibiaoqianView> page =new Query<YouxibiaoqianView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<YouxibiaoqianVO> selectListVO(Wrapper<YouxibiaoqianEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YouxibiaoqianVO selectVO(Wrapper<YouxibiaoqianEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YouxibiaoqianView> selectListView(Wrapper<YouxibiaoqianEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YouxibiaoqianView selectView(Wrapper<YouxibiaoqianEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
