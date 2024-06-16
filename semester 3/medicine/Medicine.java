public class Medicine{
    private String custID;
    private String custName;
    private String phoneNo;
    private int age;
    private String memberStatus;
    private String medID;
    private String medName;
    private int medQty;
    private double medPrice;
    private char medType;
    
    public Medicine(String id, String name, String p, int a, String s, String mID, String mName, int q, double price, char t){
        custID = id;
        custName = name;
        phoneNo = p;
        age = a;
        memberStatus = s;
        medID = mID;
        medName = mName;
        medQty = q;
        medPrice = price;
        medType = t;
    }
    
    public void setCustID(String id){custID = id;}
    public void setCustName(String name){custName = name;}
    public void setPhoneNo(String p){phoneNo = p;}
    public void setAge(int a){age = a;}
    public void setMemberStatus(String s){memberStatus = s;}
    public void setMedID(String mID){medID = mID;}
    public void setMedName(String mName){medName = mName;}
    public void setMedQty (int q){medQty = q;}
    public void setMedPrice(double price){medPrice = price;}
    public void setMedType(char t){medType = t;}
    
    public String getCustID(){return custID;}
    public String getCustName() {return custName;}
    public String getPhoneNo(){return phoneNo;}
    public int getAge(){return age;}
    public String getMemberStatus(){return memberStatus;}
    public String getMedID(){return medID;}
    public String getMedName(){return medName;}
    public int getMedQty(){return medQty;}
    public double getMedPrice(){return medPrice;}
    public char getMedType(){return medType;}
    
    public String toString(){
        return "\nCustomer ID: " + custID + "\n" + 
               "Customer Name: " + custName + "\n" +
               "Phone No: " + phoneNo + "\n" +
               "Age : " + age + "\n" +
               "Member Status: " + memberStatus + "\n" +
               "Medcine ID: " + medID + "\n" +
               "Medicine Name: " + medName + "\n" +
               "Medicine Quantity: " + medQty + "\n" +
               "Medicine Price: " + medPrice + "\n" +
               "Meicine Type: " + medType ;
    }
    
    public double calculateTotalPrice(){
        double total = getMedQty() * getMedPrice();
        return total;
    }
}