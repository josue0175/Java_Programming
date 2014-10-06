package com.coderevisited.spring.jpa;


import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class RequestController {
	
	RequestService requestService = new RequestService();

	/**
	 * <p>Get the details of a request. The request table acts as a queue in the data warehouse. <br>
	 * After a provisioning request has been issued it is added to the request table where it gets picked up and executed.<br>
	 * The user must poll this table to see the status of the request (InProgress, Complete, and so on).</p>
	 * 
	 * GET: /request/requestId/{requestId}
	 * 
	 * @par Required Permission Level:
	 * Storage Provider Administrator, Storage Provider Monitor, 
	 * Tenant Monitor, Tenant Administrator,  Storage Administrator, Local Replication
	 *
	 * @param requestId
	 *  <ul><li>Type: Long</li>
	 *      <li>Length: Long.MAX_VALUE</li>
	 *      <li>mandatory</li></ul>
	 * <p>The Id of the request</p>
	 * 
	 * @return responseObject
	 * <p>The object that corresponds to the provisioning request</p>
	 */
	@RequestMapping(
			method = RequestMethod.GET, 
			value = "system/request/requestId/{requestId}", 
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public @ResponseBody
	ApiResponse getRequest(@PathVariable("requestId") Long requestId) {

		ApiResponse apiResponse = null;

		apiResponse = requestService.getRequest(requestId);

		return apiResponse;


	}
}
