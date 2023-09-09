package assignment3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Jdbc {
	public static void main(String[] args) {
		System.out.println("Press the number to do operation");
		System.out.println("1.insert");
		System.out.println("2.update");
		System.out.println("3.Modify");
		System.out.println("4.delete");
		System.out.println("5.Truncate table");
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.print("Enter a number (or) 0 to exit): ");
			System.out.println();
			int option = sc.nextInt();

			if (option == 0) {
				break;
			}
			switch (option) {
			case 1:
				insert();
				System.out.println();
				System.out.println("Inserted Successfully");
				break;
			case 2:
				update();
				System.out.println();
				System.out.println("Updated Successfully");
				break;
			case 3:
				Modify();
				System.out.println();
				System.out.println("Modified Successfully");
				break;
			case 4:
				delete();
				System.out.println();
				System.out.println("deleted Successfully");
				break;
			case 5:
				droprecord();
				System.out.println();
				System.out.println("deleted records ");
				break;
			default:
				System.out.println("You entered invalid option");
				break;

			}
		}

	}

	public static void insert() {
		System.out.println("Connecting to Database");
		String url = "jdbc:mysql://localhost:3306/gl";
		String username = "root";
		String password = "sruthi";
		String query1= "insert into employee values(1,'aravind','aravind@gmail.com',1236549871)";
		String query2 = "insert into employee values(2,'anand','anand@gmail.com',1236549541)";
		String query3 = "insert into employee values(3,'rajesh','rajesh@gmail.com',1566549871)";
		String query4 = "insert into employee values(4,'sathish','sathish@gmail.com',456549871)";
		String query5 = "insert into employee values(5,'prakash','prakash@gmail.com',1546549871)";
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			Statement st = con.createStatement();
			int row1 = st.executeUpdate(query1);
			int row2 = st.executeUpdate(query2);
			int row3 = st.executeUpdate(query3);
			int row4 = st.executeUpdate(query4);
			int row5 = st.executeUpdate(query5);
			System.out.println("No of Rows Get Affected : " + (row1 + row2 + row3 + row4 + row5));
			System.out.println("Excecuted Successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void Modify() {
		System.out.println("connection to database");
		String url = "jdbc:mysql://localhost:3306/gl";
		String username = "root";
		String password = "sruthi";

		String querry = "alter table employee modify Email_Id varchar(30) not null";

		try {
			Connection con = DriverManager.getConnection(url, username, password);
			Statement st = con.createStatement();
			int row = st.executeUpdate(querry);
			System.out.println("no of table change" + row);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void update() {
		// Update the name of employee Id 3 to Karthik and phone number to 1234567890.
		String url = "jdbc:mysql://localhost:3306/gl";
		String username = "root";
		String password = "sruthi";

		String query1 = "update employee set Name='Karthik' where Id=3";
		String query2 = "update employee set Email_Id='Karthik@gl' where Id=3";
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			Statement st = con.createStatement();
			int row1 = st.executeUpdate(query1);
			int row2 = st.executeUpdate(query2);
			System.out.println("Rename Has Been Done for the table " + (row1 + row2));
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void delete() {
		String url = "jdbc:mysql://localhost:3306/gl";
		String username = "root";
		String password = "sruthi";
		String query1 = "delete from employee where Id=3";
		String query2 = "delete from employee where Id=4";
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			Statement st = con.createStatement();
			int rows1 = st.executeUpdate(query1);
			int row2 = st.executeUpdate(query2);
			System.out.println("No Of Rows Get Affected : " + (rows1 + row2));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void droprecord() {
		String url = "jdbc:mysql://localhost:3306/gl";
		String username = "root";
		String password = "sruthi";
		String query = "truncate employee";
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			Statement st = con.createStatement();
			int rows = st.executeUpdate(query);
			System.out.println("Rows get Affected : " + rows);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}