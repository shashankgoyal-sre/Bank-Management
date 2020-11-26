package MainClasses;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DbConnection.Conn;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.awt.Point;
import java.awt.Toolkit;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField tf1;
	private JPasswordField pf2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setLocation(new Point(700, 700));
		setLocationByPlatform(true);
		setTitle("BANKING MANAGEMENT");
		setResizable(false);
		
		//setLocation(100,1000);
		//setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
	
setLocationRelativeTo(null);
	
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel l1 = new JLabel("WELCOME TO ATM");
		l1.setFont(new Font("Tahoma", Font.BOLD, 14));
		l1.setBounds(154, 30, 135, 14);
		contentPane.add(l1);
		
		JLabel l2 = new JLabel("Card No:");
		l2.setFont(new Font("Tahoma", Font.BOLD, 14));
		l2.setBounds(52, 76, 78, 14);
		contentPane.add(l2);
		
		JLabel l3 = new JLabel("PIN:");
		l3.setFont(new Font("Tahoma", Font.BOLD, 14));
		l3.setBounds(52, 120, 48, 14);
		contentPane.add(l3);
		
		tf1 = new JTextField();
		tf1.setFont(new Font("Tahoma", Font.BOLD, 14));
		tf1.setBounds(201, 73, 135, 20);
		contentPane.add(tf1);
		tf1.setColumns(10);
		
		pf2 = new JPasswordField();
		pf2.setFont(new Font("Tahoma", Font.BOLD, 14));
		pf2.setBounds(201, 117, 135, 20);
		contentPane.add(pf2);
		
		JButton b1 = new JButton("SIGN IN");
		b1.setFont(new Font("Tahoma", Font.BOLD, 14));
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				try {
					
					
					Connection c1=Conn.getCon();
					
					String a=tf1.getText();
					String b=pf2.getText();
					
					String q="select * from login where cardno='"+a+"' and pin='"+b+"'";
					Statement s=c1.createStatement();
					ResultSet rs=s.executeQuery(q);
					
					if(rs.next())
					{
						new Transactions().setVisible(true);
						setVisible(false);
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Invalid card no or pin.");
					}
					
					
					
				} catch (Exception e2) {
					System.out.println("Error:"+e2);
				}
				
				
				
			}
		});
		b1.setBounds(165, 161, 103, 23);
		contentPane.add(b1);
		
		JButton b2 = new JButton("CLEAR");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tf1.setText("");
				pf2.setText("");
				
			}
		});
		b2.setFont(new Font("Tahoma", Font.BOLD, 14));
		b2.setBounds(289, 161, 103, 23);
		contentPane.add(b2);
		
		JButton b3 = new JButton("SIGN UP");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new Signup().setVisible(true);
				setVisible(false);
				
			}
		});
		b3.setFont(new Font("Tahoma", Font.BOLD, 14));
		b3.setBounds(224, 207, 112, 23);
		contentPane.add(b3);
	}
}
