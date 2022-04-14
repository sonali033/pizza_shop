
package PizzaShop; 

import java.util.*;

                                                           
public class Shop {

    public static void show()
    {
        System.out.print("******************************");
        System.out.print("  WELCOME TO MOM'S PIZZATERIA  ");
        System.out.println("****************************");
        System.out.println("Please select one option");
        System.out.println("1.Show Menu Card\n2.Place Order\n3.Display order details\n4.Exit");   
    }
    
    public static void menu()
    {
        System.out.println("PIZZA                    PRICE ");
        System.out.println("VEG LARGE PIZZA          600");
        System.out.println("VEG MEDIUM PIZZA         400");
        System.out.println("VEG SMALL PIZZA          200");
        System.out.println("NON-VEG LARGE PIZZA      650");
        System.out.println("NON-VEG MEDIUM PIZZA     450");
        System.out.println("NON-VEG SMALL PIZZA      250");
        
    }
    
    public static ArrayList<Order> search()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the date in dd/mm/yyyy format");
        String date=sc.next().trim();
        System.out.println(date);
        ArrayList<Order>orders=OrderList.getOrders();
        orders.stream().allMatch(order ->date.equals(order.getDate()));
        //
        return orders;
    }
  
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        Service service= new Service();
        Order order = null;
        
        while(true)
        {
            show();
            int option=sc.nextInt();
           
            switch(option)
            {
                case 1: menu();
                        break;
                case 2: 
                        order = service.placeOrder();
                        if(order != null){
                            OrderList.addOrder(order);
                        }
                        break;
                case 3: if(order==null) System.out.println("You did not place any order "); 
                         else order.Details();
                          break;
//                case 4:ArrayList<Order>orders= search();
//                       for(Order o : orders)
//                       {
//                           o.Details();
//                       }
//                       break; 
                 
                default : System.out.println("Please enter valid input");
            }
            
            if(option==4) break;
        }  
    }    
}

