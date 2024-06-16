import java.util.*;
import java.io.*;
import java.io.IOException;
public class MedicineLinkedList
{
    public static void main(String args[]) {
        try{
            Medicine[] med = new Medicine[23];
        
            Scanner input = new Scanner(System.in);
            System.out.println("-----------------------------------------------------------------");
            System.out.println("                    Welcome to Big Pharmacy                       ");
            System.out.println("-----------------------------------------------------------------");
            
            displayRecord(med);
        }  catch (Exception e){
            
        }
    }
    
    public static void readFile(Medicine[] med) throws Exception {
        try {
            BufferedReader br = new BufferedReader(new FileReader("InputMedicine.txt"));
            int i = 0;

            String dataRow;
            while ((dataRow = br.readLine()) != null) {
                StringTokenizer parse = new StringTokenizer(dataRow, ";");
                String custID = parse.nextToken();
                String custName = parse.nextToken();
                String phoneNo = parse.nextToken();
                int age = Integer.parseInt(parse.nextToken());
                String memberStatus = parse.nextToken();
                String medID = parse.nextToken();
                String medName = parse.nextToken();
                int medQty = Integer.parseInt(parse.nextToken());
                double medPrice = Double.parseDouble(parse.nextToken());
                char medType =  parse.nextToken().charAt(0);

                med[i] = new Medicine(custID, custName, phoneNo, age, memberStatus, medID, medName, medQty, medPrice, medType);
                i ++;
            }
            int count = i;
            br.close();
        } catch (Exception e) {
            
        }
    }
    
    public static void displayRecord(Medicine[] med) throws Exception{
        try{
            readFile(med);
            System.out.println("\nDetails of all the customer: ");
            for (int x = 0; x < 24; x++){
                System.out.println(med[x].toString());
            }
        } 
        
        catch (Exception e){
        }
    }
}