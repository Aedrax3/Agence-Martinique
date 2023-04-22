package projetag;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

public class fichebienimmo extends JFrame implements ActionListener {
	private JButton editButton;
	private JButton deleteButton;
	public fichebienimmo() {
		this.setTitle("Fiche Vente");
		this.setSize(600,400);
		this.setLocationRelativeTo(null);

		JPanel pn=new JPanel();
		pn.setLayout(new BorderLayout());

		tablebienimmo model = new tablebienimmo();
		JTable table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);

		//Ajouter un ScrollPane au JPanel
		pn.add(scrollPane, BorderLayout.CENTER);

		//Cr�er des bouton et l'ajouter au JPanel
		 editButton = new JButton("Modifier");
		 editButton.addActionListener(this);
		 deleteButton=new JButton("Supprimer");
		 deleteButton.addActionListener(this);
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(editButton);
		buttonPanel.add(deleteButton);

		//Add the buttonPanel to the main JPanel using the BorderLayout.SOUTH constraint
		pn.add(buttonPanel, BorderLayout.SOUTH);

		this.add(pn);

     
	}
	
// cr�ation d'action pour bouton
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source =e.getSource();
		 if(source==editButton) {
			modifbienimmo cl=new modifbienimmo();
			cl.setVisible(true);
		}else if(source==deleteButton) {
			supbienimmo cl =new supbienimmo();
			cl.setVisible(true);
		}
		
	}

	
}

