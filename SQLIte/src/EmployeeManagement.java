import java.sql.*;
import java.util.Scanner;

public class EmployeeManagement
{
	private static final String DATABASE = "fk7.db";
	protected static Connection c;
	protected static Statement stmt;
	private static Employee employee;
	
	  public static void main( String args[] ) throws SQLException
	  {
		try{
			  
		  EmployeeManagement object = new EmployeeManagement();
		  Scanner keyboard=new Scanner(System.in);
		  int line;
		  int input;
		  object.openDatabase();
		  CreateTables.createTables(c, stmt, employee);
		  do{
			  
			  System.out.println("Enter Option:");
			  System.out.println("1:Select\n2:Insert\n3:Update\n4:Delete\n0:Exit");
			  input = Integer.parseInt(keyboard.nextLine());
			  switch(input){
			  	case 1: object.selectRecord();
			  			break;
			  			
			  	case 2: boolean insert_flag = object.getData();
						  if(insert_flag)
							  object.insertRecord();
						  else
							  System.out.println("Please enter all the required fields");
						  break;
						  
			  	case 3: System.out.println("Please enter id you want to update");
				  		line = Integer.parseInt(keyboard.nextLine());
				  		object.updateRecord(line);
				  		break;
				  		
			  	case 4: System.out.println("Please enter id you want to delete");
					    line = Integer.parseInt(keyboard.nextLine());
					    object.deleteRecord(line);
					    break;
			   default: System.out.println("Thank you for visiting!");
			   			break;
			  }
		  
		  } while(input!=0);
		} 
		  
		  
		  	catch(Exception e){
		  		e.printStackTrace();
			  System.out.println("You have entered incorrect values!");
		  }
		  
	  }
	  
	  public void updateRecord(int id) throws SQLException {
		  ResultSet rs = selectRecordByID(id);
		  
		  if(rs.next()) {
		  c.setAutoCommit(false);
		  boolean insert_flag = getData();
		  
		  if(insert_flag) {
			  String query = "UPDATE EMPLOYEE set FIRST_NAME = ?, LAST_NAME = ?,AGE = ?, SEX = ?, ADDRESS =?, SALARY =?, EMP_TYPE_ID = ?, DEPT_ID =? , PROJECT_ID= ?, SALARY_ID = ?" +  "where ID="+id+" ;";

			PreparedStatement statement = c.prepareStatement(query);
		        statement.setString(1, employee.getFirstName());
		        statement.setString(2, employee.getLastName());
		        statement.setString(3, employee.getAge());
		        statement.setString(4, employee.getSex());
		        statement.setString(5, employee.getAddress());
		        statement.setString(6, employee.getSalary());
		        statement.setInt(7, employee.getEmpId());
		        statement.setInt(8, employee.getDeptId());
		        statement.setInt(9, employee.getProjectId());
		        statement.setInt(10, employee.getSalaryId());
		        statement.executeUpdate();
			  c.commit();
			  System.out.println("Record Updated");
		  }
	      else
			  System.out.println("Please enter all the required fields");
	      
		  } else{
			  System.out.println("ID not found");  
		  }
	
	}

	public void deleteRecord(int id) throws SQLException {
		ResultSet rs = selectRecordByID(id);
		  if(rs.next()) {
		  c.setAutoCommit(false);

	      stmt = c.createStatement();
	      String sql = "DELETE from EMPLOYEE where ID="+id+" ;";
	      
	      stmt.executeUpdate(sql);
		  System.out.println("Record Deleted");
	      c.commit();
		  } else {
			  System.out.println("ID not found");
		  }

	  }
	  
