package com.dasafodata.PeluqueriaCanina_Java.igu;

import com.dasafodata.PeluqueriaCanina_Java.logica.Controladora;
import com.dasafodata.PeluqueriaCanina_Java.logica.Mascota;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VerDatos extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable tablaMascotas;
    
    // Instancia de la controladora lógica
    Controladora control = null;

    public VerDatos() {
        // Inicializamos la controladora
        control = new Controladora();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 850, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Título principal
        JLabel lblTitulo = new JLabel("Visualización de Datos");
        lblTitulo.setFont(new Font("Dialog", Font.BOLD, 30));
        lblTitulo.setBounds(148, 56, 348, 36);
        contentPane.add(lblTitulo);

        // Panel contenedor secundario
        JPanel panel = new JPanel();
        panel.setBounds(33, 120, 665, 456);
        contentPane.add(panel);
        panel.setLayout(null);

        // Etiqueta "Datos de Mascotas"
        JLabel lblDatos = new JLabel("Datos de Mascotas:");
        lblDatos.setFont(new Font("Dialog", Font.BOLD, 14));
        lblDatos.setBounds(12, 22, 146, 22);
        panel.add(lblDatos);

        // 1. Creamos el JScrollPane
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 56, 503, 388);
        panel.add(scrollPane);
        
        // 2. Creamos la tabla
        tablaMascotas = new JTable();
        tablaMascotas.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        
        // 3. Metemos la tabla DENTRO del ScrollPane
        scrollPane.setViewportView(tablaMascotas);

        // Botón Eliminar
        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                // Verificar que la tabla no esté vacía
                if(tablaMascotas.getRowCount() > 0) { 
                    
                    // Verificar que se haya seleccionado una fila
                    if(tablaMascotas.getSelectedRow() != -1 ) { 
                        
                        // Obtener el ID de la mascota a eliminar (columna 0)
                        int num_cliente = Integer.parseInt(String.valueOf(tablaMascotas.getValueAt(tablaMascotas.getSelectedRow(), 0)));
                    
                        // Llamar a la controladora para borrar
                        control.borrarMascota(num_cliente);
                        
                        // Avisar al usuario
                        mostrarMensaje("Mascota eliminada correctamente", "Info", "Borrado de mascota");
                        
                        // IMPORTANTE: Recargar la tabla para ver los cambios
                        cargarTabla();
                                            
                    } else {
                        mostrarMensaje("No se seleccionó ninguna mascota", "Error", "Error al eliminar");
                    }
                } else {
                    mostrarMensaje("No hay datos para eliminar", "Error", "Error al eliminar");
                }
            }
        });
        
        btnEliminar.setBounds(548, 81, 105, 56);
        panel.add(btnEliminar);

        // Botón Editar
        JButton btnEditar = new JButton("Editar");
        btnEditar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
                    // Verificar que la tabla no esté vacía
                    if(tablaMascotas.getRowCount() > 0) { 
                        
                        // Verificar que se haya seleccionado una fila
                        if(tablaMascotas.getSelectedRow() != -1 ) { 
                        	
                        	// Obtener el ID de la mascota a editar
                            int num_cliente = Integer.parseInt(String.valueOf(tablaMascotas.getValueAt(tablaMascotas.getSelectedRow(), 0)));
                            
                            //creamos una pantalla de tipo ModificarDatos y la hacemos visible
                            ModificarDatos pantallaModif = new ModificarDatos(num_cliente);
                            pantallaModif.setVisible(true);
                            pantallaModif.setLocationRelativeTo(null); //para que aparezca en el medio
                            
                          //cerramos la ventana
            				VerDatos.this.dispose();
                        	
                        } else {
                            mostrarMensaje("No se seleccionó ninguna mascota", "Error", "Error al eliminar");
                        }
                    } else {
                        mostrarMensaje("No hay datos para eliminar", "Error", "Error al eliminar");
                    }
                    
                    

        	}
        });
        btnEditar.setBounds(548, 154, 105, 56);
        panel.add(btnEditar);
        
        // Evento para cargar la tabla al abrir la ventana
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                cargarTabla();
            }
        });
    
    } // <--- AQUÍ TERMINA EL CONSTRUCTOR

    
    // Método para mostrar mensajes (FUERA del constructor)
    public void mostrarMensaje(String mensaje, String tipo, String titulo) {
        JOptionPane optionPane = new JOptionPane(mensaje);
        
        if(tipo.equals("Info")){
            optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
        } else if(tipo.equals("Error")) {
            optionPane.setMessageType(JOptionPane.ERROR_MESSAGE);
        }
        
        JDialog dialog = optionPane.createDialog(titulo);
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(true);
    }

    // Método para cargar la tabla (FUERA del constructor)
    public void cargarTabla() {
        
        DefaultTableModel modeloTabla = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; 
            }
        };

        String titulos[] = {"Num", "Nombre", "Color", "Raza", "Alergico", "At. Esp.", "Dueño", "Móvil"};
        modeloTabla.setColumnIdentifiers(titulos);

        List<Mascota> listaMascotas = control.traerMascotas();

        if (listaMascotas != null) {
            for (Mascota masco : listaMascotas) {
                Object[] objeto = {
                    masco.getNum_cliente(), 
                    masco.getNombre(), 
                    masco.getColor(),
                    masco.getRaza(), 
                    masco.getAlergico(), 
                    masco.getAtencion_especial(),
                    masco.getUnDuenio().getNombre(), 
                    masco.getUnDuenio().getMovil()
                };
                modeloTabla.addRow(objeto);
            }
        }
        
        tablaMascotas.setModel(modeloTabla);
    }
}