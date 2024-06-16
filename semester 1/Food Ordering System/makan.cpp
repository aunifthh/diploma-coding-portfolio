#include<iostream>
#include<conio.h>
#include <stdlib.h>
#include <unistd.h>


using namespace std;

void customerPage();
void adminLogin();
void adminHomePage();
void mainPage();
void serviceType();
void paymentType();
double calcTotal(double,int);
void delivery();
void creditCard();


//global variable -------------------------------------
double totalSales = 0, average = 0, total = 0;
int count = 0;
int qty;


int main(){
	mainPage();
	system("cls");
	cout<<"Program terminated permanently" << endl;
	cout<<"\nThank you For Ordering From MAKAN MAKAN food\n";
	return 0;
}

void mainPage(){
	char option;
    
    system("cls");
	cout<<"\t\t\t|-------------------------------------------------------|\n";
	cout<<"\t\t\t|              MAKAN MAKAN  Food Ordering System        |\n";
	cout<<"\t\t\t|-------------------------------------------------------|\n\n";
    cout <<endl;
    cout << "DO YOU WANT TO LOGIN AS :" << endl;
    cout << "[A] ADMIN"<<endl;
	cout << "[C] CUSTOMER" << endl;
    cout << "\nPress [A] or [C] : ";
    cin >> option;
    
    if (option == 'A' || option == 'a'){
        adminLogin();
    }
    else if (option == 'C' || option == 'c'){
        customerPage();
    }
    else {
		cout<<"Program terminated permanently" << endl;
   		cout<<"\nThank you For Ordering From MAKAN MAKAN food\n";
   	}
}

void adminLogin(){
	string username, password;
    int attempts=0;
    int remainder=3;
    int code;
    
    system("cls");
	cout<<"\t\t\t|-------------------------------------------------------|\n";
	cout<<"\t\t\t|                   Admin Login Page                    |\n";
	cout<<"\t\t\t|-------------------------------------------------------|\n\n";
    
    do{
		cout << "Enter username : ";
	    cin >> username;
	    cout << "Enter password : ";
	    cin >> password;
    
    	if (username == "makan" && password == "makan")
        	adminHomePage();
        
	    else {
		    cout << "--------------------------------------------------" << endl;
			cout << "|  Your username and password are not matched !  |"<< endl;
		    cout << "--------------------------------------------------" << endl;
		    cout << endl;
		    cout << "---------------------------------------" << endl;
		    cout << "| You have "<< remainder << " more attempt(s) to login |" << endl;
		    cout << "---------------------------------------" << endl;
	    
		    sleep(2);
			system("cls");
		    attempts++;
			remainder--;
			}

    } while (attempts<=3);
    mainPage();
}
    
void adminHomePage(){
	int code;

    system("cls");
    
    a:
    cout<<"\t\t\t|-------------------------------------------------------|\n";
	cout<<"\t\t\t|                    Admin Home Page                    |\n";
	cout<<"\t\t\t|-------------------------------------------------------|\n\n";
    
    cout << "[1] Total Sales" << endl;
    cout << "[2] Average Sales" << endl;
    cout << "[3] Back to Main Page" << endl;

    
    cout << "Enter code : ";
    cin >> code;
    
    if (code == 1){
        system("cls");
		cout << "The total sales is : RM " << totalSales << endl;
	   	cout << "Press ENTER to continue."<<endl;
		getch();
		system("cls");
		goto a;
    }
    else if (code == 2){
        system("cls");
		cout << "The average sales is : RM " << average << endl;
		cout << "Press ENTER to continue."<<endl;
		getch();
		system("cls");
		goto a;
    }
    else if (code == 3){
    	mainPage();
	}
    else {
        main();
    }
}

//--------------------------------------------------------------------------------------------------------customer

