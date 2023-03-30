/**
* This class is used for creating a Floor object that contains an array consists of Person objects that documents 
* people who exit the elevator at this floor.
* Known Bugs: None
*
* @author Qiuyang Wang
* @version 2/3/2023
* Email: qiuyangwang@brandeis.edu
* COSI 21A PA0
*/

package main;
public class Floor {
	
	private int numFloor;
	private Person[] containedPeople;
	private int numPeople;

	/**
	 * Constructs a new Floor object representing the given number of the floor.
	 *
	 * @param numFloor String the number of this floor.
	 */
	public Floor(int numFloor) {
		this.numFloor = numFloor;
		this.numPeople = 0;
	}
	
	/**
	 * Saves a reference to a Person object within this stop
	 * and sets the latest location for him or her.
	 *
	 * @param person Person a Person object that enters this floor.
	 */
	public void enterFloor(Person person) {
		if (this.numPeople == 0) {				//creates a new array if there is no one at this floor
			containedPeople = new Person[1];
			containedPeople[0] = person;
			person.setLocation(numFloor);
			this.numPeople++;
		} else {
			this.numPeople++;
			Person[] addPeople = new Person[this.numPeople];		//implements a dynamic growing array
			for(int i = 0; i <= this.numPeople - 2; i++) {
				addPeople[i] = containedPeople[i];
			}
			addPeople[this.numPeople -1] = person;
			person.setLocation(numFloor);
			containedPeople = addPeople;
		}
	}
	
	/**
	 * Obtains the Person Array that documents people who exit the elevator at this floor.
	 *
	 * @return containedPeople Person[] the Array consists of Person objects that documents
	 *                                  people who exit the elevator at this floor.
	 */
	public Person[] getPerson() {
		return containedPeople;
	}
	
	/**
	 * Standardizes the output format for Floor object
	 * into "This is Floor " + numFloor. Example: This is Floor 1.
	 * 
	 * @return String basic information represented by a Floor object
	 */
	public String toString() {
		return "This is Floor " + numFloor;
	}
}
