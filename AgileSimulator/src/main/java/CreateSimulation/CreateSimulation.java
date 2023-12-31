package CreateSimulation;

import scrum_sim_packages.*;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.BorderFactory;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpringLayout;

import static CreateSimulation.CreateSimulation.RoundButton.ErrorInputs;


public class CreateSimulation
{

	public JFrame frame;
	public static String sessionName;
	public static String noOfsprints;
	public static String noOfteamMembers;
	public static String sprintVelocity;
	public static String sprintDuration;

	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				try
				{
					CreateSimulation window = new CreateSimulation();
					window.frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CreateSimulation()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frame = new JFrame();
		frame.setBounds(350, 120, 900, 719);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new SpringLayout());
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

		JButton goBack = new JButton("Home Page");
		goBack.setBounds(650, 24, 150, 30);
		goBack.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		goBack.setBackground(Color.decode("#3e5c76"));
		goBack.setForeground(Color.WHITE);
		goBack.setOpaque(true);
		frame.getContentPane().add(goBack);
		goBack.setMinimumSize(new Dimension(100, 21));
		goBack.setMaximumSize(new Dimension(100, 21));
		goBack.setPreferredSize(new Dimension(100, 21));
		goBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LandingPage landing_Page = new LandingPage();
				landing_Page.frame.setVisible(true);
				frame.dispose();
			}
		});

		JLabel lblNewLabel = new JLabel("Create A Simulation");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 32));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(280, 24, 400, 43);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel2 = new JLabel("Session Name");
		lblNewLabel2.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblNewLabel2.setBounds(300, 84, 120, 15);
		frame.getContentPane().add(lblNewLabel2);

		MatteBorder bottomBorder = BorderFactory.createMatteBorder(0, 0, 2, 0, Color.decode("#3e5c76"));
		JTextField textField1 = new JTextField();
		textField1.setBackground(new Color(0, 0, 0));
		textField1.setForeground(new Color(0, 0, 0));
		textField1.setOpaque(false); // transparent
		textField1.setFont(new Font("SansSerif", Font.PLAIN, 13));
		textField1.setBorder(bottomBorder);
		textField1.setBounds(300, 109, 350, 25);
		textField1.setColumns(10);
		frame.getContentPane().add(textField1);
		textField1.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				sessionName = textField1.getText();

			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				sessionName = textField1.getText();

			}

			@Override
			public void changedUpdate(DocumentEvent e)
			{
				// TODO Auto-generated method stub

			}
		});

		JLabel lblNewLabel3 = new JLabel("Set Configuration");
		lblNewLabel3.setFont(new Font("SansSerif", Font.PLAIN, 20));
		lblNewLabel3.setBounds(380, 182, 210, 34);
		frame.getContentPane().add(lblNewLabel3);

		JLabel lblNewLabel5 = new JLabel("Number of Sprints");
		lblNewLabel5.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblNewLabel5.setBounds(295, 246, 120, 18);
		frame.getContentPane().add(lblNewLabel5);

		JTextField textField2 = new JTextField();
		textField2.setBackground(new Color(0, 0, 0));
		textField2.setForeground(new Color(0, 0, 0));
		textField2.setOpaque(false); // transparent
		textField2.setFont(new Font("SansSerif", Font.PLAIN, 13));
		textField2.setBorder(bottomBorder);
		textField2.setBounds(545, 241, 40, 25);
		textField2.setColumns(5);
		frame.getContentPane().add(textField2);
		textField2.getDocument().addDocumentListener(new DocumentListener() {
			public void insertUpdate(DocumentEvent e) {
				noOfsprints = textField2.getText();

			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				noOfsprints = textField2.getText();

			}

			@Override
			public void changedUpdate(DocumentEvent e)
			{
				// TODO Auto-generated method stub

			}
		});

		JLabel lblNewLabel6 = new JLabel("Number of team members");
		lblNewLabel6.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblNewLabel6.setBounds(295, 280, 180, 18);
		frame.getContentPane().add(lblNewLabel6);

		JTextField textField3 = new JTextField();
		textField3.setBackground(new Color(0, 0, 0));
		textField3.setForeground(new Color(0, 0, 0));
		textField3.setOpaque(false); // transparent
		textField3.setFont(new Font("SansSerif", Font.PLAIN, 13));
		textField3.setBorder(bottomBorder);
		textField3.setBounds(545, 275, 40, 25);
		textField3.setColumns(5);
		frame.getContentPane().add(textField3);
		textField3.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				noOfteamMembers = textField3.getText();

			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				noOfteamMembers = textField3.getText();


			}

			@Override
			public void changedUpdate(DocumentEvent e)
			{
				// TODO Auto-generated method stub

			}
		});

		JLabel lblNewLabel7 = new JLabel("Sprint Velocity");
		lblNewLabel7.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblNewLabel7.setBounds(295, 314, 151, 18);
		frame.getContentPane().add(lblNewLabel7);

		JTextField textField4 = new JTextField();
		textField4.setBackground(new Color(0, 0, 0));
		textField4.setForeground(new Color(0, 0, 0));
		textField4.setOpaque(false); // transparent
		textField4.setFont(new Font("SansSerif", Font.PLAIN, 13));
		textField4.setBorder(bottomBorder);
		textField4.setBounds(545, 309, 40, 25);
		textField4.setColumns(5);
		frame.getContentPane().add(textField4);
		textField4.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				sprintVelocity = textField4.getText();

			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				sprintVelocity = textField4.getText();

			}

			@Override
			public void changedUpdate(DocumentEvent e)
			{
				// TODO Auto-generated method stub

			}
		});

		JLabel lblNewLabel8 = new JLabel("Sprint Duration(in days)");
		lblNewLabel8.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblNewLabel8.setBounds(295, 347, 151, 18);
		frame.getContentPane().add(lblNewLabel8);

		JTextField textField5 = new JTextField();
		textField5.setBackground(new Color(0, 0, 0));
		textField5.setForeground(new Color(0, 0, 0));
		textField5.setOpaque(false);
		textField5.setFont(new Font("SansSerif", Font.PLAIN, 13));
		textField5.setBorder(bottomBorder);
		textField5.setBounds(545, 340, 40, 25);
		textField5.setColumns(5);
		frame.getContentPane().add(textField5);
		textField5.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				sprintDuration = textField5.getText();

			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				sprintDuration = textField5.getText();

			}

			@Override
			public void changedUpdate(DocumentEvent e)
			{
				// TODO Auto-generated method stub

			}
		});

		RoundButton btnNewButton4 = new RoundButton("Continue");
		btnNewButton4.setForeground(Color.WHITE);
		btnNewButton4.setFont(new Font("SansSerif", Font.PLAIN, 13));
		btnNewButton4.setBackground(Color.decode("#026e0d"));
		btnNewButton4.setFocusPainted(false);
		btnNewButton4.setBorderPainted(false);
		btnNewButton4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				boolean inputCheck = ErrorInputs(sessionName, noOfsprints, noOfteamMembers, sprintVelocity, sprintDuration);

				if(inputCheck == true){
					frame.dispose();

					SwingUtilities.invokeLater(new Runnable() {
						@Override
						public void run() {
							SimulationInProgressPage simulationInProgressPage = new SimulationInProgressPage();
							simulationInProgressPage.frame.setVisible(true);
						}
					});
				}
				else{
					CreateSimulationReaction reaction = new CreateSimulationReaction();
					reaction.frame.setVisible(true);
				}
			}
		});

		btnNewButton4.setBounds(380, 450, 142, 40);
		frame.getContentPane().add(btnNewButton4);

		JPanel panel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.setColor(Color.decode("#797979"));
				int x1 = 328;
				int y1 = 396;
				int x2 = 565;
				int y2 = 396;

				Graphics2D g2d = (Graphics2D) g;

				g2d.setStroke(new BasicStroke(1));
				g2d.drawLine(x1, y1, x2, y2);
			}
		};
		panel.setBounds(0, 0, frame.getWidth(), frame.getHeight());
		panel.setBackground(Color.decode("#f0ebd8"));
		frame.getContentPane().add(panel);
		panel.setLayout(new SpringLayout());
	}

	class RoundButton extends JButton {
		public RoundButton(String label) {
			super(label);
			setContentAreaFilled(false);
			setFocusPainted(false);
			setBorderPainted(false);
		}

		@Override
		protected void paintComponent(Graphics g) {
			if (getModel().isArmed()) {
				g.setColor(Color.gray);
			} else {
				g.setColor(getBackground());
			}
			g.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);
			super.paintComponent(g);
		}

		@Override
		protected void paintBorder(Graphics g) {
			g.setColor(getForeground());
			g.drawRoundRect(0, 0, getWidth(), getHeight(), 10, 10);
		}

		protected Shape getShape() {
			RoundRectangle2D shape = new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), 10, 10);
			return shape;
		}

		@Override
		public boolean contains(int x, int y) {
			if (getShape() == null || !getShape().contains(x, y)) {
				return false;
			}
			return super.contains(x, y);
		}
		public static boolean ErrorInputs(String sessionName,String noOfsprints, String noOfteamMembers, String sprintVelocity, String sprintDuration){
			if(sessionName.isEmpty() || sessionName.isBlank())
			{
				return false;
			}
			try {
				int number = Integer.parseInt(noOfsprints);
			} catch (NumberFormatException e) {
				return false;
			}
			try {
				int checkMembers = Integer.parseInt(noOfteamMembers);
			} catch (NumberFormatException e) {
				return false;
			}
			try {
				int checkVelocity = Integer.parseInt(sprintVelocity);
			} catch (NumberFormatException e) {
				return false;
			}
			try {
				int checkDuration = Integer.parseInt(sprintDuration);
			} catch (NumberFormatException e) {
				return false;
			}
			return true;
		}
	}

	class NoBorderComboBoxUI extends BasicComboBoxUI {
		@Override
		protected ComboPopup createPopup() {
			BasicComboPopup popup = new BasicComboPopup(comboBox) {
				@Override
				protected JScrollPane createScroller() {
					return new JScrollPane(list, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				}
			};
			popup.getAccessibleContext().setAccessibleParent(comboBox);
			return popup;
		}
	}
}

