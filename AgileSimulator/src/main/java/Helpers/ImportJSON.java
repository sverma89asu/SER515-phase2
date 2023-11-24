package Helpers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

import scrum_sim_packages.LoginPage;
import scrum_sim_packages.SaveButtonReaction;
import scrum_sim_packages.SimulationSession;
import java.io.File;

import java.io.IOException;
public class ImportJSON {
    public static SimulationSession LoadSession(String fileName){
        ObjectMapper objectMapper = new ObjectMapper();
        SimulationSession sim = null;
        try {
            File file = new File(fileName);

            // Read JSON file and convert to Java object
            sim = objectMapper.readValue(file, SimulationSession.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sim;
    }
}
