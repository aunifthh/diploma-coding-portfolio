public class Malaysian extends Customer
{
    private String IC;
    private String Customer;
    //constructor
    public Malaysian(String n, char t, double h, int a, String p, String i, String cust)
    {
        super(n,t,h,a,p);
        IC = i;
        Customer = cust;
        
    }
   //
   public void setMalaysian(String n, char t, double h, int a, String p, String i, String cust)
   {
       super.setCustomer(n,t,h,a,p);
       IC = i;
       Customer = cust;
   }
   
   public String getIC(String i)
   {
       return IC;
   }
   public String getCustomer(String cust)
   {
       return Customer;
   }
   
   public String toString()
   {
       return(super.toString() + "\nIC: " );
   }
}