package com.jeesite.modules.rental.service;

import com.jeesite.modules.rental.entity.Tenant;

public interface TenantService {

    public int addTenant(Tenant tenant);

    public int updateTenant(Tenant tenant);

    public Tenant findByID(String tenantID);

}
