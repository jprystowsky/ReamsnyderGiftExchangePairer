package io.mapping.apps.reamsnydergifts;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class ReamsnyderGiftExchangePairer {

	public static void main(String[] args) {
		ReamsnyderGiftExchangePairer pairer = new ReamsnyderGiftExchangePairer();
		List<Person> people = pairer.doPairing();
		
		for (Person p : people) {
			System.out.println(p);
		}
	}
	
	List<Person> doPairing() {
		List<Person> people = getPeople();
		
		int iterationCount = 0;
		int assignedCount = 0;
		do {
			for (Person person : people) {
				if (person.getPair() != null) {
					continue;
				}
				
				List<Person> otherPeople = new ArrayList<Person>(people);
				
				otherPeople.remove(person);
				Collections.shuffle(otherPeople);
				
				for (Person consideration : otherPeople) {
					if (!consideration.getPartner().equals(person)
							&& !consideration.getWasPaired()) {
						person.setPair(consideration);
						assignedCount++;
						break;
					}
				}
			}
			iterationCount++;
			
			if (iterationCount > 1000) {
				System.err.println("Ending heuristically now. Please try again. Most likely, we were left with one graph cycle of nodes that can't be paired with each other as they're partners.");
				System.exit(1);
			}
		} while (assignedCount < people.size());
		
		return people;
	}
	
	List<Person> getPeople() {
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
