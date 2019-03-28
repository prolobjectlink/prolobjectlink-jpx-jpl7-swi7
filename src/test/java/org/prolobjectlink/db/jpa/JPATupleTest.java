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

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.util.Arrays;
import java.util.List;

import javax.persistence.TupleElement;

import org.junit.Test;
import org.prolobjectlink.BaseTest;
import org.prolobjectlink.db.jpa.JpaTuple;
import org.prolobjectlink.db.jpa.JpaTupleElement;
import org.prolobjectlink.domain.geometry.Point;
import org.prolobjectlink.domain.geometry.Polygon;
import org.prolobjectlink.domain.geometry.Segment;

public class JPATupleTest extends BaseTest {

	private TupleElement<Point> pointTupleElement = new JpaTupleElement<Point>("point", Point.class, a);
	private TupleElement<Segment> segmentTupleElement = new JpaTupleElement<Segment>("segment", Segment.class, ab);
	private TupleElement<Polygon> polygonTupleElement = new JpaTupleElement<Polygon>("triangle", Polygon.class,
			triangle);

	private List elements = Arrays.asList(pointTupleElement, segmentTupleElement, polygonTupleElement);

	private JpaTuple tuple = new JpaTuple(elements);

	@Test
	public final void testGetTupleElementOfX() {

		assertEquals(a, tuple.get(pointTupleElement));
		assertEquals(ab, tuple.get(segmentTupleElement));
		assertEquals(triangle, tuple.get(polygonTupleElement));

	}

	@Test
	public final void testGetStringClassOfX() {

		assertEquals(a, tuple.get("point", Point.class));
		assertEquals(ab, tuple.get("segment", Segment.class));
		assertEquals(triangle, tuple.get("triangle", Polygon.class));

	}

	@Test
	public final void testGetString() {

		assertEquals(a, tuple.get("point"));
		assertEquals(ab, tuple.get("segment"));
		assertEquals(triangle, tuple.get("triangle"));

	}

	@Test
	public final void testGetIntClassOfX() {

		assertEquals(a, tuple.get(0, Point.class));
		assertEquals(ab, tuple.get(1, Segment.class));
		assertEquals(triangle, tuple.get(2, Polygon.class));

	}

	@Test
	public final void testGetInt() {

		assertEquals(a, tuple.get(0));
		assertEquals(ab, tuple.get(1));
		assertEquals(triangle, tuple.get(2));

	}

	@Test
	public final void testToArray() {
		assertArrayEquals(new Object[] { a, ab, triangle }, tuple.toArray());
	}

	@Test
	public final void testGetElements() {
		assertSame(elements, tuple.getElements());
	}

}
