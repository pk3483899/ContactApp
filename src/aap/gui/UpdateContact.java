package aap.gui;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import app.dbtask.*;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.sql.*;
import java.awt.event.*;
public class UpdateContact extends JFrame implements ActionListener
{

	private JPanel contentPane;
	private JTextField txtemail;
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateContact frame = new UpdateContact();
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
	JComboBox<String>cmbphone;
	JTextArea txtaddress;
	JButton btnupdate;
	
	public void fillCombo()
	{
		String strsql="select phone from contacts";
		
		try {
			ps=con.prepareStatement(strsql);
		rs=	ps.executeQuery();  //when we wish to read data from the table
			while(rs.next())
			{
				
				String phone=rs.getString("phone");
				cmbphone.addItem(phone);
			}
			
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		
		finally {
			
			try {
				if(ps!=null)
					ps.close();
				if(rs!=null)
					rs.close();
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
		}	
		
	}
	
	
	public void createComponents()
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 991, 721);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		cmbphone = new JComboBox();
		
		cmbphone.addActionListener(this);
		
		cmbphone.setModel(new DefaultComboBoxModel(new String[] {"Select Phone Number"}));
		fillCombo();
		
		cmbphone.setBounds(347, 104, 237, 22);
		contentPane.add(cmbphone);
		
		txtemail = new JTextField();
		txtemail.setBounds(381, 231, 191, 66);
		contentPane.add(txtemail);
		txtemail.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Email");
		lblNewLabel.setBounds(126, 238, 105, 52);
		contentPane.add(lblNewLabel);
		
		txtaddress = new JTextArea();
		txtaddress.setBounds(381, 381, 267, 124);
		contentPane.add(txtaddress);
		
		JLabel lbladdress = new JLabel("Address");
		lbladdress.setBounds(117, 413, 127, 93);
		contentPane.add(lbladdress);
		
		 btnupdate = new JButton("Update");
		btnupdate.addActionListener(this);
		btnupdate.setBounds(404, 565, 168, 42);
		contentPane.add(btnupdate);
	}
	public UpdateContact() {
		con=DatabaseConnection.createConnection();
		createComponents();
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
	
		String phone=null,name=null;
		if(e.getSource()==cmbphone)
		{
			System.out.println("combo is selected");
			phone=(String)cmbphone.getSelectedItem();
		String strsql="select * from contacts where phone=?";
		try {
			
			ps=con.prepareStatement(strsql);
			ps.setString(1, phone);
			rs=ps.executeQuery();
			if(rs.next())
			{
				String user_email=rs.getString("email");
				String user_address=rs.getString("address");
				txtemail.setText(user_email);
				
				txtaddress.setText(user_address);
				name=rs.getString("name");
			}
			
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
			
		finally {
		
			try {
				if(ps!=null)
					ps.close();
				if(rs!=null)
					rs.close();
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
		}
		
		
		
			
		}
		
		
		if(e.getSource()==btnupdate)
		{	
			
			System.out.println("button is clicked");
			
			phone=(String)cmbphone.getSelectedItem();
			
			String newmail=txtemail.getText();
			String newaddress=txtaddress.getText();
			
	String strupdate="update contacts set email=?,address=? where phone=?";
	try {
		ps=con.prepareStatement(strupdate);
		ps.setString(1,newmail);
		ps.setString(2,newaddress);
		ps.setString(3,phone);
		System.out.println(ps+name);
	int row=ps.executeUpdate();
	
	if(row>0)
	{
		JOptionPane.showMessageDialog(this, "Contact details has been updated successfully");
	}
		
	}
	catch(SQLException se)
	{
		se.printStackTrace();
	}
		
	finally {
		
		try {
			if(ps!=null)
				ps.close();
			
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
	}	
		}
		
	}
	
	
	
}
