/**
 * 
 */
package com.cfa.ppcse.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.cfa.ppcse.pojos.AllocatedAssetsBean;
import com.cfa.ppcse.pojos.Assets;
import com.cfa.ppcse.pojos.BrigadeBean;
import com.cfa.ppcse.pojos.ItemBean;
import com.cfa.ppcse.pojos.MeasurementRequestBean;
import com.cfa.ppcse.pojos.RequestBean;
import com.cfa.ppcse.pojos.UpdateRequestBean;
import com.cfa.ppcse.utils.ApplicationConstants;
import com.cfa.ppcse.utils.CFAConstants;
import com.cfa.ppcse.utils.CFAException;
import com.cfa.ppcse.utils.CfaQueries;
import com.cfa.ppcse.utils.PPCSEUtility;

/**
 * @author acclimationsupport
 *
 */
public class FetchDataDAO extends BaseDAO {

	private static final Logger LOG = Logger.getLogger(FetchDataDAO.class);

	/**
	 * This method returns the Ordered requests to SAP
	 * 
	 * @return
	 * @throws CFAException
	 */
	public List<RequestBean> getOrderedRequest() throws CFAException {

		List<RequestBean> ordersList = new ArrayList<RequestBean>();
		ordersList.addAll(processResultSet(CfaQueries.FETCH_BRIGADE_APPROVED_REQUESTS));
//		ordersList.addAll(processResultSet(CfaQueries.FETCH_DISTRICT_ADDRESS_REQUESTS));
		LOG.info("List of orders returned - "+ordersList.size());
		return ordersList;
	}

	/**
	 * @param sql
	 * @return
	 * @throws CFAException
	 */
	private List<RequestBean> processResultSet(String sql) throws CFAException {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		RequestBean requestBean = null;
		List<RequestBean> ordersList = new ArrayList<RequestBean>();
		try {

			con = getConnection();
			/*
			 * stmt = con.prepareStatement(
			 * "select * from ppcseSchema.T_ORDER_REQUEST where status in (?) and creation_date = ?"
			 * ); stmt.setString(1, "Ordered"); stmt.setDate(2, new
			 * Date(System.currentTimeMillis()));
			 */
			// stmt =
			// con.prepareStatement("select * from ppcseSchema.T_ORDER_REQUEST where status in (?)");
			stmt = con.prepareStatement(sql);
			stmt.setString(1, ApplicationConstants.STATUS_ENDORSED);
			boolean mtmMaterial = false;
			for (rs = stmt.executeQuery(); rs.next(); ordersList.add(requestBean)) {
				requestBean = new RequestBean();
				String memberNo = rs.getString("member_number");
				// System.out.println("Role - " + rs.getString("role"));
				requestBean.setBrigadeName(rs.getString("bName"));
				requestBean.setBrigadeNumber(rs.getInt("bNum"));
				requestBean.setSurname(rs.getString("surname"));
				requestBean.setMemberNumber(memberNo);
				requestBean.setGivenName(rs.getString("given_name"));
				requestBean.setRequestId(rs.getString("request_id"));
				requestBean.setReason(rs.getString("reason"));
				requestBean.setComment(rs.getString("comment"));
				requestBean.setRoleType(rs.getString("role"));
				requestBean.setApproverComments(rs.getString("approver_comments"));
				System.out.println("rs.getDate(updation_date = " + rs.getString("updation_date") + ", eta - " + rs.getString("eta"));
				 requestBean.setOrderedDate(rs.getDate("updation_date"));
				requestBean.setPriority(rs.getString("priority"));
				// requestBean.setEta(rs.getDate("eta"));

				boolean newRecruit = rs.getBoolean("newRecruit");
				mtmMaterial = fetchItemList(con, requestBean, newRecruit);

				BrigadeBean bBean = new BrigadeBean();
				bBean.setId(rs.getString("bNum"));
				bBean.setBrigade(rs.getString("bName"));
				bBean.setName_1(rs.getString("name1"));
				bBean.setName_2(rs.getString("name2"));
				bBean.setStreetNumber(rs.getString("stNum"));
				bBean.setStreetName_1(rs.getString("stName1"));
				bBean.setStreetName_2(rs.getString("stName2"));
				bBean.setSuburb(rs.getString("suburb"));
				bBean.setState(rs.getString("state"));
				bBean.setPostCode(rs.getInt("postCode"));

				requestBean.setBrigade(bBean);

				// if (mtmMaterial) {
				requestBean.setMeasurement(fetchMeasurement(con, requestBean.getRequestId(), mtmMaterial));
				// }
			}

		} catch (SQLException e) {
			throw new CFAException(CFAConstants.ERROR_CODE_001, CFAConstants.E001_DB_FETCH_ERROR, e);
		} finally {
			closeConnection(rs, stmt, con);
		}
		return ordersList;
	}

