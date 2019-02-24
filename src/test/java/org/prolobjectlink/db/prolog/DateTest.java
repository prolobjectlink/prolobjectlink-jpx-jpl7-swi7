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

import java.util.Date;

import org.junit.Test;
import org.prolobjectlink.BaseTest;
import org.prolobjectlink.db.prolog.PrologDate;

public class DateTest extends BaseTest {

	private Date date = new Date();
	private PrologDate dateTime = new PrologDate();
	private long time = System.currentTimeMillis();

	@Test
	public final void testHashCode() {
		assertEquals(dateTime.hashCode(), dateTime.hashCode());
	}

	@Test
	public final void testGetTime() {
		assertEquals(dateTime.getTime(), time);
	}

	@Test
	public final void testGetJavaUtilDate() {
		assertEquals(dateTime.getJavaUtilDate(), date);
	}

	@Test
	public final void testBefore() {
		assertTrue(new PrologDate(0).before(dateTime));
		assertFalse(dateTime.before(new PrologDate(0)));
	}

	@Test
	public final void testAfter() {
		assertFalse(new PrologDate(0).after(dateTime));
		assertTrue(dateTime.after(new PrologDate(0)));
	}

	@Test
	public final void testCompareTo() {
		assertEquals(-1, new PrologDate(0).compareTo(dateTime));
		assertEquals(0, dateTime.compareTo(dateTime));
		assertEquals(1, dateTime.compareTo(new PrologDate(0)));
	}

	@Test
	public final void testToString() {
		assertEquals(dateTime.toString(), date.toString());
	}

	@Test
	public final void testEqualsObject() {
		assertTrue(dateTime.equals(dateTime));
	}

}
