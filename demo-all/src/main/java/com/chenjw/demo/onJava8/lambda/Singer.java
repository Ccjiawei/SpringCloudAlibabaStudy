package com.chenjw.demo.onJava8.lambda;

public abstract class Singer<T> {

    protected String singerName;

    protected String singerGender;

    protected String singerTitle;

    public Singer(){
    }

    public Singer(String singerName, String singerGender, String singerTitle){
        this.singerName = singerName;
        this.singerGender = singerGender;
        this.singerTitle = singerTitle;
    }


    T create(String singerName, String singerGender, String singerTitle){
        return null;
    }

    void singing(String singerName){
    }
}
