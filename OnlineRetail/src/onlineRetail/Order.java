package onlineRetail;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Order { // instantiates variables
	private String lastName;
	private int orderNumber;
	private double orderCost;
	static int intFinder = 0;
	private static ArrayList<Integer> numberDuplicate = new ArrayList<Integer>(); // ArrayList to see if entered value
																					// exists in removeOrder() method
																					// (╯°□°)╯︵ ┻━┻
	private static Scanner scanner = new Scanner(System.in);

	public Order(String lastName, int orderNumber, double orderCost) { // technically a setter() method
		this.lastName = lastName;
		this.orderNumber = orderNumber;
		this.orderCost = orderCost;
	}

	// adds order to queue
	// gets user input and attributes a random number and price to order name for
	// convenience
	public static LinkedList<Order> addOrder(LinkedList<Order> queue) {
		DecimalFormat decFormat = new DecimalFormat("##.##"); // format template
		System.out.println("Enter customer's last name.");
		String lastName = scanner.nextLine(); // gets customer's name
		System.out.println("Enter " + lastName + "'s order number.");
		int orderNumber = scanner.nextInt(); // gets random order number
		numberDuplicate.add(orderNumber);
		System.out.println("Enter the cost of the order.");
		double orderCost = scanner.nextDouble(); // gets price
		scanner.nextLine(); //consumes newline
		String formatted = decFormat.format(orderCost);
		orderCost = Double.parseDouble(formatted); // formats double
		queue.add(new Order(lastName, orderNumber, orderCost)); // sends the Order object to the Order() method, and
																// adds to queue
		return queue; // returns data to Main() class
	}

	public static LinkedList<Order> removeOrder(LinkedList<Order> queue) {
		int index = 0;
		int x = 0;
		int y = 0;
		System.out.println("Enter the order number associated with the order that you want to remove.");
		System.out.println("Here is a list of values that you can choose to delete.");
		while (y < numberDuplicate.size()) { // neatly prints out values you can delete
			System.out.println(numberDuplicate.get(y));
			y++;
		}
		intFinder = scanner.nextInt();
		while (x != 1) { // if order exists, loop breaks, if not, it will tell the user to try again
			if (numberDuplicate.contains(intFinder)) { // if true, removes queue element, returns queue to Main()
				x = 1;
				index = numberDuplicate.indexOf(intFinder);
				queue.remove(index);
				numberDuplicate.remove(index);
				System.out.println("Entry successfully deleted.");
				return queue;
			}

			else { // if false, prompts user to try again, and sends them to the Main() class
				x = 1;
				System.out.println("Invalid input. Try again.");
			}
		}
		return queue;
	}

	// getters for the Display() class
	public String getLastName() {
		return lastName;
	}

	public String getOrderNumber() {
		String intOrderNumber = String.valueOf(orderNumber);
		return intOrderNumber;
	}

	public String getOrderCost() {
		String dblOrderCost = String.valueOf(orderCost);
		return dblOrderCost;
	}
}
