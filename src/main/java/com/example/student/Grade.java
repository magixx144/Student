package com.example.student;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;



public class Grade {
    public static CourseTxtObj readCourse(String paths) throws Exception {  //把文件读成beans
        InputStreamReader isr = new InputStreamReader(new FileInputStream(paths), "UTF-8");
        BufferedReader br = new BufferedReader(isr);
        String line = null;
        int count = 0;
        CourseTxtObj course = new CourseTxtObj();
        HomeController user=new HomeController();
        LoginTxtObject curUser=user.initialize();

        while ((line = br.readLine()) != null) {

            String[] arr = line.split(",");

            if(curUser.getUsername().equals(arr[0])&&arr.length>6){
                course.setUsername(arr[0]);
                course.setInteractiveMediaDesign(arr[1]);
                course.setTelecommunicationSystem(arr[2]);
                course.setInternetProtocol(arr[3]);
                course.setTravelTheWorldTogether(arr[4]);
                course.setImageAndVideoProcessing(arr[5]);
                course.setCareerPlaning(arr[6]);
                break;
            }
            count++;

        }


        return course;
    }
}
