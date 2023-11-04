package AgileMentor.src.Scrum;

import AgileMentor.src.UserStory;

import java.util.ArrayList;
import java.util.List;

public class SprintBacklog {
    private List<UserStory> stories;
    private int capacity; // max stories based on velocity

    public SprintBacklog(int capacity) {
        this.capacity = capacity;
        stories = new ArrayList<>();
    }

    public void addStory(UserStory story) {
        if(stories.size() < capacity) {
            stories.add(story);
        } else {
            // Sprint backlog full
        }
    }

    public void removeStory(UserStory story) {
        stories.remove(story);
    }

    public List<UserStory> getStories() {
        return stories;
    }

    public int getCapacity() {
        return capacity;
    }

    public void addAllUserStories(List<UserStory> selectedUserStories) {
        stories = selectedUserStories;
    }
}
