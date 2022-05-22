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
	
	public void selectAll() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection conn = this.getConnection();
		Statement stmt = conn.createStatement();
		String sqlCmd = "select * from fruit";

		ResultSet resultSet = stmt.executeQuery(sqlCmd);
		while(resultSet.next()) {
			String a = resultSet.getString("code");
			String b = resultSet.getString("name");
			int c = resultSet.getInt("price");
			System.out.println(a+" "+b+" "+c);
		}
	}
	
	public void select(String name, int price) throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection conn = this.getConnection();
//		Statement stmt = conn.createStatement();
		String sqlCmd = "select * from fruit where name = ? and price = ?";
		PreparedStatement pstmt = conn.prepareStatement(sqlCmd);
		pstmt.setString(1,name);
		pstmt.setInt(2,price);
		ResultSet resultSet = pstmt.executeQuery();
		while(resultSet.next()) {
			String a = resultSet.getString("code");
			String b = resultSet.getString("name");
			int c = resultSet.getInt("price");
			System.out.println(a+" "+b+" "+c);
		}
	}
	
	public void insert(String code, String name, int price) throws SQLException {
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		Connection conn = this.getConnection();
		String sqlCmd = "insert into fruit Values (?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sqlCmd);
		pstmt.setString(1,code);
		pstmt.setString(2,name);
		pstmt.setInt(3,price);
		pstmt.executeUpdate();
	}
	
	public void updatePriceByName(String name, int price) throws SQLException {
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		Connection conn = this.getConnection();
		String sqlCmd = "UPDATE fruit SET price=? where name = ?";
		PreparedStatement pstmt = conn.prepareStatement(sqlCmd);
		pstmt.setInt(1,price);
		pstmt.setString(2,name);
		pstmt.executeUpdate();
	}
	
	public void deleteByName(String name) throws SQLException {
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		Connection conn = this.getConnection();
		String sqlCmd = "DELETE FROM fruit where name = ?";
		PreparedStatement pstmt = conn.prepareStatement(sqlCmd);
		pstmt.setString(1, name);
		pstmt.executeUpdate();
	}
	
	public void innerJoinByName() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection conn = this.getConnection();
//		Statement stmt = conn.createStatement();
		String sqlCmd = "SELECT name,fruit.price from test.fruit inner join market using (name);";
		PreparedStatement pstmt = conn.prepareStatement(sqlCmd);
//		pstmt.setString(1,name);
		ResultSet resultSet = pstmt.executeQuery();
		while(resultSet.next()) {
			String a = resultSet.getString("name");
			int b = resultSet.getInt("price");
			System.out.println(a+" "+b);
		}
	}
	
	public void leftJoinByName() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection conn = this.getConnection();
//		Statement stmt = conn.createStatement();
		String sqlCmd = "SELECT name,fruit.price from test.fruit left join market using (name);";
		PreparedStatement pstmt = conn.prepareStatement(sqlCmd);
//		pstmt.setString(1,name);
		ResultSet resultSet = pstmt.executeQuery();
		while(resultSet.next()) {
			String a = resultSet.getString("name");
			int b = resultSet.getInt("price");
			System.out.println(a+" "+b);
		}
	}
	
	public void rightJoinByName() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection conn = this.getConnection();
//		Statement stmt = conn.createStatement();
		String sqlCmd = "SELECT name,fruit.price from test.fruit right join market using (name);";
		PreparedStatement pstmt = conn.prepareStatement(sqlCmd);
//		pstmt.setString(1,name);
		ResultSet resultSet = pstmt.executeQuery();
		while(resultSet.next()) {
			String a = resultSet.getString("name");
			int b = resultSet.getInt("price");
			System.out.println(a+" "+b);
		}
	}
}
