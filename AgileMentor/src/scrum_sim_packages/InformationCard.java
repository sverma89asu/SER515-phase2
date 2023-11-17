package AgileMentor.src.scrum_sim_packages;
public class InformationCard {

    private long id;

    private String name;

    private String type;
    private String description;

    private double progress;


    public InformationCard(long id, String name, String type, String description, double progress) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.description = description;
        this.progress = progress;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getProgress() {
        return progress;
    }

    public void setProgress(double progress) {
        this.progress = progress;
    }
}