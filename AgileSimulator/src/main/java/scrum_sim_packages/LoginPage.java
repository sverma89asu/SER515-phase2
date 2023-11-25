package scrum_sim_packages;

import CreateSimulation.CreateSimulation;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.*;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagLayout;
import java.awt.Component;
import java.awt.event.KeyEvent;

import javax.swing.border.LineBorder;

public class LoginPage extends JFrame {

	public String username;
	public String password;

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField;

	public JFrame frame;

	public static String loggedInUser;

	public static String loggedInUserRole;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
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
	public LoginPage() {
		frame = new JFrame();
		frame.setBounds(345, 120, 754, 719);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridBagLayout());
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.decode("#f0ebd8"));
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);

		JLabel lblNewLabel = new JLabel("Agile Tutor");
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setPreferredSize(new Dimension(400, 400));
		lblNewLabel.setBounds(new Rectangle(295, 0, 184, 100));
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel.setMinimumSize(new Dimension(250, 100));
		lblNewLabel.setMaximumSize(new Dimension(300, 100));
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Sign In");
		lblNewLabel_1.setBounds(345, 112, 82, 24);
		lblNewLabel_1.setFont(new Font("SansSerif", Font.BOLD, 18));
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Username");
		lblNewLabel_2.setBounds(305, 168, 100, 19);
		lblNewLabel_2.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblNewLabel_2.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblNewLabel_2.setVerticalAlignment(SwingConstants.BOTTOM);
		frame.getContentPane().add(lblNewLabel_2);

		textField = new JTextField();
		textField.setBounds(305, 204, 148, 15);
		textField.setBorder(new LineBorder(new Color(171, 173, 179), 1, true));
		textField.setMaximumSize(new Dimension(7, 19));
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setBounds(305, 236, 184, 34);
		lblNewLabel_3.setFont(new Font("SansSerif", Font.PLAIN, 16));
		frame.getContentPane().add(lblNewLabel_3);

		textField_1 = new JPasswordField();
		textField_1.setBounds(305, 283, 148, 17);
		textField_1.setBorder(new LineBorder(new Color(171, 173, 179), 2, true));
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		textField_1.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				password = textField_1.getText();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				password = textField_1.getText();
			}

			@Override
			public void changedUpdate(DocumentEvent e)
			{
				// TODO Auto-generated method stub

			}
		});
		textField.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				username = textField.getText();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				username = textField.getText();
			}

			@Override
			public void changedUpdate(DocumentEvent e)
			{
				// TODO Auto-generated method stub

			}
		});
		JButton btnNewButton = new JButton("Sign In");
		btnNewButton.setBounds(325, 360, 100, 21);
		btnNewButton.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnNewButton.setBackground(Color.decode("#3e5c76"));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setMinimumSize(new Dimension(100, 21));
		btnNewButton.setMaximumSize(new Dimension(100, 21));
		btnNewButton.setPreferredSize(new Dimension(100, 21));
		btnNewButton.setOpaque(true);
		frame.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Database db = new Database();
				if(db.authenticate(username, password)) {
					SwingUtilities.invokeLater(new Runnable() {
						@Override
						public void run() {
							loggedInUser=username;
							LandingPage frame = new LandingPage();
							frame.frame.setVisible(true);
						}
					});
					frame.dispose();
				}
			}
		});

// Set up KeyBinding on the frame itself
		frame.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
		frame.getRootPane().getActionMap().put("enter", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton.doClick();
			}
		});
		frame.setVisible(true);

	}

}
