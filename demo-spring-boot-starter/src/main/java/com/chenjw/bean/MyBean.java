package com.chenjw.bean;

import lombok.Data;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@Data
public class MyBean {

    private String name;

    private String sex;

    protected static Map<String, String> vmap = new HashMap<>();

    private MyBean() {
    }

    private MyBean(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    private static class InnerClass {
        public static final MyBean INSTANCE =  new MyBean(vmap.get("name"), vmap.get("sex"));
    }


    public static MyBean getDefaultSingletonInstance(String name, String sex) {
        vmap.put("name", name);
        vmap.put("sex", sex);
        return InnerClass.INSTANCE;
    }

    public String hello(){
        return this.hashCode() + "hello!" + name + "--" + sex;
    }

    @Override
    public String toString() {
        return "MyBean{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
