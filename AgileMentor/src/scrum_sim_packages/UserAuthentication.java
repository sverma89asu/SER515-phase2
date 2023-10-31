package AgileMentor.src.scrum_sim_packages;

public class UserAuthentication {
    public static void main(String[] args) {
        Database database = new Database();

       
        database.addUser(new User("user1", "user1@example.com", "password1", "user"));
        database.addUser(new User("user2", "user2@example.com", "password2", "user"));

        // Add more users as needed...

        // Authenticate a user
        String username = "user1";
        String password = "password1";
        if (database.authenticate(username, password)) {
            System.out.println("Authentication successful for user: " + username);
        } else {
            System.out.println("Authentication failed for user: " + username);
        }
    }
}
