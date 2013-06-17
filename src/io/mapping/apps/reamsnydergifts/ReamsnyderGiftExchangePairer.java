package io.mapping.apps.reamsnydergifts;

import io.mapping.apps.reamsnydergifts.interfaces.PairingAlgorithm;
import io.mapping.apps.reamsnydergifts.interfaces.Person;
import io.mapping.apps.reamsnydergifts.models.ConcretePerson;

import java.util.ArrayList;
import java.util.List;


public class ReamsnyderGiftExchangePairer {

	public static void main(String[] args) {
		PairingAlgorithm pairer = HeuristicPairingAlgorithm.newPairer();

		pairer.setPersons(getGiftPersons());

		List<Person> people = pairer.doPairing();
		for (Person p : people) {
			System.out.println(p);
		}
	}

	/**
	 * Creates a static list of persons to be gift-paired.
	 *
	 * @return a list of Person objects
	 */
	private static List<Person> getGiftPersons() {
		Person jacob = ConcretePerson.newPerson("Jacob");
		Person mary = ConcretePerson.newPerson("Mary");
		ConcretePerson.partnerMutually(jacob, mary);

		Person joe = ConcretePerson.newPerson("Joe");
		Person ashley = ConcretePerson.newPerson("Ashley");
		ConcretePerson.partnerMutually(joe, ashley);

		Person jake = ConcretePerson.newPerson("Jake");
		Person megan = ConcretePerson.newPerson("Megan");
		ConcretePerson.partnerMutually(jake, megan);

		Person lee = ConcretePerson.newPerson("Lee");
		Person kristin = ConcretePerson.newPerson("Kristin");
		ConcretePerson.partnerMutually(lee, kristin);

		List<Person> people = new ArrayList<Person>();

		people.add(jacob);
		people.add(mary);
		people.add(joe);
		people.add(ashley);
		people.add(jake);
		people.add(megan);
		people.add(lee);
		people.add(kristin);

		return people;
	}
}