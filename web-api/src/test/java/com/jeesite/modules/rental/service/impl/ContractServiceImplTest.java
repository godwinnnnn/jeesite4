package com.jeesite.modules.rental.service.impl;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import com.jeesite.common.lang.DateUtils;
import com.jeesite.modules.rental.entity.Contract;
import junit.framework.TestCase;

import java.util.UUID;

public class ContractServiceImplTest extends TestCase {
    public void testObjectUtil() {
        Contract contract = new Contract("123456",  null,101, DateUtil.date(), DateUtil.date(), DateUtil.date());
        boolean allNotEmpty = ObjectUtil.isAllNotEmpty(contract);
        System.out.println(allNotEmpty);
    }

    public void testUUID(){
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid.toString());
    }

    public void testDateUtil(){
        DateTime date = DateUtil.date();
        System.out.println(date);
    }
}