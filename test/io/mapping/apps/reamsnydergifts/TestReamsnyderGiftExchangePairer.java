package io.mapping.apps.reamsnydergifts;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestReamsnyderGiftExchangePairer {
	
	static ReamsnyderGiftExchangePairer pairer;
	
	@BeforeClass
	public static void beforeClass() {
		pairer = new ReamsnyderGiftExchangePairer();
	}

	@Test
	public void testGetPeople() {
		List<ConcretePerson> people = pairer.getPeople();
		assertTrue(people.size() > 0);
		assertTrue(people.size() % 2 == 0);
	}
	
	@Test
	public void testDoPairing() {
		List<ConcretePerson> people = pairer.doPairing();
		for (ConcretePerson person : people) {
			assertTrue(person.isPaired());
			
			int assignedTo = 0;
			for (ConcretePerson otherPerson : people) {
				if (otherPerson.getPair().equals(person)) {
					assignedTo++;
				}
			}
			
			assertTrue(assignedTo == 1);
		}
	}

}
