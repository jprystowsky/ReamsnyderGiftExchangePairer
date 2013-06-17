package io.mapping.apps.reamsnydergifts.interfaces;

import java.util.List;

/**
 * Provides an interface for an algorithm to generate valid pairs of gift-giving pairs among people.
 */
public interface PairingAlgorithm {
	/**
	 * Sets the list of persons to be paired together.
	 *
	 * @param l the list of persons to be paired together
	 */
	void setPersons(List<Person> l);

	/**
	 * Returns a list of persons (or concrete implementations thereof) to be paired together.
	 *
	 * @return a list of persons who have not yet been paired
	 */
	List<Person> getPersons();

	/**
	 * Returns a list of persons who have been paired together for gift-giving purposes.
	 *
	 * @return a list of persons, who have now been paired
	 */
	List<Person> doPairing();
}
