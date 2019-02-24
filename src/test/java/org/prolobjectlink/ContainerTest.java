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

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.prolobjectlink.domain.geometry.Point;
import org.prolobjectlink.domain.geometry.Polygon;
import org.prolobjectlink.domain.geometry.Segment;

public class ContainerTest extends BaseTest {

	@Test
	public final void testContainsString() {

		cache.add(a);
		cache.add(b);
		cache.add(c);
		cache.add(ab);
		cache.add(bc);
		cache.add(ca);
		cache.add(triangle);

		assertTrue(cache.contains("'" + Point.class.getName() + "'(Idp, X, Y)"));
		assertTrue(cache.contains("'" + Point.class.getName() + "'( a, 3,14 )"));
		assertTrue(cache.contains("'" + Point.class.getName() + "'( b, 3,14 )"));
		assertTrue(cache.contains("'" + Point.class.getName() + "'( c, 3,14 )"));

		assertTrue(cache.contains("'" + Segment.class.getName() + "'(Ids, Point0, Point1)"));
		assertTrue(cache.contains("'" + Segment.class.getName() + "'( ab, '" + Point.class.getName() + "'( a, 3,14 ), '"
				+ Point.class.getName() + "'( b, 3,14 ) )"));
		assertTrue(cache.contains("'" + Segment.class.getName() + "'( bc, '" + Point.class.getName() + "'( b, 3,14 ), '"
				+ Point.class.getName() + "'( c, 3,14 ) )"));
		assertTrue(cache.contains("'" + Segment.class.getName() + "'( ca, '" + Point.class.getName() + "'( c, 3,14 ), '"
				+ Point.class.getName() + "'( a, 3,14 ) )"));

		assertTrue(cache.contains("'" + Polygon.class.getName() + "'( triangle, Segment0, Segment1, Segment2 )"));
		assertTrue(cache.contains("'" + Polygon.class.getName() + "'( triangle, '" + Segment.class.getName()
				+ "'( ab, '" + Point.class.getName() + "'( a, 3,14 ), '" + Point.class.getName() + "'( b, 3,14 ) ), '"
				+ Segment.class.getName() + "'( bc, '" + Point.class.getName() + "'( b, 3,14 ), '"
				+ Point.class.getName() + "'( c, 3,14 ) ), '" + Segment.class.getName() + "'( ca, '"
				+ Point.class.getName() + "'( c, 3,14 ), '" + Point.class.getName() + "'( a, 3,14 ) ) )"));

		assertTrue(cache.contains(
				"'" + Segment.class.getName() + "'(Ids, Point0, Point1), '" + Point.class.getName() + "'(Idp, X, Y)"));

	}

	@Test
	public final void testContainsObject() {

		cache.add(a);
		cache.add(b);
		cache.add(c);
		cache.add(ab);
		cache.add(bc);
		cache.add(ca);
		cache.add(triangle);

		assertTrue(cache.contains(a));
		assertTrue(cache.contains(b));
		assertTrue(cache.contains(c));
		assertTrue(cache.contains(ab));
		assertTrue(cache.contains(bc));
		assertTrue(cache.contains(ca));
		assertTrue(cache.contains(triangle));

	}

	@Test
	public final void testContainsClassOfQ() {

		cache.add(a);
		cache.add(b);
		cache.add(c);
		cache.add(ab);
		cache.add(bc);
		cache.add(ca);
		cache.add(triangle);

		assertTrue(cache.contains(Point.class));
		assertTrue(cache.contains(Segment.class));
		assertTrue(cache.contains(Polygon.class));

	}

}
