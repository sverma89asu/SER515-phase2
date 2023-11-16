package AgileMentor.src.scrum_sim_packages;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Dimension;

public class DownloadButtonReaction extends JFrame {

    public JFrame frame;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DownloadButtonReaction frame = new DownloadButtonReaction(false,0);
                    frame.frame.setVisible(true);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    /**
     * Create the frame.
     */
    public DownloadButtonReaction(boolean state, int tryCount) {
        int shiftx=0;
        frame = new JFrame("Message");
        frame.setBounds(100, 100, 354, 119);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Color.decode("#f0ebd8"));
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        if (state==true)
        {
            JLabel lblNewLabel_2 = new JLabel("Download succeed");
            lblNewLabel_2.setBounds(120, 5, 300, 50);
            lblNewLabel_2.setFont(new Font("SansSerif", Font.PLAIN, 16));
            frame.getContentPane().add(lblNewLabel_2);
        }
        if (state==false && tryCount<3)
        {

            JLabel lblNewLabel_2 = new JLabel("Download failed");
            lblNewLabel_2.setBounds(120, 5, 300, 50);
            lblNewLabel_2.setFont(new Font("SansSerif", Font.PLAIN, 16));
            frame.getContentPane().add(lblNewLabel_2);
            JButton btnNewButton1 = new JButton("Retry");
            btnNewButton1.setBounds(65, 50, 100, 25);
            btnNewButton1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
            btnNewButton1.setBackground(Color.decode("#3e5c76"));
            btnNewButton1.setForeground(Color.WHITE);
            btnNewButton1.setMinimumSize(new Dimension(100, 21));
            btnNewButton1.setMaximumSize(new Dimension(100, 21));
            btnNewButton1.setPreferredSize(new Dimension(100, 21));

            int finalTryCount = tryCount+1;
            btnNewButton1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new DownloadButtonReaction(state, finalTryCount);
                    frame.dispose();
                }
            });
            shiftx=60;
            frame.getContentPane().add(btnNewButton1);

        }
        if(tryCount==3){
            JLabel lblNewLabel_3 = new JLabel("Try Limit Exceeded!");
            lblNewLabel_3.setBounds(105, 5, 300, 50);
            lblNewLabel_3.setFont(new Font("SansSerif", Font.PLAIN, 16));
            frame.getContentPane().add(lblNewLabel_3);
        }

        tryCount=tryCount+1;
        JButton btnNewButton = new JButton("Close");
        btnNewButton.setBounds(125+shiftx, 50, 100, 25);
        btnNewButton.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        btnNewButton.setBackground(Color.decode("#3e5c76"));
        btnNewButton.setForeground(Color.WHITE);
        btnNewButton.setMinimumSize(new Dimension(100, 21));
        btnNewButton.setMaximumSize(new Dimension(100, 21));
        btnNewButton.setPreferredSize(new Dimension(100, 21));

        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        frame.getContentPane().add(btnNewButton);
        frame.setVisible(true);
    }
}