package AgileMentor.src;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class SprintDetailsPage extends JPanel {



    /**
     * Create the panel.
     */
    public SprintDetailsPage(int x, int y, int width, int height) {
        //setBounds(100, 100, 450, 300);
        setBounds(x, y, width, height);
        setLayout(null);

        JPanel sprintDetailsPanel = new JPanel();
        sprintDetailsPanel.setBounds(-868, 5, 1856, 49);
        //sprintDetailsPanel.setBounds(144, 0, width, 37); // 추가
        sprintDetailsPanel.setBorder(null);
        sprintDetailsPanel.setBackground(new Color(240, 235, 216));
        add(sprintDetailsPanel); // SprintDetailsPage에 패널 추가
        //sprintDetailsPanel.setBounds(144, 300, 509, 274);
        //frame.getContentPane().add(panel);
        //sprintDetailsPanel.setLayout(null);

        JButton btnNewButton = new JButton("Sprint");
        btnNewButton.setVerticalAlignment(SwingConstants.TOP);
        btnNewButton.setBackground(new Color(240, 235, 216));
        btnNewButton.setOpaque(true);
        btnNewButton.setBorderPainted(false);
        btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
        btnNewButton.setFont(new Font("SansSerif", Font.PLAIN, 22));
        btnNewButton.setBounds(20, 11, 96, 37);
        //btnNewButton.setBounds(x, 0, width, 37);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });

        JTextField SprintNumber = new JTextField();
        SprintNumber.setText("0");
        SprintNumber.setFont(new Font("SansSerif", Font.PLAIN, 22));
        SprintNumber.setBorder(null);
        //SprintNumber.setBounds(98, 11, 48, 37);
        SprintNumber.setBounds(0, 0, width, height);
        SprintNumber.setOpaque(false);
        SprintNumber.setFocusable(false);
        sprintDetailsPanel.add(SprintNumber);
        SprintNumber.setColumns(10);
        sprintDetailsPanel.add(btnNewButton);

        JTextField txtTotalNumberOf = new JTextField();
        txtTotalNumberOf.setForeground(new Color(240, 235, 216));
        txtTotalNumberOf.setBackground(new Color(62, 92, 118));
        txtTotalNumberOf.setFont(new Font("SansSerif", Font.PLAIN, 22));
        txtTotalNumberOf.setText("Total Number of User Stories");
        txtTotalNumberOf.setEditable(false);
        txtTotalNumberOf.setBorder(null);
        txtTotalNumberOf.setBounds(31, 59, 308, 37);
        sprintDetailsPanel.add(txtTotalNumberOf);
        txtTotalNumberOf.setColumns(10);

        JTextField txtUserStoriesCompleted = new JTextField();
        txtUserStoriesCompleted.setForeground(new Color(240, 235, 216));
        txtUserStoriesCompleted.setBackground(new Color(62, 92, 118));
        txtUserStoriesCompleted.setText("User Stories Completed");
        txtUserStoriesCompleted.setFont(new Font("SansSerif", Font.PLAIN, 22));
        txtUserStoriesCompleted.setEditable(false);
        txtUserStoriesCompleted.setColumns(10);
        txtUserStoriesCompleted.setBorder(null);
        txtUserStoriesCompleted.setBounds(31, 104, 308, 37);
        sprintDetailsPanel.add(txtUserStoriesCompleted);

        JTextField txtTotalBusinessStories = new JTextField();
        txtTotalBusinessStories.setForeground(new Color(240, 235, 216));
        txtTotalBusinessStories.setBackground(new Color(62, 92, 118));
        txtTotalBusinessStories.setText("Total Business Points");
        txtTotalBusinessStories.setFont(new Font("SansSerif", Font.PLAIN, 22));
        txtTotalBusinessStories.setEditable(false);
        txtTotalBusinessStories.setBorder(null);
        txtTotalBusinessStories.setColumns(10);
        txtTotalBusinessStories.setBounds(31, 152, 308, 37);
        sprintDetailsPanel.add(txtTotalBusinessStories);

        JTextField txtBusinessStoriesCompleted = new JTextField();
        txtBusinessStoriesCompleted.setForeground(new Color(240, 235, 216));
        txtBusinessStoriesCompleted.setBackground(new Color(62, 92, 118));
        txtBusinessStoriesCompleted.setText("Business Points Completed");
        txtBusinessStoriesCompleted.setFont(new Font("SansSerif", Font.PLAIN, 22));
        txtBusinessStoriesCompleted.setEditable(false);
        txtBusinessStoriesCompleted.setBorder(null);
        txtBusinessStoriesCompleted.setColumns(10);
        txtBusinessStoriesCompleted.setBounds(31, 200, 308, 37);
        sprintDetailsPanel.add(txtBusinessStoriesCompleted);

        JTextField NoOfUSInput = new JTextField();
        NoOfUSInput.setText("0");
        NoOfUSInput.setBackground(new Color(62, 92, 118));
        NoOfUSInput.setFont(new Font("SansSerif", Font.PLAIN, 22));
        NoOfUSInput.setForeground(new Color(240, 235, 216));
        NoOfUSInput.setEditable(false);
        NoOfUSInput.setBorder(null);
        NoOfUSInput.setBounds(338, 59, 96, 37);
        sprintDetailsPanel.add(NoOfUSInput);
        NoOfUSInput.setColumns(10);

        JTextField CompletedUSInput = new JTextField();
        CompletedUSInput.setText("0");
        CompletedUSInput.setBackground(new Color(62, 92, 118));
        CompletedUSInput.setFont(new Font("SansSerif", Font.PLAIN, 22));
        CompletedUSInput.setForeground(new Color(240, 235, 216));
        CompletedUSInput.setEditable(false);
        CompletedUSInput.setColumns(10);
        CompletedUSInput.setBorder(null);
        CompletedUSInput.setBounds(338, 104, 96, 37);
        sprintDetailsPanel.add(CompletedUSInput);

        JTextField TotalBPInput = new JTextField();
        TotalBPInput.setText("0");
        TotalBPInput.setBackground(new Color(62, 92, 118));
        TotalBPInput.setFont(new Font("SansSerif", Font.PLAIN, 22));
        TotalBPInput.setForeground(new Color(240, 235, 216));
        TotalBPInput.setEditable(false);
        TotalBPInput.setColumns(10);
        TotalBPInput.setBorder(null);
        TotalBPInput.setBounds(338, 152, 96, 37);
        sprintDetailsPanel.add(TotalBPInput);

        JTextField CompletedBPInput = new JTextField();
        CompletedBPInput.setText("0");
        CompletedBPInput.setBackground(new Color(62, 92, 118));
        CompletedBPInput.setFont(new Font("SansSerif", Font.PLAIN, 22));
        CompletedBPInput.setForeground(new Color(240, 235, 216));
        CompletedBPInput.setEditable(false);
        CompletedBPInput.setBorder(null);
        CompletedBPInput.setColumns(10);
        CompletedBPInput.setBounds(338, 200, 96, 37);
        sprintDetailsPanel.add(CompletedBPInput);
    }
}