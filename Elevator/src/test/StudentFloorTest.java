/**
* It is used for testing methods of Floor class.
* Known Bugs: None
*
* @author Qiuyang Wang
* @version 2/3/2023
* Email: qiuyangwang@brandeis.edu
* COSI 21A PA0
*/

package test;

import static org.junit.jupiter.api.Assertions.*;
import main.Building;
import main.Person;
import main.Elevator;
import main.Job;
import main.Floor;
import org.junit.jupiter.api.Test;

class StudentFloorTest {
	
	Building A = new Building(5);
	Person a = new Person("a", "a");
	Person b = new Person("b", "b");
	Person c = new Person("c", "c");
	Person d = new Person("d", "d");
	
	@Test
	void testEnterFloor() {			//verifies whether the Floor object contains corresponding Person objects
		a.enterBuilding(A, 5);
		b.enterBuilding(A, 1);
		c.enterBuilding(A, 4);
		d.enterBuilding(A, 5);
		A.startElevator();
		Floor[] testFloor = A.getFloors();
		Person[] group1 = testFloor[4].getPerson();
		Person[] group2 = testFloor[0].getPerson();
		Person[] group3 = testFloor[3].getPerson();
		assertEquals(group1[0].toString(), "a a");
		assertEquals(group1[1].toString(), "d d");
		assertEquals(group2[0].toString(), "b b");
		assertEquals(group3[0].toString(), "c c");
	}
	
	@Test
	void testNumFloor() {		//verifies the correctness of the floor number
		Floor[] testFloor = A.getFloors();
		for(int i = 0; i < testFloor.length; i++) {
			assertEquals(testFloor[i].toString(), "This is Floor " + (i + 1));
		}
	}
}
