package com.ifudata.ums.api.testdamon.interfaces;


import com.ifudata.ums.api.testdamon.param.TestDamonRequest;
import com.ifudata.ums.api.testdamon.param.TestDamonResponse;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/damonTest")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({MediaType.APPLICATION_JSON,MediaType.TEXT_XML,MediaType.TEXT_PLAIN})
public interface ITestDamonDubboSV {
	/**
	 *
	 * @param req
	 * @return
	 */
	@POST
	@Path("/batchApply")
	TestDamonResponse testQuery(TestDamonRequest req);
}
