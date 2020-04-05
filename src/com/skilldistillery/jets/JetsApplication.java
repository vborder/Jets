package com.skilldistillery.jets;

import java.util.Scanner;

public class JetsApplication {
	private AirField kHawk = new AirField();
	Scanner kb = new Scanner(System.in);

	public static void main(String[] args) {
		JetsApplication jetApp = new JetsApplication();
		jetApp.launch();
	}

	public void launch() {
		System.out.println("\n        Welcome to the JetPlay App!            ");
		kHawk.readJets();
		displayUserMenu();
	}

	public void displayUserMenu() {
		boolean menuSel = true;
		
		do {
			System.out.println("\n-----------------MAIN MENU-----------------");
			System.out.println("           Select an item (number)           ");
			System.out.println("1: List fleet                                ");
			System.out.println("2: Fly all jets                              ");
			System.out.println("3: View the fastest jet					     ");
			System.out.println("4: View the jet with the longest range       ");
			System.out.println("5: Load all Cargo jets                       ");
			System.out.println("6: DogFight!                                 ");
			System.out.println("7: Add a jet to the fleet                    ");
			System.out.println("8: Remove a jet from the fleet               ");
			System.out.println("9: Quit                                      ");
			int menuChoice = kb.nextInt();

			switch (menuChoice) {
			case 1:
				kHawk.displayFleet(); // displays jets
				break;
			case 2:
				kHawk.fly(); // fly method is executed on all jets
				break;
			case 3:
				kHawk.fastJet(); // displays fastest jet in fleet
				break;
			case 4:
				kHawk.airbus(); // displays jet with longest range
				break;
			case 5:
				kHawk.loadJet(); // load method executed on all jets
				break;
			case 6:
				kHawk.fightJet(); // dogfight method executed on all jets
				break;
			case 7:
				kHawk.addJet(); // adds jet to the fleet
				break;
			case 8:
				kHawk.removeJet(); // removes jet from fleet
				break;
			case 9:
				kHawk.exitApp(); // exits program
				System.out.println("Thanks for flying with us. Aim high!");
				menuSel = false;
				System.exit(0);
			default:
				System.out.println("That was not a valid selection. Please select another choice from the menu.\n");
			}

		} while (menuSel = true);
	}

}
