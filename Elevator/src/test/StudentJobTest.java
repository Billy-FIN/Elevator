/**
* It is used for testing methods of Job class.
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

class StudentJobTest {

	Building A = new Building(5);
	Person a = new Person("a", "a");
	Person b = new Person("b", "b");
	Person c = new Person("c", "c");
	Person d = new Person("d", "d");
	
	@Test
	void test() {			//verifies the correctness of different jobs
		a.enterBuilding(A, 3);
		b.enterBuilding(A, 0);
		c.enterBuilding(A, 1);
		Job[] jobs1 = A.getElevator().getJob();
		assertEquals(jobs1[0].toString(), "Please take a a to Floor 3");
		assertEquals(jobs1[1].toString(), "Please take c c to Floor 1");
		A.startElevator();
		d.enterBuilding(A, 2);
		Job[] jobs2 = A.getElevator().getJob();
		assertEquals(jobs2[0].toString(), "Please take d d to Floor 2");
	}
}
