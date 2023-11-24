package scrum_sim_packages;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.Dimension;

public class CreateAccount extends JFrame {
    public JFrame frame;
    private JTextField username_textField;
    private JPasswordField passwordField;
    private JPasswordField passwordVerificationField;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CreateAccount frame = new CreateAccount();
                    frame.setVisible(false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public CreateAccount() {
        initialize();
    }

    private void initialize()
    {
        frame = new JFrame();
        frame.setVisible(true);
        frame.setBounds(350, 120, 754, 800);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Color.decode("#f0ebd8"));
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        JLabel createAccount = new JLabel("Create Account");
        createAccount.setFont(new Font("SansSerif", Font.BOLD, 32));
        createAccount.setHorizontalAlignment(SwingConstants.CENTER);
        createAccount.setBounds(150, 85, 450, 50);
        frame.getContentPane().add(createAccount);

        JLabel username = new JLabel("Username");
        username.setFont(new Font("SansSerif", Font.PLAIN, 20));
        //lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        username.setBounds(150, 160, 200, 40);
        frame.getContentPane().add(username);

        username_textField = new JTextField();
        username_textField.setBounds(150, 210, 450, 40);
        username_textField.setBorder(new LineBorder(new Color(171, 173, 179), 1, true));
        username_textField.setMaximumSize(new Dimension(7, 19));
        frame.getContentPane().add(username_textField);
        username_textField.setColumns(10);

        JLabel password = new JLabel("Password");
        password.setFont(new Font("SansSerif", Font.PLAIN, 20));
        password.setBounds(150, 270, 200, 40);
        frame.getContentPane().add(password);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 320, 450, 40);
        passwordField.setBorder(new LineBorder(new Color(171, 173, 179), 1, true));
        frame.getContentPane().add(passwordField);

        JLabel passwordVerification = new JLabel("Password Verification");
        passwordVerification.setFont(new Font("SansSerif", Font.PLAIN, 20));
        passwordVerification.setBounds(150, 380, 200, 40);
        frame.getContentPane().add(passwordVerification);

        passwordVerificationField = new JPasswordField();
        passwordVerificationField.setBounds(150, 430, 450, 40);
        passwordVerificationField.setBorder(new LineBorder(new Color(171, 173, 179), 1, true));
        frame.getContentPane().add(passwordVerificationField);

        JLabel selectRole = new JLabel("Select Role");
        selectRole.setFont(new Font("SansSerif", Font.PLAIN, 20));
        selectRole.setBounds(150, 490, 200, 40);
        frame.getContentPane().add(selectRole);

        JComboBox<String> roleComboBox = new JComboBox<>(new String[]{"Trainee", "Trainer", "Sim User"});
        roleComboBox.setFont(new Font("SansSerif", Font.PLAIN, 20));
        roleComboBox.setBounds(150, 540, 450, 40);
        frame.getContentPane().add(roleComboBox);

        JButton create = new JButton("Create");
        create.setBounds(300, 600, 150, 43);
        create.setFont(new Font("SansSerif", Font.BOLD, 20));
        create.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        create.setBackground(Color.decode("#3e5c76"));
        create.setForeground(Color.WHITE);
        create.setOpaque(true);
        frame.getContentPane().add(create);
        frame.getContentPane().setLayout(null);

        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = username_textField.getText();
                String password = String.valueOf(passwordField.getPassword());
                String passwordVerification = String.valueOf(passwordVerificationField.getPassword());

                if (username.isEmpty() || password.isEmpty() || passwordVerification.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Check Your Input");
                } else if (!password.equals(passwordVerification)) {
                    JOptionPane.showMessageDialog(frame, "Check Password Verification");
                } else {
                    // If password is identical, the account should be created
                }
            }
        });

    }
}