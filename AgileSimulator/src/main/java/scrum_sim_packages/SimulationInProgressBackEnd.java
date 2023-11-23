package scrum_sim_packages;

import java.util.ArrayList;
import java.util.Random;

import static java.lang.Long.parseLong;
import static java.lang.Math.min;

public class SimulationInProgressBackEnd
{

	public static String sessionName;
	public static String noOfsprints;
	public static String noOfteamMembers;
	public static String sprintVelocity;
	public static String sprintDuration;	
	
	public static void main(String[] args)
	{
		
	}

	static void removeSprintStoriesFromProductBacklog(ArrayList<UserStory>productBacklog, ArrayList<UserStory>sprintBacklog){
		int itr = 0;
		boolean isChanged = false;
		while(itr < productBacklog.size()){
			isChanged = false;
			for(UserStory us: sprintBacklog) {
				if(itr >= productBacklog.size()){
					break;
				}
				if (productBacklog.get(itr).getId() == us.getId()) {
					productBacklog.remove(itr);
					isChanged = true;
				}
			}
			if(!isChanged){
				itr++;
			}
		}
	}
	// Prints the items which are put
	// in a knapsack of capacity W
	static ArrayList<UserStory> printknapSack(int W, ArrayList<UserStory> productBacklog, int n, Sprint currentSprint)
	{
		int i, w;
		int K[][] = new int[n + 1][W + 1];

		// Build table K[][] in bottom up manner
		for (i = 0; i <= n; i++) {
			for (w = 0; w <= W; w++) {
				if (i == 0 || w == 0)
					K[i][w] = 0;
				else if (productBacklog.get(i-1).getStoryPoints() <= w)
					K[i][w] = (int) Math.max(productBacklog.get(i-1).getBusinessValue() +
							K[i - 1][w - (int)productBacklog.get(i-1).getStoryPoints()], K[i - 1][w]);
				else
					K[i][w] = K[i - 1][w];
			}
		}

		// stores the result of Knapsack
		int res = K[n][W];
		currentSprint.setExpectedBV(res);
		ArrayList<UserStory> sprintBacklog = new ArrayList<>();
		w = W;
		for (i = n; i > 0 && res > 0; i--) {
			if (res == K[i - 1][w])
				continue;
			else {
				sprintBacklog.add(productBacklog.get(i-1));


				// Since this weight is included its
				// value is deducted
				res = (int) (res - productBacklog.get(i-1).getBusinessValue());
				w = (int) (w - productBacklog.get(i-1).getStoryPoints());
			}
		}
		return sprintBacklog;
	}
	public SimulationSession calcSimulationParameters(String sessionName,String noOfsprints,String noOfteamMembers,String sprintVelocity,String sprintDuration)
	{
		System.out.println("New simulation!");
		Random rndm = new Random();
		ArrayList<Sprint> sprints = new ArrayList<>();
		ArrayList<UserStory> productBacklog = UserStoryModel.getUserStories();
		ArrayList<InformationCard> informationCards = InformationCardModel.getInformationCards();
		SimulationSession simulationSession = new SimulationSession(sessionName, parseLong(sprintVelocity), parseLong(sprintDuration), parseLong(noOfsprints), parseLong(noOfteamMembers), sprints, LoginPage.loggedInUser);
		for(int i = 0; i < parseLong(noOfsprints); i++){
			Sprint currentSprint = new Sprint(0,parseLong(sprintVelocity),0,0,null, null, null);
			ArrayList<UserStory> sprintBacklog = printknapSack((int) simulationSession.getVelocity(), productBacklog, productBacklog.size(), currentSprint);
			removeSprintStoriesFromProductBacklog(productBacklog, sprintBacklog);
			ArrayList<UserStory> currentProductBacklog = new ArrayList<>(productBacklog);
			ArrayList<UserStory> currentSprintBacklog = new ArrayList<>(sprintBacklog);
			currentSprint.setProductBacklog(new Backlog(currentProductBacklog));
			currentSprint.setSprintBacklog(new Backlog(currentSprintBacklog));
			long numStories = sprintBacklog.size();
			long numEmployees = simulationSession.getTeamSize();
			long freeEmployees = numEmployees - min(numEmployees, numStories);
			long currentNumberOfStories = min(numEmployees, numStories);
			long remainingBV = currentSprint.getExpectedBV();
			double remainingSP = currentSprint.getExpectedSP();
			ArrayList<StandupDay> standupDays = new ArrayList<>();
			for (int j = 0; j < simulationSession.getSprintDuration(); j++){
				StandupDay standupDay = new StandupDay(j+1, null);
				ArrayList<StandupStoryProgress> standupStoryProgresses = new ArrayList<>();
				int k = 0;
				while (k < min(currentNumberOfStories, sprintBacklog.size())){
					InformationCard currentCard = informationCards.get(rndm.nextInt(informationCards.size()));
					StandupStoryProgress currentStandupStoryProgress = new StandupStoryProgress(sprintBacklog.get(k), currentCard, "Good Job", sprintBacklog.get(k).getStoryPoints(), sprintBacklog.get(k).getBusinessValue());
					if(currentCard.getType().equals("Progress")){
						remainingSP -= (sprintBacklog.get(k).getStoryPoints()*currentCard.getProgress())/100.00;
						sprintBacklog.get(k).setStoryPoints(sprintBacklog.get(k).getStoryPoints()*(1-currentCard.getProgress()/100.00));
						if(currentCard.getProgress() == 100.0){
							remainingBV -= sprintBacklog.get(k).getBusinessValue();
							currentSprint.setActualBV(currentSprint.getActualBV()+sprintBacklog.get(k).getBusinessValue());
							sprintBacklog.get(k).setBusinessValue(0);
							sprintBacklog.remove(k);
							freeEmployees++;
						}
						else{
							k++;
						}
					}
					else{
						if(freeEmployees > 0){
							currentStandupStoryProgress.setResponse("Resolved");
							freeEmployees--;
							k++;
						}
						else{
							currentStandupStoryProgress.setResponse("Blocked");
							sprintBacklog.add(sprintBacklog.get(k));
							sprintBacklog.remove(k);
						}
					}
					currentStandupStoryProgress.setRemainingStoryPoints(remainingSP);
					currentStandupStoryProgress.setRemainingBusinessValue(remainingBV);
					standupStoryProgresses.add(currentStandupStoryProgress);
				}
				standupDay.setStandupStoryProgresses(standupStoryProgresses);
				standupDays.add(standupDay);
			}
			currentSprint.setStandupDays(standupDays);
			currentSprint.setActualSP(currentSprint.getExpectedSP()-remainingSP);
			sprints.add(currentSprint);
			ArrayList<UserStory> userStories = UserStoryModel.getUserStories();
			for (UserStory us: sprintBacklog){
				productBacklog.add(userStories.get((int) (us.getId()-1)));
			}
		}
		simulationSession.setSprints(sprints);
		return simulationSession;
	}

}
