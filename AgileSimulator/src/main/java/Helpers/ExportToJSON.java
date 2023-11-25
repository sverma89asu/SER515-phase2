package Helpers;

import scrum_sim_packages.SaveButtonReaction;
import scrum_sim_packages.SimulationSession;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;


import java.io.File;
public class ExportToJSON {
    // The function will take the file name and save a json file in
    public static void SaveSessionFunction(String fileName, SimulationSession session){
        String folderPath = fileName;

        // Create a File object representing the folder
        File folder = new File(folderPath);

        // Use the mkdir() method to create the folder
        boolean success = folder.mkdir();

        if (success) {
            //File is created
        } else {
            //File already exists
        }
        String filePath = fileName+"/"+fileName+".json";
        File saveJson = new File(filePath);
        String fileSaveName = fileName+"/"+fileName;
        int saveCounter = 1;
        boolean ifExisting = saveJson.exists() && !saveJson.isDirectory();
        while (ifExisting == true){
            String filePathExtend=Integer.toString(saveCounter);
            filePath = fileName+"/"+fileName+"_"+filePathExtend+".json";
            saveJson = new File(filePath);
            ifExisting = saveJson.exists() && !saveJson.isDirectory();
            fileSaveName = fileName+"/"+fileName +"_"+filePathExtend;
        }
        new SaveButtonReaction(SaveSession(fileSaveName, session),0);
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
