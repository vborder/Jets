package com.skilldistillery.jets;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class AirField {
	private ArrayList<Jet> jets = new ArrayList<>();;
	Scanner kb = new Scanner(System.in);

	public List<Jet> readJets() {
		try (BufferedReader bufIn = new BufferedReader(new FileReader("jetFile.txt"))) {
			String line;
			while ((line = bufIn.readLine()) != null) {

				String[] jetYard = line.split(", ");
				String model = jetYard[0];
				double speed = Double.parseDouble(jetYard[1]);
				int range = Integer.parseInt(jetYard[2]);
				long price = Long.parseLong(jetYard[3]);
				if (model.contains("F-")) {
					Jet fighter = new FighterJet(model, speed, range, price);
					jets.add(fighter);
				}
				if (model.contains("C-")) {
					Jet cargo = new CargoPlane(model, speed, range, price);
					jets.add(cargo);
				}
			}
			bufIn.close();
		} catch (IOException e) {
			System.err.println(e);
		}
		return jets;
	}

	public void displayFleet() {

		System.out.println("The fleet of jets includes: \n");
		for (Jet jet : jets) {
			System.out.println(jet.toString());
		}
	}

	public void fly() {
		for (Jet jet : jets) {
			jet.fly();
		}
	}

	public void fastJet() {
		double fastestJet = 0.0;

		for (Jet jet : jets) {
			if (fastestJet < jet.getSpeed()) {
				fastestJet = jet.getSpeed();
			}
		}
		for (Jet jet : jets) {
			if (fastestJet == jet.getSpeed()) {
				System.out.println("The fastest jet is: " + jet.toString());
			}
		}
	}

	public void airbus() {
		int airbus = 0;

		for (Jet jet : jets) {
			if (airbus < jet.getRange()) {
				airbus = jet.getRange();
			}
		}
		for (Jet jet : jets) {
			if (airbus == jet.getRange()) {
				System.out.println("The jet with the longest range is: " + jet.toString());
			}
		}
	}

	public void loadJet() {
		for (Jet jet : jets) {
			if (jet instanceof CargoPlane) {
				((CargoPlane) jet).loadCargo();
			}
		}
	}

	public void fightJet() {
		for (Jet jet : jets) {
			if (jet instanceof FighterJet) {
				((FighterJet) jet).fight();
			}
		}
	}

	public void addJet() {

		System.out.println("\nLet's create your jet!\n");
		System.out.println("Enter the jet model: ");
		String model = kb.next();

		System.out.println("Enter the jet speed: ");
		double speed = kb.nextDouble();

		System.out.println("Enter the jet range: ");
		int range = kb.nextInt();

		System.out.println("Enter the jet cost: ");
		long price = kb.nextLong();

		Jet plane = new JetImpl(model, speed, range, price);
		if (model.contains("F-")) {
			Jet fighter = new FighterJet(model, speed, range, price);
			jets.add(fighter);
		}
		if (model.contains("C-")) {
			Jet cargo = new CargoPlane(model, speed, range, price);
			jets.add(cargo);
		} else {
			jets.add(plane);
		}
		System.out.println("\nThe jet you created has been added to the fleet.");
	}

	public void removeJet() {
		int counter = 0;
		boolean menuDisplay = true;

		while (menuDisplay) {
			System.out.println("--------------------FLEET---------------------\n");
			for (Jet jet : jets) {
				counter++;
				System.out.println(String.valueOf(counter) + " " + jet);
			}

			System.out.println("\nWhich jet would you like to remove? Enter the jet's corresponding number, "
					+ "or 0 to return to the main menu.\n");
			int menuChoice = kb.nextInt();

			if (menuChoice == 0) {
				menuDisplay = false;
			} else {
				menuChoice = menuChoice - 1;
				jets.remove(menuChoice);
				System.out.println("The jet you selected has been removed.\n");
				counter = 0;
			}

		}
	}

	public void exitApp() {
		System.out.println("Thanks for flying with us. Aim high!");
		System.exit(0);
	}

}
