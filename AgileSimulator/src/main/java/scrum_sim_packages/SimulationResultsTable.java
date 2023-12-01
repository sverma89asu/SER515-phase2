package scrum_sim_packages;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class SimulationResultsTable extends JFrame {
    private SimulationSession simulationSession;
    private int sprintID;
    JTable table;

    SimulationResultsTable(int sprintID, SimulationSession simulationSession) {
        this.sprintID = sprintID;
        this.simulationSession = simulationSession;

        JFrame frame = new JFrame();
        frame.setBounds(350, 120, 1500, 800);
        //frame.getContentPane().setLayout(new SpringLayout());  수정
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Color.decode("#f0ebd8"));
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        JLabel lblNewLabel = new JLabel("Sprint " + Integer.toString(sprintID+1));
        lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 32));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(600, 24, 305, 60);
        frame.getContentPane().add(lblNewLabel);

        ArrayList<UserStory> productBacklog = simulationSession.getSprints().get(sprintID).getProductBacklog().getUserStories();
        Object[][] productBacklogData = new Object[productBacklog.size()][1];
        for(int i = 0; i < productBacklog.size(); i++){
            productBacklogData[i][0] = productBacklog.get(i).getName();
        }
        String[] columnNames = {"Product Backlog"};

        ArrayList<UserStory> sprintBacklog = simulationSession.getSprints().get(sprintID).getSprintBacklog().getUserStories();
        Object[][] sprintBacklogData = new Object[sprintBacklog.size()][1];
        for(int i = 0; i < sprintBacklog.size(); i++){
            sprintBacklogData[i][0] = sprintBacklog.get(i).getName();
        }
        String[] columnNames2 = {"Sprint Backlog"};
        int size = 0;
        for(StandupDay standupDay: simulationSession.getSprints().get(sprintID).getStandupDays()){
            for(StandupStoryProgress standupStoryProgress: standupDay.getStandupStoryProgresses()){
                size++;
            }
        }
        Object[][] rightTabledata = new Object[size][6];
        int index = 0;
        for(StandupDay standupDay: simulationSession.getSprints().get(sprintID).getStandupDays()){
            for(StandupStoryProgress standupStoryProgress: standupDay.getStandupStoryProgresses()){
                rightTabledata[index][0] = standupDay.getDay();
                rightTabledata[index][1] = standupStoryProgress.getUserStory().getName();
                rightTabledata[index][2] = standupStoryProgress.getInformationCard().getType();
                rightTabledata[index][3] = standupStoryProgress.getResponse();
                DecimalFormat decimalFormat = new DecimalFormat("#.##");

                // Format the double using the DecimalFormat
                String formattedSPValue = decimalFormat.format(standupStoryProgress.getRemainingStoryPoints() > 0 ? standupStoryProgress.getRemainingStoryPoints() : 0);
                rightTabledata[index][4] = formattedSPValue;
                rightTabledata[index][5] = standupStoryProgress.getRemainingBusinessValue();
                index++;
            }
        }
        String[] columnNames3 = {"Day", "Stories Selected", "Progress/Blocker", "Response", "Remaining Storypoints", "Remaining Business Value"};

        DefaultTableModel model = new DefaultTableModel(productBacklogData, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        DefaultTableModel model2 = new DefaultTableModel(sprintBacklogData, columnNames2) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        DefaultTableModel model3 = new DefaultTableModel(rightTabledata, columnNames3) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        table = new JTable(model);
        setLayout(new GridLayout(3, 2));

        JPanel containerPanel = new JPanel();
        containerPanel.setBackground(Color.decode("#f0ebd8"));
        containerPanel.setBorder(null);
        containerPanel.setBounds(40, 100, 150, 600);
        containerPanel.setOpaque(false);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(150, 600));

        table = new JTable(model2);
        setLayout(new GridLayout(3, 2));

        JPanel containerPanel2 = new JPanel();
        containerPanel2.setBackground(Color.decode("#f0ebd8"));
        containerPanel2.setBorder(null);
        containerPanel2.setBounds(250, 100, 150, 600);
        containerPanel2.setOpaque(false);

        JScrollPane scrollPane2 = new JScrollPane(table);
        scrollPane2.setPreferredSize(new Dimension(150, 600));

        table = new JTable(model3);
        table.getColumnModel().getColumn(0).setPreferredWidth(15);
        table.getColumnModel().getColumn(1).setPreferredWidth(30);
        table.getColumnModel().getColumn(2).setPreferredWidth(30);
        table.getColumnModel().getColumn(3).setPreferredWidth(40);
        table.getColumnModel().getColumn(5).setPreferredWidth(90);
        setLayout(new GridLayout(3, 6));

        JPanel containerPanel3 = new JPanel();
        containerPanel3.setBackground(Color.decode("#f0ebd8"));
        containerPanel3.setBorder(null);
        containerPanel3.setBounds(450, 100, 800, 600);
        containerPanel3.setOpaque(false);

        JScrollPane scrollPane3 = new JScrollPane(table);
        scrollPane3.setPreferredSize(new Dimension(750, 600));

        containerPanel.add(scrollPane);
        containerPanel.add(new JPanel());
        frame.getContentPane().add(containerPanel);
        containerPanel.validate();

        containerPanel2.add(scrollPane2);
        containerPanel2.add(new JPanel());
        frame.getContentPane().add(containerPanel2);
        containerPanel2.validate();

        containerPanel3.add(scrollPane3);
        containerPanel3.add(new JPanel());
        frame.getContentPane().add(containerPanel3);
        containerPanel3.validate();
    }
}