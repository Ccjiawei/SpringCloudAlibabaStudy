package com.chenjw.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description
 * @Author: Chenjiawei
 * @Date: 2024/6/18 16:39
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@TableName("order_tbl")
public class Order implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private Integer stockId;
    private String orderInfo;
}
