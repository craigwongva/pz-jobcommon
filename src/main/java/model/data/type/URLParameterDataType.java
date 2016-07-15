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
package model.data.type;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

/**
 * Indicates that text content is to be used in URL key-value pair
 * 
 * @author bkrasner
 *
 */
public class URLParameterDataType extends TextDataType {

	@ApiModelProperty(required = true, value = "The type of data.", allowableValues = "urlparameter")
	public String type;

	public String getMimeType() {
		// TODO Auto-generated method stub
		return null;
	}
}