package com.cfa.ppcse.ws;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;

import org.apache.log4j.Logger;

import com.cfa.ppcse.business.FetchDataBusiness;
import com.cfa.ppcse.pojos.AllocatedAssetsBean;
import com.cfa.ppcse.pojos.RequestBean;
import com.cfa.ppcse.utils.CFAException;

public class FetchOrdersWebService {
	private static Logger LOG = Logger.getLogger(FetchOrdersWebService.class);

	/**
	 * @return
	 * @throws CFAException
	 * @throws Exception
	 */
	@WebMethod
	public static List<RequestBean> getOrderedRequest() throws CFAException {
		LOG.info("In the getOrderedRequest method");
		List<RequestBean> ordersList = new ArrayList<RequestBean>();
		FetchDataBusiness business = new FetchDataBusiness();
		ordersList = business.getOrderedRequest();
		LOG.debug("Request LIst - " + ordersList);
		return ordersList;
	}

	/**
	 * 
	 * @return
	 * @throws CFAException
	 * 
	 */
	@WebMethod
	public static List<AllocatedAssetsBean> getAllocatedAssetsDetailsLogicData()
			throws CFAException {

		List<AllocatedAssetsBean> assetsCreatedOrUpdatedTodayList = new ArrayList<AllocatedAssetsBean>();
		FetchDataBusiness business = new FetchDataBusiness();
		business.getAllocatedAssetsDetailsLogicData();
		return assetsCreatedOrUpdatedTodayList;
	}

}
