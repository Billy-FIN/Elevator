/**
* This class is used for creating a Job object which includes a person with his or her desired floor number.
* Known Bugs: None
*
* @author Qiuyang Wang
* @version 2/3/2023
* Email: qiuyangwang@brandeis.edu
* COSI 21A PA0
*/

package main;
public class Job {
	
	private Person person;
	private int destinedFloor;
	
	/**
	 * Constructs a new Job object representing the given Person
	 * object and his or her desired stop.
	 *
	 * @param person         Person  a Person object that requested an elevator
	 *                               (or null if the elevator needs to go to
	 *                               the Lobby to pick up others).
	 * @param destinedFloor  integer the person's desired floor number.
	 */
	public Job(Person person, int destinedFloor) {
		if(person == null) {
			this.destinedFloor = 0;			//let the elevator back to Lobby
		} else {
			this.person = person;
			this.destinedFloor = destinedFloor;			
		}
	}
	
	/**
	 * Obtains the person's desired floor from this Job object.
	 *
	 * @return destinedFloor integer the person's desired floor number.
	 */
	public int getFloor() {
		return destinedFloor;
	}
	
	/**
	 * Obtains the Person object that requested an elevator to certain floor.
	 *
	 * @return person Person the Person instance of this Job object.
	 */
	public Person getPerson() {
		return person;
	}
	
	/**
	 * Standardizes the output format for Job object
	 * into "Please take " + this.person.toString() + " to Floor " + this.destinedFLoor. 
	 * Example: Please take Qiuyang Wang to Floor 1.
	 * 
	 * @return String basic information that describes this Job object.
	 */
	public String toString() {
		return "Please take " + this.person.toString() + " to Floor " + this.destinedFloor;
	}
}