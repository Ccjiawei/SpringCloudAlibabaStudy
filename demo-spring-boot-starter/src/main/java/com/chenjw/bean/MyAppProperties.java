package com.chenjw.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 *
 */
@Data
@ConfigurationProperties(prefix = "my.app")
public class MyAppProperties {

    private String name;
    private String sex;

}
