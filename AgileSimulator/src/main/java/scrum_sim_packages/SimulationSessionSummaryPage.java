package scrum_sim_packages;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class SimulationSessionSummaryPage extends JPanel {
    private JPanel simulationSessionSummary;
    private SimulationSession simulationSession;

    /**
     * Create the panel.
     */
    public SimulationSessionSummaryPage(int x, int y, int width, int height, int j, SimulationSession simulationSession) {
        this.simulationSession = simulationSession;
        setBounds(x, y, width, height);
        setLayout(null);

        simulationSessionSummary = new JPanel();
        simulationSessionSummary.setBounds(0, 0, width, height);
        simulationSessionSummary.setBorder(null);
        simulationSessionSummary.setLayout(null);
        simulationSessionSummary.setBackground(Color.decode("#f0ebd8"));
        add(simulationSessionSummary);

        // Simulation Session
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        addbtnNewButton(30,0,140,37);
        addTextField2("Number of Sprints", 30, 74, 300, 37);
        addTextField2(String.valueOf(simulationSession.getNumberOfSprints()), 330, 74, 60, 37);
        addTextField2("Sprint Velocity", 30, 37, 300, 37);
        addTextField2(decimalFormat.format(simulationSession.getVelocity()), 330, 37, 60, 37);
        addTextField2("Team size", 30, 111, 300, 37);
        addTextField2(String.valueOf(simulationSession.getTeamSize()), 330, 111, 60, 37);
        addTextField2("Sprint Duration(in days)", 30, 148, 300, 37);
        addTextField2(String.valueOf(simulationSession.getSprintDuration()), 330, 148, 60, 37);
    }

    public void addbtnNewButton(int x, int y, int width, int height) {
        JButton btnNewButton = new JButton(simulationSession.getName());
        btnNewButton.setVerticalAlignment(SwingConstants.TOP);
        btnNewButton.setBackground(new Color(240, 235, 216));
        btnNewButton.setFocusable(false);
        btnNewButton.setOpaque(true);
        btnNewButton.setBorderPainted(false);
        btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
        btnNewButton.setFont(new Font("SansSerif", Font.PLAIN, 22));
        btnNewButton.setBounds(x, y, width, height);
        btnNewButton.setPreferredSize(new Dimension(width, height));
        simulationSessionSummary.add(btnNewButton);
    }

    public void addTextField(int x, int y, int width, int height, int j) {
        JTextField textField = new JTextField(String.valueOf(j));
        textField.setBackground(Color.decode("#f0ebd8"));
        textField.setFont(new Font("SansSerif", Font.PLAIN, 22));
        textField.setEditable(false);
        textField.setBorder(null);
        textField.setColumns(10);
        textField.setBounds(x, y, width, height);
        textField.setPreferredSize(new Dimension(width, height));
        simulationSessionSummary.add(textField);
    }
    public void addTextField2(String text, int x, int y, int width, int height) {
        JTextField textField = new JTextField();
        textField.setForeground(new Color(240, 235, 216));
        textField.setBackground(new Color(62, 92, 118));
        textField.setFont(new Font("SansSerif", Font.PLAIN, 22));
        textField.setText(text);
        textField.setEditable(false);
        textField.setBorder(null);
        textField.setColumns(10);
        textField.setBounds(x, y, width, height);
        textField.setPreferredSize(new Dimension(width, height));
        simulationSessionSummary.add(textField);
    }
}
