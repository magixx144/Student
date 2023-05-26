package com.example.student.Test;

import com.example.student.GPAReader;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class GPAReaderTest {
    private GPAReader gpaReader;
    File file = new File("");
    String path = file.getCanonicalPath();
    //相对路径，勿改动

    public String paths=path+"/Student/info/GPA.txt";

    public GPAReaderTest() throws IOException {
    }

    @Before
    public void setUp() throws Exception {
        gpaReader = new GPAReader(paths);
    }

    @Test
    public void testCourseNumberList() {
        // use the correct values from the test file
        assertEquals(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16)), gpaReader.getCourseNumberList());
    }

    // similarly add tests for courseList, semesterList, gradeList, creditList, CourseGPAList

    @Test
    public void testCalculateWeightedAverage() {
        // use the correct values from the test file
        assertEquals(78.26923076923077, gpaReader.calculateWeightedAverage(1), 0.001);
    }

    // similarly add tests for calculateWeightedGPA, calculateSimpleAverage, calculateSimpleGPA
}