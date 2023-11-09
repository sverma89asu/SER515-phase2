package AgileMentor.src;

import AgileMentor.src.CreateSimulation.CreateSimulation;
import AgileMentor.src.scrum_sim_packages.LoginPage;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SimulationInProgressPage frame = new SimulationInProgressPage();
					frame.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SimulationInProgressPage() {
		initialize();
	}
	
	private void initialize()
	{
		CreateSimulation frontendcalltoCAS = new CreateSimulation();
		System.out.println("In SIP");
		String sessionName = frontendcalltoCAS.sessionName;
		System.out.println(sessionName);
		String noOfsprints = frontendcalltoCAS.noOfsprints;
		System.out.println(noOfsprints);
		String noOfteamMembers = frontendcalltoCAS.noOfteamMembers;
		System.out.println(noOfteamMembers);
		String sprintVelocity = frontendcalltoCAS.sprintVelocity;
		System.out.println(sprintVelocity);
		String sprintDuration = frontendcalltoCAS.sprintDuration;
		System.out.println(sprintDuration);

		System.out.println("From backend");
		SimulationInProgressBackEnd backendcalltoSIPBE = new SimulationInProgressBackEnd();
		ArrayList<String> arr = backendcalltoSIPBE.calcSimulationParameters(sessionName,noOfsprints,noOfteamMembers,sprintVelocity,sprintDuration);
		System.out.println(arr);

		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(350, 120, 754, 800); // Size of frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.decode("#f0ebd8"));
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);

		JButton signOutButton = new JButton("Sign Out");
		signOutButton.setForeground(Color.RED);
		signOutButton.setFont(new Font("SansSerif", Font.PLAIN, 13));
		signOutButton.setOpaque(false); // Transparent color
		signOutButton.setContentAreaFilled(false);
		signOutButton.setBorderPainted(false); // Hide border
		signOutButton.setFocusPainted(false);
		signOutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // Need to make link between LoginPage
				frame.dispose();

				LoginPage LoginPage = new LoginPage(); // New Frame (NewScreen)
				LoginPage.setVisible(true);

			}
		});
		frame.getContentPane().setLayout(null);
		signOutButton.setBounds(40, 22, 120, 40);
		frame.getContentPane().add(signOutButton);

		JLabel lblNewLabel = new JLabel("Simulation in Progress");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(221, 16, 305, 43);
		frame.getContentPane().add(lblNewLabel);

		JButton saveButton = new JButton("");
		saveButton.setIcon(new ImageIcon("C:\\Users\\Rushabh\\Downloads\\icons8-save-material-rounded\\icons8-save-48.png"));
		saveButton.setForeground(Color.RED);
		saveButton.setFont(new Font("SansSerif", Font.PLAIN, 13));
		saveButton.setOpaque(true); // Transparent color
		saveButton.setContentAreaFilled(false);
		saveButton.setBorderPainted(false); // Hide border
		saveButton.setFocusPainted(false);
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // Need to make link between LoginPage


			}
		});
		saveButton.setBounds(536, 22, 76, 50);
		frame.getContentPane().add(saveButton);

		JButton homeButton = new JButton("");
		homeButton.setIcon(new ImageIcon("C:\\Users\\Rushabh\\Downloads\\icons8-home-ios-16-filled\\icons8-home-50.png"));
		homeButton.setForeground(Color.RED);
		homeButton.setFont(new Font("SansSerif", Font.PLAIN, 13));
		homeButton.setOpaque(true); // Transparent color
		homeButton.setContentAreaFilled(false);
		homeButton.setBorderPainted(false); // Hide border
		homeButton.setFocusPainted(false);
		homeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // Need to make link between LoginPage


			}
		});
		homeButton.setBounds(608, 22, 70, 50);
		frame.getContentPane().add(homeButton);

		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(144, 119, 438, 28);
		progressBar.setForeground(new Color(2, 110, 13));
		progressBar.setBackground(new Color(255, 255, 255));
		progressBar.setValue(0);
		progressBar.setStringPainted(true);
		frame.getContentPane().add(progressBar);

		JButton playButton = new JButton("");
		playButton.setIcon(new ImageIcon("C:\\Users\\Rushabh\\Downloads\\icons8-play-50.png"));
		playButton.setForeground(Color.RED);
		playButton.setFont(new Font("SansSerif", Font.PLAIN, 13));
		playButton.setOpaque(true); // Transparent color
		playButton.setContentAreaFilled(false);
		playButton.setBorderPainted(false); // Hide border
		playButton.setFocusPainted(false);
		playButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // Need to make link between LoginPage


			}
		});
		playButton.setBounds(279, 158, 70, 50);
		frame.getContentPane().add(playButton);

		JButton rewindButton = new JButton("");
		rewindButton.setIcon(new ImageIcon("C:\\Users\\Rushabh\\Downloads\\icons8-rewind-material-sharp\\icons8-rewind-48.png"));
		rewindButton.setForeground(Color.RED);
		rewindButton.setFont(new Font("SansSerif", Font.PLAIN, 13));
		rewindButton.setOpaque(true); // Transparent color
		rewindButton.setContentAreaFilled(false);
		rewindButton.setBorderPainted(false); // Hide border
		rewindButton.setFocusPainted(false);
		rewindButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // Need to make link between LoginPage


			}
		});
		rewindButton.setBounds(359, 158, 70, 50);
		frame.getContentPane().add(rewindButton);

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

		int numberOfPanels = Integer.parseInt(noOfsprints);
		int panelY = 0;

		containerPanel.setLayout(new BoxLayout(containerPanel, BoxLayout.Y_AXIS));
		scrollPane.setViewportView(containerPanel);
		containerPanel.setPreferredSize(new Dimension(438, 200 * numberOfPanels));

		for (int i=1; i < numberOfPanels + 1; i++) {
			SprintDetailsPage sprintPanel = new SprintDetailsPage(0, panelY, 509, 200, numberOfPanels);
			sprintPanel.addTextField(130, 0,30,37, i);
			containerPanel.add(sprintPanel);
			sprintPanel.setBackground(Color.decode("#f0ebd8"));
			panelY += 200;
		}

		containerPanel.setVisible(true);
	}
}

