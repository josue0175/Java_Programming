package com.emc.sms.api.test.facades;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import com.emc.sms.api.test.facades.enums.TestObjName;

public abstract class TestRecordObject<K, V> {


//abstract class to hold instances of test runs
//could hold variables and values
//or other information necessary to save in a file
//should implement read, write to a stream
//	Map<T, V> variablePairMapMap = new HashMap<T, V>();
	String name;
	Map<K, V> variablePairMap = null;
	String streamName = null;
	
	/*
	public TestRecordObject () {
		this.name = "MyTestVariablesObject";
		this.variablePairMap = new HashMap<K, V>();
		
	}
	*/
	
	public abstract void setName(String name);
	public abstract void setStreamName(String streamName);
	;
	public abstract String getName();
	public abstract String getStreamName();
	
	public abstract void setVarObjMap(Map<K, V> objMap); 
	public abstract Map<K, V> getVarObjMap();
	public abstract Map<K, V> getMapFromFile();
	public abstract void putMapToFile(Map<TestObjName, Long> testValuesObjMap) throws FileNotFoundException;
//	public abstract void setVarObjMap(Map<TestObjName, Long> objMap);
	
//	public abstract Map<TestObjName, Long> getVarObjMap(Map<TestObjName, Long> objMap);
	

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
