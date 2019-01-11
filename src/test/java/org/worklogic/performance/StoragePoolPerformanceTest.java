package org.worklogic.performance;

import org.logicware.prolog.Prolog;
import org.logicware.prolog.PrologProvider;
import org.logicware.prolog.jpl7.swi7.SwiProlog7;
import org.worklogic.db.ContainerFactory;
import org.worklogic.db.StoragePool;
import org.worklogic.db.etc.Settings;
import org.worklogic.domain.geometry.Point;
import org.worklogic.prolog.jpl7.swi.SwiPrologContainerFactory;

public class StoragePoolPerformanceTest {

	static final Class<? extends ContainerFactory> driver = SwiPrologContainerFactory.class;
	static final Class<? extends PrologProvider> engine = SwiProlog7.class;
	static final PrologProvider prolog = Prolog.newProvider(engine);

	public static void main(String[] args) {

		StoragePool pool = new Settings(driver).createStoragePool("stress", "test");

		Point[] array = new Point[100000];
		for (int i = 0; i < array.length; i++) {
			// array[i] = new Point("" + i + "", i, i);
			array[i] = new Point("a", i, i);
		}

		// bulk addition
		long startTimeMillis = System.currentTimeMillis();
		pool.insert(array);
		pool.flush();
		// pool.clear();
		// pool.close();
		long endTimeMillis = System.currentTimeMillis();
		float durationSeconds = (endTimeMillis - startTimeMillis) / 1000F;
		System.out.println("Bulk Add Duration: " + durationSeconds + " seconds");
		System.out.println();

		// contains
		startTimeMillis = System.currentTimeMillis();
		// pool.open();
		System.out.println(pool.contains("'" + Point.class.getName() + "'(a, 999.0, 999.0)"));
		// pool.clear();
		// pool.close();
		endTimeMillis = System.currentTimeMillis();
		durationSeconds = (endTimeMillis - startTimeMillis) / 1000F;
		System.out.println("Contains Duration: " + durationSeconds + " seconds");
		System.out.println();

		// find all
		startTimeMillis = System.currentTimeMillis();
		// pool.open();
		System.out.println(pool.findAll(Point.class).size());
		// pool.clear();
		// pool.close();
		endTimeMillis = System.currentTimeMillis();
		durationSeconds = (endTimeMillis - startTimeMillis) / 1000F;
		System.out.println("Find All Duration: " + durationSeconds + " seconds");
		System.out.println();

	}

}
