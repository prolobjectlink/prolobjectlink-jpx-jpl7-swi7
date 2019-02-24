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
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.prolobjectlink.db.DatabaseFunction;

public class DatabaseFunctionTest extends BaseTest {

	@Test
	public void testHashCode() {
		DatabaseFunction f = rdb.getSchema().addFunction("pitagoras", "");
		assertEquals(rdb.getSchema().addFunction("pitagoras", "").hashCode(), f.hashCode());
	}

	@Test
	public void testGetName() {
		DatabaseFunction f = rdb.getSchema().addFunction("pitagoras", "");
		assertEquals("pitagoras", f.getName());
	}

	@Test
	public void testGetPath() {
		DatabaseFunction f = rdb.getSchema().addFunction("pitagoras", "");
		assertEquals("dat/relational/test/functions.pl", f.getPath());
	}

	@Test
	public void testGetCode() {

		DatabaseFunction f = rdb.getSchema().addFunction("fn", "");
		f.addParameter("X").addParameter("Y").addParameter("Z").addParameter("R");
		f.addInstructions("R is X*Y*Z");
		assertEquals("fn(X,Y,Z,R) :- \n\tR is X*Y*Z", f.getCode());

	}

	@Test
	public void testGetParameters() {

		DatabaseFunction f = rdb.getSchema().addFunction("fn", "");
		f.addParameter("X").addParameter("Y").addParameter("Z");
		assertEquals(3, f.getParameters().size());

	}

	@Test
	public void testAddParameter() {

		DatabaseFunction f = rdb.getSchema().addFunction("fn", "");
		assertFalse(f.containsParameter("X"));
		assertFalse(f.containsParameter("Y"));
		assertFalse(f.containsParameter("Z"));
		f.addParameter("X");
		f.addParameter("Y");
		f.addParameter("Z");
		assertTrue(f.containsParameter("X"));
		assertTrue(f.containsParameter("Y"));
		assertTrue(f.containsParameter("Z"));

	}

	@Test
	public void testRemoveParameter() {

		DatabaseFunction f = rdb.getSchema().addFunction("fn", "");
		assertFalse(f.containsParameter("X"));
		assertFalse(f.containsParameter("Y"));
		assertFalse(f.containsParameter("Z"));
		f.addParameter("X");
		f.addParameter("Y");
		f.addParameter("Z");
		assertTrue(f.containsParameter("X"));
		assertTrue(f.containsParameter("Y"));
		assertTrue(f.containsParameter("Z"));
		f.removeParameter("X");
		f.removeParameter("Y");
		f.removeParameter("Z");
		assertFalse(f.containsParameter("X"));
		assertFalse(f.containsParameter("Y"));
		assertFalse(f.containsParameter("Z"));

	}

	@Test
	public void testContainsParameter() {

		DatabaseFunction f = rdb.getSchema().addFunction("fn", "");
		assertFalse(f.containsParameter("X"));
		assertFalse(f.containsParameter("Y"));
		assertFalse(f.containsParameter("Z"));
		f.addParameter("X");
		f.addParameter("Y");
		f.addParameter("Z");
		assertTrue(f.containsParameter("X"));
		assertTrue(f.containsParameter("Y"));
		assertTrue(f.containsParameter("Z"));

	}

	@Test
	public void testGetProvider() {
		assertNotNull(rdb.getSchema().addFunction("pitagoras", "").getProvider());
	}

	@Test
	public void testToString() {
		DatabaseFunction f = rdb.getSchema().addFunction("pitagoras", "");
		assertEquals(rdb.getSchema().addFunction("pitagoras", "").toString(), f.toString());
	}

	@Test
	public void testEqualsObject() {
		DatabaseFunction f = rdb.getSchema().addFunction("pitagoras", "");
		assertTrue(f.equals(rdb.getSchema().addFunction("pitagoras", "")));
	}

}
