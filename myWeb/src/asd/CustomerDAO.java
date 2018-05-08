package asd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CustomerDAO {
	private CustomerDAO() {
	}

	private static CustomerDAO instance = null;

	public static CustomerDAO getInstance() {
		if (instance == null) {
			instance = new CustomerDAO();
		}
		return instance;
	}

	private Connection getConnection() {//
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hhjlf", "asd3576");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("connecting 실패");
		}
		System.out.println("connecting 성공");
		return conn;
	}

	public int Insert(String name, String jumin, String tel, String gender, StringBuffer hobby) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = 0;
		conn = getConnection();
		try {

			pstmt = conn.prepareStatement("select * from customers where tel=?");
			pstmt.setString(1, jumin);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				x = -1;
				return x;
			}
			pstmt = conn.prepareStatement("insert into customers(name, jumin, tel, gender, hobby) values (?,?,?,?,?)");
			pstmt.setString(1, name);
			pstmt.setString(2, jumin);
			pstmt.setString(4, gender);
			pstmt.setString(3, tel.toString());
			pstmt.setString(5, hobby.toString());
			x = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {

				}
		}
		return x;
	}

	public ObservableList<CustomerVO> getCustomer() {
		ObservableList<CustomerVO> vo = FXCollections.observableArrayList();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement("select * from customers");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				CustomerVO a = new CustomerVO();
				a.setName(rs.getString("name"));
				a.setWnals(rs.getString("jumin"));
				a.setTel(rs.getString("tel"));
				a.setGneder(rs.getString("gender"));
				a.setHobby(rs.getString("hobby"));
				vo.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
		return vo;
	}

	public int Update(String name, String jumin, String tel, String gender, StringBuffer hobby) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int x = 0;
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement("update customers set name =?, tel =?, gender=?,hobby=? where jumin = ? ");
			pstmt.setString(1, name);
			pstmt.setString(2, tel);
			pstmt.setString(3, gender);
			pstmt.setString(4, hobby.toString());
			pstmt.setString(5, jumin);
			x = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
		return x;
	}

	public void Delete(String jumin) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int x = 0;
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement("delete customers where jumin = ? ");
			pstmt.setString(1, jumin);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}

		}
	}
}
