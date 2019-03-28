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
package org.prolobjectlink.performance;

import org.prolobjectlink.db.ContainerFactory;
import org.prolobjectlink.db.Storage;
import org.prolobjectlink.db.etc.Settings;
import org.prolobjectlink.db.prolog.jpl7.swi7.SwiPrologContainerFactory;
import org.prolobjectlink.domain.geometry.Point;
import org.prolobjectlink.prolog.Prolog;
import org.prolobjectlink.prolog.PrologProvider;
import org.prolobjectlink.prolog.jpl7.swi7.SwiProlog7;

public class MainPerformanceTest {

	// private static ObjectCache cache;
	private static Storage store;

	private static final int instanceNumber = 5000;

	private static final String LOCATION = "performance";
	// private static final String ROOT = "data" + File.separator + "test";

	protected static final Class<? extends ContainerFactory> driver = SwiPrologContainerFactory.class;

	// protected static final Class<?> engine = JBPEPrologEngine.class;
	// protected static final Class<?> engine = JLogProvider.class;
	protected static final Class<? extends PrologProvider> engine = SwiProlog7.class;
	// protected static final Class<?> engine = TuPrologProvider.class;
	// protected static final Class<?> engine = SwiPrologProvider.class;
	// protected static final Class<?> engine = ZPrologProvider.class;

	protected static final PrologProvider prolog = Prolog.getProvider(engine);

	public MainPerformanceTest() {
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// cache = Prolobjectlink.create(ENGINE).createCache();
		store = new Settings(driver).createStorage(LOCATION);

		Point[] array = new Point[instanceNumber];
		for (int i = 0; i < array.length; i++) {
			// array[i] = new Point("" + i + "", i, i);
			array[i] = new Point("a", i, i);
		}

		// bulk addition
		long startTimeMillis = System.currentTimeMillis();

		// cache.insert(array);
		store.insert(array);
		store.flush();

		long endTimeMillis = System.currentTimeMillis();
		float durationSeconds = (endTimeMillis - startTimeMillis) / 1000F;
		System.out.println("Bulk Add Duration: " + durationSeconds + " seconds");
		System.out.println();

		// contains
		startTimeMillis = System.currentTimeMillis();

		int last = instanceNumber - 1;
		// cache.contains(new Point("" + last + "", last, last));
		// store.contains(new Point("" + last + "", last, last));
		// System.out.println(cache.contains(new Point("" + last + "", last,
		// last)));
		// System.out.println(store.contains(new Point("a", last, last)));

		System.out.println(store.contains("'" + Point.class.getName() + "'(a, 999.0, 999.0)"));

		endTimeMillis = System.currentTimeMillis();
		durationSeconds = (endTimeMillis - startTimeMillis) / 1000F;
		System.out.println("Contains Duration: " + durationSeconds + " seconds");
		System.out.println();

		// find all
		startTimeMillis = System.currentTimeMillis();

		// cache.findAll(Point.class);
		// store.findAll(Point.class);
		// System.out.println(cache.findAll(Point.class).size());
		System.out.println(store.findAll(Point.class).size());

		endTimeMillis = System.currentTimeMillis();
		durationSeconds = (endTimeMillis - startTimeMillis) / 1000F;
		System.out.println("Find All Duration: " + durationSeconds + " seconds");
		System.out.println();

	}

}
