package com.cfa.ppcse.pojos;

public class ItemBean {
	private String requestId;
	private String itemRequestId;
	private String productID;
	private Integer quantity;
	private String alteration;
	private String vendorMaterialCode;
	private String itemType;
	private boolean altered;

	/**
	 * @return the altered
	 */
	public boolean isAltered() {
		return altered;
	}

	/**
	 * @param altered
	 *            the altered to set
	 */
	public void setAltered(boolean altered) {
		this.altered = altered;
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
	 * @return the itemRequestId
	 */
	public String getItemRequestId() {
		return itemRequestId;
	}

	/**
	 * @param itemRequestId
	 *            the itemRequestId to set
	 */
	public void setItemRequestId(String itemRequestId) {
		this.itemRequestId = itemRequestId;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getAlteration() {
		return alteration;
	}

	public void setAlteration(String alteration) {
		this.alteration = alteration;
	}

	public String getVendorMaterialCode() {
		return vendorMaterialCode;
	}

	public void setVendorMaterialCode(String vendorMaterialCode) {
		this.vendorMaterialCode = vendorMaterialCode;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

}
