package MainClasses;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.net.httpserver.Authenticator.Result;

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
import java.awt.event.ActionEvent;

public class Deposit extends JFrame {

	private JPanel contentPane;
	private JTextField t1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Deposit frame = new Deposit();
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
	public Deposit() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 600, 480);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel l1 = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
		l1.setFont(new Font("Tahoma", Font.BOLD, 18));
		l1.setBounds(98, 94, 458, 22);
		contentPane.add(l1);
		
		t1 = new JTextField();
		t1.setFont(new Font("Tahoma", Font.BOLD, 15));
		t1.setBounds(191, 151, 186, 31);
		contentPane.add(t1);
		t1.setColumns(10);
		
		JButton b1 = new JButton("DEPOSIT");
		b1.setFont(new Font("Tahoma", Font.BOLD, 14));
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					
					String a=t1.getText();
				//	String k=t2.getText();
					
			//	int b= Integer.parseInt(k);
					
					
					if(t1.getText().equals(""))
					{
						JOptionPane.showMessageDialog(null,"Please enter the amount you want to deposit");
					}
					else
					{
						                                  
						Connection c=Conn.getCon();
						Statement s=c.createStatement();
						
						
						String k=JOptionPane.showInputDialog("Enter Pin:");
						int b= Integer.parseInt(k);
double balance=0,d=0;
						
						String cardno="";

						String q="select * from banks where pin ='"+b+"'";
						//String query="select * from login where pin ='"+b+"'";
						ResultSet rs=s.executeQuery(q);
					//	ResultSet rs1=s.executeQuery(query);
						
						
						
						//String pin=null;
						//if(rs.next())
					if(rs.last())
						{
							// pin=rs.getString("pin");
							balance=rs.getDouble("balance");
							 d=Double.parseDouble(a);
							balance+=d;
							
							
						}
					rs.close();
					String query="select * from login where pin ='"+b+"'";
					ResultSet rs1=s.executeQuery(query);
					

			       if(rs1.next())
					{
						 cardno=rs1.getString("cardno");
					}

						rs1.close();
						
						
						DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
						Date dateobj = new Date();
					//	System.out.println(df.format(dateobj));
						
						PreparedStatement pst=c.prepareStatement("insert into banks values(?,?,?,?,?,?)");
						pst.setString(1,cardno);
						pst.setInt(2,b);
						pst.setDouble(3,d);
						pst.setDouble(4,0.0);
						pst.setDouble(5,balance);
						pst.setString(6,df.format(dateobj));

						
						
						pst.executeUpdate();
						
						
						//String q1="insert into banks values('"+b+"','"+d+"',0.0,'"+balance+"')";
						//s.executeUpdate(q1);
						
						JOptionPane.showMessageDialog(null,"Rs. '"+a+"' deposited succesfilly.");
						
						new Transactions().setVisible(true);
                         setVisible(false);
						
						
						
						
						
					}
					
					
				} catch (Exception e2) {
					System.out.println("Exception:"+e2);
				}
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			}
		});
		b1.setBounds(127, 227, 122, 23);
		contentPane.add(b1);
		
		JButton b2 = new JButton("BACK");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Transactions().setVisible(true);
				setVisible(false);
			}
		});
		b2.setFont(new Font("Tahoma", Font.BOLD, 14));
		b2.setBounds(353, 227, 115, 23);
		contentPane.add(b2);
		
		JButton b3 = new JButton("EXIT");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		b3.setFont(new Font("Tahoma", Font.BOLD, 14));
		b3.setBounds(253, 321, 89, 31);
		contentPane.add(b3);
	}
}
