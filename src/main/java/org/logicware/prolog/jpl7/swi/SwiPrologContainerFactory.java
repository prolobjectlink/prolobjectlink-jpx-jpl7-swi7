package org.logicware.prolog.jpl7.swi;

import org.logicware.database.HierarchicalCache;
import org.logicware.database.Settings;
import org.logicware.database.prolog.PrologContainerFactory;
import org.logicware.prolog.jpl7.swi7.SwiProlog7;

public final class SwiPrologContainerFactory extends PrologContainerFactory {

	public SwiPrologContainerFactory(Settings settins) {
		super(settins, new SwiProlog7());
	}

	public HierarchicalCache createHierarchicalCache() {
		return new SwiPrologHierarchicalCache(getProvider(), getSettings(), this);
	}

}
