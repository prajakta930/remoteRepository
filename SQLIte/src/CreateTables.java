import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTables {
	
public static void createEmployeeTypeTable(Connection c, Statement stmt, Employee e)throws SQLException{
		

	String sql;
	stmt = c.createStatement();
	String createEmployeeTypeTable = "CREATE TABLE IF NOT EXISTS EMPLOYEE_TYPE" +
            "(EMP_TYPE_ID INT PRIMARY KEY     NOT NULL," +
            " EMP_TYPE     TEXT    NOT NULL, " + 
            " DESCRIPTION  TEXT    NOT NULL)"; 
	stmt.executeUpdate(createEmployeeTypeTable);
	System.out.println("EmployeeTypeTable created successfully");

     sql = "INSERT INTO EMPLOYEE_TYPE (EMP_TYPE_ID, EMP_TYPE, DESCRIPTION) " +
           "VALUES (1, 'FULL TIME','Full time employees are Type 1 Employees');"; 
    stmt.executeUpdate(sql);
	
     sql = "INSERT INTO EMPLOYEE_TYPE (EMP_TYPE_ID, EMP_TYPE, DESCRIPTION) " +
           "VALUES (2, 'PART TIME','Part time employees are Type 2 Employees');"; 
    stmt.executeUpdate(sql);
	
     sql = "INSERT INTO EMPLOYEE_TYPE (EMP_TYPE_ID, EMP_TYPE, DESCRIPTION) " +
           "VALUES (3, 'INTERN','Intern employees are Type 3 Employees');"; 
    stmt.executeUpdate(sql);
    stmt.close();
	}
	
	public static void createSalaryTypeTable(Connection c, Statement stmt, Employee e) throws SQLException{
		
		String sql;
		stmt = c.createStatement();
		String createSalaryTypeTable = "CREATE TABLE IF NOT EXISTS SALARY_TYPE" +
                "(SALARY_ID INT PRIMARY KEY     NOT NULL," +
                " SALARY_TYPE     TEXT    NOT NULL, " + 
                " DESCRIPTION  TEXT    NOT NULL)"; 
		stmt.executeUpdate(createSalaryTypeTable);
		System.out.println("SALARY_TYPE created successfully");
   
	    sql = "INSERT INTO SALARY_TYPE (SALARY_ID, SALARY_TYPE, DESCRIPTION) " +
	           "VALUES (1, 'HOURLY','Hourly employee salary are assigned to Type 1');"; 
	    stmt.executeUpdate(sql);
		
	    sql = "INSERT INTO SALARY_TYPE (SALARY_ID, SALARY_TYPE, DESCRIPTION) " +
		           "VALUES (2, 'QUARTERLY','Quarterly employee salary are assigned to Type 2');"; 
		stmt.executeUpdate(sql);
		
		sql = "INSERT INTO SALARY_TYPE (SALARY_ID, SALARY_TYPE, DESCRIPTION) " +
		           "VALUES (3, 'MONTHLY','Monthly employee salary are assigned to Type 3');"; 
		stmt.executeUpdate(sql);
		
		 sql = "INSERT INTO SALARY_TYPE (SALARY_ID, SALARY_TYPE, DESCRIPTION) " +
		           "VALUES (4, 'YEARLY','Yearly employee salary are assigned to Type 4');"; 
		 stmt.executeUpdate(sql);
	 
	    stmt.close();
	}
	
	public static void createEmployeeTable(Connection c, Statement stmt, Employee e) throws SQLException{
		stmt = c.createStatement();
		String sql = "CREATE TABLE IF NOT EXISTS EMPLOYEE  " +
                "(ID INT PRIMARY KEY     NOT NULL," +
                " FIRST_NAME     TEXT    NOT NULL, " + 
                " LAST_NAME      TEXT    NOT NULL, " + 
                " AGE            REAL, " + 
                " SEX            CHAR(50), " + 
                " ADDRESS        CHAR(50), " + 
                " SALARY         REAL," +
	       		" EMP_TYPE_ID INT," +
	       		" SALARY_ID INT," +
	       		" DEPT_ID INT," +
	       		" PROJECT_ID INT," +
	       		" FOREIGN KEY(EMP_TYPE_ID) REFERENCES EMPLOYEE_TYPE,"+
	       		" FOREIGN KEY(DEPT_ID) REFERENCES DEPARTMENT,"+
	       		" FOREIGN KEY(PROJECT_ID) REFERENCES PROJECT,"+
				" FOREIGN KEY(SALARY_ID) REFERENCES SALARY_TYPE)";
		stmt.executeUpdate(sql);
		System.out.println("Employee table created successfully");
		stmt.close();
		
		
	}
	
	public static void createOrganizationTable(Connection c, Statement stmt, Employee e) throws SQLException {
		String sql;
		stmt = c.createStatement();
		String createSalaryTypeTable = "CREATE TABLE IF NOT EXISTS ORGANIZATION " +
                "(ORG_ID INT PRIMARY KEY     NOT NULL," +
                " STATE     TEXT    NOT NULL, " + 
                " CITY     TEXT    NOT NULL, " +
                " ZIP     INT    NOT NULL, " +
                " ADDRESS  TEXT    NOT NULL)"; 
		stmt.executeUpdate(createSalaryTypeTable);
		System.out.println("Organization Table created successfully");
   
	     sql = "INSERT INTO ORGANIZATION (ORG_ID, STATE, CITY,ZIP,ADDRESS) " +
	           "VALUES (1, 'MD','ANNAPOLIS',20740,'245 E LANE');"; 
	    stmt.executeUpdate(sql);
	    
	    sql = "INSERT INTO ORGANIZATION (ORG_ID, STATE, CITY,ZIP,ADDRESS) " +
		           "VALUES (2, 'OH','ANNAPOLIS',20740,'245 E LANE');"; 
		stmt.executeUpdate(sql);
		
		  sql = "INSERT INTO ORGANIZATION (ORG_ID, STATE, CITY,ZIP,ADDRESS) " +
		           "VALUES (3, 'CA','ANNAPOLIS',20740,'245 E LANE');"; 
		stmt.executeUpdate(sql);
		
		  sql = "INSERT INTO ORGANIZATION (ORG_ID, STATE, CITY,ZIP,ADDRESS) " +
		           "VALUES (4, 'PT','ANNAPOLIS',20740,'245 E LANE');"; 
		 stmt.executeUpdate(sql);
	 
	    stmt.close();
			
	}
	
	public static void createDepartmentTable(Connection c, Statement stmt, Employee e) throws SQLException {
		stmt = c.createStatement();
		String sql = "CREATE TABLE IF NOT EXISTS DEPARTMENT" +
                "(DEPT_ID INT PRIMARY KEY     NOT NULL," +
                " NAME     TEXT    NOT NULL, " + 
                " ORG_ID INT," +
	       		" FOREIGN KEY(ORG_ID) REFERENCES ORGANIZATION)";
		
		stmt.executeUpdate(sql);
		System.out.println("Department Table created successfully");
   
	     sql = "INSERT INTO DEPARTMENT (DEPT_ID, NAME, ORG_ID) " +
	           "VALUES (1, 'Technology','1');"; 
	    stmt.executeUpdate(sql);
	    
	    sql = "INSERT INTO DEPARTMENT (DEPT_ID, NAME, ORG_ID) " +
		           "VALUES (2, 'Support','1');"; 
	   stmt.executeUpdate(sql);
		
		sql = "INSERT INTO DEPARTMENT (DEPT_ID, NAME, ORG_ID) " +
			           "VALUES (3, 'Technology','2');"; 
		stmt.executeUpdate(sql);  
		
		sql = "INSERT INTO DEPARTMENT (DEPT_ID, NAME, ORG_ID) " +
		           "VALUES (4, 'Design','2');"; 
		stmt.executeUpdate(sql);
	 
	    stmt.close();
			
	}
	
	public static void createEmpProjectTable(Connection c, Statement stmt, Employee e) throws SQLException {
		stmt = c.createStatement();
		String sql = "CREATE TABLE IF NOT EXISTS EMPPROJECT" +
                "(PROJECT_ID INT ," +
                " DEPT_ID INT," +
                "FOREIGN KEY(PROJECT_ID) REFERENCES PROJECT,"+
	       		"FOREIGN KEY(DEPT_ID) REFERENCES DEPARTMENT)";
		
		stmt.executeUpdate(sql);
		System.out.println("Projeect Employee Table created successfully");
   
	     sql = "INSERT INTO EMPPROJECT (PROJECT_ID, DEPT_ID) " +
	           "VALUES (1,2);";  
	    stmt.executeUpdate(sql);
	    
	    sql = "INSERT INTO EMPPROJECT (PROJECT_ID, DEPT_ID) " +
		           "VALUES (1,2);";  
		    stmt.executeUpdate(sql);
		    
		 sql = "INSERT INTO EMPPROJECT (PROJECT_ID, DEPT_ID) " +
			           "VALUES (2,2);";  
	    stmt.executeUpdate(sql);
	    
	    sql = "INSERT INTO EMPPROJECT (PROJECT_ID, DEPT_ID) " +
				           "VALUES (3,4);";  
	    stmt.executeUpdate(sql);
	    stmt.close();
			
	}
	
	public static void createProjectTable(Connection c, Statement stmt, Employee e) throws SQLException {
		stmt = c.createStatement();
		String sql = "CREATE TABLE IF NOT EXISTS PROJECT" +
                "(PROJECT_ID INT PRIMARY KEY     NOT NULL," +
                " PROJECT_NAME     TEXT    NOT NULL, " + 
                " DEPT_ID INT," +
	       		" FOREIGN KEY(DEPT_ID) REFERENCES DEPARTMENT)";
		
		stmt.executeUpdate(sql);
		System.out.println("Project Table created successfully");
   
	     sql = "INSERT INTO PROJECT (PROJECT_ID, PROJECT_NAME, DEPT_ID) " +
	           "VALUES (1, 'Sales and Services Sector',1);"; 
	    stmt.executeUpdate(sql);
	    
	     sql = "INSERT INTO PROJECT (PROJECT_ID, PROJECT_NAME, DEPT_ID) " +
		           "VALUES (2, 'Project 2',2);"; 
		    stmt.executeUpdate(sql);
		 
		 sql = "INSERT INTO PROJECT (PROJECT_ID, PROJECT_NAME, DEPT_ID) " +
			           "VALUES (3, 'Project 3',3);"; 
		 stmt.executeUpdate(sql);	
		 
	     sql = "INSERT INTO PROJECT (PROJECT_ID, PROJECT_NAME, DEPT_ID) " +
		           "VALUES (4, 'Website',3);"; 
		    stmt.executeUpdate(sql);
	    
	 
	    stmt.close();
			
	}
	
	 public static void createTables(Connection c, Statement stmt, Employee e) throws SQLException{
		  
		  DatabaseMetaData metadata = c.getMetaData();
		  ResultSet resultSet;
		  resultSet = metadata.getTables(null, null, "EMPLOYEE", null);
		  if(!resultSet.next())
		  {
		  try {
			createEmployeeTypeTable(c,stmt,e); 
			createSalaryTypeTable(c,stmt,e);
		
			createOrganizationTable(c,stmt,e);
			 createDepartmentTable(c,stmt,e);
			 createProjectTable(c,stmt,e);
			 
			createEmployeeTable(c,stmt,e);
			createEmpProjectTable(c,stmt,e);
			 
			print(c,stmt,e);
			 
		  } catch (SQLException error) {
			error.printStackTrace();
		  }
		}
		  else{
			  System.out.println("Tables Present in the database!");
		  }
	}
	  


	public static void print(Connection c, Statement stmt, Employee e) throws SQLException{
		  
		 stmt = c.createStatement();
		String sql = "INSERT INTO EMPLOYEE (ID,FIRST_NAME,LAST_NAME,AGE,SEX,ADDRESS,SALARY ,EMP_TYPE_ID, DEPT_ID, PROJECT_ID, SALARY_ID) " +
                 "VALUES (01, 'Paul','Rivers', 32,'Male', 'California', 20000.00, 1,2,1,3);"; 
    stmt.executeUpdate(sql);
	
		  ResultSet rs;
		 
		  rs = stmt.executeQuery( "SELECT * FROM EMPLOYEE_TYPE;" );
		    while ( rs.next() ) {
		   
	        System.out.println( "ID = " + rs.getInt(1));
	        System.out.println( "NAME = " + rs.getString(2) );
	        System.out.println();
	     }
		    
		    rs = stmt.executeQuery( "SELECT * FROM SALARY_TYPE;" );
		    while ( rs.next() ) {
		   
	        System.out.println( "ID = " + rs.getInt(1));
	        System.out.println( "NAME = " + rs.getString(2) );
	        System.out.println();
	     }
		    
		    rs = stmt.executeQuery( "SELECT * FROM ORGANIZATION;" );
		    while ( rs.next() ) {
		   
	        System.out.println( "ID = " + rs.getInt(1));
	        System.out.println( "NAME = " + rs.getString(2) );
	        System.out.println();
	     }
		    
		    rs = stmt.executeQuery( "SELECT * FROM DEPARTMENT;" );
		    while ( rs.next() ) {
		   
	        System.out.println( "ID = " + rs.getInt(1));
	        System.out.println( "NAME = " + rs.getString(2) );
	        System.out.println();
	     }
		   
		    
		    rs = stmt.executeQuery( "SELECT * FROM PROJECT;" );
		    while ( rs.next() ) {
		   
	        System.out.println( "ID = " + rs.getInt(1));
	        System.out.println( "NAME = " + rs.getString(2) );
	        System.out.println();
	     }
		    
		    
		    rs = stmt.executeQuery( "SELECT * FROM EMPPROJECT;" );
		    while ( rs.next() ) {
		   
	        System.out.println( "ID = " + rs.getInt(1));
	        System.out.println( "NAME = " + rs.getInt(2) );
	        System.out.println();
	     }
		   
		    rs = stmt.executeQuery( "SELECT * FROM EMPLOYEE;" );
		      while ( rs.next() ) {
		         int id = rs.getInt("id");
		         String  name = rs.getString("first_name");
		         int age  = rs.getInt("EMP_TYPE_ID");
		         String  address = rs.getString("address");
		         float salary = rs.getFloat("salary");
		         System.out.println( "ID = " + id );
		         System.out.println( "NAME = " + name );
		         System.out.println( "AGE = " + age );
		         System.out.println( "ADDRESS = " + address );
		         System.out.println( "SALARY = " + salary );
		         System.out.println();
		      }
		      rs.close();
		      stmt.close();
		  
	  }
}
