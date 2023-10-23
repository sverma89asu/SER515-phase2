/*package engine;

import java.util.ArrayList;
import java.util.List;

public class ScrumSimulator {

  private int teamSize;
  private int sprintDuration; // in weeks
  private int velocity; // story points per sprint
  private int numSprints;
  private List<Sprint> sprints;
  
  public ScrumSimulator(int teamSize, int sprintDuration, int velocity, int numSprints) {
    this.teamSize = teamSize;
    this.sprintDuration = sprintDuration; 
    this.velocity = velocity;
    this.numSprints = numSprints;
    this.sprints = new ArrayList<>();
  }

  public void simulate() {
    // Generate backlog
    Backlog backlog = new Backlog();
    backlog.generateUserStories();
    
    // Run sprints
    for (int i = 0; i < numSprints; i++) {
      Sprint sprint = new Sprint(sprintDuration, velocity);
      sprint.selectUserStories(backlog);
      sprint.run();
      sprints.add(sprint);
    }
  }

  public void printMetrics() {
    // Print number of user stories completed
    int totalCompleted = 0;
    for (Sprint sprint : sprints) {
      totalCompleted += sprint.getNumUserStoriesCompleted();
    }
    System.out.println("Total User Stories Completed: " + totalCompleted);

    // Print total business value gained
    int totalValue = 0;
    for (Sprint sprint : sprints) {
      totalValue += sprint.getBusinessValue();
    }
    System.out.println("Total Business Value Gained: " + totalValue);
    
    // Print burndown chart for each sprint
  }
  
  public static void main(String[] args) {
    ScrumSimulator simulator = new ScrumSimulator(5, 2, 20, 5); 
    simulator.simulate();
    simulator.printMetrics();
  }

}

class Sprint {

  // Sprint logic

}

class Backlog {
  
  // Backlog logic
  
}
*/