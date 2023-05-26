package com.example.student.Test;

import com.example.student.ContributionReader;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class ContributionReaderTest {
    private ContributionReader contributionReader;
//    File file = new File("");
//    String path = file.getCanonicalPath();
//    //相对路径，勿改动
//
//    public String paths=path+"/info/Contribution.txt";

    public ContributionReaderTest() throws IOException {
    }

    @Before
    public void setUp() throws Exception {
        String currentPath = new File("").getCanonicalPath();
        String filePath = currentPath + "\\info\\Contribution.txt";
        System.out.println(filePath);
        contributionReader = new ContributionReader(filePath);
    }

    @Test
    public void testContributionNumberList() {
        // use the correct values from the test file
        assertEquals(new ArrayList<>(Arrays.asList(1, 2, 3, 4)), contributionReader.getContributionNumberList());
    }

    @Test
    public void testContributionList() {
        // use the correct values from the test file
        assertEquals(new ArrayList<>(Arrays.asList("Resident Advisor", "Club President", "Peer Tutor", "Event Coordinator")), contributionReader.getContributionList());
    }

    @Test
    public void testSemesterList() {
        // use the correct values from the test file
        assertEquals(new ArrayList<>(Arrays.asList(1, 2, 3, 4)), contributionReader.getSemesterList());
    }

    @Test
    public void testDetailList() {
        // use the correct values from the test file
        assertEquals(new ArrayList<>(Arrays.asList("Excellent", "Good", "Good","Fair")), contributionReader.getDetailList());
    }
}
