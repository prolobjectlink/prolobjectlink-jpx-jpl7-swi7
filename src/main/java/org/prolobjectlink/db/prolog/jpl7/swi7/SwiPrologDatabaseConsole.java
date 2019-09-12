/*
 * #%L
 * prolobjectlink-jpx-jpl7-swi7
 * %%
 * Copyright (C) 2019 Prolobjectlink Project
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package org.prolobjectlink.db.prolog.jpl7.swi7;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.prolobjectlink.db.DatabaseConsole;
import org.prolobjectlink.db.DatabaseServer;
import org.prolobjectlink.db.platform.linux.LinuxDatabaseServer;
import org.prolobjectlink.db.platform.macosx.MacosxDatabaseServer;
import org.prolobjectlink.db.platform.win32.Win32DatabaseServer;
import org.prolobjectlink.db.prolog.AbstractDatabaseConsole;
import org.prolobjectlink.web.application.GrizzlyModelGenerator;
import org.prolobjectlink.web.application.ModelGenerator;
import org.prolobjectlink.web.platform.GrizzlyServerControl;
import org.prolobjectlink.web.platform.GrizzlyWebServer;
import org.prolobjectlink.web.platform.WebPlatformUtil;
import org.prolobjectlink.web.platform.WebServerControl;
import org.prolobjectlink.web.platform.linux.grizzly.LinuxGrizzlyWebServer;
import org.prolobjectlink.web.platform.macosx.grizzly.MacosxGrizzlyWebServer;
import org.prolobjectlink.web.platform.win32.grizzly.Win32GrizzlyWebServer;

/**
 * 
 * @author Jose Zalacain
 * @since 1.0
 */
public class SwiPrologDatabaseConsole extends AbstractDatabaseConsole implements DatabaseConsole {

	public SwiPrologDatabaseConsole() {
		super(new SwiPrologDatabaseProvider());
	}

	public static void main(String[] args) {
		new SwiPrologDatabaseConsole().run(args);
	}

	public WebServerControl getWebServerControl(int port) {
		GrizzlyWebServer server = null;
		DatabaseServer database = null;
		if (WebPlatformUtil.runOnWindows()) {
			database = new Win32DatabaseServer();
			server = new Win32GrizzlyWebServer(port);
		} else if (WebPlatformUtil.runOnOsX()) {
			database = new MacosxDatabaseServer();
			server = new MacosxGrizzlyWebServer(port);
		} else if (WebPlatformUtil.runOnLinux()) {
			database = new LinuxDatabaseServer();
			server = new LinuxGrizzlyWebServer(port);
		} else {
			Logger.getLogger(GrizzlyServerControl.class.getName()).log(Level.SEVERE, null, "Not supported platfor");
			System.exit(1);
		}
		return new GrizzlyServerControl(server, database);
	}

	public ModelGenerator getModelGeneratorInstance() {
		return new GrizzlyModelGenerator();
	}

}
