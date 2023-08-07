package com.jeesite.modules.rental.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contract {
    private String id;
    private String tenantID;
    private Integer roomID;
    private Date startTime;
    private Date endTime;
    private Date updateTime;

}
