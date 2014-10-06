package com.coderevisited.spring.jpa;

public class Result {
	
	/**
	 * ctor
	 */
	public Result() {}

	private Integer errorCode = 0;
	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public ApiExecutionStatus getStatus() {
		return status;
	}

	public void setStatus(ApiExecutionStatus status) {
		this.status = status;
	}

	public String getDetailMessage() {
		return detailMessage;
	}

	public void setDetailMessage(String detailMessage) {
		this.detailMessage = detailMessage;
	}

	/**
	 * Error message
	 * 
	 * <p>
	 * Immutable
	 * <p>
	 * mandatory, readonly for user
	 */	
	private String errorMessage = "";
	/**
	 * API execution status
	 * 
	 * <p>
	 * Immutable
	 * <p>
	 * mandatory, readonly for user
	 */	
	private ApiExecutionStatus status = ApiExecutionStatus.UNDEFINED; 
	/**
	 * Detailed technical message.
	 * 
	 * <p>
	 * Immutable
	 * <p>
	 * mandatory, readonly for user
	 */	
	private String detailMessage = "";
    
	/**
	 * ctor with status
	 * @param apiExecutionStatus
	 */
	public Result(ApiExecutionStatus apiExecutionStatus) {
		this.status = apiExecutionStatus;
	}

	/**
	 * ctor with status and errorCode
	 * @param apiExecutionStatus
	 * @param errorCode
	 */
	public Result(
			ApiExecutionStatus apiExecutionStatus,
			Integer errorCode) {
		this(apiExecutionStatus);
		this.errorCode = errorCode;
	}

	/**
	 * ctor with status, errorCode and errorMessage
	 * @param apiExecutionStatus
	 * @param errorCode
	 * @param errorMessage
	 */
	public Result(
			ApiExecutionStatus apiExecutionStatus,
			Integer errorCode,
			String errorMessage) {
		this(apiExecutionStatus, errorCode);
		this.errorMessage = errorMessage;
	}

	/**
	 * ctor with status, errorCode, errorMessage and detailMessage
	 * @param apiExecutionStatus
	 * @param errorCode
	 * @param errorMessage
	 * @param detailMessage
	 */
	public Result(
			ApiExecutionStatus apiExecutionStatus,
			Integer errorCode,
			String errorMessage,
			String detailMessage) {
		this(apiExecutionStatus, errorCode, errorMessage);
		this.detailMessage = detailMessage;
	}



}
