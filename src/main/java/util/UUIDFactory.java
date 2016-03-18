/**
 * Copyright 2016, RadiantBlue Technologies, Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 **/
package util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import model.resource.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 * UUIDGen factory class that calls the Piazza Core UUIDGen service and returns
 * a new GUID. All UUIDs generated by core Piazza components should have their
 * UUIDs generated by the Piazza UUIDGen service, this utility factory provides
 * an abstracted way to reach that service and obtain lists of UUIDs.
 * 
 * @author mlynum, rorf, patrick.doody
 * @version 1.0
 */
@Component
public class UUIDFactory {
	@Value("${pz.uuid.url:}")
	private String uuidServiceUrl;
	private RestTemplate template;
	private final static Logger LOG = LoggerFactory.getLogger(UUIDFactory.class);

	/**
	 * Default constructor required for Bean instantiation.
	 */
	public UUIDFactory() {
	}

	/**
	 * Creates a new UUIDGen component. This constructor is not recommended.
	 * It's more recommended to have your project populate the pz.uuid.url
	 * property, and allow Spring to Autowire this object. However, this
	 * constructor exists for cases where that is not an option..
	 * 
	 * @param uuidServiceUrl
	 *            The URL of the UUIDGen service.
	 */
	public UUIDFactory(String uuidServiceUrl) {
		this.uuidServiceUrl = uuidServiceUrl;
	}

	@PostConstruct
	public void init() {
		LOG.info(String.format("UUIDGen initialized for to url %s", uuidServiceUrl));
		template = new RestTemplate();
	}

	/**
	 * Only gets one UUID
	 * 
	 * @return UUID - Piazza unique identifier
	 */
	public String getUUID() throws RestClientException {
		return getUUID(1).get(0);
	}

	/**
	 * Calls the UUIDgen service to get a unique identifier.
	 * 
	 * @return List of UUIDs
	 */
	public List<String> getUUID(Integer count) throws RestClientException {
		try {
			Map<String, Integer> map = new HashMap<String, Integer>();
			map.put("count", count);
			ResponseEntity<UUID> uuid = template.postForEntity("https://" + uuidServiceUrl + "?count={count}", null,
					UUID.class, map);
			return uuid.getBody().getData();
		} catch (Exception exception) {
			// Aiding with debugging, if the above REST call fails, then UUIDs
			// will be generated locally. This is not a permanent solution.
			System.out
					.println(String
							.format("UUIDGen service encountered an error: %s, and local UUIDs were generated. Please fix your UUIDGen REST Endpoint.",
									exception.getMessage()));
			List<String> uuidList = new ArrayList<String>();
			for (int i = 0; i < count; i++) {
				uuidList.add(java.util.UUID.randomUUID().toString());
			}
			return uuidList;
		}
	}
}