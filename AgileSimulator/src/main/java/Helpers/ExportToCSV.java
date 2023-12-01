package Helpers;

import scrum_sim_packages.*;
import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ExportToCSV {
    public static void convertToCSV(SimulationSession session, String csvFilePath) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(csvFilePath))) {
            // Write the header line for SimulationSession to the CSV file
            writeHeader(writer, SimulationSession.class);

            // Write the data for SimulationSession to the CSV file
            writeData(writer, session);

            // Write a blank line to separate SimulationSession and Sprint tables
            writer.writeNext(new String[0]);

            // Write tables for each Sprint
            int sprintNumber = 1;
            for (Sprint sprint : session.getSprints()) {
                // Temporary name for the Sprint
                String sprintName = "Sprint #" + sprintNumber;

                // Write the header line for Sprint to the CSV file
                writeHeader(writer, Sprint.class, "");

                // Write the data for each Sprint to the CSV file
                writeData(writer, sprint, sprintName);

                // Write a blank line to separate Sprint tables
                writer.writeNext(new String[0]);
                writer.writeNext(new String[]{"Product Backlog"});
                // Write the header line for Product Backlog
                writeHeader(writer, UserStory.class, "");
                for(UserStory productStories : sprint.getProductBacklog().getUserStories()) {
                    writeData(writer, productStories);
                }
                // Write a blank line to separate Product Backlog tables
                writer.writeNext(new String[0]);
                writer.writeNext(new String[]{"Sprint Backlog"});
                // Write the header line for Sprint Backlog
                writeHeader(writer, UserStory.class, "");
                for(UserStory sprintStories : sprint.getSprintBacklog().getUserStories()) {
                    writeData(writer, sprintStories);
                }
                // Write the data for Sprint Backlog
                writeData(writer, sprint.getSprintBacklog());

                // Write a blank line to separate Sprint Backlog tables
                writer.writeNext(new String[0]);

                sprintNumber++;
                writer.writeNext(new String[]{"Sprint Days"});
                writeHeader(writer, StandupDay.class);
                for(StandupDay standupDay : sprint.getStandupDays()) {
                    writeData(writer, standupDay);
                    writer.writeNext(new String[0]);
                    writeHeader(writer, StandupStoryProgress.class);
                    for(StandupStoryProgress progress : standupDay.getStandupStoryProgresses()) {
                        writeData(writer, progress);
                        writer.writeNext(new String[0]);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeHeader(CSVWriter writer, Class<?> clazz) {
        List<String> header = getFieldNames(clazz);
        writer.writeNext(header.toArray(new String[0]));
    }

    private static void writeData(CSVWriter writer, Object object) {
        if (object instanceof List<?> list) {
            // Handle the case where the object is a list (e.g., StandupDay.getStandupStoryProgresses())
            for (Object item : (List<?>) object) {
                writeData(writer, item);
                writer.writeNext(new String[0]);  // Add a blank line to separate list items
            }
        } else {
            // Handle the case where the object is a standalone object (e.g., StandupStoryProgress)
            List<String> fieldValues = getFieldValues(object);
            writer.writeNext(fieldValues.toArray(new String[0]));
        }
    }

    private static List<String> getFieldNames(Class<?> clazz) {
        List<String> fieldNames = new ArrayList<>();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            // Exclude fields that are lists
            if (!List.class.isAssignableFrom(field.getType())) {
                fieldNames.add(field.getName());
            }
        }
        return fieldNames;
    }
    private static void writeHeader(CSVWriter writer, Class<?> clazz, String headerPrefix) {
        List<String> header = getFieldNames(clazz, headerPrefix);
        writer.writeNext(header.toArray(new String[0]));
    }

    private static List<String> getFieldNames(Class<?> clazz, String headerPrefix) {
        List<String> fieldNames = new ArrayList<>();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            // Exclude fields that are lists
            if (!List.class.isAssignableFrom(field.getType())) {
                fieldNames.add(field.getName());
            }
        }
        return fieldNames;
    }

    private static List<String> getFieldValues(Object object) {
        List<String> fieldValues = new ArrayList<>();
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            // Exclude fields that are lists
            if (!List.class.isAssignableFrom(field.getType())) {
                field.setAccessible(true);
                try {
                    Object value = field.get(object);
                    if (value instanceof UserStory) {
                        fieldValues.add(((UserStory) value).getName());
                    } else if (value instanceof InformationCard) {
                        fieldValues.add(((InformationCard) value).getType());
                    }
                    else  {
                        fieldValues.add(value != null ? value.toString() : "");
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return fieldValues;
    }

    private static void writeData(CSVWriter writer, Object object, String sprintName) {
        List<String> fieldValues = new ArrayList<>();
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            // Exclude fields that are lists or of type Backlog
            if (!List.class.isAssignableFrom(field.getType()) && !field.getType().equals(Backlog.class)) {
                field.setAccessible(true);
                try {
                    // Use the temporary name for the Sprint
                    if (field.getName().equals("name")) {
                        fieldValues.add(sprintName);
                    } else {
                        Object value = field.get(object);
                        fieldValues.add(value != null ? value.toString() : "");
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        writer.writeNext(fieldValues.toArray(new String[0]));
    }
}
