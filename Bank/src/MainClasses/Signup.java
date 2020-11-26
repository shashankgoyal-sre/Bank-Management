package MainClasses;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DbConnection.Conn;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.time.Month;
import java.util.Random;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Signup extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;
	private JTextField t5;
	private JTextField t6;
	private JTextField t7;
	JRadioButton r1,r2,r3,r4;
	JComboBox c1,c2,c3,c4;

	
	
	
	Random ran=new Random();
	long f=(ran.nextLong() % 9000L)+100L;
	long f1=Math.abs(f);
	private JTextField t8;
	
	
	
	
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signup frame = new Signup();
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
	public Signup() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 670);
		setResizable(false);
		contentPane = new JPanel();
		setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel l1 = new JLabel("APPLICATION FORM NO."+f1);
		l1.setFont(new Font("Tahoma", Font.BOLD, 18));
		l1.setBounds(240, 11, 285, 14);
		contentPane.add(l1);
		
		JLabel l2 = new JLabel("Page 1:Personal Details");
		l2.setFont(new Font("Tahoma", Font.BOLD, 14));
		l2.setBounds(268, 36, 172, 26);
		contentPane.add(l2);
		
		JLabel l3 = new JLabel("Name");
		l3.setFont(new Font("Tahoma", Font.BOLD, 14));
		l3.setBounds(128, 76, 48, 14);
		contentPane.add(l3);
		
		JLabel l4 = new JLabel("Father's Name");
		l4.setFont(new Font("Tahoma", Font.BOLD, 14));
		l4.setBounds(128, 116, 109, 14);
		contentPane.add(l4);
		
		JLabel l5 = new JLabel("D.O.B.");
		l5.setFont(new Font("Tahoma", Font.BOLD, 14));
		l5.setBounds(128, 155, 48, 14);
		contentPane.add(l5);
		
		JLabel l6 = new JLabel("Gender");
		l6.setFont(new Font("Tahoma", Font.BOLD, 14));
		l6.setBounds(128, 202, 71, 14);
		contentPane.add(l6);
		
		JLabel l7 = new JLabel("Email");
		l7.setFont(new Font("Tahoma", Font.BOLD, 14));
		l7.setBounds(128, 244, 48, 14);
		contentPane.add(l7);
		
		JLabel l8 = new JLabel("Marital Status");
		l8.setFont(new Font("Tahoma", Font.BOLD, 14));
		l8.setBounds(128, 288, 109, 14);
		contentPane.add(l8);
		
		JLabel l9 = new JLabel("Address");
		l9.setFont(new Font("Tahoma", Font.BOLD, 14));
		l9.setBounds(128, 330, 89, 14);
		contentPane.add(l9);
		
		JLabel l10 = new JLabel("City");
		l10.setFont(new Font("Tahoma", Font.BOLD, 14));
		l10.setBounds(128, 379, 48, 14);
		contentPane.add(l10);
		
		JLabel l11 = new JLabel("Pin Code");
		l11.setFont(new Font("Tahoma", Font.BOLD, 14));
		l11.setBounds(128, 433, 71, 14);
		contentPane.add(l11);
		
		JLabel l12 = new JLabel("State");
		l12.setFont(new Font("Tahoma", Font.BOLD, 14));
		l12.setBounds(128, 488, 48, 14);
		contentPane.add(l12);
		
		t1 = new JTextField();
		t1.setFont(new Font("Tahoma", Font.BOLD, 14));
		t1.setBounds(268, 73, 202, 20);
		contentPane.add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setFont(new Font("Tahoma", Font.BOLD, 14));
		t2.setBounds(268, 113, 202, 20);
		contentPane.add(t2);
		t2.setColumns(10);
		
		 r1 = new JRadioButton("Male");
		r1.setFont(new Font("Tahoma", Font.BOLD, 14));
		r1.setBounds(255, 198, 109, 23);
		contentPane.add(r1);
		
		r2 = new JRadioButton("Female");
		r2.setFont(new Font("Tahoma", Font.BOLD, 14));
		r2.setBounds(437, 198, 109, 23);
		contentPane.add(r2);
		
		t3 = new JTextField();
		t3.setFont(new Font("Tahoma", Font.BOLD, 14));
		t3.setBounds(268, 241, 202, 20);
		contentPane.add(t3);
		t3.setColumns(10);
		
		 r3 = new JRadioButton("Married");
		r3.setFont(new Font("Tahoma", Font.BOLD, 14));
		r3.setBounds(255, 284, 109, 23);
		contentPane.add(r3);
		
		 r4 = new JRadioButton("Unmarried");
		r4.setFont(new Font("Tahoma", Font.BOLD, 14));
		r4.setBounds(437, 284, 109, 23);
		contentPane.add(r4);
		
		t4 = new JTextField();
		t4.setFont(new Font("Tahoma", Font.BOLD, 14));
		t4.setBounds(268, 327, 208, 20);
		contentPane.add(t4);
		t4.setColumns(10);
		
		t5 = new JTextField();
		t5.setFont(new Font("Tahoma", Font.BOLD, 14));
		t5.setBounds(268, 376, 208, 20);
		contentPane.add(t5);
		t5.setColumns(10);
		
		t6 = new JTextField();
		t6.setFont(new Font("Tahoma", Font.BOLD, 14));
		t6.setBounds(268, 430, 208, 20);
		contentPane.add(t6);
		t6.setColumns(10);
		
		t7 = new JTextField();
		t7.setFont(new Font("Tahoma", Font.BOLD, 14));
		t7.setBounds(268, 485, 208, 20);
		contentPane.add(t7);
		t7.setColumns(10);
		
		
		JButton b = new JButton("Next");
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String form=Long.toString(f1);
				
				String a=t1.getText();
				String b=t2.getText();
				
				String ac=(String)c1.getSelectedItem();
				String bc=(String)c2.getSelectedItem();
				String cc=(String)c3.getSelectedItem();
				
				String d=null;
				if(r1.isSelected())
				{
					d="Male";
				}
				else if(r2.isSelected())
				{
					d="Female";
				}
				
				String e1=t3.getText();
				String f=null;
				if(r3.isSelected())
				{
					f="Married";
				}
				else if(r4.isSelected())
				{
					f="Unmarried";
				}
				
				String g=t4.getText();
				String h=t5.getText();
				String i=t6.getText();
				String j=t7.getText();
			    String k=t8.getText();
				
				
				try {
					
					Connection con=Conn.getCon();
					Statement s=con.createStatement();
		            String q="insert into signup values('"+form+"','"+a+"','"+b+"','"+ac+"','"+bc+"','"+cc+"','"+d+"','"+e1+"','"+f+"','"+g+"','"+h+"','"+i+"','"+j+"','"+k+"')";
		            s.executeUpdate(q);
		            
		            new Signup2().setVisible(true);
		            setVisible(false);
		            
					
					
					
					
				} catch (Exception e2) {
					System.out.println("Exception:"+e2);
				}
				
				
				
				
				
				
				
				
				
				
				
				
				
			}
		});
		b.setFont(new Font("Tahoma", Font.BOLD, 14));
		b.setBounds(436, 587, 89, 23);
		contentPane.add(b);
		
		 c1 = new JComboBox();
		c1.setFont(new Font("Tahoma", Font.BOLD, 14));
		c1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "21", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		c1.setBounds(278, 151, 48, 22);
		contentPane.add(c1);
		
		 c2 = new JComboBox();
		c2.setFont(new Font("Tahoma", Font.BOLD, 14));
		c2.setModel(new DefaultComboBoxModel(new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		c2.setBounds(336, 151, 104, 22);
		contentPane.add(c2);
		
		 c3 = new JComboBox();
		c3.setModel(new DefaultComboBoxModel(new String[] {"1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005"}));
		c3.setFont(new Font("Tahoma", Font.BOLD, 14));
		c3.setBounds(454, 151, 71, 22);
		contentPane.add(c3);
		
		JLabel l13 = new JLabel("Mobile Number");
		l13.setFont(new Font("Tahoma", Font.BOLD, 14));
		l13.setBounds(128, 535, 109, 14);
		contentPane.add(l13);
		
		t8 = new JTextField();
		t8.setBounds(268, 534, 208, 20);
		contentPane.add(t8);
		t8.setColumns(10);
	}
}
