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
	public void addContcatTest() {
		group.addContcat("name", "010-1234-1234");
	}
}
