package projetag;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class supclt extends JFrame  {
	 JTextField supid;
	 JButton supprimer;
	 Connection con;
		PreparedStatement pst;
		ResultSet rs;
		JLabel home;
	public supclt(){
	this.setTitle("Supprimer un client");
	this.setSize(1920,1080);
	this.setLocationRelativeTo(null);
	JPanel pn=new JPanel();
	add(pn);
	pn.setBackground(Color.green);
	pn.setLayout(null);
	 home = new JLabel("Système de Suppression");
	supid= new JTextField("");
	supprimer=new JButton("Supprimer");
	 supid.setBounds(50, 70, 130, 30);
     supprimer.setBounds(185, 70, 102, 30);
     home.setBounds(50, 10, 400, 60);
	pn.add(supid);
	pn.add(supprimer);
	pn.add(home);
	 supprimer.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent actionEvent) {
             if (!supid.getText().isEmpty()) {
                 try {
                 	Connect();
                 	pst=con.prepareStatement("DELETE FROM client WHERE id_client = ?");
                 	pst.setString(1, supid.getText());
                    rs = pst.executeQuery();
                 }catch (Exception e) {
                     e.printStackTrace();
                 }
	}
}
	 });
	}
	//connexion à la base 
	public void Connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/agmartinique","root","");
			//JOptionPane.showMessageDialog(null, "Connection reussie");
		}catch(Exception e1) {
			e1.printStackTrace();
		}
		
}
}
