package com.chenjw.review.strategy;

public class SeniorStudentGotoSchoolStrategy implements TheWayGotoSchool<SeniorStudent>{

    @Override
    public void goToSchoolByWhat(SeniorStudent seniorStudent) {
        System.out.println("高中生上学交通工具为："+ seniorStudent.getJtgjl());
    }
}
