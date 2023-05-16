package com.example.student;

import java.util.ArrayList;
import java.util.List;
/*
Copyright (C) [2023] [Kehao Lyu]
This code is owned and solely developed by [Kehao Lyu]. Any unauthorized copying, usage, modification, or distribution of this software is strictly prohibited without the written permission of [Kehao Lyu].
@Kuangxiaokao
*/

public class Grade {
    private int courseNumber;
    private String courseName;
    private int semester;
    private int grade;
    private double credit;
    private double CourseGPA;

    public Grade(int courseNumber, String courseName, int semester, int grade, double credit, double CourseGPA) {
        this.courseNumber = courseNumber;
        this.courseName = courseName;
        this.semester = semester;
        this.grade = grade;
        this.credit = credit;
        this.CourseGPA = CourseGPA;

    }

    public int getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(int courseNumber) {
        this.courseNumber = courseNumber;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public double getCourseGPA() {
        return CourseGPA;
    }

    public void setCourseGPA(double CourseGPA) {
        this.CourseGPA = CourseGPA;
    }


    @Override
    public String toString() {
        return "Course{" +
                "courseNumber=" + courseNumber +
                ", courseName='" + courseName + '\'' +
                ", semester=" + semester +
                ", grade=" + grade +
                ", credit=" + credit +
                ", courseGPA=" + CourseGPA +
                '}';
    }

    public static List<Grade> fromGradeReader(GPAReader reader) {
        List<Integer> courseNumberList = reader.getCourseNumberList();
        List<String> courseList = reader.getCourseList();
        List<Integer> semesterList = reader.getSemesterList();
        List<Integer> gradeList = reader.getGradeList();
        List<Double> creditList = reader.getCreditList();
        List<Double> CourseGPAList = reader.getCourseGPAList();
        List<Grade> gradeListOut = new ArrayList<>();
        for (int i = 0; i < courseNumberList.size(); i++) {
            int courseNumber = courseNumberList.get(i);
            String courseName = courseList.get(i);
            int semester = semesterList.get(i);
            int grade = gradeList.get(i);
            double credit = creditList.get(i);
            double CourseGPA = CourseGPAList.get(i);
            Grade course = new Grade(courseNumber, courseName, semester, grade, credit, CourseGPA);
            gradeListOut.add(course);
        }
        return gradeListOut;
    }
}
