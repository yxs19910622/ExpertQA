package org.izhong.web.expert;

import org.izhong.web.services.ResolveData;

public class ExpertQAServiceImpl implements ExpertQAService {

	@Override
	public boolean InsertOnedayOrderData(String xmlOrderData) {
		ResolveData resolve = new ResolveData();
		return resolve.resolveOrderData(xmlOrderData);
	}
}
