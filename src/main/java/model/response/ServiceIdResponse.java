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
package model.response;

import io.swagger.annotations.ApiModelProperty;

/**
 * A Response containing an ID regarding a Piazza Service.
 * 
 * @author Patrick.Doody
 *
 */
public class ServiceIdResponse extends PiazzaResponse {

	@ApiModelProperty(value = "The type of response.", required = true, allowableValues = "service-id")
	private String type = "service-id";

	@ApiModelProperty(value = "The unique ID for a Piazza Service.")
	public String serviceId;

	public ServiceIdResponse() {

	}

	public ServiceIdResponse(String serviceId) {
		this.serviceId = serviceId;
	}

	/**
	 * Gets the type of this response.
	 * 
	 * @return
	 */
	public String getType() {
		return type;
	}
}