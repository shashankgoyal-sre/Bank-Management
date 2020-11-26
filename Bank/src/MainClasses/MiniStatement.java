package MainClasses;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import DbConnection.Conn;

import java.sql.*;

public class MiniStatement extends JFrame implements ActionListener{
 
    JTable t1;
    JButton b1;
    String x[] = {"Card","Deposit","Withdraw","Balance","Date"};
    String y[][] = new String[20][5];
    int i=0, j=0;
    
    MiniStatement(){
        super("Mini Statement");
        setSize(1200,450);
        setLocation(200,200);
        setResizable(false);
        setLocationRelativeTo(null);
        String pinn = JOptionPane.showInputDialog("Enter PIN");

        
        try{
        	Connection con=Conn.getCon();
        	Statement s=con.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM banks where pin = '" + pinn + "'");
         
          //  String s1 = "select * from bank";
          //  ResultSet rs  = c1.s.executeQuery(s1);
          
           
           
            while(rs.next()){
                y[i][j++]=rs.getString("cardno");
                y[i][j++]=rs.getString("deposit");
                y[i][j++]=rs.getString("withdraw");
                y[i][j++]=rs.getString("balance");
                y[i][j++]=rs.getString("transactiondate");
                i++;
                j=0;
            }
            t1 = new JTable(y,x);
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        b1 = new JButton("Print");
        add(b1,"South");
        JScrollPane sp = new JScrollPane(t1);
        add(sp);
        b1.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae){
        try{
            t1.print();
        }catch(Exception e){}
    }
    
    public static void main(String[] args){
        new MiniStatement().setVisible(true);
    }
    
}