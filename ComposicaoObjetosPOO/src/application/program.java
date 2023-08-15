package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class program {

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter client data: ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth date: ");
		String birthDate = sc.nextLine();

		Client client = new Client(name, email, sdf.parse(birthDate));

		System.out.println("\n------------------------------\n");
		System.out.print("Enter status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());

		System.out.println("\nHow many items to this order? ");
		int cont = sc.nextInt();
		Order order = new Order(new Date(), status, client);

		

		for (int i = 0; i < cont; i++) {
			sc.nextLine();
			System.out.println("\n------------------------------\n");
			System.out.println("Enter #" + (i + 1) + " item data: ");
			System.out.print("\nProduct name: ");
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			double price = sc.nextDouble();
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();

			Product product = new Product(productName, price);
			OrderItem orderItem = new OrderItem(quantity, price, product);
			order.addItem(orderItem);

		}
		
		System.out.println("\n------------------------------\n");
		System.out.println(order.toString());

		sc.close();
	}

}
