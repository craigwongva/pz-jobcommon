package env.util;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import org.springframework.web.client.RestTemplate;

import model.resource.UUID;



	// Add License header
	/**
	 * CoreUUIDGen class that calls the Piazza Core UUIDGen service and returns
	 * a new ID.  If the service is down, an ID is generated
	 * TODO this class has to be integrated with the new Discovery approach
	 * before it can be used.  
	 * @author mlynum
	 * @version 1.0
	 */

	@Component
	//@DependsOn("coreInitDestroy")

	public class CoreUUIDGen {

		private String uuidService;
		private String uuidServiceHost;
	
		private final static Logger LOGGER = LoggerFactory.getLogger(CoreUUIDGen.class);
		@Autowired
		// TODO This has to be revisited to autowired Discovery
		//CoreServiceProperties coreServiceProperties;
		private RestTemplate template;
		@PostConstruct
		public void init() {
			LOGGER.info("CoreUUIDGen initialized");
			template = new RestTemplate();
			// TODO call discovery.get("uuidgen.host") and populate uuidServiceHost
			// TODO call discovery.get("uuidgen.service") and populate uuidService
			//uuidService = coreServiceProperties.getUuidservice();
			//uuidServiceHost = coreServiceProperties.getUuidservicehost();
			uuidService = "";
			uuidServiceHost = "";
		}
		/**
		 * Only gets one UUID
		 * @return UUID - Piazza unique identifier
		 */
		public String getUUID() {
			
			List <String> resultList =  getUUID(1);
			return resultList.get(0);
		}

		/**
		 * Calls the UUIDgen service to get a unique identifier.  if the service
		 * cannot be reached then a UUID is generated.
		 * @return List of UUIDs
		 */
		public List <String> getUUID(int count) {
			
			List <String> uuidList = new ArrayList<String>();
			
			try {
				
				MultiValueMap<String, Integer> map = new LinkedMultiValueMap<String, Integer>();
				   map.add("count", new Integer(count));
				LOGGER.debug("Calling UUIDGen Service" + uuidServiceHost + uuidService);
				ResponseEntity<UUID> uuid = template.postForEntity("http://" + uuidServiceHost + uuidService, map, UUID.class);
				List <String> data = uuid.getBody().getData();
				
				if (data != null )
				{
					LOGGER.debug("Response from UUIDgen" + uuid.toString());
					if (data.size() > 1) {
			
					LOGGER.debug("Received more than one ID from the UUIDGen service, " +
								"defaulting to first id returned.");
					}
					uuidList = data;
				} else {
					// No data came from the UUIDGen, generate own ID
					String uuidString = generateId();
					uuidList.add(uuidString);
					LOGGER.debug("Final UUIDString is " + uuidList.get(0));
				}
			    
				
			} catch (Exception ex) {
				LOGGER.error(ex.getMessage());
				LOGGER.debug(ex.toString());
				LOGGER.debug("UUIDGen Service Used " + uuidServiceHost);
				// The UUID Gen Service is not accessible so now
				// Make up a random ID	
				String uuidString = generateId();
				uuidList.add(uuidString);
				LOGGER.debug("Final UUIDString is " + uuidList.get(0));
				
			}
			
			return uuidList;
			
			
		}

		
		/**
		 * Generates an ID for persisting data using Random
		 * @return id 
		 */
		private String generateId() {
			String id = "";
			Random rand = new Random(System.nanoTime());
			int randomInt = rand.nextInt(1000000000);
			rand = new Random();		
			id= "123-345-456" + (new Integer(randomInt).toString()) + rand.nextInt(100) + 2;
			return id;
			
		}
}