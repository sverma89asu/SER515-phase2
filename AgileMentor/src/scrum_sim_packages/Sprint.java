package AgileMentor.src.scrum_sim_packages;

import java.util.ArrayList;

public class Sprint {
    private Backlog productBacklog;
    private Backlog sprintBacklog;
    private ArrayList<StandupDay> standupDays;

    public Sprint(Backlog productBacklog, Backlog sprintBacklog, ArrayList<StandupDay> standupDays) {
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
