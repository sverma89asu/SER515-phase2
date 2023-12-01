package scrum_sim_packages;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class UserStoryModel {
    private static final String DB_FILE = "UserStories.json";
    public static ArrayList<UserStory> getUserStories() {
        ArrayList<UserStory> userStories = new ArrayList<>() ;
        try(FileReader reader = new FileReader(DB_FILE)) {
            JSONParser parser = new JSONParser();
            JSONArray userStoryArray = (JSONArray) parser.parse(reader);

            for(Object userStoryObj : userStoryArray) {
                JSONObject userStoryJson = (JSONObject) userStoryObj;
                long id = (long) userStoryJson.get("id");
                String name = (String) userStoryJson.get("name");
                String description = (String) userStoryJson.get("description");
                double storyPoints = (double) userStoryJson.get("story_points");
                long businessValue = (long) userStoryJson.get("business_value");
                userStories.add(new UserStory(id, name, description, storyPoints, businessValue));
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace(System.out);
        }

        return userStories;
    }
    public static void main(String[] args){
        ArrayList<UserStory> userStories = getUserStories();
        for (int i = 0; i < userStories.size(); i++) {
            UserStory element = userStories.get(i);
            System.out.println(element.getDescription());
            // You can now use 'i' to access the index.
        }
    }
}