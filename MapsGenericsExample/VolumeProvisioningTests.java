
import com.emc.sms.api.test.facades.impl.TestVarObject;


import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.emc.sms.api.rest.UserContext;
import com.emc.sms.api.rest.VolumeFacade;
import com.emc.sms.api.rest.impl.VolumeFacadeImpl;
import com.emc.sms.api.rest.response.RequestResponse;
import com.emc.sms.api.rest.response.VolumeResponse;
import com.emc.sms.api.test.facades.CommonUtilsForTest;
import com.emc.sms.api.test.facades.ConstantsForTests;
import com.emc.sms.api.test.facades.TestRecordObject;
import com.emc.sms.api.test.facades.enums.TestExecType;
import com.emc.sms.api.test.facades.enums.TestObjName;
import com.emc.sp.api.rest.model.Request;
import com.emc.sp.api.rest.model.Volume;
import com.emc.sp.api.rest.model.enums.ResultResponseStatus;
import com.emc.sp.api.rest.model.enums.VolumeMetaOption;

public class VolumeProvisioningTests extends CommonUtilsForTest {
	
	private static final Logger LOGGER = Logger.getLogger(VolumeProvisioningTests.class);
	
	private static UserContext userContext = null;
	private static Long applicationId1 = null;
	private static Long businessUnitId1 = null;
	private static Long accountId1 = null;
	private static Long functionId1 = null;
	private static Long replicaGroupId = null;
	private static Long serviceLevelId = null;
	private static Long hostId1 = null;
	private static Long hostId2 = null;
	private static Long hostPortId1 = null;
	private static Long hostPortId2 = null;
	private static Long volumeId1 = null;
	private static Long hostGroupId1 = null;
	private static Long requestId1 = null;
	private static Long clientId1 = null;
	private static Long subclientId1 = null;
	
	 @AfterClass
     public static void teardown() throws IOException, ClassNotFoundException {
		TestRecordObject<TestObjName, Long> testVarObject = new TestVarObject();
		testVarObject.setName("@AfterClass Variable List");
		testVarObject.setStreamName("/tmp/map.ser");
		Map<TestObjName, Long> objMap = testVarObject.getVarObjMap();
		
		//Save current variable values into a hashmap
		objMap.put(TestObjName.BUSINESSUNITID1, businessUnitId1);
		objMap.put(TestObjName.ACCOUNTID1, accountId1);
		objMap.put(TestObjName.FUNCTIONID1, functionId1);
		objMap.put(TestObjName.APPLICATIONID1, applicationId1);
		objMap.put(TestObjName.HOSTID1, hostId1);
		objMap.put(TestObjName.HOSTID2, hostId1);
		objMap.put(TestObjName.HOSTPORTID1, hostPortId1);
		objMap.put(TestObjName.HOSTPORTID2, hostPortId2);
		objMap.put(TestObjName.HOSTGROUPID1, hostGroupId1);
		testVarObject.setVarObjMap(objMap);
		testVarObject.putMapToFile(objMap);
		cleanAllObjects(TestExecType.PROVISION, testVarObject);
		
		//SAVE serialized objects into file for later useS
		/*
		FileOutputStream fos = new FileOutputStream("/tmp/map.ser");
        ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(fos);
			oos.writeObject(objMap);
			oos.close();
			//Clean up all variables referenced in serialized object file 
			//cleanAllObjects(TestExecType.PROVISION);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		*/
		
		//SAVE Mangement Objects in ASCII filee
		Map<TestObjName, Long> mgmtObjMap = new HashMap<TestObjName, Long>();
		if(requestId1 != null) mgmtObjMap.put(TestObjName.REQUESTID1, requestId1);
		if(clientId1 != null) mgmtObjMap.put(TestObjName.CLIENTID1, clientId1);
		if(subclientId1 != null) mgmtObjMap.put(TestObjName.SUBCLIENTID1, subclientId1);
		BufferedWriter out = 
				new BufferedWriter (new OutputStreamWriter(new FileOutputStream("/tmp/mgmtIdTable.txt"), "UTF-8"));
		try {
    		Iterator<Entry<TestObjName, Long>> it = mgmtObjMap.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry pairs = (Map.Entry)it.next();
				System.out.println(pairs.getKey() + " = " + pairs.getValue());
				String output = null;
				out.write(pairs.getKey().toString() + " " + pairs.getValue().toString());
				out.newLine();
			} 
	
		} finally {
			out.close();
		}
		 
