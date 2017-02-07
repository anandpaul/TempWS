/**
 * 
 */
package com.cfa.ppcse.utils;

/**
 * @author acclimationsupport
 *
 */
public interface CfaQueries {

	// Fetches the brigade address for the ordered requests
	String FETCH_BRIGADE_APPROVED_REQUESTS = " select b.Brigade_number bNum,b.Brigade_name bName,b.Name1 name1,b.Name2 name2,b.Street_Number stNum,b.Street_Name1 stName1,b.Street_Name2 stName2,b.Suburb suburb,"
			+ "b.State state,b.Post_Code postCode,r.role_type role, r.* from ppcseSchema.T_ORDER_REQUEST r,ppcseSchema.M_BRIGADE b where r.status=? and r.brigade=b.Brigade_Number "
			+ "and r.brigadeApproved=1";

	// Fetches the brigade address for the ordered requests
	String FETCH_DISTRICT_ADDRESS_REQUESTS = "select b.Brigade_number bNum,d.name bName,d.Name1 name1,d.Name2 name2,d.Street_Number stNum,d.Street_Name1 stName1,d.Street_Name2 stName2,d.Suburb suburb,"
			+ "d.State state,d.Post_Code postCode,r.role_type role, r.* from ppcseSchema.T_ORDER_REQUEST r,ppcseSchema.M_BRIGADE b,ppcseSchema.M_DISTRICT d"
			+ " where r.status=? and r.brigade=b.Brigade_Number and b.District_id=d.ID and r.brigadeApproved=0";

	String UPDATE_REQUEST_STATUS = "update ppcseSchema.T_ORDER_REQUEST set status=?,status_id=?,updated_by=?,updation_date=? where request_id=?";
	
	String FETCH_STATUS_CODE = "SELECT ID FROM ppcseSchema.M_STATUS WHERE upper(status)=?";
	
	String CREATE_STATUS_AUDIT_TRAIL = "INSERT INTO [ppcseSchema].[T_ORDER_REQUEST_STATUS_LOG] ([Request_Id],[Status_Id],[Updated_By]) VALUES (?,?,?)";
}
