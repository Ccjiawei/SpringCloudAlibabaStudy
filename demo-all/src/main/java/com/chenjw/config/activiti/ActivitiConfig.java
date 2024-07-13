package com.chenjw.config.activiti;

import org.activiti.engine.*;
import org.activiti.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;
import javax.sql.DataSource;

//@Configuration
public class ActivitiConfig {

    @Resource
    DataSource dataSource;

    @Bean
    public StandaloneProcessEngineConfiguration processEngineConfiguration(){
        StandaloneProcessEngineConfiguration configuration = new StandaloneProcessEngineConfiguration();
        configuration.setDataSource(dataSource);
        configuration.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
        configuration.setAsyncExecutorActivate(false);
        return configuration;
    }


    @Bean
    public ProcessEngine processEngine(){
        return processEngineConfiguration().buildProcessEngine();
    }

    @Bean
    public RepositoryService repositoryService(){
        return processEngine().getRepositoryService();
    }

    @Bean
    public RuntimeService runtimeService(){
        return processEngine().getRuntimeService();
    }

    @Bean
    public TaskService taskService(){
        return processEngine().getTaskService();
    }

    @Bean
    public HistoryService historyService(){
        return processEngine().getHistoryService();
    }
}
