package com.skilldistillery.jets;

public class FighterJet extends Jet implements CombatReady {

	public FighterJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}
	
	public void fight() {
		System.out.println(getModel() + " is locked and loaded and ready to take down some planes ...");
	}
}
