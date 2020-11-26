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
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.awt.event.ActionEvent;

public class Withdrawl extends JFrame {

	private JPanel contentPane;
	private JTextField t1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Withdrawl frame = new Withdrawl();
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
	public Withdrawl() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 480);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel l1 = new JLabel("Please Enter Your Amount");
		l1.setFont(new Font("Tahoma", Font.BOLD, 18));
		l1.setBounds(175, 97, 254, 25);
		contentPane.add(l1);
		
		t1 = new JTextField();
		t1.setBounds(211, 142, 153, 20);
		contentPane.add(t1);
		t1.setColumns(10);
		
		
		
	int otp=(int)(Math.random()*1000000);
		String otp1=Integer.toString(otp);
		
		
		
		JButton b1 = new JButton("WITHDRAWL");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
                 try {
					
					
					String a=t1.getText();
				//	String k=t2.getText();
					//int b=
							 // Integer.parseInt(k);
						
					
					if(t1.getText().equals(""))
					{
						JOptionPane.showMessageDialog(null,"Please enter the amount you want to withdraw");
					}
					else
					{
						
						Connection c=Conn.getCon();
						Statement s=c.createStatement();
						
						String k=JOptionPane.showInputDialog("Enter Pin:");
						int b= Integer.parseInt(k);
				

						String queryn="select * from signup where formno=(select formno from signup3 where pin='"+b+"')";
						
						ResultSet t=s.executeQuery(queryn);
						String number="";
						if(t.next())
						{
							number=t.getString("number");
						}
						
						System.out.println(number);
						t.close();
						
						double balance=0,d=0;
						//System.out.println(otp1);
					//	System.out.println(otp1);
						SMS se=new SMS();
				              se.send("This is your OTP:"+otp1, number);
						String m=JOptionPane.showInputDialog("Enter otp:");
					
					
					//	     SMS se=new SMS();
			          //      se.send("This is your OTP:"+otp, number);
						
				if(m.equals(otp1))
				{
					

					String q="select * from banks where pin ="+b;
					ResultSet rs=s.executeQuery(q);
						
				
					
					
					if(rs.last())
						
					{
						//String pin=rs.getString("pin");
						balance=rs.getDouble("balance");
						
						 d=Double.parseDouble(a);
						balance-=d;

					}
					rs.close();
				}
						
				else
				{
					System.exit(0);
				}
						
						String query="select * from login where pin ='"+b+"'";
						ResultSet rs1=s.executeQuery(query);
						
						String cardno="";
						if(rs1.next())
						{
							 cardno=rs1.getString("cardno");
						}
						
						
						
						rs1.close();
						
						DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
						Date dateobj = new Date();

							PreparedStatement pst=c.prepareStatement("insert into banks values(?,?,?,?,?,?)");
							pst.setString(1,cardno);
							pst.setInt(2,b);
							pst.setDouble(3,0.0);
							pst.setDouble(4,d);
							pst.setDouble(5,balance);
							pst.setString(6,df.format(dateobj));
							pst.executeUpdate();
							
			
							
							
						
						
						
						JOptionPane.showMessageDialog(null,"Rs. '"+a+"' withdrawl succesfilly.");
						
						new Transactions().setVisible(true);
                         setVisible(false);
							
					}
					
					
				} catch (Exception e2) {
					System.out.println("Exception:"+e2);
		            setVisible(false);
				}
				
			}
		});
		b1.setFont(new Font("Tahoma", Font.BOLD, 15));
		b1.setBounds(145, 196, 137, 23);
		contentPane.add(b1);
		
		JButton b2 = new JButton("BACK");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Transactions().setVisible(true);
				setVisible(false);
			}
		});
		b2.setFont(new Font("Tahoma", Font.BOLD, 15));
		b2.setBounds(325, 196, 126, 23);
		contentPane.add(b2);
		
		JButton b3 = new JButton("EXIT");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		b3.setFont(new Font("Tahoma", Font.BOLD, 15));
		b3.setBounds(263, 266, 101, 23);
		contentPane.add(b3);
		
		
		
		
		
	}

}
