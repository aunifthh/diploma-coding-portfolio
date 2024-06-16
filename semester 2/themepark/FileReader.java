import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {
    public static Customer readCustomerFromFile(String filename) throws FileNotFoundException {
        Customer cust = null;
        try {
            Scanner inputFile = new Scanner(new File(filename));
            String name = inputFile.nextLine();
            char nationality = inputFile.next().charAt(0);
            double height = inputFile.nextDouble();
            int age = inputFile.nextInt();
            String noPhone = inputFile.nextLine().trim();
            
            cust = new Customer(name, nationality, height, age, noPhone);
            
            inputFile.close();
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File not found: " + e.getMessage());
        }
        return cust;
    }
    
    public static Ticket readTicketFromFile(String filename, Customer customer) throws FileNotFoundException {
        Ticket ticket = null;
        try {
            Scanner inputFile = new Scanner(new File(filename));
            inputFile.nextLine(); // Skip the customer info, as it is already provided
            
            String id = inputFile.nextLine();
            String rides = inputFile.nextLine().trim();
            String date = inputFile.nextLine().trim();
            int qty = inputFile.nextInt();
            char type = inputFile.next().charAt(0);
            
            ticket = new Ticket(id, rides, date, qty, type, customer);
            
            inputFile.close();
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File not found: " + e.getMessage());
        }
        return ticket;
    }
}