	  public ResultSet selectRecordByID(int id)
	  {
		  ResultSet rs = null;
		  try {
			  stmt = c.createStatement();
			  rs = stmt.executeQuery( "SELECT * FROM EMPLOYEE where ID="+id+" ;" );
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
		  return rs; 
	  }
	public void selectRecord() {
		  try {
		  stmt = c.createStatement();
	      ResultSet rs = stmt.executeQuery( "SELECT * FROM EMPLOYEE;" );
	      while ( rs.next() ) {
	         System.out.println( "ID = "+rs.getInt(1));
	         System.out.println( "FIRST NAME = "+rs.getString(2));
	         System.out.println( "LAST NAME = "+rs.getString(3));
	         System.out.println( "AGE = "+rs.getLong(4));
	         System.out.println( "SEX = "+rs.getString(5));
	         System.out.println( "ADDRESS = "+rs.getString(6));
	         System.out.println( "SALARY = "+rs.getFloat(7));
	         System.out.println( "EMP ID = "+rs.getInt(8));
	         System.out.println( "SALARY TYPE ID = "+rs.getInt(9));
	         System.out.println( "DEPT ID = "+rs.getInt(10));
	         System.out.println( "PROJECT ID = "+rs.getInt(11));
	         System.out.println();
	      }
	      rs.close();
	      stmt.close();
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	    System.out.println("Operation done successfully");
	  }
	
	public void insertRecord(){
		  try{
			  c.setAutoCommit(false);
			  stmt = c.createStatement();
			  ResultSet rs = stmt.executeQuery( "SELECT max(ID) FROM EMPLOYEE;" );
			  employee.setId(rs.getInt(1)+1);
			  
	      String sql = "INSERT INTO EMPLOYEE (ID,FIRST_NAME,LAST_NAME,AGE,SEX,ADDRESS,SALARY ,EMP_TYPE_ID, DEPT_ID, PROJECT_ID, SALARY_ID) " +
	                   "VALUES (?,?,?,?,?,?,?,?,?,?,?);"; 
	      
	      PreparedStatement statement = c.prepareStatement(sql);
	     
	        statement.setInt(1, employee.getId());
	        statement.setString(2, employee.getFirstName());
	        statement.setString(3, employee.getLastName());
	        statement.setString(4, employee.getAge());
	        statement.setString(5, employee.getSex());
	        statement.setString(6, employee.getAddress());
	        statement.setString(7, employee.getSalary());
	        statement.setInt(8, employee.getEmpId());
	        statement.setInt(9, employee.getDeptId());
	        statement.setInt(10, employee.getProjectId());
	        statement.setInt(11, employee.getSalaryId());
	        statement.executeUpdate();
	    
	        statement.close();
	      c.commit();
	      
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.out.println("Entered Values which do not exsist in tables - EmployeeType, Department, Project or SalaryType. ");
	      System.exit(0);
	    }
	    System.out.println("Records created successfully");

	  }

	public boolean getData() {
		   employee = new Employee();
		  Scanner keyboard=new Scanner(System.in);
		  String line;
		  
		  System.out.println("Enter first name");
		  line = keyboard.nextLine();
		  if(!line.isEmpty())
			  employee.setFirstName(line);
		  else
			  return false;
		  
		  System.out.println("Enter last name");
		  line = keyboard.nextLine();
		  if(!line.isEmpty())
			  employee.setLastName(line);
		  else
			  return false;
		  
		  System.out.println("Enter age");
		  line = keyboard.nextLine();
		  if(!line.isEmpty())
			  employee.setAge(line);
		  else
			  return false;
		  
		  
		  System.out.println("Enter sex");
		  line = keyboard.nextLine();
		  if(!line.isEmpty())
			  employee.setSex(line);
		  else
			  return false;
		  
		  System.out.println("Enter address");
		  line = keyboard.nextLine();
		  if(!line.isEmpty())
			  employee.setAddress(line);
		  else
			  return false;
		  
		  
		  System.out.println("Enter salary");
		  line = keyboard.nextLine();
		  if(!line.isEmpty())
			  employee.setSalary(line);
		  else
			  return false;
		  
		  System.out.println("Enter Emp Type ID");
		  line = keyboard.nextLine();
		  if(!line.isEmpty())
			  employee.setEmpId(Integer.parseInt(line));
		  else
			  return false;
		  
		  System.out.println("Enter Dept ID");
		  line = keyboard.nextLine();
		  if(!line.isEmpty())
			  employee.setDeptId(Integer.parseInt(line));
		  else
			  return false;
		  
		  System.out.println("Enter Project ID");
		  line = keyboard.nextLine();
		  if(!line.isEmpty())
			  employee.setProjectId(Integer.parseInt(line));
		  else
			  return false;
		  
		  System.out.println("Enter salary ID");
		  line = keyboard.nextLine();
		  if(!line.isEmpty())
			  employee.setSalaryId(Integer.parseInt(line));
		  else
			  return false;
		  
		  return true;
		  
	  }

	public void openDatabase(){
		  try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:" + DATABASE);
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
		  System.out.println("Opened database successfully");
	  }
	  
	
	  
	public void closeConnections() {
		try {
			stmt.close();
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	  
}
