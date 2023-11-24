package scrum_sim_packages;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Sprint {
    private long expectedBV;
    private double expectedSP;
    private long actualBV;
    private double actualSP;

    public long getExpectedBV() {
        return expectedBV;
    }

    public void setExpectedBV(long expectedBV) {
        this.expectedBV = expectedBV;
    }

    public double getExpectedSP() {
        return expectedSP;
    }

    public void setExpectedSP(double expectedSP) {
        this.expectedSP = expectedSP;
    }

    public long getActualBV() {
        return actualBV;
    }

    public void setActualBV(long actualBV) {
        this.actualBV = actualBV;
    }

    public double getActualSP() {
        return actualSP;
    }

    public void setActualSP(double actualSP) {
        this.actualSP = actualSP;
    }

    private Backlog productBacklog;
    private Backlog sprintBacklog;
    private ArrayList<StandupDay> standupDays;

    public Sprint(@JsonProperty("expectedBV") long expectedBV,@JsonProperty("expectedSP") double expectedSP,@JsonProperty("actualBV") long actualBV,@JsonProperty("actualSP") double actualSP,@JsonProperty("productBacklog") Backlog productBacklog,@JsonProperty("sprintBacklog") Backlog sprintBacklog,@JsonProperty("standupDays") ArrayList<StandupDay> standupDays) {
        this.expectedBV = expectedBV;
        this.expectedSP = expectedSP;
        this.actualBV = actualBV;
        this.actualSP = actualSP;
        this.productBacklog = productBacklog;
        this.sprintBacklog = sprintBacklog;
        this.standupDays = standupDays;
    }
    public Backlog getProductBacklog() {
        return productBacklog;
    }

    public void setProductBacklog(Backlog productBacklog) {
        this.productBacklog = productBacklog;
    }

    public Backlog getSprintBacklog() {
        return sprintBacklog;
    }

    public void setSprintBacklog(Backlog sprintBacklog) {
        this.sprintBacklog = sprintBacklog;
    }

    public ArrayList<StandupDay> getStandupDays() {
        return standupDays;
    }

    public void setStandupDays(ArrayList<StandupDay> standupDays) {
        this.standupDays = standupDays;
    }
}
