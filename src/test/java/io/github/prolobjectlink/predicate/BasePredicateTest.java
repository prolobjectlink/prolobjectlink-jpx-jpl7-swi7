/*
 * #%L
 * prolobjectlink-jpx-jpl7-swi7
 * %%
 * Copyright (C) 2019 Prolobjectlink Project
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 2.1 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Lesser Public License for more details.
 * 
 * You should have received a copy of the GNU General Lesser Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/lgpl-2.1.html>.
 * #L%
 */
package io.github.prolobjectlink.predicate;

import org.junit.Assert;

import io.github.prolobjectlink.BaseTest;
import io.github.prolobjectlink.db.Predicate;
import io.github.prolobjectlink.db.predicate.NotNullPredicate;
import io.github.prolobjectlink.domain.geometry.Point;

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
