package com.jeesite.modules.rental.service;

import com.jeesite.modules.rental.entity.Contract;

public interface ContractService {

    public String addContract(String tenantID);

    public String updateContract(Contract contract);
}
