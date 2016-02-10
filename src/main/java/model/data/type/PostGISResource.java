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

import model.data.DataType;

/**
 * Vector resource held by a PostGIS table. For example: a Shapefile loaded with
 * ogr2ogr.
 * 
 * TODO: This class is likely missing some necessary parameters.
 * 
 * @author Patrick.Doody
 * 
 */
public class PostGISResource implements DataType {
	public static final String type = "postgis";
	public String database;
	public String table;

	public PostGISResource() {

	}

	public String getType() {
		return type;
	}
}
