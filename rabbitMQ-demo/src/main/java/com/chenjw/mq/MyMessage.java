package com.chenjw.mq;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 消息对象
 * @Author: Chenjw
 * @Date: 2024-11-07 15:16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyMessage implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String title;

    private String content;

    private Date createTime;
}
