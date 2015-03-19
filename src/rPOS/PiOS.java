package rPOS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class PiOS {
	// Declaring global scanner. Issue encountered with attempting to reference
	// scanner outside of method, so it's global
	Scanner in = new Scanner(System.in);

	// initialize integer array of check numbers. 2 Dimensional Array to allow
	// items added to check.
	String[][] checks = new String[1024][255];

	private void initializeArray() {
		for (int i = 0; i < checks.length; i++) {
			checks[i][254] = "0.00";
		}
	}

	private void DBConnect() {
		String host = "jdbc:derby://eaglenet.lhup.edu:1527/raspberrypos";
		String username = "piconnect";
		String password = "26X7DuxjbJeu2JBf";

		try {
			Connection con = DriverManager.getConnection(host, username,
					password);
			Statement stmt = con.createStatement();
			String test = "SELECT * FROM EMPLOYEES";
			ResultSet rs = stmt.executeQuery(test);
		} catch (SQLException err) {
			System.out.println(err.getMessage());
		}
	}

	private void login() {
		// Method utilized to log in a user

		// request username
		System.out.print("Username: ");
		String username = in.next();

		System.out.print("Password: ");
		String password = in.next();

		// replace this with a method that checks against an entire list of
		// authorized users/passwords
		if (username.equals("dmuthle2")) {
			if (password.equals("12345")) {
				isLoggedIn(true);
			}

		} else {
			System.out.println("Invalid User! \n");
			isLoggedIn(false);
		}

	}

	private void logout() {
		// Method used to log out a user
		isLoggedIn(false);
		login();
	}

	private void isLoggedIn(boolean status) {
		if (status == true) {
			System.out.println("You are now logged in!");
			mainMenu();
		} else {
			System.out.println("Please Log In!");
			login();
		}
		// TODO Auto-generated method stub

	}

	// Stand-in menu until the GUI version is created.
	private void mainMenu() {
		System.out.println("Please select a menu option:");
		System.out.println("1. Start a new check");
		System.out.println("2. Open an existing check");
		System.out.println("3. Manager Login");
		System.out.println("4. Clock Out");
		System.out.println("5. Exit RPOS");
		int selection = in.nextInt();

		// Switch statement calls a method based on user input
		switch (selection) {
		case 1:
			newCheck();
			break;
		case 2:
			System.out.print("Please Enter Check Number: ");
			int checkID = in.nextInt();
			openCheck(checkID);
			break;
		case 3:
			adminLogin();
			break;
		case 4:
			logout();
			break;
		case 5:
			System.out.println("Thank you for using RPOS! Goodbye!");
			System.exit(100);
		default:
			mainMenu();

		}

	}

	// Switch between normal user mode and admin mode.
	private void adminLogin() {
		if (User.userStatus >= 1) {
			adminMenu();
		} else {
			System.out
					.println("Sorry, you do not have access to this menu... \n");
			mainMenu();
		}

	}

	private void adminMenu() {
		// TODO Auto-generated method stub

	}

	// Method utilized to edit existing RPOS User. Restricted to Admin Status
	// Users
	private void editUser(int userID) {

	}

	// Method utilized to add RPOS User to system. Restricted to Admin status
	// users
	private void addUser() {

		System.out.print("Please enter User ID of new user: ");
		int userID = in.nextInt();

		System.out.print("Please enter Privilege Level of new user: ");
		int userStatus = in.nextInt();

		System.out.print("Please enter default password of new user");
		String password = in.nextLine();

		User user = new User(userID, userStatus, password);
	}

	// Method to open a new check
	private void newCheck() {

	}

	// Method to open an existing check.
	private void openCheck(int checkID) {
		for (int i = 0; i < checks[checkID].length - 1; i++) {
			if (checks[checkID][i] == null) {
				System.out.println("There's nothing here!\n");
				break;
			} else {
				System.out.println(checks[checkID][i]);
			}
		}
		System.out.print("Do something with this check? ");
	}

	private String getTotal(int checkID) {
		String total = checks[checkID][255];

		return total;
	}

	private void closeCheck() {

	}

	private void addDrink(int drinkID) {

	}

	private void addFood(int foodID) {

	}

	public static void main(String[] args) {
		PiOS pi = new PiOS();

		System.out.println("Welcome to RPOS\n");

		// pi.DBConnect();
		pi.initializeArray();
		while (true) {
			pi.login();
		}

	}

}
