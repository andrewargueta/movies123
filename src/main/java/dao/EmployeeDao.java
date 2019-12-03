package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Customer;
import model.Employee;
import model.Movie;

public class EmployeeDao {
	/*
	 * This class handles all the database operations related to the employee table
	 */
	
	public String addEmployee(Employee employee) {

		/*
		 * All the values of the add employee form are encapsulated in the employee object.
		 * These can be accessed by getter methods (see Employee class in model package).
		 * e.g. firstName can be accessed by employee.getFirstName() method.
		 * The sample code returns "success" by default.
		 * You need to handle the database insertion of the employee details and return "success" or "failure" based on result of the database insertion.
		 */
		
		/*Sample data begins*/
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://mysql3.cs.stonybrook.edu:3306/agargueta?user=agargueta", "agargueta", "111456257");
			Statement st = con.createStatement();
			
			String sql = "INSERT INTO Employee " + "VALUES ('" + employee.getEmployeeID() + "', '"+employee.getStartDate()+"', '"+employee.getHourlyRate()+"', '"+employee.getEmail()+"', '"+employee.getFirstName()+"', '"+employee.getLastName()+"', '"+employee.getAddress()+"'"
					+ ", '"+employee.getCity()+"', '"+employee.getState()+"', '"+employee.getZipCode()+"', '"+employee.getTelephone()+"', '"+employee.getLevel()+"', '"+employee.getRevenue()+"')";
			st.executeUpdate(sql);
			return "success";
		}
		catch(Exception e) {
			System.out.println(e);
			return "failure";
		}

		/*Sample data ends*/

	}

	public String editEmployee(Employee employee) {
		/*
		 * All the values of the edit employee form are encapsulated in the employee object.
		 * These can be accessed by getter methods (see Employee class in model package).
		 * e.g. firstName can be accessed by employee.getFirstName() method.
		 * The sample code returns "success" by default.
		 * You need to handle the database update and return "success" or "failure" based on result of the database update.
		 */
		
		/*Sample data begins*/
		try {
			//System.out.println(movie.getMovieName());
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://mysql3.cs.stonybrook.edu:3306/agargueta?user=agargueta", "agar"
					+ "gueta", "111456257");
			Statement st = con.createStatement();
			String sql = "UPDATE Employee " + "SET FirstName ='"+employee.getFirstName()+"', LastName='"+employee.getLastName()+"', HourlyRate='"+employee.getHourlyRate()+"', Email='"+employee.getEmail()+"', StartDate='"+employee.getStartDate()+"'"
					+ ", City='"+employee.getCity()+"', ZipCode='"+employee.getZipCode()+"', Telephone='"+employee.getTelephone()+"', State='"+employee.getState()+"', Address='"+employee.getAddress()+"'"
					+ ", Level='"+employee.getLevel()+"', Revenue='"+employee.getRevenue()+"' "
					+ "WHERE Id ='"+employee.getEmployeeID() +"'";
			st.executeUpdate(sql);
			return "success";
		}
		catch(Exception e) {
			System.out.println(e);
			return "failure";
		}
		/*Sample data ends*/

	}

	public String deleteEmployee(String employeeID) {
		/*
		 * employeeID, which is the Employee's ID which has to be deleted, is given as method parameter
		 * The sample code returns "success" by default.
		 * You need to handle the database deletion and return "success" or "failure" based on result of the database deletion.
		 */
		
		/*Sample data begins*/
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://mysql3.cs.stonybrook.edu:3306/agargueta?user=agargueta", "agargueta", "111456257");
			Statement st = con.createStatement();
			String sql = "DELETE FROM Employee where Employee.Id = '" +employeeID+"' ";
			st.executeUpdate(sql);
			return "success";

			
		}
		catch(Exception e) {
			System.out.println(e);
			return "failure";
		}
		/*Sample data ends*/

	}

	
	public List<Employee> getEmployees() {

		/*
		 * The students code to fetch data from the database will be written here
		 * Query to return details about all the employees must be implemented
		 * Each record is required to be encapsulated as a "Employee" class object and added to the "employees" List
		 */

		List<Employee> employees = new ArrayList<Employee>();
		
		/*Sample data begins*/
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://mysql3.cs.stonybrook.edu:3306/agargueta?user=agargueta", "agargueta", "111456257");
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("select * from Employee");
				while(rs.next()) {
					Employee employee = new Employee();
					employee.setEmployeeID(rs.getString("Id"));
					employee.setFirstName(rs.getString("FirstName"));
					employee.setLastName(rs.getString("LastName"));
					employee.setAddress(rs.getString("Address"));
					employee.setCity(rs.getString("City"));
					employee.setState(rs.getString("State"));
					employee.setZipCode(rs.getInt("Zipcode"));
					employee.setTelephone(rs.getString("Telephone"));
					employee.setEmail(rs.getString("Email"));
					employee.setStartDate(rs.getString("StartDate"));
					employee.setHourlyRate(rs.getInt("HourlyRate"));
					employee.setLevel(rs.getString("Level"));
					employee.setRevenue(rs.getString("Revenue"));
					employees.add(employee);
				}
				
			}
			catch(Exception e) {
				System.out.println(e);
			}
		/*Sample data ends*/
		
		return employees;
	}

	public Employee getEmployee(String employeeID) {

		/*
		 * The students code to fetch data from the database based on "employeeID" will be written here
		 * employeeID, which is the Employee's ID who's details have to be fetched, is given as method parameter
		 * The record is required to be encapsulated as a "Employee" class object
		 */

		Employee employee = new Employee();
		
		/*Sample data begins*/
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://mysql3.cs.stonybrook.edu:3306/agargueta?user=agargueta", "agargueta", "111456257");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from Employee where Id = '"+ employeeID+"'");
			while(rs.next()) {
				employee.setEmployeeID(rs.getString("Id"));
				employee.setFirstName(rs.getString("FirstName"));
				employee.setLastName(rs.getString("LastName"));
				employee.setAddress(rs.getString("Address"));
				employee.setCity(rs.getString("City"));
				employee.setState(rs.getString("State"));
				employee.setZipCode(rs.getInt("Zipcode"));
				employee.setTelephone(rs.getString("Telephone"));
				employee.setEmail(rs.getString("Email"));
				employee.setStartDate(rs.getString("StartDate"));
				employee.setHourlyRate(rs.getInt("HourlyRate"));
				employee.setLevel(rs.getString("Level"));
				employee.setRevenue(rs.getString("Revenue"));
			}
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		/*Sample data ends*/
		
		return employee;
	}
	
	public Employee getHighestRevenueEmployee() {
		
		/*
		 * The students code to fetch employee data who generated the highest revenue will be written here
		 * The record is required to be encapsulated as a "Employee" class object
		 */
		
		Employee employee = new Employee();
		
		/*Sample data begins*/
		
		/*Sample data ends*/
		
		return employee;
	}

	public String getEmployeeID(String username) {
		/*
		 * The students code to fetch data from the database based on "username" will be written here
		 * username, which is the Employee's email address who's Employee ID has to be fetched, is given as method parameter
		 * The Employee ID is required to be returned as a String
		 */
		String employeeId="";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://mysql3.cs.stonybrook.edu:3306/agargueta?user=agargueta", "agargueta", "111456257");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select Id from Employee where Email = '"+username+"'");
			employeeId = rs.getString("Id");
				
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return employeeId;
	}

}
