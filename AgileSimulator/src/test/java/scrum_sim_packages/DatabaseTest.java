package scrum_sim_packages;

import CreateSimulation.CreateSimulation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {
    Database database = new Database();
    @DisplayName("add new user")
    @Test
    void testBasicTrueCase() {
        User user = new User("user20", "user20@abc.com", "Password123%1", "trainer");
        boolean result1 = database.addUser(user);
        assertTrue(result1);
    }
}
