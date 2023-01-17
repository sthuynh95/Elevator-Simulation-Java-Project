package elevator_project;
/**
 * Job.java Class
 * Known bugs:
 *
 * @author Simon Huynh
 * sthuynh@brandeis.edu
 * January 9th, 2023
 */
public class Job {

    // Primary purpose: store requests for elevator to service
    // each request contains a Person and their desired floor to be taken to
    private Person person;
    private int floor;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public Job(Person person, int floor){
        setPerson(person);
        setFloor(floor);
    }
}
