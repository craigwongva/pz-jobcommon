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
package model.data.location;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Model representing a File accessible via a folder share that is will be
 * accessible to the Piazza Core internal components.
 * 
 * @author Patrick.Doody
 * 
 */
public class FolderShare implements FileLocation {
	public static final String type = "share";
	public String filePath;

	public String getType() {
		return type;
	}

	/**
	 * Returns the InputStream for the file which resides at a folder share or
	 * local file system. Null if no file can be found.
	 */
	public InputStream getFile() {
		try {
			return new FileInputStream(filePath);
		} catch (FileNotFoundException exception) {
			exception.printStackTrace();
			return null;
		}
	}
}