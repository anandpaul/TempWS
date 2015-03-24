package com.cfa.ppcse.pojos;

import java.util.Date;
import java.util.List;

public class RequestBean {

	private String requestId;
	private String memberNumber;
	private int brigadeNumber;
	private String brigadeName;
	private String surname;
	private String givenName;
	private String reason;
	private String qualificationType;
	private String deliveryAddress;
	private String status;
	private String comment;
	private String roleType;
	private Date orderedDate;
	private BrigadeBean brigade;
	private MeasurementRequestBean measurement;

	private List<ItemBean> itemBeanList;

	/**
	 * @return the orderedDate
	 */
	public Date getOrderedDate() {
		return orderedDate;
	}

	/**
	 * @param orderedDate
	 *            the orderedDate to set
	 */
	public void setOrderedDate(Date orderedDate) {
		this.orderedDate = orderedDate;
	}

	/**
	 * @return the measurement
	 */
	public MeasurementRequestBean getMeasurement() {
		return measurement;
	}

	/**
	 * @param measurement
	 *            the measurement to set
	 */
	public void setMeasurement(MeasurementRequestBean measurement) {
		this.measurement = measurement;
	}

	/**
	 * @return the brigade
	 */
	public BrigadeBean getBrigade() {
		return brigade;
	}

	/**
	 * @param brigade
	 *            the brigade to set
	 */
	public void setBrigade(BrigadeBean brigade) {
		this.brigade = brigade;
	}

	/**
	 * @return the roleType
	 */
	public String getRoleType() {
		return roleType;
	}

	/**
	 * @param roleType
	 *            the roleType to set
	 */
	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	/**
	 * @return the brigadeNumber
	 */
	public int getBrigadeNumber() {
		return brigadeNumber;
	}

	/**
	 * @param brigadeNumber
	 *            the brigadeNumber to set
	 */
	public void setBrigadeNumber(int brigadeNumber) {
		this.brigadeNumber = brigadeNumber;
	}

	/**
	 * @return the brigadeName
	 */
	public String getBrigadeName() {
		return brigadeName;
	}

	/**
	 * @param brigadeName
	 *            the brigadeName to set
	 */
	public void setBrigadeName(String brigadeName) {
		this.brigadeName = brigadeName;
	}

	/**
	 * @return the memberNumber
	 */
	public String getMemberNumber() {
		return memberNumber;
	}

	/**
	 * @return the requestId
	 */
	public String getRequestId() {
		return requestId;
	}

	/**
	 * @param requestId
	 *            the requestId to set
	 */
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	/**
	 * @param memberNumber
	 *            the memberNumber to set
	 */
	public void setMemberNumber(String memberNumber) {
		this.memberNumber = memberNumber;
	}

	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * @param surname
	 *            the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * @return the givenName
	 */
	public String getGivenName() {
		return givenName;
	}

	/**
	 * @param givenName
	 *            the givenName to set
	 */
	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	/**
	 * @return the reason
	 */
	public String getReason() {
		return reason;
	}

	/**
	 * @param reason
	 *            the reason to set
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}

	/**
	 * @return the qualificationType
	 */
	public String getQualificationType() {
		return qualificationType;
	}

	/**
	 * @param qualificationType
	 *            the qualificationType to set
	 */
	public void setQualificationType(String qualificationType) {
		this.qualificationType = qualificationType;
	}

	/**
	 * @return the deliveryAddress
	 */
	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	/**
	 * @param deliveryAddress
	 *            the deliveryAddress to set
	 */
	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment
	 *            the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the itemBeanList
	 */
	public List<ItemBean> getItemBeanList() {
		return itemBeanList;
	}

	/**
	 * @param itemBeanList
	 *            the itemBeanList to set
	 */
	public void setItemBeanList(List<ItemBean> itemBeanList) {
		this.itemBeanList = itemBeanList;
	}

}
