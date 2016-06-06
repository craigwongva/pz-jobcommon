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

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import model.workflow.Trigger;

@ApiModel(value="TriggerResults")
public class TriggerListResponse extends PiazzaResponse {

	@ApiModelProperty(hidden = true)
	private String type = "trigger-list";

	@ApiModelProperty(value = "The array of Trigger results.")
	public List<Trigger> triggers;

	@ApiModelProperty(value = "The pagination metadata for this query.")
	public Pagination pagination;

	public TriggerListResponse() {

	}

	public TriggerListResponse(List<Trigger> triggers) {
		this.triggers = triggers;
	}

	public TriggerListResponse(List<Trigger> triggers, Pagination pagination) {
		this(triggers);
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
	 * Returns the list of Triggers held by this response object
	 * 
	 * @return The list
	 */
	public List<Trigger> getTriggers() {
		return triggers;
	}

	public Pagination getPagination() {
		return pagination;
	}
}