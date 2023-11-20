package test;

import static org.junit.jupiter.api.Assertions.*;

import scrum_sim_packages.UserStory;
import scrum_sim_packages.UserStoryModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scrum_sim_packages.UserStory;
import scrum_sim_packages.UserStoryModel;

import java.util.ArrayList;

public class UserStoryModelTest {

    @BeforeEach
    void setUp() {

    }

    @Test
    void testGetUserStories(){
        ArrayList<UserStory> userStoryList = UserStoryModel.getUserStories();
        for(int i = 0; i < userStoryList.size(); i++){
            assertEquals(i+1,userStoryList.get(i).getId());
        }
    }

}
