package elevator_project;
/**
 * Elevator.java Class
 * Known bugs:
 *
 * @author Simon Huynh
 * sthuynh@brandeis.edu
 * January 9th, 2023
 */
public class Elevator {
    // jobs are handle first-come-first-serve
    static int maxOccupant;
    private Job[] jobs;
    private Building building;
    private int location; // keep track of the elevator location
    private Person[] spaces;

    private int numRequests = 0;

    public static int getMaxOccupant() {
        return maxOccupant;
    }

    public static void setMaxOccupant(int maxOccupant) {
        Elevator.maxOccupant = maxOccupant;
    }

    public Job[] getJobs() {
        return jobs;
    }

    public void setJobs(Job[] jobs) {
        this.jobs = jobs;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public String getLocation() {
        String message = "";
        if(this.location == 0){
            message = message + "Elevator at Lobby";
        }
        else{
            message = message + "Elevator at Floor " + this.location;
        }

        return message;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public Person[] getSpaces() {
        return spaces;
    }

    public void setSpaces(Person[] spaces) {
        this.spaces = spaces;
    }

    public Elevator(Building building, int maxOccupants){ // freedom of parameters to use
        // construct an Elevator instance on the lobby with no current Jobs
        // max number of Jobs = maxOccupants
        this.maxOccupant = maxOccupants;
        this.jobs = new Job[0]; // array of Job(s) needed to get processed
        this.building = building;
        this.location = 0; // location 0 is the Lobby
    }

    public void createJob(Person person, int floor){
        //add new job to be completed by the Elevator given a Person and desired floor
        // create a new Job
        Job job = new Job(person, floor);
        // add this job to the Elevator
        // check whether the elevator can still take more request
        if(this.numRequests < this.maxOccupant){
            Job[] newJobs = new Job[this.jobs.length + 1];
            for(int i = 0; i < this.jobs.length; i++){ // move the current jobs to the new array
                newJobs[i] = this.jobs[i];
            }
            this.jobs = newJobs;
            this.jobs[this.numRequests] = job; // add the new job to jobs request
            this.numRequests ++; // increase the number of requests by 1
        }
        else{
            // need to be removed
            System.out.println("Elevator Max Capacity Reached!");
        }
    }

    public void processAllJobs(){
        // remove jobs one by one and process them
        while(this.jobs.length != 0){ // run while there is still job remaining
            // process the oldest job on the list
            this.processJob(this.jobs[0]);
            // remove this job off the list of jobs
            Job[] newJobs = new Job[this.jobs.length - 1];
            for(int i = 0; i < newJobs.length; i++){
                newJobs[i] = this.jobs[i + 1];
            }
            this.jobs = newJobs;
        }
        // after all jobs have been process, move the elevator back to Lobby
        System.out.println("Return to Lobby");
        System.out.println(this.getLocation());
        while(this.location != 0){
            this.location --;
            System.out.println(this.getLocation());
        }

    }

    public void processJob(Job job){
        // process a Job : by moving this Elevator from the current floor to the desired Floor
        // once the floor is reached, use exit() to move the Job's Person to destination Floor
        // Print Elevator's location before moving it and after each time it is moved by a floor
        // print current location of the elevator
        System.out.println(this.getLocation());
        // move the Elevator floor by floor to drop off the Person with desired floor
        while(job.getFloor() != this.location){ // while desired floor is not current floor
            if(job.getFloor() > this.location){ // go up
                this.location ++;
            }
            else if(job.getFloor() < this.location){ // go down
                this.location --;
            }
            System.out.println(this.getLocation()); // print current location
        }
        // when the floor has been reached, exit the person
        exit(job.getPerson(), job.getFloor());

    }

    public void exit(Person person, int floor){
        // remove a Person from this Elevator onto their Floor in the Building the Person is in
        person.getBuilding().enterFloor(person, floor);
        System.out.println("Drop off " + person.getFirstName() +" at Floor "+ floor);
    }
}
