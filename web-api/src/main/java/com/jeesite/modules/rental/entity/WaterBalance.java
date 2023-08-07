package com.jeesite.modules.rental.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WaterBalance {
    private Integer id;
    private Integer rid;
    private Double meter;
    private Double used;
    private Double price;
    private Double charge;
    private Double balanceTime;


}
