import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JComboBox;

public class Create_A_Simulation
{

	private JFrame frame;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					Create_A_Simulation window = new Create_A_Simulation();
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
	public Create_A_Simulation()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frame = new JFrame();
		frame.setBounds(350, 120, 754, 719); // Size of frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.decode("#f0ebd8"));
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
		JButton btnNewButton_1 = new JButton("Sign Out");
		btnNewButton_1.setForeground(Color.RED);
		btnNewButton_1.setFont(new Font("SansSerif", Font.PLAIN, 13));
		btnNewButton_1.setOpaque(false); // Transparent color
		btnNewButton_1.setContentAreaFilled(false); 
		btnNewButton_1.setBorderPainted(false); // Hide border
		btnNewButton_1.setFocusPainted(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // Need to make link between LoginPage
				frame.dispose();
				
				//NewScreen LoginPage = new NewScreen();
				//newScreen.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(40, 22, 120, 40);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Create A Simulation");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 32));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(226, 24, 305, 43);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Session Name");
		lblNewLabel_2.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(228, 84, 120, 15);
		frame.getContentPane().add(lblNewLabel_2);

		MatteBorder bottomBorder = BorderFactory.createMatteBorder(0, 0, 2, 0, Color.decode("#3e5c76"));
		textField_1 = new JTextField();
		textField_1.setBackground(new Color(0, 0, 0));
		textField_1.setForeground(new Color(0, 0, 0));
		textField_1.setOpaque(false); // transparent
		textField_1.setFont(new Font("SansSerif", Font.PLAIN, 13));
		textField_1.setBorder(bottomBorder);
		textField_1.setBounds(228, 109, 295, 25);
		textField_1.setColumns(10);
		frame.getContentPane().add(textField_1);
		
		JLabel lblNewLabel_3 = new JLabel("Set Configuration:");
		lblNewLabel_3.setFont(new Font("SansSerif", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(150, 182, 162, 34);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("or");
		lblNewLabel_4.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(380, 190, 13, 17);
		frame.getContentPane().add(lblNewLabel_4);
		
		RoundButton btnNewButton_2 = new RoundButton("Import Configuration");
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setFont(new Font("SansSerif", Font.PLAIN, 13));
		btnNewButton_2.setBackground(Color.decode("#3e5c76"));
		btnNewButton_2.setFocusPainted(false);
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(460, 176, 162, 45);
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel_5 = new JLabel("Number of Sprints");
		lblNewLabel_5.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(219, 246, 120, 18);
		frame.getContentPane().add(lblNewLabel_5);
		
		textField_2 = new JTextField();
		textField_2.setBackground(new Color(0, 0, 0));
		textField_2.setForeground(new Color(0, 0, 0));
		textField_2.setOpaque(false); // transparent
		textField_2.setFont(new Font("SansSerif", Font.PLAIN, 13));
		textField_2.setBorder(bottomBorder);
		textField_2.setBounds(470, 241, 40, 25);
		textField_2.setColumns(5);
		frame.getContentPane().add(textField_2);
		//addValidationToTextField(textField2);
		
		JLabel lblNewLabel_6 = new JLabel("Number of team members");
		lblNewLabel_6.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblNewLabel_6.setBounds(219, 280, 151, 18);
		frame.getContentPane().add(lblNewLabel_6);
		
		textField_3 = new JTextField();
		textField_3.setBackground(new Color(0, 0, 0));
		textField_3.setForeground(new Color(0, 0, 0));
		textField_3.setOpaque(false); // transparent
		textField_3.setFont(new Font("SansSerif", Font.PLAIN, 13));
		textField_3.setBorder(bottomBorder);
		textField_3.setBounds(470, 275, 40, 25);
		textField_3.setColumns(5);
		frame.getContentPane().add(textField_3);
		
		JLabel lblNewLabel_7 = new JLabel("Sprint Velocity");
		lblNewLabel_7.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblNewLabel_7.setBounds(219, 314, 151, 18);
		frame.getContentPane().add(lblNewLabel_7);
		
		textField_4 = new JTextField();
		textField_4.setBackground(new Color(0, 0, 0));
		textField_4.setForeground(new Color(0, 0, 0));
		textField_4.setOpaque(false); // transparent
		textField_4.setFont(new Font("SansSerif", Font.PLAIN, 13));
		textField_4.setBorder(bottomBorder);
		textField_4.setBounds(470, 309, 40, 25);
		textField_4.setColumns(5);
		frame.getContentPane().add(textField_4);
		
		JLabel lblNewLabel_8 = new JLabel("Sprint Duration");
		lblNewLabel_8.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblNewLabel_8.setBounds(219, 347, 151, 18);
		frame.getContentPane().add(lblNewLabel_8);
		
		textField_5 = new JTextField();
		textField_5.setBackground(new Color(0, 0, 0));
		textField_5.setForeground(new Color(0, 0, 0));
		textField_5.setOpaque(false);
		textField_5.setFont(new Font("SansSerif", Font.PLAIN, 13));
		textField_5.setBorder(bottomBorder);
		textField_5.setBounds(470, 340, 40, 25);
		textField_5.setColumns(5);
		frame.getContentPane().add(textField_5);
		
        JLabel lblNewLabel_9 = new JLabel("Choose a development scenario");
        lblNewLabel_9.setFont(new Font("SansSerif", Font.PLAIN, 13));
        lblNewLabel_9.setBounds(117, 426, 200, 18);
        frame.getContentPane().add(lblNewLabel_9);
        
        JComboBox<String> comboBox = new JComboBox();
        //comboBox.setUI(new ColoredArrowComboBoxUI());
        comboBox.setBounds(353, 426, 300, 25);
        frame.getContentPane().add(comboBox);
        
        comboBox.addItem("Tea Game");
        comboBox.addItem("Coffee Game");
        comboBox.addItem("Pizza Game");
        
        comboBox.setFont(new Font("SansSerif", Font.PLAIN, 13));
        comboBox.setBackground(Color.decode("#f0ebd8"));
        comboBox.setForeground(Color.BLACK);
        comboBox.setFocusable(false);
        comboBox.setBorder(bottomBorder);
        
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
                
        
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.decode("#797979"));
                int x1 = 253;
                int y1 = 396;
                int x2 = 453;
                int y2 = 396;

                Graphics2D g2d = (Graphics2D) g;
                g2d.setStroke(new BasicStroke(1));
                g2d.drawLine(x1, y1, x2, y2);
            }
        };
        panel.setBounds(0, 0, frame.getWidth(), frame.getHeight());
        panel.setBackground(Color.decode("#f0ebd8"));
        frame.getContentPane().add(panel);

    }
	
	/*
	public void addValidationToTextField(JTextField textField) {
	    textField.getDocument().addDocumentListener(new DocumentListener() {
	        @Override
	        public void insertUpdate(DocumentEvent e) {
	            validateInput(textField);
	        }

	        @Override
	        public void removeUpdate(DocumentEvent e) {
	            validateInput(textField);
	        }

	        @Override
	        public void changedUpdate(DocumentEvent e) {
	            validateInput(textField);
	        }
	    });
	}

	public void validateInput(JTextField textField) {
	    String text = textField.getText();
	    try {
	        int number = Integer.parseInt(text);
	        if (number < 0 || number > 999) {
	            textField.setText("");
	        }
	    } catch (NumberFormatException ex) {
	        textField.setText("");
	    }
	}
}
*/

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
}
