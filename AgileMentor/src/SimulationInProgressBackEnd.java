package AgileMentor.src;

import java.util.ArrayList;

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
	
	public ArrayList<String> calcSimulationParameters(String sessionName,String noOfsprints,String noOfteamMembers,String sprintVelocity,String sprintDuration)
	{
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
