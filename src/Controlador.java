import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JLabel;

public class Controlador {
	
	static int controlador = 0;
	
	public Controlador(ArrayList<JLabelCarta> cartas, JLabelCarta c) {
		
		
		if(cartas.get(c.numeroCarta()).getIcon()==c.cartafrente()) {
		controlador++;
		if(controlador==(int)Inicio.getCartas().getSelectedItem()) {
			JLabel label = new JLabel("Ganaste!!");
			label.setPreferredSize(new Dimension(100,100));
			label.setAlignmentX(JComponent.CENTER_ALIGNMENT);
			label.setForeground(Color.GREEN);
			Juego.laminamedia().add(label);
			controlador=0;
		}
		cartas.get(c.numeroCarta()).setVisible(false);
		
		System.out.println(c.numeroCarta());
		if((c.numeroCarta()-1>=0) && (c.numeroCarta()<cartas.size()-1)) {
			if(cartas.get(c.numeroCarta()-1).getIcon()==cartas.get(c.numeroCarta()-1).cartafrente()) {
			cartas.get(c.numeroCarta()-1).setIcon(JLabelCarta.cartadorso());
			}
			else if(cartas.get(c.numeroCarta()-1).getIcon()==JLabelCarta.cartadorso()) {
				cartas.get(c.numeroCarta()-1).setIcon(cartas.get(c.numeroCarta()-1).cartafrente());
			}			
			if(cartas.get(c.numeroCarta()+1).getIcon()==cartas.get(c.numeroCarta()+1).cartafrente()) {
				cartas.get(c.numeroCarta()+1).setIcon(JLabelCarta.cartadorso());
			}
			else if(cartas.get(c.numeroCarta()+1).getIcon()==JLabelCarta.cartadorso()) {
				cartas.get(c.numeroCarta()+1).setIcon(cartas.get(c.numeroCarta()+1).cartafrente());
			}
		}
		else if(c.numeroCarta()==0) {
			if(cartas.get(c.numeroCarta()+1).getIcon()==cartas.get(c.numeroCarta()+1).cartafrente()){
				cartas.get(c.numeroCarta()+1).setIcon(JLabelCarta.cartadorso());
			}
			else if(cartas.get(c.numeroCarta()+1).getIcon()==JLabelCarta.cartadorso()) {
				cartas.get(c.numeroCarta()+1).setIcon(cartas.get(c.numeroCarta()+1).cartafrente());
			}			
		}
		else if(c.numeroCarta()==cartas.size()-1) {
			if(cartas.get(c.numeroCarta()-1).getIcon()==cartas.get(c.numeroCarta()-1).cartafrente()){
				cartas.get(c.numeroCarta()-1).setIcon(JLabelCarta.cartadorso());
			}
			else if(cartas.get(c.numeroCarta()-1).getIcon()==JLabelCarta.cartadorso()) {
				cartas.get(c.numeroCarta()-1).setIcon(cartas.get(c.numeroCarta()-1).cartafrente());
			}	
		}		
		}
	}
}
