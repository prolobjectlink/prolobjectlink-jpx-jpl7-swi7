package org.logicware.jpi.jpl7.swi;

import org.jpl7.Term;
import org.logicware.jpi.PrologConverter;
import org.logicware.jpi.PrologProvider;
import org.logicware.jpi.jpl7.JplConverter;

public class SwiPrologConverter extends JplConverter implements PrologConverter<Term> {

    @Override
    public PrologProvider createProvider() {
	return new SwiPrologProvider(this);
    }

}
