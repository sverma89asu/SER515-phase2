package AgileMentor.src;

import org.json.simple.JSONObject;

import java.util.HashMap;

// This tells Hibernate to make a table out of this class
public class UserStory {

    private int id;

    private String name;

    private String description;

    private int storyPoints;

    private int businessValue;

    public UserStory(int id, String name, String description, int storyPoints, int businessValue) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.storyPoints = storyPoints;
        this.businessValue = businessValue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getStoryPoints() {
        return storyPoints;
    }

    public void setStoryPoints(int storyPoints) {
        this.storyPoints = storyPoints;
    }

    public int getBusinessValue() {
        return businessValue;
    }

    public void setBusinessValue(int businessValue) {
        this.businessValue = businessValue;
    }
}
