package io.mapping.apps.reamsnydergifts;

import static org.junit.Assert.*;

import io.mapping.apps.reamsnydergifts.Person;
import org.junit.Test;

public class PersonTest {
	
	@Test
	public void testPartnerMutually() {
		Person personOne = new Person();
		Person personTwo = new Person();
		
		Person.partnerMutually(personOne, personTwo);
		assertSame(personOne.getPartner(), personTwo);
		assertSame(personTwo.getPartner(), personOne);
	}

	@Test
	public void testPerson() {
		Person testPerson = new Person();
		assertNull(testPerson.getName());
		assertNull(testPerson.getPair());
		assertNull(testPerson.getPartner());
		
		testPerson = new Person("Jacob");
		assertEquals(testPerson.getName(), "Jacob");
	}
	
	@Test
	public void testSetName() {
		Person testPerson = new Person().setName("Jacob");
		assertEquals(testPerson.getName(), "Jacob");
		
		testPerson.setName(null);
		assertNull(testPerson.getName());
	}

	@Test
	public void testSetPartner() {
		Person testPersonPartner = new Person();
		Person testPerson = new Person().setPartner(testPersonPartner);
		assertSame(testPerson.getPartner(), testPersonPartner);
		
		Person testPairPerson = new Person();
		testPerson.setPair(testPairPerson);
		testPerson.setPartner(testPairPerson);
		assertNotSame(testPerson.getPartner(), testPairPerson);
		
		testPerson.setPartner(null);
		assertNull(testPerson.getPartner());
	}

	@Test
	public void testSetPair() {
		Person testPersonPair = new Person();
		Person testPerson = new Person().setPair(testPersonPair);
		assertSame(testPerson.getPair(), testPersonPair);
		
		Person testPartnerPerson = new Person();
		testPerson.setPartner(testPartnerPerson);
		testPerson.setPair(testPartnerPerson);
		assertNotSame(testPerson.getPair(), testPartnerPerson);
	}
	
	@Test
	public void testGetWasPaired() {
		Person testPerson = new Person();
		assertFalse(testPerson.getWasPaired());
		
		Person testOtherPerson = new Person();
		testOtherPerson.setPair(testPerson);
		assertTrue(testPerson.getWasPaired());
	}
	
	@Test
	public void testIsPaired() {
		Person testPerson = new Person();
		assertFalse(testPerson.isPaired());
		
		Person testPairPerson = new Person();
		testPerson.setPair(testPairPerson);
		assertTrue(testPerson.isPaired());
	}
	
	@Test
	public void testToString() {
		Person testPerson = new Person("Jacob");
		Person testPersonPartner = new Person("Mary");
		Person testPersonPair = new Person("Joe");
		testPerson.setPartner(testPersonPartner).setPair(testPersonPair);
		
		assertEquals(testPerson.toString(), "Jacob is assigned Joe");
	}

}
