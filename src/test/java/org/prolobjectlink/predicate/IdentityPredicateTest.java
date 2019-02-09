/*
 * #%L
 * prolobjectlink-db-jpl7-swi
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
package org.prolobjectlink.predicate;

import org.junit.Test;
import org.prolobjectlink.db.predicate.IdentityPredicate;
import org.prolobjectlink.domain.geometry.Point;
import org.prolobjectlink.domain.geometry.Polygon;
import org.prolobjectlink.domain.geometry.Segment;

public class IdentityPredicateTest extends BasePredicateTest {

	@Test
	public final void testEvaluate() {

		assertTrue(new IdentityPredicate<Point>(a), a);
		assertTrue(new IdentityPredicate<Segment>(ab), ab);
		assertTrue(new IdentityPredicate<Polygon>(triangle), triangle);

		assertFalse(new IdentityPredicate<Point>(a), b);
		assertFalse(new IdentityPredicate<Segment>(ab), bc);
		assertFalse(new IdentityPredicate<Polygon>(triangle), tetragon);

		assertFalse(new IdentityPredicate<Point>(a), new Point("a", 3, 14));
		assertFalse(new IdentityPredicate<Segment>(ab), new Segment("ab", a, b));
		assertFalse(new IdentityPredicate<Polygon>(triangle), new Polygon(new String("triangle"), ab, bc, ca));

	}
}
