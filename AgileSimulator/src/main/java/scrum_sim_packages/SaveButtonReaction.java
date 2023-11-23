package AgileSimulator.src.main.java.scrum_sim_packages;

import AgileSimulator.src.main.java.CreateSimulation.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Component;
import java.util.Random;

import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.LineBorder;

public class SaveButtonReaction extends JFrame {


    public JFrame frame;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SaveButtonReaction frame = new SaveButtonReaction(false,0);
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
    public SaveButtonReaction(boolean state, int tryCount) {
        int shiftx=0;
        frame = new JFrame("Message");
        frame.setBounds(100, 100, 354, 119);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Color.decode("#f0ebd8"));
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        if (state==true)
        {
            JLabel lblNewLabel_2 = new JLabel("Simulation successfully saved");
            lblNewLabel_2.setBounds(65, 5, 300, 50);
            lblNewLabel_2.setFont(new Font("SansSerif", Font.PLAIN, 16));
            frame.getContentPane().add(lblNewLabel_2);
        }
        if (state==false && tryCount<3)
        {

            JLabel lblNewLabel_2 = new JLabel("Simulation failed to save");
            lblNewLabel_2.setBounds(85, 5, 300, 50);
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
                    new SaveButtonReaction(state, finalTryCount);
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
