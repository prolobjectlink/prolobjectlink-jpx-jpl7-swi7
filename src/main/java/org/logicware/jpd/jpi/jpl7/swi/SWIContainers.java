package org.logicware.jpd.jpi.jpl7.swi;

import org.logicware.jpd.ContainerFactory;
import org.logicware.jpd.Containers;
import org.logicware.jpd.Properties;
import org.logicware.jpd.jpi.PrologContainers;
import org.logicware.jpi.jpl7.swi.SwiPrologProvider;

public final class SWIContainers extends PrologContainers {

	static final Containers instance = new SWIContainers();

	protected SWIContainers() {
		super(new Properties(), new SwiPrologProvider());
	}

	public Containers getInstance() {
		return instance;
	}

	public ContainerFactory createContainerFactory() {
		return new SWIContainerFactory(getProperties(), getProvider());
	}

}
