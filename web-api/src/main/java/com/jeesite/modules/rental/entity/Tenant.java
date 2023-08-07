package com.jeesite.modules.rental.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tenant {
    private String id;
    private String name;
    private String sex;
    private Integer age;
    private String address;
    private String cid;
    private String cidPhoto;
    private  String status;
}