		 /*
		 if(volumeId1 != null) deleteAndProvisionVolume(volumeId1);
		 if(hostGroupId != null) cleanHostGroup(TestExecType.PROVISION, hostGroupId);
		 if(applicationId1 != null) cleanApplication(TestExecType.PROVISION, applicationId1);
		 if(hostPortId1 != null) cleanHostPort(TestExecType.PROVISION, hostPortId1);
		 if(hostPortId2 != null) cleanHostPort(TestExecType.PROVISION, hostPortId2);
		 if(hostId11 != null) cleanHost(TestExecType.PROVISION, hostId11);
		 if(hostId12 != null)  cleanHost(TestExecType.PROVISION, hostId12);
		 if(functionId1 != null) cleanFunction(TestExecType.PROVISION, functionId1);
		 if(accountId1 != null) cleanAccount(TestExecType.PROVISION, accountId1);
		 if(businessUnitId1 != null) cleanBusinessUnit(TestExecType.PROVISION, businessUnitId1);
		 */
     }

	@Before
    public void setupNoErrors() throws Exception {
		
		TestRecordObject<TestObjName, Long> testVarObject = new TestVarObject();
		testVarObject.setStreamName("/tmp/map.ser");
		testVarObject.setName("@Before TestRun Var List");
		//Calling getMapFromFile loads the Variable/Value pair into the object
		System.out.println(testVarObject.getMapFromFile());
		cleanAllObjects(TestExecType.PROVISION, testVarObject);
	/*	
    	//Map<TestObjName, Long> objMap = null;
        try {
        	FileInputStream fis = new FileInputStream("/tmp/map.ser");
        	ObjectInputStream ois = new ObjectInputStream(fis);
        	objMap = (Map) ois.readObject();
        	ois.close();
        	System.out.println("The last job's set of object IDs: ");
        	System.out.println(objMap);
			cleanAllObjects(TestExecType.PROVISION);
        } catch (Exception i) {
        	i.printStackTrace();
        }
        */
        
		/*
		BufferedWriter out = 
				new BufferedWriter (new OutputStreamWriter(new FileOutputStream("/tmp/varIdTable.txt"), "UTF-8"));
		try {
    	Iterator<Entry<TestObjName, Long>> it = objMap.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pairs = (Map.Entry)it.next();
			System.out.println(pairs.getKey() + " = " + pairs.getValue());
			String output = null;
				//output = String.format(format, args)
				out.write(pairs.getKey().toString() + " " + pairs.getValue().toString());
				out.newLine();
			} 
		
		} finally {
			out.close();
		}
		*/
		userContext = getUserContextGood(TestExecType.PROVISION);
		clientId1 = userContext.getClientId();
		subclientId1 = userContext.getSubClientId();
		 
	}
		 
	@Test
    public void volumeProvisioningTests() throws Exception {
		
            
		
	}
	
    private void volumeProvisioning(VolumeMetaOption metaOption, Long size, Long count) throws Exception {
		
		String func = "volumeProvisioning()...";
		
		VolumeFacade volumeFacade = new VolumeFacadeImpl();
		
		Volume volume = null;
		Volume volumeUpdates = null;
		Request request = null;
		RequestResponse requestResponse = null;
		VolumeResponse volumeResponse = null;
		List <Long> volumeIds = null;
		
		if (volumeId1 == null) {
			//
			// setup arguments
			//
			volume = new Volume();
			volume.setName(getUniqueName());
			volume.setServiceLevelId(ConstantsForTests.CLIENT276_SERVICELEVELIDGOLD_1);
			volume.setSize(size);
			volume.setMetaOption(metaOption);
			volume.setHostGroupId(hostGroupId1);
			
			//
			// Test: create the volume
			//
			requestResponse = volumeFacade.createVolume(userContext, volume, count, null);;
			assertNotNull(requestResponse);
			LOGGER.info(func + "createVolume " + requestResponse.getResult().getResultResponseStatus());
			assertTrue(requestResponse.getResult().getResultResponseStatus() == ResultResponseStatus.SUCCESSFUL);
			assertTrue(requestResponse.getRequests().size() == 1);
			request = requestResponse.getRequests().get(0);
			validate(request);
			requestId1 = request.getId();
			LOGGER.info(func + "requestId " + requestId1);
			
			// wait for it to provision
			volumeIds = waitForProvisioningToComplete(userContext, requestId1);
			
		} else {
			volumeIds = new ArrayList <Long> ();
			volumeIds.add(volumeId1);
			LOGGER.info(func + "volumeId " + volumeId1);
		}
		assertNotNull(volumeIds);
		assertTrue(volumeIds.size() > 0);
		for (Long id : volumeIds) {
			//
			// Test: get the volume
			//
			volumeResponse = volumeFacade.getVolume(userContext, id);
			assertNotNull(volumeResponse);
			LOGGER.info(func + "getVolume " + requestResponse.getResult().getResultResponseStatus());
			assertTrue(volumeResponse.getResult().getResultResponseStatus() == ResultResponseStatus.SUCCESSFUL);
			assertTrue(volumeResponse.getVolumes().size() == 1);
			volume = volumeResponse.getVolumes().get(0);
			validate(volume);
			volumeId1 = volume.getId();
			LOGGER.info(func + "volumeId " + volumeId1);
			
			//
			// Test: expand this volume
			//
			volumeUpdates = new Volume ();
			volumeUpdates.setSize(size * 2);
			requestResponse = volumeFacade.updateVolume(userContext, volumeId1, volumeUpdates, null);
			assertNotNull(requestResponse);
			LOGGER.info(func + "updateVolume Expansion" + requestResponse.getResult().getResultResponseStatus());
			if (metaOption == VolumeMetaOption.STANDARD) {
				assertTrue(requestResponse.getResult().getResultResponseStatus() == ResultResponseStatus.CANNOT_ALTER_VOLUME_SIZE);
				assertTrue(requestResponse.getRequests().size() == 0);
			} else {
				assertTrue(requestResponse.getResult().getResultResponseStatus() == ResultResponseStatus.SUCCESSFUL);
				assertTrue(requestResponse.getRequests().size() == 1);
				request = requestResponse.getRequests().get(0);
				validate(request);
				//
				// wait for it to provision
				//
				waitForProvisioningToComplete(userContext, request.getId());
			}
			
			//
			// Test: upgrade serviceLevel and increase size
			//
			volumeUpdates = new Volume ();
			volumeUpdates.setSize(size * 3);
			volumeUpdates.setServiceLevelId(ConstantsForTests.CLIENT276_SERVICELEVELIDPLATINUM_1);
			requestResponse = volumeFacade.updateVolume(userContext, volumeId1, volumeUpdates, null);
			assertNotNull(requestResponse);
			LOGGER.info(func + "updateVolume Upgrade and Expand" + requestResponse.getResult().getResultResponseStatus());
			assertTrue(requestResponse.getResult().getResultResponseStatus() == ResultResponseStatus.SUCCESSFUL);
			assertTrue(requestResponse.getRequests().size() == 1);
			request = requestResponse.getRequests().get(0);
			validate(request);
			// wait for it to provision
			waitForProvisioningToComplete(userContext, request.getId());
			
			
    		//
    		// Test: OverrideApplication Parameter
    		//
    			
    		// create Override Application
    		Long overrideBusinessUnitId = createBusinessUnit(TestExecType.PROVISION);
    		assertNotNull(overrideBusinessUnitId);
    		Long overrideAccountId = createAccount(TestExecType.PROVISION, overrideBusinessUnitId);
    		assertNotNull(overrideAccountId);
    		Long overrideFunctionId = createFunction(TestExecType.PROVISION, overrideAccountId, overrideBusinessUnitId);
    		assertNotNull(overrideFunctionId);
    		Long overrideApplicationId = createApplication(TestExecType.PROVISION, overrideFunctionId, overrideAccountId, overrideBusinessUnitId);
    		assertNotNull(overrideApplicationId);
    		LOGGER.info(func + "overrideApplicationId = " + overrideApplicationId);
			
    		// Volume create with overrideApplication
			volumeUpdates = new Volume ();
			volumeUpdates.setOverrideApplicationId(overrideApplicationId);
			requestResponse = volumeFacade.updateVolume(userContext, volumeId1, volumeUpdates, null);;
			assertNotNull(requestResponse);
			LOGGER.info(func + requestResponse);
			LOGGER.info(func + "updateVolume OverrideApplicationId" + requestResponse.getResult().getResultResponseStatus());
			assertTrue(requestResponse.getResult().getResultResponseStatus() == ResultResponseStatus.SUCCESSFUL);
			assertTrue(requestResponse.getRequests().size() == 1);
			request = requestResponse.getRequests().get(0);
			validate(request);
			// wait for it to provision
			waitForProvisioningToComplete(userContext, request.getId());
			
			//Check to make sure no volumes are returned for overrideApplication (getVolByApp)
			VolumeResponse response = volumeFacade.getVolumesByApplication(userContext, overrideApplicationId, 1l, 5l);
			assertNotNull(response);
			assertTrue(response.getResult().getResultResponseStatus() == ResultResponseStatus.SUCCESSFUL);
			LOGGER.info(func + response);
			assertTrue(response.getVolumes().size() == 0);
			
			//Check to make sure at least 1 volume returned for applicationId1
			VolumeResponse secondResponse = volumeFacade.getVolumesByApplication(userContext, applicationId1, 1l, 5l);
			assertNotNull(secondResponse);
			assertTrue(secondResponse.getResult().getResultResponseStatus() == ResultResponseStatus.SUCCESSFUL);
			LOGGER.info(func + secondResponse);
			assertTrue(secondResponse.getVolumes().size() == 1);
			for (Volume returnedVolume : secondResponse.getVolumes()) {
				LOGGER.info(func + returnedVolume.getId() +" "+ returnedVolume.getName() +" "+ returnedVolume.getMetaOption() +" "+ volume.getSize() +" "+ volume.getServiceLevelId());
			}
			
			
			//
			// Test: delete this volume
			//
			
			requestResponse = volumeFacade.deleteVolume(userContext, volumeId1, null);
			assertNotNull(requestResponse);
			LOGGER.info(func + "deleteVolume " + requestResponse.getResult().getResultResponseStatus());
			assertTrue(requestResponse.getResult().getResultResponseStatus() == ResultResponseStatus.SUCCESSFUL);
			assertTrue(requestResponse.getRequests().size() == 1);
			request = requestResponse.getRequests().get(0);
			validate(request);
			//
			// wait for it to provision
			//
			waitForProvisioningToComplete(userContext, request.getId());
			
			//
			// validate that it no longer exists
			//
			volumeResponse = volumeFacade.getVolume(userContext, volumeId1);
			assertNotNull(volumeResponse);
			LOGGER.info(func + "getVolume " + requestResponse.getResult().getResultResponseStatus());
			assertTrue(volumeResponse.getResult().getResultResponseStatus() == ResultResponseStatus.DOES_NOT_EXIST_VOLUME);
			assertTrue(volumeResponse.getVolumes().size() == 0);
		}
	}
}
