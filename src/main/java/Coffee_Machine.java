public class Coffee_Machine {
    enum on_off_states{ON,OFF}
    enum coffee_states{IDLE,BUSY}
    enum money_states{EMPTY,NOT_EMPTY}
    int money;
    on_off_states machineState;
    on_off_states lightState;
    coffee_states coffeeState;
    money_states moneyState;


    public void press_power_on_button(){
        if(machineState==on_off_states.ON){
            System.out.println("The machine is already on");
        }else{
            power_on();
        }
    }

    public void press_power_off_button(){
        if(coffeeState==coffee_states.BUSY){
            System.out.println("Wait for machine to finish the coffee");
            while(coffeeState==coffee_states.BUSY){
                //do nothing
            }
        }
        if(moneyState!=money_states.EMPTY){
            withdraw_money();
        }
        power_off();
    }

    public void show_money(){
        System.out.println("Money = " + money);
    }

    private void power_on(){
        machineState = on_off_states.ON;
        lightState = on_off_states.ON;
        coffeeState = coffee_states.IDLE;
        moneyState = money_states.EMPTY;
        money = 0;
    }
    private void power_off(){
        lightState = on_off_states.OFF;
        machineState = on_off_states.OFF;
    }
    public void order_coffee(){
        if(coffeeState == coffee_states.IDLE){
            if(decrement_money()){
                prepare_coffee();
            }
        }else{
            System.out.println("Busy making coffee!");
        }
    }
    private void prepare_coffee(){
        coffeeState = coffee_states.BUSY;
        System.out.println("Preparing your coffee!");
        //delay
        System.out.println("Done preparing!");
        coffeeState = coffee_states.IDLE;
    }
    public void insert_coin(){
        increment_money();
    }
    private void increment_money(){
        if(moneyState==money_states.EMPTY){
            moneyState = money_states.NOT_EMPTY;
        }
        money++;
    }
    public boolean decrement_money(){
        if(money >0){
            money--;
            if(money ==0){
                moneyState=money_states.EMPTY;
            }
            return true;
        }else{
            System.out.println("Not enough Money");
            return false;
        }
    }
    private void return_coin(){
        //return coin stub
        System.out.println("Returned coin");
    }
    public void withdraw_money(){
        while(moneyState!=money_states.EMPTY){
            return_coin();
            decrement_money();
        }
    }
}
