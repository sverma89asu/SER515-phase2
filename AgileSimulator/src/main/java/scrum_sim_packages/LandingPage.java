package scrum_sim_packages;

import CreateSimulation.CreateSimulation;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;




import java.awt.Dimension;

public class LandingPage extends JFrame {
    public JFrame frame;
    private static JButton createAccountButton;

    public static void setCreateAccountVisible(boolean visible) {
        createAccountButton.setVisible(visible);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LandingPage frame = new LandingPage();
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
    public LandingPage() {
        initialize();
    }

    private void initialize()
    {
        frame = new JFrame();
        frame.setVisible(true);
        frame.setBounds(350, 120, 754, 800); // Size of frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Color.decode("#f0ebd8"));
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        JButton signOutButton = new JButton("Sign Out");
        signOutButton.setBounds(115, 22, 90, 30);
        signOutButton.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        signOutButton.setBackground(Color.decode("#3e5c76"));
        signOutButton.setForeground(Color.WHITE);
        signOutButton.setOpaque(true);
        frame.getContentPane().add(signOutButton);
        signOutButton.setMinimumSize(new Dimension(100, 21));
        signOutButton.setMaximumSize(new Dimension(100, 21));
        signOutButton.setPreferredSize(new Dimension(100, 21));
        signOutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                LoginPage LoginPage = new LoginPage(); // New Frame (NewScreen)
                LoginPage.setVisible(true);

            }
        });
        frame.getContentPane().setLayout(null);
        frame.getContentPane().add(signOutButton);

        createAccountButton = new JButton("Create Account");
        createAccountButton.setBounds(580, 22, 90, 30);
        createAccountButton.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        createAccountButton.setBackground(Color.decode("#3e5c76"));
        createAccountButton.setForeground(Color.WHITE);
        createAccountButton.setOpaque(true);
        frame.getContentPane().add(createAccountButton);
        createAccountButton.setMinimumSize(new Dimension(100, 21));
        createAccountButton.setMaximumSize(new Dimension(100, 21));
        createAccountButton.setPreferredSize(new Dimension(100, 21));
        createAccountButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CreateAccount CreateAccount = new CreateAccount();
                CreateAccount.setVisible(true);
            }
        });
        frame.getContentPane().setLayout(null);
        frame.getContentPane().add(createAccountButton);
        createAccountButton.setVisible(false);

        JLabel lblNewLabel = new JLabel("Main Menu");
        lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 32));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(150, 85, 450, 43);
        frame.getContentPane().add(lblNewLabel);

        JButton createASimButton = new JButton("Create A Simulation");
        createASimButton.setBounds(150, 160, 450, 43);
        createASimButton.setFont(new Font("SansSerif", Font.BOLD, 20));
        createASimButton.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        createASimButton.setBackground(Color.decode("#3e5c76"));
        createASimButton.setForeground(Color.WHITE);
        createASimButton.setOpaque(true);
        frame.getContentPane().add(createASimButton);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().add(createASimButton);
        createASimButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CreateSimulation createSimulation = new CreateSimulation();
                createSimulation.frame.setVisible(true);
                frame.dispose();
            }
        });

        JButton ViewsimLibraryButton = new JButton("View Simulation Library");
        ViewsimLibraryButton.setBounds(150, 220, 450, 43);
        ViewsimLibraryButton.setFont(new Font("SansSerif", Font.BOLD, 20));
        ViewsimLibraryButton.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        ViewsimLibraryButton.setBackground(Color.decode("#3e5c76"));
        ViewsimLibraryButton.setForeground(Color.WHITE);
        ViewsimLibraryButton.setOpaque(true);
        frame.getContentPane().add(ViewsimLibraryButton);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().add(ViewsimLibraryButton);

}
}
