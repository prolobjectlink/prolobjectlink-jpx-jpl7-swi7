/*-
 * #%L
 * prolobjectlink-jpx-jpl7-swi7
 * %%
 * Copyright (C) 2012 - 2019 Prolobjectlink Project
 * %%
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 * 1. Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 * #L%
 */
package org.prolobjectlink.db.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;

import javax.persistence.SynchronizationType;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.junit.Test;
import org.prolobjectlink.BaseTest;
import org.prolobjectlink.domain.model.Person;

public class JPAEntityManagerFactoryTest extends BaseTest {

	@Test
	public final void testCreateEntityManager() {
		assertNotNull(JPA_EMF);
		assertNotNull(JPA_EMF.createEntityManager());
	}

	@Test
	public final void testCreateEntityManagerMap() {
		assertNotNull(JPA_EMF);
		assertNotNull(JPA_EMF.createEntityManager(new HashMap<String, Object>()));
	}

	@Test
	public final void testCreateEntityManagerSynchronizationType() {
		assertEquals(JPA_EM, JPA_EMF.createEntityManager(SynchronizationType.UNSYNCHRONIZED));
	}

	@Test
	public final void testCreateEntityManagerSynchronizationTypeMap() {
		assertEquals(JPA_EM, JPA_EMF.createEntityManager(SynchronizationType.UNSYNCHRONIZED, properties));
	}

	@Test
	public final void testGetCriteriaBuilder() {
		CriteriaBuilder cb = JPA_EMF.getCriteriaBuilder();
		CriteriaQuery<Person> q = cb.createQuery(Person.class);
		Root<Person> p = q.from(Person.class);
		q.select(p).orderBy(cb.desc(p.get("id")));
		assertEquals("SELECT p FROM Person p ORDER BY p.id DESC", "" + q + "");
	}

	@Test
	public final void testGetMetamodel() {
		assertNotNull(JPA_EMF.getMetamodel());
	}

	@Test
	public final void testIsOpen() {
		assertTrue(JPA_EMF.isOpen());
	}

	@Test
	public final void testClose() {
		JPA_EMF.close();
		assertFalse(JPA_EMF.isOpen());
	}

	@Test
	public final void testGetProperties() {
		assertEquals(properties, JPA_EMF.getProperties());
	}

	@Test
	public final void testGetCache() {
		assertNotNull(JPA_EMF.getCache());
	}

	@Test
	public final void testGetPersistenceUnitUtil() {
		assertNotNull(JPA_EMF.getPersistenceUnitUtil());
	}

	@Test
	public final void testAddNamedQuery() {
		JPA_EMF.addNamedQuery("allPersons", JPA_EM.createQuery("SELECT p FROM Person p"));
		assertEquals(1, JPA_EMF.unwrap(JpaEntityManagerFactory.class).getNamedQueries().size());
	}

	@Test
	public final void testUnwrap() {
		assertSame(JPA_EMF, JPA_EMF.unwrap(JpaEntityManagerFactory.class));
	}

	@Test
	public final void testAddNamedEntityGraph() {
		JPA_EMF.addNamedEntityGraph("Person", JPA_EM.createEntityGraph(Person.class));
		assertEquals(1, JPA_EMF.unwrap(JpaEntityManagerFactory.class).getNamedEntityGraphs().size());
	}

}
