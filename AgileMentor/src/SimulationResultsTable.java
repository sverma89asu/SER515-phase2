package AgileMentor.src;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class SimulationResultsTable extends JFrame {

    JTable table;
    JButton refreshButton;

    SimulationResultsTable() {

        JFrame frame = new JFrame();
        frame.setBounds(350, 120, 754, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new SpringLayout());
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Color.decode("#f0ebd8"));
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        JLabel lblNewLabel = new JLabel("Simulation Results");
        lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 32));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(226, 24, 305, 43);
        frame.getContentPane().add(lblNewLabel);

        Object[][] data = {{"1", "US17", "Progress", "10", "10", "8"}, {"1", "US18", "Progress", "5", "8", "4"}, {"1", "US19", "Progress", "1", "8", "4"}};
        String[] columnNames = {"Day", "Stories Selected", "Progress/Blocker", "Remaining Storypoints (1)", "Remaining Storypoints (2)", "Remaining Business Value"};

        DefaultTableModel model = new DefaultTableModel(data, columnNames);

        table = new JTable(model);
        setLayout(new GridLayout(3, 6));

        refreshButton = new JButton("Refresh Page");
        refreshButton.setBackground(new Color(62, 92, 118));
        refreshButton.setForeground(Color.decode("#f0ebd8"));
        refreshButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                Random randomNum = new Random();
                int day_int = randomNum.nextInt(10);
                String day = Integer.toString(day_int);
                int us_int = randomNum.nextInt(50);
                String us_selected = "US" + Integer.toString(us_int);
                ArrayList<String> ActionCards = new ArrayList<String>();
                ActionCards.add("Progress");
                ActionCards.add("Blocker");
                int action_cards_int = randomNum.nextInt(2);
                String action_card = ActionCards.get(action_cards_int);
                int rem_sp_1_int = randomNum.nextInt(10);
                String rem_sp_1 = Integer.toString(rem_sp_1_int);
                int rem_sp_2_int = randomNum.nextInt(10);
                String rem_sp_2 = Integer.toString(rem_sp_1_int);
                int rem_bp_int = randomNum.nextInt(10);
                String rem_bp = Integer.toString(rem_bp_int);

                Object[] newRow = {day, us_selected, action_card, rem_sp_1, rem_sp_2, rem_bp};

                model.addRow(newRow);


            }
        });

        JPanel containerPanel = new JPanel();
        containerPanel.setBackground(Color.decode("#f0ebd8"));
        containerPanel.setBorder(null);
        containerPanel.setBounds(40, 100, 754, 450);
        containerPanel.setOpaque(false);
        containerPanel.add(new JScrollPane(table));
        containerPanel.add(new JPanel());
        containerPanel.add(refreshButton);
        frame.getContentPane().add(containerPanel);
        containerPanel.validate();

//        setSize(754,719);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        setVisible(true);
//
//        Object[][] data = {{"1","US17","Progress"},{"1","US18","Progress"},{"1","US19","Progress"}};
//        String[] columnNames={"Day","Stories Selected","Progress/Blocker"};
//
//        DefaultTableModel model = new DefaultTableModel(data,columnNames);
//
//        table = new JTable(model);
//        setLayout(new GridLayout(3,1));
//
//        JPanel panel = new JPanel();
//
//
//        add(new JScrollPane(table));
//        add(new JPanel());
//        add(panel);
//
//        refreshButton = new JButton("Refresh");
//        panel.add(refreshButton);
//
//        refreshButton.addActionListener(new ActionListener(){
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//                Random randomNum = new Random();
//                int day_int = randomNum. nextInt(10);
//                String day =  Integer.toString(day_int);
//                int us_int = randomNum. nextInt(50);
//                String us_selected = "US"+Integer.toString(us_int);
//                ArrayList<String> ActionCards = new ArrayList<String>();
//                ActionCards.add("Progress");
//                ActionCards.add("Blocker");
//                int action_cards_int = randomNum. nextInt(2);
//                String action_card = ActionCards.get(action_cards_int);
//
//                Object[] newRow = {day,us_selected,action_card};
//
//                model.addRow(newRow);
//
//
//            }
//        });
//        validate();


    }
}
