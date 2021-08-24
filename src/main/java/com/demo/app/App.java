package com.demo.app;

import java.sql.*;

/**
 * FoD demo
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Connection conn = null;
		try {
			String userName = args [0];
			String passwd   = args [1];
			String query = "select uname, passwd from users where uname like "+userName+"%";
			conn = DriverManager.getConnection ("jdbc:odbc:logistics", "admin", "letmein");
			Statement stmnt = conn.createStatement ();
			ResultSet rs = stmnt.executeQuery (query);
			
			// Good
			//String query = "select uname, passwd from users where uname like ?";
			//PreparedStatement p = conn.prepareStatement(query);
			//p.setString(20, username);
			//ResultSet rs = p.executeQuery(query));
			while ( rs.next() ) {
				System.out.println( "Next!" );
			}
			rs.close ();
			stmnt.close ();
			conn.close ();
		} catch (SQLException err) {
			err.printStackTrace ();
		}
		System.out.println( "Hello World!" );
    }
}
