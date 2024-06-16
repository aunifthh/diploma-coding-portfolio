public class Customer
{
    protected String name;
    protected char nationality;
    protected double height;
    protected int age;
    protected String noPhone;
    
    //Default Constructor
    public Customer()
    {
        name = null;
        nationality = 'x';
        height = 0.0;
        age = 0;
        noPhone = null;
    }
    
    //Normal Constructor
    public Customer(String n, char nt, double h, int a, String p)
    {
        name = n;
        nationality = nt;
        height = h;
        age = a;
        noPhone = p;
    }
    
    //Mutator all data members
    public void setCustomer(String n, char nt, double h, int a, String p)
    {
        name = n;
        nationality = nt;
        height = h;
        age = a;
        noPhone = p;
    }
    
    //Mutator each data members
    public void setName(String n)
    {
        name = n;
    }
    public void setNationality(char nt)
    {
        nationality = nt;
    }
    public void setHeight(double h)
    {
        height = h;
    }
    public void setAge(int a)
    {
        age = a;
    }
    public void setNoPhone(String p)
    {
        noPhone = p;
    }
    
    //Accessor
    public String getName()
    {
        return name;
    }
    public char getNationality()
    {
        return nationality;
    }
    public double getHeight()
    {
        return height;
    }
    public int getAge()
    {
        return age;
    }
    public String getNoPhone()
    {
        return noPhone;
    }
    
    //toString() method
    public String toString()
    {
        return("\nCustomer's name:"+ name +"\nCustomer's nationality:"+ nationality +"\nCustomer's height:"+ height +"\nCustomer's age:"+ age +"\nCustomer's phone number:"+ noPhone);
    }
    
    
}