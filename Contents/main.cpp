#include <iostream>
using namespace std;

int main() {
    //Variables:
    
    //for menu selection
    int choice;
    
    //account balance
    double balance = 0;
    
    //transaction
    double amount = 0;

//This while condition allows us to run the program continously until the user chooses to exit.
while(true){
    //Our Menu for this program
    cout << "\nGCASH Transaction Menu" << endl;
    cout << "[1] Check Balance" << endl;
    cout << "[2] Cash in" << endl;
    cout << "[3] Cash out" << endl;
    cout << "[4] Exit" << endl;
    
    //Part where we ask the user what he/she wants to do
    cout << "What do you want to do?: ";
    //We set the value of choice base from the user input
    cin >> choice;
    
    //Tells the program to exit
    if (choice == 4) {
        cout << "Exiting... Program closed. Goodbye!" << endl;
    }
    
    //Program enters the option 1 in the menu
    else if (choice == 1) {
        cout << "Your current balance is: ₱" << balance << endl;
    }
    
    //Program enters the option 2 in the menu
    else if (choice == 2) {
        //We asked for amount the user want to cash in, then add it to our current balance
        cout << "Enter amount you want to Cash in: ";
        
        //We set the value of amount base from the user input
        cin >> amount;
        
        //We add that amount to our current balance
        balance = balance + amount;
        
        //We print an output that the transaction is success
        cout << "Cash in Success!" << endl;
        cout << "Your updated balance is:₱" << balance << endl;
    }
    
    //Program enters the option 3 in the menu
    else if (choice == 3) {
        //We asked for amount the user want to cash out, then subtract it to our current balance
        cout << "Enter amount you want to Cash out: ";
        
        //We set the value of amount base from the user input
        cin >> amount;
        
        //This condition stops the user from doing cashout more than our current balance
        if(amount>balance){
            cout << "Cashout Failed! Balance insufficient" << endl;
        } 
        
        //We print an output that the transaction is success
        else if(amount>=balance){
            balance = balance - amount;
            cout << "You have successfully cashed out ₱" << amount << endl;
            cout << "Your remaining balance is: ₱" << balance << endl;
        }
    }
    
    //We doesn't allow choices not there in our menu
    else {
        cout << "Invalid choice! Choose only from number 1-4" << endl;
    }
}   
   
}

