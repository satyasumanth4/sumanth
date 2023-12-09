import java.util.Scanner;
class ATM {
    String userid;
    String pin;
    double balance;

    public ATM(String userid, String pin, double balance) {
        this.userid = userid;
        this.pin = pin;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit successful. Your current balance is: " + balance);
    }

    public void withdraw(double amount) {
        if (balance - amount <0) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println("Withdraw successful. Your current balance is: " + balance);
        }
    }

    public void transactionHistory() {
        System.out.println("---------------------------------------");  
        System.out.println(" Date | AmountTransfer ");  
        System.out.println("---------------------------------------"); 
		System.out.println("20/01/2023\t|	+ 2000/-");
		System.out.println("25/01/2023\t|	- 5000/-");
		System.out.println("10/02/2023\t|	+ 10000/-");
		System.out.println("12/03/2023\t|	+ 3000/-");
    }
	public void transfer(String acnum,double amount)
	{
		balance-=amount;
		System.out.println("Amount transfered to the user of this account number "+acnum);
		System.out.println("Withdraw successful. Your current balance is: " + balance);
	}
}
public class ATMInterface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String choice;
        String userid;
        String pin;
		String acnum;
        double amount;

        while (true) {
			System.out.println();
            System.out.println("Welcome to the ATM Application");
            System.out.println("1. Login");
            System.out.println("2. Close");
            System.out.print("Enter your choice: ");
            choice = sc.nextLine();
			ATM atm=new ATM("suman","123456",100000);
            if (choice.equals("1")) {
                System.out.print("Enter your id: ");
                userid = sc.nextLine();
                System.out.print("Enter your pin: ");
                pin = sc.nextLine();
                if (userid.equals("5673210") && pin.equals("12345")){
                    while (choice.equals("5")!=true) {
						System.out.println();
                        System.out.println("Welcome to ABC bank");
                        System.out.println("1. Withdraw");
                        System.out.println("2. Deposit");
                        System.out.println("3. Transfer");
                        System.out.println("4. Transaction History");
                        System.out.println("5. Quit");
                        System.out.print("Enter your choice: ");
                        choice = sc.nextLine();
                        if (choice.equals("1")) {
                            System.out.print("Enter the amount to withdraw: ");
                            amount = sc.nextDouble();
                            sc.nextLine();
                            atm.withdraw(amount);
                        } else if (choice.equals("2")) {
                            System.out.print("Enter the amount to deposit: ");
                            amount = sc.nextDouble();
                            sc.nextLine();
                            atm.deposit(amount);
                        } else if (choice.equals("3")) {
							System.out.print("Enter the account number to transfer:  ");
							acnum=sc.nextLine();
							System.out.print("Enter the amount to transfer: ");
                            amount = sc.nextDouble();
                            atm.transfer(acnum,amount);
                        } else if (choice.equals("4")) {
                           atm.transactionHistory();
                        } else if (choice.equals("5")) {
							System.out.println("if you don't want to continue enter 2 to close");
                            break;
                        } else {
                            System.out.println("Invalid choice.");
                        }
                    }
                }
				else{
					System.out.println("Invalid Credentials");
					break;
				}
            } else if (choice.equals("2")) {
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }
        System.out.println("\tTHANK YOU");
        sc.close();
    }
}
