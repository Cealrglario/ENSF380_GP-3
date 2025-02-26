package edu.ucalgary.oop;

import java.util.Arrays;
import java.util.regex.*;

public class DisasterVictim {
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private final int ASSIGNED_SOCIAL_ID;
    private FamilyRelation[] familyConnections;
    private MedicalRecord[] medicalRecords;
    private Supply[] personalBelongings;
    private final String ENTRY_DATE;
    private String gender;
    private String comments;
    private static int counter = 0;

    public DisasterVictim(String firstName, String ENTRY_DATE) throws IllegalArgumentException {
        boolean isValidEntryDate = isValidDateFormat(ENTRY_DATE);

        if (!isValidEntryDate) {
            throw new IllegalArgumentException("Invalid entry date format.");
        } else {
            this.firstName = firstName;
            this.ENTRY_DATE = ENTRY_DATE;
            this.ASSIGNED_SOCIAL_ID = generateSocialID();
        }
    }

    public DisasterVictim(String firstName, String ENTRY_DATE, String dateOfBirth) throws IllegalArgumentException {
        boolean isValidDate = isValidDateFormat(dateOfBirth);
        boolean isValidEntryDate = isValidDateFormat(ENTRY_DATE);

        if (!isValidDate || !isValidEntryDate) {
            throw new IllegalArgumentException("Invalid date format.");
        } else {
            int intEntryDate = convertDateStringToInt(ENTRY_DATE);
            int intBirthDate = convertDateStringToInt(dateOfBirth);

            if (intEntryDate < intBirthDate) {
                throw new IllegalArgumentException("Entry date is earlier than birth date.");
            } else {
                this.firstName = firstName;
                this.ENTRY_DATE = ENTRY_DATE;
                this.dateOfBirth = dateOfBirth;
                this.ASSIGNED_SOCIAL_ID = generateSocialID();
            }
        }
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) throws IllegalArgumentException {
        boolean isValidDate = isValidDateFormat(dateOfBirth);

        if (!isValidDate) {
            throw new IllegalArgumentException("Invalid date format.");
        } else {
            this.dateOfBirth = dateOfBirth;
        }
    }

    public FamilyRelation[] getFamilyConnections() {
        return familyConnections;
    }

    public void setFamilyConnections(FamilyRelation[] familyConnections) {
        this.familyConnections = familyConnections;
    }

    public MedicalRecord[] getMedicalRecords() {
        return medicalRecords;
    }

    public void setMedicalRecords(MedicalRecord[] medicalRecords) {
        this.medicalRecords = medicalRecords;
    }

    public Supply[] getPersonalBelongings() {
        return personalBelongings;
    }

    public void setPersonalBelongings(Supply[] personalBelongings) {
        this.personalBelongings = personalBelongings;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) throws IllegalArgumentException {
        boolean isValidGender = isValidGender(gender);

        if (!isValidGender) {
            throw new IllegalArgumentException("Invalid gender.");
        } else {
            this.gender = gender;
        }
    }

    public int getAssignedSocialID() {
        return ASSIGNED_SOCIAL_ID;
    }

    public String getEntryDate() {
        return ENTRY_DATE;
    }

    private static int generateSocialID() {
        counter++;
        return counter;
    }

    private static boolean isValidDateFormat(String date) {
        Pattern validDate = Pattern.compile("^[0-9]{4}-[0-9]{2}-[0-9]{2}$");
        Matcher checkDate = validDate.matcher(date);
        return checkDate.matches();
    }

    private static int convertDateStringToInt(String dateStr) {
        String dateNumberOnly = "";
        String[] splitDates = dateStr.split("-");

        for(String date : splitDates) {
            dateNumberOnly += date;
        }
        return Integer.parseInt(dateNumberOnly);
    }

    private boolean isValidGender(String gender) {
        Pattern validGender = Pattern.compile("male|female");
        Matcher checkGender = validGender.matcher(gender);
        return checkGender.matches();
    }

    public void addPersonalBelonging(Supply supply) {
        if (personalBelongings != null) {
            Supply[] newPersonalBelongings = Arrays.copyOf(personalBelongings, personalBelongings.length + 1);
            newPersonalBelongings[newPersonalBelongings.length - 1] = supply;

            this.personalBelongings = newPersonalBelongings;
        } else {
            Supply[] newPersonalBelongings = new Supply[1];
            newPersonalBelongings[0] = supply;
            this.personalBelongings = newPersonalBelongings;
        }
    }

    public void removePersonalBelonging(Supply unwantedSupply) {
        if (personalBelongings != null) {
            Supply[] newPersonalBelongings = new Supply[personalBelongings.length - 1];

            for (int i = 0, j = 0; i < personalBelongings.length; i++) {
                if (personalBelongings[i] != unwantedSupply) {
                    newPersonalBelongings[j] = personalBelongings[i];
                    j++;
                }
            }

            this.personalBelongings = newPersonalBelongings;
        }
    }

    public void removeFamilyConnection(FamilyRelation exRelation) {
        if (familyConnections != null) {
            FamilyRelation[] newFamilyConnections = new FamilyRelation[familyConnections.length - 1];

            for (int i = 0, j = 0; i < familyConnections.length; i++) {
                if (familyConnections[i] != exRelation) {
                    newFamilyConnections[j] = familyConnections[i];
                    j++;
                }
            }

            this.familyConnections = newFamilyConnections;
        }
    }

    public void addFamilyConnection(FamilyRelation relation) {
        if (familyConnections != null) {
            FamilyRelation[] newFamilyConnections = Arrays.copyOf(familyConnections, familyConnections.length + 1);
            newFamilyConnections[newFamilyConnections.length - 1] = relation;

            this.familyConnections = newFamilyConnections;
        } else {
            FamilyRelation[] newFamilyConnections = new FamilyRelation[1];
            newFamilyConnections[0] = relation;
            this.familyConnections = newFamilyConnections;
        }
    }

    public void addMedicalRecord(MedicalRecord record) {
        if (medicalRecords != null) {
            MedicalRecord[] newMedicalRecords = Arrays.copyOf(medicalRecords, medicalRecords.length + 1);
            newMedicalRecords[medicalRecords.length - 1] = record;

            this.medicalRecords = newMedicalRecords;
        } else {
            MedicalRecord[] newMedicalRecords = new MedicalRecord[1];
            newMedicalRecords[0] = record;
            this.medicalRecords = newMedicalRecords;
        }
    }


}
