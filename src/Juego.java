import java.awt.BorderLayout;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Juego extends JFrame {
	
	private static JPanel laminamedia;

	public Juego() {
		
		JFrame marco = new JFrame();
		JPanel lamina = new JPanel();
		JButton volveratras = new JButton("Menu");
		volveratras.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		JPanel laminasuperior = new JPanel();
		laminasuperior.add(volveratras);
		lamina.setLayout(new BorderLayout());
		GridLayout grid = new GridLayout();
		laminamedia = new JPanel(grid);
		lamina.add(laminamedia, BorderLayout.CENTER);
		lamina.add(laminasuperior, BorderLayout.NORTH);
		marco.setBounds(250,100,1000,650);
		Mazo mazo = new Mazo();
		mazo.repartirCartas();
		volveratras.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				marco.dispose();
				Controlador.controlador=0;
				new Inicio();				
			}									
		});
		marco.add(lamina);
		marco.setVisible(true);
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	}

	static JPanel lamina;
	
	public static JPanel laminamedia() {
		
		return laminamedia;
	}	
}
