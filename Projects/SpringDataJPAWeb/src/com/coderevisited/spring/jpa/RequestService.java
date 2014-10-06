package com.coderevisited.spring.jpa;

import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class RequestService {
	private static CrudRepository repository;

	//This should be business logic class?
	//private RequestFacade requestFacade;
	

	/**
	 * Get an existing request that was made prior. When a request for certain resources is made i.e, volume
	 * provisioning, a request id is created that is used to identify the point in the process. A requestId is required
	 * for this operation to be successful. This code calls out to the facade that interfaces with the database to
	 * populate the object we expect to return
	 * 
	 * @param requestId
	 *            - the unique identfier of the request
	 * 
	 * @return apiResponse
	 */
	public ApiResponse getRequest(Long requestId) {
		// Create a place holder to an apiResponse object
		ApiResponse apiResponse = null;
		// Ensure that the user has given us a request ID

		//TODO request facade would 
		// Get the required request object from the data store
		//Request requestResponse = requestFacade.getRequest(requestId);
		//Request request = requestFacade

        AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        repository = context.getBean(RequestRepository.class);
        
        createRequest(22, RequestStatus.REQUESTED, "10:23", " ");
        createRequest(23, RequestStatus.REQUESTED, "10:23", " ");
        createRequest(24, RequestStatus.REQUESTED, "10:23", " ");
        
        // fetch all customers
        Iterable<Request> customers = repository.findAll();
        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        for (Request customer : customers) {
            System.out.println(customer);
        }
        System.out.println();
        context.close();
        

		// Put result object into apiResponse
		Request request = new Request(22, RequestStatus.REQUESTED, "May 5 2014", " ");
		apiResponse = new ApiResponse(request);

		Result result = new Result();
		//setErrorCode
		result.setStatus(ApiExecutionStatus.SUCCESS);

		apiResponse.setResult(result);

		return apiResponse;
	}

	private void createRequest	(int id, RequestStatus changeStatus, String requestDate,
			String completeDate) {
		
        Request emp = new Request(id, changeStatus, requestDate, completeDate);
        repository.save(emp);
		
	}


}
