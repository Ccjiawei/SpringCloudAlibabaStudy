package com.chenjw.service.impl;

import com.chenjw.bean.NbaTeam;
import com.chenjw.mapper.NbaTeamManagerMapper;
import com.chenjw.service.NbaTeamManagerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description
 * @Author: Chenjiawei
 * @Date: 2024/6/20 17:01
 */
@Service
public class NbaTeamManagerServiceImpl implements NbaTeamManagerService {

    @Resource
    private NbaTeamManagerMapper nbaTeamManagerMapper;


    @Override
    public void addTeamInfo(NbaTeam nbaTeam) {
        nbaTeamManagerMapper.addTeam(nbaTeam);
    }
}
