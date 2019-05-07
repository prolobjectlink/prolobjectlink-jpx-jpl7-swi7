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

import static org.prolobjectlink.db.XmlParser.XML;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import javax.persistence.spi.PersistenceProvider;

import org.prolobjectlink.db.DatabaseEngine;
import org.prolobjectlink.db.DatabaseSchema;
import org.prolobjectlink.db.DatabaseUser;
import org.prolobjectlink.db.DatabaseUnitInfo;
import org.prolobjectlink.db.Protocol;
import org.prolobjectlink.db.Schema;
import org.prolobjectlink.db.etc.Settings;
import org.prolobjectlink.db.jpa.JpaAbstractProvider;
import org.prolobjectlink.db.jpa.JpaEntityManagerFactory;
import org.prolobjectlink.db.jpa.JpaProperties;
import org.prolobjectlink.db.memory.MemoryHierarchical;
import org.prolobjectlink.db.persistent.EmbeddedHierarchical;
import org.prolobjectlink.db.persistent.RemoteHierarchical;
import org.prolobjectlink.db.util.JavaReflect;
import org.prolobjectlink.db.xml.PersistenceXmlParser;
import org.prolobjectlink.logging.LoggerConstants;
import org.prolobjectlink.logging.LoggerUtils;

public class SwiPrologPersistenceProvider extends JpaAbstractProvider implements PersistenceProvider {

	public SwiPrologPersistenceProvider() {
		PersistenceXmlParser p = new PersistenceXmlParser();
		URL persistenceXml = Thread.currentThread().getContextClassLoader().getResource(XML);
		Map<String, DatabaseUnitInfo> m = p.parsePersistenceXml(persistenceXml);
		for (Entry<String, DatabaseUnitInfo> info : m.entrySet()) {
			DatabaseUnitInfo unit = info.getValue();
			String name = unit.getPersistenceUnitName();
			Properties properties = unit.getProperties();
			Settings settings = new Settings(properties.getProperty(JpaProperties.DRIVER));
			URL url = null;
			try {
				System.setProperty("java.protocol.handler.pkgs", Protocol.class.getPackage().getName());
				url = new URL(properties.getProperty(JpaProperties.URL).replace(URL_PREFIX, ""));
				if (!url.getPath().substring(url.getPath().lastIndexOf('/') + 1).equals(name)) {
					throw new MalformedURLException("The URL path don't have database named " + name);
				}
			} catch (MalformedURLException e) {
				LoggerUtils.error(MemoryHierarchical.class, LoggerConstants.URL, e);
			}

			assert url != null;

			// catch the rest of properties
			String password = properties.getProperty(JpaProperties.PASSWORD);
			String user = properties.getProperty(JpaProperties.USER);
			DatabaseUser owner = new DatabaseUser(user, password);
			Schema schema = new DatabaseSchema(url.getPath(), settings.getProvider(), settings, owner);
			for (String managedClass : unit.getManagedClassNames()) {
				schema.addClass(JavaReflect.classForName(managedClass), "");
			}

			DatabaseEngine e = null;
			String protocol = url.getProtocol();
			if (protocol.equalsIgnoreCase(Protocol.MEMPDB.toString())) {
				e = MemoryHierarchical.newInstance(unit, properties);
			} else if (protocol.equalsIgnoreCase(Protocol.REMPDB.toString())) {
				e = RemoteHierarchical.newInstance(unit, properties);
			} else if (protocol.equalsIgnoreCase(Protocol.FILE.toString())) {
				e = EmbeddedHierarchical.newInstance(unit, properties);
			}

			entityManagerFactories.put(name, new JpaEntityManagerFactory(e, properties));

		}
	}

}
