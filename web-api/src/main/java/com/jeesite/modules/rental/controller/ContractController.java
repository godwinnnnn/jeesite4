package com.jeesite.modules.rental.controller;

import com.jeesite.common.lang.StringUtils;
import com.jeesite.modules.rental.entity.Contract;
import com.jeesite.modules.rental.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ContractController {
@Autowired
private ContractService contractService;
    @RequestMapping(value = "addContract",method = RequestMethod.GET)
    public String addContract(@RequestParam(value = "tenantID") String tenantID){
        String s = contractService.addContract(tenantID);
        return s;
    }

    @RequestMapping(value = "addContract",method = RequestMethod.POST)
    public String updateContract(@RequestBody Contract contract){
        String s = contractService.updateContract(contract);
        return s;
    }
}
