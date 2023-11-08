package AgileMentor.src.Helpers;

import AgileMentor.src.scrum_sim_packages.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExportToJSON {
    public static void main(String[] args){
        //Sample creation for test
        UserStory userStory1 = new UserStory(1, "Sample Story 1", "This is a sample user story 1", 3.5, 1000);
        UserStory userStory2 = new UserStory(2, "Sample Story 2", "This is a sample user story 2", 2.0, 800);

        ArrayList<UserStory> productBacklogUserStories = new ArrayList<>();
        productBacklogUserStories.add(userStory1);
        Backlog productBacklog = new Backlog(productBacklogUserStories);

        ArrayList<UserStory> sprintBacklogUserStories = new ArrayList<>();
        sprintBacklogUserStories.add(userStory2);
        Backlog sprintBacklog = new Backlog(sprintBacklogUserStories);

        InformationCard informationCard1 = new InformationCard(1, "Card 1", "Type A", "Description for Card 1", 0.5);
        InformationCard informationCard2 = new InformationCard(2, "Card 2", "Type B", "Description for Card 2", 0.7);

        StandupStoryProgress progress1 = new StandupStoryProgress(userStory1, informationCard1, "Good progress", 2.0, 800);
        StandupStoryProgress progress2 = new StandupStoryProgress(userStory2, informationCard2, "On track", 1.5, 600);

        ArrayList<StandupStoryProgress> standupStoryProgresses1 = new ArrayList<>();
        standupStoryProgresses1.add(progress1);
        StandupDay standupDay1 = new StandupDay(1, standupStoryProgresses1);

        ArrayList<StandupStoryProgress> standupStoryProgresses2 = new ArrayList<>();
        standupStoryProgresses2.add(progress2);
        StandupDay standupDay2 = new StandupDay(2, standupStoryProgresses2);

        ArrayList<StandupDay> standupDays = new ArrayList<>();
        standupDays.add(standupDay1);
        standupDays.add(standupDay2);

        Sprint sprint1 = new Sprint(10000, 35.0, 9500, 30.0, productBacklog, sprintBacklog, standupDays);

        ArrayList<Sprint> sprints = new ArrayList<>();
        sprints.add(sprint1);

        SimulationSession simulationSession = new SimulationSession("Sample Session", 30, 14, 5, 6, sprints,"user");
        SimulationSession simulationSession2 = new SimulationSession("Sample Session2", 30, 14, 5, 6, sprints,"user2");
        SimulationSession simulationSession3 = new SimulationSession("Sample Session3", 30, 14, 5, 6, sprints,"user23");

        ArrayList<SimulationSession> ses=new ArrayList<>();
        ArrayList<SimulationSession> ses2=new ArrayList<>();
        ses.add(simulationSession);
        ses.add(simulationSession2);
        ses2.add(simulationSession3);
        //ses.add();
        //boolean check = SaveJSON("file",ses);
        //System.out.println(check);
        //boolean check1 = SaveJSON("file",ss);
        boolean check = SaveSession("file",simulationSession);
        System.out.println(check);


    }
    // The function will take the file name and save a json file in

    public static boolean SaveSession(String fileName, SimulationSession session){
        boolean check = false;
        String path_fileName="AgileMentor/src/Database/"+fileName+".json";
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            ObjectWriter objectWriter = objectMapper.writerWithDefaultPrettyPrinter();
            objectWriter.writeValue(new File(path_fileName), session);
            check=true;
            return check;
        } catch (Exception e) {
            e.printStackTrace();
            return check;
        }

    }



}
