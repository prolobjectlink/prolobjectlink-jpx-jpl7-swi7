package org.logicware.jpd.jpi.jpl7.swi;

import org.logicware.jpd.Cache;
import org.logicware.jpd.ContainerFactory;
import org.logicware.jpd.Documents;
import org.logicware.jpd.Properties;
import org.logicware.jpd.jpi.PrologCache;
import org.logicware.jpd.jpi.PrologDocuments;
import org.logicware.jpi.jpl7.swi.SwiPrologProvider;

public final class SWIDocuments extends PrologDocuments {

	static final Documents instance = new SWIDocuments();

	protected SWIDocuments() {
		super(new Properties(), new SwiPrologProvider());
	}

	public Documents getInstance() {
		return instance;
	}

	public Cache createCache() {
		return new PrologCache(getProvider());
	}

	public ContainerFactory createContainerFactory() {
		return new SWIContainerFactory(getProperties(), getProvider());
	}

}
