package scrum_sim_packages;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.Dimension;

public class AccountCreate extends JFrame {
    public JFrame frame;
    private JTextField username_textField;
    private JPasswordField passwordField;
    private JPasswordField passwordVerificationField;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AccountCreate frame = new AccountCreate();
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
    public AccountCreate() {
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
        password.setBounds(150, 280, 200, 40);
        frame.getContentPane().add(password);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 330, 450, 40);
        passwordField.setBorder(new LineBorder(new Color(171, 173, 179), 1, true));
        frame.getContentPane().add(passwordField);

        JLabel passwordVerification = new JLabel("Password Verification");
        passwordVerification.setFont(new Font("SansSerif", Font.PLAIN, 20));
        passwordVerification.setBounds(150, 400, 200, 60);
        frame.getContentPane().add(passwordVerification);

        passwordVerificationField = new JPasswordField();
        passwordVerificationField.setBounds(150, 450, 450, 40);
        passwordVerificationField.setBorder(new LineBorder(new Color(171, 173, 179), 1, true));
        frame.getContentPane().add(passwordVerificationField);

        JButton create = new JButton("Create");
        create.setBounds(300, 550, 150, 43);
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
                String password = String.valueOf(passwordField.getPassword());
                String passwordVerification = String.valueOf(passwordVerificationField.getPassword());

                if (!password.equals(passwordVerification)) {
                    JOptionPane.showMessageDialog(frame, "Check Password Verification");
                } else {
                    // 비밀번호가 일치하는 경우의 로직을 구현
                }
            }
        });

    }
}