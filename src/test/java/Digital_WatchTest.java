import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Digital_WatchTest {
    Digital_Watch mywatch;
    @BeforeEach
    void setup(){
        mywatch = new Digital_Watch();
    }

    @Test
    void press_a_button() {
        assertEquals(Digital_Watch.display_states.TIME,mywatch.display_state);
        mywatch.press_a_button();
        assertEquals(Digital_Watch.display_states.DATE,mywatch.display_state);
    }

    @Test
    void press_b_button() {
        mywatch.press_b_button();
        assertEquals(Digital_Watch.states.ALARM,mywatch.state);
    }

    @Test
    void press_c_button() {
        mywatch.press_c_button();
        assertEquals(Digital_Watch.states.UPDATE,mywatch.state);
    }

    @Test
    void press_d_button() {
        mywatch.press_b_button();
        mywatch.press_d_button();
        assertEquals(Digital_Watch.states.NORMAL,mywatch.state);
    }
}