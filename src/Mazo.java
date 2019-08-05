import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Mazo {
	
	ArrayList<JLabelCarta> mazo;
	File archivo;
	BufferedImage cartafrente;
	BufferedImage cartadorso;
	private File archivo2;
	public Mazo() {

		mazo = new ArrayList<JLabelCarta>();
		archivo = new File("C:\\Users\\Facundo\\Downloads\\boardgamePack_v2\\Spritesheets\\playingCards.png");
		archivo2 = new File("C:\\Users\\Facundo\\Downloads\\boardgamePack_v2\\Spritesheets\\playingCardBacks.png");
		try {
			 cartafrente = ImageIO.read(getClass().getResourceAsStream("\\playingCards.png"));
			 cartadorso = ImageIO.read(getClass().getResourceAsStream("\\playingCardBacks.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int y=0;	
		int r = (int)(Math.random()*3);
		for(int z = 0; z<10;z++) {			
			int x=0;
			for(int i = 0; i<5;i++) {		
			mazo.add(new JLabelCarta(new ImageIcon(cartafrente.getSubimage(x, y, 140, 190)), new ImageIcon(cartadorso.getSubimage(r*140, 0, 140, 190))));
			x+=140;			
			}
			y+=190;
		}			
	}	
	
	public void repartirCartas() {
		
		ArrayList<JLabelCarta> cartaspartida = new ArrayList<JLabelCarta>();
		cartaspartida.clear();
		
		for(int i=0; i<(int)Inicio.getCartas().getSelectedItem();i++) {	
			JLabelCarta label = new JLabelCarta(mazo.get((int)(Math.random()*mazo.size())).cartafrente(), JLabelCarta.cartadorso());
			label.setNumeroCarta(i);
			cartaspartida.add(label);
			if((int)(Math.random()*2)==1) label.setIcon(label.cartafrente());
			else label.setIcon(JLabelCarta.cartadorso());
			Juego.laminamedia().add(label);
		}
			for(JLabelCarta c: cartaspartida) {
			c.addMouseListener(new MouseAdapter() {
						
				public void mouseClicked(MouseEvent e) {
					
					new Controlador(cartaspartida, c);

					}
				});
						
			}		
		}	
	}



@SuppressWarnings("serial")
class JLabelCarta extends JLabel {
	
	static ImageIcon cartadorso;
	ImageIcon cartafrente;
	private  int numerocarta;
	public JLabelCarta(ImageIcon cartafrente, ImageIcon cartadorso) {		
		this.cartafrente=cartafrente;
		JLabelCarta.cartadorso=cartadorso;
	}	
	public static ImageIcon cartadorso() {		
		return cartadorso;		
	}
	
	public ImageIcon cartafrente() {		
		return cartafrente;
	}	
	public int numeroCarta() {	
		return numerocarta;
	}
	public void setNumeroCarta(int numerocarta) {		
		this.numerocarta = numerocarta;
	}	
}
