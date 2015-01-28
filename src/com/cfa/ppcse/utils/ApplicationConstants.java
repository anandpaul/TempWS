package com.cfa.ppcse.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author acclimationsupport
 *
 */
public class ApplicationConstants {
	public static final String STATUS_ORDERED = "Ordered";
	public static final String EMPTY_STRING = "";
	public static final String CFA = "CFA";
	public static final String PBI = "PBI";
	public static final String NOMEX = "NOMEX";
	public static final String PBI_GOLD = "GOLD";
	public static final String NOMEX_LIME = "LIME";
	public static final String ORDER_REQUESTS_ALL_QRY = "select * from ppcseSchema.T_ORDER_REQUEST where status in (?)";
	public static final String FETCH_ORDER_ITEM_QRY = "select * from ppcseSchema.T_ORDER_ITEM where request_id =?";
	public static final List<String> STYLABLE_GARMENTS = Collections
			.unmodifiableList(new ArrayList<String>() {

				private static final long serialVersionUID = 1L;

				{
					add("JACKET");
					add("TROUSER");
				}
			});
	public static final String FETCH_SIZES_BY_GROUP_NAME = "select * from ppcseSchema.M_CATALOGUE_ITEMS where product_group = ? and description like ? and catalogue_id=(SELECT [catalogue_id] FROM [ppcseSchema].[M_CATALOGUES] where description = 'ACTIVE') order by material_id";

	public static final String FETCH_MEASUREMENT_DATA = "select * from ppcseSchema.T_MEASUREMENT_REQUEST_ITEM where request_Id=?";
}
