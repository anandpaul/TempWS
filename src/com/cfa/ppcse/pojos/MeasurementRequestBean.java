package com.cfa.ppcse.pojos;

import java.util.Date;

public class MeasurementRequestBean {

	private String measurementId;
	private String shOrderNo;
	private String requestorId;
	private String createdBy;
	private String updatedBy;
	private Date creationDate;
	private Date updationDate;
	private String style;
	private String file;

	/**
	 * MTM details
	 */

	/* Jacket */
	private String chestOrBust_A;
	private String waist_B;
	private String seatOrHips_C;
	private String neck_G;
	private String sleeveLength_D;
	private String acrossBack_E;
	private String backLength_F;

	/* Trouser */
	private String inLeg_H;
	private String outLeg_I;
	private String kneePadPosition_J;
	private String frontRise_K;
	private String backRise_L;
	private String thigh_M;

	/**
	 * @return the requestorId
	 */
	public String getRequestorId() {
		return requestorId;
	}

	/**
	 * @param requestorId
	 *            the requestorId to set
	 */
	public void setRequestorId(String requestorId) {
		this.requestorId = requestorId;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy
	 *            the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the updatedBy
	 */
	public String getUpdatedBy() {
		return updatedBy;
	}

	/**
	 * @param updatedBy
	 *            the updatedBy to set
	 */
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	/**
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creationDate
	 *            the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * @return the updationDate
	 */
	public Date getUpdationDate() {
		return updationDate;
	}

	/**
	 * @param updationDate
	 *            the updationDate to set
	 */
	public void setUpdationDate(Date updationDate) {
		this.updationDate = updationDate;
	}

	/**
	 * @return the shOrderNo
	 */
	public String getShOrderNo() {
		return shOrderNo;
	}

	/**
	 * @param shOrderNo
	 *            the shOrderNo to set
	 */
	public void setShOrderNo(String shOrderNo) {
		this.shOrderNo = shOrderNo;
	}

	/**
	 * @return the style
	 */
	public String getStyle() {
		return style;
	}

	/**
	 * @param style
	 *            the style to set
	 */
	public void setStyle(String style) {
		this.style = style;
	}

	/**
	 * @return the chestOrBust_A
	 */
	public String getChestOrBust_A() {
		return chestOrBust_A;
	}

	/**
	 * @param chestOrBust_A
	 *            the chestOrBust_A to set
	 */
	public void setChestOrBust_A(String chestOrBust_A) {
		this.chestOrBust_A = chestOrBust_A;
	}

	/**
	 * @return the waist_B
	 */
	public String getWaist_B() {
		return waist_B;
	}

	/**
	 * @param waist_B
	 *            the waist_B to set
	 */
	public void setWaist_B(String waist_B) {
		this.waist_B = waist_B;
	}

	/**
	 * @return the seatOrHips_C
	 */
	public String getSeatOrHips_C() {
		return seatOrHips_C;
	}

	/**
	 * @param seatOrHips_C
	 *            the seatOrHips_C to set
	 */
	public void setSeatOrHips_C(String seatOrHips_C) {
		this.seatOrHips_C = seatOrHips_C;
	}

	/**
	 * @return the sleeveLength_D
	 */
	public String getSleeveLength_D() {
		return sleeveLength_D;
	}

	/**
	 * @param sleeveLength_D
	 *            the sleeveLength_D to set
	 */
	public void setSleeveLength_D(String sleeveLength_D) {
		this.sleeveLength_D = sleeveLength_D;
	}

	/**
	 * @return the acrossBack_E
	 */
	public String getAcrossBack_E() {
		return acrossBack_E;
	}

	/**
	 * @param acrossBack_E
	 *            the acrossBack_E to set
	 */
	public void setAcrossBack_E(String acrossBack_E) {
		this.acrossBack_E = acrossBack_E;
	}

	/**
	 * @return the backLength_F
	 */
	public String getBackLength_F() {
		return backLength_F;
	}

	/**
	 * @param backLength_F
	 *            the backLength_F to set
	 */
	public void setBackLength_F(String backLength_F) {
		this.backLength_F = backLength_F;
	}

	/**
	 * @return the neck_G
	 */
	public String getNeck_G() {
		return neck_G;
	}

	/**
	 * @param neck_G
	 *            the neck_G to set
	 */
	public void setNeck_G(String neck_G) {
		this.neck_G = neck_G;
	}

	/**
	 * @return the inLeg_H
	 */
	public String getInLeg_H() {
		return inLeg_H;
	}

	/**
	 * @param inLeg_H
	 *            the inLeg_H to set
	 */
	public void setInLeg_H(String inLeg_H) {
		this.inLeg_H = inLeg_H;
	}

	/**
	 * @return the outLeg_I
	 */
	public String getOutLeg_I() {
		return outLeg_I;
	}

	/**
	 * @param outLeg_I
	 *            the outLeg_I to set
	 */
	public void setOutLeg_I(String outLeg_I) {
		this.outLeg_I = outLeg_I;
	}

	/**
	 * @return the kneePadPosition_J
	 */
	public String getKneePadPosition_J() {
		return kneePadPosition_J;
	}

	/**
	 * @param kneePadPosition_J
	 *            the kneePadPosition_J to set
	 */
	public void setKneePadPosition_J(String kneePadPosition_J) {
		this.kneePadPosition_J = kneePadPosition_J;
	}

	/**
	 * @return the frontRise_K
	 */
	public String getFrontRise_K() {
		return frontRise_K;
	}

	/**
	 * @param frontRise_K
	 *            the frontRise_K to set
	 */
	public void setFrontRise_K(String frontRise_K) {
		this.frontRise_K = frontRise_K;
	}

	/**
	 * @return the backRise_L
	 */
	public String getBackRise_L() {
		return backRise_L;
	}

	/**
	 * @param backRise_L
	 *            the backRise_L to set
	 */
	public void setBackRise_L(String backRise_L) {
		this.backRise_L = backRise_L;
	}

	/**
	 * @return the thigh_M
	 */
	public String getThigh_M() {
		return thigh_M;
	}

	/**
	 * @param thigh_M
	 *            the thigh_M to set
	 */
	public void setThigh_M(String thigh_M) {
		this.thigh_M = thigh_M;
	}

	/**
	 * @return the file
	 */
	public String getFile() {
		return file;
	}

	/**
	 * @param file
	 *            the file to set
	 */
	public void setFile(String file) {
		this.file = file;
	}

	public String getMeasurementId() {
		return measurementId;
	}

	public void setMeasurementId(String measurementId) {
		this.measurementId = measurementId;
	}

}