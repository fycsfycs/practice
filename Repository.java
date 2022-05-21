package tw.com.fcb.fcb_music;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Repository {
	
	String dbUrl = "jdbc:mysql://localhost:3306/test";
	String username = "root";
	String password = "Bear*0527";
	
	public Connection getConnection() throws SQLException {
		Connection connection = DriverManager.getConnection(dbUrl,username,password);
		return connection;
	}
	
	public void select() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection conn = this.getConnection();
//		Statement stmt = conn.createStatement();
		String sqlCmd = "select * from fruit where code = ? and name = ?";
		PreparedStatement pstmt = conn.prepareStatement(sqlCmd);
		pstmt.setString(1,"1");
		pstmt.setString(2,"apple");
		ResultSet resultSet = pstmt.executeQuery();
		while(resultSet.next()) {
			String a = resultSet.getString("code");
			String b = resultSet.getString("name");
			int c = resultSet.getInt("price");
			System.out.println(a+" "+b+" "+c);
		}
	}
}
