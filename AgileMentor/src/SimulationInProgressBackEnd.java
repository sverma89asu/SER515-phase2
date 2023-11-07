package AgileMentor.src;


import AgileMentor.src.scrum_sim_packages.SimulationSession;
import AgileMentor.src.scrum_sim_packages.Sprint;
import AgileMentor.src.scrum_sim_packages.UserStory;
import AgileMentor.src.scrum_sim_packages.UserStoryModel;

import java.util.ArrayList;

import static java.lang.Long.parseLong;

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
	// Prints the items which are put
	// in a knapsack of capacity W
	static ArrayList<UserStory> printknapSack(int W, ArrayList<UserStory> pb, int n)
	{
		int i, w;
		int K[][] = new int[n + 1][W + 1];

		// Build table K[][] in bottom up manner
		for (i = 0; i <= n; i++) {
			for (w = 0; w <= W; w++) {
				if (i == 0 || w == 0)
					K[i][w] = 0;
				else if (pb.get(i-1).getStoryPoints() <= w)
					K[i][w] = (int) Math.max(pb.get(i-1).getBusinessValue() +
							K[i - 1][w - (int)pb.get(i-1).getStoryPoints()], K[i - 1][w]);
				else
					K[i][w] = K[i - 1][w];
			}
		}

		// stores the result of Knapsack
		int res = K[n][W];
		ArrayList<UserStory> sprintBacklog = new ArrayList<>();
		w = W;
		for (i = n; i > 0 && res > 0; i--) {
			if (res == K[i - 1][w])
				continue;
			else {

				// This item is included.
				System.out.println(pb.get(i-1).getDescription());
				sprintBacklog.add(pb.get(i-1));

				// Since this weight is included its
				// value is deducted
				res = (int) (res - pb.get(i-1).getBusinessValue());
				w = (int) (w - pb.get(i-1).getStoryPoints());
			}
		}
		return sprintBacklog;
	}
	public ArrayList<String> calcSimulationParameters(String sessionName,String noOfsprints,String noOfteamMembers,String sprintVelocity,String sprintDuration)
	{
		ArrayList<Sprint> sprints = new ArrayList<>();
		ArrayList<UserStory> productBacklog = UserStoryModel.getUserStories();
		SimulationSession simulationSession = new SimulationSession(sessionName, parseLong(sprintVelocity), parseLong(sprintDuration), parseLong(noOfsprints), parseLong(noOfteamMembers), sprints);
		for(int i = 0; i < parseLong(noOfsprints); i++){
			ArrayList<UserStory> sprintBacklog = printknapSack((int) simulationSession.getVelocity(), productBacklog, productBacklog.size());

		}

//		ArrayList<UserStory> sprintBacklog = printknapSack(simulationSession.getVelocity(), productBacklog, productBacklog.size());

		String sessionNameBE = sessionName;
		String noOfsprintsBE = noOfsprints;
		String noOfteamMembersBE = noOfteamMembers;
		String sprintVelocityBE = sprintVelocity;
		String sprintDurationBE = sprintDuration;
		ArrayList<String> sprintParametersBE = new ArrayList<String>();
		sprintParametersBE.add(sessionName);
		sprintParametersBE.add(noOfsprintsBE);
		sprintParametersBE.add(noOfteamMembersBE);
		sprintParametersBE.add(sprintVelocityBE);
		sprintParametersBE.add(sprintDurationBE);
		return sprintParametersBE ;
		
		
	}
	
	//SimulationInProgressPage frontendcalltoSIPP = new SimulationInProgressPage();
//	System.out.println("In SIPBE");
//	String sessionName = frontendcalltoSIPP.sessionName;
//	System.out.println(sessionName);
//	String noOfsprints = frontendcalltoSIPP.noOfsprints;
//	System.out.println(noOfsprints);
//	String noOfteamMembers = frontendcalltoSIPP.noOfteamMembers;
//	System.out.println(noOfteamMembers);
//	String sprintVelocity = frontendcalltoSIPP.sprintVelocity;
//	System.out.println(sprintVelocity);
//	String sprintDuration = frontendcalltoSIPP.sprintDuration;
//	System.out.println(sprintDuration);

}
