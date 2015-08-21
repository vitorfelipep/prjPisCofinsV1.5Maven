package br.com.milano.persistence.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DaoMilano {
	PreparedStatement stmt;
	ResultSet rs;
	Connection con;

	private final String URL = "jdbc:oracle:thin:@//192.168.15.182:1521/MILANO";
	private final String USER = "sapiens2";
	private final String PASS = "senior2";

	protected void open() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection(URL, USER, PASS);
	}

	protected void close() throws Exception {
		con.close();
	}
}
