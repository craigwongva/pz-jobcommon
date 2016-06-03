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
package model.data.deployment;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModelProperty;

/**
 * JSON Database Model, serialized by Jackson, that represents a Deployment in
 * the Piazza System.
 * 
 * @author Patrick.Doody
 * 
 */
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Deployment {

	@ApiModelProperty(value = "The unique identifier for this Deployment.")
	public String id;

	@ApiModelProperty(value = "The unique identifier of the Data that this deployment hosts.")
	public String dataId;

	@ApiModelProperty(value = "The host name for the deployment server.")
	public String host;

	@ApiModelProperty(value = "The port number for the deployment server. ")
	public String port;

	@ApiModelProperty(value = "The layer name for the hosted service on the deployment server.")
	public String layer;

	@ApiModelProperty(value = "Fully qualified URL for accessing the GetCapabilities action for the deployment service.")
	public String capabilitiesUrl;

	/**
	 * Creates a new Deployment.
	 */
	public Deployment() {

	}

	/**
	 * Creates a new Deployment.
	 * 
	 * @param id
	 *            The ID of this deployment.
	 * @param dataId
	 *            The ID of the DataResource that this deployment represents
	 * @param host
	 *            The Host of the GeoServer instance
	 * @param port
	 *            The port of the GeoServer instance
	 * @param layer
	 *            The name of the GeoServer layer being deployed
	 * @param capabilitiesUrl
	 *            The URL that will return the Capabilities document
	 */
	public Deployment(String id, String dataId, String host, String port, String layer, String capabilitiesUrl) {
		this.id = id;
		this.dataId = dataId;
		this.host = host;
		this.port = port;
		this.layer = layer;
		this.capabilitiesUrl = capabilitiesUrl;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDataId() {
		return dataId;
	}

	public void setDataId(String dataId) {
		this.dataId = dataId;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getLayer() {
		return layer;
	}

	public void setLayer(String layer) {
		this.layer = layer;
	}

	public String getCapabilitiesUrl() {
		return capabilitiesUrl;
	}

	public void setCapabilitiesUrl(String capabilitiesUrl) {
		this.capabilitiesUrl = capabilitiesUrl;
	}
}