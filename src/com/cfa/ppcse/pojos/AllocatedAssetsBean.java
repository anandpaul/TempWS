package com.cfa.ppcse.pojos;

import java.util.List;

public class AllocatedAssetsBean {

	private String memberId;
	private String brigade;
	private List<Assets> assetsList;

	/**
	 * @return the memberId
	 */
	public String getMemberId() {
		return memberId;
	}

	/**
	 * @param memberId
	 *            the memberId to set
	 */
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	/**
	 * @return the brigade
	 */
	public String getBrigade() {
		return brigade;
	}

	/**
	 * @param brigade
	 *            the brigade to set
	 */
	public void setBrigade(String brigade) {
		this.brigade = brigade;
	}

	/**
	 * @return the assetsList
	 */
	public List<Assets> getAssetsList() {
		return assetsList;
	}

	/**
	 * @param assetsList
	 *            the assetsList to set
	 */
	public void setAssetsList(List<Assets> assetsList) {
		this.assetsList = assetsList;
	}

}
