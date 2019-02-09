/*-
 * #%L
 * prolobjectlink-db-jpl7-swi
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
package org.prolobjectlink.util;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

import org.junit.Test;
import org.prolobjectlink.db.util.JavaMaps;

public class JavaMapsTest {

	@Test
	public void testTreeMap() {
		assertEquals(new TreeMap<Object, Object>(), JavaMaps.treeMap());
	}

	@Test
	public void testTreeMapMapOfQextendsKQextendsV() {
		assertEquals(new TreeMap<String, Object>(), JavaMaps.treeMap(new TreeMap<String, Object>()));
	}

	@Test
	public void testHashMap() {
		assertEquals(new HashMap<Object, Object>(), JavaMaps.hashMap());
	}

	@Test
	public void testHashMapInt() {
		assertEquals(new HashMap<Object, Object>(16), JavaMaps.hashMap(16));
	}

	@Test
	public void testHashMapMapOfQextendsKQextendsV() {
		assertEquals(new HashMap<Object, Object>(), JavaMaps.hashMap(new HashMap<Object, Object>()));
	}

	@Test
	public void testLinkedHashMap() {
		assertEquals(new LinkedHashMap<Object, Object>(), JavaMaps.linkedHashMap());
	}

	@Test
	public void testLinkedHashMapInt() {
		assertEquals(new LinkedHashMap<Object, Object>(16), JavaMaps.linkedHashMap(16));
	}

	@Test
	public void testLinkedHashMapMapOfQextendsKQextendsV() {
		assertEquals(new LinkedHashMap<Object, Object>(), JavaMaps.linkedHashMap(new LinkedHashMap<Object, Object>()));
	}

}
