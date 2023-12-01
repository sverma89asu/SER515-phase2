package scrum_sim_packages;

import CreateSimulation.*;

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

public class CreateSimulationReaction extends JFrame {


    public JFrame frame;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CreateSimulationReaction frame =new CreateSimulationReaction ();
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
    public CreateSimulationReaction () {
        frame = new JFrame("Message");
        frame.setBounds(100, 100, 354, 119);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Color.decode("#f0ebd8"));
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        JLabel lblNewLabel_2 = new JLabel("Invalid Inputs");
        lblNewLabel_2.setBounds(130, 5, 300, 50);
        lblNewLabel_2.setFont(new Font("SansSerif", Font.PLAIN, 16));
        frame.getContentPane().add(lblNewLabel_2);
        JButton btnNewButton = new JButton("Close");
        btnNewButton.setBounds(125, 50, 100, 25);
        btnNewButton.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        btnNewButton.setBackground(Color.decode("#3e5c76"));
        btnNewButton.setForeground(Color.WHITE);
        btnNewButton.setOpaque(true);
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
