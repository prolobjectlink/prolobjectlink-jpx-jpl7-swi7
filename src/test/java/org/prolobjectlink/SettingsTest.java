/*-
 * #%L
 * prolobjectlink-jpx-jpl7-swi7
 * %%
 * Copyright (C) 2012 - 2019 Prolobjectlink Project
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
package org.prolobjectlink;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Test;
import org.prolobjectlink.db.StorageMode;
import org.prolobjectlink.db.etc.Settings;

public class SettingsTest extends BaseTest {

	@Test
	public void testHashCode() {
		assertEquals(new Settings(driver).hashCode(), settings.hashCode());
	}

	@Test
	public void testGetContainerFactory() {
		assertNotNull(settings.getContainerFactory());
	}

	@Test
	public void testGetProvider() {
		assertNotNull(settings.getProvider());
	}

	@Test
	public void testLoad() {
		assertEquals(settings.getProvider().getClass().getName(),
				settings.load().get(Settings.class.getPackage().getName().concat(".prologProvider")));
		assertEquals(settings.getContainerFactory().getClass().getName(),
				settings.load().get(Settings.class.getPackage().getName().concat(".containerFactory")));
	}

	@Test
	public void testSave() {
		settings.save();
		File file = new File("etc" + File.separator + "prolobjectlink.xml");
		assertTrue(file.exists());
		assertTrue(file.length() > 0);
	}

	@Test
	public void testEqualsObject() {
		assertTrue(settings.equals(new Settings(driver)));
		assertFalse(settings.equals(new Object()));
		assertFalse(settings.equals(null));
	}

	@Test
	public void testCreateHierarchicalCache() {
		assertNotNull(settings.createHierarchicalCache());
	}

	@Test
	public void testCreateStorage() {
		assertNotNull(settings.createStorage(LOCATION));
	}

	@Test
	public void testCreateStoragePool() {
		assertNotNull(settings.createStoragePool(POOL_ROOT, POOL_NAME));
	}

	@Test
	public void testCreateStorageManager() {
		assertNotNull(settings.createStorageManager(ROOT, StorageMode.STORAGE_POOL));
	}

	@Test
	public void testCreateRelationalDatabase() {
		assertNotNull(settings.createRelationalDatabase(StorageMode.STORAGE_POOL, "test", user));
	}

	@Test
	public void testCreateHierarchicalDatabase() {
		assertNotNull(settings.createHierarchicalDatabase(StorageMode.STORAGE_POOL, "test", user));
	}

	@Test
	public void testPutObjectObject() {

		assertNull(settings.put(zero, "zero"));
		assertNull(settings.put(one, "one"));
		assertNull(settings.put(two, "two"));
		assertNull(settings.put(three, "three"));

		assertEquals("zero", settings.put(zero, "zero"));
		assertEquals("one", settings.put(one, "one"));
		assertEquals("two", settings.put(two, "two"));
		assertEquals("three", settings.put(three, "three"));

	}

	@Test
	public void testEntrySet() {
		assertTrue(settings.entrySet().size() > 0);
	}

}
