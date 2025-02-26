package edu.ucalgary.oop;

import java.util.ArrayList;
import java.util.Arrays;

public class Location {
    private String name;
    private String address;
    private DisasterVictim[] occupants;
    private Supply[] supplies;

    public Location(String name, String address){
        this.name = name;
        this.address = address;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public DisasterVictim[] getOccupants(){
        return occupants;
    }

    public void setOccupants(DisasterVictim[] occupants){
        this.occupants = occupants;
    }

    public Supply[] getSupplies(){
        return supplies;
    }

    public void setSupplies(Supply[] supplies){
        this.supplies = supplies;
    }

    public void addOccupant(DisasterVictim occupant){
        if (occupants != null){
           ArrayList<DisasterVictim> temporaryList = new ArrayList<>(Arrays.asList(this.occupants));
           temporaryList.add(occupant);

           occupants = temporaryList.toArray(new DisasterVictim[0]);
        } else {
            occupants = new DisasterVictim[]{occupant};
        }
    }

    public void removeOccupant(DisasterVictim occupant){
        if (occupants != null){
            ArrayList<DisasterVictim> temporaryList = new ArrayList<>(Arrays.asList(this.occupants));
            temporaryList.remove(occupant);
 
            occupants = temporaryList.toArray(new DisasterVictim[0]);
         } else {
             return;
         }
    }

    public void addSupply(Supply supply){
        if (supplies != null){
            ArrayList<Supply> temporaryList = new ArrayList<>(Arrays.asList(this.supplies));
            temporaryList.add(supply);
 
            supplies = temporaryList.toArray(new Supply[0]);
         } else {
             supplies = new Supply[]{supply};
         }
    }

    public void removeSupply(Supply supply){
        if (supplies != null){
            ArrayList<Supply> temporaryList = new ArrayList<>(Arrays.asList(this.supplies));
            temporaryList.remove(supply);
 
            supplies = temporaryList.toArray(new Supply[0]);
         } else {
             return;
         }
    }
}
