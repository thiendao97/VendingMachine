import java.util.Scanner; //gets user inputs

public class VendingMachine {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in); //food choice from user
		int cookiesQuantity = 10; // how many cookies are in the machine
		int candiesQuantity = 10; // how many candies are in the machine
		int chipsQuantity = 10; // how many chips are in the machine
		int quarters; // whatever the user put into machine
		int dimes; // whatever the user put into machine
		int nickels; // whatever the user put into machine
		double userMoney; // all of the users money after inputing all coins in the machine
		final double chipsPrice = 1.25; // the price of chips that never changes
		final double candiesPrice = .95; // the price of candies that never changes
		final double cookiesPrice = .85; // the price of cookies that never changes

// first menu screen for inserting coins
		System.out.println("Please insert Quarters"); //tells user to insert his quarters;
		quarters = getUserInput(); // goes back to method to see what getUserInput() is
		System.out.println("Please insert Dimes"); //tells user to insert his dimes;
		dimes = getUserInput(); // goes back to method to see what getUserInput() is
		System.out.println("Please insert Nickels"); //tells user to insert his nickels;
		nickels = getUserInput(); // goes back to method to see what getUserInput() is
		userMoney = calculateTotalMoney(quarters, dimes, nickels); // this sums all coins to total value
		System.out.println("Your total is " + userMoney); //outputs to user his total money in the vending machine
		
		boolean keepLooping = true;
		switch (determineWhichMenuOptions(userMoney)) {
			case 1:
				while (keepLooping) {
					System.out.println("Please choose a number: 1. Chips 2. Candies 3. Cookies");
					int userChoice = getUserInput();
		
					switch (userChoice) {
						case 1:
							if (chipsQuantity == 0) {
								System.out.println("Sold out. Please make another choice");
							}
							else {
								System.out.println("Please take your Chips");
								// userMoney - cookiesPrice find the left over money nad convert it to quarters first then dimes then nickles
								chipsQuantity --;
								keepLooping = false; // means stop looping because the choice was valid.
								double moneyRemaining = userMoney - chipsPrice;
								if (moneyRemaining == 0) {
									System.out.println("Have a nice day!");
								}
								else {
									printChipChange (moneyRemaining);
								}
							}
							break;
						case 2:
							if (candiesQuantity == 0) {
								System.out.println("Sold out. Please make another choice");
							}
							else {
								System.out.println("Please take your Candies");
								candiesQuantity --;
								keepLooping = false; // means stop looping because the choice was valid.
							}
							break;
						case 3:
							if (cookiesQuantity == 0) {
								System.out.println("Sold out. Please make another choice");
							}
							else {
								System.out.println( "Please take your Cookies");	
								cookiesQuantity --;
								keepLooping = false; // means stop looping because the choice was valid.
							}
							break;
						default:
					    	System.out.println("Invalid input please try again.\n");
					    	break;
					}// end of inner switch		
				} // exitWhileLoop
				//printChipChange ();
				//printCandyChange();
				//printCookieChange ();
				
				break;
			case 2:
				
				break;
			case 3:
				
				break;
			default:
				
			
		}// end of outer switch	
		//showMenu(userMoney, cookiesQuantity, candiesQuantity, chipsQuantity);
		
	}

// Checks user validation by making sure user only inputs a positive int and nothing else
	public static int getUserInput() { // name of method for user validation
		Scanner sc = new Scanner(System.in); // implements user input
		int number; // number that user typed
		
		do { // does user validation first until user finally types in correctly in which it will return the correct value for inserting coin menu
			while (!sc.hasNextInt()) { // if user puts in anything that's not an int. Returns true if the next token in this scanner's input can be interpreted as an int value
				System.out.println("Please type a number"); // tells user it is not an int
				sc.nextLine(); // returns the question "please type a number" if you keep typing a word. However if you type two words it repeats the question twice.
			}
			number = sc.nextInt(); // what ever int the user types is the number
			if (number < 0) { // checks to see if number is negative
				System.out.println("Please enter 0 or more\n"); // tells user to not type a negative number
			    sc.nextLine();
			}
		}
		while (number < 0);
		
		return number; // only return if user finally puts correct int
	}
	
// Formula and method for calculating coins into money
	public static double calculateTotalMoney(int quarters, int dimes, int nickels) { // name of method for calculating total money which includes the coin variables
		double userMoney = (quarters * .25) + (dimes * .10) + (nickels * .05); //formula for finding total amount of money from coins
		userMoney = Math.round(userMoney * 100.0) / 100.0; //rounds off two decimal places
		return userMoney; // returns to user the total amount after conversion from coins
	}
	
	public static int determineWhichMenuOptions (double userMoney) {
		if (userMoney >= 1.25) {
			return 1;
		}
		else if (userMoney >= 0.95 && userMoney < 1.25) {
			return 2;
		}
		else if (userMoney >= 0.85 && userMoney < 0.95) {
			return 3;
		}
		else {
			return 4;
		}
	
	}
	
	public static void  printChipChange(double userMoneyLeft) {
		int cents = (int) Math.round(userMoneyLeft * 100);
		int quarters = cents / 25;
		cents = cents % 25;
		int dimes = cents / 10;
		cents = cents % 10;
		int nickels = cents / 5;
		cents = cents % 5;
		
		System.out.println("Here are your cents: " + cents); 
		System.out.println("Here are your Quarters: " + quarters); 
		System.out.println("Here are your Dimes: " + dimes); 
		System.out.println("Here are your Nickels: " + nickels); 
	}
	
	/**
	public static void showMenu(double userMoney, int cookieQuantity, int candyQuantity, int chipQuantity) { 
		Scanner scanner = new Scanner(System.in);
		if (userMoney >= 1.25) { //user money exceeds 1.25, show user whole menu
			boolean keepLooping = true;
			
			while (keepLooping) {
				System.out.println("Please choose a number: 1. Chips 2. Candies 3. Cookies");
				int choice = scanner.nextInt();
				
				switch (choice) {
					case (1):
						if (chipQuantity == 0) {
							System.out.println("Sold out. Please make another choice");
						}
						else {
							System.out.println("Please take your Cookies");
							// userMoney - cookiesPrice find the left over money nad convert it to quarters first then dimes then nickles
							System.out.println("Here is your change\n");
							chipQuantity --;
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
						if (cookieQuantity == 0) {
							System.out.println("Sold out. Please make another choice");
						}
						else {
							System.out.println( "Please take your Chips");	
							System.out.println("Here is your change\n");
							cookieQuantity --;
							keepLooping = false; // means stop looping because the choice was valid.
						}
						break;
				    default: // means any other case
				    	System.out.println("Invalid input please try again.\n");
				    	break;
				}
			}
		}	
		
	}**/

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
		
	
	
	



	

		
	



