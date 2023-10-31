package AgileMentor.src.Model;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserStoryModel {
    private static final String DB_FILE = "UserStories.json";
    public List<UserStory> getUserStories() {
        List<UserStory> userStories;
        try(FileReader reader = new FileReader(DB_FILE)) {
            JSONParser parser = new JSONParser();
            JSONArray userStoryArray = (JSONArray) parser.parse(reader);

            for(Object userObj : userStoryArray) {
                JSONObject userStoryJson = (JSONObject) userStoryObj;
                int id = (int) userStoryJson.get("id");
                String name = (String) userStoryJson.get("name");
                String description = (String) userStoryJson.get("description");
                int storyPoints = (int) userStoryJson.get("story_points");
                int businessValue = (int) userStoryJson.get("business_value");
                userStories.add(new UserStory(id, name, description, storyPoints, businessValue));
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace(System.out);
        }
    }
    public void main(){
        List<UserStory> userStories = getUserStories();
    }
}