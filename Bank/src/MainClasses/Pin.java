package MainClasses;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DbConnection.Conn;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Pin extends JFrame {

	private JPanel contentPane;
	private JPasswordField t1;
	private JPasswordField t2;
	private JPasswordField t3;
	private JButton b1;
	private JButton b2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pin frame = new Pin();
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
	public Pin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 325);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CHANGE YOUR PIN");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(125, 28, 195, 14);
		contentPane.add(lblNewLabel);
		
		JLabel l1 = new JLabel("Current PIN:");
		l1.setFont(new Font("Tahoma", Font.BOLD, 14));
		l1.setBounds(67, 72, 89, 14);
		contentPane.add(l1);
		
		JLabel l2 = new JLabel("New PIN:");
		l2.setFont(new Font("Tahoma", Font.BOLD, 14));
		l2.setBounds(67, 115, 89, 14);
		contentPane.add(l2);
		
		JLabel l3 = new JLabel("Re-Enter PIN:");
		l3.setFont(new Font("Tahoma", Font.BOLD, 14));
		l3.setBounds(67, 171, 98, 14);
		contentPane.add(l3);
		
		t1 = new JPasswordField();
		t1.setFont(new Font("Tahoma", Font.BOLD, 14));
		t1.setBounds(213, 69, 89, 20);
		contentPane.add(t1);
		
		t2 = new JPasswordField();
		t2.setFont(new Font("Tahoma", Font.BOLD, 14));
		t2.setBounds(213, 112, 89, 20);
		contentPane.add(t2);
		
		t3 = new JPasswordField();
		t3.setFont(new Font("Tahoma", Font.BOLD, 14));
		t3.setBounds(213, 168, 89, 20);
		contentPane.add(t3);
		
		b1 = new JButton("SAVE");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				try {
					
					
					
					String a=t1.getText();
					String b=t2.getText();
					String c=t3.getText();
					
					
					
					
					
					
					
					
					 if(t1.getText().equals(""))
					 {
						 JOptionPane.showMessageDialog(null,"Please enter current PIN:");
					 }
					 
					 if(t2.getText().equals(""))
					 {
						 JOptionPane.showMessageDialog(null,"Please enter new PIN:");
					 }
					 
					 if(t3.getText().equals(""))
					 {
						 JOptionPane.showMessageDialog(null,"Please re-enter new PIN:");
					 }
					 
					 
					 
					 if(t2.getText().equals(t3.getText()))
					 {
						 
						 
						 Connection con=Conn.getCon();		 
						Statement s=con.createStatement();
						
						
						String q1="update banks set pin='"+b+"' where pin='"+a+"'";
						String q2="update login set pin='"+b+"' where pin='"+a+"'";
						String q3="update signup3 set pin='"+b+"' where pin='"+a+"'";
			
						s.executeUpdate(q1);
						s.executeUpdate(q2);
						s.executeUpdate(q3);
						
						
						JOptionPane.showMessageDialog(null,"PIN changed successfully.");
						
						new Transactions().setVisible(true);
						setVisible(false);
						 
					 }
					 
					 else
					 {
							JOptionPane.showMessageDialog(null,"PIN entered doesn't match.");						
					 }
					 
					 
					 
					 
				} catch (Exception e2) {
					System.out.println("Exception:"+e2);
				}
				
				
				 
				 
		
				
				
			}
		});
		b1.setFont(new Font("Tahoma", Font.BOLD, 15));
		b1.setBounds(93, 224, 89, 23);
		contentPane.add(b1);
		
		b2 = new JButton("BACK");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Transactions().setVisible(true);
				setVisible(false);
			}
		});
		b2.setFont(new Font("Tahoma", Font.BOLD, 15));
		b2.setBounds(241, 224, 89, 23);
		contentPane.add(b2);
	}
}
