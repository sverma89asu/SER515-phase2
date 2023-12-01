package scrum_sim_packages;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;

public class Backlog {
    private ArrayList<UserStory> userStories;

    public Backlog(@JsonProperty("userStories") ArrayList<UserStory> userStories) {
        this.userStories = userStories;
    }

    public ArrayList<UserStory> getUserStories() {
        return userStories;
    }

    public void setUserStories(ArrayList<UserStory> userStories) {
        this.userStories = userStories;
    }
}
