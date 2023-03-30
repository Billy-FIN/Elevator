/**
* It is used for testing methods of Building class.
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

class StudentBuildingTest {

	Building A = new Building(1);
	Building B = new Building(5);
	Building C = new Building(7);
	Person a = new Person("a", "a");
	Person b = new Person("b", "b");
	Person c = new Person("c", "c");
	
	@Test
	void testNumFloors() {
		assertEquals(A.toString(), "This is a building with 1 floor.");
		assertEquals(B.toString(), "This is a building with 5 floors.");
		assertEquals(C.toString(), "This is a building with 7 floors.");
	}
	
	@Test
	void testEnterElevatorRequest() {
		assertTrue(A.enterElevatorRequest(a, 0) == false);		//verifies whether it can differentiate invalid floors
		assertTrue(A.enterElevatorRequest(a, -1) == false);
		assertTrue(A.enterElevatorRequest(a, 2) == false);
		assertTrue(A.enterElevatorRequest(a, 1) == true);
		assertTrue(B.enterElevatorRequest(a, 4) == true);
		assertTrue(C.enterElevatorRequest(a, 7) == true);
	}
}
