package com.example.student;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class GradeReader {
    private ArrayList<Integer> courseNumberList;
    private ArrayList<String> courseList;
    private ArrayList<Integer> semesterList;
    private ArrayList<Integer> gradeList;

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

    private ArrayList<Double> creditList;
    private ArrayList<Double> CourseGPAList;


    public GradeReader(String filename) throws FileNotFoundException {

        courseNumberList = new ArrayList<>();
        courseList = new ArrayList<>();
        semesterList = new ArrayList<>();
        gradeList = new ArrayList<>();
        creditList = new ArrayList<>();
        CourseGPAList = new ArrayList<>();

        File file = new File(filename);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] fields = line.split(",");

            int courseNumber = Integer.parseInt(fields[0]);
            String course = fields[1];
            int semester = Integer.parseInt(fields[2]);
            int grade = Integer.parseInt(fields[3]);
            double credit = Double.parseDouble(fields[4]);

            courseNumberList.add(courseNumber);
            courseList.add(course);
            semesterList.add(semester);
            gradeList.add(grade);
            creditList.add(credit);
            for (int i = 0; i < courseNumberList.size(); i++) {
                courseGPACalculate(i);
            }
        }

        scanner.close();
}

    public double courseGPACalculate(int index) {
        int grade = gradeList.get(index);
        if (grade >= 60) {
            double gpa = 4 - 3 * Math.pow(100 - grade, 2) / 1600;
            CourseGPAList.add(gpa);
            return gpa;
        } else {
            return 0;
        }

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


