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
package org.prolobjectlink;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.prolobjectlink.db.DatabaseSequence;
import org.prolobjectlink.domain.model.Address;
import org.prolobjectlink.domain.model.Person;

public class DatabaseSequenceTest extends BaseTest {

	@Test
	public void testGetName() {

		DatabaseSequence dbp = rdb.getSchema().addSequence("person_sequence", "", Person.class, 1);
		assertEquals("person_sequence", rdb.getSchema().getSequence("person_sequence").getName());
		assertEquals(dbp, rdb.getSchema().getSequence("person_sequence"));

		DatabaseSequence dba = rdb.getSchema().addSequence("address_sequence", "", Address.class, 1);
		assertEquals("address_sequence", rdb.getSchema().getSequence("address_sequence").getName());
		assertEquals(dba, rdb.getSchema().getSequence("address_sequence"));

	}

	@Test
	public void testGetIncrement() {

		DatabaseSequence dbp = rdb.getSchema().addSequence("person_sequence", "", Person.class, 1);
		assertEquals(1, rdb.getSchema().getSequence("person_sequence").getIncrement());
		assertEquals(dbp, rdb.getSchema().getSequence("person_sequence"));

		DatabaseSequence dba = rdb.getSchema().addSequence("address_sequence", "", Address.class, 1);
		assertEquals(1, rdb.getSchema().getSequence("address_sequence").getIncrement());
		assertEquals(dba, rdb.getSchema().getSequence("address_sequence"));

	}

	@Test
	public void testGetValue() {

		DatabaseSequence dbp = rdb.getSchema().addSequence("person_sequence", "", Person.class, 1);
		assertEquals(0, rdb.getSchema().getSequence("person_sequence").getValue());
		assertEquals(dbp, rdb.getSchema().getSequence("person_sequence"));
		dbp.setValue(20);
		assertEquals(20, rdb.getSchema().getSequence("person_sequence").getValue());

	}

	@Test
	public void testSetValue() {

		DatabaseSequence dbp = rdb.getSchema().addSequence("person_sequence", "", Person.class, 1);
		assertEquals(0, rdb.getSchema().getSequence("person_sequence").getValue());
		assertEquals(dbp, rdb.getSchema().getSequence("person_sequence"));
		dbp.setValue(20);
		assertEquals(20, rdb.getSchema().getSequence("person_sequence").getValue());

	}

	@Test
	public void testGetSchema() {
		assertNotNull(rdb.getSchema().addSequence("address_sequence", "", Address.class, 1).getSchema());
	}

	@Test
	public void testToString() {
		assertEquals("address_sequence",
				rdb.getSchema().addSequence("address_sequence", "", Address.class, 1).toString());
	}

	@Test
	public void testHashCode() {
		assertEquals(rdb.getSchema().addSequence("address_sequence", "", Address.class, 1).hashCode(),
				rdb.getSchema().addSequence("address_sequence", "", Address.class, 1).hashCode());
		assertTrue(rdb.getSchema().addSequence("address_sequence", "", Address.class, 1).hashCode() != rdb.getSchema()
				.addSequence("address_sequence", "", Address.class, 2).hashCode());
		assertTrue(rdb.getSchema().addSequence("address_sequence", "", Address.class, 1).hashCode() != rdb.getSchema()
				.addSequence("other_address_sequence", "", Address.class, 1).hashCode());
		assertTrue(rdb.getSchema().addSequence("address_sequence", "", Address.class, 1).hashCode() != rdb.getSchema()
				.addSequence(null, "", Address.class, 2).hashCode());
	}

	@Test
	public void testEquals() {

		DatabaseSequence s = rdb.getSchema().addSequence("address_sequence", "", Address.class, 1);
		assertEquals(s, s);

		s = rdb.getSchema().addSequence("address_sequence", "", Address.class, 1);
		assertFalse(s.equals(null));

		assertEquals(rdb.getSchema().addSequence("address_sequence", "", Address.class, 1),
				rdb.getSchema().addSequence("address_sequence", "", Address.class, 1));

		assertFalse(rdb.getSchema().addSequence("address_sequence", "", Address.class, 1)
				.equals(rdb.getSchema().addSequence(null, "", Address.class, 2)));

		assertFalse(rdb.getSchema().addSequence("address_sequence", "", Address.class, 1)
				.equals(rdb.getSchema().addSequence(null, "", Address.class, 0)));

		assertFalse(rdb.getSchema().addSequence("address_sequence", "", Address.class, 1)
				.equals(rdb.getSchema().addSequence("address_sequence", "", Address.class, 2)));

		assertFalse(rdb.getSchema().addSequence("address_sequence", "", Address.class, 1).equals(new Object()));

		assertFalse(rdb.getSchema().addSequence(null, "", Address.class, 1)
				.equals(rdb.getSchema().addSequence(null, "", Address.class, 2)));

	}

}
