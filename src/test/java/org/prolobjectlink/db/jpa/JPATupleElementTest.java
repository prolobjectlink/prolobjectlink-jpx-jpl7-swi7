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
package org.prolobjectlink.db.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.prolobjectlink.BaseTest;
import org.prolobjectlink.db.jpa.JpaTupleElement;
import org.prolobjectlink.domain.geometry.Point;
import org.prolobjectlink.domain.geometry.Segment;

public class JPATupleElementTest extends BaseTest {

	private JpaTupleElement<Point> pointTupleElement = new JpaTupleElement<Point>("point", Point.class);
	private JpaTupleElement<Segment> segmentTupleElement = new JpaTupleElement<Segment>("segment", Segment.class);

	@Test
	public final void testHashCode() {
		assertEquals(new JpaTupleElement<Point>("point", Point.class).hashCode(), pointTupleElement.hashCode());
		assertEquals(new JpaTupleElement<Segment>("segment", Segment.class).hashCode(), segmentTupleElement.hashCode());
	}

	@Test
	public final void testGetJavaType() {
		assertEquals(Point.class, pointTupleElement.getJavaType());
		assertEquals(Segment.class, segmentTupleElement.getJavaType());
	}

	@Test
	public final void testGetAlias() {
		assertEquals("point", pointTupleElement.getAlias());
		assertEquals("segment", segmentTupleElement.getAlias());
	}

	@Test
	public final void testGetValue() {
		assertNull(pointTupleElement.getValue());
		assertNull(segmentTupleElement.getValue());
	}

	@Test
	public final void testEqualsObject() {
		assertEquals(new JpaTupleElement<Point>("point", Point.class), pointTupleElement);
		assertEquals(new JpaTupleElement<Segment>("segment", Segment.class), segmentTupleElement);
	}

}
