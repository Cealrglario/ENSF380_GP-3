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
        if(isValidDateFormat(dateOfInquiry)){
        this.dateOfInquiry = dateOfInquiry;
          }else{
            throw new IllegalArgumentException("invalid date format");   
          }
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

    private boolean isValidDateFormat(String date){
          String regex = "^\\d{4}-\\d{2}-\\d{2}$";
          Pattern myPattern = Pattern.compile(regex);
          Matcher myMatcher = myPattern.matcher(date);
          return myMatcher.matches();
     }

    String getLogDetails()   
}