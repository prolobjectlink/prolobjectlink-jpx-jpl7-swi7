package org.logicware.jpd.jpi.jpl7.swi;

import org.logicware.jpd.Cache;
import org.logicware.jpd.ContainerFactory;
import org.logicware.jpd.Documents;
import org.logicware.jpd.Properties;
import org.logicware.jpd.jpi.JPICache;
import org.logicware.jpd.jpi.JPIDocuments;
import org.logicware.jpi.jpl7.swi.SwiPrologProvider;

public final class JPISWIDocuments extends JPIDocuments {

    static final Documents instance = new JPISWIDocuments();

    protected JPISWIDocuments() {
	super(new Properties(), new SwiPrologProvider());
    }

    @Override
    public Documents getInstance() {
	return instance;
    }

    public Cache createCache() {
	return new JPICache(getProvider());
    }

    @Override
    public ContainerFactory createContainerFactory() {
	return new JPISWIContainerFactory(getProperties(), getProvider());
    }

}
