package org.prolobjectlink.db.prolog.jpl7.swi7;

import org.prolobjectlink.db.prolog.PrologDatabaseEngine;
import org.prolobjectlink.db.prolog.PrologProgrammer;
import org.prolobjectlink.prolog.PrologProvider;
import org.prolobjectlink.prolog.jpl7.swi7.SwiProlog7Engine;

public class SwiPrologDatabaseEngine extends SwiProlog7Engine implements PrologDatabaseEngine {

	SwiPrologDatabaseEngine() {
		super(new SwiPrologDatabaseProvider());
	}

	SwiPrologDatabaseEngine(PrologProvider provider) {
		super(provider);
	}

	public PrologProgrammer getProgrammer() {
		return new SwiProlog7Programmer(getProvider());
	}

}
