package AgileMentor.src.Scrum;

import AgileMentor.src.UserStory;
import AgileMentor.src.UserStoryModel;

import java.util.ArrayList;
import java.util.List;

public class ProductBacklog {
    private List<UserStory> stories;

    public ProductBacklog() {
        stories = new ArrayList<>();

        // Get stories from model
        List<UserStory> loadedStories = UserStoryModel.getUserStories();

        // Add to backlog
        stories.addAll(loadedStories);
    }

    public void addStory(UserStory story) {
        stories.add(story);
    }

    public void removeStory(UserStory story) {
        stories.remove(story);
    }

    public List<UserStory> getStories() {
        return stories;
    }

}



