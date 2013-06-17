package io.mapping.apps.reamsnydergifts;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class ReamsnyderGiftExchangePairer {

	public static void main(String[] args) {
		ReamsnyderGiftExchangePairer pairer = new ReamsnyderGiftExchangePairer();
		List<ConcretePerson> people = pairer.doPairing();
		
		for (ConcretePerson p : people) {
			System.out.println(p);
		}
	}
	
	protected List<ConcretePerson> doPairing() {
		List<ConcretePerson> people = getPeople();
		
		int iterationCount = 0;
		int assignedCount = 0;
		do {
			for (ConcretePerson person : people) {
				if (person.getPair() != null) {
					continue;
				}
				
				List<ConcretePerson> otherPeople = new ArrayList<ConcretePerson>(people);
				
				otherPeople.remove(person);
				Collections.shuffle(otherPeople);
				
				for (ConcretePerson consideration : otherPeople) {
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
	
	protected List<ConcretePerson> getPeople() {
		ConcretePerson jacob = new ConcretePerson("Jacob");
		ConcretePerson mary = new ConcretePerson("Mary");
		ConcretePerson.partnerMutually(jacob, mary);
		
		ConcretePerson joe = new ConcretePerson("Joe");
		ConcretePerson ashley = new ConcretePerson("Ashley");
		ConcretePerson.partnerMutually(joe, ashley);
		
		ConcretePerson jake = new ConcretePerson("Jake");
		ConcretePerson megan = new ConcretePerson("Megan");
		ConcretePerson.partnerMutually(jake, megan);
		
		ConcretePerson lee = new ConcretePerson("Lee");
		ConcretePerson kristin = new ConcretePerson("Kristin");
		ConcretePerson.partnerMutually(lee, kristin);
		
		List<ConcretePerson> people = new ArrayList<ConcretePerson>();
		
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
