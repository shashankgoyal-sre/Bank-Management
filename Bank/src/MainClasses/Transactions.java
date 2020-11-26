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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Transactions extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Transactions frame = new Transactions();
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
	public Transactions() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel l1 = new JLabel("Please Select Your Transaction");
		l1.setFont(new Font("Tahoma", Font.BOLD, 18));
		l1.setBounds(249, 55, 425, 48);
		contentPane.add(l1);
		
		JButton b1 = new JButton("DEPOSIT");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Deposit().setVisible(true);
				setVisible(false);
			}
		});
		b1.setForeground(new Color(0, 0, 0));
		b1.setFont(new Font("Tahoma", Font.BOLD, 15));
		b1.setBounds(102, 162, 155, 23);
		contentPane.add(b1);
		
		JButton b2 = new JButton("CASH WITHDRAWL");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Withdrawl().setVisible(true);
				setVisible(false);
			}
		});
		b2.setFont(new Font("Tahoma", Font.BOLD, 15));
		b2.setBounds(449, 162, 186, 23);
		contentPane.add(b2);
		
		JButton b4 = new JButton("MINI STATEMENT");
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MiniStatement().setVisible(true);
                 setVisible(false);
			}
		});
		b4.setFont(new Font("Tahoma", Font.BOLD, 15));
		b4.setBounds(449, 259, 186, 23);
		contentPane.add(b4);
		
		JButton b5 = new JButton("PIN CHANGE");
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Pin().setVisible(true);
				setVisible(false);
			}
			
		});
		b5.setFont(new Font("Tahoma", Font.BOLD, 15));
		b5.setBounds(102, 259, 155, 23);
		contentPane.add(b5);
		
		JButton b6 = new JButton("BALANCE ENQUIRY");
		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String pinn=JOptionPane.showInputDialog("Enter Pin:");
				Connection con=Conn.getCon();
				
				try {
					
					
					
					Statement s=con.createStatement();
					//String q="select balance from banks ORDER BY pin='"+pinn+"' DESC LIMIT 1";
				//	String q="select balance from banks ORDER BY pin="+pinn+" DESC LIMIT 1";
					String q="select * from banks where pin ='"+pinn+"'";
					ResultSet rs=s.executeQuery(q);
					
					if(rs.last())
					{
				Double balance=rs.getDouble("balance");
						JOptionPane.showMessageDialog(null,"Your Account Balance is"+balance);
					}
					
					
					
				} catch (Exception e2) {
				System.out.println("Exception:"+e2);	
				}
				
				
				
				
				
			}
		});
		b6.setFont(new Font("Tahoma", Font.BOLD, 15));
		b6.setBounds(449, 351, 186, 23);
		contentPane.add(b6);
		
		JButton b7 = new JButton("EXIT");
		b7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		b7.setFont(new Font("Tahoma", Font.BOLD, 15));
		b7.setBounds(102, 351, 155, 23);
		contentPane.add(b7);
	}
}
