package com.chenjw.demo.onJava8.lambda;

public class SingerJunitTest {


    public static void main(String[] args) {

        SingingFactory<DenglijunSinger> singerFactory = DenglijunSinger::new;

        Singer denglijun = singerFactory.create("邓丽君", "女", "《甜蜜蜜》");

        System.out.println(denglijun);


        SingingHandler singingHandler = denglijun::singing;
        singingHandler.singing(denglijun.singerName);

    }
}
