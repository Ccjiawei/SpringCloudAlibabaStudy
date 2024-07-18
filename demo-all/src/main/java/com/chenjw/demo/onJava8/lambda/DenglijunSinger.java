package com.chenjw.demo.onJava8.lambda;

import lombok.Getter;

@Getter
//@ToString(exclude = {"singerName","singerGender","singerTitle"})
public class DenglijunSinger extends Singer{


    public DenglijunSinger(String singerName, String singerGender, String singerTitle) {
        super.singerName = singerName;
        super.singerGender = singerGender;
        super.singerTitle = singerTitle;
    }

    @Override
    DenglijunSinger create(String singerName, String singerGender, String singerTitle){
        return new DenglijunSinger(singerName, singerGender, singerTitle);
    }

    @Override
    void singing(String singername){
        System.out.println(singername+"--正在唱歌！！！");
    }

    @Override
    public String toString() {
        return "DenglijunSinger{" +
                "singerName='" + singerName + '\'' +
                ", singerGender='" + singerGender + '\'' +
                ", singerTitle='" + singerTitle + '\'' +
                '}';
    }
}
