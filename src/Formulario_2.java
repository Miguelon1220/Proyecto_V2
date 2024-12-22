import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class Formulario_2 extends JFrame implements ActionListener {
    private JLabel Nombre, Apellido, Equipo;
    private JButton Guardar,Regresar;
    private JTextField nombreField,apellidoField, equipoField;
    private DefaultTableModel modelo;
    private ArrayList<Jugador> jugadores;

    public Formulario_2(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
        setLayout(null);
        Nombre = new JLabel("Nombre");
        Nombre.setBounds(50, 20, 50, 20);
        add(Nombre);
        Apellido = new JLabel("Apellido");
        Apellido.setBounds(50, 60, 50, 20);
        add(Apellido);
        Equipo = new JLabel("Equipo");
        Equipo.setBounds(50, 100, 50, 20);
        add(Equipo);
        Guardar = new JButton("Guardar");
        Guardar.setBounds(450, 35, 100, 35);
        add(Guardar);
        Guardar.addActionListener(this);
        Regresar = new JButton("Regresar");
        Regresar.setBounds(450, 75, 100, 35);
        add(Regresar);
        Regresar.addActionListener(this);

        // Campos de texto
        nombreField = new JTextField();
        nombreField.setBounds(100, 20, 150, 20);
        add(nombreField);

        apellidoField = new JTextField();
        apellidoField.setBounds(100, 60, 150, 20);
        add(apellidoField);

        equipoField = new JTextField();
        equipoField.setBounds(100, 100, 150, 20);
        add(equipoField);

        // Crear el modelo de tabla con columnas iniciales
        modelo = new DefaultTableModel();
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Equipo");

        // Crear la tabla usando el modelo
        JTable tabla = new JTable(modelo);
        JScrollPane scrollPane = new JScrollPane(tabla);
        scrollPane.setBounds(45, 140, 500, 200);
        add(scrollPane);

    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == Guardar){
            String nombre = nombreField.getText();
            String apellido = apellidoField.getText();
            String equipo = equipoField.getText();
            // Verificar si los campos no están vacíos
            if (!nombre.isEmpty() && !apellido.isEmpty() && !equipo.isEmpty()) {
                // Crear un nuevo jugador y agregarlo a la lista compartida
                Jugador nuevoJugador = new Jugador(nombre, apellido, equipo);
                jugadores.add(nuevoJugador);  // Guardar el jugador en la lista

                // Añadir el jugador a la tabla de la ventana
                modelo.addRow(new Object[]{nombre, apellido, equipo});

                // Limpiar los campos de texto
                nombreField.setText("");
                apellidoField.setText("");
                equipoField.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, llena todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            if (e.getSource() == Regresar) {
                System.out.println("Cerrando la ventana...");  // Mensaje de depuración
                dispose();  // Cerrar la ventana
            }
        }
    }
}
