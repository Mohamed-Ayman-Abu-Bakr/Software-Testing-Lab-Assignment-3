import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ATM_MachineTest {

    ATM_Machine atm;
    credit_card card;

    @BeforeEach
    void setup(){
        atm = new ATM_Machine();
        card = new credit_card(1000,"1111");
    }

    @Test
    void press_turn_on_button() {
        atm.press_turn_on_button();
        assertEquals(ATM_Machine.on_off_states.ON,atm.machineState);
    }

    @Test
    void insertCard() {
        atm.insertCard(card);
        assertEquals(card,atm.inserted_card);
    }

    @Test
    void authenticate(){
        atm.insertCard(card);
        assertEquals(false,atm.authenticated);
        atm.authenticate("1111");
        assertEquals(true,atm.authenticated);
    }
    @Test
    void withdrawCard() {
        atm.insertCard(card);
        atm.withdrawCard();
        assertEquals(false,atm.authenticated);
        assertEquals(null,atm.inserted_card);
    }

    @Test
    void withdraw() {
        atm.insertCard(card);
        atm.authenticate("1111");
        assertEquals(1000,card.balance);
        atm.withdraw(500);
        assertEquals(500,card.balance);
    }

    @Test
    void deposit() {
        atm.insertCard(card);
        atm.authenticate("1111");
        atm.deposit(239);
        assertEquals(1239,card.balance);
    }
}