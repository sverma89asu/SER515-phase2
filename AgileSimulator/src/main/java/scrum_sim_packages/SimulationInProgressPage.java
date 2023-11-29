package scrum_sim_packages;
import CreateSimulation.*;
import tests.ExportTOJSONTests;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import static Helpers.ExportToJSON.SaveSessionFunction;
import java.awt.Dimension;

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
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

		JButton goBack = new JButton("Create A Simulation");
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
				CreateSimulation createSimulation = new CreateSimulation();
				createSimulation.frame.setVisible(true);
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
		frame.getContentPane().add(DownloadButton);

//		JButton homeButton = new JButton("");
//		homeButton.setIcon(new ImageIcon("C:\\Users\\Rushabh\\Downloads\\icons8-home-ios-16-filled\\icons8-home-50.png"));
//		homeButton.setForeground(Color.RED);
//		homeButton.setFont(new Font("SansSerif", Font.PLAIN, 13));
//		homeButton.setOpaque(true); // Transparent color
//		homeButton.setContentAreaFilled(false);
//		homeButton.setBorderPainted(false); // Hide border
//		homeButton.setFocusPainted(false);
//		homeButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) { // Need to make link between LoginPage
//
//
//			}
//		});
//		homeButton.setBounds(608, 22, 70, 50);
//		frame.getContentPane().add(homeButton);

//		JProgressBar progressBar = new JProgressBar();
//		progressBar.setBounds(144, 119, 438, 28);
//		progressBar.setForeground(new Color(2, 110, 13));
//		progressBar.setBackground(new Color(255, 255, 255));
//		progressBar.setValue(0);
//		progressBar.setStringPainted(true);
//		frame.getContentPane().add(progressBar);

//		JButton playButton = new JButton("");
//		playButton.setIcon(new ImageIcon("C:\\Users\\Rushabh\\Downloads\\icons8-play-50.png"));
//		playButton.setForeground(Color.RED);
//		playButton.setFont(new Font("SansSerif", Font.PLAIN, 13));
//		playButton.setOpaque(true); // Transparent color
//		playButton.setContentAreaFilled(false);
//		playButton.setBorderPainted(false); // Hide border
//		playButton.setFocusPainted(false);
//		playButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) { // Need to make link between LoginPage
//
//
//			}
//		});
//		playButton.setBounds(279, 158, 70, 50);
//		frame.getContentPane().add(playButton);

//		JButton rewindButton = new JButton("");
//		rewindButton.setIcon(new ImageIcon("C:\\Users\\Rushabh\\Downloads\\icons8-rewind-material-sharp\\icons8-rewind-48.png"));
//		rewindButton.setForeground(Color.RED);
//		rewindButton.setFont(new Font("SansSerif", Font.PLAIN, 13));
//		rewindButton.setOpaque(true); // Transparent color
//		rewindButton.setContentAreaFilled(false);
//		rewindButton.setBorderPainted(false); // Hide border
//		rewindButton.setFocusPainted(false);
//		rewindButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) { // Need to make link between LoginPage
//
//
//			}
//		});
//		rewindButton.setBounds(359, 158, 70, 50);
//		frame.getContentPane().add(rewindButton);

//		JButton randomEventsButton = new JButton("Add Random Event");
//		randomEventsButton.setBackground(new Color(62, 92, 118));
//		randomEventsButton.setIcon(null);
//		randomEventsButton.setForeground(Color.decode("#f0ebd8"));
//		randomEventsButton.setFont(new Font("SansSerif", Font.PLAIN, 15));
//		randomEventsButton.setOpaque(true); // Transparent color
//		randomEventsButton.setContentAreaFilled(true);
//		randomEventsButton.setBorderPainted(false); // Hide border
//		randomEventsButton.setFocusPainted(false);
//		randomEventsButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) { // Need to make link between LoginPage
//
//
//			}
//		});
//		randomEventsButton.setBounds(506, 158, 224, 50);
//		frame.getContentPane().add(randomEventsButton);

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
