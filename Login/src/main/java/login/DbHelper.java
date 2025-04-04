package login;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DbHelper {    
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";  
    private static final String DBurl = "jdbc:mysql://localhost:3306/userlogin";
    private static final String user = "login";
    private static final String pwd = "pippo";    

    private Connection con;
    
    public DbHelper() {
      con = null;
      try {
    	  Class.forName(DRIVER);  // check if library is loaded
    	  System.out.println("Driver Connector/J trovato!");
      }
      catch (ClassNotFoundException e) {
    	  System.out.println("Driver Connector/J NON trovato!");
      }
    }
    
    /* CONNESSIONE DB */
    public void connect() throws SQLException {   	 
    	con = DriverManager.getConnection(DBurl, user, pwd);
    }
    
    public void disconnect() throws SQLException {
    	if (con != null) con.close();
    }
    
    /* DB API */    
    public boolean logon(String email, String pwd) throws SQLException {
    	String query = "SELECT * FROM account WHERE email = '" + email + "' AND pwd = md5('" + pwd + "')";
    	Statement sql = con.createStatement();
    	ResultSet res = sql.executeQuery(query);
		
    	return res.next();
	}
    
    public boolean userExists(String email) throws SQLException {
    	String query = "SELECT * FROM account WHERE email = ?";
    	PreparedStatement stmt = con.prepareStatement(query);
    	stmt.setString(1, email);
    	ResultSet res = stmt.executeQuery();
    	return res.next();
    }
    
    public int getUserId(String email) throws SQLException {
    	String query = "SELECT id FROM account WHERE email = ?";
    	PreparedStatement stmt = con.prepareStatement(query);
    	stmt.setString(1, email);
    	ResultSet res = stmt.executeQuery();
    	return res.next() ? res.getInt(1) : 0;
    }
    
}