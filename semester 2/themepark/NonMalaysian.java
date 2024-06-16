public class NonMalaysian extends Customer
{
    private String country;
    
    public NonMalaysian(String n, char t, double h, int a, String p, String c)
    {
        super(n,t,h,a,p);
        country = c;
    }
    
    public void setNonMalaysian(String n, char t, double h, int a, String p, String c)
    {
        super.setCustomer(n,t,h,a,p);
        country = c;
    }
    
    public void setCountry(String c)
    {
        country = c;
    }
    
    public String getCountry()
    {
        return country;
    }
    
    public String toString()
    {
        return(super.toString() + "\nCountry: " + country);
    }

}