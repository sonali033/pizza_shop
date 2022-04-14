
package PizzaShop;

import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;


public class Order 
{
    
    // DateTime todayDate
    private int totalBill;
    private Customer customer;
    LocalDateTime orderDateTime;
    final int VEG_LARGE_COST = 600;
    final int VEG_MEDIUM_COST = 400;
    final int VEG_SMALL_COST = 200;
    final int nonVEG_LARGE_COST = 650;
    final int nonVEG_MEDIUM_COST = 450;
    final int nonVEG_SMALL_COST = 250;
    final int COST_PER_TOPPING = 25; 
    private final ArrayList<Pizza>listOfPizza;
   
    
   public Order(ArrayList<Pizza>listOfPizza, Customer customer)
   {
       this.listOfPizza = listOfPizza; 
       //customerName = name;
       this.customer =customer;
       orderDateTime = LocalDateTime.now();
   }
   
   public int getTotalOrderCost() {
       calculateTotalBill();
        return totalBill;
    }
    
 private void calculateTotalBill()
   {
        
        
        for(Pizza p:listOfPizza)
        {
            if(p.getCategory()=="VEG")
            {
                switch(p.getSize())
                {
                    case "Large":
                        totalBill += VEG_LARGE_COST;
                        break;
                    case "Medium":
                        totalBill += VEG_MEDIUM_COST;
                        break;
                    case "Small":
                         totalBill += VEG_SMALL_COST;
                         break;
                    default:
                        totalBill +=0.0;
                        break;
                }
            }
            else
            {
                switch(p.getSize())
                {
                    case "Large":
                        totalBill += nonVEG_LARGE_COST;
                        break;
                    case "Medium":
                        totalBill += nonVEG_MEDIUM_COST;
                        break;
                    case "Small":
                         totalBill += nonVEG_SMALL_COST;
                         break;
                    default:
                        totalBill +=0.0;
                        break;
                }
                
            }   
                
             int total_toppings = p.getToppings().size();
             
             totalBill += total_toppings*COST_PER_TOPPING;
        
     }
   }  
    
    
    public void Details()
   {
       //DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
       
       DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");
       String formattedDate = orderDateTime.format(myFormatObj);
       String name = customer.getName();
       System.out.println(name + " Has ordred.");
       
       System.out.println(listOfPizza.size());
       
       for(Pizza p: listOfPizza)
       {
          System.out.print(p.getCategory() + " " + p.getSize()+ " pizza ");
          
          ArrayList<String>extraToppings = p.getToppings();
          
          if(extraToppings.size() > 0) System.out.println(" with toppings.");
          
          for(String top:extraToppings)
          {
              System.out.println(top);
          }  
       }
          
           System.out.println("with total bill: " + totalBill);
           System.out.println("On "+ formattedDate);
       
    }
    
   
     
    public LocalDateTime getOrderDateTime()
    {
        return orderDateTime;
    }
    
    public String getDate()
    {
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");
       String formattedDate = orderDateTime.format(myFormatObj);
       return formattedDate;
    }
    
}
