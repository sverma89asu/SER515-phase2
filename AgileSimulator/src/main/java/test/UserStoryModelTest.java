package AgileSimulator.src.main.java.test;

import static org.junit.jupiter.api.Assertions.*;
import AgileSimulator.src.main.java.scrum_sim_packages.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
