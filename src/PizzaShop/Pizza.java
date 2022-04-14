
package PizzaShop;

import java.util.*;


public class Pizza 
{
   private String category;
   private  String size;
   private ArrayList<String>toppings;
    
   public Pizza(String category, String size)
   {
       this.category=category;
       this.size = size;
   }
   public void setToppings(ArrayList<String>toppings)
   {
       this.toppings=toppings;
   }
   
   public String getSize() {return size;}
   
   public String getCategory() {return category;}
   
   public ArrayList<String>getToppings(){ return toppings;}
   
   
    
}
