package com.jeesite.modules.rental.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ElectricityBalance {
    private Integer id;
    private Integer rid;
    private Double meter;
    private Double used;
    private Double price;
    private Double charge;
    private Date balanceTime;
}
