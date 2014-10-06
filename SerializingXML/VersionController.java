/**
 * VersionController.java
 * Copyright 2012, EMC Corporation.  All rights reserved. 
 */
package com.emc.sp.api.rest.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import com.thoughtworks.xstream.*;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.QNameMap;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.thoughtworks.xstream.XStream;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.emc.sp.api.rest.model.ApiVersion;
import com.emc.sp.api.rest.model.Global;

/**
 * @author madhas
 *
 */
@Controller
@RequestMapping(Global.BaseUrlPrefix)
public class VersionController {
	/**
	 * Get API Version details
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, 
			value = "",
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
			headers = "Accept=application/json, application/xml")
	public @ResponseBody ApiVersion getVersion() {
		System.out.println("getVersion");
		
		XStream xstream = new XStream(new StaxDriver());
		//processAnnotations was needed in order to avoid a "cannot find class" problem with XStream mapper
		xstream.processAnnotations(ApiVersion.class);
		//DOES NOT WORK		xstream.autodetectAnnotations(true);
		ApiVersion apiVersion = new ApiVersion();
		
		try {
				/*
				//WORKS!!	
				String jboss_conf =  System.getProperty("jboss.server.home.dir");
				String filename = jboss_conf + File.separator + "conf" + File.separator + "apiVersion.xml";
				FileInputStream inStream = new FileInputStream(filename);
	            xstream.fromXML(inStream, apiVersion);
	            */
			
				//TODO: What checks need to be done on Java IO?
				//null file?  close streams/files?
				File jbossConfDir = new File("/conf"); 
				File jbossConfPath =  new File(System.getProperty("jboss.server.home.dir") + jbossConfDir);
				File filename = new File(jbossConfPath, "apiVersion.xml");
				FileInputStream inStream = new FileInputStream(filename);
	            xstream.fromXML(inStream, apiVersion);
	            inStream.close();
                
	    } catch (Exception ex) {
	                ex.printStackTrace();
	    }

		return apiVersion;
	}
}
