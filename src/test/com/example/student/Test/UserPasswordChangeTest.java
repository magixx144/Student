package com.example.student.Test;


import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class UserPasswordChangeTest {
    File file = new File("");
    String path = file.getCanonicalPath();
    //相对路径，勿改动

    public String paths=path+"/Student/info/stuinfo.txt";

    public UserPasswordChangeTest() throws IOException {
    }

    @Test
    void init() {
        ArrayList<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(paths))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] expectedLines = lines.toArray(new String[0]);

        // Print the contents
        for (String line : expectedLines) {
            String[] userInfo = line.split(",");
            System.out.println(userInfo[0] + "," + userInfo[1] + "," + userInfo[2] + "," + userInfo[3]);
        }

        // Compare the expected lines with the file contents
        assertArrayEquals(expectedLines, lines.toArray());
    }
}
