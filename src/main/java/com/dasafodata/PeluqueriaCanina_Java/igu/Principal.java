package com.dasafodata.PeluqueriaCanina_Java.igu;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;



	/**
	 * Create the frame.
	 */
	public Principal() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(24, 133, 178, 292);
		contentPane.add(panel);

		JButton btnCargarDatos = new JButton("Cargar Datos");
		btnCargarDatos.setBounds(21, 47, 128, 36);
		btnCargarDatos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				//creamos una pantalla de tipo CargaDatos creando una instancia
				CargaDatos pantalla = new CargaDatos();
				//la hacmos visible
				pantalla.setVisible(true);
				//La fojamos en el medio
				pantalla.setLocationRelativeTo(null);
			}
		});
		panel.setLayout(null);
		panel.add(btnCargarDatos);

		JButton btnNewButton_1 = new JButton("Ver Datos");
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//creamos una pantalla de tipo VerDatos creando una instancia
				VerDatos pantalla = new VerDatos();
				//la hacmos visible
				pantalla.setVisible(true);
				//La fojamos en el medio
				pantalla.setLocationRelativeTo(null);

			}
		});
		btnNewButton_1.setBounds(21, 114, 128, 36);
		panel.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Salir");
		btnNewButton_2.setBounds(21, 185, 128, 36);
		panel.add(btnNewButton_2);

		JLabel lblPeluqueraCanina = new JLabel("Peluquería Canina");
		lblPeluqueraCanina.setFont(new Font("Dialog", Font.BOLD, 30));
		lblPeluqueraCanina.setBounds(178, 25, 283, 67);
		contentPane.add(lblPeluqueraCanina);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("/home/david/Documents/Programacion/PeluqueriaCanina_Java/src/main/resources/img/Screenshot from 2025-12-05 18-10-55.png"));
		lblNewLabel.setBounds(249, 104, 389, 342);
		contentPane.add(lblNewLabel);

	}
}
