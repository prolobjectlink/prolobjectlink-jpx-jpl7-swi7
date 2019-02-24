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
package org.prolobjectlink.util;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

import org.junit.Test;
import org.prolobjectlink.db.util.JavaSets;

public class JavaSetsTest {

	@Test
	public void testTreeSet() {
		assertEquals(new TreeSet<Object>(), JavaSets.treeSet());
	}

	@Test
	public void testTreeSetCollectionOfQextendsT() {
		assertEquals(new TreeSet<String>(), JavaSets.treeSet(new TreeSet<String>()));
	}

	@Test
	public void testHashSet() {
		assertEquals(new HashSet<Object>(), JavaSets.hashSet());
	}

	@Test
	public void testLinkedHashSet() {
		assertEquals(new LinkedHashSet<Object>(), JavaSets.linkedHashSet());
	}

	@Test
	public void testHashSetInt() {
		assertEquals(new HashSet<Object>(16), JavaSets.hashSet(16));
	}

	@Test
	public void testLinkedHashSetInt() {
		assertEquals(new LinkedHashSet<Object>(16), JavaSets.linkedHashSet(16));
	}

	@Test
	public void testHashSetCollectionOfQextendsT() {
		assertEquals(new HashSet<Object>(), JavaSets.hashSet(new HashSet<Object>()));
	}

}
