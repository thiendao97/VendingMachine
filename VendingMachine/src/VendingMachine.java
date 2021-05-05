import java.util.Scanner; //gets user inputs

public class VendingMachine {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in); //food choice from user
		int cookieQuantity = 10;
		int candyQuantity = 10;
		int chipQuantity = 10;
		int quarters;
		int dimes;
		int nickels;
		double userMoney;
		final double chipsPrice = 1.25;
		final double candiesPrice = .95;
		final double cookiesPrice = .85;
		
		
		System.out.println("Please insert Quarters"); //tells user to insert his quarters;
		quarters = getUserInput();
		System.out.println("Please insert Dimes"); //tells user to insert his dimes;
		dimes = getUserInput();
		System.out.println("Please insert Nickels"); //tells user to insert his nickels;
		nickels = getUserInput();

		userMoney = calculateTotalMoney(quarters, dimes, nickels);
		// temporery version
		System.out.println("Your total is " + userMoney); //outputs to user his total money in the vending machine
	}

	public static int getUserInput() {
		Scanner sc = new Scanner(System.in);
		int number;
		
		do {
			while (!sc.hasNextInt()) {
				System.out.println("That's not a number!");
				sc.next(); // this is important!
			}
			number = sc.nextInt();
			if (number < 0) {
				System.out.println("Please enter 0 or more");
			}
			
		} while (number < 0);
		//System.out.println("Thank you we have received " + number + " coins.\n");
		return number;
	}
	
	public static double calculateTotalMoney(int quarters, int dimes, int nickels) {
		double userMoney = (quarters * .25) + (dimes * .10) + (nickels * .05); //formula for finding total amount of money from coins
		userMoney = Math.round(userMoney * 100.0) / 100.0; //rounds off two decimal places
		return userMoney;
	}

}






//Menu for food is money is over 1.25
			/*if (userMoney >= 1.25) { //user money exceeds 1.25, show user whole menu
				boolean keepLooping = true;
				
				while (keepLooping) {
					System.out.println("Please choose a number: 1. Cookies 2. Candies");
					int choice = scanner.next();
					
					switch (choice) {
						case (1):
							if (cookieQuantity == 0) {
								System.out.println("Sold out. Please make another choice");
							}
							else {
								System.out.println("Please take your Cookies");
								// userMoney - cookiesPrice find the left over money nad convert it to quarters first then dimes then nickles
								System.out.println("Here is your change\n");
								cookieQuantity --;
								keepLooping = false; // means stop looping because the choice was valid.
							}
							break;
						case (2):
							if (candyQuantity == 0) {
								System.out.println("Sold out. Please make another choice");
							}
							else {
								System.out.println("Please take your Candies");
								System.out.println("Here is your change\n");
								candyQuantity --;
								keepLooping = false; // means stop looping because the choice was valid.
							}
							
							break;
						case (3):
							if (chipQuantity == 0) {
								System.out.println("Sold out. Please make another choice");
							}
							else {
								System.out.println( "Please take your Chips");	
								System.out.println("Here is your change\n");
								chipQuantity --;
								keepLooping = false; // means stop looping because the choice was valid.
							}
							break;
					    default: // means any other case
					    	System.out.println("Invalid input please try again.\n");
					    	break;
					}
				}
			}	
			
//menu for food if money is over .95 but not 1.25
			else if (userMoney >= 0.95 && userMoney < 1.25) { //user money exceeds 0.95 but below 1.25, show user only Cookies and Candies
				boolean keepLooping = true;
				
				while (keepLooping) {
				System.out.println("\nPlease choose a number: 1. Cookies 2. Candies");
				int choice = scanner.nextInt();
				
				switch (choice) {
					case 1:
						if (cookieQuantity == 0) {
							System.out.println("Sold out. Please make another choice");
						}
						else {
							System.out.println("Please take your Cookies");
							System.out.println("Here is your change\n");
							cookieQuantity --;
							keepLooping = false; // means stop looping because the choice was valid.
						}
						break;
					case 2:
						if (candyQuantity == 0) {
							System.out.println("Sold out. Please make another choice");
						}
						else {
							System.out.println("Please take your Candies");
							System.out.println("Here is your change\n");
							candyQuantity --;
							keepLooping = false; // means stop looping because the choice was valid.
						}
						
						break;
					default: // means any other case
				    	System.out.println("Invalid input please try again.");
				    	break;
				    }
				}
			}
			
//menu for food if money is over .85 but not .95			
			else if (userMoney >= 0.85 && userMoney < 0.95) { //user money exceeds 0.85 but below 0.95, show user only Candies
				boolean keepLooping = true;
				
				while (keepLooping) {
				System.out.println("\nPlease choose a number: 2. Candies");
				int choice = scanner.nextInt();
					
				switch (choice) {
					case 2:
						if (cookieQuantity == 0) {
							System.out.println("Sold out. Please make another choice");
						}
						else {
							System.out.println("Please take your Cookies");
							System.out.println("Here is your change\n");
							cookieQuantity --;
							keepLooping = false; // means stop looping because the choice was valid.
							}
							break;
					default: // means any other case
				    	System.out.println("Invalid input please try again.");
				    	break;
				    }
				}
			}

//to do: make last statement loop back to money input menu and finish change program
//menu for food if money is under .85			
			else if (userMoney < 0.85) { //user money is less than 0.85, show user no menu a
				boolean keepLooping = true;
				
				while (keepLooping) {
				System.out.println("Sorry you do not have enough funds, " + userMoney + " cents have been returned to you.");
				keepLooping = false;
			}
			}
		}
	}
}
*/

			
	 



			
	
				
		//}

		

	

		/*double quarterChange = (userMoney / .25);
		double dimeChange = (userMoney / .10);
		double nickleChange = (userMoney / .05);
		while (userMoney > 0) {
			if (userMoney >= 25) {
			}
		}
	
     }
	
	public static void printMenu () {
	*/
		
	
	
	



	

		
	



