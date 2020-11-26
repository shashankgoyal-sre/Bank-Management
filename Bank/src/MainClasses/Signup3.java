package MainClasses;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.email.durgesh.Email;

import DbConnection.Conn;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import java.awt.event.ActionEvent;

public class Signup3 extends JFrame {

	private JPanel contentPane;
	JRadioButton r1,r2,r3;
	private JTextField t1;
	JCheckBox c1,c2,c3,c4,c5,c6,c7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signup3 frame = new Signup3();
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
	public Signup3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,700, 700);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel l1 = new JLabel("Page 3:Account Details");
		l1.setFont(new Font("Tahoma", Font.BOLD, 14));
		l1.setBounds(235, 23, 175, 23);
		contentPane.add(l1);
		
		JLabel l11 = new JLabel("Form No:");
		l11.setFont(new Font("Tahoma", Font.BOLD, 14));
		l11.setBounds(543, 11, 70, 35);
		contentPane.add(l11);
		
		JLabel l2 = new JLabel("Account Type");
		l2.setFont(new Font("Tahoma", Font.BOLD, 14));
		l2.setBounds(147, 66, 120, 28);
		contentPane.add(l2);
		
		 r1 = new JRadioButton("Saving Account\r\n");
		r1.setFont(new Font("Tahoma", Font.BOLD, 14));
		r1.setBounds(175, 101, 138, 23);
		contentPane.add(r1);
		
		 r2 = new JRadioButton("Fixed Deposit Account");
		r2.setFont(new Font("Tahoma", Font.BOLD, 14));
		r2.setBounds(361, 101, 187, 23);
		contentPane.add(r2);
		
		 r3 = new JRadioButton("Current Account");
		r3.setFont(new Font("Tahoma", Font.BOLD, 14));
		r3.setBounds(271, 144, 139, 23);
		contentPane.add(r3);
		
		JLabel l3 = new JLabel("Card Number:");
		l3.setFont(new Font("Tahoma", Font.BOLD, 14));
		l3.setBounds(147, 210, 97, 23);
		contentPane.add(l3);
		
		JLabel l5 = new JLabel("(Your 16 Digit Card Number)");
		l5.setBounds(106, 234, 138, 14);
		contentPane.add(l5);
		
		JLabel l4 = new JLabel("XXXX-XXXX-XXXX-");
		l4.setFont(new Font("Tahoma", Font.BOLD, 14));
		l4.setBounds(332, 214, 241, 14);
		contentPane.add(l4);
		
		JLabel l6 = new JLabel("(It would appear on ATM Card/Cheque Book)");
		l6.setBounds(332, 234, 241, 14);
		contentPane.add(l6);
		
		JLabel l7 = new JLabel("PIN:");
		l7.setFont(new Font("Tahoma", Font.BOLD, 14));
		l7.setBounds(147, 290, 48, 14);
		contentPane.add(l7);
		
		JLabel l9 = new JLabel("(4-digit password)");
		l9.setBounds(106, 307, 106, 14);
		contentPane.add(l9);
		
		JLabel l8 = new JLabel("XXXX");
		l8.setFont(new Font("Tahoma", Font.BOLD, 14));
		l8.setBounds(332, 290, 48, 14);
		contentPane.add(l8);
		
		JLabel l10 = new JLabel("Services Required:");
		l10.setFont(new Font("Tahoma", Font.BOLD, 14));
		l10.setBounds(147, 368, 138, 30);
		contentPane.add(l10);
		
	 c1 = new JCheckBox("ATM Card\r\n");
		c1.setFont(new Font("Tahoma", Font.BOLD, 14));
		c1.setBounds(170, 412, 97, 23);
		contentPane.add(c1);
		
		 c3 = new JCheckBox("Mobile Banking");
		c3.setFont(new Font("Tahoma", Font.BOLD, 14));
		c3.setBounds(170, 451, 143, 23);
		contentPane.add(c3);
		
	 c5 = new JCheckBox("Cheque Book");
		c5.setFont(new Font("Tahoma", Font.BOLD, 14));
		c5.setBounds(170, 501, 143, 23);
		contentPane.add(c5);
		
	 c2 = new JCheckBox("Internet Banking");
		c2.setFont(new Font("Tahoma", Font.BOLD, 14));
		c2.setBounds(345, 433, 151, 23);
		contentPane.add(c2);
		
		 c4 = new JCheckBox("EMAIL Alerts");
		c4.setFont(new Font("Tahoma", Font.BOLD, 14));
		c4.setBounds(345, 473, 138, 23);
		contentPane.add(c4);
		
		JButton b = new JButton("Submit");
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String fo=t1.getText();
				String a=null;
				if(r1.isSelected())
				{
					
					a="Saving Account";
					
				}
				else if(r2.isSelected())
				{
					a="Fixed Deposit Account";
				}
				else if(r3.isSelected())
				{
					a="Current Account";
				}
			
				
				Random ran=new Random();
				long first7=(ran.nextLong()%90000000L)+5040936000000000L;
				long first=Math.abs(first7);
				 String first8=String.valueOf(first);
				
				//long first3=(ran.nextLong()%9000L)+1000L;
				//long first4=Math.abs(first3);
				//int firsr3=(ran.nextInt(10000));
			//	int first3=first3*4;
				//int first4=Math.abs(first3);
				
				
				int first3=(ran.nextInt()%10000)+10000;
				
				String b="";
				if(c1.isSelected())
				{
					b=b+" ATM Card";
				}
				if(c2.isSelected())
				{
					b=b+" Internet Banking";
				}
				if(c3.isSelected())
				{
					b=b+" Mobile Banking";
				}
				if(c4.isSelected())
				{
					b=b+" Email Alerts";
				}
				if(c5.isSelected())
				{
					b=b+" Cheque Book";
				}
				
					String c=t1.getText();
					
					try {
						
						
						
						
						Connection con=Conn.getCon();
						Statement s=con.createStatement();
			          //  String q1="insert into signup3 values('"+c+"','"+a+"','"+first8+"','"+first3+"','"+b+"')";
			            //String q2="insert into login values('"+first8+"','"+first3+"')";
			            //s.executeUpdate(q1);
			            //s.executeUpdate(q2);
			            
						
			            
			            
			            
			            
			        	PreparedStatement pst=con.prepareStatement("insert into signup3 values(?,?,?,?,?)");
						pst.setString(1,c);
						pst.setString(2,a);
						pst.setString(3,first8);
						pst.setInt(4,first3);
						pst.setString(5,b);
						
						pst.executeUpdate();
			            
			            
			            
						PreparedStatement pst1=con.prepareStatement("insert into login values(?,?)");
						pst1.setString(1,first8);
						pst1.setInt(2,first3);
			            
			            
			            
						pst1.executeUpdate();
			            
						
						String q="select email from signup where formno ='"+c+"'";
						ResultSet rs=s.executeQuery(q);
						
						String tomail="";
						
						while(rs.next())
						{
							tomail=rs.getString("email");
						}
			            
						Email email=new Email("chandigarhmohali38","***************");
						email.setFrom("chandigarhmohali38@","Welcome to our Bank");
						email.setSubject("Thanks for Registering with us.");
						email.setContent("<h1>Your Card No:</h1>"+first8+"<br><h1>Your Pin:</h1>"+first3+"","text/html");
						email.addRecipient(tomail);
						email.send();

					//	JOptionPane.showMessageDialog(null,"Card Number:"+first8+"\n Pin:"+first3);
						JOptionPane.showMessageDialog(null,"Registration Successful."
								+ "Your Card Number and Pin are sent to your mail id.");
						
						new Deposit().setVisible(true);
						setVisible(false);
						
						
						
					} catch (Exception e2) {
						System.out.println("Exception:"+e2);
					}
				

					
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			}
		});
		b.setFont(new Font("Tahoma", Font.BOLD, 14));
		b.setBounds(291, 606, 89, 23);
		contentPane.add(b);
		
		 c7 = new JCheckBox("I hereby declares that the above entered details are correct to the best of my knowledge.\r\n");
		c7.setBounds(122, 556, 519, 23);
		contentPane.add(c7);
		
		t1 = new JTextField();
		t1.setBounds(623, 20, 61, 20);
		contentPane.add(t1);
		t1.setColumns(10);
	}
}
