package scrum_sim_packages;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class InformationCardModel {
    private static final String DB_FILE = "InformationCard.json";
    public static ArrayList<InformationCard> getInformationCards() {
        ArrayList<InformationCard> informationCards = new ArrayList<>() ;
        try(FileReader reader = new FileReader(DB_FILE)) {
            JSONParser parser = new JSONParser();
            JSONArray userStoryArray = (JSONArray) parser.parse(reader);

            for(Object userStoryObj : userStoryArray) {
                JSONObject userStoryJson = (JSONObject) userStoryObj;
                long id = (long) userStoryJson.get("id");
                String name = (String) userStoryJson.get("name");
                String type = (String) userStoryJson.get("type");
                String description = (String) userStoryJson.get("description");
                double progress = (double) userStoryJson.get("progress");
                informationCards.add(new InformationCard(id, name, type, description, progress));
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace(System.out);
        }

        return informationCards;
    }
    public static void main(String[] args){
        ArrayList<InformationCard> informationCards = getInformationCards();
        for (int i = 0; i < informationCards.size(); i++) {
            InformationCard element = informationCards.get(i);
            System.out.println(element.getDescription());
            // You can now use 'i' to access the index.
        }
    }
}
