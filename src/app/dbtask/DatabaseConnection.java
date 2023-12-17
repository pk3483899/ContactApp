package app.dbtask;
import java.sql.*;

public class DatabaseConnection {

	private static Connection con;
	
	
	public static void closeConnection()
	{
		if(con!=null)
			try {
				con.close();
				System.out.println("Connection is being closed");
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
	}
	
	
	
	
	public static Connection createConnection()
	{
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); //used to create the object of Driver class
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mycontacts","root","root"); //connection string or connection url (must remember)
			
					//name or ip address of th emachine where database has been installed
					//127.0.0.1-> loop back address
//			portno->logical number where database listens
						//factory method->is used to create the object of class
					//factory design pattern->known solution of known problems
			
			
			
			
			//	Gang of four design pattern
			//1. Eric Gama 2.....
//			Singlaton design pattern (imp)
//			decorator
//			adapter design pattern 
//			MVC design pattern
//			
		}
		catch(ClassNotFoundException|SQLException cse)
		{
			
			cse.printStackTrace();
		}
		return con;

	}
//	for checking the connection
//	public static void main(String[] args) {
//		Connection cn=createConnection();
//		System.out.println(cn);
//	}
}
