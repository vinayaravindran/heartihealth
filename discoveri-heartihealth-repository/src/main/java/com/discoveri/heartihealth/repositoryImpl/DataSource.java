package com.discoveri.heartihealth.repositoryImpl;
import java.sql.Connection;
import java.sql.DriverManager;

import org.discoveri.heartihealth.configuration.DBConfiguration;

public class DataSource {
	public static Connection getConnetion() {
		Connection con=null;
		try {
			Class.forName(DBConfiguration.className);
			con = DriverManager.getConnection(DBConfiguration.dbUrl, DBConfiguration.userName, DBConfiguration.password);
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}
}
