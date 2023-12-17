package aap.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import app.dbtask.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.*;

import java.sql.*;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class DeleteContact extends JFrame implements ActionListener
{

	private JPanel contentPane;
	private JTextField txtphone;
	private Connection con;
	private PreparedStatement ps;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteContact frame = new DeleteContact();
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
	public DeleteContact() {
		//setIconImage(Toolkit.getDefaultToolkit().getImage(DeleteContact.class.getResource("/digital/images/bheem.png")));
		
		con=DatabaseConnection.createConnection();
		createComponents();
	}
	
	
	
	public void createComponents()
	{
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 854, 640);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PhoneNumber");
		lblNewLabel.setFont(new Font("Candara", Font.BOLD, 17));
		lblNewLabel.setBounds(88, 126, 180, 34);
		contentPane.add(lblNewLabel);
		
		txtphone = new JTextField();
		txtphone.setBounds(337, 131, 244, 42);
		contentPane.add(txtphone);
		txtphone.setColumns(10);
		
		JButton btndelete = new JButton("Delete");
		btndelete.addActionListener(this);
		btndelete.setFont(new Font("Candara", Font.BOLD, 17));
		btndelete.setBounds(288, 326, 145, 34);
		contentPane.add(btndelete);
		
		lblNewLabel_1 = new JLabel("");
		//lblNewLabel_1.setIcon(new ImageIcon(DeleteContact.class.getResource("/digital/images/enquiry.png")));
		lblNewLabel_1.setBounds(0, 0, 840, 603);
		contentPane.add(lblNewLabel_1);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String phone=txtphone.getText();
		if(phone.isEmpty())
			JOptionPane.showMessageDialog(this, "Please Enter Phone Number","Required Fields",JOptionPane.ERROR_MESSAGE);
		
		else {
			
	int status=		JOptionPane.showConfirmDialog(this, "Are You sure you wish to delete this "+phone+" Number");
		System.out.println(status);
		if(status==0)
			
		{
			String strdelete="delete from contacts where phone=?";
			
			try {
				ps=con.prepareStatement(strdelete);
				ps.setString(1, phone); //place holder position
			int row_status=ps.executeUpdate();
			if(row_status>0)
			{
				JOptionPane.showMessageDialog(this, "PhoneNumberDeleted Successfully","Deletion",JOptionPane.INFORMATION_MESSAGE);
				txtphone.setText("");
			}
			
			else
			{
				JOptionPane.showMessageDialog(this, "No such Number Exists","numberchecking",JOptionPane.ERROR_MESSAGE);
				txtphone.setText("");
			}
				
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
			finally {
				
				
				if(ps!=null)
					try {
						ps.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
			
			
			
			
					
			
		}
			
		}
		
		
		
	}
	
	
	
	
	
}
