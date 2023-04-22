package projet01;
import java.awt.Color;
import java.text.DateFormat;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class formulSalleloue extends JFrame implements ActionListener{
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
	JComboBox <String> liste2;
	JComboBox <String> liste;

	//création du formulaire
public formulSalleloue() {
	this.setTitle("SALLE A LOUER");
	this.setSize(1920,1080);
	//  ........(Cotï¿½, en haut et en bas)
	this.setLocationRelativeTo(null);
	JPanel pn=new JPanel();
	add(pn);
	pn.setBackground(Color.green);
	pn.setLayout(null);
	
	
//	tf1=new JTextField();
//	tf1.setBounds(50,60,150,25);
//	pn.add(tf1);
	
	
	
    
    label = new JLabel("N°Salle : ", JLabel.CENTER);
	label.setBounds(100,60,190,25);
    pn.add(label);
    
     label2 = new JLabel("Rue salle : ", JLabel.CENTER);
	label2.setBounds(100,200,190,25);
    pn.add(label2);
    
     label8 = new JLabel("Type salle : ", JLabel.CENTER);
	label8.setBounds(100,340,190,25);
    pn.add(label8);
    
    label3 = new JLabel("Superficie : ", JLabel.CENTER);
	label3.setBounds(100,480,190,25);
    pn.add(label3);
    
    
    
    
     label9 = new JLabel("Loueur : ", JLabel.CENTER);
	label9.setBounds(800,60,190,25);
    pn.add(label9);
    
     label4 = new JLabel("Date mise en location : ", JLabel.CENTER);
	label4.setBounds(800,100,190,25);
    pn.add(label4);
    
    label5 = new JLabel("Ville salle : ", JLabel.CENTER);
	label5.setBounds(800,200,190,25);
	pn.add(label5);    
    
     label6 = new JLabel("Capacité (Nb de Pers) : ", JLabel.CENTER);
	label6.setBounds(800,340,190,25);
    pn.add(label6);
    
     label7 = new JLabel("Prix location : ", JLabel.CENTER);
	label7.setBounds(800,480,190,25);
    pn.add(label7);
	
    
    
    
    
     tf1=new JTextField("Teste 1");
	tf1.setBounds(300,60,150,25);
	pn.add(tf1);
	
	tf2 = new JTextField("Teste 2");
	tf2.setBounds(300,200,150,25);
	pn.add(tf2);
	
	 tf4 = new JTextField("Teste 4");
	tf4.setBounds(300,480,150,25);
	pn.add(tf4); 
	
	
	
	
	Object[] elements1 = new Object[] {"FÃªte", "SÃ©minaire"};
	liste2 = new JComboBox(elements1);
	liste2.setBounds(300,340,150,30);
	pn.add(liste2);
	
	elements=getloueur();
	liste = new JComboBox(elements);
	liste.setBounds(1000,60,150,30);
	pn.add(liste);
	

	
	
	
	
	//JTextField tf11=new JTextField("Teste 5");
	//tf11.setBounds(400,60,150,25);
	//pn.add(tf11);
	

	
	 tf22 = new JTextField("jj-mm-aaaa");
	tf22.setBounds(1000,100,150,25);
	pn.add(tf22);

	tf33 = new JTextField("Texte 7");
	tf33.setBounds(1000,240,150,25);
	pn.add(tf33);
	
	 tf44 = new JTextField("Teste 8");
	tf44.setBounds(1000,380,150,25);
	pn.add(tf44);
	
	tf55 = new JTextField("Teste 9");
	tf55.setBounds(1000,480,150,25);
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
			String v9="salle de location";
			int v10=Integer.parseInt(tf44.getText());
			pst=con.prepareStatement("Insert into location(NÂ°bien,datelocation,Prixlocation,loueur,Type)values(?,?,?,?,?)");
			pst.setInt(1, v1);
			pst.setString(2, v2);
			pst.setInt(3, v3);
			pst.setString(4, v4);
			pst.setString(5, v9);
			pst.executeUpdate();
			pst=con.prepareStatement("Insert into bien immo(NÂ°bien,superficie,rue,villle,Type,capacite)values(?,?,?,?,?,?) ");
			pst.setInt(1, v1);
			pst.setInt(2, v6);
			pst.setString(3, v7);
			pst.setString(4, v8);
			pst.setString(5, v5);
			pst.setInt(6, v10);
			JOptionPane.showMessageDialog(null, "donnÃ© enregistrÃ©");
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
		try{
			Connect();
		int v1= Integer.parseInt(tf1.getText());
		String v2=formatter.format(tf22.getText());
		int v3= Integer.parseInt(tf55.getText());
		String v4 =(String) getListe().getSelectedItem();
		String v5=(String) getListe2().getSelectedItem();
		int v6=Integer.parseInt(tf4.getText());
		String v7 =tf2.getText();
		String v8= tf33.getText();
		String v9="salle de location";
		int v10=Integer.parseInt(tf44.getText());
		pst=con.prepareStatement("Insert into location(NÂ°bien,datelocation,Prixlocation,loueur,Type)values(?,?,?,?,?)");
		pst.setInt(1, v1);
		pst.setString(2, v2);
		pst.setInt(3, v3);
		pst.setString(4, v4);
		pst.setString(5, v9);
		pst.executeUpdate();
		pst=con.prepareStatement("Insert into bien immo(NÂ°bien,superficie,rue,villle,Type,capacite)values(?,?,?,?,?,?) ");
		pst.setInt(1, v1);
		pst.setInt(2, v6);
		pst.setString(3, v7);
		pst.setString(4, v8);
		pst.setString(5, v5);
		pst.setInt(6, v10);
		JOptionPane.showMessageDialog(null, "donnÃ© enregistrÃ©");
		con.close();
	}catch(Exception e2) {
		e2.printStackTrace();
		}
		formulSalleloue.this.dispose();	
	}
}
//récupérer la liste de tout les loueur
public Object[] getloueur() {
	String f = null;
	 String f2=null;
	 Object[] elements1=null;
	 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/agmartinique","root","");
			 pst=con.prepareStatement("Select nom_client from client where profession='loueur'");
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



