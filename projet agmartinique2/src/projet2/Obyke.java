package projet2;
import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.event.ActionEvent;
import java.sql.*;
public class Obyke extends JFrame{
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	private static JMenu m1;
	private  static JMenu m2;
	private  static JMenu m5;
	private  static JMenu m6;
	private  static JMenu m7;
	private  static JMenuItem m8;
	private  static JMenuItem m9;
	private  static JMenuItem m10;
	private static JMenuItem m11;
	private static JMenuItem m12;
	private static JMenu m15;
	private static JMenu m16;
	private static JMenuItem m13;
	private static JMenuItem m14;

	private static final long serialVersionUID = -7390516394922878897L;
	// Construction de l'interface graphique
	public Obyke() {
		super("Obyke");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(new Dimension(600,400));
		this.setLocationRelativeTo(null);
		this.setJMenuBar(createMenuBar());
		//BackGround pn=new BackGround("img/fond.jpg");
		//add(pn);
		//pn.setLayout(null);
	}
	
	//construction de la bar de menu avec chaque bouton 
		private JMenuBar createMenuBar() {
		JMenuBar mb = new JMenuBar();
		m1 = new JMenu("Centre");
			m8= new JMenuItem("Licenciés");
			m9= new JMenuItem("Hotels");
			m10= new JMenuItem("Instituts");
			m11= new JMenuItem("Quitter");
		 m2 = new JMenu("RDV");
		 m5 = new JMenu("Matériel");
		 	m12= new JMenuItem("Occasion");
			m13= new JMenuItem("Neuf");
			m14= new JMenuItem("Garanties");
			m15= new JMenu("Services");
				
		 m6=new JMenu("Vendre");
		 m7 = new JMenu("?");

		mb.add(m1);
		mb.add(m2);
		mb.add(m5);
		mb.add(m6);
		mb.add(m7);
		m1.add(m8);
		m1.add(m9);
		m1.add(m10);
		m1.add(m11);
		m5.add(m12);
		m5.add(m13);
		m5.add(m14);
		m5.add(m15);
		return mb;
		
}
		public static void main(String[] args) throws Exception {
			// TODO Auto-generated method stub
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
			Obyke obyke =new Obyke();
			obyke.setVisible(true);
			
		}		
}

