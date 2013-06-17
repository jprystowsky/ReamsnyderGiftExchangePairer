package io.mapping.apps.reamsnydergifts;

import io.mapping.apps.reamsnydergifts.interfaces.PairingAlgorithm;
import io.mapping.apps.reamsnydergifts.interfaces.Person;

import java.util.List;


public class ReamsnyderGiftExchangePairer {

	public static void main(String[] args) {
		PairingAlgorithm pairer = HeuristicPairingAlgorithm.newPairer();
		List<Person> people = pairer.doPairing();

		for (Person p : people) {
			System.out.println(p);
		}
	}
}