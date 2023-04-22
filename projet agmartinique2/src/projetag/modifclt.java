package projetag;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;
public class modifclt extends JFrame implements ActionListener{
	private JButton btafficher;
	private JButton btafficher3,btafficher4;
	JTextField tf1,tf2,tf3,tf4,tf5;
	JLabel label;
	JLabel label2;
	JLabel label3;
	JLabel label4;
	JLabel label5 ,label6,label7;
	JComboBox liste1 ;
	JComboBox liste2;
	JComboBox liste3;
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	int id;
	String nom;
	String prenom;
	String mdp;
	String adresse;
	String mail;
	String tel;
	String prof;
	
	// formulaire avec liste déroulante , bouton ...
	public modifclt() {
		this.setTitle("Modification un client");
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
		btafficher4.setBounds(1020,60,140,30);
		pn.add(btafficher4);
		pn.add(liste3);
	
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
	    
		tf1 = new JTextField(nom);
			tf1.setBounds(300,60,150,25);
			pn.add(tf1);
			
			tf2 = new JTextField(prenom);
			tf2.setBounds(300,200,150,25);
			pn.add(tf2);
			
			 tf3 = new JTextField(adresse);
			tf3.setBounds(300,480,150,25);
			pn.add(tf3); 
			 tf4 = new JTextField(mail);
				tf4.setBounds(1000,100,150,25);
				pn.add(tf4);

				tf5 = new JTextField(tel);
				tf5.setBounds(1000,240,150,25);
				pn.add(tf5);
				
		
				
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
	         }else if(source==btafficher4) {
	        		//récupère toute les donnée selon l'id que l'utilisateur a sélectionné pour les mettre dans la barre de texte
	     		try {
	     			Connect();
	     			int id= (int) getListe3().getSelectedItem();
	     			pst=con.prepareStatement("SELECT * FROM client WHERE id_client=?");
	     			pst.setInt(1, id);
	     			rs=pst.executeQuery();
	     			if(rs.next()) {
	     			nom= rs.getString("nom_client");
	     			 prenom=rs.getString("prenom_client");
	     			 mdp=rs.getString("modePaiement");
	     			 adresse=rs.getString("adresse_client");
	     			mail =rs.getString("mail_client");
	     			tel=rs.getString("Telephone_client");
	     			 prof =rs.getString("profession");}
	     		}catch(Exception e1) {
	     			e1.printStackTrace();
	     		}
	        	 tf1.setText(nom);
		         tf2.setText(prenom);
		         tf4.setText(adresse);
		         tf5.setText(mail);
		         tf3.setText(tel); 
	         }
		
		else if(source==btafficher3) {
			try {
				Connect();
				 
				String v1= tf1.getText();
				String v2=tf2.getText();
				String v3 =(String) getListe().getSelectedItem();
				String v4=tf3.getText();
				String v5=tf4.getText();
				String v6=tf5.getText();
				String v7=(String) getListe2().getSelectedItem();
				int v8=(int) getListe3().getSelectedItem();
				//requête pour mettre a jour les donnée 
				pst=con.prepareStatement("UPDATE client SET nom_client = ?, prenom_client = ? ,modePaiement=?,adresse_client=? ,mail_client=?,Telephone_client=?,profession=? WHERE id_client = ?");
				pst.setString(1, v1);
				pst.setString(2, v2);
				pst.setString(3, v3);
				pst.setString(4, v4);
				pst.setString(5, v5);
				pst.setString(6, v6);
				pst.setString(7, v7);
				pst.setInt(8, v8);
				pst.executeUpdate();
				JOptionPane.showMessageDialog(null, "donné enregistrée");
				con.close();
		}catch(Exception e2) {
			e2.printStackTrace();
			}
			modifclt.this.dispose();	
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
				 pst=con.prepareStatement("Select id_client from client ");
				 rs = pst.executeQuery();
					 if(rs.next()) {
					   f=rs.getInt("id_client");}
					 if(rs.next()) {
						   f2=rs.getInt("id_client");
						} 
					 if(rs.next()) {
						   f3=rs.getInt("id_client");}
								elements1 = new Object[] {f,f2,f3};
				}catch(Exception e1) {
					e1.printStackTrace();
		}return elements1;}
	}


