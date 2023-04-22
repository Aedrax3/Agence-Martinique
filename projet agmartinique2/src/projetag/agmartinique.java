package projetag;
import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import java.awt.event.ActionEvent;
import java.sql.*;
public  class agmartinique extends JFrame{
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	private static JMenu m1;
	private  static JMenu m2;
	private  static JMenu m5;
	private  static JMenu m6;
	private  static JMenu m7;
	private  static JMenuItem m4;
	private  static JMenuItem m3;
	private  static JMenuItem m8;
	private  static JMenuItem m9;
	private  static JMenuItem m10;
	private static JMenu m11;
	private static JMenuItem m12;
	private static JMenu m15;
	private static JMenu m16;
	private static JMenuItem m14;
	private static JMenuItem m17;
	private static JMenuItem m18;
	private static JMenuItem m19;
	private static JMenuItem m20;
	private static JMenuItem m21;
	private static JMenuItem m22;
	private static JMenuItem m23;
	private static JMenuItem m24;
	private static JMenu m25;
	private static final long serialVersionUID = -7390516394922878897L;
	// Construction de l'interface graphique
	public agmartinique() {
		super("agence martinique");
		Connect();
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(new Dimension(600,400));
		this.setLocationRelativeTo(null);
		this.setJMenuBar(createMenuBar());
		BackGround pn=new BackGround("img/fond.jpg");
		add(pn);
		pn.setLayout(null);
		
	}
	//construction de la bar de menu avec chaque bouton 
		private JMenuBar createMenuBar() {
		JMenuBar mb = new JMenuBar();
		m1 = new JMenu("Bien immo");
		 m2 = new JMenu("Client");
		 m5 = new JMenu("Rechercher");
		 m6=new JMenu("Location");
		 m7 = new JMenu("Vente");
		 m25 = new JMenu("Recapitulatif");
		 m3= m25.add(fichebienimmo);
		 m10=m25.add(fichebienimmo2);
		 m4= m2.add(clients);
		 m8=m6.add(rechercher);
		 m9=m7.add(rechercher2);
		 m11 =new JMenu("Nouveau");
		 m14 =m1.add(quitter);
		 m15=new JMenu("Location");
		 m16 = new JMenu("Vente");
		 m17 =m1.add(Appartement1);
		 m18 =m1.add(Villa1);
		m19 =m1.add(Salle1);
		m20=m1.add(localcom1);
		 m21 =m1.add(Appartement2);
		m22 =m1.add(Villa2);
		m23 =m1.add(Salle2);
		 m24=m1.add(localcom2);
		mb.add(m1);
		mb.add(m2);
		mb.add(m5);
		m1.add(m25);
		m1.add(m11);
		m1.add(m14);
		m5.add(m6);
		m5.add(m7);
		m11.add(m15);
		m11.add(m16);
		m15.add(m17);
		m15.add(m18);
		m15.add(m19);
		m15.add(m20);
		m16.add(m21);
		m16.add(m22);
		m16.add(m23);
		m16.add(m24);
		return mb;
		
	}
		
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		agmartinique agmartinique=new agmartinique();
		agmartinique.setVisible(true);
		
	}

	//Cr�ation d'action pour chaque boutton
	private AbstractAction rechercher = new AbstractAction() {
	    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{   // Nom de l'action 
	    	putValue( Action.NAME, "Recherche" );
	     	    }
	    
	    @Override public void actionPerformed( ActionEvent e ) {
	    	// appel a une autre interface 
	    	recherche recherche1 = new recherche();
	    	recherche1.setVisible(true);
	    }
	};
	private AbstractAction rechercher2 = new AbstractAction() {
	    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{   // Nom de l'action 
	    	putValue( Action.NAME, "Recherche" );
	     	    }
	    
	    @Override public void actionPerformed( ActionEvent e ) {
	    	// appel a une autre interface 
	    	recherche2 recherche1 = new recherche2();
	    	recherche1.setVisible(true);
	    }
	};
	private AbstractAction quitter = new AbstractAction() {
	    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{  
	        putValue( Action.NAME, "Quitter" );
	       
	    }
	    
	    @Override public void actionPerformed( ActionEvent e ) {
	    	agmartinique.this.dispose();
	    }
	};
	private AbstractAction Appartement1 = new AbstractAction() {
	    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{   
	        putValue( Action.NAME, "Appartement" );
	     	    }
	    
	    @Override public void actionPerformed( ActionEvent e ) {
	        formulappartloue immobilier5=new formulappartloue();
	        immobilier5.setVisible(true);
	    }
	};
	private AbstractAction Appartement2 = new AbstractAction() {
	    {   
	        putValue( Action.NAME, "Appartement" );
	     	    }
	    
	    @Override public void actionPerformed( ActionEvent e ) {
	        formulappartvend immobilier6=new formulappartvend();
	        immobilier6.setVisible(true);
	    }
	};
	private AbstractAction Villa1 = new AbstractAction() {
	    {  
	        putValue( Action.NAME, "Villa" );
	     	    }
	    
	    @Override public void actionPerformed( ActionEvent e ) {
	        formulVillaloue immobilier3=new formulVillaloue();
	        immobilier3.setVisible(true);
	    }
	};
	private AbstractAction Villa2 = new AbstractAction() {
	    {  
	        putValue( Action.NAME, "Villa" );
	     	    }
	    
	    @Override public void actionPerformed( ActionEvent e ) {
	        formulVillavend immobilier4=new formulVillavend();
	        immobilier4.setVisible(true);
	    }
	};
	private AbstractAction Salle1 = new AbstractAction() {
	    {  
	        putValue( Action.NAME, "Salle" );
	     	    }
	    
	    @Override public void actionPerformed( ActionEvent e ) {
	    	formulSalleloue immobilier1 = new formulSalleloue();
	    	immobilier1.setVisible(true);
	    }
	};
	private AbstractAction Salle2 = new AbstractAction() {
	    {   
	        putValue( Action.NAME, "Salle" );
	     	    }
	    
	    @Override public void actionPerformed( ActionEvent e ) {
	    	formulsallevend immobilier2 = new formulsallevend();
	    	immobilier2.setVisible(true);
	    }
	};
	private AbstractAction localcom1 = new AbstractAction() {
	    {   
	        putValue( Action.NAME, "Local Com" );
	     	    }
	    
	    @Override public void actionPerformed( ActionEvent e ) {
	        formulocalcomloue immobilier7=new formulocalcomloue();
	        immobilier7.setVisible(true);
	    }
	};
	private AbstractAction localcom2 = new AbstractAction() {
	    {   
	        putValue( Action.NAME, "Local Com" );
	     	    }
	    
	    @Override public void actionPerformed( ActionEvent e ) {
	       formulocalcomven immobilier8= new formulocalcomven();
	       immobilier8.setVisible(true);
	    }
	};
	private AbstractAction clients = new AbstractAction() {
	    

		{   
	        putValue( Action.NAME, " Fiche client" );
	     	    }
	    
	    @Override public void actionPerformed( ActionEvent e ) {
	      tableClient cl= new tableClient();
	      cl.setVisible(true);
	    }
	};
private AbstractAction fichebienimmo = new AbstractAction() {
	    

		{   
	        putValue( Action.NAME, " Fiche Vente" );
	     	    }
	    
	    @Override public void actionPerformed( ActionEvent e ) {
	      fichebienimmo cl= new fichebienimmo();
	      cl.setVisible(true);
	    }
	};
private AbstractAction fichebienimmo2 = new AbstractAction() {
	    

		{   
	        putValue( Action.NAME, " Fiche location" );
	     	    }
	    
	    @Override public void actionPerformed( ActionEvent e ) {
	      fichebienimmo2 cl= new fichebienimmo2();
	      cl.setVisible(true);
	    }
	};
	// M�thode pour se connecter � la base de donn�es
	public void Connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/agmartinique","root","");
			JOptionPane.showMessageDialog(null, "Connection reussie");
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
	



	
