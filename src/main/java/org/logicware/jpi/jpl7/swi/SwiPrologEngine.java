package org.logicware.jpi.jpl7.swi;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;

import org.jpl7.Query;
import org.jpl7.Term;
import org.logicware.jpi.PrologClause;
import org.logicware.jpi.PrologEngine;
import org.logicware.jpi.PrologProvider;
import org.logicware.jpi.PrologQuery;
import org.logicware.jpi.PrologTerm;
import org.logicware.jpi.jpl7.JplEngine;
import org.logicware.jpi.jpl7.JplQuery;

public final class SwiPrologEngine extends JplEngine implements PrologEngine {

    private static final String META_INF = "META-INF";
    private static final String SWI_PROLOG = "swi-prolog.pl";
    private static final String SWI_TEMP_FILE = "prolobjectlink-jpi-jpl7-swi.pl";

    private static final String SWI_TEMP = TEMP + "/" + SWI_TEMP_FILE;
    private static final String SWI_PROCEDURE = META_INF + "/" + SWI_PROLOG;

    SwiPrologEngine(PrologProvider provider) {
	super(provider);
	InputStream in;
	OutputStream out;
	try {
	    Thread thread = Thread.currentThread();
	    ClassLoader cl = thread.getContextClassLoader();
	    if (!(new File(SWI_PROCEDURE).exists())) {
		in = cl.getResource(SWI_PROCEDURE).openStream();
		out = new FileOutputStream(SWI_TEMP);
		copy(in, out);
		System.out.println(SWI_TEMP);
	    }
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    SwiPrologEngine(PrologProvider provider, String file) {
	super(provider, file);
	InputStream in;
	OutputStream out;
	try {
	    Thread thread = Thread.currentThread();
	    ClassLoader cl = thread.getContextClassLoader();
	    if (!(new File(SWI_PROCEDURE).exists())) {
		in = cl.getResource(SWI_PROCEDURE).openStream();
		out = new FileOutputStream(SWI_TEMP);
		copy(in, out);
		System.out.println(SWI_TEMP);
	    }
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    @Override
    public synchronized void abolish(String functor, int arity) {
	query = new Query("" +

	"ensure_loaded('" + SWI_TEMP + "')," +

	"remove_all('" + location + "'," + functor + "," + arity + ")"

	);
	query.hasSolution();
    }

    @Override
    public synchronized void asserta(Term term) {
	// TODO Auto-generated method stub
    }

    @Override
    public synchronized void assertz(Term t) {
	Term h = t, b = BODY;
	if (t.hasFunctor(":-", 2)) {
	    h = t.arg(1);
	    b = t.arg(2);
	}
	query = new Query("" +

	"ensure_loaded('" + SWI_TEMP + "')," +

	"add_clause('" + location + "'," + t + "," + h + "," + b + ")"

	);
	query.hasSolution();
    }

    @Override
    public synchronized boolean clause(Term t) {
	Term h = t, b = BODY;
	if (t.hasFunctor(":-", 2)) {
	    h = t.arg(1);
	    b = t.arg(2);
	}
	query = new Query("" +

	"clause(" + h + "," + b + ")"

	);
	return query.hasSolution();
    }

    @Override
    public synchronized void retract(Term t) {
	query = new Query("" +

	"ensure_loaded('" + SWI_TEMP + "')," +

	"remove_clause('" + location + "'," + t + ")"

	);
	query.hasSolution();
    }

    public PrologQuery query(String stringQuery) {
	return new JplQuery(this, file, files, stringQuery);
    }

    public PrologQuery query(PrologTerm... terms) {
	String stringQuery = "";
	int length = terms.length;
	for (int i = 0; i < length; i++) {
	    stringQuery += i < length - 1 ? terms[i] + ", " : terms[i];
	}
	return query(stringQuery);
    }

    public Enumeration<PrologClause> getProgramClauses() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public synchronized int getProgramSize() {
	query = new Query(

		"ensure_loaded('" + SWI_TEMP + "')," +

	"program_size('" + location + "'," + KEY + ")"

	);
	Term term = query.oneSolution().get(KEY);
	return term.intValue();
    }

}
