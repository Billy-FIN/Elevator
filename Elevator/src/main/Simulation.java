/**
* It is a program that can simulate various situations of taking the elevator of the building by different people.
* Known Bugs: None
*
* @author Qiuyang Wang 
* @version 2/3/2023 
* Email: qiuyangwang@brandeis.edu 
* COSI 21A PA0 
*/

package main;
public class Simulation {
	//The main method for java to operate in.
	public static void main(String[] args) {
		Building brandeis = new Building(7);
		Person a = new Person("Billy", "Ellen");		Person b = new Person("Micheal", "James");   //Constructs people
		Person c = new Person("Susan", "Xu");		Person d = new Person("Bob", "Dylon");
		Person e = new Person("John", "Alex");		Person f = new Person("Steven", "White");
		Person g = new Person("Sophia", "Anne");		Person h = new Person("dsf", "dfre");
		Person i = new Person("Xu", "Cai");        Person j = new Person("Jason", "dfjsl");
		Person k = new Person("Matt", "Torch");
		
		brandeis.getElevator();
		a.enterBuilding(brandeis, 3);		//Simulates people enter in the building and then the elevator starts working
		b.enterBuilding(brandeis, 3);
		c.enterBuilding(brandeis, 3);
		brandeis.startElevator();
		
		d.enterBuilding(brandeis, 7);
		brandeis.startElevator();
		
		e.enterBuilding(brandeis, 2);
		f.enterBuilding(brandeis, 1);
		brandeis.startElevator();
		
		g.enterBuilding(brandeis, 5);
		h.enterBuilding(brandeis, 0);
		i.enterBuilding(brandeis, 5);
		j.enterBuilding(brandeis, 1);
		k.enterBuilding(brandeis, 3);
		brandeis.startElevator();
		brandeis.startElevator();
	}
}
