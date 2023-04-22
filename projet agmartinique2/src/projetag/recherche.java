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

public class recherche extends JFrame {
	// définir différents éléments  de la fenetre 
		JLabel home;
	 JLabel Numerobien;
	    JLabel datedebutlocation;
	    JLabel datefinlocation;
	    JLabel Prixlocation;
	    JLabel Loueur;
	    JLabel Type;
	    JLabel alert;
	    JTextField trecherche;
	    JButton recherche;
	    PreparedStatement pst ;
	    ResultSet rs ;
	    Connection con ;
	    Font font = new Font(Font.SANS_SERIF, Font.BOLD, 14);
	    Font fb = new Font(Font.SANS_SERIF, Font.BOLD, 12);
	    Font fhome = new Font(Font.SANS_SERIF, Font.BOLD, 28);
	 public recherche() {
		 trecherche = new JTextField();
	        recherche = new JButton("Rechercher");
	 
	        alert = new JLabel("");
	        home = new JLabel("Système de Recherche");
	        Numerobien = new JLabel("");
	        datedebutlocation = new JLabel("");
	        datefinlocation = new JLabel("");
	        Prixlocation= new JLabel("");
	        Loueur= new JLabel("");
	        Type = new JLabel("");
	        Numerobien.setBounds(300, 120, 200, 30);
	        datedebutlocation.setBounds(300, 150, 200, 30);
	        datefinlocation.setBounds(300, 180, 200, 30);
	        Prixlocation.setBounds(300, 210, 200, 30);
	        Loueur.setBounds(300, 2140, 200, 30);
	        Type.setBounds(300, 270, 220, 30);
	        home.setBounds(50, 10, 400, 60);
	        trecherche.setBounds(50, 70, 130, 30);
	        recherche.setBounds(185, 70, 102, 30);
	        alert.setBounds(350, 90, 200, 30);
	        alert.setForeground(Color.blue);
	        home.setFont(fhome);
	        Numerobien.setFont(font);
	        datedebutlocation.setFont(font);
	        datefinlocation.setFont(font);
	        Prixlocation.setFont(font);
	        Loueur.setFont(font);
	        Type.setFont(font);
	        recherche.setFont(fb);
	        JPanel panel = new JPanel(null);
	        panel.add(home);
	 
	        panel.add(home);
	        panel.add(alert);
	        panel.add(trecherche);
	        panel.add(recherche);
	        panel.add(Numerobien);
	        panel.add(datedebutlocation);
	        panel.add(datefinlocation);
	        panel.add(Prixlocation);
	        panel.add(Loueur);
	        panel.add(Type);
	       
	// Action pour rechercher un élément dans la table bien immobilier grâce a son id
	        recherche.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent actionEvent) {
	                if (!trecherche.getText().isEmpty()) {
	                    try {
	                    	Connect();
	                        pst = con.prepareStatement("SELECT * FROM location WHERE N°bien= ?");
	                        pst.setString(1, trecherche.getText());
	                        rs = pst.executeQuery();
	                        if (rs.next()) {
	                        	// si cela a été trouver il l'affiche dans la fenetre tout les détail du bien immobilier
	                            alert.setText("Recherche effectuée avev succes!");
	                            Numerobien.setText("numéro du bien: " + rs.getString("N°bien"));
	                            datedebutlocation.setText("datelocation: " + rs.getString("datedebutlocation"));
	                            datefinlocation.setText("datelocation: " + rs.getString("datefinlocation"));
	                            Prixlocation.setText("prix location: " + rs.getString("Prixlocation"));
	                            Loueur.setText("loueur " + rs.getString("loueur"));
	                            Type.setText("Type " + rs.getString("Type"));
	                        } else {
	                        	//sinon il le met null
	                            alert.setText("Aucun resultat!");
	                            Numerobien.setText(null);
	                            datedebutlocation.setText(null);
	                            datefinlocation.setText(null);
	                            Prixlocation.setText(null);
	                            Loueur.setText(null);
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
