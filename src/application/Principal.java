package application;


import entities.Client;
import entities.Order;
import entities.Orderitem;
import entities.Product;
import entities.enuns.OrderStatus;

import java.sql.SQLOutput;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Order order = new Order();

        System.out.println("Enter cliente data:");
        System.out.print("name: ");
        String nameClient = sc.nextLine();
        System.out.print("email: ");
        String emailClient = sc.next();
        System.out.print("date: ");
        String dateClient = sc.next();

        order.setClient(new Client(nameClient, emailClient, new Date()));

        System.out.println("Enter order data:");
        System.out.print("status: ");
        String status = sc.next();

        OrderStatus orderStatus = OrderStatus.valueOf(status);
        order.setStatus(orderStatus);

        System.out.println("How many items to this order? ");
        int qtdItems = sc.nextInt();

        for (int i = 0; i < qtdItems; i++) {
            System.out.println("Enter #" + (i+1) +  " item data:");
            System.out.println("Product name:");
            String productName = sc.next();
            System.out.println("Product price:");
            double productPrice = sc.nextDouble();
            System.out.println("Quantity:");
            int quantidyOrderItem = sc.nextInt();
            order.addItem(new Orderitem(quantidyOrderItem, productPrice, new Product(productName, productPrice)));
        }

        System.out.println("ORDER SUMMARY:");
        System.out.println("Order moment: " );
        System.out.println("Order status: " + order.getStatus());
        System.out.println("Client: " + order.getClient().getNameClient());
        System.out.println("Email: " + order.getClient().getEmail());
        System.out.println("data: " + dateClient);

        System.out.println("Order items:");
        char sn;
        do {
            for (int i = 0; i < order.getItems().size(); i++) {
                System.out.printf("%s, $%.2f, quantity: %d, subtotal: $%.2f  \n",
                        order.getItems().get(i).getProduct().getName(),
                        order.getItems().get(i).getPrice(),
                        order.getItems().get(i).getQuantity(),
                        order.getItems().get(i).subTotal());

            }
            System.out.printf("Total price: $%.2f%n", order.total());

            System.out.println("----------------------------");
            System.out.println("desejar remover um item? S/N");
            sn = sc.next().charAt(0);

            if (sn == 'S'){
                System.out.println("qual item deseja remover? ");
                for (int i = 0; i < order.getItems().size(); i++) {
                    System.out.println("item " + (i+1) + " " + order.getItems().get(i).getProduct().getName());
                }
                System.out.print("digite o numero para remover: ");
                int remove = sc.nextInt();
                order.removeItem(order.getItems().remove(remove - 1));
            }


        } while (sn == 'S');

    }
}
