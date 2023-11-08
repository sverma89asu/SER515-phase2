package AgileMentor.src.Helpers;

import AgileMentor.src.scrum_sim_packages.SimulationSession;
import AgileMentor.src.scrum_sim_packages.Sprint;
import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ExportToCSV {
    public static void convertToCSV(SimulationSession session, String csvFilePath) {
        // Get the field names from the class using reflection
        try (CSVWriter writer = new CSVWriter(new FileWriter(csvFilePath)) ) {
            // Get the field names from the class using reflection
            List<String> header = getFieldNames(session.getClass());
            // Write the header line to the CSV file
            writer.writeNext(header.toArray(new String[0]));

            // Get the field values and write them to the CSV file
            List<String> data = getFieldValues(session);
            writer.writeNext(data.toArray(new String[0]));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static List<String> getFieldNames(Class<?> clazz) {
        List<String> fieldNames = new ArrayList<>();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            // Add field names to the list
            fieldNames.add(field.getName());
        }
        return fieldNames;
    }
    //private static String[] flattenObject(Object data) {

    //}
    private static List<String> getFieldValues(SimulationSession session) {
        List<String> fieldValues = new ArrayList<>();
        Field[] fields = session.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                // Get the field values and add them to the list
                Object value = field.get(session);
                fieldValues.add(value != null ? value.toString() : "");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return fieldValues;
    }
    public static void main(String[] args) {
        ArrayList<Sprint> sprints = new ArrayList<>();
        SimulationSession session = new SimulationSession("Example Session", 10, 14, 5, 6, sprints);
        String csvFilePath = "output.csv";
        convertToCSV(session, csvFilePath);
    }
}
