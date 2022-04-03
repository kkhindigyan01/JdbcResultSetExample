package com.kkhindigyan.client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.kkhindigyan.util.DBUtil;
/**
 * JDBC ResultSet Example
 * @author KK HindiGyan
 *
 */
public class JdbcUpdatabeResultSetExample {

	public static void main(String[] args) {

		String SQL = "SELECT * FROM employee";
		
		try(Connection conn = DBUtil.getMySQLConnection();PreparedStatement stmt = conn.prepareStatement(SQL,
				ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE)
				;ResultSet rs = stmt.executeQuery();) {
			
			int empId = 3;
			Double newSal=50000.00;
			
			while (rs.next()) {
				if( rs.getInt("employee_id") == empId) {
					rs.updateDouble("employee_salary", newSal);
					rs.updateRow();
					System.out.println("Salary is updated..");
					break;
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
