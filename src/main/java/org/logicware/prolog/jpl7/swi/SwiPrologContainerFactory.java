package org.logicware.prolog.jpl7.swi;

import org.logicware.pdb.HierarchicalCache;
import org.logicware.pdb.Settings;
import org.logicware.pdb.prolog.PrologContainerFactory;
import org.logicware.prolog.jpl7.swi7.SwiPrologProvider;

public final class SwiPrologContainerFactory extends PrologContainerFactory {

	public SwiPrologContainerFactory(Settings settins) {
		super(settins, new SwiPrologProvider());
	}

	public HierarchicalCache createHierarchicalCache() {
		return new SwiPrologHierarchicalCache(getProvider(), getSettings(), this);
	}

}
