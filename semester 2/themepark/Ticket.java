public class Ticket
{
    protected String id;
    protected String rides;
    protected String date;
    protected int qty;
    protected char type;
    protected Customer cust;
    
    //default constructor
    public Ticket()
    {
        id = null;
        rides = null;
        date = null;
        qty = 0;
        type = 'X';
        cust = new Customer();
    }
    
    //normal constructor
    public Ticket(String i, String r, String d, int q, char t, Customer c)
    {
        id = i;
        rides = r;
        date = d;
        qty = q;
        type = t;
        cust = c;
    }
    
    //mutator
    public void setTicket(String i, String r, String d, int q, char t, Customer c)
    {
        id = i;
        rides = r;
        date = d;
        qty = q;
        type = t;
        cust = c;
    }
    
    public void setId(String i)
    {
        id = i;
    }
    public void setRides(String r)
    {
        rides = r;
    }
    public void setDate(String d)
    {
        date = d;
    }
    public void setQty(int q)
    {
        qty = q;
    }
    public void setType(char t)
    {
        type = t;
    }
    public void setCustomer(Customer c)
    {
        cust = c;
    }
    
    //accessor
    public String getId()
    {
        return id;
    }
    public String getRides()
    {
        return rides;
    }
    public String getDate()
    {
        return date;
    }
    public int getQty()
    {
        return qty;
    }
    public char getType()
    {
        return type;
    }
    public Customer getCust()
    {
        return cust;
    }
    
    //toString method
    public String toString()
    {
        return("ID:"+ id +"\nRides:"+ rides +"\nDate:"+ date + "\nQuantity:"+ qty + "\nType of ticket :" + type +"\nCustomer Info:" + cust.toString());
    }
    
    //processor
    double total = 0.0;
    public double calculateTypeTicket()
    {
        if(type == 'E' || type == 'e')
            total = 150*qty;
        else if(type == 'S' || type == 's')
            total = 100*qty;
        return total;
    }
    
    public double calculateTypeTicket(double discount)
    {
        if(type == 'E' || type == 'e')
            total = (150*qty)-((150*qty)*discount);
        else if(type == 'S' || type == 's')
            total = (100*qty)-((100*qty)*discount);;
        return total;
    }
    
    public double calculateTicket(double discount)
    {
        
        if(cust.getNationality()=='M' )
        {
             discount=0.05;
            return discount;
        }
        else
            return 0.0;
        
    }
    
    public void displayRidesName()
    {
        if(rides.equalsIgnoreCase("TC"))
            System.out.println("Teacups");
        else if(rides.equalsIgnoreCase("RC"))
            System.out.println("Roller Coaster");
        else if(rides.equalsIgnoreCase("BC"))
            System.out.println("Bumper Car");
    }
}