package DbConnection;


import java.sql.*;



public class Conn {


	public static Connection getCon()
	{
		try {
			
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
			return con;
		//	System.out.println(con);
		
		} catch (Exception e) {
			
		return null;
		//	System.out.println(e);
			
		}
	}
	
}
	


