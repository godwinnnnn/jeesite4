package com.jeesite.modules.rental.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jeesite.modules.rental.entity.Contract;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ContractMapper extends BaseMapper<Contract> {

}
