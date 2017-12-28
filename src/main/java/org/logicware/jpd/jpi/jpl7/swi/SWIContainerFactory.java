package org.logicware.jpd.jpi.jpl7.swi;

import org.logicware.jpd.ContainerFactory;
import org.logicware.jpd.Properties;
import org.logicware.jpd.jpi.PrologContainerFactory;
import org.logicware.jpi.PrologProvider;
import org.logicware.jpi.jpl7.swi.SwiPrologProvider;

public final class SWIContainerFactory extends PrologContainerFactory {

	public SWIContainerFactory() {
		this(new Properties());
	}

	public SWIContainerFactory(Properties properties) {
		super(properties, new SwiPrologProvider());
	}

	public SWIContainerFactory(Properties properties, PrologProvider provider) {
		super(properties, provider);
	}

	public ContainerFactory createContainerFactory() {
		return this;
	}

}
