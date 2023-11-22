package AgileSimulator.src.main.java.tests;
import org.junit.jupiter.api.Test;
import AgileSimulator.src.main.java.scrum_sim_packages.*;
import java.util.ArrayList;
import static AgileSimulator.src.main.java.Helpers.ExportToJSON.SaveSession;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExportTOJSONTests {
    public ExportTOJSONTests(){

    }
    public SimulationSession CreateSample(){
        //Sample creation for test
        UserStory userStory1 = new UserStory(1, "Sample Story 1", "This is a sample user story 1", 3.5, 1000);
        UserStory userStory2 = new UserStory(2, "Sample Story 2", "This is a sample user story 2", 2.0, 800);

        ArrayList<UserStory> productBacklogUserStories = new ArrayList<>();
        productBacklogUserStories.add(userStory1);
        Backlog productBacklog = new Backlog(productBacklogUserStories);

        ArrayList<UserStory> sprintBacklogUserStories = new ArrayList<>();
        sprintBacklogUserStories.add(userStory2);
        Backlog sprintBacklog = new Backlog(sprintBacklogUserStories);

        InformationCard informationCard1 = new InformationCard(1, "Card 1", "Type A", "Description for Card 1", 0.5);
        InformationCard informationCard2 = new InformationCard(2, "Card 2", "Type B", "Description for Card 2", 0.7);

        StandupStoryProgress progress1 = new StandupStoryProgress(userStory1, informationCard1, "Good progress", 2.0, 800);
        StandupStoryProgress progress2 = new StandupStoryProgress(userStory2, informationCard2, "On track", 1.5, 600);

        ArrayList<StandupStoryProgress> standupStoryProgresses1 = new ArrayList<>();
        standupStoryProgresses1.add(progress1);
        StandupDay standupDay1 = new StandupDay(1, standupStoryProgresses1);

        ArrayList<StandupStoryProgress> standupStoryProgresses2 = new ArrayList<>();
        standupStoryProgresses2.add(progress2);
        StandupDay standupDay2 = new StandupDay(2, standupStoryProgresses2);

        ArrayList<StandupDay> standupDays = new ArrayList<>();
        standupDays.add(standupDay1);
        standupDays.add(standupDay2);

        Sprint sprint1 = new Sprint(10000, 35.0, 9500, 30.0, productBacklog, sprintBacklog, standupDays);

        ArrayList<Sprint> sprints = new ArrayList<>();
        sprints.add(sprint1);

        SimulationSession simulationSession = new SimulationSession("Sample Session", 30, 14, 5, 6, sprints,"user");
        SimulationSession simulationSession2 = new SimulationSession("Sample Session2", 30, 14, 5, 6, sprints,"user2");
        SimulationSession simulationSession3 = new SimulationSession("Sample Session3", 30, 14, 5, 6, sprints,"user23");
        return simulationSession3;

    }
    @Test
    void testFileSaveNoName()
    {
        SimulationSession testSession=CreateSample();
        String fileName="";
        assertEquals(false,SaveSession(fileName, testSession));

    }
    @Test
    void testFileSaveSpecialCharacter()
    {
        SimulationSession testSession=CreateSample();
        String fileName="//!@#$%^&*()_+{}[];'./,.<>?|";
        assertEquals(false,SaveSession(fileName, testSession));

    }
    @Test
    void testFileSaveUsername()
    {
        SimulationSession testSession=CreateSample();
        String fileName="username";
        assertEquals(true,SaveSession(fileName, testSession));

    }
    @Test
    void testFileSaveUsername1()
    {
        SimulationSession testSession=CreateSample();
        String fileName="username1";
        assertEquals(true,SaveSession(fileName, testSession));

    }
    @Test
    void testFileSaveUsername_1()
    {
        SimulationSession testSession=CreateSample();
        String fileName="user_1";
        assertEquals(true,SaveSession(fileName, testSession));

    }
    @Test
    void testFileSaveALL()
    {
        SimulationSession testSession=CreateSample();
        assertAll("Combining all zero test",
                ()->assertEquals(false,SaveSession("", testSession), "Test for fileName = "),
                ()->assertEquals(false,SaveSession("//!@#$%^&*()_+{}[];'./,.<>?|", testSession), "Test for fileName = //!@#$%^&*()_+{}[];'./,.<>?|"),
                ()->assertEquals(true,SaveSession("username", testSession), "Test for fileName = username"),
                ()->assertEquals(true,SaveSession("user1", testSession), "Test for fileName = user1"),
                ()->assertEquals(true,SaveSession("user_1", testSession), "Test for fileName = user_1")
        );
    }
}
