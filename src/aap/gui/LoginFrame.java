package aap.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.*;
public class LoginFrame extends JFrame implements ActionListener 
{
	private JPanel contentPane;
	private JTextField txtuserId;
	private JPasswordField txtxuserpass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		createComponents();
	}
	
	
	public void createComponents()
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginFrame.class.getResource("/app/images/Background.jpg")));
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 396);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login Frame");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(255, 250, 205));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(128, 0, 0));
		lblNewLabel.setFont(new Font("Microsoft YaHei", Font.BOLD, 20));
		lblNewLabel.setBounds(142, 33, 131, 27);
		contentPane.add(lblNewLabel);
		
		JLabel UserId = new JLabel("UserId");
		UserId.setForeground(new Color(244, 164, 96));
		UserId.setFont(new Font("Tahoma", Font.BOLD, 16));
		UserId.setBounds(41, 87, 141, 22);
		contentPane.add(UserId);
		
		txtuserId = new JTextField();
		txtuserId.setBounds(231, 82, 131, 27);
		contentPane.add(txtuserId);
		txtuserId.setColumns(10);
		
		JLabel Password = new JLabel("Pass");
		Password.setForeground(new Color(244, 164, 96));
		Password.setFont(new Font("Tahoma", Font.BOLD, 17));
		Password.setBounds(41, 133, 87, 27);
		contentPane.add(Password);
		
		txtxuserpass = new JPasswordField();
		txtxuserpass.setBounds(231, 136, 131, 27);
		contentPane.add(txtxuserpass);
		
		JButton btnsubmit = new JButton("SUBMIT");
		btnsubmit.addActionListener(this); //register the listener with source
		btnsubmit.setActionCommand("Submit");
		btnsubmit.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnsubmit.setForeground(new Color(244, 164, 96));
		btnsubmit.setBounds(188, 221, 174, 51);
		contentPane.add(btnsubmit);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String id=txtuserId.getText().trim();
		char[] pwd=txtxuserpass.getPassword(); //Fetching the value from Jpassword
		String password=String.valueOf(pwd).trim(); //converting char[] into String
		
		if(id.length()>0 && password.length()>0)
		{
			if(id.equals("Pradeep")&& password.equals("lucknow"))
			{
				JOptionPane.showMessageDialog(this, "Welcome"+id);
				adminFeame ad=new adminFeame();
				ad.setVisible(true);
				this.dispose(); //closing login frame
			}
		
		else
		{
			JOptionPane.showMessageDialog(this, "Invalid credentials");
		}
	}
		
		else
		{
			JOptionPane.showMessageDialog(this, "Data required for the User Id and Password");
		}
		
	} 
	
}
