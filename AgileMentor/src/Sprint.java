package AgileMentor.src;

import AgileMentor.src.Scrum.ProductBacklog;
import AgileMentor.src.Scrum.SprintBacklog;

import java.util.ArrayList;
import java.util.List;

public class Sprint {
    int teamSize;
    int sprintDuration;
    int velocity;
    SprintBacklog sprintBacklog;
    public Sprint(int sprintDuration, int velocity, int teamSize, ProductBacklog productBacklog) {
        this.teamSize = teamSize;
        this.sprintDuration = sprintDuration;
        this.velocity = velocity;
        sprintBacklog = new SprintBacklog(velocity);
        createSprintBacklog(productBacklog);
    }
    public void createSprintBacklog(ProductBacklog productBacklog) {
        List<UserStory> userStories = productBacklog.getStories(); // Assuming you have a method to get user stories from the product backlog

        // Implement the knapsack algorithm to select user stories based on sprint velocity
        List<UserStory> selectedUserStories = selectUserStories(userStories);

        // Add selected user stories to the sprint backlog
        sprintBacklog.addAllUserStories(selectedUserStories);
    }
    private List<UserStory> selectUserStories(List<UserStory> userStories) {
        List<UserStory> selectedUserStories = new ArrayList<>();

        // Implement the knapsack algorithm here to select user stories
        // while ensuring the total story points do not exceed the sprint velocity

        int[][] dp = new int[userStories.size() + 1][velocity + 1];

        for (int i = 1; i <= userStories.size(); i++) {
            UserStory story = userStories.get(i - 1);
            for (int j = 0; j <= velocity; j++) {
                if (story.getStoryPoints() > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - story.getStoryPoints()] + story.getStoryPoints());
                }
            }
        }

        int remainingVelocity = velocity;

        for (int i = userStories.size(); i > 0 && remainingVelocity > 0; i--) {
            if (dp[i][remainingVelocity] != dp[i - 1][remainingVelocity]) {
                UserStory story = userStories.get(i - 1);
                selectedUserStories.add(story);
                remainingVelocity -= story.getStoryPoints();
            }
        }

        return selectedUserStories;
    }
    public int getBusinessValue() {
      return 0;
    }
  
    public int getNumUserStoriesCompleted() {
      return 0;
    }
  
    public void run() {
    }
  
    public void selectUserStories(ProductBacklog backlog) {
    }
  
    // Sprint logic  
}
