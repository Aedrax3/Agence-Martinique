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

public class formulappartloue extends JFrame implements ActionListener {
	JFrame frame;
	Object[] elements;
	JTextField tf1,tf2,tf4,tf22,tf33,tf44,tf55,tf66;
	private JButton btafficher;
	private JButton btafficher2;
	private JButton btafficher3;
	
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
	JLabel label11;
	JComboBox <String> liste2;
	JComboBox <String> liste;
	JComboBox <String> liste3;

public formulappartloue() {
	this.setTitle("Appartement A LOUER");
	this.setSize(1920,1080);
	this.setLocationRelativeTo(null);
	BackGround pn=new BackGround("img/fond2.jpg");
	add(pn);
	pn.setLayout(null);
	
	
//	tf1=new JTextField();
//	tf1.setBounds(50,60,150,25);
//	pn.add(tf1);
	
    label = new JLabel("N°appartement : ", JLabel.CENTER);
	label.setBounds(100,60,190,30);
    pn.add(label);
    
     label2 = new JLabel("Rue appartement : ", JLabel.CENTER);
     label2.setBounds(100,160,190,30);
    pn.add(label2);
    
     label8 = new JLabel("Type appartement : ", JLabel.CENTER);
     label8.setBounds(100,260,190,30);
    pn.add(label8);
    
    label3 = new JLabel("Superficie : ", JLabel.CENTER);
    label3.setBounds(100,360,190,30);
    pn.add(label3);
    
    label10 = new JLabel("Loueur: ", JLabel.CENTER);
   	label10.setBounds(100,460,190,30);
       pn.add(label10);
    
    
       label9 = new JLabel("Est-il loué ? : ", JLabel.CENTER);
   	label9.setBounds(800,60,190,30);
       pn.add(label9);
    
       label4 = new JLabel("Date mise en location : ", JLabel.CENTER);
   	label4.setBounds(800,140,190,30);
       pn.add(label4);
    
       label5 = new JLabel("Date fin location: ", JLabel.CENTER);
   	label5.setBounds(800,240,190,30);
   	pn.add(label5);    
    
    label6 = new JLabel("Ville appartement: ", JLabel.CENTER);
  	label6.setBounds(800,340,190,30);
      pn.add(label6);
    
      label7 = new JLabel("Capacité (Nb de Pers) : ", JLabel.CENTER);
  	label7.setBounds(800,440,190,30);
      pn.add(label7);
      label11 = new JLabel("Prix  : ", JLabel.CENTER);
    	label11.setBounds(100,540,190,30);
        pn.add(label11);
	
    
    
    
    
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
	
	elements=getloueur();
	liste = new JComboBox(elements);
	liste.setBounds(300,460,150,30);
	pn.add(liste);
	
	Object[] elements2 = new Object[] {"oui", "non"};
	liste3 = new JComboBox(elements2);
	liste3.setBounds(1000,60,150,30);
	pn.add(liste3);
	

	

	
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
	
	tf66 = new JTextField("Teste 10");
	tf66.setBounds(300,540,150,30);
	pn.add(tf66);
	


	btafficher=new JButton("Annuler");
	btafficher.addActionListener(this);
	btafficher.setBounds(50,600,200,30);
	
	
	
	
	
	btafficher2=new JButton("Autre Appartement");
	btafficher2.addActionListener(this);
	btafficher2.setBounds(550,600,200,30);
	
	
	
	
	btafficher3=new JButton("Valider");
	btafficher3.addActionListener(this);
	btafficher3.setBounds(1000,600,200,30);
	
	

	
	
	pn.add(btafficher);
	pn.add(btafficher2);
	pn.add(btafficher3);
	

	
	
	}


//paramètre de connexion
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
public JComboBox getListe3() {
	return liste3;
}
// Création des action des boutons
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
			String v3=formatter.format(tf33.getText());
			int v4= Integer.parseInt(tf66.getText());
			String v5 =(String) getListe().getSelectedItem();
			String v6=(String) getListe2().getSelectedItem();
			int v7=Integer.parseInt(tf4.getText());
			String v8 =tf2.getText();
			String v9= tf44.getText();
			String v10="Appartement ";
			int v11=Integer.parseInt(tf55.getText());
			String v12=(String) getListe3().getSelectedItem();
			pst=con.prepareStatement("Insert into location(N°bien,datedebutlocation,datefinlocation,Prixlocation,loueur,Type)values(?,?,?,?,?,?)");
			pst.setInt(1, v1);
			pst.setString(2, v2);
			pst.setString(3, v3);
			pst.setInt(4, v4);
			pst.setString(5, v5);
			pst.setString(5, v6);
			pst.executeUpdate();
			pst=con.prepareStatement("Insert into bien immo(N°bien,superficie,rue,villle,Type,capacite,Acheté)values(?,?,?,?,?,?,?) ");
			pst.setInt(1, v1);
			pst.setInt(2, v7);
			pst.setString(3, v8);
			pst.setString(4, v9);
			pst.setString(5, v10);
			pst.setInt(6, v11);
			pst.setString(7, v12);
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
		try{
			Connect();
			int v1= Integer.parseInt(tf1.getText());
			String v2=formatter.format(tf22.getText());
			String v3=formatter.format(tf33.getText());
			int v4= Integer.parseInt(tf66.getText());
			String v5 =(String) getListe().getSelectedItem();
			String v6=(String) getListe2().getSelectedItem();
			int v7=Integer.parseInt(tf4.getText());
			String v8 =tf2.getText();
			String v9= tf44.getText();
			String v10="Appartement ";
			int v11=Integer.parseInt(tf55.getText());
			String v12=(String) getListe3().getSelectedItem();
			pst=con.prepareStatement("Insert into location(N°bien,datedebutlocation,datefinlocation,Prixlocation,loueur,Type)values(?,?,?,?,?,?)");
			pst.setInt(1, v1);
			pst.setString(2, v2);
			pst.setString(3, v3);
			pst.setInt(4, v4);
			pst.setString(5, v5);
			pst.setString(5, v6);
			pst.executeUpdate();
			pst=con.prepareStatement("Insert into bien immo(N°bien,superficie,rue,villle,Type,capacite,Acheté)values(?,?,?,?,?,?,?) ");
			pst.setInt(1, v1);
			pst.setInt(2, v7);
			pst.setString(3, v8);
			pst.setString(4, v9);
			pst.setString(5, v10);
			pst.setInt(6, v11);
			pst.setString(7, v12);
			pst.executeUpdate();
			JOptionPane.showMessageDialog(null, "donné enregistrée");
			con.close();
	}catch(Exception e2) {
		e2.printStackTrace();
		}
		formulappartloue.this.dispose();	
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
