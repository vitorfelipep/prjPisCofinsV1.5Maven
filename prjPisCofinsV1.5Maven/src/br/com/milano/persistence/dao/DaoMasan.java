package br.com.milano.persistence.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DaoMasan {
	PreparedStatement stmt;
	ResultSet rs;
	Connection con;

	private final String URL = "jdbc:oracle:thin:@//192.168.15.182:1521/MASAN";
	private final String USER = "******";
	private final String PASS = "******";

	protected void open() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection(URL, USER, PASS);
	}

	protected void close() throws Exception {
		con.close();
	}

}
