package com.cfa.ppcse.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class DBConnection {

	public Connection openConnectionToDB(){
		InitialContext ctx;
		
		try {
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String userName = "svc_PPCSE";
            String password = "PpC53ACc0un3je#hr2";
            String url = "jdbc:sqlserver://10.215.77.82:1433;databaseName=CFA_PPCSE_DEV";
            con = DriverManager.getConnection(url, userName, password);
			
			con.setAutoCommit(false);
			con.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 		
    
        return con;
	}
	public boolean closeConnectionToDB(Connection con,boolean cleanTransactionFlag){
		try {
			if(con!=null){
				if(cleanTransactionFlag){
					con.commit();
					con.close();
				}else{
					con.rollback();
					con.close();
					return false;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	private Connection con = null;
}
