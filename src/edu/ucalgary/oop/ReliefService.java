package edu.ucalgary.oop;

public class ReliefService {
    private Inquirer inquirer;
    private DisasterVictim missingPerson;
    private String dateOfInquiry;
    private String infoProvided;
    private Location lastKnownLocation;  

    public void ReliefService(Inquirer inquirer, DisasterVictim missingPerson, String dateOfInquiry, String infoProvided, Location lastKnownLocation) {
        setInquirer(inquirer);
        setDisasterVictim(missingPerson);
        setDateOfInquiry(dateOfInquiry);
        setInfoProvided(infoProvided);
        setLastKnownLocation(lastKnownLocation);
    }

    public Inquirer getInquirer(){
        return inquirer;
    }

    public void setInquirer(Inquirer inquirer){
        this.inquirer = inquirer;
    }

    public DisasterVictim getDisasterVictim(){
        return missingPerson;
    }

    public void setDisasterVictim(DisasterVictim missingPerson){
        this.missingPerson = missingPerson;
    }

    public String getDateOfInquiry(){
        return dateOfInquiry;
    }
    
    public void setDateOfInquiry(String dateOfInquiry) {
        this.dateOfInquiry = dateOfInquiry;
    }

    public String getInfoProvided(){
        return infoProvided;
    }

    public void setInfoProvided(String infoProvided){
        this.infoProvided = infoProvided;
    }

    public Location getLastKnownLocation(){
        return lastKnownLocation;
    }

    public void getLastKnownLocation(Location lastKnownLocation ){
        this.lastKnownLocation = lastKnownLocation;
    }

    boolean isValidDateFormat(String date)

    String getLogDetails()   
}