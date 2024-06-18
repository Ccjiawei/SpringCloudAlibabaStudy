package com.chenjw.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description
 * @Author: Chenjiawei
 * @Date: 2024/6/18 16:54
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Stock implements Serializable {
    private Integer id;
    private Integer count;
}
