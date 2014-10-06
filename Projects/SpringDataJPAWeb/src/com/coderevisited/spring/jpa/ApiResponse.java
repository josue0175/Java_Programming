package com.coderevisited.spring.jpa;

public class ApiResponse {
	/**
	 * Result of the API execution
	 * 
	 * <p>
	 * Immutable
	 * <p>
	 * Readonly
	 */
	private Result result;
	
	/**
	 * Type of the returned object.
	 * 
	 * <p>
	 * Immutable
	 * <p>
	 * Readonly
	 */
	private String responseObjectType = "";
	
	/**
	 * Restuned object from API execution
	 * 
	 * <p>
	 * Immutable
	 * <p>
	 * Readonly
	 */
	private Object responseObject = null;
	
	/**
	 * ctor
	 */
	
	public ApiResponse() {}
	
	/**
	 * ctor - @param responseObject
	 * @param responseObject 
	 */
	public ApiResponse(Object responseObject) {
		if (responseObject == null) {
			this.responseObjectType = "void";
		}
		else {
			this.responseObject = responseObject;
			this.responseObjectType = responseObject.getClass().getSimpleName();
		}
	}

	/**
	 * @return responseObjectType
	 * <p>The type of the response object</p>
	 */
	public String getResponseObjectType() {
		return this.responseObjectType;
	}

	/// @cond
	/**
	 * @return the result
	 * <p>The result</p>
	 */
	/// @endcond
	public Result getResult() {
		return this.result;
	}

	/// @cond
	/**
	 * @param result
	 * <p>The result to set</p>
	 */
	/// @endcond
	public void setResult(Result result) {
		if(this.result == null){
			this.result = new Result();
		}
		this.result = result;
	}

	/// @cond
	/**
	 * @return responseObject
	 * <p>The response object that gets returned</p>
	 */
	/// @endcond
	public Object getResponseObject() {
		return this.responseObject;
	}

	/// @cond
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	/// @endcond
	@Override
	public String toString() {
		return "ApiResponse [result=" + this.result + ", responseObjectType="
				+ this.responseObjectType + ", responseObject="
				+ this.responseObject + "]";
	}

}

