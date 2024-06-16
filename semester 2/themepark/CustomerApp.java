import java.util.*;
import java.io.*;
import javax.swing.*;

public class CustomerApp
{
    public static void main (String[] args) throws IOException
    {
        Scanner in = new Scanner(System.in);
        Scanner inline = new Scanner(System.in);
        Scanner huruf = new Scanner(System.in);
        
        System.out.println("===============================================================================");
        System.out.println("| ｡･:*:･ﾟ★,｡･:*:･ﾟ☆ WELCOME TO GENTING QOROWORLD THEME PARK ｡･:*:･ﾟ★,｡･:*:･ﾟ☆ |");
        System.out.println("===============================================================================");
        
        System.out.println("============================================="); 
        System.out.println("|      TICKETS      |   CODE  |    PRICE    |");
        System.out.println("|===========================================|");
        System.out.println("|      EXPRESS      |    E    |    RM 150   |");
        System.out.println("|      STANDARD     |    S    |    RM 100   |");
        System.out.println("|-------------------------------------------|");
        System.out.println("|      ENJOY 5% DISCOUNT FOR MALAYSIAN      |");
        System.out.println("=============================================");
        
        System.out.println("===================================");
        System.out.println("|     RIDES            |   CODE   |");
        System.out.println("===================================");
        System.out.println("|     TEACUPS          |    TC    |");
        System.out.println("|     ROLLER COASTER   |    RC    |");
        System.out.println("|     BUMPER CAR       |    BC    |");
        System.out.println("===================================");
        
        String input = JOptionPane.showInputDialog(null, "Enter [C] to continue, [E] to exit : ", "Continue/Exit", JOptionPane.INFORMATION_MESSAGE);

        if(input.equalsIgnoreCase("C"))
        {
            /*****************
                 Customer 
            *******************/
        
            Customer cust[] = new Customer[1];  
            
            //INFO FOR CUSTOMER---------------------------------------------
            
            for(int i=0;i<1;i++)
            {
                System.out.println("\nName:");
                String name = inline.nextLine();
            
                System.out.println("Nationality [M] Malaysian [N] Non-Malaysian:");
                char nationality = huruf.next().charAt(0);
                
                if (nationality == 'N')
                {
                    System.out.println("Enter country :");
                    String country = inline.nextLine();
                }
            
                System.out.println("Height [cm]:");
                double height = in.nextDouble();
            
                System.out.println("Age:");
                int age = in.nextInt();
            
                System.out.println("Phone Number [ex:0116584934]:");
                String noPhone = inline.nextLine();
                
                cust[i] = new Customer(name,nationality,height,age,noPhone);
            }
         
            for(int i=0;i<1;i++){
                System.out.println("\n========================================");
                System.out.println("  Customer's Information                ");
                System.out.println("========================================");
                System.out.println(cust[i].toString());
                System.out.println("========================================");
            }
            
            /*****************
                 Ticket
            ******************/
            
            JOptionPane.showMessageDialog(null,"Enter your information carefully!"); 
            int tick = 1 ;   
            
            Ticket tix[] = new Ticket[tick];
            
            //INFO FOR TICKETS --------------------
            
            for(int j = 0; j < tix.length; j ++)
            {
                System.out.println("ID Ticket:");
                String id = inline.nextLine();
            
                System.out.println("Rides [TC/RC/BC]:");
                String rides = inline.nextLine();
            
                System.out.println("Date [DD/MM/YYYY]:");
                String date = inline.nextLine();
            
                System.out.println("Ticket Quantity(ies): ");
                int qty = in.nextInt();
                
                System.out.println("Type of Ticket(s) [E/S]: ");
                char type = huruf.next().charAt(0);
                
                tix[j] = new Ticket(id,rides,date,qty,type,cust[0]);
            }
            
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
                    char paymentType = in.next().charAt(0);
                    
                    if(paymentType == 'B'|| paymentType == 'b')
                    {
                        System.out.println("Your final amount : RM " + tix[j].calculateTypeTicket(discp[j]) );
                        System.out.println("Price per Ticket : RM " + (tix[j].calculateTypeTicket(discp[j]) / tix[j].qty ));
                        System.out.println("Enter the payment amount : RM ");
                        double paymentAmount = in.nextDouble();
                        while( paymentAmount < tix[j].calculateTypeTicket(discp[j]))
                        {
                            System.out.println("Low balance, please enter new amount!");
                            paymentAmount = in.nextDouble();
                        }
                        System.out.println("Transaction completed! ");
                        JOptionPane.showMessageDialog(null,"Thank you for using our system"); 
                    }
                    else if(paymentType == 'A'|| paymentType == 'a')
                    {
                        System.out.println("Your final amount : RM " + tix[j].calculateTypeTicket(discp[j]) );
                        System.out.println("Price per Ticket : RM " + (tix[j].calculateTypeTicket(discp[j]) / tix[j].qty ));
                        System.out.println("Enter the payment amount : RM ");
                        double paymentAmount = in.nextDouble();
                        while( paymentAmount < tix[j].calculateTypeTicket(discp[j]))
                        {
                            System.out.println("Low balance, please enter new amount!");
                            paymentAmount = in.nextDouble();
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
                    char paymentType = in.next().charAt(0);
                    
                    if(paymentType == 'B'|| paymentType == 'b')
                    {
                        System.out.println("Your final amount : RM " + tix[j].calculateTypeTicket() );
                        System.out.println("Price per Ticket : RM " + (tix[j].calculateTypeTicket() / tix[j].qty ));
                        System.out.println("Enter the payment amount : RM ");
                        double paymentAmount = in.nextDouble();
                        while( paymentAmount < tix[j].calculateTypeTicket())
                        {
                            System.out.println("Low balance, please enter new amount!");
                            paymentAmount = in.nextDouble();
                        }
                        System.out.println("Transaction completed! ");
                        JOptionPane.showMessageDialog(null,"Thank you for using our system"); 
                    }
                    else if(paymentType == 'A'|| paymentType == 'a')
                    {
                        System.out.println("Your final amount : RM " + tix[j].calculateTypeTicket() );
                        System.out.println("Price per Ticket : RM " + (tix[j].calculateTypeTicket() / tix[j].qty ));
                        System.out.println("Enter the payment amount : RM ");
                        double paymentAmount = in.nextDouble();
                        while( paymentAmount < tix[j].calculateTypeTicket())
                        {
                            System.out.println("Low balance, please enter new amount!");
                            paymentAmount = in.nextDouble();
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
        
        else
        {
             JOptionPane.showMessageDialog(null,"Thank you for using our system"); 
        }
    }
}