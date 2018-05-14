package pl.coderslab.model;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
	
	private static String DB_URL = "jdbc:mysql://localhost:3306/books?useSSL=false";
	private static String DB_USER = "root";
	private static String DB_PASS = "root";
	public static Connection getConn() throws SQLException {
	return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
	}

//	private static DataSource ds;
//	public static Connection getConn() throws SQLException {
//		return getInstance().getConnection();
//	}
//	private static DataSource getInstance() {
//		if(ds == null) {
//			try {
//				Context ctx = new InitialContext();
//				ds = (DataSource) ctx.lookup("java:comp/env/jdbc/books");
//			} catch (NamingException e) {
//				e.printStackTrace();}}
//		return ds;}

}
