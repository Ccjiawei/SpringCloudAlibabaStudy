package com.chenjw.mapper;

import com.chenjw.bean.NbaTeam;
import org.apache.ibatis.annotations.Param;

/**
 * @Description
 * @Author: Chenjiawei
 * @Date: 2024/6/20 17:02
*/
public interface NbaTeamManagerMapper {

    public void addTeam(@Param("team") NbaTeam team);

}
