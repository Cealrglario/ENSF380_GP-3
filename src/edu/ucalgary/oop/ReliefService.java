package edu.ucalgary.oop;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReliefService {
    private Inquirer inquirer;
    private DisasterVictim missingPerson;
    private String dateOfInquiry;
    private String infoProvided;
    private Location lastKnownLocation;  

    public ReliefService(Inquirer inquirer, DisasterVictim missingPerson, String dateOfInquiry, String infoProvided, Location lastKnownLocation) {
        setInquirer(inquirer);
        setMissingPerson(missingPerson);
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

    public DisasterVictim getMissingPerson(){
        return missingPerson;
    }

    public void setMissingPerson(DisasterVictim missingPerson){
        this.missingPerson = missingPerson;
    }

    public String getDateOfInquiry(){
        return dateOfInquiry;
    }
    
    public void setDateOfInquiry(String dateOfInquiry) {
        if(isValidDateFormat(dateOfInquiry)){
        this.dateOfInquiry = dateOfInquiry;
          }else{
            throw new IllegalArgumentException("invalid date format");   
          }
    }

    private boolean isValidDateFormat(String date){
          String regex = "^\\d{4}-\\d{2}-\\d{2}$";
          Pattern myPattern = Pattern.compile(regex);
          Matcher myMatcher = myPattern.matcher(date);
          return myMatcher.matches();
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

    public void setLastKnownLocation(Location lastKnownLocation ){
        this.lastKnownLocation = lastKnownLocation;
    }

    public String getLogDetails() {
        return String.format("Inquirer: %s, Missing Person: %s, Date of Inquiry: %s, Info Provided: %s, Last Known Location: %s",
                inquirer.getFirstName(), 
                missingPerson.getName(), 
                dateOfInquiry, 
                infoProvided, 
                lastKnownLocation.getName());
    }
}