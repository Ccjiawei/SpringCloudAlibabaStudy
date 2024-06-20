package com.chenjw.controller;

import com.chenjw.bean.NbaTeam;
import com.chenjw.common.Result;
import com.chenjw.service.NbaTeamManagerService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description
 * @Author: Chenjiawei
 * @Date: 2024/6/17 10:51
 */
@RestController
@RequestMapping("/team")
public class NbaTeamManagerController {

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${server.port}")
    private String port;

    @Resource
    private NbaTeamManagerService nbaTeamManagerService;

    @RequestMapping("/add")
    public Result add(@RequestBody NbaTeam nbaTeam){
        nbaTeamManagerService.addTeamInfo(nbaTeam);
        return Result.success();
    }

}
