package com.chenjw.entity;


import lombok.Data;

import java.io.Serializable;

/**
* 
* @TableName resources
*/
@Data
public class Resources implements Serializable {

    private Integer id;
    private String pattern;

}
