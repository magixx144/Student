package com.example.student;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author Magixx
 * @Date 2023 05 15 19 45
 **/
/*
Copyright (C) [2023] [Kehao Lyu]
This code is owned and solely developed by [Kehao Lyu]. Any unauthorized copying, usage, modification, or distribution of this software is strictly prohibited without the written permission of [Kehao Lyu].
@Kuangxiaokao
*/
public class GPAReader {
    private String username;
    private ArrayList<Integer> courseNumberList;
    private ArrayList<String> courseList;
    private ArrayList<Integer> semesterList;
    private ArrayList<Integer> gradeList;
    private ArrayList<Double> creditList;
    private ArrayList<Double> CourseGPAList;
    File file = new File("");
    String path = file.getCanonicalPath();
    //相对路径，勿改动

    public String paths=path+"/Student/info/temp.txt";

    public String getUsername() {
        return username;
    }

    public ArrayList<Integer> getCourseNumberList() {
        return courseNumberList;
    }

    public ArrayList<String> getCourseList() {
        return courseList;
    }

    public ArrayList<Integer> getSemesterList() {
        return semesterList;
    }

    public ArrayList<Integer> getGradeList() {
        return gradeList;
    }

    public ArrayList<Double> getCreditList() {
        return creditList;
    }

    public GPAReader(String filename) throws IOException {
        courseNumberList = new ArrayList<>();
        courseList = new ArrayList<>();
        semesterList = new ArrayList<>();
        gradeList = new ArrayList<>();
        creditList = new ArrayList<>();
        CourseGPAList = new ArrayList<>();

        File file= new File(filename);
        Scanner scanner = new Scanner(file);
        List userinfo=User.readTxts(paths);
        Object[] o=userinfo.toArray();
        LoginTxtObject user=(LoginTxtObject) o[0];
        username=user.getUsername();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] fields = line.split(";");
            if(fields[0].equals(username)){
                String[] gradeInfo=fields[1].split("/");
                for(int i=0;i<gradeInfo.length;i++){
                    int courseNumber = Integer.parseInt(gradeInfo[i].split(",")[0]);
                    String course=gradeInfo[i].split(",")[1];
                    int semester = Integer.parseInt(gradeInfo[i].split(",")[2]);
                    int grade = Integer.parseInt(gradeInfo[i].split(",")[3]);
                    double credit = Double.parseDouble(gradeInfo[i].split(",")[4]);
                    courseNumberList.add(courseNumber);
                    courseList.add(course);
                    semesterList.add(semester);
                    gradeList.add(grade);
                    creditList.add(credit);
                }
                for (int j = 0; j < courseNumberList.size(); j++) {
                    CourseGPAList.add(courseGPACalculate(j));
                }
                scanner.close();
                break;
            }
        }
    }
    public double courseGPACalculate(int index) {
        int grade = gradeList.get(index);
        double gpa;
        if (grade >= 60) {
            gpa = 4 - 3 * Math.pow(100 - grade, 2) / 1600;
        } else {
            gpa = 0;
        }
        return gpa;
    }
    public ArrayList<Double>getCourseGPAList(){

        return CourseGPAList;
    }

    public void judgeSemester(int semester) {
        System.out.println("Semester " + semester + " courses:");

        for (int i = 0; i < courseNumberList.size(); i++) {
            if (semesterList.get(i) == semester) {
                System.out.println("Course Number: " + courseNumberList.get(i) + ", Course: " + courseList.get(i) + ", Semester: " + semesterList.get(i) + ", Grade: " + gradeList.get(i) + ", Credit: " + creditList.get(i) + ", GPA: " + courseGPACalculate(i));
            }
        }
    }

    public double calculateWeightedAverage(int semester) {
        double totalGradeCredits = 0;
        double totalCredits = 0;

        for (int i = 0; i < courseNumberList.size(); i++) {
            if (semesterList.get(i) == semester) {
                int grade = gradeList.get(i);
                double credit = creditList.get(i);
                totalGradeCredits += grade * credit;
                totalCredits += credit;
            }
        }

        if (totalCredits == 0) {
            return 0;
        } else {
            System.out.println("In the Semester:"+semester+"totalGradeCredits:"+ totalGradeCredits / totalCredits);
            return totalGradeCredits / totalCredits;

        }
    }
    public double calculateWeightedGPA(int semester) {
        double totalGPACredits = 0;
        double totalCredits = 0;

        for (int i = 0; i < courseNumberList.size(); i++) {
            if (semesterList.get(i) == semester) {
                double gpa = courseGPACalculate(i);
                double credit = creditList.get(i);
                totalGPACredits += gpa * credit;
                totalCredits += credit;
            }
        }

        if (totalCredits == 0) {
            return 0;
        } else {
            System.out.println("In the Semester:"+semester+"totalGradeCredits:"+ totalGPACredits / totalCredits);
            return totalGPACredits / totalCredits;
        }
    }

    public double calculateSimpleAverage(int semester) {
        int totalGrades = 0;
        int numCourses = 0;

        for (int i = 0; i < courseNumberList.size(); i++) {
            if (semesterList.get(i) == semester) {
                int grade = gradeList.get(i);
                totalGrades += grade;
                numCourses++;
            }
        }

        if (numCourses == 0) {
            return 0;
        } else {
            return (double) totalGrades / numCourses;
        }
    }

    public double calculateSimpleGPA(int semester) {
        double totalGPA = 0;
        int numCourses = 0;

        for (int i = 0; i < courseNumberList.size(); i++) {
            if (semesterList.get(i) == semester) {
                double gpa = courseGPACalculate(i);
                totalGPA += gpa;
                numCourses++;
            }
        }

        if (numCourses == 0) {
            return 0;
        } else {
            return totalGPA / numCourses;
        }
    }
}
