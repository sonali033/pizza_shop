
package PizzaShop;



public class Customer 
{
  final private String customerName;
  final private String address;
    
    Customer(String name, String address) {
        customerName = name; 
        this.address = address;
    }
    
    public String getName()
    {
        return customerName;
    }  
    
     public String getaddress()
    {
        return address;
    }  
}


