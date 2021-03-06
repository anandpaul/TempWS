/**
 * 
 */
package com.cfa.ppcse.business;

import java.util.List;

import org.apache.log4j.Logger;

import com.cfa.ppcse.dao.FetchDataDAO;
import com.cfa.ppcse.pojos.AllocatedAssetsBean;
import com.cfa.ppcse.pojos.RequestBean;
import com.cfa.ppcse.utils.CFAException;

/**
 * @author acclimationsupport
 *
 */
public class FetchDataBusiness {

	private static final Logger LOG = Logger.getLogger(FetchDataBusiness.class);

	/**
	 * @return
	 * @throws CFAException
	 */
	public List<RequestBean> getOrderedRequest() throws CFAException {
		LOG.info("Get Ordered Request...");
		List<RequestBean> reqList = null;
		FetchDataDAO dataDAO = new FetchDataDAO();
		reqList = dataDAO.getOrderedRequest();
		return reqList;
	}

	/**
	 * @return
	 * @throws CFAException
	 */
	public List<AllocatedAssetsBean> getAllocatedAssetsDetailsLogicData()
			throws CFAException {
		List<AllocatedAssetsBean> beans = null;
		FetchDataDAO dataDAO = new FetchDataDAO();
		beans = dataDAO.getAllocatedAssetsDetailsLogicData();
		return beans;
	}
}
