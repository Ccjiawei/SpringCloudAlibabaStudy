package com.chenjw.entity;

import lombok.Data;

import java.io.Serializable;

/**
* 
* @TableName role
*/
@Data
public class Role implements Serializable {

    private Integer id;
    private String name;
    private String description;

}
