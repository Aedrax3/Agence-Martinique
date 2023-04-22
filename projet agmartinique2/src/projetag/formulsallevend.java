package projetag;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class formulsallevend extends JFrame implements ActionListener {
	JFrame frame;
	Object[] elements;
	JTextField tf1,tf2,tf4,tf22,tf33,tf44,tf55;
	private JButton btafficher;
	private JButton btafficher2;
	private JButton btafficher3;
	//mettre en format date 
	 SimpleDateFormat formatter =new SimpleDateFormat("dd-MM-yyyy");
	JComboBox combobox; 
	JLabel l1, l2;
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
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
	JComboBox <String> liste2;
	JComboBox <String> liste;
	JComboBox <String> liste3;
	//création du formulaire
public formulsallevend() {
	this.setTitle("SALLE A VENDRE");
	this.setSize(1920,1080);
	//  ........(Cotï¿½, en haut et en bas)
	this.setLocationRelativeTo(null);
	BackGround pn=new BackGround("img/fond2.jpg");
	add(pn);
	pn.setLayout(null);
	
	
//	tf1=new JTextField();
//	tf1.setBounds(50,60,150,25);
//	pn.add(tf1);
	
	
	
    
	  
		label = new JLabel("N°Salle : ", JLabel.CENTER);
		label.setBounds(100,60,190,30);
	    pn.add(label);
	    
	     label2 = new JLabel("Rue Salle : ", JLabel.CENTER);
	     label2.setBounds(100,160,190,30);
	    pn.add(label2);
	    
	     label8 = new JLabel("Type Salle : ", JLabel.CENTER);
	     label8.setBounds(100,260,190,30);
	    pn.add(label8);
	    
	    label3 = new JLabel("Superficie : ", JLabel.CENTER);
	    label3.setBounds(100,360,190,30);
	    pn.add(label3);
	    
	    label10 = new JLabel("Vendeur: ", JLabel.CENTER);
	   	label10.setBounds(100,460,190,30);
	       pn.add(label10);
	    
	    
	    
	    
	       label9 = new JLabel("Est-il vendu ? : ", JLabel.CENTER);
		   	label9.setBounds(800,60,190,30);
		       pn.add(label9);
	    
		       label4 = new JLabel("Date mise en Vente : ", JLabel.CENTER);
		      	label4.setBounds(800,140,190,30);
		          pn.add(label4);
		       
		          label5 = new JLabel("Ville Salle: ", JLabel.CENTER);
		      	label5.setBounds(800,240,190,30);
		      	pn.add(label5);    
		       
		       label6 = new JLabel("Capacité (Nb de Pers) : ", JLabel.CENTER);
		     	label6.setBounds(800,340,190,30);
		         pn.add(label6);
		       
		         label7 = new JLabel("Prix  : ", JLabel.CENTER);
		     	label7.setBounds(800,440,190,30);
		         pn.add(label7);
	    
	    
	    
	    
		         tf1=new JTextField("Teste 1");
			    	tf1.setBounds(300,60,150,30);
			    	pn.add(tf1);
			    	
			    	tf2 = new JTextField("Teste 2");
			    	tf2.setBounds(300,160,150,30);
			    	pn.add(tf2);
			    	
			    	 tf4 = new JTextField("Teste 4");
			    		tf4.setBounds(300,360,150,30);
			    	pn.add(tf4); 
		
		
		
		
			     	Object[] elements1 = new Object[] {"Fête", "Séminaire"};
			    	liste2 = new JComboBox(elements1);
			    	liste2.setBounds(300,260,150,30);
			    	pn.add(liste2);
			    	
			    	elements=getvendeur();
			    	liste = new JComboBox(elements);
			    	liste.setBounds(300,460,150,30);
			    	pn.add(liste);
			    	
			    	Object[] elements2 = new Object[] {"oui", "non"};
			    	liste3 = new JComboBox(elements2);
			    	liste3.setBounds(1000,60,150,30);
			    	pn.add(liste3);
			

		
		
		
		
		//JTextField tf11=new JTextField("Teste 5");
		//tf11.setBounds(400,60,150,25);
		//pn.add(tf11);
		

		
				   	 tf22 = new JTextField("jj-mm-aaaa");
					 tf22.setBounds(1000,140,150,30);
					pn.add(tf22);

					tf33 = new JTextField("Texte 7");
					tf33.setBounds(1000,240,150,30);
					pn.add(tf33);
					
					 tf44 = new JTextField("Teste 8");
					 tf44.setBounds(1000,340,150,30);
					pn.add(tf44);
					
					tf55 = new JTextField("Teste 9");
					tf55.setBounds(1000,440,150,30);
					pn.add(tf55);
	

	//(gauche droite, en haut en bas, ..., ...)
	
	
	
	
	//btafficher=new JButton("Annuler");
	//btafficher.setBounds(50,220,200,30);
	
	btafficher=new JButton("Annuler");
	btafficher.addActionListener(this);
	btafficher.setBounds(50,600,200,30);
	
	
	
	//btafficher2=new JButton("Autre Salle");
	//btafficher2.setBounds(400,220,200,30);
	
	btafficher2=new JButton("Autre Salle");
	btafficher2.addActionListener(this);
	btafficher2.setBounds(550,600,200,30);
	
	
	//btafficher3=new JButton("Valider");
	//btafficher3.setBounds(750,220,200,30);
	
	btafficher3=new JButton("Valider");
	btafficher3.addActionListener(this);
	btafficher3.setBounds(1000,600,200,30);
	
	
//	btafficher.addActionListener(new ActionListener(){

		
//public void actionPerformed(ActionEvent evt){
	/*on rï¿½cupere le texte dans le premier JTextField
	* et on l'affiche dans le second JTextField*/
//	tf2.setText(tf1.getText());
//	}

//	});
	
	
	
	pn.add(btafficher);
	pn.add(btafficher2);
	pn.add(btafficher3);
	
	//JTextField tf3=new JTextField("Texte 3");
	//tf3.setBounds(50,140,150,25);
	//pn.add(tf3);
	
	
	}


//connection à la base de donnée
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
return liste;	
}
public JComboBox getListe2() {
	return liste2;
}public JComboBox getListe3() {
	return liste3;
}
//création d'action pour les boutons
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	Object source=e.getSource();
	if(source == btafficher) {
		 tf1.setText(null);
         tf22.setText(null);
         tf55.setText(null);
         tf2.setText(null);
         tf33.setText(null);
         tf44.setText(null);}
	else if(source==btafficher2) {
		try {
			Connect();
			int v1= Integer.parseInt(tf1.getText());
			String v2=formatter.format(tf22.getText());
			int v3= Integer.parseInt(tf55.getText());
			String v4 =(String) getListe().getSelectedItem();
			String v5=(String) getListe2().getSelectedItem();
			int v6=Integer.parseInt(tf4.getText());
			String v7 =tf2.getText();
			String v8= tf33.getText();
			String v9="Salle ";
			int v10=Integer.parseInt(tf44.getText());
			String v11=(String) getListe3().getSelectedItem();
			pst=con.prepareStatement("Insert into vente(N°bien,datelocation,Prixlocation,loueur,Type)values(?,?,?,?,?)");
			pst.setInt(1, v1);
			pst.setString(2, v2);
			pst.setInt(3, v3);
			pst.setString(4, v4);
			pst.setString(5, v5);
			pst.executeUpdate();
			pst=con.prepareStatement("Insert into bien immo(N°bien,superficie,rue,villle,Type,capacite,Acheté)values(?,?,?,?,?,?,?) ");
			pst.setInt(1, v1);
			pst.setInt(2, v6);
			pst.setString(3, v7);
			pst.setString(4, v8);
			pst.setString(5, v9);
			pst.setInt(6, v10);
			pst.setString(7, v11);
			pst.executeUpdate();
			JOptionPane.showMessageDialog(null, "donné enregistrée");
			con.close();
		}catch(Exception e2) {
			e2.printStackTrace();
			} tf1.setText(null);
	         tf22.setText(null);
	         tf55.setText(null);
	         tf2.setText(null);
	         tf33.setText(null);
	         tf44.setText(null);
	}else if(source==btafficher3) {
		try {
			Connect();
			int v1= Integer.parseInt(tf1.getText());
			String v2=formatter.format(tf22.getText());
			int v3= Integer.parseInt(tf55.getText());
			String v4 =(String) getListe().getSelectedItem();
			String v5=(String) getListe2().getSelectedItem();
			int v6=Integer.parseInt(tf4.getText());
			String v7 =tf2.getText();
			String v8= tf33.getText();
			String v9="Salle ";
			int v10=Integer.parseInt(tf44.getText());
			String v11=(String) getListe3().getSelectedItem();
			pst=con.prepareStatement("Insert into vente(N°bien,datelocation,Prixlocation,loueur,Type)values(?,?,?,?,?)");
			pst.setInt(1, v1);
			pst.setString(2, v2);
			pst.setInt(3, v3);
			pst.setString(4, v4);
			pst.setString(5, v5);
			pst.executeUpdate();
			pst=con.prepareStatement("Insert into bien immo(N°bien,superficie,rue,villle,Type,capacite,Acheté)values(?,?,?,?,?,?,?) ");
			pst.setInt(1, v1);
			pst.setInt(2, v6);
			pst.setString(3, v7);
			pst.setString(4, v8);
			pst.setString(5, v9);
			pst.setInt(6, v10);
			pst.setString(7, v11);
			pst.executeUpdate();
			JOptionPane.showMessageDialog(null, "donné enregistrée");
			con.close();
		}catch(Exception e2) {
			e2.printStackTrace();
			}
		formulsallevend.this.dispose();	
	}
}
//récupérer la liste de tout les vendeurs
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