class RoundButton extends JButton {
	public RoundButton(String label) {
		super(label);
		setContentAreaFilled(false);
		setFocusPainted(false);
		setBorderPainted(false);
	}

	@Override
	protected void paintComponent(Graphics g) {
		if (getModel().isArmed()) {
			g.setColor(Color.gray);
		} else {
			g.setColor(getBackground());
		}
		g.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);
		super.paintComponent(g);
	}

	@Override
	protected void paintBorder(Graphics g) {
		g.setColor(getForeground());
		g.drawRoundRect(0, 0, getWidth(), getHeight(), 10, 10);
	}

	protected Shape getShape() {
		RoundRectangle2D shape = new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), 10, 10);
		return shape;
	}

	@Override
	public boolean contains(int x, int y) {
		if (getShape() == null || !getShape().contains(x, y)) {
			return false;
		}
		return super.contains(x, y);
	}
}

class NoBorderComboBoxUI extends BasicComboBoxUI {
	@Override
	protected ComboPopup createPopup() {
		BasicComboPopup popup = new BasicComboPopup(comboBox) {
			@Override
			protected JScrollPane createScroller() {
				return new JScrollPane(list, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			}
		};
		popup.getAccessibleContext().setAccessibleParent(comboBox);
		return popup;
	}
}

