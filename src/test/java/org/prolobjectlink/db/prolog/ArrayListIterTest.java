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
package org.prolobjectlink.db.prolog;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Iterator;

import org.junit.Test;

public class ArrayListIterTest extends CollectionTest {

	private Iterator<Integer> iterator;
	private PrologArrayList<Integer> expected = new PrologArrayList<Integer>();
	private PrologArrayList<Integer> actual = new PrologArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));

	@Test
	public void testHasNext() {

		iterator = actual.iterator();
		assertTrue(iterator.hasNext());
		assertEquals(zero, iterator.next());
		assertTrue(iterator.hasNext());
		assertEquals(one, iterator.next());
		assertTrue(iterator.hasNext());
		assertEquals(two, iterator.next());
		assertTrue(iterator.hasNext());
		assertEquals(three, iterator.next());
		assertTrue(iterator.hasNext());
		assertEquals(four, iterator.next());
		assertTrue(iterator.hasNext());
		assertEquals(five, iterator.next());
		assertTrue(iterator.hasNext());
		assertEquals(six, iterator.next());
		assertTrue(iterator.hasNext());
		assertEquals(seven, iterator.next());
		assertTrue(iterator.hasNext());
		assertEquals(eight, iterator.next());
		assertTrue(iterator.hasNext());
		assertEquals(nine, iterator.next());

		assertFalse(iterator.hasNext());

	}

	@Test
	public void testNext() {

		iterator = actual.iterator();
		assertTrue(iterator.hasNext());
		assertEquals(zero, iterator.next());
		assertTrue(iterator.hasNext());
		assertEquals(one, iterator.next());
		assertTrue(iterator.hasNext());
		assertEquals(two, iterator.next());
		assertTrue(iterator.hasNext());
		assertEquals(three, iterator.next());
		assertTrue(iterator.hasNext());
		assertEquals(four, iterator.next());
		assertTrue(iterator.hasNext());
		assertEquals(five, iterator.next());
		assertTrue(iterator.hasNext());
		assertEquals(six, iterator.next());
		assertTrue(iterator.hasNext());
		assertEquals(seven, iterator.next());
		assertTrue(iterator.hasNext());
		assertEquals(eight, iterator.next());
		assertTrue(iterator.hasNext());
		assertEquals(nine, iterator.next());

		assertFalse(iterator.hasNext());

	}

	@Test
	public void testRemove() {

		iterator = actual.iterator();

		iterator.next();
		iterator.remove();

		iterator.next();
		iterator.remove();

		iterator.next();
		iterator.remove();

		iterator.next();
		iterator.remove();

		iterator.next();
		iterator.remove();

		iterator.next();
		iterator.remove();

		iterator.next();
		iterator.remove();

		iterator.next();
		iterator.remove();

		iterator.next();
		iterator.remove();

		iterator.next();
		iterator.remove();

		assertFalse(iterator.hasNext());
		assertEquals(expected, actual);

	}

}
