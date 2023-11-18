package AgileMentor.src.scrum_sim_packages;

import java.util.ArrayList;

public class SimulationSession {
    private String name;
    private long velocity;
    private long sprintDuration;
    private long numberOfSprints;
    private long teamSize;
    private ArrayList<Sprint> sprints;
    private String username;

    public SimulationSession(String name, long velocity, long sprintDuration, long numberOfSprints, long teamSize, ArrayList<Sprint> sprints, String username) {
        this.name = name;
        this.velocity = velocity;
        this.sprintDuration = sprintDuration;
        this.numberOfSprints = numberOfSprints;
        this.teamSize = teamSize;
        this.sprints = sprints;
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getVelocity() {
        return velocity;
    }

    public void setVelocity(long velocity) {
        this.velocity = velocity;
    }

    public long getSprintDuration() {
        return sprintDuration;
    }

    public void setSprintDuration(long sprintDuration) {
        this.sprintDuration = sprintDuration;
    }

    public long getNumberOfSprints() {
        return numberOfSprints;
    }

    public void setNumberOfSprints(long numberOfSprints) {
        this.numberOfSprints = numberOfSprints;
    }

    public long getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(long teamSize) {
        this.teamSize = teamSize;
    }
    public ArrayList<Sprint> getSprints() {
        return sprints;
    }

    public void setSprints(ArrayList<Sprint> sprints) {
        this.sprints = sprints;
    }

    public String getUsername(){
        return this.username;
    }

    public void setUsername(String username){
        this.username = username;
    }
}
