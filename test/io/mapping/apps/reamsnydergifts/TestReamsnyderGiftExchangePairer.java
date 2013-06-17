package io.mapping.apps.reamsnydergifts;

import static org.junit.Assert.*;

import java.util.List;

import io.mapping.apps.reamsnydergifts.Person;
import io.mapping.apps.reamsnydergifts.ReamsnyderGiftExchangePairer;
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
		List<Person> people = pairer.getPeople();
		assertTrue(people.size() > 0);
		assertTrue(people.size() % 2 == 0);
	}
	
	@Test
	public void testDoPairing() {
		List<Person> people = pairer.doPairing();
		for (Person person : people) {
			assertTrue(person.isPaired());
			
			int assignedTo = 0;
			for (Person otherPerson : people) {
				if (otherPerson.getPair().equals(person)) {
					assignedTo++;
				}
			}
			
			assertTrue(assignedTo == 1);
		}
	}

}
