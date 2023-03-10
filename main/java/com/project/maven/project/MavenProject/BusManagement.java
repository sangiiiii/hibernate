package com.project.maven.project.MavenProject;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.cfg.Configuration;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/* Here class name is taken as table name (Student) 
 * because of the @Entity annotation.
 */

@Entity
@DynamicUpdate
public class BusManagement {

	/* scanner object private to this class is created to accept userInput */
	private static final Scanner scan=new Scanner(System.in);
	
	
	private String startingpoint;
	private String endingPoint;
	private String driverName;
	private Long driverNumber;
	// @Id annotation denotes the primary key of the table created
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer busId;

	@Column(name="Bus_number",length=10,unique=true)
	private String busNumber;
	private String busType;
	public BusManagement() {

	}
	public String getStartingPoint() {
		return startingpoint;
	}
	public void setStartingPoint(String startingpoint) {
		this.startingpoint = startingpoint;
	}
	public String getEndingPoint() {
		return endingPoint;
	}
	public void setEndingPoint(String endingPoint) {
		this.endingPoint = endingPoint;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public Long getDriverNumber() {
		return driverNumber;
	}
	public void setDriverNumber(Long driverNumber) {
		this.driverNumber = driverNumber;
	}
	public String getBusNumber() {
		return busNumber;
	}
	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
	}
	public String getBusType() {
		return busType;
	}
	public void setBusType(String busType) {
		this.busType = busType;
	}
	public Integer getbusId() {
		return busId;
	}
	public void setbusId(int busId) {
		this.busId = busId;
	}
	@Override
	public String toString() {
		return "BusManagement [startingpoint=" + startingpoint + ", endingPoint=" + endingPoint + ", driverName="
				+ driverName + ", driverNumber=" + driverNumber + ", busNumber=" + busNumber + ", busType=" + busType
				+ ",busId=" + busId +"]";
	}
	/*
	 * Defining a login method using if condition to check username and password,
	 * entered by user is equal to the value initialized or not. Only when the
	 * conditions are true, the system gets logged in and display the menu. Else,
	 * the system fails to login
	 */
	public void toReadInput() {
		System.out.println("!!! Login First !!!");
		System.out.print("Enter username: ");
		String userName = scan.nextLine();
		System.out.print("Enter password: ");
		String password = scan.nextLine();
		/* calling the toLogin method */
		toLogin(userName, password);
	}
	public static void toLogin(String userName, String password) {
		if (userName.equals("Room2&5") && password.equals("12345")) { 
			
			System.out.println("successfully logged in");
			HibernateConfiguration.toCreateConnection(scan);
			
		}
		/* If the if-condition fails, then the else part is executed */
		else {
			System.out.println("Login Failed!!!");
		}
	}

	
	/* Defining logout() method for logging out the system */
	public static void toLogout() {
		System.out.println("Logged out!!! \nThank You! Visit Again!!!");
	}
}




