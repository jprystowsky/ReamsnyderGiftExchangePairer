package io.mapping.apps.reamsnydergifts;

import io.mapping.apps.reamsnydergifts.interfaces.Person;
import io.mapping.apps.reamsnydergifts.models.ConcretePerson;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

public class HeuristicPairingAlgorithmTest {

	private static HeuristicPairingAlgorithm pairer;

	@BeforeClass
	public static void beforeClass() {
		pairer = (HeuristicPairingAlgorithm) HeuristicPairingAlgorithm.newPairer();
	}

	@Before
	public void setUp() throws Exception {
		Person jacob = ConcretePerson.newPerson("Jacob");
		Person mary = ConcretePerson.newPerson("Mary");
		ConcretePerson.partnerMutually(jacob, mary);

		Person joe = ConcretePerson.newPerson("Joe");
		Person ashley = ConcretePerson.newPerson("Ashley");
		ConcretePerson.partnerMutually(joe, ashley);

		List<Person> people = new ArrayList<Person>();

		people.add(jacob);
		people.add(mary);
		people.add(joe);
		people.add(ashley);


		pairer.setPersons(people);
	}

	@Test
	public void testSetPersons() {
		ArrayList<Person> persons = new ArrayList<Person>();
		persons.add(ConcretePerson.newPerson("Jacob"));
		pairer.setPersons(persons);

		assertSame(persons, pairer.getPersons());
	}

	@Test
	public void testGetPersons() {
		List<Person> people = pairer.getPersons();
		assertNotNull(people);
	}

	@Test
	public void testDoPairing() {
		List<Person> people = pairer.doPairing();
		for (Person person : people) {
			assertTrue(person.getWasPaired());

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
