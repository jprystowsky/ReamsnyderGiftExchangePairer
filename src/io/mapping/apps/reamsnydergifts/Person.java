package io.mapping.apps.reamsnydergifts;

/**
 * Provides an interface representing a physical person that can have a partner (i.e., romantically), which is a person
 * who should be excluded from gift-giving consideration (as a person will buy his or her partner gifts already), as
 * well as a pair, which is the person to whom this person will give a gift.
 * <p/>
 * A set of such persons will form a DCG (Directed Cyclic Graph).
 */
public interface Person {
	/**
	 * Returns a String representing the name of a person.
	 *
	 * @return the name of the person
	 */
	public String getName();

	/**
	 * Sets the name of this person to a new value.
	 *
	 * @param n the new name to assign
	 * @return this person
	 */
	public Person setName(String n);

	/**
	 * Returns the partner of this person.
	 *
	 * @return the person's partner (person who this person should not have as a pair)
	 */
	public Person getPartner();

	/**
	 * Sets the partner of this person to a new person
	 *
	 * @param p the person who should be this person's partner
	 * @return this person
	 */
	public Person setPartner(Person p);

	/**
	 * Returns the pair of this person, i.e., the person to whom this person will give a gift.
	 *
	 * @return the pair of this person
	 */
	public Person getPair();

	/**
	 * Sets the pair of this person to a new person
	 *
	 * @param p the person to whom this person should give a gift
	 * @return this person
	 */
	public Person setPair(Person p);

	/**
	 * Returns whether or not this person was paired to another person, i.e., whether or not there exists a person p1 in
	 * the graph of persons such that getPair(p1) == this.
	 *
	 * @return a Boolean object describing whether or not this person is another person's pair person
	 */
	public Boolean getWasPaired();

	/**
	 * Sets whether or not this person is another person's pair.
	 *
	 * @param b the value to indicate the pair status of this person with respect to another person
	 * @return a Boolean describing whether or not this person is another person's pair
	 */
	public Person setWasPaired(Boolean b);
}
