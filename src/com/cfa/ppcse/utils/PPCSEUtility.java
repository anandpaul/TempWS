package com.cfa.ppcse.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class PPCSEUtility {
	public static Date convertStringToDate(String strDate) throws Exception {
		// String s = "03/24/2013 21:54";
		Date date = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		try {
			date = simpleDateFormat.parse(strDate);

			System.out.println("date : " + simpleDateFormat.format(date));
		} catch (ParseException ex) {
			System.out.println(ex.getMessage());
			// throw new Exception(ex);
		}

		return date;
	}

	public static String formatDateString(String date) {
		String formattedDateString = null;
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-mm-dd");
		try {
			Date formattedDate = dt.parse(date);
			SimpleDateFormat dtt = new SimpleDateFormat("dd/mm/yyyy");

			formattedDateString = dtt.format(formattedDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return formattedDateString;
	}

	public static java.sql.Date convertStringToSQLDate(String strDate) throws Exception {
		// String s = "03/24/2013 21:54";
		Date date = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		try {
			date = simpleDateFormat.parse(strDate);

		} catch (ParseException ex) {
			System.out.println(ex.getMessage());
			// throw new Exception(ex);
		}
		return new java.sql.Date(date.getTime());
	}

	/**
	 * 
	 * @param con
	 * @return
	 */
	public static Map<String, String> fetchActivityDetails(Connection con) {
		Map<String, String> activitiesMap = new HashMap<String, String>();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement("select act.ID ,act.Name from [CFA_PPCSE_DEV].[ppcseSchema].[Activities] act where act.ID in (SELECT assetLogs.ActivityID"
					+ " FROM [CFA_PPCSE_DEV].[ppcseSchema].[AssetFFAllocations] alloc,[CFA_PPCSE_DEV].[ppcseSchema].[AssetActivityLogs] assetLogs"
					+ "  where assetLogs.[AssetID] =alloc.AssetID)");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				activitiesMap.put(rs.getString("ID"), rs.getString("Name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return activitiesMap;
	}

	/**
	 * 
	 * @param con
	 * @return
	 */
	public static Map<String, String> fetchSiteDetails(Connection con) {
		Map<String, String> siteMap = new HashMap<String, String>();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement("select sites.ID,sites.SiteCode from [CFA_PPCSE_DEV].[ppcseSchema].[Sites] sites where sites.ID in (SELECT assetLogs.SiteID"
					+ "  FROM [CFA_PPCSE_DEV].[ppcseSchema].[AssetFFAllocations] alloc,[CFA_PPCSE_DEV].[ppcseSchema].[AssetActivityLogs] assetLogs"
					+ "  where assetLogs.[AssetID] =alloc.AssetID)");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				siteMap.put(rs.getString("ID"), rs.getString("SiteCode"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return siteMap;
	}

	/**
	 * 
	 * @param con
	 * @return
	 */
	public static Map<String, String> fetchFireFighterDetails(Connection con) {
		Map<String, String> fireFighterMap = new HashMap<String, String>();
		PreparedStatement stmt = null;
		try {
			stmt = con
					.prepareStatement("select distinct(alloc.AssetID),ff.FireFighterRego from  [CFA_PPCSE_DEV].[ppcseSchema].Firefighters ff,[CFA_PPCSE_DEV].[ppcseSchema].[AssetFFAllocations] alloc where alloc.FirefighterID=ff.ID");
			for (ResultSet rs = stmt.executeQuery(); rs.next();) {
				fireFighterMap.put(rs.getString("AssetID"), rs.getString("FireFighterRego"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fireFighterMap;
	}

	/**
	 * 
	 * @param con
	 * @return
	 */
	public static Map<String, String> fetchAssetDetails(Connection con) {
		Map<String, String> assetMap = new HashMap<String, String>();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement("select ID,SerialNo from [CFA_PPCSE_DEV].[ppcseSchema].Assets assets");
			for (ResultSet rs = stmt.executeQuery(); rs.next();) {
				assetMap.put(rs.getString("SerialNo"), rs.getString("ID"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return assetMap;
	}

	/**
	 * This method places ? as many number of times
	 * 
	 * @param length
	 * @return
	 */
	public static String preparePlaceHolders(int length) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < length;) {
			builder.append("?");
			if (++i < length) {
				builder.append(",");
			}
		}
		System.out.println("Built - " + builder.toString());
		return builder.toString();
	}

	/**
	 * This method sets the values for the number of ?
	 * 
	 * @param preparedStatement
	 * @param values
	 * @throws SQLException
	 */
	public static void setValues(PreparedStatement preparedStatement, Object... values) throws SQLException {
		int j = 0;
		for (int i = 1; i <= values.length; i++) {
			preparedStatement.setObject(i + 1, values[j]);
			j++;
		}
	}
}
