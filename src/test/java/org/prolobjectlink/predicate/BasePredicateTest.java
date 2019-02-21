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

import org.junit.Assert;
import org.prolobjectlink.BaseTest;
import org.prolobjectlink.db.Predicate;
import org.prolobjectlink.db.predicate.NotNullPredicate;
import org.prolobjectlink.domain.geometry.Point;

/** @author Jose Zalacain @since 1.0 */
public abstract class BasePredicateTest extends BaseTest {

	protected Predicate<Point> leftPredicate = new NotNullPredicate<Point>();
	protected Predicate<Point> rigthPredicate = new Predicate<Point>() {

		public boolean evaluate(Point o) {
			return o != null ? o.getX() < o.getY() : false;
		}
	};

	protected <T> void assertFalse(final Predicate<T> predicate, final T testObject) {
		Assert.assertFalse(predicate.evaluate(testObject));
	}

	protected <T> void assertTrue(final Predicate<T> predicate, final T testObject) {
		Assert.assertTrue(predicate.evaluate(testObject));
	}

}