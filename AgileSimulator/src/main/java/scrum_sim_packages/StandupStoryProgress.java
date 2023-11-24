package scrum_sim_packages;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StandupStoryProgress {
    private UserStory userStory;
    private InformationCard informationCard;
    private String response;
    private double remainingStoryPoints;
    private long remainingBusinessValue;

    public StandupStoryProgress(@JsonProperty("userStory") UserStory userStory,@JsonProperty("informationCard") InformationCard informationCard,@JsonProperty("response") String response,@JsonProperty("remainingStoryPoints") double remainingStoryPoints,@JsonProperty("remainingBusinessValue") long remainingBusinessValue) {
        this.userStory = userStory;
        this.informationCard = informationCard;
        this.response = response;
        this.remainingStoryPoints = remainingStoryPoints;
        this.remainingBusinessValue = remainingBusinessValue;
    }

    public UserStory getUserStory() {
        return userStory;
    }

    public void setUserStory(UserStory userStory) {
        this.userStory = userStory;
    }

    public InformationCard getInformationCard() {
        return informationCard;
    }

    public void setInformationCard(InformationCard informationCard) {
        this.informationCard = informationCard;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public double getRemainingStoryPoints() {
        return remainingStoryPoints;
    }

    public void setRemainingStoryPoints(double remainingStoryPoints) {
        this.remainingStoryPoints = remainingStoryPoints;
    }

    public long getRemainingBusinessValue() {
        return remainingBusinessValue;
    }

    public void setRemainingBusinessValue(long remainingBusinessValue) {
        this.remainingBusinessValue = remainingBusinessValue;
    }
}
