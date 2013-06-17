package io.mapping.apps.reamsnydergifts;

public class Person {

	private String name;
	private Person partner;
	private Person pair;
	private boolean wasPaired;
	
	public static void partnerMutually(Person p1, Person p2) {
		p1.setPartner(p2);
		p2.setPartner(p1);
	}
	
	public Person() {}
	
	public Person(String name) {
		setName(name);
	}
	
	public String getName() {
		return name;
	}
	
	public Person setName(String name) {
		this.name = name;
		return this;
	}
	
	public Person getPartner() {
		return partner;
	}
	
	public Person setPartner(Person partner) {
		if (partner != this.pair) {
			this.partner = partner;
		}
		return this;
	}
	
	public Person getPair() {
		return this.pair;
	}
	
	public Person setPair(Person pair) {
		if (pair != this.partner) {
			this.pair = pair;
			pair.setWasPaired(Boolean.TRUE);
		}
		return this;
	}
	
	public boolean getWasPaired() {
		return wasPaired;
	}
	
	public Person setWasPaired(Boolean wasPaired) {
		this.wasPaired = wasPaired;
		return this;
	}
	
	public boolean isPaired() {
		return this.pair != null;
	}
	
	@Override
	public String toString() {
		return String.format("%s is assigned %s", this.name, this.pair.name);
	}

}
