package org.logicware.jpd.jpi.jpl7.swi;

import org.logicware.jpd.ContainerFactory;
import org.logicware.jpd.Properties;
import org.logicware.jpd.jpi.JPIContainerFactory;
import org.logicware.jpi.PrologProvider;
import org.logicware.jpi.jpl7.swi.SwiPrologProvider;

public final class JPISWIContainerFactory extends JPIContainerFactory {

	public JPISWIContainerFactory() {
		this(new Properties());
	}

	public JPISWIContainerFactory(Properties properties) {
		super(properties, new SwiPrologProvider());
	}

	public JPISWIContainerFactory(Properties properties, PrologProvider provider) {
		super(properties, provider);
	}

	public ContainerFactory createContainerFactory() {
		return this;
	}

}
