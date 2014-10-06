package com.coderevisited.spring.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity	//Request will be persisted in the database;JPA creates a table for Request
public class Request {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) //Autogenerate the primary key
    private int id; //Unique ID of DB entry

	private RequestStatus changeStatus;
	
	private String requestDate;

	private String completeDate;

	public Request(int id, RequestStatus changeStatus, String requestDate,
			String completeDate) {
		this.id = id;
		this.changeStatus = changeStatus;
		this.requestDate = requestDate;
		this.completeDate = completeDate;
	}

	protected Request() { }

	public RequestStatus getChangeStatus() {
		return changeStatus;
	}

	public void setChangeStatus(RequestStatus changeStatus) {
		this.changeStatus = changeStatus;
	}

	public String getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}

	public String getCompleteDate() {
		return completeDate;
	}

	public void setCompleteDate(String completeDate) {
		this.completeDate = completeDate;
	}

	@Override
	public String toString() {
		return "Request [changeStatus=" + changeStatus + ", requestDate="
				+ requestDate + ", completeDate=" + completeDate + "]";
	}
	

}
