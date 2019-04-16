package org.prolobjectlink.db.prolog.jpl7.swi7;

import org.prolobjectlink.db.prolog.PrologDatabaseEngine;
import org.prolobjectlink.db.prolog.PrologDatabaseProvider;
import org.prolobjectlink.prolog.jpl7.swi7.SwiProlog7;

public class SwiPrologDatabaseProvider extends SwiProlog7 implements PrologDatabaseProvider {

	public PrologDatabaseEngine newEngine() {
		return new SwiPrologDatabaseEngine(this);
	}

	public PrologDatabaseEngine newEngine(String path) {
		PrologDatabaseEngine engine = newEngine();
		engine.consult(path);
		return engine;
	}

}
