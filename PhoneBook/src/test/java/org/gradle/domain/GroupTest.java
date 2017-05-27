package org.gradle.domain;

import org.junit.Before;
import org.junit.Test;

public class GroupTest {

	private Group group;
	
	@Before
	public void setUp(){
		group = new Group();
	}
	
	@Test
	public void add_contcat_test() {
		group.addContcat("name", "number");
	}
}
