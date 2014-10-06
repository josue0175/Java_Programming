package com.emc.sms.api.test.facades;

import java.util.HashMap;
import java.util.Map;

import com.emc.sms.api.test.facades.enums.TestObjName;

public abstract class TestValueObject {


//abstract class to hold instances of test runs
//could hold variables and values
//or other information necessary to save in a file
//should implement read, write to a stream
	String name;
//	Map<T, V> testValuesObjMap = new HashMap<T, V>();
	Map<TestObjName, Long> testValuesObjMap = null;
	String streamName = null;
	
	public TestValueObject () {
		this.name = "MyTestVariablesObject";
		this.testValuesObjMap = new HashMap<TestObjName, Long>();
		
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	/*
	public void setMgmtObjMap(Map<T, V> objMap) {
		this.testValuesObjMap = objMap;
	}
	public Map<T, V> getMgmtObjMap(Map<T, V> objMap) {
		if(objMap == null) {
			objMap = new HashMap<TestObjName, Long>();
		}
		return objMap;
	}
	*/
	public void setMgmtObjMap(Map<TestObjName, Long> objMap) {
		this.testValuesObjMap = objMap;
	}
	
	public Map<TestObjName, Long> getMgmtObjMap(Map<TestObjName, Long> objMap) {
		if(objMap == null) {
			objMap = new HashMap<TestObjName, Long>();
		}
		return objMap;
	}
	
	public void setStreamName(String streamName) {
		this.streamName = streamName;
	}

	public String getName() {
		return this.name;
	}
	
	
	public String getStreamName(String streamName) {
		return this.streamName;
	}
/*	
	public boolean writeSerialTestObj (Map<T, V> objMap, String stream, FileOutputStrem fops) {
		//SAVE serialized objects into file for later useS
		FileOutputStream fos = new FileOutputStream("/tmp/map.ser");
        ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(fos);
			oos.writeObject(objMap);
			oos.close();
			//Clean up all variables referenced in serialized object file 
			cleanAllObjects(TestExecType.PROVISION);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//Write class/method to save object pairs in ASCII
		return objMap;
	}
	*/
}