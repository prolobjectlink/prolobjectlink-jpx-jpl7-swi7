package org.logicware.prolog.jpl7.swi;

import org.logicware.database.ContainerFactory;
import org.logicware.database.HierarchicalCache;
import org.logicware.database.ObjectConverter;
import org.logicware.database.Settings;
import org.logicware.database.prolog.PrologHierarchicalCache;
import org.logicware.prolog.PrologProvider;
import org.logicware.prolog.PrologTerm;

public class SwiPrologHierarchicalCache extends PrologHierarchicalCache implements HierarchicalCache {

	public SwiPrologHierarchicalCache(PrologProvider provider, Settings settings, ContainerFactory containerFactory) {
		super(provider, settings, new SwiPrologContainerFactory(settings));
	}

	public SwiPrologHierarchicalCache(PrologProvider provider, Settings settings, ObjectConverter<PrologTerm> converter,
			ContainerFactory containerFactory) {
		super(provider, settings, converter, new SwiPrologContainerFactory(settings));
	}

}
