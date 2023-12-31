package scrum_sim_packages;
import CreateSimulation.*;
import Helpers.ExportToCSV;
import com.opencsv.CSVWriter;
import tests.ExportTOJSONTests;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import static Helpers.ExportToCSV.convertToCSV;
import static Helpers.ExportToJSON.SaveSessionFunction;
import java.awt.Dimension;
import java.io.FileWriter;
import java.io.IOException;

public class SimulationInProgressPage extends JFrame {

	private static final long serialVersionUID = 1L;
	public JFrame frame;
	public static String sessionName;
	public static String noOfsprints;
	public static String noOfteamMembers;
	public static String sprintVelocity;
	public static String sprintDuration;
	public static String sessionNameBE;
	public static String noOfsprintsBE;
	public static String noOfteamMembersBE;
	public static String sprintVelocityBE;
	public static String sprintDurationBE;
	public SimulationSession simulationSession;
	private boolean isSaved;

	/**
	 * Create the frame.
	 */
	public SimulationInProgressPage() {
		isSaved = false;
		runSimulation();
		initialize();
	}

	public SimulationInProgressPage(SimulationSession simulationSession){
		isSaved = true;
		this.simulationSession = simulationSession;
		initialize();
	}

	private void runSimulation(){
		CreateSimulation frontendcalltoCAS = new CreateSimulation();

		sessionName = frontendcalltoCAS.sessionName;
		noOfsprints = frontendcalltoCAS.noOfsprints;
		noOfteamMembers = frontendcalltoCAS.noOfteamMembers;
		sprintVelocity = frontendcalltoCAS.sprintVelocity;
		sprintDuration = frontendcalltoCAS.sprintDuration;


		SimulationInProgressBackEnd backendcalltoSIPBE = new SimulationInProgressBackEnd();
		simulationSession = backendcalltoSIPBE.calcSimulationParameters(sessionName,noOfsprints,noOfteamMembers,sprintVelocity,sprintDuration);
	}

