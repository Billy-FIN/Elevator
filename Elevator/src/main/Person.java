/**
* This class is used for creating a Person object with a name and an integer value that stores his current 
* location in the building.
* Known Bugs: None
*
* @author Qiuyang Wang
* @version 2/3/2023
* Email: qiuyangwang@brandeis.edu
* COSI 21A PA0
*/

package main;
public class Person {
	
	private String firstName;
	private String lastName;
	private int currentLocation;
	
	/**
	 * Constructs a new Person object representing the given names.
	 *
	 * @param firstName String  the first name of this person.
	 * @param lastName  String  the last name of this person.
	 */
	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.currentLocation = 0;
	}

	/**
	 * Calls to enter the building and requires an elevator
	 * to a certain floor.
	 * 
	 * @param building   Building  the building to be entered.
	 * @param floor      integer   the floor that this Person objected wants to go.
	 * @return boolean   True if this person requires a valid floor, false if this 
	 *                   person requires a invalid floor.
	 */
	public boolean enterBuilding(Building building, int floor) {
		return building.enterElevatorRequest(this, floor);
	}
	
	/**
	 * Obtains the current floor location of a Person object.
	 *
	 * @return String  the floor location of this Person object, always is "In Lobby" or
	 *   			   "Waiting to be serviced" or "In Stop x".
	 */
	public String getLocation() {
	    if (this.currentLocation == -1) {		//this person requires an invalid floor
	    	return "In Lobby";
	    } else if(this.currentLocation == 0) {
	    	return "Waiting to be serviced";
	    } else {
	    	return "In Floor " + currentLocation;
	    }
	}
	
	/**
	 * Sets the current location of a Person object.
	 *
	 * @param numFloor integer the latest floor location of
	 *                         this Person object.
	 */
	public void setLocation(int numFloor) {
		this.currentLocation = numFloor;
	}
	
	/**
	 * Standardizes the output format for Person object
	 * into firstName + lastName. Example: Qiuyang Wang.
	 * 
	 * @return String name represented by a Person object
	 */
	public String toString() {
		return this.firstName + " " + this.lastName;
	}
}
