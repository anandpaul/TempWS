/**
 * 
 */
package com.cfa.ppcse.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.cfa.ppcse.utils.CFAConstants;
import com.cfa.ppcse.utils.CFAException;

/**
 * This is the Base DAO class to create and close the DB connections and is the
 * architectural DAO for the entire application
 * 
 * @author anandap
 * 
 */
public class BaseDAO {

	/**
	 * This method gets the DB connection and returns the connection object
	 * 
	 * @return
	 * @throws CFAException
	 */
	public Connection getConnection() throws CFAException {
		Connection con = null;
		// InitialContext ctx;

		try {

			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:jboss/");
			// ctx = new InitialContext();
			// DataSource ds=(DataSource)ctx.lookup("jdbc/SES_PPCE_MAXDB");
			DataSource ds = (DataSource) envCtx.lookup("Datasources/ppceDS");
			// DataSource ds=(DataSource)envCtx.lookup("Datasources/testDS");

			con = ds.getConnection();
			con.setAutoCommit(false);
			con.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);

		} catch (NamingException e) {
			throw new CFAException(CFAConstants.ERROR_CODE_002,
					CFAConstants.E002_DB_CONNECTION_ERROR, e);
		} catch (SQLException e) {
			throw new CFAException(CFAConstants.ERROR_CODE_002,
					CFAConstants.E002_DB_CONNECTION_ERROR, e);
		}
		return con;
	}

	/**
	 * This method closes all the database related objects so as to free the
	 * database pool
	 * 
	 * @param rs
	 * @param st
	 * @param con
	 * @param commit
	 * @throws CFAException
	 */
	public void closeConnection(ResultSet rs, Statement st, Connection con,
			boolean commit) throws CFAException {
		closeResources(rs, st);
		closeConnection(con, commit);

	}

	/**
	 * This method closes all the database related objects so as to free the
	 * database pool. This method is required for methods that perform select
	 * operation in Database
	 * 
	 * @param rs
	 * @param st
	 * @param con
	 * @throws CFAException
	 */
	public void closeConnection(ResultSet rs, Statement st, Connection con)
			throws CFAException {
		try {
			if (rs != null) {
				rs.close();
			}
			if (st != null) {
				st.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			throw new CFAException(CFAConstants.ERROR_CODE_002,
					CFAConstants.E003_DB_CLOSE_CONNECTION_ERROR, e);
		}
	}

	/**
	 * This method closes the Result set and statement alone
	 * 
	 * @param rs
	 * @param st
	 * @throws CFAException
	 */
	public void closeResources(ResultSet rs, Statement st) throws CFAException {
		try {
			if (rs != null) {
				rs.close();
			}
			if (st != null) {
				st.close();
			}
		} catch (SQLException e) {
			throw new CFAException(CFAConstants.ERROR_CODE_002,
					CFAConstants.E003_DB_CLOSE_CONNECTION_ERROR, e);
		}
	}

	/**
	 * This method closes the connection. Based on the commit value, it will
	 * commit or rollback
	 * 
	 * @param con
	 * @param commit
	 * @throws CFAException
	 */
	public void closeConnection(Connection con, boolean commit)
			throws CFAException {
		try {
			if (con != null) {
				if (commit) {
					con.commit();
				} else {
					con.rollback();
				}
				con.close();
			}
		} catch (SQLException e) {
			throw new CFAException(CFAConstants.ERROR_CODE_002,
					CFAConstants.E003_DB_CLOSE_CONNECTION_ERROR, e);
		}

	}
}
