package AgileMentor.src.scrum_sim_packages;

import java.util.ArrayList;

public class StandupDay {
    private long day;
    private ArrayList<StandupStoryProgress> standupStoryProgresses;

    public StandupDay(long day, ArrayList<StandupStoryProgress> standupStoryProgresses) {
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
