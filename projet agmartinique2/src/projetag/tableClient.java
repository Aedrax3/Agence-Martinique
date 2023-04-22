package projetag;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.*;

import javax.swing.*;

import javax.swing.table.*;

public class tableClient extends JFrame implements ActionListener {
	private JButton addButton;
	private JButton editButton;
	private JButton deleteButton;
	public tableClient () {
		this.setTitle("Fiche client");
		this.setSize(600,400);
		this.setLocationRelativeTo(null);

		JPanel pn=new JPanel();
		pn.setLayout(new BorderLayout());

		Client model = new Client();
		JTable table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);

		//Ajouter un ScrollPane au JPanel
		pn.add(scrollPane, BorderLayout.CENTER);

		//Créer des bouton et l'ajouter au JPanel
		 addButton = new JButton("Ajouter");
		 addButton.addActionListener(this);
		 editButton = new JButton("Modifier");
		 editButton.addActionListener(this);
		 deleteButton=new JButton("Supprimer");
		 deleteButton.addActionListener(this);
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(addButton);
		buttonPanel.add(editButton);
		buttonPanel.add(deleteButton);

		//Add the buttonPanel to the main JPanel using the BorderLayout.SOUTH constraint
		pn.add(buttonPanel, BorderLayout.SOUTH);

		this.add(pn);

     
	}
	
// création d'action pour bouton
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source =e.getSource();
		if(source==addButton) {
			ajouterclt cl= new ajouterclt();
			cl.setVisible(true);
			
		}else if(source==editButton) {
			modifclt cl=new modifclt();
			cl.setVisible(true);
		}else if(source==deleteButton) {
			supclt cl =new supclt();
			cl.setVisible(true);
		}
		
	}
}
