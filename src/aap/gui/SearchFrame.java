package aap.gui;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import app.dbtask.DatabaseConnection;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.*;
import java.sql.*;
public class SearchFrame extends JFrame implements ActionListener

{

	private JPanel contentPane;
	private JTextField txtPhone;
	private JTextField txtname;
	private Connection con;
	private JTextField txtemail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchFrame frame = new SearchFrame();
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
	public SearchFrame() {
		con=DatabaseConnection.createConnection();  //to established the connection to the sql
	createComponents();
}
	public void createComponents() {
	setIconImage(Toolkit.getDefaultToolkit().getImage(SearchFrame.class.getResource("/app/images/pexels-photo-753626.jpg")));
	setTitle("SearchFrame");
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	setBounds(100, 100, 549, 400);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JLabel lblNewLabel = new JLabel("Phone Number");
	lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
	lblNewLabel.setBounds(10, 63, 131, 29);
	contentPane.add(lblNewLabel);
	
	txtPhone = new JTextField();
	txtPhone.setFont(new Font("Tahoma", Font.PLAIN, 16));
	txtPhone.setBounds(151, 66, 137, 21);
	contentPane.add(txtPhone);
	txtPhone.setColumns(10);
	
	JButton btnSearch = new JButton("Search");
	btnSearch.addActionListener(this);
	btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 17));
	btnSearch.setBounds(321, 66, 105, 21);
	contentPane.add(btnSearch);
	
	JLabel lblName = new JLabel("Name");
	lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
	lblName.setBounds(10, 134, 131, 29);
	contentPane.add(lblName);
	
	txtname = new JTextField();
	txtname.setEditable(false);
	txtname.setEnabled(false);
	txtname.setFont(new Font("Tahoma", Font.PLAIN, 16));
	txtname.setColumns(10);
	txtname.setBounds(151, 141, 158, 21);
	contentPane.add(txtname);
	
	JLabel lblEmail = new JLabel("Email");
	lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
	lblEmail.setBounds(10, 196, 131, 29);
	contentPane.add(lblEmail);
	
	txtemail = new JTextField();
	txtemail.setFont(new Font("Tahoma", Font.PLAIN, 16));
	txtemail.setEnabled(false);
	txtemail.setEditable(false);
	txtemail.setColumns(10);
	txtemail.setBounds(151, 199, 158, 21);
	contentPane.add(txtemail);
}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Botton is being clicked");
		
		String phone=txtPhone.getText();
		
		if(phone.isEmpty())
		{
			JOptionPane.showMessageDialog(this, "PhoneNumber Required ", "Mandatory ",JOptionPane.ERROR_MESSAGE);
		}
		else {
			String strsql="select * from contacts where phone = ?";
		
		PreparedStatement ps;
		ResultSet rs;
		try {
		ps=con.prepareStatement(strsql);
		ps.setString(1,phone);
		rs=ps.executeQuery();
		if(rs.next())
		{
			String nm=rs.getString("Name"); //the name is taken from the sql database name
			String em=rs.getString("email");
			
			txtname.setText(nm);
			txtemail.setText(em);
			
			
		}
		else {
			JOptionPane.showMessageDialog(this, "No such Phone number Exists ");
		}
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
	}
	}
}
