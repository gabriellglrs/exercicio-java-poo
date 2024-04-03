package entities;

import entities.enuns.OrderStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private Date moment;
    private OrderStatus status;
    private Client client;
    List<Orderitem> items = new ArrayList<>();

    public Order() {
    }

    public Order(Date moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Orderitem> getItems() {
        return items;
    }

    public void addItem(Orderitem orderitem){
        items.add(orderitem);
   }

   public void removeItem(Orderitem orderitem){
        items.remove(orderitem);
   }

   public double total(){
        double soma = 0;
        for (Orderitem total : items){
            soma += total.subTotal();
        }
        return soma;
   }

}
