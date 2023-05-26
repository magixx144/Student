package com.example.student.Test;

import com.example.student.Grade;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GradeTest {
    private Grade grade;

    @Before
    public void setUp() {
        grade = new Grade(1, "Mathematics", 1, 90, 4.0, 3.7);
    }

    @Test
    public void testCourseNumber() {
        assertEquals(1, grade.getCourseNumber());
        grade.setCourseNumber(2);
        assertEquals(2, grade.getCourseNumber());
    }

    @Test
    public void testCourseName() {
        assertEquals("Mathematics", grade.getCourseName());
        grade.setCourseName("Physics");
        assertEquals("Physics", grade.getCourseName());
    }

    @Test
    public void testSemester() {
        assertEquals(1, grade.getSemester());
        grade.setSemester(2);
        assertEquals(2, grade.getSemester());
    }

    @Test
    public void testGrade() {
        assertEquals(90, grade.getGrade());
        grade.setGrade(95);
        assertEquals(95, grade.getGrade());
    }

    @Test
    public void testCredit() {
        assertEquals(4.0, grade.getCredit(), 0.001);
        grade.setCredit(3.0);
        assertEquals(3.0, grade.getCredit(), 0.001);
    }

    @Test
    public void testCourseGPA() {
        assertEquals(3.7, grade.getCourseGPA(), 0.001);
        grade.setCourseGPA(3.8);
        assertEquals(3.8, grade.getCourseGPA(), 0.001);
    }
}
