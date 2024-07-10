package com.chenjw.review.strategy;

public class LittleStudentGotoSchoolStrategy implements TheWayGotoSchool<LittleStudent>{
    @Override
    public void goToSchoolByWhat(LittleStudent littleStudent) {
        System.out.println("小学生上学交通工具为："+littleStudent.getJtgjl());
    }
}
