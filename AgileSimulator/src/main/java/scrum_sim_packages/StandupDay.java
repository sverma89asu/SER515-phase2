package scrum_sim_packages;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class StandupDay {
    private long day;
    private ArrayList<StandupStoryProgress> standupStoryProgresses;

    public StandupDay(@JsonProperty("day") long day,@JsonProperty("standupStoryProgresses") ArrayList<StandupStoryProgress> standupStoryProgresses) {
        this.day = day;
        this.standupStoryProgresses = standupStoryProgresses;
    }

    public long getDay() {
        return day;
    }

    public void setDay(long day) {
        this.day = day;
    }

    public ArrayList<StandupStoryProgress> getStandupStoryProgresses() {
        return standupStoryProgresses;
    }

    public void setStandupStoryProgresses(ArrayList<StandupStoryProgress> standupStoryProgresses) {
        this.standupStoryProgresses = standupStoryProgresses;
    }
}
