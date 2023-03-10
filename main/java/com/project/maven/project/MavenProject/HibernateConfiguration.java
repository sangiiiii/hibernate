package com.project.maven.project.MavenProject;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConfiguration {
	public static void toCreateConnection(Scanner scan) {


		try {
			Configuration config = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(BusManagement.class);//<hibernate-configuration> </hibernate-configuration>
			SessionFactory sessionFact = config.buildSessionFactory(); //<sessionFactory> </sessionFactory>
			Session session = sessionFact.openSession();
			System.out.println("1.ToCreateBusManagement");
			System.out.println("2.ToDeleteBybusId");
			System.out.println("3. ToUpdateBybusId");
			System.out.println("4.ToDisplayBybusId");
			System.out.println("5. Press 5 to Logout");

			/* variable to store user input value */
			byte userInput;    
			/* do-loop executes at least once before checking condition */
			do {                     
				userInput = scan.nextByte();

				/* passing userInput to switch case as case number */
				switch(userInput) {     

				/* userInput = 1 - toAdd method is called (inserting records) */
				case 1:
					createBusManagement(session,scan); 
					break;
					/* userInput = 2 - todeleteBybusId method is called */
				case 2:
					deleteBybusId(session,scan); 
					break;
					/* userInput = 3 - toUpdateBybusId method is called */
				case 3:
					updateBybusId(session,scan); 
					break;					
					/* userInput = 4 - todisplayBybusId method is called */
				case 4:
					displayBybusId(session,scan); 
					break;					
					/* when 5 is the userInput, user is logged out 
					 */
				case 5: 
					BusManagement.toLogout();
					//session.close();
					break;

					/* if the userInput doesn't match case value, default statement is executed */
				default: 
					System.out.println(" Enter the Correct valid Input! ");
				}
			}

			/* When user input is 5, the corresponding case's method call is executed.
			 * So, that the system gets logged out. 
			 * Until input is not equal to 5, the do-loop gets executed
			 */
			while (userInput != 5);
		}

		catch(HibernateException obj) {

		}
		catch(Exception obj) {

		}
	}





	/* toCreateStudent method is defined to insert data into a table 
	 * in a database. It is done with the help of Hibernate Framework.
	 */

	public static void createBusManagement(Session session,Scanner scan) {
		session.beginTransaction();
		Integer busId = (Integer) session.save(getBusManagement(scan));
		System.out.println("Bus Information is inserted  :"+busId);
		session.getTransaction().commit();
	}

	public static BusManagement getBusManagement(Scanner scan) {
		BusManagement bus = new BusManagement();
		System.out.println("Enter the StartingPoint ");
		String startingpoint = scan.next();
		bus.setStartingPoint(startingpoint);
		System.out.println("Enter the EndingPoint ");
		String endingpoint = scan.next();
		bus.setEndingPoint(endingpoint);
		System.out.println("Enter the DriverName ");
		String drivername = scan.next();
		bus.setDriverName(drivername);
		System.out.println("Enter the DriverNo ");
		long driverno = scan.nextLong();
		bus.setDriverNumber( driverno);
		System.out.println("Enter the BusId ");
		Integer busid = scan.nextInt();
		bus.setbusId(busid);
		System.out.println("Enter the BusNo ");
		String busno = scan.next();
		bus.setBusNumber(busno);
		System.out.println("Enter the BusType ");
		String bustype = scan.next();
		bus.setBusType(bustype);
		return bus;
	}
	/*toDeletebybusid method is defined to delete that specific record
	 * corresponding to id entered from a database
	 */
	private static void deleteBybusId(Session session,Scanner scan) {
		System.out.println("Enter the number");
		Integer busId=scan.nextInt();
		BusManagement bus = session.get(BusManagement.class,busId);

		if(bus != null) {
			session.beginTransaction();
			session.remove(bus);
			session.getTransaction().commit();
		}
		else {
			System.out.println("BusId  doesnt exists..");

		}	
	}
	/*updateBybusid method is defined to update that specific record
	 * corresponding to id entered from a database
	 */
	private static void updateBybusId(Session session,Scanner scan) {
		System.out.println("Enter the busId");
		Integer busId=scan.nextInt();
		BusManagement bus = session.get(BusManagement.class, busId);
		if(bus != null) {
			System.out.println("Enter the DriverName ");
			bus.setDriverName(scan.next());
			System.out.println("Enter the busType ");
			bus.setBusType(scan.next());
			session.beginTransaction();
			session.persist(bus);
			session.getTransaction().commit();
		}
		else {
			System.out.println("busId doesnt exists..");

		}	
	}
	/*toDisplayBybusid method is defined to display that specific record
	 * corresponding to id entered from a database
	 */
	private static void displayBybusId(Session session,Scanner scan){
		System.out.println("Enter the BusId");
		Integer busId=scan.nextInt();
		BusManagement bus = session.get(BusManagement.class,busId);
		if(bus != null) {
			System.out.println(bus);
		}
		else {
			System.out.println("busId doesnt exists..");

		}
	}

}



