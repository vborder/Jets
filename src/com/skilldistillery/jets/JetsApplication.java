package com.skilldistillery.jets;

import java.util.Scanner;

public class JetsApplication {
	private AirField khawk = new AirField();
	public AirField airField;
	Scanner kb = new Scanner(System.in);

	public static void main(String[] args) {
		
		JetsApplication jetApp = new JetsApplication();
		jetApp.launch();
	}	
		public void launch() {
			System.out.println("          Welcome to the JetForce App!              \n");
			khawk.readJets();
			displayUserMenu();
		}
		
		public void displayUserMenu() {
			boolean menuSel = true;
			do {
				
				System.out.println("-----------------MAIN MENU-------------------");
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
				
				switch(menuChoice) {
				case 1: 
					khawk.displayFleet(); // displays jets
					break;
				case 2: 
					khawk.fly(); // fly method is executed on all jets
					break;
				case 3:
					khawk.fastJet(); // displays fastest jet in fleet
					break;
				case 4: 
					khawk.airbus(); // displays jet with longest range
					break;
				case 5: 
					khawk.loadJet(); // load method executed on all jets
					break;
				case 6: 
					khawk.fightJet(); // dogfight method executed on all jets
					break;
				case 7:
					khawk.addJet(); // adds jet to the fleet
					break;
				case 8:
					khawk.removeJet(); // removes jet from fleet
					break;
				case 9:
//					airField.exitApp(); // exits program
					System.out.println("Thanks for flying with us. Aim high!");
					menuSel = false;
					System.exit(0);
				default:
					System.out.println("That was not a valid selection. Please select another choice from the menu.\n");
				}	
				
			} while (menuSel = true);
		}

}
