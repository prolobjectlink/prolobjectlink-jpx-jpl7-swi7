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

	public Containers getInstance() {
		return instance;
	}

	public ContainerFactory createContainerFactory() {
		return new JPISWIContainerFactory(getProperties(), getProvider());
	}

}
