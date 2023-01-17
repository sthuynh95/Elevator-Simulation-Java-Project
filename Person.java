package elevator_project;
/**
 * Person.java Class
 * Known bugs:
 *
 * @author Simon Huynh
 * sthuynh@brandeis.edu
 * January 9th, 2023
 */
public class Person {

    private String firstName;
    private String lastName;

    private Building building;

    private int location; // track this Person floor location

    public String getFirstName() {
        return firstName;
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

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public Person(String firstName, String lastName){
        // construct a person with a given first and last names
        setFirstName(firstName);
        setLastName(lastName);
        setLocation(-1); // initialize this Person's location

    }

    public boolean enterBuilding(Building building, int floor){
        // enter this Person into a Building's Elevator with a desired floor number
        // return true if Person can reach the desired floor number in this Building
        // otherwise, return false
        boolean isJobValid;
        int numFloors = building.getNumFloors();
        setBuilding(building); // set this Person building to reference later

        isJobValid = 0 < floor && floor <= numFloors; // if the desired floor is between 1 and numFloors, then true.
        // if the Job is valid, send the request to the Building's Elevator
        if(isJobValid){ //enterElevatorRequest()
            building.enterElevatorRequest(this, floor); // enter this Person request to the Elevator
        }
        else{ // if Job is not valid, enter the person to the Lobby
            building.getFloors()[0].enterFloor(this);
            // update the person location
            this.location = 0;
        }

        return isJobValid;
    }

    public String getLocation(){
        // return this Person's location
        String message = "";
        if(this.location == -1){
            message = message + "Waiting to be serviced";
        }
        else if(this.location == 0){
            message = message + "In Lobby";
        }
        else{
            message = message + "In Floor " + this.location;
        }
        return message;
    }
}
