package com.cfa.ppcse.pojos;

public class Assets {

	private String assetID;
	private String rfidINNER;
	private String rfidOUTER;
	private String materialId;
	private String activityID;
	private String currentDisposition;

	/**
	 * @return the rfidINNER
	 */
	public String getRfidINNER() {
		return rfidINNER;
	}

	/**
	 * @param rfidINNER
	 *            the rfidINNER to set
	 */
	public void setRfidINNER(String rfidINNER) {
		this.rfidINNER = rfidINNER;
	}

	/**
	 * @return the rfidOUTER
	 */
	public String getRfidOUTER() {
		return rfidOUTER;
	}

	/**
	 * @param rfidOUTER
	 *            the rfidOUTER to set
	 */
	public void setRfidOUTER(String rfidOUTER) {
		this.rfidOUTER = rfidOUTER;
	}

	/**
	 * @return the materialId
	 */
	public String getMaterialId() {
		return materialId;
	}

	/**
	 * @param materialId
	 *            the materialId to set
	 */
	public void setMaterialId(String materialId) {
		this.materialId = materialId;
	}

	/**
	 * @return the currentDisposition
	 */
	public String getCurrentDisposition() {
		return currentDisposition;
	}

	/**
	 * @param currentDisposition
	 *            the currentDisposition to set
	 */
	public void setCurrentDisposition(String currentDisposition) {
		this.currentDisposition = currentDisposition;
	}

	/**
	 * @return the assetID
	 */
	public String getAssetID() {
		return assetID;
	}

	/**
	 * @param assetID
	 *            the assetID to set
	 */
	public void setAssetID(String assetID) {
		this.assetID = assetID;
	}

	/**
	 * @return the activityID
	 */
	public String getActivityID() {
		return activityID;
	}

	/**
	 * @param activityID
	 *            the activityID to set
	 */
	public void setActivityID(String activityID) {
		this.activityID = activityID;
	}

}
