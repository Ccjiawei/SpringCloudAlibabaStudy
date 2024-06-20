package com.chenjw.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description
 * @Author: Chenjiawei
 * @Date: 2024/6/20 17:18
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class NbaTeam implements Serializable {

    private int id;
    private String teamName;
    private String teamPart;
    private String teamArea;
    private String teamGym;

}
