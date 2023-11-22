package AgileSimulator.src.main.java.Helpers;

import AgileSimulator.src.main.java.scrum_sim_packages.SaveButtonReaction;
import AgileSimulator.src.main.java.scrum_sim_packages.SimulationSession;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;


import java.io.File;
public class ExportToJSON {
    // The function will take the file name and save a json file in
    public static void SaveSessionFunction(String fileName, SimulationSession session){
        new SaveButtonReaction(SaveSession(fileName, session),0);
    }
    public static boolean SaveSession(String fileName, SimulationSession session){
        String pathFileName= fileName+".json";
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            if(fileName.equals("")){
                throw new Exception("File name not defined");
            }
            ObjectWriter objectWriter = objectMapper.writerWithDefaultPrettyPrinter();
            objectWriter.writeValue(new File(pathFileName), session);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
}
