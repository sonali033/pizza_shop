
package PizzaShop;

import java.util.*;


public class OrderList 
{
    private static ArrayList<Order> orders = new ArrayList<>();
    public static void addOrder(Order order)
    {
        orders.add(order);
    }
    public static ArrayList<Order> getOrders(){ return orders;}
}
