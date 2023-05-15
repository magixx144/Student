package com.example.student;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContributionReader {
    private String username;
    private ArrayList<Integer> contributionNumberList;
    private ArrayList<String> contributionList;
    private ArrayList<Integer> semesterList;
    private ArrayList<String> detailList;
    File file = new File("");
    String path = file.getCanonicalPath();
    //相对路径，勿改动

    public String paths=path+"/Student/info/temp.txt";

    public ContributionReader(String filename) throws IOException {
        contributionNumberList = new ArrayList<>();
        contributionList = new ArrayList<>();
        semesterList = new ArrayList<>();
        detailList = new ArrayList<>();

        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        List userinfo=User.readTxts(paths);
        Object[] o=userinfo.toArray();
        LoginTxtObject user=(LoginTxtObject) o[0];
        username=user.getUsername();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] data = line.split(";");
            if(data[0].equals(username)){
                String[] skillInfo=data[1].split("/");
                for(int i=0;i<skillInfo.length;i++){
                    int semester = Integer.parseInt(skillInfo[i].split(",")[0]);
                    int contributionNumber = Integer.parseInt(skillInfo[i].split(",")[1]);
                    String contribution = skillInfo[i].split(",")[2];
                    String detail = skillInfo[i].split(",")[3];
                    semesterList.add(semester);
                    contributionNumberList.add(contributionNumber);
                    contributionList.add(contribution);
                    detailList.add(detail);
                }
                break;
            }

        }

        scanner.close();
    }

    // Getter methods for accessing the ArrayLists

    public ArrayList<Integer> getContributionNumberList() {
        return contributionNumberList;
    }

    public ArrayList<String> getContributionList() {
        return contributionList;
    }

    public ArrayList<Integer> getSemesterList() {
        return semesterList;
    }

    public ArrayList<String> getDetailList() {
        return detailList;
    }
}