	private void initialize()
	{
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(350, 120, 754, 800); // Size of frame
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.decode("#f0ebd8"));
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);

		JButton signOutButton = new JButton("Sign Out");
		signOutButton.setBounds(115, 22, 90, 30);
		signOutButton.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		signOutButton.setBackground(Color.decode("#3e5c76"));
		signOutButton.setForeground(Color.WHITE);
		signOutButton.setOpaque(true);
		frame.getContentPane().add(signOutButton);
		signOutButton.setMinimumSize(new Dimension(100, 21));
		signOutButton.setMaximumSize(new Dimension(100, 21));
		signOutButton.setPreferredSize(new Dimension(100, 21));
		signOutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				LoginPage LoginPage = new LoginPage(); // New Frame (NewScreen)
				LoginPage.setVisible(true);

			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(signOutButton);

		JButton goBack = new JButton("Home Page");
		goBack.setBounds(510, 22, 200, 30);
		goBack.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		goBack.setBackground(Color.decode("#3e5c76"));
		goBack.setForeground(Color.WHITE);
		goBack.setOpaque(true);
		frame.getContentPane().add(goBack);
		goBack.setMinimumSize(new Dimension(100, 21));
		goBack.setMaximumSize(new Dimension(100, 21));
		goBack.setPreferredSize(new Dimension(100, 21));
		goBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LandingPage landingPage = new LandingPage();
				landingPage.frame.setVisible(true);
				frame.dispose();
			}
		});

		JLabel lblNewLabel = new JLabel(simulationSession.getName());
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(221, 16, 305, 43);
		frame.getContentPane().add(lblNewLabel);

		//Icon icon = new ImageIcon("//src//Assets//icons8-save-48.png"));
		JButton saveButton = new JButton("Save");
		saveButton.setFont(new Font("SansSerif", Font.PLAIN, 13));
		saveButton.setBackground(Color.decode("#3e5c76"));
		saveButton.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		saveButton.setForeground(Color.WHITE);
		saveButton.setOpaque(true);
		saveButton.setMinimumSize(new Dimension(100, 21));
		saveButton.setMaximumSize(new Dimension(100, 21));
		saveButton.setPreferredSize(new Dimension(100, 21));
		if(isSaved){
			saveButton.setEnabled(false);
		}

		//Sample creation for test

		ExportTOJSONTests mockExporter= new ExportTOJSONTests();
		//SimulationSession testSession = mockExporter.CreateSample();
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaveSessionFunction(LoginPage.loggedInUser, simulationSession );// Need to make link between LoginPage
			}
		});
		saveButton.setBounds(536, 75, 76, 50);
		frame.getContentPane().add(saveButton);

		JButton DownloadButton = new JButton("Download");
		DownloadButton.setFont(new Font("SansSerif", Font.PLAIN, 13));
		DownloadButton.setBackground(Color.decode("#3e5c76"));
		DownloadButton.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		DownloadButton.setForeground(Color.WHITE);
		DownloadButton.setOpaque(true);
		DownloadButton.setMinimumSize(new Dimension(100, 21));
		DownloadButton.setMaximumSize(new Dimension(100, 21));
		DownloadButton.setPreferredSize(new Dimension(100, 21));
		DownloadButton.setBounds(640, 75, 76, 50);
		DownloadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String sourcePath = "Downloads";
					File sourceFolder = new File(sourcePath);
					boolean successFolder = sourceFolder.mkdir();
					String fileName = "Downloads/" + LoginPage.loggedInUser;
					String folderPath = fileName;
					File folder = new File(folderPath);
					boolean success = folder.mkdir();
					String filePath = "Downloads/" + LoginPage.loggedInUser + "/" + LoginPage.loggedInUser + ".csv";
					File saveCSV = new File(filePath);
					int saveCounter = 1;
					boolean ifExisting = saveCSV.exists() && !saveCSV.isDirectory();
					while (ifExisting == true) {
						String filePathExtend = Integer.toString(saveCounter);
						filePath = "Downloads/" + LoginPage.loggedInUser + "/" + LoginPage.loggedInUser + "_" + filePathExtend + ".csv";
						saveCSV = new File(filePath);
						ifExisting = saveCSV.exists() && !saveCSV.isDirectory();
						saveCounter = saveCounter + 1;
					}
					convertToCSV(simulationSession, filePath);
					DownloadButtonReaction messageWindow = new DownloadButtonReaction(true,0,filePath);
					messageWindow.frame.setVisible(true);
				}catch (Exception downloadExecption){
					downloadExecption.printStackTrace();
					DownloadButtonReaction messageWindow = new DownloadButtonReaction(false,0,"");
					messageWindow.frame.setVisible(true);
				}
			}
		});
		frame.getContentPane().add(DownloadButton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(144, 245, 438, 400);
		frame.getContentPane().add(scrollPane);

		JPanel containerPanel = new JPanel();
		containerPanel.setBorder(null);
		containerPanel.setOpaque(false);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		int numberOfPanels = (int)simulationSession.getNumberOfSprints();
		int panelY = 0;

		containerPanel.setLayout(new BoxLayout(containerPanel, BoxLayout.Y_AXIS));
		scrollPane.setViewportView(containerPanel);
		containerPanel.setPreferredSize(new Dimension(438, 200 * numberOfPanels));

		for (int i=1; i < numberOfPanels + 1; i++) {
			SprintDetailsPage sprintPanel = new SprintDetailsPage(0, panelY, 509, 200, numberOfPanels, simulationSession, i-1);
			sprintPanel.addTextField(170, 0,30,37, i);
			containerPanel.add(sprintPanel);
			sprintPanel.setBackground(Color.decode("#f0ebd8"));
			panelY += 200;
		}

		containerPanel.setVisible(true);
	}
}
