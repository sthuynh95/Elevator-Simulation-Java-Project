package elevator_project;
/**
 * Simulation.java Class
 * Known bugs:
 *
 * @author Simon Huynh
 * sthuynh@brandeis.edu
 * January 9th, 2023
 */
public class Simulation {
    // run the Elevator Simulation
    // only use this class to construct Person and Building objects
    // should *not* interact with the Elevator class at all

    // construct a Building object named Costco
    public static void main(String[] args){

        // create a test Person(s)
        Person Micah = new Person("Micah","Graff");
        Person Ray = new Person("Ray","Maresca");
        Person Anna = new Person("Anna","Kolb");
        Person Lilah = new Person("Lilah","Graff");
        Person Hannah = new Person("Hannah","Graff");
        Person Xinran = new Person("Xinran", "Niu");
        //System.out.println(Micah.getFirstName());
        //System.out.println(Micah.getLastName());


        // create a test Building
        Building Costco = new Building(4);
        //Costco.createElevator(Costco); // create an elevator in the building

        //System.out.println(Costco.getFloors().length); // we have a floor with Length 5
        //System.out.println(Costco); // we have a building named Costco
        //System.out.println(Costco.getElevator()); // we have an elevator in Costco
        //System.out.println(Costco.getElevator().getBuilding()); // the elevator is in Costco
        //System.out.println(Costco.getElevator().getJobs()); // the elevator have an array of Job(s)
        //System.out.println(Costco.getElevator().getJobs().length); // max number of Jobs i.e. maxOccupant
        //System.out.println(Costco.getElevator().getLocation()); // the elevator location is 0 i.e. Lobby

        // enter Person(s) into the Building's Elevator with enterBuilding method
        Micah.enterBuilding(Costco,3); // enter Micah into Costco with a desired floor
        Xinran.enterBuilding(Costco,-5);
        Anna.enterBuilding(Costco,9); // there is no floor 9
        Lilah.enterBuilding(Costco,2);
        Ray.enterBuilding(Costco,4); // invalid
        Hannah.enterBuilding(Costco,1); // over the capacity of the elevator
        //System.out.println(Costco.getElevator().getJobs()[0]);
        //System.out.println(Costco.getElevator().getJobs()[1]);
        //System.out.println(Costco.getElevator().getJobs().length);

        // ready to activate the elevator
        Costco.startElevator();

        // check the results
        // where is Ray?
        System.out.println("Ray is " + Ray.getLocation());
        // where is Micah?
        System.out.println("Micah is " + Micah.getLocation());
        // where is Hannah?
        System.out.println("Hannah is " + Hannah.getLocation());
        // where is Lilah?
        System.out.println("Lilah is " + Lilah.getLocation());
        // where is Anna?
        System.out.println("Anna is " + Anna.getLocation());
        // where is Xinran?
        System.out.println("Xinran is " + Xinran.getLocation());

    }

}
