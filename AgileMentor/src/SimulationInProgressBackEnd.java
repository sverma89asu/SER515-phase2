 

public class SimulationInProgressBackEnd
{

	public static String sessionName;
	public static String noOfsprints;
	public static String noOfteamMembers;
	public static String sprintVelocity;
	public static String sprintDuration;	
	
	public static void main(String[] args)
	{
		SimulationInProgressPage frontendcalltoSIPP = new SimulationInProgressPage();
		System.out.println("In SIPBE");
		String sessionName = frontendcalltoSIPP.sessionName;
		System.out.println(sessionName);
		String noOfsprints = frontendcalltoSIPP.noOfsprints;
		System.out.println(noOfsprints);
		String noOfteamMembers = frontendcalltoSIPP.noOfteamMembers;
		System.out.println(noOfteamMembers);
		String sprintVelocity = frontendcalltoSIPP.sprintVelocity;
		System.out.println(sprintVelocity);
		String sprintDuration = frontendcalltoSIPP.sprintDuration;
		System.out.println(sprintDuration);

	}

}
