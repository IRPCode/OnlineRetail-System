package onlineRetail;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	static LinkedList<Order> queue = new LinkedList<>();
	static Scanner scanner = new Scanner(System.in);

	public static void main(String args[]) {
		// goes to the choice() method
		choice(queue);
	}

	public static void choice(LinkedList<Order> queue) {
		// allows user to choose to add, remove, or display customer data.
		int x = 0;
		int userInput = 0;
		while (x == 0) {
			try {
				System.out.println("Would you like to add, remove or display an order?");
				System.out.println("Enter '1' for add, '2' for remove, '3' for display and quit.");
				userInput = scanner.nextInt();
			} catch (Exception e) { // here to make sure the user behaves
				System.out.println("Please enter a numeric value. Program terminated.");
				x = 1;
			}
			if (userInput == 1) { // goes to the addOrder() method, sends queue
				System.out.println("You have selected add.");
				queue = Order.addOrder(queue);
			}

			else if (userInput == 2) { // goes to the removeOrder() method, sends queue
				System.out.println("You have selected remove.");
				queue = Order.removeOrder(queue);
			}

			else if (userInput == 3) { // goes to the display() method, sends queue
				System.out.println("You have selected display.");
				Display.display(queue);
				System.out.println("Program terminated.");
				x = 1;
			}

			else { // if the user inputs a number not 1-3
				System.out.println("Input error. Please try again.");
			}

		}
	}
}
