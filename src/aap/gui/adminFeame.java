package aap.gui;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Frame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Toolkit;
import java.awt.event.*;

public class adminFeame extends JFrame  implements ActionListener,WindowListener
{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminFeame frame = new adminFeame();
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
	JMenuItem mi_add,mi_update,mi_delete,mi_number;
	public adminFeame() {
		this.addWindowListener(this);
		
		//int x=10;
		//System.out.println(x);
		setIconImage(Toolkit.getDefaultToolkit().getImage(adminFeame.class.getResource("/app/images/pexels-photo-753626.jpg")));
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setTitle("AdminFrame");
//		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  //it is default provided by the swing
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu_contact = new JMenu("Contacts");
		menu_contact.setIcon(null);
		menu_contact.setForeground(Color.BLUE);
		menu_contact.setFont(new Font("Segoe UI", Font.BOLD, 20));
		menuBar.add(menu_contact);
		
		 mi_add = new JMenuItem("Add");
		 mi_add.addActionListener(this);
		 
		mi_add.setIcon(new ImageIcon(adminFeame.class.getResource("/app/images/plus (1).png")));
		mi_add.setForeground(Color.BLUE);
		mi_add.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menu_contact.add(mi_add);
		
		 mi_update = new JMenuItem("Update");
		 mi_update.addActionListener(this);

		mi_update.setIcon(new ImageIcon(adminFeame.class.getResource("/app/images/refresh (1).png")));
		mi_update.setForeground(Color.BLUE);
		mi_update.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menu_contact.add(mi_update);
		
		 mi_delete = new JMenuItem("Delete");
		 mi_delete.addActionListener(this);
		 
		mi_delete.setIcon(new ImageIcon(adminFeame.class.getResource("/app/images/delete-button (1).png")));
		mi_delete.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mi_delete.setForeground(Color.BLUE);
		menu_contact.add(mi_delete);
		
		JMenu mnSearch = new JMenu("Search");
		 mi_add.addActionListener(this);

		mnSearch.setForeground(Color.BLUE);
		mnSearch.setFont(new Font("Segoe UI", Font.BOLD, 20));
		menuBar.add(mnSearch);
		
		 mi_number = new JMenuItem("ByNumber");
		 mi_number.addActionListener(this);

		mi_number.setIcon(new ImageIcon(adminFeame.class.getResource("/app/images/search.png")));
		mnSearch.add(mi_number);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 205));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(adminFeame.class.getResource("/app/images/Background 2.jpg")));
		lblNewLabel.setBounds(0, 0, 1920, 1020);
		contentPane.add(lblNewLabel);
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {

		String caption=e.getActionCommand();
		if(caption.equalsIgnoreCase("add"))
		{
			ContactFrame cf=new ContactFrame();
					cf.setVisible(true);
		}
		String caption1=e.getActionCommand();
		if(caption1.equalsIgnoreCase("update"))
		{
		UpdateContact cf=new UpdateContact();
					cf.setVisible(true);
		}
		
		String caption2=e.getActionCommand();
		if(caption2.equalsIgnoreCase("delete"))
		{
			DeleteContact cf=new DeleteContact();

					cf.setVisible(true);
		}
		
		String caption3=e.getActionCommand();
		if(caption3.equalsIgnoreCase("ByNumber"))
		{
			SearchFrame cf=new SearchFrame();

					cf.setVisible(true);
		}
	
		
	}



	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		LoginFrame login=new LoginFrame();
		login.setVisible(true);
		this.dispose();

		
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
