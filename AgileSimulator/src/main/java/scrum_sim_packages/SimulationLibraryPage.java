package scrum_sim_packages;
import Helpers.ImportJSON;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.util.ArrayList;

public class SimulationLibraryPage extends JFrame {

    private static final long serialVersionUID = 1L;
    public JFrame frame;

    /**
     * Create the frame.
     */
    public SimulationLibraryPage() {
        initialize();
    }

    private void initialize()
    {
       ArrayList<SimulationSession> simulationSessions = new ArrayList<>();

        simulationSessions = ImportJSON.LoadSessions(LoginPage.loggedInUser);
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
                frame.dispose();
                LandingPage landingPage = new LandingPage();
                landingPage.frame.setVisible(true);
            }
        });

        JLabel lblNewLabel = new JLabel("Simulation Library");
        lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 25));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(221, 16, 305, 43);
        frame.getContentPane().add(lblNewLabel);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(144, 245, 438, 400);
        frame.getContentPane().add(scrollPane);

        JPanel containerPanel = new JPanel();
        containerPanel.setBorder(null);
        containerPanel.setOpaque(false);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        int numberOfSessions = simulationSessions.size();
        int panelY = 0;

        containerPanel.setLayout(new BoxLayout(containerPanel, BoxLayout.Y_AXIS));
        scrollPane.setViewportView(containerPanel);
        containerPanel.setPreferredSize(new Dimension(438, 200 * numberOfSessions));

        for (int i=0; i < numberOfSessions; i++) {
            SimulationSessionSummaryPage simulationSessionSummaryPage = new SimulationSessionSummaryPage(0, panelY, 509, 200, numberOfSessions, simulationSessions.get(i));
            containerPanel.add(simulationSessionSummaryPage);
            simulationSessionSummaryPage.setBackground(Color.decode("#f0ebd8"));
            panelY += 200;
        }

        containerPanel.setVisible(true);
    }
}
