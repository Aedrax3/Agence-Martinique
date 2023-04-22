package projetag;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class recherche2 extends JFrame {
	// définir différents éléments  de la fenetre 
			JLabel home;
		 JLabel Numerobien;
		    JLabel dateVente;
		    JLabel PrixVente;
		    JLabel Type;
		    JLabel vendeur;
		    JLabel alert;
		    JTextField trecherche;
		    JButton recherche;
		    PreparedStatement pst ;
		    ResultSet rs ;
		    Connection con ;
		    Font font = new Font(Font.SANS_SERIF, Font.BOLD, 14);
		    Font fb = new Font(Font.SANS_SERIF, Font.BOLD, 12);
		    Font fhome = new Font(Font.SANS_SERIF, Font.BOLD, 28);
		 public recherche2() {
			 trecherche = new JTextField();
		        recherche = new JButton("Rechercher");
		 
		        alert = new JLabel("");
		        home = new JLabel("Système de Recherche");
		        Numerobien = new JLabel("");
		        dateVente = new JLabel("");
		        PrixVente= new JLabel("");
		        Type= new JLabel("");
		        vendeur = new JLabel("");
		        Numerobien.setBounds(300, 120, 200, 30);
		        dateVente.setBounds(300, 150, 200, 30);
		        PrixVente.setBounds(300, 180, 200, 30);
		        Type.setBounds(300, 210, 200, 30);
		        vendeur.setBounds(300, 240, 220, 30);
		        home.setBounds(50, 10, 400, 60);
		        trecherche.setBounds(50, 70, 130, 30);
		        recherche.setBounds(185, 70, 102, 30);
		        alert.setBounds(350, 90, 200, 30);
		        alert.setForeground(Color.blue);
		        home.setFont(fhome);
		        Numerobien.setFont(font);
		        dateVente.setFont(font);
		        PrixVente.setFont(font);
		        Type.setFont(font);
		        vendeur.setFont(font);
		        recherche.setFont(fb);
		        JPanel panel = new JPanel(null);
		        panel.add(home);
		 
		        panel.add(home);
		        panel.add(alert);
		        panel.add(trecherche);
		        panel.add(recherche);
		        panel.add(Numerobien);
		        panel.add(dateVente);
		        panel.add(PrixVente);
		        panel.add(Type);
		        panel.add(vendeur);
		        
		       
		// Action pour rechercher un élément dans la table bien immobilier grâce a son id
		        recherche.addActionListener(new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent actionEvent) {
		                if (!trecherche.getText().isEmpty()) {
		                    try {
		                    	Connect();
		                        pst = con.prepareStatement("SELECT * FROM vente WHERE N°bien= ?");
		                        pst.setString(1, trecherche.getText());
		                        rs = pst.executeQuery();
		                        if (rs.next()) {
		                        	// si cela a été trouver il l'affiche dans la fenetre tout les détail du bien immobilier
		                            alert.setText("Recherche effectuée avev succes!");
		                            Numerobien.setText("numéro du bien: " + rs.getString("N°bien"));
		                            dateVente.setText("datevente: " + rs.getString("dateVente"));
		                            PrixVente.setText("prix vent: " + rs.getString("prixVente"));
		                            vendeur.setText("vendeur " + rs.getString("vendeur"));
		                            Type.setText("Type " + rs.getString("Type"));
		                        } else {
		                        	//sinon il le met null
		                            alert.setText("Aucun resultat!");
		                            Numerobien.setText(null);
		                            dateVente.setText(null);
		                            PrixVente.setText(null);
		                            vendeur.setText(null);
		                            Type.setText(null);
		                           
		                        }
		 
		                    } catch (SQLException e) {
		                        e.printStackTrace();
		                    }
		                } else {
		                    JOptionPane.showMessageDialog(null, "Erreur de saisir!");
		                }
		            }
		        });
		 
		        this.setVisible(true);
		        this.setLocationRelativeTo(null);
		        this.setSize(600, 400);
		        this.setContentPane(panel);
		    }
		 
		   
		 
		// Connexion à la base de donnée
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
