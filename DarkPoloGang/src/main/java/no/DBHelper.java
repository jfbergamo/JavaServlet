package no;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;



public class DBHelper {    
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";  
    private static final String DBurl = "jdbc:mysql://localhost:3306/userlogin";
    private static final String user = "login";
    private static final String pwd = "pippo";    

    private Connection con;
    
    public DBHelper() {
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
    
    public List<Account> getAccount() throws SQLException {
    	ArrayList<Account> accounts = new ArrayList<Account>();
    	
    	String query = "SELECT name, surname, email FROM account";
    	Statement sql = con.createStatement();
    	ResultSet res = sql.executeQuery(query);
    	
    	while (res.next()) {
    		accounts.add(new Account(res.getString(1), res.getString(2), res.getString(3)));
    	}
    	
    	return accounts;
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