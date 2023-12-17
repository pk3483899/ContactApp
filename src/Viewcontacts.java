import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import app.dbtask.DatabaseConnection;

import java.sql.*;
import java.awt.Color;

//import java.

public class Viewcontacts extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private Connection con;
	private String[]columnNames= {"Name","Email","ContactNumber"};
	private Object[][]data;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Viewcontacts frame = new Viewcontacts();
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
	public Viewcontacts() {
		con=DatabaseConnection.createConnection();
		
		
		createContacts();
		
	}
	//1. find the number of records(will create double dimentaiton rows)
	//2. create object of double dimension array
	//3. populate double dimension array from database table contacts
	
	public void populateArray() 
	{
	PreparedStatement pscount,psdata;
	ResultSet rscount,rsdata;  //result set and result data
	
	try {
		String strcount="select count(*) from contacts";
		pscount=con.prepareStatement(strcount);
		rscount=pscount.executeQuery();
		if(rscount.next())
		{
		int row_count=rscount.getInt(1); //it will read the data from first column
		System.out.println(row_count);
		
		data=new Object[row_count][3];  //making object of 2D array
		
		String strsql="select * from contacts";
		psdata=con.prepareStatement(strsql);
		
		rsdata=psdata.executeQuery();  //it will fetch all the records from contacts table and assign reference to rsdata
		int row=0;
		while(rsdata.next())
		{
			String name=rsdata.getString("name");  //filling values in rows and colums of 2d array from the database
			String em=rsdata.getString("email");
			String ph=rsdata.getString("phone");
			data[row][0]=name;
			data[row][1]=em;
			data[row][2]=ph;
			row++;
		}
		
		}
		else {
			JOptionPane.showMessageDialog(this,"No contact to show");
			
		}
		
	}
	catch(SQLException se)
	{
		se.printStackTrace();
	}
		
	}
	
	
	
	
	
	
	
	public void createContacts() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 788, 609);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(115, 98, 469, 363);
		contentPane.add(scrollPane);
		
		table = new JTable();
		
		
		JTableHeader header=table.getTableHeader();
		header.setForeground(Color.white);
		header.setBackground(Color.black);
		header.setFont(new Font("Comic Sans Ms",Font.BOLD,20));
		
		
		populateArray();  //data populate
		
		
//		for(int i=0;i<2;i++)
//		{
//			for(int j=0;j<3;j++)
//			{
//				System.out.println(data[i][j]);
//			}
//		}
		
		table.setModel(new DefaultTableModel(data,columnNames)); //it will show records in the table
		
		
		
//		table.setModel(new DefaultTableModel(
//			new Object[][] {
//				{"Scott"},
//				{"Aman"},
//			},
//			new String[] {
//				"Name"
//			}
//		));
		scrollPane.setViewportView(table);
	}
}
