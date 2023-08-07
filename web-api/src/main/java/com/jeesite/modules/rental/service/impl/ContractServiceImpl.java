package com.jeesite.modules.rental.service.impl;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.jeesite.common.lang.DateUtils;
import com.jeesite.modules.rental.dao.ContractMapper;
import com.jeesite.modules.rental.entity.Contract;
import com.jeesite.modules.rental.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ContractServiceImpl implements ContractService {

    @Autowired
    private ContractMapper contractMapper;

    @Override
    public String addContract(String tenantID) {
        String contractID = UUID.randomUUID().toString();
        DateTime updateTime = DateUtil.date();

        Contract contract = new Contract(contractID, tenantID, -1, DateUtil.date(), DateUtil.date(), updateTime);
        int insert = contractMapper.insert(contract);
        if (insert >= 1) {
            return contractID;
        }
        return null;
    }

    @Override
    public String updateContract(Contract contract) {
        if (ObjectUtil.isNotEmpty(contract)) {

            LambdaUpdateWrapper<Contract> contractUpdateWrapper = new LambdaUpdateWrapper<Contract>();
            contractUpdateWrapper.eq(Contract::getId, contract.getId())
                    .set(Contract::getRoomID, contract.getRoomID())
                    .set(Contract::getStartTime, contract.getStartTime())
                    .set(Contract::getEndTime, contract.getEndTime())
                    .set(Contract::getUpdateTime, DateUtil.date());
            int update = contractMapper.update(null, contractUpdateWrapper);
            if(update>=1){
                return contract.getId();
            }
            else {
                return null;
            }
        }
        return null;
    }
}
