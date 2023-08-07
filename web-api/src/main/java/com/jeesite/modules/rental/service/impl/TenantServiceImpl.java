package com.jeesite.modules.rental.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.jeesite.common.lang.StringUtils;
import com.jeesite.modules.rental.dao.TenantMapper;
import com.jeesite.modules.rental.entity.Tenant;
import com.jeesite.modules.rental.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class TenantServiceImpl implements TenantService {

    @Autowired
    private TenantMapper tenantMapper;

    @Override
    public int addTenant(Tenant tenant) {
        tenant.setId(UUID.randomUUID().toString());
        int insert = tenantMapper.insert(tenant);
        return insert;
    }

    @Override
    public int updateTenant(Tenant tenant) {

        if (ObjectUtil.isNotEmpty(findByID(tenant.getId()))) {
            LambdaUpdateWrapper<Tenant> tenantLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
            tenantLambdaUpdateWrapper.eq(Tenant::getId, tenant.getId())
                    .set(Tenant::getName, tenant.getName())
                    .set(Tenant::getSex, tenant.getSex())
                    .set(Tenant::getAge, tenant.getAge())
                    .set(Tenant::getAddress, tenant.getAddress())
                    .set(Tenant::getCid, tenant.getCid())
                    .set(Tenant::getCidPhoto, tenant.getCidPhoto())
                    .set(Tenant::getStatus, tenant.getStatus());
            int update = tenantMapper.update(null, tenantLambdaUpdateWrapper);
            return update;
        }else{
            return 0;
        }
    }

    @Override
    public Tenant findByID(String tenantID) {
        LambdaQueryWrapper<Tenant> tenantLambdaQueryWrapper = new LambdaQueryWrapper<>();
        tenantLambdaQueryWrapper.eq(Tenant::getId, tenantID);
        Tenant tenant = tenantMapper.selectOne(tenantLambdaQueryWrapper);
        return null;
    }


}