void customerPage()
{
	string fullname;
	double price;
	char piz1[]="Beef Pepperoni" ,piz2[]="Hawaiian Chicken" ,piz3[]="Chicken Bar BQ" ,piz4[]="Cheezilla", drinks1[]="Mountain Dew", drinks2[]="Coca Cola", drinks3[]="Royal Canin",burger_1[]="Zinger Burger",burger_2[]="Chicken Burger",burger_3[]="Beef Burger";
	char spaghetti_1[]="Spaghetti Bolognese", spaghetti_2[]="Spaghetti Carbonara", spaghetti_3[]="Aglio Oglio";
	char fried1[]="Chicken Fried", fried2[]="Prawn Fried", fried3[]="Beef Fried",gotobeginning ;
	int option=0,pizzaOption,size,fried,spaghetti,burger,drinks,qty;
	starting:
	system("cls");
	cout<<"\t\t\t|-------------------------------------------------------|\n";
	cout<<"\t\t\t|              MAKAN MAKAN  Food Ordering System        |\n";
	cout<<"\t\t\t|-------------------------------------------------------|\n\n";
	cout << endl;
	cout<<"Please Enter Your Name: ";
	cin>>fullname;
	count++;
	cout << endl;
	cout<<"Hello "<<fullname<<"\n\nWhat would you like to order?\n\n";
	

	cout<<"\t\t\t|-------------------------------------------------------|\n";
	cout<<"\t\t\t|                       Food Menu                       |\n";
	cout<<"\t\t\t|-------------------------------------------------------|\n\n";

	cout<<"[Choice 1] Pizzas\n";
	cout<<"[Choice 2] Burgers\n";
	cout<<"[Choice 3] Spaghetti\n";
	cout<<"[Choice 4] Drinks\n";
	cout<<"\nPlease Enter your Choice: ";
	cin>>option;

//------------------------------------------------------------------------------------pizza
	if(option==1)
	 {
		cout<<"\n[1] "<<piz1<<"\n";
		cout<<"[2] "<<piz2<<"\n";
		cout<<"[3] "<<piz3<<"\n";
		cout<<"[4] "<<piz4<<"\n";
		cout<<"\nPlease Enter which Pizza Flavor would you like to have?:";
		cin>>pizzaOption;
		if(pizzaOption>=1 && pizzaOption<=4)
		{
			cout<<"\n[1] Small RM10.00\n"<<"[2] Regular RM15.00\n"<<"[3] Large RM20.00\n";
			cout<<"\nChoose Size Please:";
			cin>>size;
			
			if(size>=1 && size<=3)
			
			cout<<"\nPlease Enter Quantity: ";
			cin>>qty;
			
			switch(size)
			{
			case 1: total += calcTotal(10.00,qty);
			break;

			case 2: total += calcTotal(15.00,qty);
			break;

			case 3: total += calcTotal(20.00,qty);
			break;


			}
			system("cls");
			
			switch (pizzaOption)
			{
			 case 1:
			 cout<<"\t\t\t--------Your Order---------\n";
			 cout<<""<<qty<<" "<<piz1;
			 cout<<"\nYour Total Bill is \nRM"<<total<<endl;
			 serviceType();
			 paymentType();
			 cout<<"\n\nThank you For Ordering From MAKAN MAKAN food\n";
			 break;
			 
			 case 2:
			 cout<<"\t\t--------Your Order---------\n";
			 cout<<""<<qty<<"  "<<piz2;
			 cout<<"\nYour Total Bill is \nRM"<<total<<endl;
			 serviceType();
			 paymentType();
			 cout<<"\nThank you For Ordering From MAKAN MAKAN food\n";
			 break;
			 
			 case 3:
			 cout<<"\t\t--------Your Order---------\n";
			 cout<<""<<qty<<" "<<piz3;
			 cout<<"\nYour Total Bill is \nRM"<<total<<endl;
			 serviceType();
			 paymentType();
			 cout<<"\nThank you For Ordering From MAKAN MAKAN food\n";
			 break;
			 
			 case 4:
			 cout<<"\t\t--------Your Order---------\n";
			 cout<<""<<qty<<" "<<piz4;
			 cout<<"\nYour Total Bill is \nRM"<<total<<endl;			
			 serviceType();
			 paymentType();
			 cout<<"\nThank you For Ordering From MAKAN MAKAN food\n";
			 break;

			}
			cout<<"Would you like to order anything else? Y / N:";
			cin>>gotobeginning;
			if(gotobeginning=='Y' || gotobeginning=='y')
			{
			  goto starting;
			  //return 0;
			}
			else
				mainPage();

		}

	 }


	//------------------------------------------------------------------------------------burger
	 else if(option==2)
	 {
		cout<<"\n[1] "<<burger_1<<" RM8.00"<<"\n";
		cout<<"[2] "<<burger_2<<" RM5.00"<<"\n";
		cout<<"[3] "<<burger_3<<" RM7.00"<<"\n";
		
		cout<<"\nPlease Enter which Burger you would like to have?: ";
		cin>>burger;
		if(burger>=1 && burger<=3)
		{
			cout<<"\nPlease Enter Quantity: ";
			cin>>qty;
			switch(burger)
			{
			case 1: total += calcTotal(8.00,qty);
			break;

			case 2: total += calcTotal(5.00,qty);
			break;

			case 3: total += calcTotal(7.00,qty);
			break;

			}
			system("cls");
			
			switch (burger)
			{
			 
			 case 1:
			 cout<<"\t\t--------Your Order---------\n";
			 cout<<""<<qty<<" "<<burger_1;
			 cout<<"\nYour Total Bill is \nRM"<<total<<endl;
			 serviceType();
			 paymentType();
			 cout<<"\nThank you For Ordering From MAKAN MAKAN food\n";
			 break;
			 
			 case 2:
			 cout<<"\t\t--------Your Order---------\n";
			 cout<<""<<qty<<"  "<<burger_2;
			 cout<<"\nYour Total Bill is \nRM"<<total<<endl;
			 serviceType();
			 paymentType();
			 cout<<"\nThank you For Ordering From MAKAN MAKAN food\n";
			 break;
			 
			 case 3:
			 cout<<"\t\t--------Your Order---------\n";
			 cout<<""<<qty<<" "<<burger_3;
			 cout<<"\nYour Total Bill is \nRM"<<total<<endl;
			 serviceType();
			 paymentType();
			 cout<<"\nThank you For Ordering From MAKAN MAKAN food\n";
			 break;


			}
			cout<<"\nWould you like to order anything else? Y / N:";
			cin>>gotobeginning;
			if(gotobeginning=='Y' || gotobeginning=='y')
			{
			  goto starting;
			  //return 0;
			}
			else
				mainPage();

 		}
	}
	
	//------------------------------------------------------------------------------------spaghetti
	else if(option==3)
	 {
		cout<<"\n[1]  "<<spaghetti_1<<" RM8.00"<<"\n";
		cout<<"[2]  "<<spaghetti_2<<" RM10.00"<<"\n";
		cout<<"[3]  "<<spaghetti_3<<" 13.00"<<"\n";
		
		cout<<"\nPlease Enter which Spaghetti you would like to have?:";
		cin>>spaghetti;
		if(spaghetti>=1 && spaghetti<=3)
		{
			cout<<"\nPlease Enter Quantity: ";
			cin>>qty;
			
			switch(spaghetti)
			{
			case 1: total += calcTotal(8.00,qty);
			break;

			case 2: total += calcTotal(10.00,qty);
			break;

			case 3: total += calcTotal(13.00,qty);
			break;

			}
			system("cls");
			switch (spaghetti)
			{
			 case 1:
			 cout<<"\t\t--------Your Order---------\n";
			 cout<<""<<qty<<" "<<spaghetti_1;
			 cout<<"\nYour Total Bill is \nRM"<<total<<endl;
			 serviceType();
			 paymentType();
			 cout<<"\nThank you For Ordering From MAKAN MAKAN food\n";
			 break;
			 
			 case 2:
			 cout<<"\t\t--------Your Order---------\n";
			 cout<<""<<qty<<"  "<<spaghetti_2;
			 cout<<"\nYour Total Bill is \nRM"<<total<<endl;
			 serviceType();
			 paymentType();
			 cout<<"\nThank you For Ordering From MAKAN MAKAN food\n";
			 break;
			 
			 case 3:
			 cout<<"\t\t--------Your Order---------\n";
			 cout<<""<<qty<<" "<<spaghetti_2;
			 cout<<"\nYour Total Bill is \nRM"<<total<<endl;
			 serviceType();
			 paymentType();
			 cout<<"\nThank you For Ordering From MAKAN MAKAN food\n";
			 break;


			}
			cout<<"Would you like to order anything else? Y / N:";
			cin>>gotobeginning;
			if(gotobeginning=='Y' || gotobeginning=='y')
			{
			  goto starting;
			  //return 0;
			}
			else
				mainPage();
			}
			}

	//------------------------------------------------------------------------------------drinks
	else if(option==4)
	{
		cout<<"\n[1] "<<drinks1<<" RM3.00"<<"\n";
		cout<<"[2] "<<drinks2<<" RM4.00"<<"\n";
		cout<<"[3] "<<drinks3<<" RM5.00"<<"\n";
		cout<<"\nPlease enter which drink you would like to have?: ";
		cin>>drinks;
		if(drinks>=1 && drinks<=3)
		{
			cout<<"\nHow Much Drinks Do you want: ";
			cin>>qty;
			switch(drinks)
			{
			case 1: total += calcTotal(3.00,qty);
			break;

			case 2: total += calcTotal(4.00,qty);
			break;

			case 3: total += calcTotal(5.00,qty);
			break;

			}
			system("cls");
			
			switch (drinks)
			{
			case 1:
			cout<<"\t\t--------Your Order---------\n";
			cout<<""<<qty<<" "<<drinks1;
			cout<<"\nYour Total Bill is \nRM"<<total<<endl;
			serviceType();
			paymentType();
			cout<<"\nThank you For Ordering From MAKAN MAKAN food\n";
			break;
			 
			case 2:
			cout<<"\t\t--------Your Order---------\n";
			cout<<""<<qty<<"  "<<drinks2;
			cout<<"\nYour Total Bill is \nRM"<<total<<endl;
			serviceType();
			paymentType();
			cout<<"\nThank you For Ordering From MAKAN MAKAN food\n";
			break;
			 
			case 3:
			cout<<"\t\t--------Your Order---------\n";
			cout<<""<<qty<<" "<<drinks3;
			cout<<"\nYour Total Bill is \nRM"<<total<<endl;
			serviceType();
			paymentType();
			cout<<"\nThank you For Ordering From MAKAN MAKAN food\n";
			break;
			}
			
			cout<<"Would you like to order anything else? Y / N:";
			cin>>gotobeginning;
			if(gotobeginning=='Y' || gotobeginning=='y')
			{
			  goto starting;
			  //return 0;
			}
			else
				mainPage();

 		}
	}
		
	else
	{
		system("cls");
		cout<<"Please Select Right Choice \n";
		cout<<"Would You like to Start Order Again? Y / N: " ;
		cin>>gotobeginning;

		if(gotobeginning=='Y' || gotobeginning=='y')
		{
			goto starting;
			  //return 0;
		}
		else
			mainPage();
	}
}

