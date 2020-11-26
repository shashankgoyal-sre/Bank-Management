package MainClasses;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DbConnection.Conn;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Signup2 extends JFrame {

	private JPanel contentPane;
	private JTextField t2;
	private JTextField t1;

	JComboBox c1,c2,c3,c4,c5;
	JRadioButton r1,r2,r3,r4;
	private JTextField t3;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signup2 frame = new Signup2();
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
	public Signup2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 625);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel l1 = new JLabel("Page 2:Additional Details");
		l1.setFont(new Font("Tahoma", Font.BOLD, 14));
		l1.setBounds(264, 11, 176, 23);
		contentPane.add(l1);
		
		JLabel l2 = new JLabel("Religion");
		l2.setFont(new Font("Tahoma", Font.BOLD, 14));
		l2.setBounds(151, 49, 89, 18);
		contentPane.add(l2);
		
		JLabel l3 = new JLabel("Category");
		l3.setFont(new Font("Tahoma", Font.BOLD, 14));
		l3.setBounds(151, 96, 69, 18);
		contentPane.add(l3);
		
		JLabel l4 = new JLabel("Income");
		l4.setFont(new Font("Tahoma", Font.BOLD, 14));
		l4.setBounds(151, 145, 89, 18);
		contentPane.add(l4);
		
		JLabel l5 = new JLabel("Educational");
		l5.setFont(new Font("Tahoma", Font.BOLD, 14));
		l5.setBounds(151, 198, 89, 14);
		contentPane.add(l5);
		
		JLabel l11 = new JLabel("Qualification");
		l11.setFont(new Font("Tahoma", Font.BOLD, 14));
		l11.setBounds(151, 213, 89, 14);
		contentPane.add(l11);
		
		JLabel l6 = new JLabel("Occupation");
		l6.setFont(new Font("Tahoma", Font.BOLD, 14));
		l6.setBounds(151, 257, 89, 14);
		contentPane.add(l6);
		
		JLabel l7 = new JLabel("PAN Number");
		l7.setFont(new Font("Tahoma", Font.BOLD, 14));
		l7.setBounds(151, 304, 109, 14);
		contentPane.add(l7);
		
		JLabel l8 = new JLabel("Aadhar Number\r\n");
		l8.setFont(new Font("Tahoma", Font.BOLD, 14));
		l8.setBounds(151, 354, 129, 14);
		contentPane.add(l8);
		
		JLabel l9 = new JLabel("Senior Citizen");
		l9.setFont(new Font("Tahoma", Font.BOLD, 14));
		l9.setBounds(151, 393, 109, 14);
		contentPane.add(l9);
		
		JLabel l10 = new JLabel("Existing Account");
		l10.setFont(new Font("Tahoma", Font.BOLD, 14));
		l10.setBounds(151, 437, 129, 19);
		contentPane.add(l10);
		
		JButton b = new JButton("Next");
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
								String a=(String)c1.getSelectedItem();
				String b=(String)c2.getSelectedItem();
				String c=(String)c3.getSelectedItem();
				String d=(String)c4.getSelectedItem();
				String e1=(String)c5.getSelectedItem();
				
				String f=t1.getText();
				String g=t2.getText();
				
				String h="";
				if(r1.isSelected())
				{
					h="Yes";
				}
				else if(r2.isSelected())
				{
					h="No";
				}
				
				String i="";
				if(r3.isSelected())
				{
					i="Yes";
				}
				else if(r4.isSelected())
				{
					i="No";
				}
				
				
				String j=t3.getText();
				
				
               try {
					
					Connection con=Conn.getCon();
					Statement s=con.createStatement();
		            String q="insert into signup2 values('"+j+"','"+a+"','"+b+"','"+c+"','"+d+"','"+e1+"','"+f+"','"+g+"','"+h+"','"+i+"')";
		            s.executeUpdate(q);
		            
		            new Signup3().setVisible(true);
		            setVisible(false);
		            
					
					
					
					
				} catch (Exception e2) {
					System.out.println("Exception:"+e2);
				}
				
				
			
				
			}
		});
		b.setFont(new Font("Tahoma", Font.BOLD, 14));
		b.setBounds(427, 498, 117, 23);
		contentPane.add(b);
		
		t2 = new JTextField();
		t2.setFont(new Font("Tahoma", Font.BOLD, 14));
		t2.setBounds(311, 351, 179, 20);
		contentPane.add(t2);
		t2.setColumns(10);
		
		t1 = new JTextField();
		t1.setFont(new Font("Tahoma", Font.BOLD, 14));
		t1.setBounds(311, 301, 179, 20);
		contentPane.add(t1);
		t1.setColumns(10);
		
	 c1 = new JComboBox();
		c1.setModel(new DefaultComboBoxModel(new String[] {"Hindu", "Muslim", "Christian", "Sikh", "OIther"}));
		c1.setFont(new Font("Tahoma", Font.BOLD, 14));
		c1.setBounds(311, 45, 129, 22);
		contentPane.add(c1);
		
		 c2 = new JComboBox();
		c2.setModel(new DefaultComboBoxModel(new String[] {"General", "OBC", "SC", "ST", "Other"}));
		c2.setFont(new Font("Tahoma", Font.BOLD, 14));
		c2.setBounds(311, 92, 129, 22);
		contentPane.add(c2);
		
	 c3 = new JComboBox();
		c3.setModel(new DefaultComboBoxModel(new String[] {"Null", "<1,00,000", "<1,50,000", "<2,50,000", "<3,00,000", ">3,00,000"}));
		c3.setFont(new Font("Tahoma", Font.BOLD, 14));
		c3.setBounds(311, 141, 129, 22);
		contentPane.add(c3);
		
		 c4 = new JComboBox();
		c4.setModel(new DefaultComboBoxModel(new String[] {"Non-Graduate", "Graduate", "Post-Graduate", "Others"}));
		c4.setFont(new Font("Tahoma", Font.BOLD, 14));
		c4.setBounds(311, 194, 129, 22);
		contentPane.add(c4);
		
	c5 = new JComboBox();
		c5.setModel(new DefaultComboBoxModel(new String[] {"Salaried", "Business", "Srudent", "Retired", "Others"}));
		c5.setFont(new Font("Tahoma", Font.BOLD, 14));
		c5.setBounds(311, 253, 129, 22);
		contentPane.add(c5);
		
		 r1 = new JRadioButton("YES\r\n");
		r1.setFont(new Font("Tahoma", Font.BOLD, 14));
		r1.setBounds(311, 389, 89, 23);
		contentPane.add(r1);
		
	 r2 = new JRadioButton("NO");
		r2.setFont(new Font("Tahoma", Font.BOLD, 14));
		r2.setBounds(412, 389, 109, 23);
		contentPane.add(r2);
		
	r4 = new JRadioButton("NO");
		r4.setFont(new Font("Tahoma", Font.BOLD, 14));
		r4.setBounds(412, 433, 109, 23);
		contentPane.add(r4);
		
	 r3 = new JRadioButton("YES");
		r3.setFont(new Font("Tahoma", Font.BOLD, 14));
		r3.setBounds(313, 433, 89, 23);
		contentPane.add(r3);
		
		JLabel l12 = new JLabel("Form");
		l12.setFont(new Font("Tahoma", Font.BOLD, 14));
		l12.setBounds(585, 11, 48, 23);
		contentPane.add(l12);
		
		t3 = new JTextField();
		t3.setBounds(634, 14, 40, 20);
		contentPane.add(t3);
		t3.setColumns(10);
	}

}
