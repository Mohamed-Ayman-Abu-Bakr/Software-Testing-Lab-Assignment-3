import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Coffee_MachineTest {

    Coffee_Machine coffeeMachine;

    @BeforeEach
    void setup(){
        coffeeMachine = new Coffee_Machine();
        coffeeMachine.press_power_on_button();
    }

    @Test
    void press_power_on_button() {
        coffeeMachine.press_power_on_button();
        assertEquals(Coffee_Machine.on_off_states.ON,coffeeMachine.machineState);
        assertEquals(0,coffeeMachine.money);
    }

    @Test
    void press_power_off_button() {
        coffeeMachine.press_power_on_button();
        coffeeMachine.press_power_off_button();
        assertEquals(Coffee_Machine.on_off_states.OFF,coffeeMachine.machineState);
    }

    @Test
    void insert_coin(){
        coffeeMachine.insert_coin();
        assertEquals(1,coffeeMachine.money);
    }

    @Test
    void decrement_money() {
        assertFalse(coffeeMachine.decrement_money());
        coffeeMachine.insert_coin();
        assertTrue(coffeeMachine.decrement_money());
    }

    @Test
    void order_coffee() {
        System.out.println(coffeeMachine.money);
        coffeeMachine.insert_coin();
        System.out.println(coffeeMachine.money);
        coffeeMachine.order_coffee();
        System.out.println(coffeeMachine.money);
        assertEquals(0,coffeeMachine.money);
        System.out.println(coffeeMachine.money);
    }

    @Test
    void withdraw_money() {
        coffeeMachine.insert_coin();
        coffeeMachine.insert_coin();
        assertEquals(2,coffeeMachine.money);
        coffeeMachine.withdraw_money();
        assertEquals(0,coffeeMachine.money);
    }
}