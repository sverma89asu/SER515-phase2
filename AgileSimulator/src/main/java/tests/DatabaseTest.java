package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import scrum_sim_packages.Database;
import scrum_sim_packages.User;

public class DatabaseTest {
    @Test
    public void testValidateWithInvalidUsername() {
        User user = new User("invalidUsername@", "validPassword", "valid@email.com", "user");
        Database db = new Database();
        boolean isValid = db.validate(user);
        Assertions.assertFalse(isValid, "Username with invalid characters should be considered invalid");
    }

    @Test
    public void testValidateWithInvalidPassword() {
        User user = new User("validUsername", "invalidPassword", "valid@email.com", "user");
        Database db = new Database();
        boolean isValid = db.validate(user);
        Assertions.assertFalse(isValid, "Password less than 8 characters should be considered invalid");
    }

    @Test
    public void testValidateWithInvalidEmail() {
        User user = new User("validUsername", "validPassword", "invalidEmail", "user");
        Database db = new Database();
        boolean isValid = db.validate(user);
        Assertions.assertFalse(isValid, "Email without '@' symbol should be considered invalid");
    }
}
