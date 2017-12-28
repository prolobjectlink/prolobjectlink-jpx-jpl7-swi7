package org.logicware.jpi.jpl7.swi;

import org.jpl7.Term;
import org.logicware.jpi.PrologConverter;
import org.logicware.jpi.PrologEngine;
import org.logicware.jpi.PrologProvider;
import org.logicware.jpi.jpl7.JplProvider;

public class SwiPrologProvider extends JplProvider implements PrologProvider {

	public SwiPrologProvider() {
		super(new SwiPrologConverter());
	}

	public SwiPrologProvider(PrologConverter<Term> converter) {
		super(converter);
	}

	public PrologEngine newEngine() {
		return new SwiPrologEngine(this);
	}

	@Override
	public String toString() {
		return "SwiPrologProvider [converter=" + converter + "]";
	}

}
