/*-
 * #%L
 * prolobjectlink-db-jpl7-swi
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
package org.prolobjectlink.persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;
import org.prolobjectlink.BaseTest;
import org.prolobjectlink.domain.classes.OuterInnerClass;

public class InnerClassPersistenceTest extends BaseTest {

	@Test
	public final void testOuterClass() {

		storage.getTransaction().begin();
		storage.insert(new OuterInnerClass(60));
		assertTrue(storage.contains(new OuterInnerClass(60)));
		assertEquals(new OuterInnerClass(60), storage.find(new OuterInnerClass(60)));
		storage.delete(new OuterInnerClass(60));
		assertFalse(storage.contains(new OuterInnerClass(60)));
		storage.getTransaction().commit();
		storage.getTransaction().close();

	}

	@Test
	public final void testPublicInnerClass() {

		storage.getTransaction().begin();
		storage.insert(new OuterInnerClass(60).new PublicInnerClass(100));
		assertTrue(storage.contains(new OuterInnerClass(60).new PublicInnerClass(100)));
		assertEquals(new OuterInnerClass(60).new PublicInnerClass(100),
				storage.find(new OuterInnerClass(60).new PublicInnerClass(100)));
		storage.delete(new OuterInnerClass(60).new PublicInnerClass(100));
		assertFalse(storage.contains(new OuterInnerClass(60).new PublicInnerClass(100)));
		storage.getTransaction().commit();
		storage.getTransaction().close();

	}

	@Test
	public final void testPublicInnerClass2() {

		storageManager.getTransaction().begin();
		storageManager.insert(new OuterInnerClass(60).new PublicInnerClass(100));
		assertTrue(storageManager.contains(new OuterInnerClass(60).new PublicInnerClass(100)));
		assertEquals(new OuterInnerClass(60).new PublicInnerClass(100),
				storageManager.createQuery((new OuterInnerClass(60).new PublicInnerClass(100))).getSolution());
		storageManager.delete(new OuterInnerClass(60).new PublicInnerClass(100));
		assertFalse(storageManager.contains(new OuterInnerClass(60).new PublicInnerClass(100)));
		storageManager.getTransaction().commit();
		storageManager.getTransaction().close();

	}

	@Test
	public final void testPrivateInnerClass() {

		storage.getTransaction().begin();
		storage.insert(new OuterInnerClass(60).newPrivateInnerClass(100));
		assertTrue(storage.contains(new OuterInnerClass(60).newPrivateInnerClass(100)));
		assertEquals(new OuterInnerClass(60).newPrivateInnerClass(100),
				storage.find(new OuterInnerClass(60).newPrivateInnerClass(100)));
		storage.delete(new OuterInnerClass(60).newPrivateInnerClass(100));
		assertFalse(storage.contains(new OuterInnerClass(60).newPrivateInnerClass(100)));
		storage.getTransaction().commit();
		storage.getTransaction().close();

	}

	@Test
	@Ignore
	public final void testPrivateInnerClass2() {

		storageManager.getTransaction().begin();
		storageManager.insert(new OuterInnerClass(60).newPrivateInnerClass(100));
		assertTrue(storageManager.contains(new OuterInnerClass(60).newPrivateInnerClass(100)));
		assertEquals(new OuterInnerClass(60).newPrivateInnerClass(100),
				storageManager.createQuery(new OuterInnerClass(60).newPrivateInnerClass(100)));
		storageManager.delete(new OuterInnerClass(60).newPrivateInnerClass(100));
		assertFalse(storageManager.contains(new OuterInnerClass(60).newPrivateInnerClass(100)));
		storageManager.getTransaction().commit();
		storageManager.getTransaction().close();

	}

}
