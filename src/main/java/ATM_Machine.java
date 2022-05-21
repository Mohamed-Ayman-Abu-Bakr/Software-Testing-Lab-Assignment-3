import java.util.Scanner;
enum pin_status{CORRECT,INCORRECT}
class credit_card{
    public credit_card(int balance, String pin){
        this.balance=balance;
        this.pin =pin;
    }
    private String pin;
    int balance;
    public pin_status checkPin(String pin){
        if(pin.equals(this.pin))return pin_status.CORRECT;
        else return pin_status.INCORRECT;
    }
    void withdraw(int withdraw_amount){
        balance-=withdraw_amount;
    }
    void deposit(int deposit_amount){
        balance+=deposit_amount;
    }
    void setPin(String pin){
        this.pin = pin;
    }
}
public class ATM_Machine {
    enum on_off_states{ON,OFF}

    credit_card inserted_card;
    on_off_states machineState;
    on_off_states screenState;
    boolean card;               // is there a credit card in the machine
    boolean authenticated;

    public void press_turn_on_button(){
        if(machineState == on_off_states.ON){
            System.out.println("The machine is already on");
        }else{
            turn_on();
        }
    }

    private void turn_on(){
        machineState = on_off_states.ON;
        screenState = on_off_states.ON;
        inserted_card=null;
        card = false;
        authenticated = false;
    }
    private void turn_off(){
        if(card){
            System.out.println("Withdraw card first");
        }else{
            screenState = on_off_states.OFF;
            machineState = on_off_states.OFF;
        }
    }
    public void insertCard(credit_card card){
        this.inserted_card = card;
        //authenticate();
    }
    public void withdrawCard(){
        this.inserted_card=null;
        card = false;
        authenticated = false;
    }

    public void authenticate(String pin){
        int remaining_tries = 3;
        while(remaining_tries>0){
            //System.out.println("You have "+remaining_tries+" remaining tries");
            pin_status pinStatus = inserted_card.checkPin(pin);

            if(pinStatus == pin_status.CORRECT){
                authenticated = true;
                return;
            }
            remaining_tries--;
        }
        eatCard();
    }
    private String enterPin(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your pin: ");
        return input.next();
    }
    private void eatCard(){
        //eatCard stub
        System.out.println("Your card has been eaten");
    }
    public void removeCard(){
        inserted_card = null;
        authenticated = false;
    }
    private void output_money(int amount){
        //stub
        System.out.println("Here is your "+amount+" pounds");
    }

    public void withdraw(int withdraw_amount){
        if(inserted_card.balance>=withdraw_amount){
            output_money(withdraw_amount);
            inserted_card.withdraw(withdraw_amount);
        }else{
            System.out.println("Insufficient balance");
        }
    }
    public void deposit(int deposit_amount){
        inserted_card.deposit(deposit_amount);
    }

    private int get_balance(){
        return inserted_card.balance;
    }
    public void view_balance(){
        System.out.println("Your current balance = " + inserted_card.balance);
    }
    public void update_pin(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your new pin: ");
        String pin = input.next();
        System.out.println("Confirm new pin: ");
        if(pin.equals(input.next()))inserted_card.setPin(pin);
        else System.out.println("The two pins weren't matching!");
    }

}
