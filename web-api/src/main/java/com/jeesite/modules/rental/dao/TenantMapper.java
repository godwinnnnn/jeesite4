package com.jeesite.modules.rental.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jeesite.modules.rental.entity.Tenant;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TenantMapper extends BaseMapper<Tenant> {
}
