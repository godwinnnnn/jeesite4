package com.jeesite.modules.rental.controller;

import com.jeesite.common.constant.Status;
import com.jeesite.common.model.ApiResponse;
import com.jeesite.modules.rental.entity.Tenant;
import com.jeesite.modules.rental.service.TenantService;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.print.DocFlavor;

@RestController
public class TenantController {
    @Autowired
    private TenantService tenantService;

    @RequestMapping(value = "/addTenant", method = RequestMethod.POST)
    public ApiResponse addTenant(@RequestBody Tenant tenant) {
        int i = tenantService.addTenant(tenant);
        if (i != 0) {
            return ApiResponse.ofSuccess(null);
        } else {
            return ApiResponse.ofStatus(Status.UNKNOWN_ERROR);
        }
    }

    @RequestMapping(value = "/updateTenant", method = RequestMethod.POST)
    public ApiResponse updateTenant(@RequestBody Tenant tenant) {
        int i = tenantService.updateTenant(tenant);
        if (i != 0) {
            return ApiResponse.ofSuccess(null);
        } else {
            return ApiResponse.ofStatus(Status.UNKNOWN_ERROR);
        }
    }
}
