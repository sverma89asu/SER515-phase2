package engine;

public class UserStory {

  private int id;
  private String title;
  private int storyPoints;
  private int businessValue;

  public UserStory(int id, String title, int storyPoints, int businessValue) {
    this.id = id;
    this.title = title;
    this.storyPoints = storyPoints;
    this.businessValue = businessValue;
  }

  public void displayDetails() {
    System.out.println("ID: " + id);
    System.out.println("Title: " + title);
    System.out.println("Story Points: " + storyPoints);
    System.out.println("Business Value: " + businessValue);
  }

  public int getBusinessValue() {
    return businessValue;
  }

  public int getStoryPoints() {
    return storyPoints;
  }

  // Getters and setters 

}