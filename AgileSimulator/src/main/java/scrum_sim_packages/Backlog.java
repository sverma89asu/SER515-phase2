package scrum_sim_packages;
import java.util.ArrayList;

public class Backlog {
    private ArrayList<UserStory> userStories;

    public Backlog(ArrayList<UserStory> userStories) {
        this.userStories = userStories;
    }

    public ArrayList<UserStory> getUserStories() {
        return userStories;
    }

    public void setUserStories(ArrayList<UserStory> userStories) {
        this.userStories = userStories;
    }
}
