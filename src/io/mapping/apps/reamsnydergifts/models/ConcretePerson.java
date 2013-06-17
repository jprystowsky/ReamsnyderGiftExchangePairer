package io.mapping.apps.reamsnydergifts.models;

import io.mapping.apps.reamsnydergifts.interfaces.Person;

/**
 * A concrete implementation of the Person interface. Nothing fancy.
 */
public class ConcretePerson implements Person {

	private String mName;
	private Person mPartner;
	private Person mPair;
	private boolean mWasPaired;

	/**
	 * Instantiates a new ConcretePerson with the given name.
	 *
	 * @param name the name of this person
	 * @return a new ConcretePerson named {@code name}
	 */
	public static Person newPerson(String name) {
		return new ConcretePerson(name);
	}

	/**
	 * Assigns two Persons to be each other's partner. This is primarily a convenience method to save typing
	 * repetitive code, and eliminate errors from forgetting to assign one person as a partner, or accidentally
	 * assigning partners in incomprehensible ways. (We don't support polygamy.)
	 *
	 * @param p1 the first person (the second person's partner)
	 * @param p2 the second person (the first person's partner)
	 */
	public static void partnerMutually(Person p1, Person p2) {
		p1.setPartner(p2);
		p2.setPartner(p1);
	}

	/**
	 * Instantiates a new, blank ConcretePerson.
	 */
	public ConcretePerson() {
	}

	/**
	 * Instantiates a new ConcretePerson named {@code name}.
	 *
	 * @param name the name of the new ConcretePerson
	 */
	private ConcretePerson(String name) {
		setName(name);
	}

	@Override
	public String getName() {
		return mName;
	}

	@Override
	public Person setName(String name) {
		this.mName = name;
		return this;
	}

	@Override
	public Person getPartner() {
		return mPartner;
	}

	@Override
	public Person setPartner(Person partner) {
		if (partner != this.mPair) {
			this.mPartner = partner;
		}
		return this;
	}

	@Override
	public Person getPair() {
		return this.mPair;
	}

	@Override
	public Person setPair(Person pair) {
		if (pair != this.mPartner) {
			this.mPair = pair;
			pair.setWasPaired(Boolean.TRUE);
		}
		return this;
	}

	@Override
	public Boolean getWasPaired() {
		return mWasPaired;
	}

	@Override
	public Person setWasPaired(Boolean wasPaired) {
		this.mWasPaired = wasPaired;
		return this;
	}

	@Override
	public Boolean isPaired() {
		return this.mPair != null;
	}

	@Override
	public String toString() {
		return String.format("%s is assigned %s", this.mName, this.mPair.getName());
	}

}
