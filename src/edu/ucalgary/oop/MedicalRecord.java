package edu.ucalgary.oop;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MedicalRecord{
     private Location location;
     private String treatmentDetails;
     private String dateOfTreatment;
     public MedicalRecord(Location location, String treatmentDetails, String dateOfTreatment){
          this.setLocation(location);
          this.setTreatmentDetails(treatmentDetails);
          this.setDateOfTreatment(dateOfTreatment);
     }
     public Location getLocation(){
          return location;
     }
     public void setLocation(Location location){
          this.location = location;
     }
     public String getTreatmentDetails(){
               if (treatmentDetails == null || treatmentDetails.isEmpty()) {
                  throw new IllegalArgumentException("Treatment details is empty.");
               }else{
                   return treatmentDetails;
               }

     }
     public void setTreatmentDetails(String treatmentDetails){
          this.treatmentDetails = treatmentDetails;
     }
     public String getDateOfTreatment(){
          return dateOfTreatment;
     }
     public void setDateOfTreatment(String dateOfTreatment){
          if(isValidDateFormat(dateOfTreatment)){
               this.dateOfTreatment = dateOfTreatment;
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
}
