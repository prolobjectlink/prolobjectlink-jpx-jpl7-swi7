package org.prolobjectlink.reference;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import javax.swing.JFrame;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.prolobjectlink.BaseTest;
import org.prolobjectlink.prolog.PrologEngine;
import org.prolobjectlink.prolog.PrologQuery;

public class ReferenceTest extends BaseTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		PrologEngine engine = provider.newEngine();
		PrologQuery query = engine.query("jpl_new( 'javax.swing.JFrame', ['frame with dialog'], F)");
		Map<String, Object> m = query.oneVariablesResult();
		assertEquals(JFrame.class, m.get("F").getClass());
	}

}
