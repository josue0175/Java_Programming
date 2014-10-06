package com.coderevisited.spring.jpa;


public class MockExampleService {

	    public ApiResponse beginHealthCheck() {
	    	ApiResponse apiResponse = null;

			// Put result object into apiResponse

//	    	HealthCheckResult result = new HealthCheckResult();
//	    	result.setSerialNumber("HK1111102345");
//	    	result.setCodeLevel(5597);
//	    	result.setSystemStatus("Up and no warnings");
//	    	result.setUptime(2450000);

			Request request = null; //Request request = spawnHealthCheckThreadFacade();
			apiResponse = new ApiResponse((Request) request);
			apiResponse.setResult(new Result(ApiExecutionStatus.SUCCESS));

	    	return apiResponse;
	    }


}
