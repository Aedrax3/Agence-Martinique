package projetag;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;
public class modifbienimmo extends JFrame implements ActionListener {
	private JButton btafficher;
	private JButton btafficher3,btafficher4;
	JTextField tf1,tf2,tf4,tf22,tf33,tf44,tf55;
	JLabel label;
	JLabel label1;
	JLabel label2;
	JLabel label8;
	JLabel label3;
	JLabel label9;
	JLabel label4;
	JLabel label5;
	JLabel label6;
	JLabel label7;
	JLabel label10;
	JComboBox liste1 ;
	JComboBox liste2;
	JComboBox liste3;
	JComboBox liste4;
	JComboBox liste5;
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	int id;
	String sup;
	String rue;
	String ville;
	String cap;
	String dv;
	String pv;
	Object[]elements3;
	
	// formulaire avec liste déroulante , bouton ...
	public modifbienimmo() {
		this.setTitle("Modification Vente");
		this.setSize(1920,1080);
		this.setLocationRelativeTo(null);
		BackGround pn=new BackGround("img/fond2.jpg");
		add(pn);
		pn.setLayout(null);
		// liste déroulante de tous les id qu'on a récupérer
		Object[]elements=getid();
		liste3 = new JComboBox(elements);
		liste3.setBounds(1000,60,150,30);
		btafficher4=new JButton("Rechercher");
		btafficher4.addActionListener(this);
		btafficher4.setBounds(1400,60,140,30);
		pn.add(btafficher4);
		pn.add(liste3);
	
		  label2 = new JLabel("Rue  : ", JLabel.CENTER);
			label2.setBounds(100,60,190,30);
		    pn.add(label2);
		    
		     label8 = new JLabel("Type : ", JLabel.CENTER);
			label8.setBounds(100,160,190,30);
		    pn.add(label8);
		    
		    label3 = new JLabel("Superficie : ", JLabel.CENTER);
			label3.setBounds(100,260,190,30);
		    pn.add(label3);
		    
		    label10 = new JLabel("Vendeur : ", JLabel.CENTER);
		   	label10.setBounds(100,360,190,30);
		       pn.add(label10);
		       
		       label9 = new JLabel("Est-il vendu ? : ", JLabel.CENTER);
		   	label9.setBounds(800,60,190,30);
		       pn.add(label9);
		       
		        label4 = new JLabel("Date mise en Vente : ", JLabel.CENTER);
		   	label4.setBounds(800,140,190,30);
		       pn.add(label4);
		       
		       label5 = new JLabel("Ville : ", JLabel.CENTER);
		   	label5.setBounds(800,240,190,30);
		   	pn.add(label5);    
		       
		        label6 = new JLabel("Capacité (Nb de Pers) : ", JLabel.CENTER);
		   	label6.setBounds(800,340,190,30);
		       pn.add(label6);
		       
		        label7 = new JLabel("Prix  : ", JLabel.CENTER);
		   	label7.setBounds(800,440,190,30);
		       pn.add(label7);
		       
		       tf1=new JTextField(rue);
		   	tf1.setBounds(300,60,150,30);
		   	pn.add(tf1);
		   	
		   	tf2 = new JTextField(sup);
		   	tf2.setBounds(300,260,150,30);
		   	pn.add(tf2);
		   	
		   	
		   	Object[] elements1 = new Object[] {"Fête", "Séminaire"};
			liste2 = new JComboBox(elements1);
			liste2.setBounds(300,160,150,30);
			pn.add(liste2);
			
			elements3=getvendeur();
			liste4 = new JComboBox(elements3);
			liste4.setBounds(300,360,150,30);
			pn.add(liste4);
			
			Object[] elements2 = new Object[] {"oui", "non"};
			liste5 = new JComboBox(elements2);
			liste5.setBounds(1000,60,150,30);
			pn.add(liste5);
			
			 tf22 = new JTextField(dv);
				tf22.setBounds(1000,140,150,30);
				pn.add(tf22);

				tf33 = new JTextField(ville);
				tf33.setBounds(1000,240,150,30);
				pn.add(tf33);
				
				 tf44 = new JTextField(cap);
				tf44.setBounds(1000,340,150,30);
				pn.add(tf44);
				
				tf55 = new JTextField(pv);
				tf55.setBounds(1000,440,150,30);
				pn.add(tf55);
	  
	
			
				
		
				
				btafficher=new JButton("Annuler");
				btafficher.addActionListener(this);
				btafficher.setBounds(50,600,200,30);
				
				
				
				
				
				btafficher3=new JButton("Valider");
				btafficher3.addActionListener(this);
				btafficher3.setBounds(1000,600,200,30);
				
				pn.add(btafficher);
				
				pn.add(btafficher3);
	   
		
	}
	// connexion à la base de donnée
	public void Connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/agmartinique","root","");
			//JOptionPane.showMessageDialog(null, "Connection reussie");
		}catch(Exception e1) {
			e1.printStackTrace();
		}
		
}
	public JComboBox getListe() {
		return liste1;	
		}
		public JComboBox getListe2() {
			return liste2;
		}
		public JComboBox getListe3() {
			return liste3;
		}
		public JComboBox getListe4() {
			return liste3;
		}
		public JComboBox getListe5() {
			return liste3;
		}
	//action pour les boutons
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source= e.getSource();
		if(source == btafficher) {
			 tf1.setText(null);
	         tf2.setText(null);
	         tf4.setText(null);
	         tf22.setText(null);
	         tf33.setText(null);
	         tf44.setText(null);
	         tf55.setText(null);
	         }else if(source==btafficher4) {
	        		//récupère toute les donnée selon l'id que l'utilisateur a sélectionné pour les mettre dans la barre de texte
	     		try {
	     			Connect();
	     			id= (int) getListe3().getSelectedItem();
	     			pst=con.prepareStatement("Select superficie,rue,ville,capacite,Datevente,prixVente from bienimmo b Join vente v ON v.N°bien=b.N°bien WHERE v.N°bien=?");
	     			pst.setInt(1, id);
	     			rs=pst.executeQuery();
	     			if(rs.next()) {
	     			sup= rs.getString("surperficie");
	     			 rue=rs.getString("rue");
	     			 ville=rs.getString("villle");
	     			cap=rs.getString("capacite");
	     			dv=rs.getString("DateVente");
	     			pv=rs.getString("prixVente");
	     			}
	     		}catch(Exception e1) {
	     			e1.printStackTrace();
	     		}
	        	 tf1.setText(rue);
		         tf2.setText(sup);
		         tf22.setText(dv);
		         tf33.setText(ville);
		         tf44.setText(cap);
		         tf55.setText(pv);
		         
	         }
		
		else if(source==btafficher3) {
			try {
				Connect();
				 
				String v1= tf1.getText();
				String v2=tf2.getText();
				String v3 =tf33.getText();
				String v4=(String) getListe2().getSelectedItem();
				String v5=tf44.getText();
				String v6=(String) getListe5().getSelectedItem();
				int v7=(int) getListe3().getSelectedItem();
				String v8=tf22.getText();
				String v9=tf22.getText();
				String v10=(String) getListe4().getSelectedItem();
				//requête pour mettre a jour les donnée 
				pst=con.prepareStatement("UPDATE bienimmo SET superficie = ?, rue = ? ,villle=? ,capacite=?,Acheté=? WHERE N°bien = ?");
				pst.setString(1, v2);
				pst.setString(2, v1);
				pst.setString(3, v3);
				pst.setString(4, v5);
				pst.setString(5, v6);
				pst.setInt(6, v7);
				pst.executeUpdate();
				JOptionPane.showMessageDialog(null, "donné enregistrée");
				pst=con.prepareStatement("UPDATE vente SET DateVente = ?, prixVente= ? ,Type=?,vendeur=? WHERE N°bien = ?");
				pst.setString(1, v8);
				pst.setString(2, v9);
				pst.setString(3, v4);
				pst.setString(4, v10);
				pst.setInt(5, v7);
				pst.executeUpdate();
				con.close();
		}catch(Exception e2) {
			e2.printStackTrace();
			}
			modifbienimmo.this.dispose();	
		}	
	}
	//récupère tout les id qui existe dans la table clients
	public Object[] getid() {
		int f = 0;
		 int f2=0;
		 int f3=0;
		 Object[] elements1=null;
		 try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost/agmartinique","root","");
				 pst=con.prepareStatement("Select b.N°bien from bienimmo b Join vente v ON v.N°bien=b.N°bien WHERE v.N°bien=b.N°bien ");
				 rs = pst.executeQuery();
					 if(rs.next()) {
					   f=rs.getInt("N°bien");}
					 if(rs.next()) {
						   f2=rs.getInt("N°bien");
						} 
					 if(rs.next()) {
						   f3=rs.getInt("N°bien");}
								elements1 = new Object[] {f,f2,f3};
				}catch(Exception e1) {
					e1.printStackTrace();
		}return elements1;}
	//récupération  de tout les vendeurs
	public Object[] getvendeur() {
		String f = null;
		 String f2=null;
		 Object[] elements1=null;
		 try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost/agmartinique","root","");
				 pst=con.prepareStatement("Select nom_client from client where profession='vendeur'");
				 rs = pst.executeQuery();
					 if(rs.next()) {
					   f=rs.getString("nom_client");}
					 if(rs.next()) {
						   f2=rs.getString("nom_client");
						} 
								elements1 = new Object[] {f,f2};
				}catch(Exception e1) {
					e1.printStackTrace();
		}return elements1;}
}
