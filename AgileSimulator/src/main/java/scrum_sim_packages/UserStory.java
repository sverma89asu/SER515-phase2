package AgileSimulator.src.main.java.scrum_sim_packages;

import org.json.simple.JSONObject;

import java.util.HashMap;

// This tells Hibernate to make a table out of this class
public class UserStory {

    private long id;

    private String name;

    private String description;

    private double storyPoints;

    private long businessValue;

    public UserStory(long id, String name, String description, double storyPoints, long businessValue) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.storyPoints = storyPoints;
        this.businessValue = businessValue;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getStoryPoints() {
        return storyPoints;
    }

    public void setStoryPoints(double storyPoints) {
        this.storyPoints = storyPoints;
    }

    public long getBusinessValue() {
        return businessValue;
    }

    public void setBusinessValue(long businessValue) {
        this.businessValue = businessValue;
    }
}