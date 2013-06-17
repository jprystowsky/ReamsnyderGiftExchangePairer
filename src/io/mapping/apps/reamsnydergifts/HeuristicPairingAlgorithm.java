package io.mapping.apps.reamsnydergifts;

import io.mapping.apps.reamsnydergifts.interfaces.PairingAlgorithm;
import io.mapping.apps.reamsnydergifts.interfaces.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class HeuristicPairingAlgorithm implements PairingAlgorithm {

	private List<Person> mPersons;

	public static PairingAlgorithm newPairer() {
		HeuristicPairingAlgorithm heuristicPairingAlgorithm = new HeuristicPairingAlgorithm();

		heuristicPairingAlgorithm.mPersons = new ArrayList<Person>();

		return heuristicPairingAlgorithm;
	}

	@Override
	public List<Person> getPersons() {
		return mPersons;
	}

	@Override
	public void setPersons(List<Person> persons) {
		mPersons = persons;
	}

	@Override
	public List<Person> doPairing() {
		List<Person> people = getPersons();

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
}
