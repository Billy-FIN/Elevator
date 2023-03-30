/**
* It is used for testing methods of Person class.
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

class StudentPersonTest {

	Person a = new Person("a", "a");
	Person b = new Person("b", "b");
	Person c = new Person("c", "c");
	Person d = new Person("d", "d");
	Person e = new Person("e", "e");
	Person f = new Person("f", "f");
	Person g = new Person("g", "g");
	Person h = new Person("h", "h");
	Building A = new Building(7);
	
	@Test
	void testGetLocation() {		//verifies people's location while printing to the console based on different desired floors
		a.enterBuilding(A, 0);
		b.enterBuilding(A, -1);
		c.enterBuilding(A, 3);
		e.enterBuilding(A, 7);
		d.enterBuilding(A, 2);
		A.startElevator();
		f.enterBuilding(A, 1);
		g.enterBuilding(A, 0);
		assertEquals(a.getLocation(), "In Lobby");
		assertEquals(b.getLocation(), "In Lobby");
		assertEquals(c.getLocation(), "In Floor 3");
		assertEquals(d.getLocation(), "In Floor 2");
		assertEquals(e.getLocation(), "In Floor 7");
		assertEquals(f.getLocation(), "Waiting to be serviced");
		assertEquals(g.getLocation(), "In Lobby");
		assertEquals(h.getLocation(), "Waiting to be serviced");
		a.enterBuilding(A, 2);
		A.startElevator();
		assertEquals(a.getLocation(), "In Floor 2");
	}

}