	/**
	 * @param requestId
	 * @return
	 * @throws CFAException
	 */
	private MeasurementRequestBean fetchMeasurement(Connection con, String requestId, boolean mtmMaterial) throws CFAException {
		MeasurementRequestBean bean = new MeasurementRequestBean();
		ResultSet rs = null;
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(ApplicationConstants.FETCH_MEASUREMENT_DATA);
			stmt.setString(1, requestId);
			rs = stmt.executeQuery();
			while (rs.next()) {
				if (mtmMaterial) {
					bean.setChestOrBust_A(rs.getString("chest_a"));
					bean.setWaist_B(rs.getString("waist_b"));
					bean.setSeatOrHips_C(rs.getString("seat_c"));
					bean.setSleeveLength_D(rs.getString("sleeve_length_d"));
					bean.setAcrossBack_E(rs.getString("across_back_e"));
					bean.setBackLength_F(rs.getString("back_length_f"));
					bean.setNeck_G(rs.getString("neck_g"));
					bean.setInLeg_H(rs.getString("inleg_h"));
					bean.setOutLeg_I(rs.getString("outleg_i"));
					bean.setKneePadPosition_J(rs.getString("knee_pad_position_j"));
					bean.setFrontRise_K(rs.getString("front_rise_k"));
					bean.setBackRise_L(rs.getString("back_rise_l"));
					bean.setThigh_M(rs.getString("thigh_m"));
				}
				bean.setShOrderNo(rs.getString("Measurement_Form_No"));
				bean.setComments(rs.getString("Comments"));
			}
		} catch (SQLException e) {
			throw new CFAException(CFAConstants.ERROR_CODE_001, CFAConstants.E001_DB_FETCH_ERROR, e);
		} finally {
			closeResources(rs, stmt);
		}

