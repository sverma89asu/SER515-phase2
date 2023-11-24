package scrum_sim_packages;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Database {
    private static final String DB_FILE = "Database.json";
    private List<User> users;
    public Database() {
        users = new ArrayList<>();
        loadDB();
    }
    private void loadDB() {
        try(FileReader reader = new FileReader(DB_FILE)) {
            JSONParser parser = new JSONParser();
            JSONArray userArray = (JSONArray) parser.parse(reader);

            for(Object userObj : userArray) {
                JSONObject userJson = (JSONObject) userObj;
                String username = (String) userJson.get("username");
                String email = (String) userJson.get("email");
                String password = (String) userJson.get("password");
                String role = (String) userJson.get("role");
                users.add(new User(username, email, password, role));
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace(System.out);
        }
    }
    private void saveDB() {
        JSONArray userArray = new JSONArray();
        for (User user : users){
            userArray.add(user.toJSON());
        }

        try (FileWriter writer = new FileWriter(DB_FILE)) {
            writer.write(userArray.toJSONString());
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }
    public User getUserByUsername(String username) {
        for (User user : users) {
            if (user.getName().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public boolean addUser(User user) {
        if (getUserByUsername(user.getName()) == null) {
            String name = user.getName();
            String email = user.getEmail();
            String password = user.getPassword();
            if (!name.matches("[a-zA-Z0-9]+")) {
                throw new IllegalArgumentException("Username can only have alphanumeric characters");
            }
            else if (!email.contains("@")) {
                throw new IllegalArgumentException(("Invalid Email"));
            }
            else if (password.length() <= 8) {
                throw new IllegalArgumentException("Password should be greater than 8 characters");
            }
            users.add(user);
            saveDB();
            return true;
        }
        return false;
    }

    public boolean authenticate(String username, String password) {
        User user = getUserByUsername(username);
        return user != null && user.getPassword().equals(password);
    }

    public List<User> getAllUsers() {
        return users;
    }
}
