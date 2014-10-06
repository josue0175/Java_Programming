package com.coderevisited.spring.jpa;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * The result of a Health Check request.
 *
 * @author nickls1 - Shawn-Ryan Nicklin
 */

@XmlRootElement
public class HealthCheckResult {
	
	private String serialNumber;
	private int codeLevel;
	private String systemStatus;
	private long uptime;
	
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public int getCodeLevel() {
		return codeLevel;
	}
	public void setCodeLevel(int codeLevel) {
		this.codeLevel = codeLevel;
	}
	public String getSystemStatus() {
		return systemStatus;
	}
	public void setSystemStatus(String systemStatus) {
		this.systemStatus = systemStatus;
	}
	public long getUptime() {
		return uptime;
	}
	public void setUptime(long uptime) {
		this.uptime = uptime;
	}
	
	@Override
	public String toString() {
		StringBuilder b = new StringBuilder();
		b.append("{\"serialNumber\":\"").append(getSerialNumber()).append("\",\"codeLevel\":").append(getCodeLevel());
		b.append(",\"systemStatus\":\"").append(getSystemStatus()).append("\",\"uptime\":").append(getUptime()).append("}");
		return b.toString();
	}

}
