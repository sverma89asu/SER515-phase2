package AgileSimulator.src.main.java.scrum_sim_packages;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class SprintDetailsPage extends JPanel {
    private JPanel sprintDetailsPanel;
    private int numberOfSprints;  // add
    private SimulationSession simulationSession;
    private int sprintID;

    /**
     * Create the panel.
     */
    public SprintDetailsPage(int x, int y, int width, int height, int j, SimulationSession simulationSession, int sprintID) {
        this.simulationSession = simulationSession;
        this.sprintID = sprintID;
        this.numberOfSprints = j;
        setBounds(x, y, width, height);
        setLayout(null);

        sprintDetailsPanel = new JPanel();
        sprintDetailsPanel.setBounds(0, 0, width, height);
        sprintDetailsPanel.setBorder(null);
        sprintDetailsPanel.setLayout(null);
        sprintDetailsPanel.setBackground(Color.decode("#f0ebd8"));
        add(sprintDetailsPanel);

        // Sprint
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        addbtnNewButton(30,0,140,37);
        addTextField2("Expected Velocity", 30, 37, 300, 37);
        addTextField2(decimalFormat.format(simulationSession.getSprints().get(sprintID).getExpectedSP()), 330, 37, 60, 37);
        addTextField2("Actual Velocity", 30, 74, 300, 37);
        addTextField2(decimalFormat.format(simulationSession.getSprints().get(sprintID).getActualSP()), 330, 74, 60, 37);
        addTextField2("Expected Business Value", 30, 111, 300, 37);
        addTextField2(String.valueOf(simulationSession.getSprints().get(sprintID).getExpectedBV()), 330, 111, 60, 37);
        addTextField2("Actual Business Value", 30, 148, 300, 37);
        addTextField2(String.valueOf(simulationSession.getSprints().get(sprintID).getActualBV()), 330, 148, 60, 37);
    }

    public void addbtnNewButton(int x, int y, int width, int height) {
        JButton btnNewButton = new JButton("Sprint");
        btnNewButton.setVerticalAlignment(SwingConstants.TOP);
        btnNewButton.setBackground(new Color(240, 235, 216));
        btnNewButton.setFocusable(false);
        btnNewButton.setOpaque(true);
        btnNewButton.setBorderPainted(false);
        btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
        btnNewButton.setFont(new Font("SansSerif", Font.PLAIN, 22));
        btnNewButton.setBounds(x, y, width, height);
        btnNewButton.setPreferredSize(new Dimension(width, height));
        sprintDetailsPanel.add(btnNewButton);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                new SimulationResultsTable(sprintID, simulationSession);
            }
        });
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
        sprintDetailsPanel.add(textField);
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
        sprintDetailsPanel.add(textField);
    }
}
