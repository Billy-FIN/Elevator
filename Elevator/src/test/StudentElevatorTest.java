/**
* It is used for testing methods of Elevator class.
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

class StudentElevatorTest {
	
	Building A = new Building(5);
	Person a = new Person("a", "a");
	Person b = new Person("b", "b");
	Person c = new Person("c", "c");
	Person d = new Person("d", "d");
	Person e = new Person("e", "e");	
	Job job1 = new Job(a, 3);
	Job job2 = new Job(b, 3);
	Job job3 = new Job(c, 5);
	Job job4 = new Job(d, 1);
	
	@Test
	void testProcessJob() {			//verifies whether the elevator can go to the desired floor
		A.getElevator().processJob(job1);
		assertTrue(A.getElevator().getCurrentFloor() == 3);
		A.getElevator().processJob(job2);
		assertTrue(A.getElevator().getCurrentFloor() == 3);
		A.getElevator().processJob(job3);
		assertTrue(A.getElevator().getCurrentFloor() == 5);
		A.getElevator().processJob(job4);
		assertTrue(A.getElevator().getCurrentFloor() == 1);
	}
	
	@Test
	void testProcessAllJobs() {			//verifies whether the elevator can go back to the lobby for a next pick up
		assertTrue(A.getElevator().getCurrentFloor() == 0);
		a.enterBuilding(A, 5);
		b.enterBuilding(A, 2);
		c.enterBuilding(A, 4);
		d.enterBuilding(A, 0);
		e.enterBuilding(A, 5);
		A.startElevator();
		assertTrue(A.getElevator().getCurrentFloor() == 0);
	}
}
