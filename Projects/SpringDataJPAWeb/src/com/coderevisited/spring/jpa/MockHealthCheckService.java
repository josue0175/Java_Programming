package com.coderevisited.spring.jpa;

public class MockHealthCheckService {

    public HealthCheckResult beginHealthCheck() {
    	HealthCheckResult result = new HealthCheckResult();
    	result.setSerialNumber("HK1111102345");
    	result.setCodeLevel(5597);
    	result.setSystemStatus("Up and no warnings");
    	result.setUptime(2450000);

    	return result;
    }

}
