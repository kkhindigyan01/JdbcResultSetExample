package com.kkhindigyan.client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

import com.kkhindigyan.util.DBUtil;
/**
 * JDBC ResultSet Example
 * @author KK HindiGyan
 *
 */
public class JdbcUpdatabeResultSetExample2 {

	public static void main(String[] args) {

		String SQL = "SELECT * FROM employee";
		
		try(Connection conn = DBUtil.getMySQLConnection();PreparedStatement stmt = conn.prepareStatement(SQL,
				ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE)
				;ResultSet rs = stmt.executeQuery();) {
			
			rs.moveToInsertRow();
			
			rs.updateString("employee_name", "Bean");
			rs.updateDouble("employee_salary", 60000.00);
			rs.updateString("employee_dept", "IT");
			rs.updateObject("employee_doj", LocalDate.of(2022, 04, 03));
			
			rs.insertRow();
			
			System.out.println("Row is inserted...");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
