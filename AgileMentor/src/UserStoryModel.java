package AgileMentor.src;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class UserStoryModel {
    private static final String DB_FILE = "UserStories.json";
    public List<UserStory> getUserStories() {
        List<UserStory> userStories = new List<UserStory>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<UserStory> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(UserStory userStory) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends UserStory> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends UserStory> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public UserStory get(int index) {
                return null;
            }

            @Override
            public UserStory set(int index, UserStory element) {
                return null;
            }

            @Override
            public void add(int index, UserStory element) {

            }

            @Override
            public UserStory remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<UserStory> listIterator() {
                return null;
            }

            @Override
            public ListIterator<UserStory> listIterator(int index) {
                return null;
            }

            @Override
            public List<UserStory> subList(int fromIndex, int toIndex) {
                return null;
            }
        };
        try(FileReader reader = new FileReader(DB_FILE)) {
            JSONParser parser = new JSONParser();
            JSONArray userStoryArray = (JSONArray) parser.parse(reader);

            for(Object userStoryObj : userStoryArray) {
                JSONObject userStoryJson = (JSONObject) userStoryObj;
                int id = (int) userStoryJson.get("id");
                String name = (String) userStoryJson.get("name");
                String description = (String) userStoryJson.get("description");
                int storyPoints = (int) userStoryJson.get("story_points");
                int businessValue = (int) userStoryJson.get("business_value");
                userStories.add(new UserStory(id, name, description, storyPoints, businessValue));
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace(System.out);
        }

        return userStories;
    }
    public void main(){
        List<UserStory> userStories = getUserStories();
    }
}