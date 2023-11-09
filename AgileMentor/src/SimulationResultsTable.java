package AgileMentor.src;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class SimulationResultsTable extends JFrame {

    JTable table;

    SimulationResultsTable() {

        JFrame frame = new JFrame();
        frame.setBounds(350, 120, 1500, 800);
        frame.getContentPane().setLayout(new SpringLayout());
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Color.decode("#f0ebd8"));
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        JLabel lblNewLabel = new JLabel("Simulation Results");
        lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 32));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(600, 24, 305, 60);
        frame.getContentPane().add(lblNewLabel);

        Object[][] data = {{"", "", ""}};
        String[] columnNames = {"Product Backlog"};

        Object[][] data2 = {{"", "", ""}};
        String[] columnNames2 = {"Sprint Backlog"};

        Object[][] data3 = {{"1", "US17", "Progress", "10.0", "8.0"}, {"1", "US18", "Progress", "8.0", "7.0"}, {"1", "US19", "Blocker", "8.0", "7.0"}};
        String[] columnNames3 = {"Day", "Stories Selected", "Progress/Blocker", "Remaining Storypoints", "Remaining Business Value"};

        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        DefaultTableModel model2 = new DefaultTableModel(data2, columnNames2) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        DefaultTableModel model3 = new DefaultTableModel(data3, columnNames3) {
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
        containerPanel.setBounds(40, 100, 250, 600);
        containerPanel.setOpaque(false);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(200, 600));

        table = new JTable(model2);
        setLayout(new GridLayout(3, 2));

        JPanel containerPanel2 = new JPanel();
        containerPanel2.setBackground(Color.decode("#f0ebd8"));
        containerPanel2.setBorder(null);
        containerPanel2.setBounds(290, 100, 250, 600);
        containerPanel2.setOpaque(false);

        JScrollPane scrollPane2 = new JScrollPane(table);
        scrollPane2.setPreferredSize(new Dimension(200, 600));

        table = new JTable(model3);
        setLayout(new GridLayout(3, 6));

        JPanel containerPanel3 = new JPanel();
        containerPanel3.setBackground(Color.decode("#f0ebd8"));
        containerPanel3.setBorder(null);
        containerPanel3.setBounds(550, 100, 900, 600);
        containerPanel3.setOpaque(false);

        JScrollPane scrollPane3 = new JScrollPane(table);
        scrollPane3.setPreferredSize(new Dimension(850, 600));

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
