/*
 * #%L
 * prolobjectlink-db-jpl7-swi
 * %%
 * Copyright (C) 2012 - 2018 WorkLogic Project
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package org.worklogic.prolog.jpl7.swi;

import org.logicware.prolog.jpl7.swi7.SwiProlog7;
import org.worklogic.db.HierarchicalCache;
import org.worklogic.db.etc.Settings;
import org.worklogic.db.prolog.PrologContainerFactory;

public final class SwiPrologContainerFactory extends PrologContainerFactory {

	public SwiPrologContainerFactory(Settings settins) {
		super(settins, new SwiProlog7());
	}

	public HierarchicalCache createHierarchicalCache() {
		return new SwiPrologHierarchicalCache(getProvider(), getSettings(), this);
	}

}