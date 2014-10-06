package com.emc.sms.api.test.facades;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Scanner;
import java.util.UUID;

import org.apache.log4j.Logger;

import com.emc.sms.api.rest.AccountFacade;
import com.emc.sms.api.rest.ApplicationFacade;
import com.emc.sms.api.rest.BusinessUnitFacade;
import com.emc.sms.api.rest.FacadeConstants;
import com.emc.sms.api.rest.FunctionFacade;
import com.emc.sms.api.rest.HostFacade;
import com.emc.sms.api.rest.HostGroupFacade;
import com.emc.sms.api.rest.HostPortFacade;
import com.emc.sms.api.rest.ReplicaCharacteristicFacade;
import com.emc.sms.api.rest.ReplicaFacade;
import com.emc.sms.api.rest.ReplicaGroupFacade;
import com.emc.sms.api.rest.ReplicationHistoryFacade;
import com.emc.sms.api.rest.RequestFacade;
import com.emc.sms.api.rest.ServiceLevelFacade;
import com.emc.sms.api.rest.SwitchFacade;
import com.emc.sms.api.rest.UserContext;
import com.emc.sms.api.rest.VolumeFacade;
import com.emc.sms.api.rest.impl.AccountFacadeImpl;
import com.emc.sms.api.rest.impl.ApplicationFacadeImpl;
import com.emc.sms.api.rest.impl.BusinessUnitFacadeImpl;
import com.emc.sms.api.rest.impl.FunctionFacadeImpl;
import com.emc.sms.api.rest.impl.HostFacadeImpl;
import com.emc.sms.api.rest.impl.HostGroupFacadeImpl;
import com.emc.sms.api.rest.impl.HostPortFacadeImpl;
import com.emc.sms.api.rest.impl.ReplicaCharacteristicFacadeImpl;
import com.emc.sms.api.rest.impl.ReplicaFacadeImpl;
import com.emc.sms.api.rest.impl.ReplicaGroupFacadeImpl;
import com.emc.sms.api.rest.impl.ReplicationHistoryFacadeImpl;
import com.emc.sms.api.rest.impl.RequestFacadeImpl;
import com.emc.sms.api.rest.impl.ServiceLevelFacadeImpl;
import com.emc.sms.api.rest.impl.SwitchFacadeImpl;
import com.emc.sms.api.rest.impl.VolumeFacadeImpl;
import com.emc.sms.api.rest.response.AccountResponse;
import com.emc.sms.api.rest.response.ApplicationResponse;
import com.emc.sms.api.rest.response.BusinessUnitResponse;
import com.emc.sms.api.rest.response.FacadeResponse;
import com.emc.sms.api.rest.response.FunctionResponse;
import com.emc.sms.api.rest.response.HostGroupResponse;
import com.emc.sms.api.rest.response.HostPortResponse;
import com.emc.sms.api.rest.response.HostResponse;
import com.emc.sms.api.rest.response.ReplicaCharacteristicResponse;
import com.emc.sms.api.rest.response.ReplicaGroupResponse;
import com.emc.sms.api.rest.response.ReplicaResponse;
import com.emc.sms.api.rest.response.ReplicationHistoryResponse;
import com.emc.sms.api.rest.response.RequestResponse;
import com.emc.sms.api.rest.response.ServiceLevelResponse;
import com.emc.sms.api.rest.response.SwitchResponse;
import com.emc.sms.api.rest.response.VolumeResponse;
import com.emc.sms.api.test.facades.enums.TestExecType;
import com.emc.sms.api.test.facades.enums.TestObjName;
import com.emc.sms.api.test.facades.impl.TestVarObject;
import com.emc.sp.api.rest.model.Account;
import com.emc.sp.api.rest.model.Application;
import com.emc.sp.api.rest.model.ApplicationRelationship;
import com.emc.sp.api.rest.model.BusinessUnit;
import com.emc.sp.api.rest.model.BusinessUnitAccountPair;
import com.emc.sp.api.rest.model.Function;
import com.emc.sp.api.rest.model.Host;
import com.emc.sp.api.rest.model.HostGroup;
import com.emc.sp.api.rest.model.HostPort;
import com.emc.sp.api.rest.model.Replica;
import com.emc.sp.api.rest.model.ReplicaGroup;
import com.emc.sp.api.rest.model.Request;
import com.emc.sp.api.rest.model.RequestOperation;
import com.emc.sp.api.rest.model.ServiceLevel;
import com.emc.sp.api.rest.model.Switch;
import com.emc.sp.api.rest.model.Volume;
import com.emc.sp.api.rest.model.enums.RequestStatus;
import com.emc.sp.api.rest.model.enums.ResultResponseStatus;
import com.emc.sp.api.rest.model.enums.ResultResponseStatusCode;
import com.emc.sp.api.rest.model.enums.ServiceLevelOption;
import com.emc.sp.api.rest.model.enums.SwitchType;
import com.emc.sp.api.rest.model.enums.VolumeMetaOption;

public class CommonUtilsForTest {

	private static final Logger LOGGER = Logger.getLogger(CommonUtilsForTest.class);

	protected static int ONE_MINUTE = 60 * 1000;
	
	protected String getUniqueName() {
    	
    	Calendar calendar = Calendar.getInstance();
		String name = "restapi-" + calendar.get(Calendar.SECOND) + calendar.get(Calendar.MILLISECOND);
		return name;
    }
    
    protected Date getInAboutFiveMinutes() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.set(Calendar.SECOND, 0);
		
		calendar.add(Calendar.MINUTE, 5);

		return calendar.getTime();
    }
    
    protected Date getHoursAgo(int numberOfHours) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.set(Calendar.SECOND, 0);
		
		calendar.add(Calendar.HOUR, (0 - numberOfHours));

		return calendar.getTime();
    }
    
    protected Date getInAnHour() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.set(Calendar.SECOND, 0);
		
		calendar.add(Calendar.HOUR, 1);

		return calendar.getTime();
    }
    
    protected Date getSixHoursAgo() {
		return getHoursAgo(6);
    }
    
    protected Date getThreeHoursAgo() {
		return getHoursAgo(3);
    }
    
    protected Date getOneHourAgo() {
		return getHoursAgo(1);
    }
    
    protected Date getYesterday() {
		return getDaysAgo(1);
    }

    protected Date getDaysAgo(int numberOfDays) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		
		calendar.add(Calendar.DAY_OF_YEAR, (0 - numberOfDays));

		return calendar.getTime();
    }

    protected Date getLastMonth() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.add(Calendar.MONTH, -1);

		return calendar.getTime();
    }

    protected Date getStartOfThisMonth() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, 1);

		return calendar.getTime();
    }
    
    protected Date getNextMonth() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.add(Calendar.MONTH, 1);

		return calendar.getTime();
    }

    //TODO: Add new method to accept Username, Tenant and Operating tenantId's to cancel
