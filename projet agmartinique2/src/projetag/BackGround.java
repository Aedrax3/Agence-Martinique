package projetag;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class BackGround extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	private String path;
	
	public BackGround(String p) {
		// TODO Auto-generated constructor stub
		this.path = p;
	}
	
	public void paintComponent(Graphics g) {
		g.fillRect(0, 0, getWidth(), getHeight());
		
		try {
			Image image = ImageIO.read(new File(this.path));
			g.drawImage(image, 0, 0,getWidth(), getHeight(), this);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}