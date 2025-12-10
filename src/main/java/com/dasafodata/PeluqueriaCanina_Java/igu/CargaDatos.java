package com.dasafodata.PeluqueriaCanina_Java.igu;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import com.dasafodata.PeluqueriaCanina_Java.logica.Controladora;

public class CargaDatos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textRaza;
	private JTextField textColor;
	private JTextField textNomDueno;
	private JTextField textMovil;
	
	private JTextArea textObservaciones;
    private JComboBox<String> cmbAlergico;
    private JComboBox<String> cmbEspecial;

	//PAra el boton guardar necesitaremos mandarle la info a Controladora.java
	//de ahi pasara la info al resto de controladores en la capa de persistencia
	Controladora control = new Controladora();


	/**
	 * Create the frame.
	 */
	public CargaDatos() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCargaDeDatos = new JLabel("Carga de Datos");
		lblCargaDeDatos.setFont(new Font("Dialog", Font.BOLD, 30));
		lblCargaDeDatos.setBounds(228, 28, 237, 36);
		contentPane.add(lblCargaDeDatos);

		JPanel panel = new JPanel();
		panel.setBounds(27, 76, 246, 394);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_1.setBounds(12, 28, 80, 17);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Raza:");
		lblNewLabel_1_1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(12, 57, 39, 17);
		panel.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Color:");
		lblNewLabel_1_1_1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_1_1_1.setBounds(12, 86, 42, 17);
		panel.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Alérgico:");
		lblNewLabel_1_1_1_1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_1_1_1_1.setBounds(12, 124, 80, 17);
		panel.add(lblNewLabel_1_1_1_1);

		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Atención Especial:");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_1_1_1_1_1.setBounds(12, 169, 127, 17);
		panel.add(lblNewLabel_1_1_1_1_1);

		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Nombre Dueño:");
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_1_1_1_1_1_1.setBounds(12, 213, 127, 17);
		panel.add(lblNewLabel_1_1_1_1_1_1);

		JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("Móvil Dueño:");
		lblNewLabel_1_1_1_1_1_1_1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_1_1_1_1_1_1_1.setBounds(12, 257, 108, 17);
		panel.add(lblNewLabel_1_1_1_1_1_1_1);

		JLabel lblNewLabel_1_1_1_1_1_1_2 = new JLabel("Observaciones:");
		lblNewLabel_1_1_1_1_1_1_2.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_1_1_1_1_1_1_2.setBounds(12, 299, 108, 17);
		panel.add(lblNewLabel_1_1_1_1_1_1_2);

		textNombre = new JTextField();
		textNombre.setBounds(88, 26, 114, 21);
		panel.add(textNombre);
		textNombre.setColumns(10);

		textRaza = new JTextField();
		textRaza.setBounds(58, 57, 114, 21);
		panel.add(textRaza);
		textRaza.setColumns(10);

		textColor = new JTextField();
		textColor.setBounds(68, 84, 114, 21);
		panel.add(textColor);
		textColor.setColumns(10);

		textNomDueno = new JTextField();
		textNomDueno.setBounds(128, 211, 114, 21);
		panel.add(textNomDueno);
		textNomDueno.setColumns(10);

		textMovil = new JTextField();
		textMovil.setBounds(110, 255, 114, 21);
		panel.add(textMovil);
		textMovil.setColumns(10);

		textObservaciones = new JTextArea();
		textObservaciones.setBounds(125, 299, 117, 83);
		panel.add(textObservaciones);

		cmbAlergico = new JComboBox();
		cmbAlergico.setModel(new DefaultComboBoxModel(new String[] {"- ", "Si", "No"}));
		cmbAlergico.setBounds(99, 119, 57, 26);
		panel.add(cmbAlergico);

		cmbEspecial = new JComboBox();
		cmbEspecial.setModel(new DefaultComboBoxModel(new String[] {"-", "Si", "No"}));
		cmbEspecial.setBounds(157, 164, 45, 26);
		panel.add(cmbEspecial);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("/home/david/Documents/Programacion/PeluqueriaCanina_Java/src/main/resources/img/Screenshot from 2025-12-05 18-10-55.png"));
		lblNewLabel.setBounds(275, 76, 363, 310);
		contentPane.add(lblNewLabel);

		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Si hay texto que lo limpie
				textNombre.setText("");
				textRaza.setText("");
				textColor.setText("");
				textObservaciones.setText("");
				textNomDueno.setText("");
				textMovil.setText("");

				cmbAlergico.setSelectedIndex(0); //que vuelva a la primera posicion(el -)
				cmbEspecial.setSelectedIndex(0);

			}
		});
		
		btnLimpiar.setFont(new Font("Dialog", Font.BOLD, 14));
		btnLimpiar.setBounds(322, 412, 105, 42);
		contentPane.add(btnLimpiar);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				String nombreMasco = textNombre.getText(); //cogemos el nombre del animal
				String raza = textRaza.getText();
				String color = textColor.getText();
				String observaciones = textObservaciones.getText();

				String alergico = (String) cmbAlergico.getSelectedItem();
				String atemEsp = (String) cmbEspecial.getSelectedItem();


				String nombreDuenio = textNomDueno.getText();
				String movil = textMovil.getText();

				//lo guadamos usando la funcion guardar que hay en Controladora
				control.guardar(nombreMasco, raza, color, observaciones, alergico, atemEsp, nombreDuenio, movil);

				//para que saque un cartel cuando se guarde
				JOptionPane optionPane = new JOptionPane("Guardado correctamente.");
				optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
				JDialog dialog = optionPane.createDialog("Guardado Exitoso!");
				dialog.setAlwaysOnTop(true);
				dialog.setVisible(true);

			}
		});
		btnGuardar.setFont(new Font("Dialog", Font.BOLD, 14));
		btnGuardar.setBounds(474, 412, 105, 42);
		contentPane.add(btnGuardar);

	}
}
