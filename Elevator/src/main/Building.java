/**
* This class is used for creating a Building object includes an elevator object and an array of Floor object.
* Known Bugs: None
*
* @author Qiuyang Wang
* @version 2/3/2023
* Email: qiuyangwang@brandeis.edu
* COSI 21A PA0
*/

package main;
public class Building {
	
	private Elevator elevator;
	private Floor[] floors;

	/**
	 * Constructs a new Building object containing an array of Floor object representing the given floors.
	 *
	 * @param numFloors integer the number of floors within this building.
	 */
	public Building(int numFloors) {
		this.elevator = new Elevator(this);
		this.floors = new Floor[numFloors];
		for(int i = 0; i < numFloors; i++) {
			floors[i] = new Floor(i + 1);		//there is no floor 0
		}
	}
	
	/**
	 * Passes the information to the elevator and let it be ready
	 * by calling it to create a Job object contains a Person object
	 * and his or her desired floor.
	 *
	 * @param person    Person person that requests an elevator.
	 * @param floor     integer the desired floor of that person.
	 * @return boolean  True if this person requires a valid floor, false if this 
	 *                  person requires a invalid floor.
	 */
	public boolean enterElevatorRequest(Person person, int floor) {
		if (floors.length >= floor && floor > 0) {			//ensure the validity of the requested floor
			elevator.createJob(person, floor);
			return true;
		} else {
			person.setLocation(-1);
			return false;
		}
	}
	
	/**
	 * Puts the elevator in working by calling a method defined inside the Elevator Class.
	 */
	public void startElevator() {
		elevator.processAllJobs();
	}
	
	/**
	 * Calls the Floor object to add a Person object to that floor.
	 *
	 * @param person Person   person that enters this floor.
	 * @param floor  integer  the desired floor of this person.
	 */
	public void enterFloor(Person person, int floor) {
		floors[floor - 1].enterFloor(person);
	}
	
	/**
	 * Obtains the number of floors of this Building object.
	 *
	 * @return floors Floor[] the array of Floor objects which is an
	 *                        instance of this Building object.
	 */
	public Floor[] getFloors() {
		return floors;
	}
	
	/**
	 * Obtains the number of floors of this Building object.
	 *
	 * @return floors Floor[] the array of Floor objects which is an
	 *                        instance of this Building object.
	 */
	public Elevator getElevator() {
		return this.elevator;
	}
	
	/**
	 * Standardizes the output format for Building object
	 * into "This is a building with " + this.floor.length + "floors."
	 * Example: This is a building with 5 floors.
	 * 
	 * @return String basic information about a Building object
	 */
	public String toString() {
		if (this.floors.length == 1) {
			return "This is a building with 1 floor.";
		}
		else{
			return "This is a building with " + this.floors.length + " floors.";
		}
	}
}
