package org.logicware.prolog.jpl7.swi;

import org.logicware.pdb.ContainerFactory;
import org.logicware.pdb.HierarchicalCache;
import org.logicware.pdb.ObjectConverter;
import org.logicware.pdb.Settings;
import org.logicware.pdb.prolog.PrologHierarchicalCache;
import org.logicware.pdb.prolog.PrologProvider;
import org.logicware.pdb.prolog.PrologTerm;

public class SwiPrologHierarchicalCache extends PrologHierarchicalCache implements HierarchicalCache {

	public SwiPrologHierarchicalCache(PrologProvider provider, Settings settings, ContainerFactory containerFactory) {
		super(provider, settings, new SwiPrologContainerFactory(settings));
	}

	public SwiPrologHierarchicalCache(PrologProvider provider, Settings settings, ObjectConverter<PrologTerm> converter,
			ContainerFactory containerFactory) {
		super(provider, settings, converter, new SwiPrologContainerFactory(settings));
	}

}
