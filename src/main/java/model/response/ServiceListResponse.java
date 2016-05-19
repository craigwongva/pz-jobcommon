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

import java.util.List;

import model.service.metadata.Service;

/**
 * Represents the response that the Gateway returns to the user when the user
 * has requested to see the information on a list of Services currently held by
 * the Piazza system; represented internally using the Service object.
 * 
 * @author Patrick.Doody
 * 
 */
public class ServiceListResponse extends PiazzaResponse {
	private String type = "service-list";
	public List<Service> data;
	public Pagination pagination;

	public ServiceListResponse() {
	}

	public ServiceListResponse(List<Service> services) {
		this.data = services;
	}

	public ServiceListResponse(List<Service> services, Pagination pagination) {
		this(services);
		this.pagination = pagination;
	}

	/**
	 * Gets the type of this response.
	 * 
	 * @return
	 */
	public String getType() {
		return type;
	}

	/**
	 * Returns the list of Services held by this response object
	 * 
	 * @return The list
	 */
	public List<Service> getData() {
		return data;
	}

	public Pagination getPagination() {
		return pagination;
	}
}