		return bean;
	}

	/**
	 * 
	 * @param requestId
	 * @return
	 * @throws CFAException
	 */
	private boolean fetchItemList(Connection con, RequestBean request, boolean newRecruit) throws CFAException {
		PreparedStatement stmt = null;
		boolean mtmMaterial = false;
		ResultSet resultSet = null;
		List<ItemBean> itemBeanList = new ArrayList<ItemBean>();
		try {
			stmt = con.prepareStatement(CfaQueries.FETCH_ORDER_ITEMS);
			stmt.setString(1, request.getRequestId());
			stmt.setBoolean(2, true);
			ItemBean itemBean;
			resultSet = stmt.executeQuery();
			while (resultSet.next()) {
				itemBean = new ItemBean();
				String productId = resultSet.getString("product_id");
				itemBean.setRequestId(resultSet.getString("request_id"));
				itemBean.setItemRequestId(resultSet.getString("item_request_id"));
				itemBean.setProductID(productId);
				itemBean.setAlteration(resultSet.getString("alteration_details"));
				itemBean.setAltered(resultSet.getBoolean("altered"));
				itemBean.setItemType(resultSet.getString("item_type"));
				itemBean.setQuantity(Integer.valueOf(resultSet.getInt("quantity")));
				String size = resultSet.getString("size");
				itemBean.setVendorMaterialCode(resultSet.getString("vendor_material_code"));
				if (null != size) {
					if (size.endsWith("MTM")) {
						mtmMaterial = true;
					}
//					itemBean.setVendorMaterialCode(getMaterialCode(con, size, itemBean.getProductID()));
				}
				if (newRecruit) {
					if (!("SHORTS".equalsIgnoreCase(productId) || "KIT BAG".equalsIgnoreCase(productId))) {
						itemBeanList.add(itemBean);
					}

				} else {
					itemBeanList.add(itemBean);
				}

			}
			stmt.close();
		} catch (SQLException e) {
			throw new CFAException(CFAConstants.ERROR_CODE_001, CFAConstants.E001_DB_FETCH_ERROR, e);
		} finally {
			closeResources(resultSet, stmt);
		}
		request.setItemBeanList(itemBeanList);
		return mtmMaterial;
	}

	/**
	 * @param con
	 * @param size
	 * @param productID
	 * @return
	 * @throws CFAException
	 */
	private String getMaterialCode(Connection con, String size, String productID) throws CFAException {

		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		String vendorMaterialCode = null;
		try {
			stmt = con.prepareStatement(CfaQueries.FETCH_VENDOR_MATERIAL_CODE);
			stmt.setString(1, size);
			stmt.setString(2, productID);
			resultSet = stmt.executeQuery();
			while (resultSet.next()) {
				vendorMaterialCode = resultSet.getString("vendor_material_code");
			}
		} catch (SQLException e) {
			throw new CFAException(CFAConstants.ERROR_CODE_001, CFAConstants.E001_DB_FETCH_ERROR, e);
		} finally {
			closeResources(resultSet, stmt);
		}
		return vendorMaterialCode;
	}

	/**
	 * This method updates the status of all the successfully processed requests
	 * 
	 * @param reqList
	 * @throws CFAException
	 */
	public boolean updateReqStatus(List<UpdateRequestBean> reqList) throws CFAException {
		Connection con = null;
		boolean success = true;
		PreparedStatement stmt = null;
		boolean commit = true;

		con = getConnection();
		try {
			stmt = con.prepareStatement(CfaQueries.UPDATE_REQUEST_STATUS);

			for (UpdateRequestBean rBean : reqList) {
				LOG.info("req - " + rBean.getRequestId() + ", status - " + rBean.getStatus());
				stmt.setString(1, rBean.getStatus());
				stmt.setInt(2, rBean.getStatusCode());
				stmt.setString(3, "SAP");
				stmt.setDate(4, new Date(System.currentTimeMillis()));
				stmt.setString(5, rBean.getRequestId());
				stmt.addBatch();
			}

			stmt.executeBatch();
			createStatusLog(con, reqList);
		} catch (SQLException e) {
			commit = false;
			success = false;
			throw new CFAException("Error occurred while update the status");
		} finally {
			closeConnection(null, stmt, con, commit);
		}
		return success;
	}

	/**
	 * @return
	 * @throws CFAException
	 */
	public List<AllocatedAssetsBean> getAllocatedAssetsDetailsLogicData() throws CFAException {

		Connection con = null;
		PreparedStatement stmt = null;
		AllocatedAssetsBean allocatedAssetsBean = null;

		List<AllocatedAssetsBean> assetsCreatedOrUpdatedTodayList = new ArrayList<AllocatedAssetsBean>();
		Map<String, String> fireFighterMap = null;
		Map<String, String> assetIDDetailsMap = null;
		List<Assets> assetsList = null;
		ResultSet rs = null;
		try {

			con = getConnection();
			stmt = con
					.prepareStatement("SELECT distinct([TransactionID]),TransactionDate,SerialNumber,ActivityName,Site,SiteType,AssetSupplierCode,RFID,CurrentQueue,GarmentID,Current_Disposition,updation_date FROM [ppcseSchema].[T_LAUNDRY_REQ]");
			rs = stmt.executeQuery();
			if (rs.getFetchSize() > 0) {
				assetIDDetailsMap = PPCSEUtility.fetchAssetDetails(con);
				fireFighterMap = PPCSEUtility.fetchFireFighterDetails(con);
			}
			for (; rs.next(); assetsCreatedOrUpdatedTodayList.add(allocatedAssetsBean)) {
				assetsList = new ArrayList<Assets>();
				allocatedAssetsBean = new AllocatedAssetsBean();
				Assets asset = new Assets();
				asset.setCurrentDisposition(rs.getString("Current_Disposition"));
				asset.setActivityID(rs.getString("ActivityName"));
				asset.setMaterialId(rs.getString("AssetSupplierCode"));
				asset.setAssetID((String) assetIDDetailsMap.get(rs.getString("SerialNumber")));
				if (rs.getString("AssetSupplierCode").contains("INNER")) {
					asset.setRfidINNER(rs.getString("RFID"));
				} else {
					asset.setRfidOUTER(rs.getString("RFID"));
				}
				allocatedAssetsBean.setMemberId((String) fireFighterMap.get(asset.getAssetID()));
				allocatedAssetsBean.setBrigade(rs.getString("Site"));
				assetsList.add(asset);
				allocatedAssetsBean.setAssetsList(assetsList);

			}
		} catch (SQLException e) {
			throw new CFAException(CFAConstants.ERROR_CODE_001, CFAConstants.E001_DB_FETCH_ERROR, e);
		} finally {
			closeConnection(rs, stmt, con);
		}
		return assetsCreatedOrUpdatedTodayList;
	}

	/**
	 * This method gets the status code for the given status
	 * 
	 * @param status
	 * @return
	 * @throws CFAException
	 */
	public int getStatusCode(Connection con, String status) throws CFAException {
		int statusCode = 0;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = con.prepareStatement(CfaQueries.FETCH_STATUS_CODE);
			statement.setString(1, status.toUpperCase());
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				statusCode = resultSet.getInt("ID");
			}
			System.out.println("Status - " + status + ", Status code - " + statusCode);
		} catch (SQLException e) {
			throw new CFAException(CFAConstants.ERROR_CODE_001, CFAConstants.E001_DB_FETCH_ERROR, e);
		} finally {
			closeResources(resultSet, statement);
		}
		return statusCode;
	}

	/**
	 * This method makes an entry into the Status log table to track the request
	 * 
	 * @param con
	 * @param requestBeansList
	 * @throws CFAException
	 */
	private void createStatusLog(Connection con, List<UpdateRequestBean> reqList) throws CFAException {
		String sql = "";
		PreparedStatement stmt = null;
		sql = CfaQueries.CREATE_STATUS_AUDIT_TRAIL;
		try {
			stmt = con.prepareStatement(sql);

			for (UpdateRequestBean rBean : reqList) {
				stmt.setLong(1, Long.parseLong(rBean.getRequestId()));
				stmt.setInt(2, rBean.getStatusCode());
				stmt.setString(3, "SAP");
				stmt.addBatch();
			}
			stmt.executeBatch();
		} catch (SQLException e) {
			throw new CFAException(CFAConstants.ERROR_CODE_004, CFAConstants.E004_DB_UPDATE_ERROR, e);
		} finally {
			closeResources(null, stmt);
		}
	}
}
