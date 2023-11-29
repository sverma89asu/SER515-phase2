package Helpers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

import scrum_sim_packages.LoginPage;
import scrum_sim_packages.SaveButtonReaction;
import scrum_sim_packages.SimulationSession;
import java.io.File;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ImportJSON {
    public static SimulationSession LoadSession(File file){
        ObjectMapper objectMapper = new ObjectMapper();
        SimulationSession sim = null;
        try {
            // Read JSON file and convert to Java object
            sim = objectMapper.readValue(file, SimulationSession.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sim;
    }
    public static ArrayList<SimulationSession> LoadSessions(String username){
        String folderPath = username;
        File folder = new File(folderPath);
        if (!folder.exists()){
            return new ArrayList<SimulationSession>();
        }
        File[] files = folder.listFiles();
        ArrayList<SimulationSession> simulationSessions = new ArrayList<>();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    simulationSessions.add(LoadSession(file));
                }
            }
        }

        return simulationSessions;
    }

}
