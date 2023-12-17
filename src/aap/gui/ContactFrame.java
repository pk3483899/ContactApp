package aap.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import app.dbtask.DatabaseConnection;

import java.awt.Color;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import java.sql.*;
import java.util.*;


public class ContactFrame extends JFrame implements ActionListener,KeyListener,WindowListener
{

	private JPanel contentPane;
	private JTextField txtname;
	private JTextField txtemail;
	private JTextField txtphone;

	private JRadioButton Rdmale,Rdfemale;
	private JTextArea txtArea;
	private final ButtonGroup gender_group = new ButtonGroup();
	private Connection con;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContactFrame frame = new ContactFrame();
					frame.setVisible(true);
				} 
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ContactFrame() {
		this.addWindowListener(this);//register listener with frame
		con=DatabaseConnection.createConnection();//it will give the reference of MyContacts database
		createComponents();
	}
	public void createComponents()
		{
			setTitle("CantactFrame");
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//it will close only this frame
			setBounds(100, 100, 542, 361);
			contentPane = new JPanel();
			contentPane.setBackground(Color.WHITE);
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			
			setLocationRelativeTo(null);   //open in the center of the frame
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Name");
			lblNewLabel.setForeground(Color.CYAN);
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblNewLabel.setBounds(58, 22, 54, 20);
			contentPane.add(lblNewLabel);
			
			txtname = new JTextField();
			txtname.addKeyListener(this);
			txtname.setFont(new Font("Tahoma", Font.PLAIN, 15));
			txtname.setBounds(147, 22, 116, 28);
			contentPane.add(txtname);
			txtname.setColumns(10);
			
			JLabel lblNewLabel_1 = new JLabel("Email");

			lblNewLabel_1.setForeground(Color.CYAN);
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblNewLabel_1.setBounds(58, 52, 77, 34);
			contentPane.add(lblNewLabel_1);
			
			txtemail = new JTextField();

			txtemail.setFont(new Font("Tahoma", Font.PLAIN, 15));
			txtemail.setBounds(147, 62, 116, 19);
			contentPane.add(txtemail);
			txtemail.setColumns(10);
			
			JLabel lblNewLabel_2 = new JLabel("Phone");

			lblNewLabel_2.setForeground(Color.CYAN);
			lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblNewLabel_2.setBounds(58, 96, 54, 28);
			contentPane.add(lblNewLabel_2);
			
			txtphone = new JTextField();
			txtphone.addKeyListener(this);

			txtphone.setFont(new Font("Tahoma", Font.PLAIN, 15));
			txtphone.setBounds(147, 103, 116, 19);
			contentPane.add(txtphone);
			txtphone.setColumns(10);
			
			JLabel lblNewLabel_3 = new JLabel("address");
			lblNewLabel_3.setForeground(Color.CYAN);
			lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblNewLabel_3.setBounds(58, 134, 77, 28);
			contentPane.add(lblNewLabel_3);
			
			 txtArea = new JTextArea();
			txtArea.setWrapStyleWord(true);
			txtArea.setLineWrap(true);
			txtArea.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 14));
			txtArea.setBounds(147, 138, 116, 32);
			contentPane.add(txtArea);
			
			Rdmale = new JRadioButton("Male");
			gender_group.add(Rdmale);
			Rdmale.setForeground(Color.CYAN);
			Rdmale.setOpaque(false);
			Rdmale.setBackground(new Color(102, 255, 102));
			Rdmale.setFont(new Font("Tahoma", Font.BOLD, 16));
			Rdmale.setBounds(58, 176, 103, 21);
			contentPane.add(Rdmale);
			
		 Rdfemale = new JRadioButton("Female");
			gender_group.add(Rdfemale);
			Rdfemale.setForeground(Color.CYAN);
			Rdfemale.setOpaque(false);
			Rdfemale.setBackground(new Color(102, 255, 102));
			Rdfemale.setFont(new Font("Tahoma", Font.BOLD, 16));
			Rdfemale.setBounds(254, 176, 103, 21);
			contentPane.add(Rdfemale);
			
			JButton btnSubmit = new JButton("SUBMIT ");
			btnSubmit.setForeground(new Color(0, 0, 51));
			btnSubmit.setBackground(new Color(255, 204, 255));
			btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 17));
			btnSubmit.addActionListener(this); //register the listener with source
			btnSubmit.addKeyListener(this);//register keyListener here
			btnSubmit.setBounds(150, 203, 125, 34);
			contentPane.add(btnSubmit);
			JLabel lblNewLabel_4 = new JLabel("");
			lblNewLabel_4.setIcon(new ImageIcon(ContactFrame.class.getResource("/app/images/Background3.jpg")));
			lblNewLabel_4.setBounds(10, 0, 520, 333);
			contentPane.add(lblNewLabel_4);
		}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		insertData();
	}
	
	public void insertData()
	{// TODO Auto-generated method stub
		
		String nm=txtname.getText().trim();
		String phone=txtphone.getText().trim();
		String email=txtemail.getText().trim();
		String add=txtArea.getText().trim();
		
		String gender="";
		
		if(Rdmale.isSelected())
			gender=Rdmale.getText();
		
		if(Rdfemale.isSelected())
			gender=Rdfemale.getText();

		
		
		if(nm.length()>0 && phone.length()>0&&email.length()>0 && add.length()>0 &&gender.length()>0)
		{
			//query to insert data in the table
			String strinsert="insert into contacts(Name, email, Phone, address, gender, Date)values(?,?,?,?,?,?)";
			
			PreparedStatement ps=null;
			try {
				
			java.util.	Date d=new java.util.Date();
			
			//System.out.println(d);
			
			long dt=d.getTime();
			java.sql.Date sd=new java.sql.Date(dt);//util date is getting converted into sql date
			
			ps=con.prepareStatement(strinsert);//passes query to RDBMS ->complied query ref is assigned to ps
			
			ps.setString(1, nm);
			ps.setString(2, email);
			ps.setString(3, phone);
			ps.setString(4, add);
			ps.setString(5, gender);
			ps.setDate(6, sd);
			int status=	ps.executeUpdate();
			if(status>0)
			{
			JOptionPane.showMessageDialog(this, "contact added");
			
			txtArea.setText("");
			txtemail.setText("");
			txtname.setText("");
			txtphone.setText("");
			gender_group.clearSelection();
		
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
					//con.close();
				}
				
				catch(SQLException se)
				{
					
					se.printStackTrace();
				}
				
				
			}
			
			
		}
		else
			
		{

	
	JOptionPane.showMessageDialog(this, "All fields are amndatory");
			

		}
		
		
		
		
		
		
		
		
		
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		// TODO Auto-generated method stub
		char c=e.getKeyChar();
		if(e.getSource()==txtname)
		{
			if(!((c==KeyEvent.VK_BACK_SPACE)|| (c==KeyEvent.VK_DELETE) ||
				(c==KeyEvent.VK_ENTER) || (c==KeyEvent.VK_TAB)|| (Character.isLetter(c))))
{
	e.consume();
	JOptionPane.showMessageDialog(this, "Name Requires Only Alphabets");
}
		}
		
		
		//char d=e.getKeyChar();
		if(e.getSource()==txtphone)
		{
			if(!((c==KeyEvent.VK_BACK_SPACE)|| (c==KeyEvent.VK_DELETE) ||
				(c==KeyEvent.VK_ENTER) || (c==KeyEvent.VK_TAB)|| (Character.isDigit(c))))
{
	e.consume();
	JOptionPane.showMessageDialog(this, "Phone Number requires Only Digits");
}
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int code=e.getKeyCode();
		System.out.println(code);
		if(code==10)
			insertData();
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
//		adminFeame af=new adminFeame();
//		af.setVisible(true);
//		this.dispose();
		DatabaseConnection.closeConnection();//it will close the connection
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}