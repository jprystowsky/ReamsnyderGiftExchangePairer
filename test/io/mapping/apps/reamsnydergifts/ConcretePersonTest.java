package io.mapping.apps.reamsnydergifts;

import static org.junit.Assert.*;

import org.junit.Test;

public class ConcretePersonTest {
	
	@Test
	public void testPartnerMutually() {
		ConcretePerson personOne = new ConcretePerson();
		ConcretePerson personTwo = new ConcretePerson();
		
		ConcretePerson.partnerMutually(personOne, personTwo);
		assertSame(personOne.getPartner(), personTwo);
		assertSame(personTwo.getPartner(), personOne);
	}

	@Test
	public void testPerson() {
		ConcretePerson testPerson = new ConcretePerson();
		assertNull(testPerson.getName());
		assertNull(testPerson.getPair());
		assertNull(testPerson.getPartner());
		
		testPerson = new ConcretePerson("Jacob");
		assertEquals(testPerson.getName(), "Jacob");
	}
	
	@Test
	public void testSetName() {
		ConcretePerson testPerson = (ConcretePerson) new ConcretePerson().setName("Jacob");
		assertEquals(testPerson.getName(), "Jacob");
		
		testPerson.setName(null);
		assertNull(testPerson.getName());
	}

	@Test
	public void testSetPartner() {
		ConcretePerson testPersonPartner = new ConcretePerson();
		ConcretePerson testPerson = (ConcretePerson) new ConcretePerson().setPartner(testPersonPartner);
		assertSame(testPerson.getPartner(), testPersonPartner);
		
		ConcretePerson testPairPerson = new ConcretePerson();
		testPerson.setPair(testPairPerson);
		testPerson.setPartner(testPairPerson);
		assertNotSame(testPerson.getPartner(), testPairPerson);
		
		testPerson.setPartner(null);
		assertNull(testPerson.getPartner());
	}

	@Test
	public void testSetPair() {
		ConcretePerson testPersonPair = new ConcretePerson();
		ConcretePerson testPerson = (ConcretePerson) new ConcretePerson().setPair(testPersonPair);
		assertSame(testPerson.getPair(), testPersonPair);
		
		ConcretePerson testPartnerPerson = new ConcretePerson();
		testPerson.setPartner(testPartnerPerson);
		testPerson.setPair(testPartnerPerson);
		assertNotSame(testPerson.getPair(), testPartnerPerson);
	}
	
	@Test
	public void testGetWasPaired() {
		ConcretePerson testPerson = new ConcretePerson();
		assertFalse(testPerson.getWasPaired());
		
		ConcretePerson testOtherPerson = new ConcretePerson();
		testOtherPerson.setPair(testPerson);
		assertTrue(testPerson.getWasPaired());
	}
	
	@Test
	public void testIsPaired() {
		ConcretePerson testPerson = new ConcretePerson();
		assertFalse(testPerson.isPaired());
		
		ConcretePerson testPairPerson = new ConcretePerson();
		testPerson.setPair(testPairPerson);
		assertTrue(testPerson.isPaired());
	}
	
	@Test
	public void testToString() {
		ConcretePerson testPerson = new ConcretePerson("Jacob");
		ConcretePerson testPersonPartner = new ConcretePerson("Mary");
		ConcretePerson testPersonPair = new ConcretePerson("Joe");
		testPerson.setPartner(testPersonPartner).setPair(testPersonPair);
		
		assertEquals(testPerson.toString(), "Jacob is assigned Joe");
	}

}
