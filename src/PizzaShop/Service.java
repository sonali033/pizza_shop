

package PizzaShop;

import java.util.ArrayList;
import java.util.Scanner;


public class Service 
{
    private void showToppings()
    {
        System.out.println("1.Olive\n2.Onion\n3.Tomatoes\n4.Pineapple\n5.Extra cheese\n");   
    }
    
    public Order placeOrder()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your good name: ");
        String name = sc.next();
        System.out.println("Please enter your address: ");
        String address = sc.next();
        Customer customer=new Customer(name,address);
       
        System.out.println("Enter the total pizzas you would like to order: ");
        int totalPizzas = sc.nextInt();
        ArrayList<Pizza> pizzas = new ArrayList<>();
        for(int i=0; i<totalPizzas; i++)
        {
             //Pizza pizza = new Pizza();
             Pizza pizza;
             ArrayList<String> toppings = new ArrayList<>();
             System.out.printf("Please select %d pizza\n",i+1);
             System.out.println("Please choose the category");
             System.out.println("1.VEG\n2.NON-VEG\n");
             int cat = sc.nextInt();
             while(cat<1 || cat>2) 
             { System.out.println("Please enter valid input"); cat = sc.nextInt();}
             System.out.println("Please select the size of the pizza");
             System.out.println("1.SMALL\n2.MEDIUM\n3.LARGE\n");
             int size=sc.nextInt();
             String size_of_pizza=null;
             switch(size)
             {
                 case 1: size_of_pizza = "Small";
                         break;
                 case 2: size_of_pizza = "Medium";
                         break;
                 case 3: size_of_pizza = "Large";
                         break;
                 
             }
                 
             if(cat==1) 
             {
                  pizza = new Pizza("VEG", size_of_pizza);
             }
             else        
             {
                  pizza = new Pizza("NON-VEG", size_of_pizza); 
             }
             
             System.out.println("Would you like to have extra toppings(Each extra topping will cost 25rs): ");
             System.out.println("1.YES\n2.NO\n");
             int wish = sc.nextInt();
             
             if (wish == 1) {
                showToppings();
                System.out.println("Enter number of Extra toppings: ");
                int noOfToppings = sc.nextInt();

                for (int j = 0; j < noOfToppings; j++) {
                    System.out.println("Choose topping: ");
                    showToppings();
                    int choice = sc.nextInt();

                    switch (choice) {
                        case 1:
                            toppings.add("Olive");
                            break;
                        case 2:
                            toppings.add("Onion");
                            break;
                        case 3:
                            toppings.add("Tomatoes");
                            break;
                        case 4:
                            toppings.add("Pineapple");
                            break;
                        case 5:
                            toppings.add("Extra cheese");
                            break;
                    }
                }
            }
            
             pizza.setToppings(toppings);
             
             pizzas.add(pizza);
        }
        
        Order order = new Order(pizzas,customer);
        int finalBill = order.getTotalOrderCost();
        System.out.println("YOUR FINAL BILL IS: " + finalBill);
        System.out.println("Do you want to place order: ");
        System.out.println("1.YES\n2.NO\n");
        int confirmation = sc.nextInt();
        if(confirmation==1)
        {
            System.out.println("Your order placed successfully!!");
            return order;
        }
        else
        {
            System.out.println("Your order is cancelled"); return null;
        }
            
           
        
         
    }
}
