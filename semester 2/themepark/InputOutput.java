import java.io.*;
import java.util.*;
import javax.swing.*;

public class InputOutput {

    public static void main(String args[]) throws IOException {
        try {
            FileReader fr = new FileReader("READFILE.txt");
            BufferedReader br = new BufferedReader(fr);

            Customer[] cust = new Customer[1];
            Ticket tix[] = new Ticket[1];
            int count = 0;
            StringTokenizer st = null;
            String dataRow = br.readLine(); // Read one line of data

            while (dataRow != null) {
                st = new StringTokenizer(dataRow, "*");

                // Assuming the data is in the same format as provided earlier
                String input = st.nextToken();// Read the first token as input
                
                String name = st.nextToken();
                char nationality = st.nextToken().charAt(0);
                double height = Double.parseDouble(st.nextToken());
                int age = Integer.parseInt(st.nextToken());
                String noPhone = st.nextToken();

                cust[count] = new Customer(name, nationality, height, age, noPhone);// Store info
                
                String id = st.nextToken();
                String rides = st.nextToken();
                String date = st.nextToken();
                int qty = Integer.parseInt(st.nextToken());
                char type = st.nextToken().charAt(0);
                
                tix[count] = new Ticket(id,rides,date,qty,type,cust[0]);//store info
                
                input = JOptionPane.showInputDialog(null, "Enter [C] to continue, [E] to exit : ", "Continue/Exit", JOptionPane.INFORMATION_MESSAGE);

        if(input.equalsIgnoreCase("C"))
        {
            for(int i=0;i<1;i++){
                System.out.println("\n========================================");
                System.out.println("  Customer's Information                ");
                System.out.println("========================================");
                System.out.println(cust[i].toString());
                System.out.println("========================================");
            }
            
            JOptionPane.showMessageDialog(null,"Enter your information carefully!"); 

            //count ticket
            int express = 0, standard = 0;
            for(int i=0; i<tix.length; i++)
            {
                if(tix[i].getType() == 'E' || tix[i].getType() == 'e')
                    System.out.println("Number of tickets for Express Ticket that has been sold is : " + (express += tix[i].qty));
                else if(tix[i].getType() == 'S' || tix[i].getType() == 's')
                    System.out.println("Number of tickets for Standard Ticket that has been sold is : " + (standard += tix[i].qty));
            }
            
            
            //update rides
            for(int p=0; p<tix.length; p++)
            {
                if(tix[p].getRides().equalsIgnoreCase("RC"))
                {
                    tix[p].setRides("BC");
                }
            }
            System.out.println("\nRoller Coaster is currently unavailable due to weather circumstances. More slots for Bumper Car has been opened!");
            
            //searching rides
            int idxFound = 0;
            boolean found = false;
            for (int i=0; i<tix.length; i++)
            {
                if(tix[i].getRides().equalsIgnoreCase("TC") || tix[i].getRides().equalsIgnoreCase("RC") || tix[i].getRides().equalsIgnoreCase("BC"))
                {
                   idxFound = i; 
                   found = true;
                   break;
                }
                
            }
            if (found == true)
                System.out.println("\nTeacups is one of the rides in our theme park");
            else
                System.out.println("\nRides not available!");
            
                
            for(int i=0;i<tix.length;i++)
            {
                System.out.println("========================================");
                System.out.println("  Ticket's Information                  ");
                System.out.println("========================================");
                System.out.println(tix[i].toString());
                System.out.println("=============================================================");
                System.out.println("The final ticket price has appeared in -->Purchase Report<-- ");
                System.out.println("=============================================================");
            }
            
            double totalTicket = 0.0;
            for(int m=0; m<tix.length; m++)
            {
                if(cust[m].getHeight() < 100 && cust[m].getHeight() == 100)
                {
                    totalTicket = 0.0;
                    System.out.println("Ticket is free for height 100m and below");
                }
                else if(cust[m].getHeight()>100)
                {
                    totalTicket += tix[m].calculateTypeTicket();
                }
            }
            
            double totalAfterDiscount = 0.0;
            double discp[] = new double[tix.length];
            for(int j = 0; j < tix.length; j++)
            {
                double discount = 0.05;
                if(cust[j].getNationality()=='M')
                {
                 discp[j]=tix[j].calculateTicket(discount);
                 
                 FileWriter fw=new FileWriter("PurchaseReport.txt");
                 BufferedWriter bw=new BufferedWriter(fw);
                 PrintWriter pw=new PrintWriter(bw);
            
                 pw.println("=============================================");
                 pw.println("           ! CUSTOMER INFO !                 ");
                 pw.println("=============================================");
                 pw.println(cust[j].toString());
                 pw.println("=============================================");
                 pw.println(tix[j].toString());
                 pw.println("=============================================");
                 pw.println("The discount is : " + discp[j]); 
                 pw.println("\nTotal Price Ticket After Discount is : RM " + tix[j].calculateTypeTicket(discp[j]));
                 pw.println("=============================================");
                 pw.close(); 
                }
                else
                {
                 FileWriter fw=new FileWriter("PurchaseReport.txt");
                 BufferedWriter bw=new BufferedWriter(fw);
                 PrintWriter pw=new PrintWriter(bw);
                 
                 pw.println("=============================================");
                 pw.println("           ! CUSTOMER INFO !                 ");
                 pw.println("=============================================");
                 pw.println(cust[j].toString());
                 pw.println("=============================================");
                 pw.println(tix[j].toString());
                 pw.println("=============================================");
                 pw.println("\nTotal Price Ticket : RM " + tix[j].calculateTypeTicket()); 
                 pw.println("=============================================");
                 pw.close(); 
                }
            }
            
            //PAYMENT----------
            String proceed = JOptionPane.showInputDialog(null, "\nDo you want to proceed payment? Enter [Y] to continue, [X] to exit : ", "Payment", JOptionPane.INFORMATION_MESSAGE);
                
            for(int j=0; j<1; j++)
            {
                if ((proceed.equalsIgnoreCase("Y")) && ( cust[j].getNationality() == 'M' || cust[j].getNationality() == 'm'))
                {
                    System.out.println("==================================");
                    System.out.println("  PAYMENT METHOD                  ");
                    System.out.println("==================================");
                    System.out.println("[A] CASH                          ");
                    System.out.println("[B] CREDIT CARD                  ");
                    System.out.println("==================================");
                    System.out.println("\nEnter the payment type : ");
                    char paymentType = st.nextToken().charAt(0);
                    
                    if(paymentType == 'B'|| paymentType == 'b')
                    {
                        System.out.println("Your final amount : RM " + tix[j].calculateTypeTicket(discp[j]) );
                        System.out.println("Price per Ticket : RM " + (tix[j].calculateTypeTicket(discp[j]) / tix[j].qty ));
                        System.out.println("Enter the payment amount : RM ");
                        double paymentAmount = Double.parseDouble(st.nextToken());
                        while( paymentAmount < tix[j].calculateTypeTicket(discp[j]))
                        {
                            System.out.println("Low balance, please enter new amount!");
                            paymentAmount = Double.parseDouble(st.nextToken());
                        }
                        System.out.println("Transaction completed! ");
                        JOptionPane.showMessageDialog(null,"Thank you for using our system"); 
                    }
                    else if(paymentType == 'A'|| paymentType == 'a')
                    {
                        System.out.println("Your final amount : RM " + tix[j].calculateTypeTicket(discp[j]) );
                        System.out.println("Price per Ticket : RM " + (tix[j].calculateTypeTicket(discp[j]) / tix[j].qty ));
                        System.out.println("Enter the payment amount : RM ");
                        double paymentAmount = Double.parseDouble(st.nextToken());
                        while( paymentAmount < tix[j].calculateTypeTicket(discp[j]))
                        {
                            System.out.println("Low balance, please enter new amount!");
                            paymentAmount = Double.parseDouble(st.nextToken());
                        }
                        System.out.println("Payment Successful!");
                        JOptionPane.showMessageDialog(null,"Thank you for using our system"); 
                    }
                }
                else if ((proceed.equalsIgnoreCase("Y")) && ( cust[j].getNationality() == 'N' || cust[j].getNationality() == 'n'))
                {

                    System.out.println("==================================");
                    System.out.println("  PAYMENT METHOD                  ");
                    System.out.println("==================================");
                    System.out.println("[A] CASH                          ");
                    System.out.println("[B] CREDIT CARD                  ");
                    System.out.println("==================================");
                    System.out.println("\nEnter the payment type : ");
                    char paymentType = st.nextToken().charAt(0);
                    
                    if(paymentType == 'B'|| paymentType == 'b')
                    {
                        System.out.println("Your final amount : RM " + tix[j].calculateTypeTicket() );
                        System.out.println("Price per Ticket : RM " + (tix[j].calculateTypeTicket() / tix[j].qty ));
                        System.out.println("Enter the payment amount : RM ");
                        double paymentAmount = Double.parseDouble(st.nextToken());
                        while( paymentAmount < tix[j].calculateTypeTicket())
                        {
                            System.out.println("Low balance, please enter new amount!");
                            paymentAmount = Double.parseDouble(st.nextToken());
                        }
                        System.out.println("Transaction completed! ");
                        JOptionPane.showMessageDialog(null,"Thank you for using our system"); 
                    }
                    else if(paymentType == 'A'|| paymentType == 'a')
                    {
                        System.out.println("Your final amount : RM " + tix[j].calculateTypeTicket() );
                        System.out.println("Price per Ticket : RM " + (tix[j].calculateTypeTicket() / tix[j].qty ));
                        System.out.println("Enter the payment amount : RM ");
                        double paymentAmount = Double.parseDouble(st.nextToken());
                        while( paymentAmount < tix[j].calculateTypeTicket())
                        {
                            System.out.println("Low balance, please enter new amount!");
                            paymentAmount = Double.parseDouble(st.nextToken());
                        }
                        System.out.println("Payment Successful!");
                        JOptionPane.showMessageDialog(null,"Thank you for using our system"); 
                    }
                }
                else
                {
                    System.out.println("Ticket purchase unsuccessful."); //delete ticket order
                    JOptionPane.showMessageDialog(null,"Thank you for using our system"); 
                }
            }
        }
        dataRow = br.readLine(); // Read the next line of data
        } count++;
        br.close();
       
        
        } catch (EOFException eof) {
            System.out.println("Problem: " + eof.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println("Problem: " + e.getMessage());
        } catch (IOException ioe) {
            System.out.println("Problem: " + ioe.getMessage());
        } finally {
            System.out.println("The Data has been turned in.\n");
            System.out.println(" ｡･:*:･ﾟ★,｡･:*:･ﾟ☆ THANK YOU FOR USING THE SYSTEM ｡･:*:･ﾟ★,｡･:*:･ﾟ☆ ");
            System.out.println("============ PROGRAM END ============");
        }
    }
}