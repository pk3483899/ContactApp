package aap.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class SplashScreen extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
												//The concept of event dispatcher thread which was lucnh in
									//jdk1.5 the task is to do all the operations of gui.
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SplashScreen frame = new SplashScreen();
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
	public SplashScreen() {
		CreateFomponents();
		loadFrame();
		
	}
	public void loadFrame()
	{
	Thread t=new Thread(
			new Runnable()
			{
				public void run() //This is the anonymous inner class object
				{
					try {
						Thread.sleep(4000);
						
						
						LoginFrame login=new LoginFrame();
						login.setVisible(true);
						SplashScreen.this.dispose();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
			
			
			);  //constructor close
	t.start(); //to start the thread
	
	
	}
	public void CreateFomponents()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 653, 408);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Contacts App Welcomes  You");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblNewLabel.setBounds(169, 10, 271, 38);
		contentPane.add(lblNewLabel);
	}
}
