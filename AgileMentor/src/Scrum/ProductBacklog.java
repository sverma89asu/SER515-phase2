package AgileMentor.src.Scrum;

import AgileMentor.src.UserStory;
import AgileMentor.src.UserStoryModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProductBacklog {
    private List<UserStory> userStories = new ArrayList<>();

    public ProductBacklog() {
        userStories = new ArrayList<>();

        // Get stories from model
        List<UserStory> loadedStories = UserStoryModel.getUserStories();

        // Add to backlog
        userStories.addAll(loadedStories);
    }

    public void displayUserStories() {
        for (UserStory story : userStories) {
            story.displayDetails();
            System.out.println();
        }
    }

    public void generateUserStories() {
        for (int i = 0; i < 10; i++) {
            int storyPoints = (int) (Math.random() * 20) + 1;
            int businessValue = (int) (Math.random() * 100) + 1;

            UserStory story = new UserStory(i, "Story " + i,"", storyPoints, businessValue);
            userStories.add(story);
        }
    }
    public void order() {
        Collections.sort(userStories, new Comparator<UserStory>() {
            @Override
            public int compare(UserStory s1, UserStory s2) {
                double ratio1 = (double) s1.getBusinessValue() / s1.getStoryPoints();
                double ratio2 = (double) s2.getBusinessValue() / s2.getStoryPoints();

                if (ratio1 > ratio2) {
                    return -1;
                } else if (ratio1 < ratio2) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
    }
    public void addStory(UserStory story) {
        userStories.add(story);
    }

    public void removeStory(UserStory story) {
        userStories.remove(story);
    }

    public List<UserStory> getStories() {
        return userStories;
    }

}



