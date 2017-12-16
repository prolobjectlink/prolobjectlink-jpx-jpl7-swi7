package org.logicware.jpd.jpi.jpl7.swi;

import org.logicware.jpd.ContainerFactory;
import org.logicware.jpd.Containers;
import org.logicware.jpd.Properties;
import org.logicware.jpd.jpi.JPIContainers;
import org.logicware.jpi.jpl7.swi.SwiPrologProvider;

public final class JPISWIContainers extends JPIContainers {

    static final Containers instance = new JPISWIContainers();

    protected JPISWIContainers() {
	super(new Properties(), new SwiPrologProvider());
    }

    @Override
    public Containers getInstance() {
	return instance;
    }

    @Override
    public ContainerFactory createContainerFactory() {
	return new JPISWIContainerFactory(getProperties(), getProvider());
    }

}
