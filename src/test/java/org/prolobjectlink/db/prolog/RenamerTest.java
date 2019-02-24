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
package org.prolobjectlink.db.prolog;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;

import java.lang.reflect.Field;

import org.junit.Test;
import org.prolobjectlink.BaseTest;
import org.prolobjectlink.db.prolog.PrologRenamer;
import org.prolobjectlink.domain.geometry.Point;
import org.prolobjectlink.prolog.PrologVariable;

public class RenamerTest extends BaseTest {

	private PrologRenamer r = new PrologRenamer(provider);
	private Field[] expected = Point.class.getDeclaredFields();
	private PrologVariable[] names = new PrologVariable[expected.length];

	@Test
	public final void testRename() {

		// from field to prolog variable
		for (int i = 0; i < expected.length; i++) {
			names[i] = r.toVariable(expected[i]);
		}

		// from variable to filed
		Field[] actual = Point.class.getDeclaredFields();
		for (int i = 0; i < names.length; i++) {
			actual[i] = r.toField(names[i]);
		}

		assertArrayEquals(expected, actual);

	}

	@Test
	public final void testGetVariableMap() {
		assertNotNull(r.getVariableMap());
	}

	@Test
	public final void testGetProvider() {
		assertNotNull(r.getProvider());
	}

}
