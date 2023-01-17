package elevator_project;

import java.util.HashSet;
import java.util.Set;

/**
 * Building.java Class
 * Known bugs:
 *
 * @author Simon Huynh
 * sthuynh@brandeis.edu
 * January 9th, 2023
 */
public class Building {

    private int numFloors; // number of floors excluding the Lobby
    private Floor[] floors;
    private Elevator elevator;
    static int maxOccupant = 3; // initialize maxOccupant

    public int getNumFloors() {
        return numFloors;
    }

    public void setNumFloors(int numFloors) {
        this.numFloors = numFloors;
    }

    public Floor[] getFloors() {
        return floors;
    }

    public void setFloors(Floor[] floors) {
        this.floors = floors;
    }

    public Elevator getElevator() {
        return elevator;
    }

    public void setElevator(Elevator elevator) {
        this.elevator = elevator;
    }

    public static int getMaxOccupant() {
        return maxOccupant;
    }

    public static void setMaxOccupant(int maxOccupant) {
        Building.maxOccupant = maxOccupant;
    }

    public Building(int numFloors){
        // construct a building with the specify number of floors
        // a Building object should hold an array of Floors
        // and an instance of Elevator (at the Lobby)
        setNumFloors(numFloors);

        // create an array of Floors
        this.floors = new Floor[numFloors + 1]; // Floor0 is the Lobby, ...
        for(int i = 0; i < numFloors + 1; i++ ){
            Set<Person> floorRoster = new HashSet<Person>();
            this.floors[i] = new Floor(floorRoster);
        }
        this.elevator = new Elevator(this, this.maxOccupant);

    }

    /*public void createElevator(Building building){
        this.elevator = new Elevator(building, this.maxOccupant);
    }*/

    public boolean enterElevatorRequest(Person person, int floor){ // handle job request by a Person
        // if the Person's desired floor can be reached, return true
        // otherwise, if the request is invalid, return false; note: the Person will be sent to Lobby forever
        boolean isRequestValid;
        int numFloors = person.getBuilding().getNumFloors();

        isRequestValid = 0 < floor && floor <= numFloors;
        // if the request is valid, create a Job
        if(isRequestValid){
            this.elevator.createJob(person, floor);
        } // if the request is not valid, send the person to Lobby
        else{
            this.floors[0].enterFloor(person); // floor 0 is the Lobby
            person.setLocation(0);
        }

        return isRequestValid;
    }

    public void startElevator(){
        // call a method in the Elevator instance to process All current Jobs
        this.elevator.processAllJobs();
    }

    public void enterFloor(Person person, int floor){
        //save a reference of a Person in the floor with the provided floor number
        this.getFloors()[floor].enterFloor(person);
        // update the Person location
        person.setLocation(floor);
    }

}
