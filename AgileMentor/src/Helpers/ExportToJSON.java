package AgileMentor.src.Helpers;

import AgileMentor.src.scrum_sim_packages.*;
import AgileMentor.src.tests.ExportTOJSONTests;
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
    // The function will take the file name and save a json file in
    public static void SaveSessionFunction(String fileName, SimulationSession session){
        new SaveButtonReaction(SaveSession(fileName, session),0);
    }
    public static boolean SaveSession(String fileName, SimulationSession session){
        String path_fileName="AgileMentor/src/Database/"+fileName+".json";
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            if(fileName.equals("")){
                throw new Exception("File name not defined");
            }
            ObjectWriter objectWriter = objectMapper.writerWithDefaultPrettyPrinter();
            objectWriter.writeValue(new File(path_fileName), session);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
}
