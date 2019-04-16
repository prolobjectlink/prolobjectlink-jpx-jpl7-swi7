/*
 * #%L
 * prolobjectlink-jpx-jpl7-swi7
 * %%
 * Copyright (C) 2019 Prolobjectlink Project
 * %%
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 * 1. Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
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
import org.prolobjectlink.web.platform.UndertowServerControl;
import org.prolobjectlink.web.platform.UndertowWebServer;
import org.prolobjectlink.web.platform.WebPlatformUtil;
import org.prolobjectlink.web.platform.WebServerControl;
import org.prolobjectlink.web.platform.linux.undertow.LinuxUndertowWebServer;
import org.prolobjectlink.web.platform.macosx.undertow.MacosxUndertowWebServer;
import org.prolobjectlink.web.platform.win32.undertow.Win32UndertowWebServer;

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
		UndertowWebServer server = null;
		DatabaseServer database = null;
		if (WebPlatformUtil.runOnWindows()) {
			database = new Win32DatabaseServer();
			server = new Win32UndertowWebServer(port);
		} else if (WebPlatformUtil.runOnOsX()) {
			database = new MacosxDatabaseServer();
			server = new MacosxUndertowWebServer(port);
		} else if (WebPlatformUtil.runOnLinux()) {
			database = new LinuxDatabaseServer();
			server = new LinuxUndertowWebServer(port);
		} else {
			Logger.getLogger(UndertowServerControl.class.getName()).log(Level.SEVERE, null, "Not supported platfor");
			System.exit(1);
		}
		return new UndertowServerControl(server, database);
	}

}
