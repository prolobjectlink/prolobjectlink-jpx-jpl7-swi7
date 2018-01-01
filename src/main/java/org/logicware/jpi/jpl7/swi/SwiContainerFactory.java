package org.logicware.jpi.jpl7.swi;

import org.logicware.ContainerFactory;
import org.logicware.Properties;
import org.logicware.jpi.PrologContainerFactory;
import org.logicware.jpi.PrologProvider;

public final class SwiContainerFactory extends PrologContainerFactory {

	public SwiContainerFactory() {
		this(new Properties());
	}

	public SwiContainerFactory(Properties properties) {
		super(properties, new SwiPrologProvider());
	}

	public SwiContainerFactory(Properties properties, PrologProvider provider) {
		super(properties, provider);
	}

	public ContainerFactory createContainerFactory() {
		return this;
	}

}
