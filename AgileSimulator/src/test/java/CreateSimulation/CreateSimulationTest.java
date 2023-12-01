package CreateSimulation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreateSimulationTest {

    @DisplayName("Basic True Case")
    @Test
    void testBasicTrueCase() {
        boolean result1 = CreateSimulation.RoundButton.ErrorInputs("Test Session","3", "5", "10", "3");
        assertTrue(result1);
    }

    @DisplayName("Test Blank Inputs")
    @Test
    void testBlankInputs() {
        boolean result2 = CreateSimulation.RoundButton.ErrorInputs("","", "", "", "");
        assertFalse(result2);
        boolean result3 = CreateSimulation.RoundButton.ErrorInputs("Test Session","", "", "10", "");
        assertFalse(result3);
        //Added a space in the Session Name input.
        boolean result4 = CreateSimulation.RoundButton.ErrorInputs(" ","3", "", "", "4");
        assertFalse(result4);
        boolean result5 = CreateSimulation.RoundButton.ErrorInputs("","", "", "10", "4");
        assertFalse(result5);
        //Case 1: Single Blank Space
        boolean result6 = CreateSimulation.RoundButton.ErrorInputs("  ","3", "5", "10", "3");
        assertFalse(result6);
        //Case 2: Two/Multiple Blank Spaces
        boolean result7 = CreateSimulation.RoundButton.ErrorInputs("  ","3", "5", "10", "3");
        assertFalse(result7);
    }

    @DisplayName("Invalid Input Types")
    @Test
    void testInvalidInputTypeCase() {
        //Happy Day Case
        boolean result8 = CreateSimulation.RoundButton.ErrorInputs("Test Session","3", "5", "10", "3");
        assertTrue(result8);
        //Case 1: String in place of number.
        boolean result9 = CreateSimulation.RoundButton.ErrorInputs("Test Session","three", "5", "10", "3");
        assertFalse(result9);
        //Case 2: Special Characters in place of number.
        boolean result10 = CreateSimulation.RoundButton.ErrorInputs("Test Session","three", "#%", "10", "3");
        assertFalse(result10);
        //Case 3: Special Characters in place of number
        boolean result11 = CreateSimulation.RoundButton.ErrorInputs("Test Session","3", "#%5", "10", "3");
        assertFalse(result11);
    }

    @DisplayName("Mix-Error Case")
    @Test
    void testMultipleErrorsInOneInput() {
        //Happy Day Case
        boolean result8 = CreateSimulation.RoundButton.ErrorInputs("Test Session","3", "5", "10", "3");
        assertTrue(result8);
        //Mix-case:1
        boolean result12 = CreateSimulation.RoundButton.ErrorInputs("       ","three", "5", "10", "3");
        assertFalse(result12);
        //Mix-case:2
        boolean result13 = CreateSimulation.RoundButton.ErrorInputs("Test Session","three", "#%", "10", "#3");
        assertFalse(result13);
    }




}