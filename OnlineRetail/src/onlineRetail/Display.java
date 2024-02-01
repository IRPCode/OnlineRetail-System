package onlineRetail;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Display {
	public static void display(LinkedList<Order> queue) {
		// Populate arrays
		List<String> array = new ArrayList<String>();
		array.toString();
		for (Order order : queue) { // populated by name first to sort by name, uses getters in Order()
			array.add("\nLast name: " + order.getLastName() + ", Order number: " + order.getOrderNumber()
					+ ", Order cost: " + order.getOrderCost() + ".");
		}

		List<String> Numarray = new ArrayList<String>();
		for (Order order : queue) { // populated by order number first to sort by number, uses getters in Order()
			Numarray.add("\nOrder number: " + order.getOrderNumber() + ", Last name: " + order.getLastName()
					+ ", Order cost: " + order.getOrderCost() + ".");
		}

		// sorting arrays
		Collections.sort(Numarray);
		Collections.sort(array);

		// output sorted arrays
		System.out.println("\nSorted by name: " + array + "\n");
		System.out.println("Sorted by number: " + Numarray + "\n");
	}
}
