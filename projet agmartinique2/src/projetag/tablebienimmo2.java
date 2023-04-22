package projetag;
import javax.swing.*;
import javax.swing.table.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class tablebienimmo2 extends AbstractTableModel {
	   // D�clarez les variables de connexion et la base de donn�es ici
 private Connection conn;
 private Statement stmt;
 private ResultSet rs;
 private String[] columnNames ={"N�bien", "Superficie", "rue", "ville","type de bien immobillier","capacite","en location","Date debut location","Date fin location","Prix location","Pourquoi on utilise","le loueur"};
 private Object[][] data;

 public tablebienimmo2() {
     // Etablissez la connexion et la base de donn�es ici
     try {
         // Enregistrez le pilote JDBC
     	Class.forName("com.mysql.cj.jdbc.Driver");
         // Ouvrez la connexion de la base de donn�es
     	conn=DriverManager.getConnection("jdbc:mysql://localhost/agmartinique","root","");
         // Creez un objet pour ex�cuter des requ�tes SQL
     	 stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
     } catch (Exception e) {
         e.printStackTrace();
     }
 }

 public int getColumnCount() {
     return columnNames.length;
 }

 public int getRowCount() {
     try {
         // Ex�cutez une requ�te pour r�cup�rer le nombre de clients
         rs = stmt.executeQuery("SELECT COUNT(*) FROM bienimmo b Join location l ON l.N�bien=b.N�bien WHERE l.N�bien=b.N�bien");
         rs.next();
         return rs.getInt(1);
     } catch (SQLException e) {
         e.printStackTrace();
         return 0;
     }
 }

 public String getColumnName(int col) {
     return columnNames[col];
 }

 public Object getValueAt(int row, int col) {
     try {
         // Ex�cutez une requ�te pour r�cup�rer les d�tails des clients
         rs = stmt.executeQuery("SELECT b.N�bien,surperficie,rue,villle,b.Type,capacite,Achet�,datedebutlocation,datefinlocation,Prixlocation,l.Type,loueur FROM bienimmo b Join location l ON l.N�bien=b.N�bien WHERE l.N�bien=b.N�bien");
         rs.absolute(row + 1);
         return rs.getObject(col + 1);
     } catch (SQLException e) {
         e.printStackTrace();
         return null;
     }
 }

 public boolean isCellEditable(int row, int col) {
     return col != 0;
 }

 public void setValueAt(Object value, int row, int col) {
     try {
         // Ex�cutez une requ�te pour mettre � jour les d�tails des clients
         PreparedStatement pstmt = conn.prepareStatement("UPDATE bienimmo SET " + columnNames[col] + " = ? WHERE N�bien= ?");
         pstmt.setObject(1, value);
         pstmt.setInt(2, (int) getValueAt(row, 0));
         pstmt.executeUpdate();
     } catch (SQLException e) {
         e.printStackTrace();
         }
 }



}
