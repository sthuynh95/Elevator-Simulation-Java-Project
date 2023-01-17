package elevator_project;

import java.util.Set;

/**
 * Floor.java Class
 * Known bugs:
 *
 * @author Simon Huynh
 * sthuynh@brandeis.edu
 * January 9th, 2023
 */
public class Floor {

    // each floor has a Set of Person(s)
    private Set<Person> floorRoster;

    public Set<Person> getFloorRoster() {
        return floorRoster;
    }

    public void setFloorRoster(Set<Person> floorRoster) {
        this.floorRoster = floorRoster;
    }

    public Floor(Set<Person> floorRoster){
        this.floorRoster = floorRoster;
    }

    public void enterFloor(Person person){
        // save a reference of the Person within this Floor object
        //this.floorRoster.add(person); // enter person to the roster of that floor
        this.floorRoster.add(person);
    }

}
