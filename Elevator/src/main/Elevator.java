/**
* This class is used for creating an Elevator object and operating it.
* Known Bugs: None
*
* @author Qiuyang Wang
* @version 2/3/2023
* Email: qiuyangwang@brandeis.edu
* COSI 21A PA0
*/

package main;
public class Elevator {

	/**
	 * This specifies the number of people that can be brought to their floors by an Elevator 
	 * instance at any given time. 
	 * <p>DO NOT REMOVE THIS FIELD</p>
	 * <p>You may edit it. But keep it public.</p>
	 */
	public static int maxOccupants = 3;
	private int currentFloor;
	private Job[] jobs;
	private int currentOccupants;
	private Building owner;
	
	/**
	 * Constructs a new Elevator object at the lobby.
	 *
	 * @param building Building the Building object that this elevator belongs to.
	 */
	public Elevator(Building building) {
		this.currentFloor = 0;
		this.currentOccupants = 0;
		this.owner = building;
		this.jobs = new Job[0];
	}
	
	/**
	 * Obtains the current floor location of a Drone object.
	 *
	 * @return currentFloor integer the current floor location that
	 *                              the drone is currently at.
	 */
	public int getCurrentFloor() {
		return currentFloor;
	}
	
	/**
	 * Creates a job for the elevator.
	 *
	 * @param person  Person  a Person object that requested an elevator.
	 * @param floor   integer the person's desired floor number.
	 */
	public void createJob(Person person, int floor) {
		if(currentOccupants == 0) {				//creates a new array if there is no one in the elevator
			this.jobs = new Job[1];
			this.jobs[0] = new Job(person, floor);
			this.currentOccupants++;
		} else {
			this.currentOccupants++;
			Job[] addJob = new Job[this.currentOccupants];				//implements a dynamic growing array
			for(int i = 0; i < this.currentOccupants - 1; i++) {
				addJob[i] = jobs[i];
			}
			addJob[this.currentOccupants -1] = new Job(person, floor);
			jobs = addJob;
		}
	}
	
	/**
	 * Starts the elevator to complete all the jobs and send
	 * people to their desired floors.
	 */
	public void processAllJobs() {
		if(this.currentOccupants > maxOccupants) {			//completes the first group jobs based on its maxOccupants
			for(int i = 0; i < maxOccupants; i++) {
				processJob(jobs[0]);
				this.currentOccupants--;
				Job[] updatedJobs = new Job[jobs.length - 1];		//implements a dynamic growing array, like a queue
				for (int k = 0; k < updatedJobs.length; k++) {
					updatedJobs[k] = jobs[k + 1];
				}
				jobs = updatedJobs;
			}
			processJob(new Job(null, 0));	//calls the elevator back to lobby and be ready to pick up others
			processAllJobs();				//implements recursion until all jobs are done
		} else {
			int temp = jobs.length;
			for(int j = 0; j < temp; j++) {
				processJob(jobs[0]);
				this.currentOccupants--;
				if (this.currentOccupants != 0) {
					Job[] updatedJobs = new Job[jobs.length - 1];		//implements a dynamic growing array
					for (int k = 0; k < updatedJobs.length; k++) {
						updatedJobs[k] = jobs[k + 1];
					}
					jobs = updatedJobs;
				}
				else {
					jobs = new Job[0];
					processJob(new Job(null, 0));		//calls the elevator back to lobby to stand by
				}
			}
		}
	}
	
	/**
	 * Processes a job, and move the elevator stop by stop 
	 * in order to reach the desired stop. 
	 * 
	 * @param job Job the job to be processed.
	 */
	public void processJob(Job job) {
		System.out.println(this.toSrting());
		if (job.getFloor() > this.currentFloor) {		//decides whether the elevator should go up or go down or stay
			for (int i = this.currentFloor; i != job.getFloor(); i++) {
				this.currentFloor++;
				System.out.println(this.toSrting());
			}
			exit(job.getPerson(), currentFloor);
		} else if (job.getFloor() == this.currentFloor) {
			exit(job.getPerson(), currentFloor);
		} else {
			for (int i = this.currentFloor; i != job.getFloor(); i--) {
				this.currentFloor--;
				System.out.println(this.toSrting());
			}
			if(job.getPerson() != null) {				
				exit(job.getPerson(), currentFloor);
			}
		}
	}
	
	/**
	 * Enables a person to leave the elevator and then enter a floor.
	 * 
	 * @param person Person  a Person object in this elevator.
	 * @param floor  integer the person's desired floor number.
	 */
	public void exit(Person person, int floor) {
		owner.enterFloor(person, floor);
	}
	
	/**
	 * Obtains the Job array of an Elevator object.
	 *
	 * @return jobs Job[] the array of Job objects that this elevator needs to complete.
	 */
	public Job[] getJob() {
		return jobs;
	}
	
	/**
	 * Standardizes the output format for Elevator object.
	 *
	 * @return String  the floor location of this Person object, always is "Elevator at Lobby" or
	 *   			   "Elevator at floor " + this.currentFloor.
	 */
	public String toSrting() {
		if (this.currentFloor == 0) {
			return "Elevator at Lobby";
		} else {
			return "Elevator at floor " + this.currentFloor;
		}
	}
}