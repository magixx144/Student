package com.example.student;

/**
 * @Author Magixx
 * @Date 2023 04 18 22 44
 **/
public class CourseTxtObj {
    private String username;//key value
    private String interactiveMediaDesign;//state
    private String telecommunicationSystem;
    private String internetProtocol;
    private String travelTheWorldTogether;
    private String imageAndVideoProcessing;
    private String careerPlaning;

    public String getUsername(){
        return username;
    }
    public String getInteractiveMediaDesign(){
        return interactiveMediaDesign;
    }
    public String getTelecommunicationSystem(){
        return telecommunicationSystem;
    }
    public String getInternetProtocol(){
        return internetProtocol;
    }
    public String getTravelTheWorldTogether(){
        return travelTheWorldTogether;
    }
    public String getImageAndVideoProcessing(){
        return imageAndVideoProcessing;
    }
    public String getCareerPlaning(){
        return careerPlaning;
    }

    public void setCareerPlaning(String careerPlaning) {
        this.careerPlaning = careerPlaning;
    }

    public void setImageAndVideoProcessing(String imageAndVideoProcessing) {
        this.imageAndVideoProcessing = imageAndVideoProcessing;
    }

    public void setInteractiveMediaDesign(String interactiveMediaDesign) {
        this.interactiveMediaDesign = interactiveMediaDesign;
    }

    public void setInternetProtocol(String internetProtocol) {
        this.internetProtocol = internetProtocol;
    }

    public void setTelecommunicationSystem(String telecommunicationSystem) {
        this.telecommunicationSystem = telecommunicationSystem;
    }

    public void setTravelTheWorldTogether(String travelTheWorldTogether) {
        this.travelTheWorldTogether = travelTheWorldTogether;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public CourseTxtObj(){
        super();
    }
}
