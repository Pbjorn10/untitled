//package MidProjBensal;

public class CreditCardAccount extends BankAccounts{
    //declaration of instance variables
    private double creditLimit;
    private double charges;

    //default constructor for initializing the values
    public CreditCardAccount(){
        super();
        creditLimit = 0.0;
        charges = 0.0;
    }

    //Parameterized constructor
    public CreditCardAccount(int accountNo,String accountName,double creditLimit,double charges){
        super(accountNo,accountName);
        this.creditLimit=creditLimit;
        this.charges=charges;
    }

    //get methods for credit limit and charges
    public double getCreditLimit() {
        return creditLimit;
    }
    public double getCharges() {
        return charges;
    }

    //optional set methods so that credits cant be zero
    public void setCreditLimit(double creditLimit) {
        if(creditLimit<0){
            throw new IllegalArgumentException("Credit Limit mustnotbe negative");
        }
        this.creditLimit = creditLimit;
    }

    //pay card method to pay charges when using credit
    public void payCard(double amount){

        //validator to check that amount is greater than or equals to zero
        if (amount<=0){
            System.out.println("Invalid, amount must be positive");
            return;
        }
        if(amount>charges){
            charges=0; //if payment is greater than charges it sets the charges to zero

        } else{
            charges-=amount; //deducts the amount to pay from charges
        }
        throw new IllegalArgumentException("Total amount left is "+charges); // displays the updated charges
    }
    //Method to inquire available credit
    public void inquireAvailableCredit(){
        //new variable and subtracts to find the available credit
        double inquireAvailableCredit = creditLimit-charges;

        //displays the available credit
        System.out.println("The available credit is: "+inquireAvailableCredit);

    }

    //charge method to add charges to amount
    public void chargeToCard(double amount){
        //checks for available credit
        double availableCredit = creditLimit-charges;

        //validate for amount must not be negative
        if(amount<=0){
            System.out.println("Invalid, amount must be positive");
            return;
        }
        if(availableCredit>amount){
            charges+=amount; //adds amount to charges if available credit is greater than amount
            System.out.println("Charge transaction is complete. \nNew Balance: "+charges);
        }else{ //else statement if the available credit is not enough
            throw new IllegalArgumentException("Sorry, Charge transaction didn't went through, Not enough credit");

        }
    }

    //getCashAdvance method for advance borrowing of money
    public void getCashAdvance(double amount){

        //validator to check that amount must be positive
        if(amount<=0){
            System.out.println("Invalid, amount must be positive");
            return;
        }

        //checks for available credit
        double availableCredit = creditLimit-charges;
        //ensuring that available credit is less than 50% and storing it on variable maxadvance
        double maxadvance = availableCredit *0.5;

        if(amount<maxadvance){
            charges+=amount; //if else to ensure that amount doesn't exceed 50% and add amount to be borrowed to charges
            System.out.println(amount+" cash advance is granted. \n New Balance: "+charges);
        }else{// else statement if cash advance didn't push through
            throw new IllegalArgumentException("Sorry, Cash advance didn't went through");

        }

    }

    /*
     * override methods as they are not able to use in Credit Card Account
     * As there are no deposit withdrawal and transfer money in a Credit Card Account
     * So they must be overridden to not cause error in CreditCard subclasss
     */

    @Override
    public void deposit(double amount) {
        System.out.println("Credit Card Account does not allow Deposit");
    }

    @Override
    public void withdraw(double amount) {
        System.out.println("Credit Card Account does not allow Withdrawal.");
    }

    @Override
    public void transferMoney(BankAccounts recipient, double amount) {
        System.out.println(" Credit Card Account does not allow Transfer.");
    }
    /*public void toString(BankAccounts recipient, double amount) {
        System.out.println(" Credit Card Account does not allow Transfer.");
    }*/
}
