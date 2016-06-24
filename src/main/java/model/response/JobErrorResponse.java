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
import model.response.JobResponse;
/**
 * Some internal error occurred in Piazza and should be reported to the user.
 * This response object aims to include sufficient information about the error
 * back to the user.
 * 
 * @author Patrick.Doody
 * 
 */
public class JobErrorResponse extends JobResponse {

	@ApiModelProperty(value = "The type of message.")
	private String type = "job-error";

	@ApiModelProperty(value = "A description of the error describing the failure.")
	public String message;

	@ApiModelProperty(value = "The Piazza component where the error originated.")
	public String origin;

	public JobErrorResponse(String jobId, String message, String origin) {
		super(jobId);
		this.message = message;
		this.origin = origin;
	}
	
	public JobErrorResponse() {

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