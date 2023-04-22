package projetag;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;
public class ajouterclt extends JFrame implements ActionListener{
	private JButton btafficher;
	private JButton btafficher2;
	private JButton btafficher3;
	JTextField tf1,tf2,tf3,tf4,tf5;
	JLabel label;
	JLabel label2;
	JLabel label3;
	JLabel label4;
	JLabel label5, label6 ,label7;
	JComboBox liste1 ;
	JComboBox liste2;
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	
	// formulaire avec liste déroulante , bouton ...
	public ajouterclt() {
		this.setTitle("Ajouter un client");
		this.setSize(1920,1080);
		this.setLocationRelativeTo(null);
		BackGround pn=new BackGround("img/fond2.jpg");
		add(pn);
		pn.setLayout(null);
		label = new JLabel("Nom : ", JLabel.CENTER);
		label.setBounds(100,60,190,25);
	    pn.add(label);
	    
	     label2 = new JLabel("Prénom: ", JLabel.CENTER);
		label2.setBounds(100,200,190,25);
	    pn.add(label2);
	    
	    Object[] elements1 = new Object[] {"Carte", "Espece","Cheque"};
		liste1 = new JComboBox(elements1);
		liste1.setBounds(300,340,150,30);
		pn.add(liste1);
	    
	     label3 = new JLabel("Mode de paiement : ", JLabel.CENTER);
		label3.setBounds(100,340,190,25);
	    pn.add(label3);
	    
	    label4 = new JLabel("Adresse : ", JLabel.CENTER);
		label4.setBounds(100,480,190,25);
	    pn.add(label4);
	    
	    
	    
	    
	     label5 = new JLabel("Profession : ", JLabel.CENTER);
		label5.setBounds(800,60,190,25);
	    pn.add(label5);
	    
	    label6 = new JLabel("e-mail: ", JLabel.CENTER);
		label6.setBounds(800,100,190,25);
	    pn.add(label6);
	    
	    label7 = new JLabel("Telephone : ", JLabel.CENTER);
		label7.setBounds(800,200,190,25);
	    pn.add(label7);
	    
	    
	    Object[] elements2 = new Object[] {"Vendeur", "loueur"};
		liste2 = new JComboBox(elements2);
		liste2.setBounds(1000,60,150,30);
		pn.add(liste2);
	    
		 tf1=new JTextField("Teste 1");
			tf1.setBounds(300,60,150,25);
			pn.add(tf1);
			
			tf2 = new JTextField("Teste 2");
			tf2.setBounds(300,200,150,25);
			pn.add(tf2);
			
			 tf3 = new JTextField("Teste 3");
			tf3.setBounds(300,480,150,25);
			pn.add(tf3); 
			 tf4 = new JTextField("Teste 4");
				tf4.setBounds(1000,100,150,25);
				pn.add(tf4);

				tf5 = new JTextField("Texte 5");
				tf5.setBounds(1000,240,150,25);
				pn.add(tf5);
				
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
	//action pour les boutons
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source=e.getSource();
		if(source == btafficher) {
			 tf1.setText(null);
	         tf2.setText(null);
	         tf4.setText(null);
	         tf5.setText(null);
	         tf3.setText(null);
	         }
		else if(source==btafficher2) {
			try {
				Connect();
				String v1= tf1.getText();
				String v2=tf2.getText();
				String v3 =(String) getListe().getSelectedItem();
				String v4=tf3.getText();
				String v5=tf4.getText();
				String v6=tf5.getText();
				String v7=(String) getListe2().getSelectedItem();
				pst=con.prepareStatement("Insert into location(nom_client,prenom_client,modePaiement,adresse_client,mail_client,Telephone_client,profession)values(?,?,?,?,?,?,?)");
				pst.setString(1, v1);
				pst.setString(2, v2);
				pst.setString(3, v3);
				pst.setString(4, v4);
				pst.setString(5, v5);
				pst.setString(6, v6);
				pst.setString(7, v7);
				pst.executeUpdate();
				JOptionPane.showMessageDialog(null, "donné enregistrée");
				con.close();
			}catch(Exception e2) {
				e2.printStackTrace();
				} tf1.setText(null);
		         tf2.setText(null);
		         tf3.setText(null);
		         tf4.setText(null);
		         tf5.setText(null);
		}else if(source==btafficher3) {
			try {
				Connect();
				String v1= tf1.getText();
				String v2=tf2.getText();
				String v3 =(String) getListe().getSelectedItem();
				String v4=tf3.getText();
				String v5=tf4.getText();
				String v6=tf5.getText();
				String v7=(String) getListe2().getSelectedItem();
				pst=con.prepareStatement("Insert into location(nom_client,prenom_client,modePaiement,adresse_client,mail_client,Telephone_client,profession)values(?,?,?,?,?,?,?)");
				pst.setString(1, v1);
				pst.setString(2, v2);
				pst.setString(3, v3);
				pst.setString(4, v4);
				pst.setString(5, v5);
				pst.setString(6, v6);
				pst.setString(7, v7);
				pst.executeUpdate();
				JOptionPane.showMessageDialog(null, "donné enregistrée");
				con.close();
		}catch(Exception e2) {
			e2.printStackTrace();
			}
			ajouterclt.this.dispose();	
		}	
	}

}
