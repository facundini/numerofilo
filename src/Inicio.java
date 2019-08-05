import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Inicio {
	
	JLabel cartazul;
	@SuppressWarnings("rawtypes")
	static JComboBox opciones;
	public Inicio() {
		
		JFrame marco = new JFrame();
		File archivo = new File("C:\\Users\\Facundo\\Downloads\\boardgamePack_v2\\PNG\\Cards\\cardBack_blue5.png");
		try {
			BufferedImage imagen = ImageIO.read(getClass().getResourceAsStream("\\cardBack_blue5.png"));
			 cartazul = new JLabel(new ImageIcon(imagen));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		marco.setBounds(200,200,300,500);
		
		JPanel lamina = new JPanel();
		lamina.setBackground(Color.WHITE);
		marco.add(cartazul);
		lamina.add(Box.createVerticalStrut(50));
		JButton boton1 = new JButton("Jugar");
		boton1.setPreferredSize(new Dimension(50,50));
		JButton boton2 = new JButton("Reglas");
		opciones = new JComboBox();
		JLabel label = new JLabel("Cartas:");		
		opciones.setMaximumSize(new Dimension(50,50));
		opciones.setPreferredSize(new Dimension(20,20));
		boton1.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		boton2.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		opciones.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		label.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		cartazul.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		lamina.setLayout(new BoxLayout(lamina, BoxLayout.Y_AXIS));
		lamina.add(boton1);
		lamina.add(Box.createVerticalStrut(40));
		lamina.add(label);
		lamina.add(opciones);
		lamina.add(Box.createVerticalStrut(15));
		lamina.add(cartazul);
		for(int i = 5; i<15; i++) {
			opciones.addItem(i);		
		}
		lamina.add(Box.createVerticalGlue());
		lamina.add(Box.createHorizontalGlue());
		lamina.add(Box.createRigidArea(new Dimension(5,50)));
		lamina.add(boton2);
		lamina.add(Box.createVerticalStrut(100));	
		boton1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				marco.dispose();
				new Juego();				
			}			
		});
		
		boton2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFrame reglas = new JFrame();
				reglas.setBounds(200,200,200,200);
				JLabel reglaslabel = new JLabel("Bueno bro basicamente tenes que hacerle click a las cartas boca arriba para dar vuelta las"
						+ " que tenes al lado y el objetivo es quedarte sin cartas.");
				reglaslabel.setAlignmentX(JComponent.RIGHT_ALIGNMENT);
				reglas.add(reglaslabel);
				reglas.setVisible(true);
				reglas.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
			
		});
		marco.add(lamina);
		marco.setTitle("Cartófilo");
		marco.setVisible(true);
		marco.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
	}
	
	public static JComboBox getCartas() {
		
		return opciones;
	}
}