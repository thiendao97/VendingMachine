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

// first menu screen for inserting coins
		while(true) {
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
								System.out.println("Please take your Chips\n");
								// userMoney - cookiesPrice find the left over money nad convert it to quarters first then dimes then nickles
								chipsQuantity --;
								keepLooping = false; // means stop looping because the choice was valid.
								printChipChange (userMoney, userChoice);
							}
							break;
						case 2:
							if (candiesQuantity == 0) {
								System.out.println("Sold out. Please make another choice");
							}
							else {
								System.out.println("Please take your Candies\n");
								candiesQuantity --;
								keepLooping = false; // means stop looping because the choice was valid.
								printChipChange (userMoney, userChoice);
							}
							break;
						case 3:
							if (cookiesQuantity == 0) {
								System.out.println("Sold out. Please make another choice");
							}
							else {
								System.out.println("Please take your Cookies\n");	
								cookiesQuantity --;
								keepLooping = false; // means stop looping because the choice was valid.
								printChipChange (userMoney, userChoice);
							}
							break;
						default:
					    	System.out.println("Invalid input please try again.\n");
					    	break;
					}// end of inner switch	1	
				} // exitWhileLoopCase1
				break;
			case 2:
				while (keepLooping) {
					System.out.println("Please choose a number: 2. Candies 3. Cookies");
					int userChoice = getUserInput();
					switch (userChoice) {
					case 2:
						if (candiesQuantity == 0) {
							System.out.println("Sold out. Please make another choice");
						}
						else {
							System.out.println("Please take your Candies\n");
							candiesQuantity --;
							keepLooping = false; // means stop looping because the choice was valid.
							printChipChange (userMoney, userChoice);
						}
						break;
					case 3:
						if (cookiesQuantity == 0) {
							System.out.println("Sold out. Please make another choice");
						}
						else {
							System.out.println("Please take your Cookies\n");	
							cookiesQuantity --;
							keepLooping = false; // means stop looping because the choice was valid.
							printChipChange (userMoney, userChoice);
						}
						break;
					default:
				    	System.out.println("Invalid input please try again.\n");
				    	break;
					} //end of inner switch 2	
				} // exitWhileLoopCase2
				break;
			case 3:
				while (keepLooping) {
					System.out.println("Please choose a number: 3. Cookies");
					int userChoice = getUserInput();
					switch (userChoice) {
					case 3:
						if (cookiesQuantity == 0) {
							System.out.println("Sold out. Please make another choice");
						}
						else {
							System.out.println("Please take your Cookies\n");	
							cookiesQuantity --;
							keepLooping = false; // means stop looping because the choice was valid.
							printChipChange (userMoney, userChoice);
						}
						break;
					default:
				    	System.out.println("Invalid input please try again.\n");
				    	break;
					} //end of inner switch 3
				} // exitWhileLoopCase3
				break;
			default:
				System.out.println("Invalid input please try again.\n");
		    	break;
		}// end of outer switch	
	}
	}// end of main

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
				System.out.println("Please enter 0 or more"); // tells user to not type a negative number
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
	
	public static void  printChipChange(double moneyInserted, int userChoice) {
		double chipsPrice = 1.25; // the price of chips that never changes
		double candiesPrice = .95; // the price of candies that never changes
		double cookiesPrice = .85; // the price of cookies that never changes
		double moneyRemaining;
		

		
		switch (userChoice) {
			case 1:
				moneyRemaining = moneyInserted - chipsPrice;
				break;
			case 2:
				moneyRemaining = moneyInserted - candiesPrice;
				break;
			default:
				moneyRemaining = moneyInserted - cookiesPrice;
				break;
		}
		//System.out.println("Your total change is: " + moneyRemaining); 
		
		if (moneyRemaining == 0) {
			System.out.println("Have a nice day!\n");
		}
		else {
			int cents = (int) Math.round(moneyRemaining * 100);
			int quarters = cents / 25;
			cents = cents % 25;
			int dimes = cents / 10;
			cents = cents % 10;
			int nickels = cents / 5;
			cents = cents % 5;
			
			System.out.println("Here are your Quarters: " + quarters ); 
			System.out.println("Here are your Dimes: " + dimes); 
			System.out.println("Here are your Nickels: " + nickels);
			System.out.println("Have a nice day!\n");
		}
	}
}