double calcTotal(double price, int qty){
	return price*qty;
}

void serviceType(){
	int service;
	double charge =5.0, totalCharge=0;
	
	a:
		cout<<"--------------------------"<<endl;
		cout<<"Choose your service method "<<endl;
		cout<<"--------------------------"<<endl;
		cout<<"[1] Delivery "<<endl;
		cout<<"[2] Pick-up"<<endl;
		cout<<"\nPlease enter which service would you like to have? : ";
		cin>>service;
		
		if(service==1){
			delivery();
		}
		else if(service==2){
			cout<<"Your order has been placed."<<endl;
		}
		else {
			cout<<"Please select the right code. \n"<<endl;
			system("cls");
			goto a;
		}
}

void delivery(){
	double charge=5.0, totalCharge=0;
	cout<<"\nThe delivery charge is RM 5."<<endl;
			
	totalCharge=total+charge;
			
	cout<<"Total including delivery charge is : RM "<<totalCharge<<endl;
			
	total=totalCharge;
	//totalSales+=total;
	//average = totalSales/count;
	
}

void paymentType(){
	int payment;
	double pay, discount = 0.02;
	
	cout<<"--------------------------"<<endl;
	cout<<"Choose your payment method"<<endl;
	cout<<"--------------------------"<<endl;
	cout<<"[1] CASH "<<endl;
	cout<<"[2] CREDIT CARD "<<endl;
	cout<<"Enter code : ";
	cin>>payment;
	
	if(payment==1){
		
		cout<<"The total is : RM " << total << endl;
		cout<<"You pay : RM ";
		cin>>pay;
		cout<<"Balance : RM " << (pay - total) << endl;
		
		totalSales+=total;
		average = totalSales/count;
	}
	else if(payment==2){
		creditCard();
	}
	else {
		cout<<"Your order will not be saved"<<endl;
		sleep(1);
		mainPage();
	}
}

void creditCard(){
	double discount = 0.02;
	cout<<"The total is : RM " << total << endl;
	cout<<"The total after discount is : RM " << total - (total * discount) << endl;
		
	totalSales+=total-(total*discount);
	average = totalSales/count;
	sleep(1);
	cout<<"\nTransaction completed."<<endl;
}