//    protected RequestResponse cancelRequest(
    // + Long requestId, String username, String tenantId, String operatingTenantId) {
    protected RequestResponse cancelRequest(Long requestId) {
    	
    	RequestFacade facade = new RequestFacadeImpl();
    	
    	UserContext userContext = new UserContext();
    	userContext.setUsername(ConstantsForTests.PROVISIONING_USERNAME_GOOD);
    	userContext.setTenantId(ConstantsForTests.PROVISION_CLIENT_GOOD);
    	userContext.setOperatingTenantId(ConstantsForTests.PROVISION_SUB_CLIENT_GOOD);
    	
    	RequestResponse response = facade.deleteRequest(userContext, requestId);
    	
    	return response;
    }
    
    protected static UserContext getUserContextClientGood (TestExecType testType) {
    		UserContext userContext = new UserContext();
    		
    	
    	switch (testType) {
    		case PROVISION:
    			userContext.setUsername(ConstantsForTests.PROVISIONING_USERNAME_GOOD);
    			userContext.setTenantId(ConstantsForTests.PROVISION_CLIENT_GOOD);
    			userContext.setOperatingTenantId(ConstantsForTests.PROVISION_CLIENT_GOOD);
    			break;
    		case NONPROVISION:
    			userContext.setUsername(ConstantsForTests.NONPROVISION_USERNAME_GOOD);
    			userContext.setTenantId(ConstantsForTests.NONPROVISION_CLIENT_GOOD);
    			userContext.setOperatingTenantId(ConstantsForTests.NONPROVISION_CLIENT_GOOD);
    			break;
    		case UNIVERSAL:
    			userContext.setUsername(ConstantsForTests.CLIENT_276_DEV213_ADMIN);
    			userContext.setTenantId(ConstantsForTests.CLIENT_276);
    			userContext.setOperatingTenantId(ConstantsForTests.CLIENT_276);
    			break;
    	}
    		
		
		return userContext;
    }
    
    protected static UserContext getUserContextGood (TestExecType testType) {
		UserContext userContext = new UserContext();
    	
    	switch (testType) {
    			
    		case PROVISION:    			userContext.setUsername(ConstantsForTests.PROVISIONING_USERNAME_GOOD);
    			userContext.setTenantId(ConstantsForTests.PROVISION_CLIENT_GOOD);
    			userContext.setOperatingTenantId(ConstantsForTests.PROVISION_SUB_CLIENT_GOOD);
    			break;
    		case NONPROVISION:
    			userContext.setUsername(ConstantsForTests.NONPROVISION_USERNAME_GOOD);
    			userContext.setTenantId(ConstantsForTests.NONPROVISION_CLIENT_GOOD);
    			userContext.setOperatingTenantId(ConstantsForTests.NONPROVISION_SUB_CLIENT_GOOD);
    			break;
    			//Universal not being used
    		case UNIVERSAL:
    			userContext.setUsername(ConstantsForTests.CLIENT99_DVT_USER);
    			userContext.setTenantId(ConstantsForTests.NONPROVISION_CLIENT_GOOD);
    			userContext.setOperatingTenantId(ConstantsForTests.NONPROVISION_SUB_CLIENT_GOOD);
    			break;
    	}
    	
		return userContext;
    }
    
    protected static UserContext getUserContextSubClientGood (TestExecType testType) {
    	
		return getUserContextGood(testType);
    }
    
    protected static UserContext getUserContextBad () {
    	
		UserContext userContext = new UserContext();
		userContext.setUsername(ConstantsForTests.NONPROVISION_USERNAME_GOOD);
		userContext.setTenantId(ConstantsForTests.NONPROVISION_CLIENT_GOOD);
		userContext.setOperatingTenantId(ConstantsForTests.NONPROVISION_SUB_CLIENT_SECONDARY_GOOD);
		
		return userContext;
    }
    
    protected Long createBusinessUnit (TestExecType testExecType) {
    	
    	String name = getUniqueName();

    	BusinessUnit businessUnit = new BusinessUnit ();
    	businessUnit.setName(name);
    	businessUnit.setBusinessUnitIdentifier(name);
    	
		BusinessUnitFacade facade = new BusinessUnitFacadeImpl();
		BusinessUnitResponse response = facade.createBusinessUnit(getUserContextGood(testExecType), businessUnit);
		
		return response.getBusinessUnits().get(0).getId();
    }
    
    protected Long createAccount (TestExecType testExecType, Long businessUnitId) {
    	
    	String name = getUniqueName();

    	Account account = new Account ();
    	account.setName(name);
    	account.setAccountIdentifier(name);
    	account.setBusinessUnitId(businessUnitId);
    	
    	AccountFacade facade = new AccountFacadeImpl();
    	AccountResponse response = facade.createAccount(getUserContextGood(testExecType), account);
		
		return response.getAccounts().get(0).getId();
    }
    
   protected Long createFunction (TestExecType testExecType, Long accountId, Long businessUnitId) {
    	
   		Long functionId = null;

		FunctionFacade facade = new FunctionFacadeImpl();
		
		UserContext userContext = getUserContextGood(testExecType);
		
		String name = getUniqueName();

		Function functionObj = new Function();
		functionObj.setName(name);
		functionObj.setFunctionIdentifier(name);
		
		BusinessUnitAccountPair businessUnitAccountPair = new BusinessUnitAccountPair();
		businessUnitAccountPair.setAccountId(accountId);
		businessUnitAccountPair.setBusinessUnitId(businessUnitId);
		if (functionObj.getBusinessUnitAccountPairs() == null) functionObj.setBusinessUnitAccountPairs(new ArrayList <BusinessUnitAccountPair> ());
		functionObj.getBusinessUnitAccountPairs().add(businessUnitAccountPair);
		
		FunctionResponse response = facade.createFunction(userContext, functionObj);
		functionId = response.getFunctions().get(0).getId();
   	
    	return functionId;
    }
    
   protected Long createApplication (TestExecType testExecType, Long functionId, Long accountId, Long businessUnitId) {
   	
  		Long applicationId = null;

		ApplicationFacade facade = new ApplicationFacadeImpl();
		
		UserContext userContext = getUserContextGood(testExecType);
		
		String name = getUniqueName();
		
		ApplicationRelationship applicationRelationship = new ApplicationRelationship ();
		applicationRelationship.setFunctionId(functionId);
		applicationRelationship.setAccountId(accountId);
		applicationRelationship.setBusinessUnitId(businessUnitId);
		applicationRelationship.setPercentage(new Double(100));

		Application application = new Application();
		//application.setName(null);
		application.setApplicationIdentifier(name);
		
		if (application.getApplicationRelationships() == null) application.setApplicationRelationships(new ArrayList <ApplicationRelationship> ());
		application.getApplicationRelationships().add(applicationRelationship);
		
		ApplicationResponse response = facade.createApplication(userContext, application);
		applicationId = response.getApplications().get(0).getId();
  	
		return applicationId;
   }

   protected Long createHost (TestExecType testExecType) {
	   	
		HostFacade facade = new HostFacadeImpl();
		
		UserContext userContext = getUserContextGood(testExecType);

		String name = getUniqueName();

		Host host = new Host();
		host.setName(name);
		host.setDnsName(name);
		host.setHostOsId(ConstantsForTests.HOST_OS_REDHAT_LINUX);
		host.setSiteId(ConstantsForTests.SITE_38);
				
		HostResponse response = facade.createHost(userContext, host);

		assertNotNull(response);
		assertTrue(response.getResult().getResultResponseStatus() == ResultResponseStatus.SUCCESSFUL);
		assertTrue(response.getHosts().size() == 1);
		host = response.getHosts().get(0);
		assertNotNull(host.getId());
		
		return host.getId();
  }
   
   protected Long createHostPort (TestExecType testExecType, Long hostId) {
	   	
		HostPortFacade facade = new HostPortFacadeImpl();
		
		UserContext userContext = getUserContextGood(testExecType);
		
		// Instantiate a Account object that would be used as an
					// input in the message body
		HostPort hostPort = new HostPort();
		hostPort.setWwn(getUniqueWwn());
		hostPort.setHostId(hostId);

				
		HostPortResponse response = facade.createHostPort(userContext, hostId, hostPort);

		assertNotNull(response);
		assertTrue(response.getResult().getResultResponseStatus() == ResultResponseStatus.SUCCESSFUL);
		assertTrue(response.getHostPorts().size() == 1);
		hostPort = response.getHostPorts().get(0);
		assertNotNull(hostPort.getId());
		
		return hostPort.getId();
 }

   protected Long createHostGroup (TestExecType testExecType, List <Long> hostIds, Long applicationId) {
   	
  		Long hostGroupId = null;

		HostGroupFacade facade = new HostGroupFacadeImpl();
		
		UserContext userContext = getUserContextGood(testExecType);
		
		String name = getUniqueName();

		HostGroup hostGroup = new HostGroup();
		//hostGroup.setName(null);
		hostGroup.setHostGroupIdentifier(name);
		hostGroup.setApplicationId(applicationId);
		
		if (hostGroup.getHostIds() == null) hostGroup.setHostIds(new ArrayList <Long> ());
		//hostGroup.getHostIds().add(hostId);
		hostGroup.setHostIds(hostIds);
		
		HostGroupResponse response = facade.createHostGroup(userContext, hostGroup);
		if (response.getHostGroups().size() > 0) {
			hostGroupId = response.getHostGroups().get(0).getId();
		}
 	
		return hostGroupId;
   }
   /* Create a Volume, wait for provisioning completion then return the volumeId */
    protected static void deleteAndProvisionVolume(Long id) {
    //protected Long createVolume (Long hostId, Long applicationId, Long hostGroupId) {
		String func = "volumeDeleteProvisioning()...";
		UserContext userContext = getUserContextGood(TestExecType.PROVISION);
   		Long volumeId = null;
		Volume volume = null;
		Request request = null;
		RequestResponse requestResponse = null;
		VolumeResponse volumeResponse = null;
		List <Long> volumeIds = null;
		
		VolumeFacade volumeFacade = new VolumeFacadeImpl();
		
		requestResponse = volumeFacade.deleteVolume(userContext, id, null);
		assertNotNull(requestResponse);
		if(!validateResponse(requestResponse, ResultResponseStatusCode.DOES_NOT_EXIST_VOLUME)) {
			assertNotNull(null);
		} else if (requestResponse.getResult().getResultResponseStatus().getErrorCode() == ResultResponseStatusCode.SUCCESSFUL){
			assertTrue(requestResponse.getRequests().size() == 1);
			request = requestResponse.getRequests().get(0);
			validate(request);
			Long requestId = request.getId();
			LOGGER.info(func + "requestId " + requestId);
		
			//
			// wait for it to provision
			//
			volumeIds = waitForProvisioningToComplete(userContext, requestId);
		}
			
		
    	
    }
  
    protected Long createAndProvisionReplica(Long replicaGroupId) throws Exception {
    	
		String func = "ProvisionReplicaNoErrors()...";
		ReplicaFacade replicaFacade = new ReplicaFacadeImpl();
		//TODO change context for ProvOnly
		UserContext userContext = getUserContextGood(TestExecType.PROVISION);
		ReplicaGroup replicaGroup = getReplicaGroup(replicaGroupId);
		ReplicaResponse replicaResponse = null;
		List <Long> replicaIds = null;
		Replica replica = null;
   		Long replicaId = null;
		
		replica = new Replica();
		
		RequestResponse response = replicaFacade.createReplica(userContext, replicaGroup.getApplicationId(), replicaGroupId, new Date(), ServiceLevelOption.SAME, null, null);
		LOGGER.info(func + response);

		assertNotNull(response);
		assertTrue(response.getResult().getResultResponseStatus() == ResultResponseStatus.SUCCESSFUL);
		assertTrue(response.getRequests().size() == 1);
		Request request = response.getRequests().get(0);
		validate(request);
		Long requestId = request.getId();
		LOGGER.info(func + "requestId " + requestId);
		
		//
		// wait for it to provision
		//
		Request finalRequest = waitForGenericProvisioningToComplete(userContext, requestId);
		for (RequestOperation requestOperation : finalRequest.getRequestOperations()) {
			if (requestOperation.getResourceIdentifier() != null) {
				replicaGroupId = (Long.valueOf(requestOperation.getResourceIdentifier()));
				ReplicaGroup replicaGroupOut = getReplicaGroup(replicaGroupId);
				replicaIds = (replicaGroupOut.getReplicaIds());
			}
		}
		
		LOGGER.info(func + "replicaIds " + replicaIds.toString());
			
		//TODO: waitForProvisioning returns a volume but we'll need a replica, grab from resourceIdentifier field
		//
		assertNotNull(replicaIds);
		assertTrue(replicaIds.size() > 0);
		
		for (Long id : replicaIds) {
			
			//
			// get the replica
			//
			replicaResponse = replicaFacade.getReplica(userContext, id);
			assertNotNull(replicaResponse);
			LOGGER.info(func + "getReplica" + response.getResult().getResultResponseStatus());
			assertTrue(replicaResponse.getResult().getResultResponseStatus() == ResultResponseStatus.SUCCESSFUL);
			assertTrue(replicaResponse.getReplicas().size() == 1);
			replica = replicaResponse.getReplicas().get(0);
			validate(replica);
			replicaId = replica.getId();
			LOGGER.info(func + "replicaId " + replicaId);
		}
    	
    	return replicaId;
    }
    
   /* Create a Volume, wait for provisioning completion then return the volumeId */
    protected Long createAndProvisionVolume(VolumeMetaOption metaOption, Long size, Long count, Long hostGroupId) throws Exception {
    //protected Long createVolume (Long hostId, Long applicationId, Long hostGroupId) {
		
		String func = "volumeProvisioning()...";
		UserContext userContext = getUserContextGood(TestExecType.PROVISION);
		
   		Long volumeId = null;
		Volume volume = null;
		Request request = null;
		RequestResponse requestResponse = null;
		VolumeResponse volumeResponse = null;
		List <Long> volumeIds = null;
   		
		VolumeFacade volumeFacade = new VolumeFacadeImpl();
		
		//
		// setup arguments
		//
		volume = new Volume();
		volume.setName("API-FacadeReplicaUtils" + getUniqueName());
		volume.setServiceLevelId(ConstantsForTests.SERVICELEVEL_BRONZE_PROVISIONING_GOOD);
		volume.setSize(size);
		volume.setMetaOption(metaOption);
		volume.setHostGroupId(hostGroupId);
		
		//
		//Add hostGroupId volume.setHostGroupId(hostGroupId);
			
		//
		// create the volume
		//
		requestResponse = volumeFacade.createVolume(userContext, volume, count, null);;
		assertNotNull(requestResponse);
		LOGGER.info(func + "createVolume " + requestResponse.getResult().getResultResponseStatus());
		assertTrue(requestResponse.getResult().getResultResponseStatus() == ResultResponseStatus.SUCCESSFUL);
		assertTrue(requestResponse.getRequests().size() == 1);
		request = requestResponse.getRequests().get(0);
		validate(request);
		Long requestId = request.getId();
		LOGGER.info(func + "requestId " + requestId);
		
		//
		// wait for it to provision
		//
		volumeIds = waitForProvisioningToComplete(userContext, requestId);
			
		assertNotNull(volumeIds);
		assertTrue(volumeIds.size() > 0);
		for (Long id : volumeIds) {
			
			//
			// get the volume
			//
			volumeResponse = volumeFacade.getVolume(userContext, id);
			assertNotNull(volumeResponse);
			LOGGER.info(func + "getVolume " + requestResponse.getResult().getResultResponseStatus());
			assertTrue(volumeResponse.getResult().getResultResponseStatus() == ResultResponseStatus.SUCCESSFUL);
			assertTrue(volumeResponse.getVolumes().size() == 1);
			volume = volumeResponse.getVolumes().get(0);
			validate(volume);
			volumeId = volume.getId();
			LOGGER.info(func + "volumeId " + volumeId);
		}
		return volumeId;
	}

   public Long getFunctionIdToUse() throws Exception {
    	
    	Long applicationId = null;
        
        UserContext userContext = getUserContextGood(TestExecType.NONPROVISION);
        
        FunctionFacade facade = new FunctionFacadeImpl();
        
        FunctionResponse response = facade.getFunctions(userContext, FacadeConstants.PAGING_START_INDEX_DEFAULT, FacadeConstants.PAGING_COUNT_DEFAULT);

        if ((response != null) && (response.getResult().getResultResponseStatus() == ResultResponseStatus.SUCCESSFUL) && (response.getFunctions().size() > 0)) {
        	applicationId = response.getFunctions().get(0).getId();
        }
        
        return applicationId;
    }
	
    public Long getBadBusinessUnitIdToUse() throws Exception {
    	
    	Long accountId = null;
        
        UserContext userContext = getUserContextBad();
        
        BusinessUnitFacade facade = new BusinessUnitFacadeImpl();
        
        BusinessUnitResponse response = facade.getBusinessUnits(userContext, FacadeConstants.PAGING_START_INDEX_DEFAULT, FacadeConstants.PAGING_COUNT_DEFAULT);

        if ((response != null) && (response.getResult().getResultResponseStatus() == ResultResponseStatus.SUCCESSFUL) && (response.getBusinessUnits().size() > 0)) {
        	accountId = response.getBusinessUnits().get(0).getId();
        }
        
        return accountId;
    }
    
    public Long getBusinessUnitIdToUse() throws Exception {
    	
    	Long accountId = null;
        
        UserContext userContext = getUserContextGood(TestExecType.NONPROVISION);
        
        BusinessUnitFacade facade = new BusinessUnitFacadeImpl();
        
        BusinessUnitResponse response = facade.getBusinessUnits(userContext, FacadeConstants.PAGING_START_INDEX_DEFAULT, FacadeConstants.PAGING_COUNT_DEFAULT);

        if ((response != null) && (response.getResult().getResultResponseStatus() == ResultResponseStatus.SUCCESSFUL) && (response.getBusinessUnits().size() > 0)) {
        	accountId = response.getBusinessUnits().get(0).getId();
        }
        
        return accountId;
    }
	
   public Long getHostPortIdToUse() throws Exception {
    	
    	Long accountId = null;
        
        UserContext userContext = getUserContextGood(TestExecType.NONPROVISION);
        
        HostPortFacade facade = new HostPortFacadeImpl();
        
        HostPortResponse response = facade.getHostWWNs(userContext, ConstantsForTests.HOST_GOOD, FacadeConstants.PAGING_START_INDEX_DEFAULT, FacadeConstants.PAGING_COUNT_DEFAULT);

        if ((response != null) && (response.getResult().getResultResponseStatus() == ResultResponseStatus.SUCCESSFUL) && (response.getHostPorts().size() > 0)) {
        	accountId = response.getHostPorts().get(0).getId();
        }
        
        return accountId;
    }
	
   public Long getSwitchIdToUse() throws Exception {
   	
   	Long switchId = null;
    
    UserContext userContext = getUserContextClientGood(TestExecType.NONPROVISION);
    
    SwitchFacade facade = new SwitchFacadeImpl();
    
    SwitchResponse response = facade.getSwitches(userContext, FacadeConstants.PAGING_START_INDEX_DEFAULT, FacadeConstants.PAGING_COUNT_DEFAULT);

    if ((response != null) && (response.getResult().getResultResponseStatus() == ResultResponseStatus.SUCCESSFUL) && (response.getSwitches().size() > 0)) {
    	switchId = response.getSwitches().get(0).getId();
    }
    
    return switchId;
   }
	
   public Long getSiteIdToUse() throws Exception {
	   	
  		Long siteId = ConstantsForTests.SITE_GOOD;
  		return siteId;
  }
	
    public Long getAccountIdToUse() throws Exception {
    	
    	Long accountId = null;
        
        UserContext userContext = getUserContextGood(TestExecType.NONPROVISION);
        
        AccountFacade facade = new AccountFacadeImpl();
        
        AccountResponse response = facade.getAccounts(userContext, FacadeConstants.PAGING_START_INDEX_DEFAULT, FacadeConstants.PAGING_COUNT_DEFAULT);

        if ((response != null) && (response.getResult().getResultResponseStatus() == ResultResponseStatus.SUCCESSFUL) && (response.getAccounts().size() > 0)) {
        	accountId = response.getAccounts().get(0).getId();
        }
        
        return accountId;
    }
	
    public Long getApplicationIdToUse() throws Exception {
    	
    	Long applicationId = null;
        
        UserContext userContext = getUserContextGood(TestExecType.NONPROVISION);
        
        ApplicationFacade facade = new ApplicationFacadeImpl();
        
        ApplicationResponse response = facade.getApplications(userContext, FacadeConstants.PAGING_START_INDEX_DEFAULT, FacadeConstants.PAGING_COUNT_DEFAULT);

        if ((response != null) && (response.getResult().getResultResponseStatus() == ResultResponseStatus.SUCCESSFUL) && (response.getApplications().size() > 0)) {
        	applicationId = response.getApplications().get(0).getId();
        }
        
        return applicationId;
    }
	
    public Long getHostGroupIdToUse() throws Exception {
    	
    	Long applicationId = null;
        
        UserContext userContext = getUserContextGood(TestExecType.NONPROVISION);
        
        HostGroupFacade facade = new HostGroupFacadeImpl();
        
        HostGroupResponse response = facade.getHostGroups(userContext, FacadeConstants.PAGING_START_INDEX_DEFAULT, FacadeConstants.PAGING_COUNT_DEFAULT);

        if ((response != null) && (response.getResult().getResultResponseStatus() == ResultResponseStatus.SUCCESSFUL) && (response.getHostGroups().size() > 0)) {
        	applicationId = response.getHostGroups().get(0).getId();
        }
        
        return applicationId;
    }
	
    public Long getRequestIdToUse() throws Exception {
    	
    	Long requestId = null;
        
        UserContext userContext = getUserContextGood(TestExecType.NONPROVISION);
                
        RequestFacade facade = new RequestFacadeImpl();
        
        RequestResponse response = facade.getRequests(userContext, FacadeConstants.PAGING_START_INDEX_DEFAULT, FacadeConstants.PAGING_COUNT_DEFAULT);

        if ((response != null) && (response.getResult().getResultResponseStatus() == ResultResponseStatus.SUCCESSFUL) && (response.getRequests().size() > 0)) {
        	requestId = response.getRequests().get(0).getId();
        }
        
        System.out.println("requestId " + requestId);
        return requestId;
    }
    
    
    public Long getRequestResourceIdToUse() throws Exception {
    	
    	Long requestResourceId = null;
        
        UserContext userContext = getUserContextGood(TestExecType.NONPROVISION);
                
        RequestFacade facade = new RequestFacadeImpl();
        
        RequestResponse response = facade.getRequests(userContext, FacadeConstants.PAGING_START_INDEX_DEFAULT, FacadeConstants.PAGING_COUNT_DEFAULT);

        if ((response != null) && (response.getResult().getResultResponseStatus() == ResultResponseStatus.SUCCESSFUL) && (response.getRequests().size() > 0)) {
        	Request request = response.getRequests().get(0);
        	requestResourceId = request.getRequestOperations().get(0).getId();
        }
        
        System.out.println("requestResourceId " + requestResourceId);
        return requestResourceId;
    }
    
    
    public Long getVolumeIdToUse() throws Exception {
    	
    	Long volumeId = null;
        
        UserContext userContext = getUserContextGood(TestExecType.NONPROVISION);
                
        VolumeFacade facade = new VolumeFacadeImpl();
        
        VolumeResponse response = facade.getVolumes(userContext, FacadeConstants.PAGING_START_INDEX_DEFAULT, FacadeConstants.PAGING_COUNT_DEFAULT);

        if ((response != null) && (response.getResult().getResultResponseStatus() == ResultResponseStatus.SUCCESSFUL) && (response.getVolumes().size() > 0)) {
        	for (Volume volume : response.getVolumes()) {
        		volumeId = volume.getId();
        		if ((volumeId != 1254084) &&
        			(volumeId != 1254085) &&
        			(volumeId != 1254086)
        			) { // these are bad volumes
        			break;
        		}
        	}
        }
        
        return volumeId;
    }
    
    public enum ReplicaGroupState {
		NEW("NEW"), ACTIVATED("ACTIVATED"), ATTACHED("ATTACHED"), DETACHED("DETACHED"), RESTORED("RESTORED");

		String replicaGroupState;

		ReplicaGroupState(String replicaGroupState) {
			this.replicaGroupState = replicaGroupState;
		}

		public String toString() {
			return this.replicaGroupState;
		}
	}
    
    
	public static List<ReplicaGroup> getReplicaGroupsByTenant(TestExecType testExecType, Long tenantId) {
		
    	ReplicaGroup replicaGroup = null;
        
        UserContext userContext = getUserContextGood(testExecType);
                
        ReplicaGroupFacade facade = new ReplicaGroupFacadeImpl();
        
    	ReplicaGroupResponse response = facade.getReplicaGroupsByTenant(userContext, tenantId, 1l, 50l);
    	
    	List<ReplicaGroup> replicaGroupList = response.getReplicaGroups();
    	
    	return replicaGroupList;
		
	}
    
    public static ReplicaGroup getReplicaGroupByState(ReplicaGroupState replicaGroupState,
			List<ReplicaGroup> replicaGroupList) {
		for (ReplicaGroup replicaGroup : replicaGroupList) {
			if (replicaGroup.getReplicaGroupState().equals(replicaGroupState.toString())) {
				return replicaGroup;
			}
		}
		
		return null;
	}
    
    public ReplicaGroup getReplicaGroup(Long replicaGroupId) throws Exception {
    	
    	ReplicaGroup replicaGroup = null;
        
        UserContext userContext = getUserContextGood(TestExecType.NONPROVISION);
                
        ReplicaGroupFacade facade = new ReplicaGroupFacadeImpl();
        
    	ReplicaGroupResponse response = facade.getReplicaGroup(userContext, replicaGroupId);
        
        if ((response != null) && (response.getResult().getResultResponseStatus() == ResultResponseStatus.SUCCESSFUL) && (response.getReplicaGroups().size() > 0)) {
        	replicaGroup = response.getReplicaGroups().get(0);
        }
        
        return replicaGroup;
    }
    
    public ReplicaGroup getReplicaGroupToUse() throws Exception {
    	
    	ReplicaGroup replicaGroup = null;
        
        UserContext userContext = getUserContextGood(TestExecType.NONPROVISION);
                
        ReplicaGroupFacade facade = new ReplicaGroupFacadeImpl();
        
    	ReplicaGroupResponse response = facade.getReplicaGroups(userContext, FacadeConstants.PAGING_START_INDEX_DEFAULT, FacadeConstants.PAGING_COUNT_DEFAULT);
        
        if ((response != null) && (response.getResult().getResultResponseStatus() == ResultResponseStatus.SUCCESSFUL) && (response.getReplicaGroups().size() > 0)) {
        	replicaGroup = response.getReplicaGroups().get(0);
        }
        
        return replicaGroup;
    }
    
    public Long getReplicaGroupIdToUse() throws Exception {
    	
    	ReplicaGroup replicaGroup = getReplicaGroupToUse();
    	
        System.out.println("replicaGroupId " + replicaGroup.getId());
        
        return replicaGroup.getId();
    }
        
    public Long getReplicationHistoryIdToUse() throws Exception {
    	
    	Long replicationHistoryId = null;
        
        UserContext userContext = getUserContextGood(TestExecType.NONPROVISION);
                
        ReplicationHistoryFacade facade = new ReplicationHistoryFacadeImpl();
        
    	ReplicationHistoryResponse response = facade.getReplicationHistories(userContext, null, null, null, null, null, null, FacadeConstants.PAGING_START_INDEX_DEFAULT, FacadeConstants.PAGING_COUNT_DEFAULT);
        
        if ((response != null) && (response.getResult().getResultResponseStatus() == ResultResponseStatus.SUCCESSFUL) && (response.getReplicationHistories().size() > 0)) {
        	replicationHistoryId = response.getReplicationHistories().get(0).getId();
        }
        
        System.out.println("replicationHistoryId " + replicationHistoryId);
        
        return replicationHistoryId;
    }
    
    public Long getReplicaCharacteristicIdToUse() throws Exception {
    	
    	Long replicaCharacteristicId = null;
    	
        UserContext userContext = getUserContextGood(TestExecType.NONPROVISION);
                
        ReplicaCharacteristicFacade facade = new ReplicaCharacteristicFacadeImpl();
        
    	ReplicaCharacteristicResponse response = facade.getReplicaCharacteristics(userContext, FacadeConstants.PAGING_START_INDEX_DEFAULT, FacadeConstants.PAGING_COUNT_DEFAULT);
        
        if ((response != null) && (response.getResult().getResultResponseStatus() == ResultResponseStatus.SUCCESSFUL) && (response.getReplicaCharacteristics().size() > 0)) {
        	replicaCharacteristicId = response.getReplicaCharacteristics().get(0).getId();
        }
        
        System.out.println("replicaCharacteristicId " + replicaCharacteristicId);
        
       	return replicaCharacteristicId;
     }
    
    
    public Replica getReplicaToUse() throws Exception {
    	
    	Replica replica = null;
    	
        UserContext userContext = getUserContextGood(TestExecType.NONPROVISION);
                
        ReplicaFacade facade = new ReplicaFacadeImpl();
        
    	ReplicaResponse response = facade.getReplicas(userContext, FacadeConstants.PAGING_START_INDEX_DEFAULT, FacadeConstants.PAGING_COUNT_DEFAULT);
        
        if ((response != null) && (response.getResult().getResultResponseStatus() == ResultResponseStatus.SUCCESSFUL) && (response.getReplicas().size() > 0)) {
        	replica = response.getReplicas().get(0);
        }
        
    	return replica;
    }
    
    public Long getReplicaIdToUse() throws Exception {
    	
    	Replica replica = getReplicaToUse();
        if (replica == null) return null;
        
        System.out.println("replicaId " + replica.getId());
        
    	return replica.getId();
    }
    
   public static List <Long> waitForProvisioningToComplete(UserContext userContext, Long requestId) {
    	
    	List <Long> volumeIds = new ArrayList <Long> ();
    	
		LOGGER.info("requestId " + requestId);
		//
		// wait for it to provision
		//
		while (true) {
			
			RequestFacade requestFacade = new RequestFacadeImpl();
			RequestResponse requestResponse = requestFacade.getRequest(userContext, requestId);
			assertTrue(requestResponse.getResult().getResultResponseStatus() == ResultResponseStatus.SUCCESSFUL);
			assertTrue(requestResponse.getRequests().size() == 1);
			Request request = requestResponse.getRequests().get(0);
			if ((request.getChangeStatus() == RequestStatus.COMPLETED) ||
				(request.getChangeStatus() == RequestStatus.CANCELLED) ||
				(request.getChangeStatus() == RequestStatus.FAILED) ||
				(request.getChangeStatus() == RequestStatus.TIMEOUT)
			   ) {
				if (request.getChangeStatus() == RequestStatus.COMPLETED) {
					assertTrue(request.getRequestOperations().size() >= 1);
					
					for (RequestOperation requestOperation : request.getRequestOperations()) {
						if (requestOperation.getVolumeId() != null) {
							volumeIds.add(requestOperation.getVolumeId());
						}
					}
				}
				return volumeIds;
			} else {
				try {
					LOGGER.info("going to sleep ");
					Thread.sleep(ONE_MINUTE);
				} catch (Exception e) {;}
			}
		}
    }
   
   public Request waitForGenericProvisioningToComplete(UserContext userContext, Long requestId) throws Exception {
    	
    	//List <Long> replicaIds = new ArrayList <Long> ();
    	//Long replicaGroupId = null;
    	
		//
		// wait for it to provision
		//
		while (true) {
			
			RequestFacade requestFacade = new RequestFacadeImpl();
			RequestResponse requestResponse = requestFacade.getRequest(userContext, requestId);
			assertTrue(requestResponse.getResult().getResultResponseStatus() == ResultResponseStatus.SUCCESSFUL);
			assertTrue(requestResponse.getRequests().size() == 1);
			Request request = requestResponse.getRequests().get(0);
			if ((request.getChangeStatus() == RequestStatus.COMPLETED) ||
				(request.getChangeStatus() == RequestStatus.CANCELLED) ||
				(request.getChangeStatus() == RequestStatus.FAILED) ||
				(request.getChangeStatus() == RequestStatus.TIMEOUT)
			   ) {
				if (request.getChangeStatus() == RequestStatus.COMPLETED) {
					assertTrue(request.getRequestOperations().size() >= 1);
					/* Make the caller do this work*/
					/* for (RequestOperation requestOperation : request.getRequestOperations()) {
						if (requestOperation.getResourceIdentifier() != null) {
							replicaGroupId = (Long.valueOf(requestOperation.getResourceIdentifier()));
							ReplicaGroup replicaGroup = getReplicaGroup(replicaGroupId);
							replicaIds = (replicaGroup.getReplicaIds());
						}
					}*/
				}
				return request;
			} else {
				try {
					LOGGER.info("going to sleep ");
					Thread.sleep(ONE_MINUTE);
				} catch (Exception e) {;}
			}
		}
    }
   
    public Long getServiceLevelIdToUse(UserContext userContext) throws Exception {
    	
    	Long serviceLevelId = null;
        
        //UserContext userContext = getUserContextGood(testExecType);
        
        ServiceLevelFacade facade = new ServiceLevelFacadeImpl();
        
        ServiceLevelResponse response = facade.getServiceLevels(userContext, FacadeConstants.PAGING_START_INDEX_DEFAULT, FacadeConstants.PAGING_COUNT_DEFAULT);

        if ((response != null) && (response.getResult().getResultResponseStatus() == ResultResponseStatus.SUCCESSFUL) && (response.getServiceLevels().size() > 0)) {
        	for (ServiceLevel serviceLevel : response.getServiceLevels()) {
        		serviceLevelId = serviceLevel.getId();
        	}
        }
        
        System.out.println("serviceLevelId " + serviceLevelId);
        return serviceLevelId;
    }
    
   
    public Long getServiceLevelIdToUse(TestExecType testExecType) throws Exception {
    	
    	Long serviceLevelId = null;
        
        UserContext userContext = getUserContextGood(testExecType);
        
        ServiceLevelFacade facade = new ServiceLevelFacadeImpl();
        
        ServiceLevelResponse response = facade.getServiceLevels(userContext, FacadeConstants.PAGING_START_INDEX_DEFAULT, FacadeConstants.PAGING_COUNT_DEFAULT);

        if ((response != null) && (response.getResult().getResultResponseStatus() == ResultResponseStatus.SUCCESSFUL) && (response.getServiceLevels().size() > 0)) {
        	for (ServiceLevel serviceLevel : response.getServiceLevels()) {
        		serviceLevelId = serviceLevel.getId();
        	}
        }
        
        System.out.println("serviceLevelId " + serviceLevelId);
        return serviceLevelId;
    }
    
    protected static void cleanBusinessUnit (TestExecType testType, Long id) {     	
    	BusinessUnitFacade facade = new BusinessUnitFacadeImpl();		
		BusinessUnitResponse response = facade.deleteBusinessUnit(getUserContextGood(testType), id);
		assertNotNull(response);
		if(!validateResponse(response, ResultResponseStatusCode.DOES_NOT_EXIST_BUSINESS_UNIT)) {
			assertNotNull(null);
		}
		//assertTrue(response.getResult().getResultResponseStatus() == ResultResponseStatus.SUCCESSFUL);
		//assertTrue(response.getHostPorts().size() == 0);
    }
    
    protected static void deleteBusinessUnit (Long id) {     	
		BusinessUnitFacade facade = new BusinessUnitFacadeImpl();		
		BusinessUnitResponse response = facade.deleteBusinessUnit(getUserContextGood(TestExecType.NONPROVISION), id);
		assertNotNull(response);
		assertTrue(response.getResult().getResultResponseStatus() == ResultResponseStatus.SUCCESSFUL);
		assertTrue(response.getBusinessUnits().size() == 0);
    }

    protected static void cleanAccount (TestExecType testType, Long id) {     	
    	AccountFacade facade = new AccountFacadeImpl();		
		AccountResponse response = facade.deleteAccount(getUserContextGood(testType), id);
		assertNotNull(response);
		if(!validateResponse(response, ResultResponseStatusCode.DOES_NOT_EXIST_ACCOUNT)) {
			assertNotNull(null);
		}
		//assertTrue(response.getResult().getResultResponseStatus() == ResultResponseStatus.SUCCESSFUL);
		//assertTrue(response.getHostPorts().size() == 0);
    }
    
    protected static void deleteAccount (Long id) {     	
		AccountFacade facade = new AccountFacadeImpl();		
		AccountResponse response = facade.deleteAccount(getUserContextGood(TestExecType.NONPROVISION), id);
		assertNotNull(response);
		assertTrue(response.getResult().getResultResponseStatus() == ResultResponseStatus.SUCCESSFUL);
		assertTrue(response.getAccounts().size() == 0);
    }

    protected static void cleanHostGroup (TestExecType testType, Long id) {     	
    	HostGroupFacade facade = new HostGroupFacadeImpl();		
		HostGroupResponse response = facade.deleteHostGroup(getUserContextGood(testType), id);
		assertNotNull(response);
		if(!validateResponse(response, ResultResponseStatusCode.DOES_NOT_EXIST_HOST_GROUP)) {
			assertNotNull(null);
		}
		//assertTrue(response.getResult().getResultResponseStatus() == ResultResponseStatus.SUCCESSFUL);
		//assertTrue(response.getHostPorts().size() == 0);
    }
    
    protected static void deleteHostGroup (Long id) {     	
    	HostGroupFacade facade = new HostGroupFacadeImpl();		
		HostGroupResponse response = facade.deleteHostGroup(getUserContextGood(TestExecType.NONPROVISION), id);
		assertNotNull(response);
		assertTrue(response.getResult().getResultResponseStatus() == ResultResponseStatus.SUCCESSFUL);
		assertTrue(response.getHostGroups().size() == 0);
    }

    protected static void cleanHost (TestExecType testType, Long id) {     	
    	HostFacade facade = new HostFacadeImpl();		
		HostResponse response = facade.deleteHost(getUserContextGood(testType), id);
		assertNotNull(response);
		if(!validateResponse(response, ResultResponseStatusCode.DOES_NOT_EXIST_HOST)) {
			assertNotNull(null);
		}

		//assertTrue(response.getResult().getResultResponseStatus() == ResultResponseStatus.SUCCESSFUL);
		//assertTrue(response.getHostPorts().size() == 0);
    }
    protected static void deleteHost (Long id) {     	
    	HostFacade facade = new HostFacadeImpl();		
		HostResponse response = facade.deleteHost(getUserContextGood(TestExecType.NONPROVISION), id);
		assertNotNull(response);
		assertTrue(response.getResult().getResultResponseStatus() == ResultResponseStatus.SUCCESSFUL);
		assertTrue(response.getHosts().size() == 0);
    }
    
    protected static void cleanHostPort (TestExecType testType, Long id) {     	
    	HostPortFacade facade = new HostPortFacadeImpl();		
		HostPortResponse response = facade.deleteHostPort(getUserContextGood(testType), id);
		assertNotNull(response);
		if(!validateResponse(response, ResultResponseStatusCode.DOES_NOT_EXIST_HOST_PORT)) {
			assertNotNull(null);
		}
		//assertTrue(response.getResult().getResultResponseStatus() == ResultResponseStatus.SUCCESSFUL);
		//assertTrue(response.getHostPorts().size() == 0);
    }
    
    protected static void deleteHostPort (Long id) {     	
    	HostPortFacade facade = new HostPortFacadeImpl();		
		HostPortResponse response = facade.deleteHostPort(getUserContextGood(TestExecType.NONPROVISION), id);
		assertNotNull(response);
		assertTrue(response.getResult().getResultResponseStatus() == ResultResponseStatus.SUCCESSFUL);
		assertTrue(response.getHostPorts().size() == 0);
    }

    protected static void cleanApplication (TestExecType testType, Long id) {     	
    	ApplicationFacade facade = new ApplicationFacadeImpl();		
		ApplicationResponse response = facade.deleteApplication(getUserContextGood(testType), id);
		assertNotNull(response);
		if(!validateResponse(response, ResultResponseStatusCode.DOES_NOT_EXIST_APPLICATION)) {
			assertNotNull(null);
		}
		//assertTrue(response.getResult().getResultResponseStatus() == ResultResponseStatus.SUCCESSFUL);
		//assertTrue(response.getHostPorts().size() == 0);
    }
   protected static void deleteApplication (Long id) {     	
		ApplicationFacade facade = new ApplicationFacadeImpl();		
		ApplicationResponse response = facade.deleteApplication(getUserContextGood(TestExecType.NONPROVISION), id);
		assertNotNull(response);
		assertTrue(response.getResult().getResultResponseStatus() == ResultResponseStatus.SUCCESSFUL);
		assertTrue(response.getApplications().size() == 0);
    }

    protected static void cleanFunction (TestExecType testType, Long id) {     	
    	FunctionFacade facade = new FunctionFacadeImpl();		
		FunctionResponse response = facade.deleteFunction(getUserContextGood(testType), id);
		assertNotNull(response);
		if(!validateResponse(response, ResultResponseStatusCode.DOES_NOT_EXIST_FUNCTION)) {
			assertNotNull(null);
		}
		//assertTrue(response.getResult().getResultResponseStatus() == ResultResponseStatus.SUCCESSFUL);
		//assertTrue(response.getHostPorts().size() == 0);
    }
    
    
    protected static <K> void cleanAllObjects (TestExecType testType, TestRecordObject<K, Long> testVarObj) throws IOException, ClassNotFoundException {     	
    	String func = "cleanAllObjects()";
		LOGGER.info(func + " starting...attempting to remove all DWH/Array objects ");
		/*Map<TestObjName, Long> newObjMap = new HashMap<TestObjName, Long>();
        StringBuilder text = new StringBuilder();
        String NL = System.getProperty("line.separator");
        Scanner scanner = new Scanner(new FileInputStream("/tmp/varIdTable.txt"), "UTF-8");
        try {
          while (scanner.hasNextLine()){
            //text.append(scanner.nextLine() + NL);
            String[] tokens = scanner.nextLine().split(" ");
		    objMap.put(TestObjName.BUSINESSUNITID, businessUnitId);
            System.out.println("Word found: " + tokens[0]);
            System.out.println("Word found: " + tokens[1]);
            
          }
        }
        finally{
          scanner.close();
        }
        */
		
		//Print out the current object map
		/*
        try {
        	FileInputStream fis = new FileInputStream("/tmp/map.ser");
        	ObjectInputStream ois = new ObjectInputStream(fis);
        	testValuesObjMap = (Map) ois.readObject();
        	ois.close();
        	System.out.println(testValuesObjMap);
        } catch (Exception i) {
        	i.printStackTrace();
        }
        */
        
		Map<K, Long> testValuesObjMap = testVarObj.getMapFromFile();
        //Force order of removal/deletion to be based on object dependency
        if(testValuesObjMap.get(TestObjName.HOSTGROUPID1) != null) cleanHostGroup(testType, testValuesObjMap.get(TestObjName.HOSTGROUPID1));
        if(testValuesObjMap.get(TestObjName.APPLICATIONID1) != null) cleanApplication(testType, testValuesObjMap.get(TestObjName.APPLICATIONID1));
        if(testValuesObjMap.get(TestObjName.HOSTPORTID1) != null) cleanHostPort(testType, testValuesObjMap.get(TestObjName.HOSTPORTID1));
        if(testValuesObjMap.get(TestObjName.HOSTPORTID2) != null) cleanHostPort(testType, testValuesObjMap.get(TestObjName.HOSTPORTID2));
        if(testValuesObjMap.get(TestObjName.HOSTID1) != null) cleanHost(testType, testValuesObjMap.get(TestObjName.HOSTID1));
        if(testValuesObjMap.get(TestObjName.HOSTID2) != null) cleanHost(testType, testValuesObjMap.get(TestObjName.HOSTID2));
        if(testValuesObjMap.get(TestObjName.FUNCTIONID1) != null) cleanFunction(testType, testValuesObjMap.get(TestObjName.FUNCTIONID1));
        if(testValuesObjMap.get(TestObjName.ACCOUNTID1) != null) cleanAccount(testType, testValuesObjMap.get(TestObjName.ACCOUNTID1));
        if(testValuesObjMap.get(TestObjName.BUSINESSUNITID1) != null) cleanBusinessUnit(testType, testValuesObjMap.get(TestObjName.BUSINESSUNITID1));
        if(testValuesObjMap.get(TestObjName.VOLUMEID1) != null) deleteAndProvisionVolume(testValuesObjMap.get(TestObjName.VOLUMEID1));
        
		LOGGER.info(func + ": Completed");
    	/*Iterator<Entry<TestObjName, Long>> it = objMap.entrySet().iterator();
		while (it.hasNext()) {
    			Map.Entry pairs = (Map.Entry)it.next();
			System.out.println(pairs.getKey() + " = " + pairs.getValue());
           switch((TestObjName)pairs.getKey(HOSTGROUPID)) {
           		case HOSTGROUPID:
               		if(pairs.getValue() != null) cleanHostGroup(TestExecType.PROVISION, (Long)pairs.getValue());
               		break;
           		case APPLICATIONID:
               		if((Long)pairs.getValue() != null) cleanApplication(TestExecType.PROVISION, (Long)pairs.getValue());
               		break;
           		case HOSTPORTID1:
               		if((Long)pairs.getValue() != null) cleanHostPort(TestExecType.PROVISION, (Long)pairs.getValue());
               		break;
           		case HOSTPORTID2:
               		if((Long)pairs.getValue() != null) cleanHostPort(TestExecType.PROVISION, (Long)pairs.getValue());
               		break;
           		case HOSTID1:
               		if((Long)pairs.getValue() != null) cleanHost(TestExecType.PROVISION, (Long)pairs.getValue());
               		break;
           		case HOSTID2:
               		if((Long)pairs.getValue() != null)  cleanHost(TestExecType.PROVISION, (Long)pairs.getValue());
               		break;
           		case ACCOUNTID:
               		if((Long)pairs.getValue() != null) cleanAccount(TestExecType.PROVISION, (Long)pairs.getValue());
               		break;
           		case BUSINESSUNITID:
           			if((Long)pairs.getValue() != null) cleanBusinessUnit(TestExecType.PROVISION, (Long)pairs.getValue());
               		break;
           		case FUNCTIONID:
               		if((Long)pairs.getValue() != null) cleanFunction(TestExecType.PROVISION, (Long)pairs.getValue());
               		break;
           		case VOLUMEID:
               		if((Long)pairs.getValue() != null) deleteAndProvisionVolume((Long)pairs.getValue());
               		break;
           	}
		 }
		 */
    }
    
    protected static void deleteFunction (Long id) {     	
		FunctionFacade facade = new FunctionFacadeImpl();		
		FunctionResponse response = facade.deleteFunction(getUserContextGood(TestExecType.NONPROVISION), id);
		assertNotNull(response);
		assertTrue(response.getResult().getResultResponseStatus() == ResultResponseStatus.SUCCESSFUL);
		assertTrue(response.getFunctions().size() == 0);
    }
    
    protected static void detachReplica (Long id) {     	
		ReplicaFacade facade = new ReplicaFacadeImpl();		
		RequestResponse response = facade.detachReplica(getUserContextGood(TestExecType.PROVISION), id, null);
		assertNotNull(response);
		assertTrue(response.getResult().getResultResponseStatus() == ResultResponseStatus.SUCCESSFUL);
		assertTrue(response.getRequests().size() == 0);
    }
    
    protected Switch getSwitchObject () {
    	
		Switch switchIn = new Switch();
		switchIn.setSwitchType(SwitchType.CISCO);
		switchIn.setIpAddress(getUniqueIP());
		switchIn.setPort(81);
		switchIn.setUsername("admin");
		switchIn.setPassword("secret");
		switchIn.setWwn("1234");
		switchIn.setActiveZoneSet("EST");
		switchIn.setVSAN("1");
//		if (switchIn.getFabricIds() == null) switchIn.setFabricIds(new ArrayList <String> ());
//		switchIn.getFabricIds().add("111");
//		switchIn.getFabricIds().add("222");
		
		if (switchIn.getAssetIdentifiers() == null) switchIn.setAssetIdentifiers(new ArrayList <String> ());
		switchIn.getAssetIdentifiers().add("111111");
		switchIn.getAssetIdentifiers().add("222222");
		switchIn.getAssetIdentifiers().add("333333");

		return switchIn;
    }
    
    protected static Boolean validateResponse (FacadeResponse response, int errorCode) {

		int responseCode = response.getResult().getResultResponseStatus().getErrorCode().intValue();
		if (!(responseCode == errorCode || responseCode == 0)) {
			System.out.println("ErrorResponseCode = " + responseCode);
			return Boolean.FALSE;
		}    	
		return Boolean.TRUE;
    }
    /**
     * validate the request
     */
    protected static void validate (Request request) {

		assertNotNull(request.getId());
		assertNotNull(request.getTenantId());
    	
    }
    
    /**
     * validate the volume
     */
    protected void validate (Volume volume) {

		assertNotNull(volume.getId());
		assertNotNull(volume.getName());
		assertNotNull(volume.getTenantId());
		assertNotNull(volume.getArrayIdentifier());
		assertNotNull(volume.getResourceIdentifier());
		assertNotNull(volume.getHostGroupId());
		assertNotNull(volume.getSize());
		assertNotNull(volume.getServiceLevelId());
    	
    }
    
    /**
     * validate the replica
     */
    protected void validate (Replica replica) {

		assertNotNull(replica.getId());
		assertNotNull(replica.getName());
		assertNotNull(replica.getTenantId());
		//TODO: Do we need Description and Type, serviceLevel?
//		assertNotNull(replica.getDescription());
//		assertNotNull(replica.getReplicaType());
//		assertNotNull(replica.getServiceLevelId());
		assertNotNull(replica.getReplicaGroupId());
		assertNotNull(replica.getSourceVolumeId());
    	
    }
    
    
    
    
    protected boolean isRestApiPrefix(String name) {
    	
    	if (name == null) return false;
    	if (name.isEmpty()) return false;
    	
    	if (name.startsWith("ask")) return true;
    	if (name.startsWith("restapi")) return true;
    	if (name.startsWith("test-")) return true;
    	if (name.startsWith("unana")) return true;
    	if (name.startsWith("Unana")) return true;
   	
    	return false;
    }
    
    /**
	 * This utility method generates a unique IP for testing
	 * <p>
	 * 
	 * @return A unique string
	 */
	public static String getUniqueIP() {
		String ipAddress = "";
		Random netPrefix = new Random();
		Random hostIdent = new Random();
		ipAddress = netPrefix.nextInt(256) + "." + netPrefix.nextInt(256) + "." + netPrefix.nextInt(256) + "." + hostIdent.nextInt(256); 
		
		return ipAddress;
	}
	
	/**
	 * This utility method generates a unique wwn for testing
	 * <p>
	 * 
	 * @return A unique string
	 */
	public static String getUniqueWwn() {
		String wwn = "";

		UUID uuid = UUID.randomUUID();
		String uuidNoDash = uuid.toString().replace("-", "");
		// take first 16 characters
		wwn = uuidNoDash.substring(0, 16);

		return wwn;
	}
}
