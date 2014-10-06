package com.coderevisited.spring.jpa;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * ReST Endpoint for the Platform Get and Verify Cache Service.
 *
 * @author nickls1 : Shawn-Ryan Nicklin
 */
@Controller
public class ExampleController {


	//@RequestMapping(method= RequestMethod.GET, produces = "application/json", headers="Accept=*/*")
	@RequestMapping(value = "system/example", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody ApiResponse healthCheck() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		ApiResponse apiResponse = null;
		// this should leverage dependency injection

		/*For demo/test purposes outside the VMAX env*/
//		demoDerbyDB();
		MockExampleService service = new MockExampleService();
		apiResponse = service.beginHealthCheck();
		return apiResponse;

		//return new HealthCheckService().beginHealthCheck();
	}


}
