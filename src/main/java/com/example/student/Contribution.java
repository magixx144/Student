package com.example.student;
/*
Copyright (C) [2023] [Kehao Lyu]
This code is owned and solely developed by [Kehao Lyu]. Any unauthorized copying, usage, modification, or distribution of this software is strictly prohibited without the written permission of [Kehao Lyu].
@Kuangxiaokao
*/

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.ArrayList;

public class Contribution {
    private SimpleIntegerProperty contributionNumber;
    private SimpleStringProperty contribution;
    private SimpleIntegerProperty semester;
    private SimpleStringProperty detail;

    public Contribution(int contributionNumber, String contribution, int semester, String detail) {
        this.contributionNumber = new SimpleIntegerProperty(contributionNumber);
        this.contribution = new SimpleStringProperty(contribution);
        this.semester = new SimpleIntegerProperty(semester);
        this.detail = new SimpleStringProperty(detail);
    }

    public int getContributionNumber() {
        return contributionNumber.get();
    }

    public void setContributionNumber(int contributionNumber) {
        this.contributionNumber.set(contributionNumber);
    }

    public SimpleIntegerProperty contributionNumberProperty() {
        return contributionNumber;
    }

    public String getContribution() {
        return contribution.get();
    }

    public void setContribution(String contribution) {
        this.contribution.set(contribution);
    }

    public SimpleStringProperty contributionProperty() {
        return contribution;
    }

    public int getSemester() {
        return semester.get();
    }

    public void setSemester(int semester) {
        this.semester.set(semester);
    }

    public SimpleIntegerProperty semesterProperty() {
        return semester;
    }

    public String getDetail() {
        return detail.get();
    }

    public void setDetail(String detail) {
        this.detail.set(detail);
    }

    public SimpleStringProperty detailProperty() {
        return detail;
    }

    @Override
    public String toString() {
        return "Contribution{" +
                "contributionNumber=" + contributionNumber +
                ", contribution='" + contribution + '\'' +
                ", semester=" + semester +
                ", detail='" + detail + '\'' +
                '}';
    }

    public static ArrayList<Contribution> fromContributionReader(ContributionReader contributionReader) {
        ArrayList<Contribution> contributions = new ArrayList<>();
        ArrayList<Integer> contributionNumberList = contributionReader.getContributionNumberList();
        ArrayList<String> contributionList = contributionReader.getContributionList();
        ArrayList<Integer> semesterList = contributionReader.getSemesterList();
        ArrayList<String> detailList = contributionReader.getDetailList();

        for (int i = 0; i < contributionNumberList.size(); i++) {
            int contributionNumber = contributionNumberList.get(i);
            String contribution = contributionList.get(i);
            int semester = semesterList.get(i);
            String detail = detailList.get(i);
            Contribution contributionObj = new Contribution(contributionNumber, contribution, semester, detail);
            contributions.add(contributionObj);
        }

        return contributions;
    }
}
