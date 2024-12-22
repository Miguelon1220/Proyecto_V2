import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Menu_Frame extends JFrame implements ActionListener {
    private JMenuBar barra_menu;
    private JMenuItem Nuevo,Informacion_del_Programa,Jugadores;
    private ArrayList<Jugador> jugadores;
    public Menu_Frame() {
        setLayout(null);
        // Inicializar lista de jugadores
        jugadores = new ArrayList<>();

        //Creacion de Barra Menu
        barra_menu = new JMenuBar();

        //Creacion de Jmenu Barra
        JMenu Archivo = new JMenu("Archivo");
        JMenu Editar = new JMenu("Editar");
        JMenu Acerca_De = new JMenu("Acerca De");

        //Creacion JMenu Items Archivo
        Nuevo = new JMenuItem("Nuevo");
        Nuevo.addActionListener(this);
        JMenuItem Salir = new JMenuItem("Salir");
        Salir.addActionListener(this);
        JMenuItem Guardar = new JMenuItem("Guardar");
        Guardar.addActionListener(this);
        JMenuItem Guardar_Como = new JMenuItem("Guardar Como");
        Guardar_Como.addActionListener(this);

        //Creacion JMenu Items Editar
        JMenu Consulta = new JMenu("Consulta");
        JMenuItem Actualizar = new JMenuItem("Actualizar");
        Actualizar.addActionListener(this);
        JMenuItem Borrar = new JMenuItem("Borrar");
        Borrar.addActionListener(this);

        //Creacion JMenu Items Consulta
        Jugadores = new JMenuItem("Jugadores");
        Jugadores.addActionListener(this);
        JMenuItem Equipos = new JMenuItem("Equipos");
        Equipos.addActionListener(this);
        JMenuItem Arbitros = new JMenuItem("Arbitros");
        Arbitros.addActionListener(this);
        JMenuItem Dirigentes = new JMenuItem("Dirigentes");
        Dirigentes.addActionListener(this);

        //
        Informacion_del_Programa = new JMenuItem("Informacion del Programa");
        Informacion_del_Programa.addActionListener(this);
        JMenuItem Autores = new JMenuItem("Autores");
        Autores.addActionListener(this);

        // Anadir Jmenus a Barra Menu
        add(barra_menu);
        setJMenuBar(barra_menu);
        barra_menu.add(Archivo);
        barra_menu.add(Editar);
        barra_menu.add(Acerca_De);

        // Anadir JmenuItems a Archivo
        Archivo.add(Nuevo);
        Archivo.add(Salir);
        Archivo.add(Guardar);
        Archivo.add(Guardar_Como);

        // Anadir JmenuItems a Editar
        Editar.add(Consulta);
        Editar.add(Actualizar);
        Editar.add(Borrar);

        // Anadir JmenuItems a Consulta
        Consulta.add(Jugadores);
        Consulta.add(Equipos);
        Consulta.add(Arbitros);
        Consulta.add(Dirigentes);

        // Anadir JmenuItems a Acerca De
        Acerca_De.add(Informacion_del_Programa);
        Acerca_De.add(Autores);

    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==Nuevo){
            Formulario_2 VentanaNuevo = new Formulario_2(jugadores);
            VentanaNuevo.setVisible(true);
            VentanaNuevo.setBounds(0,0,600,500);

        }
        if (e.getSource() == Jugadores) {
            // Mostrar los jugadores guardados en memoria
            if (jugadores.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No hay jugadores registrados.", "Consulta Jugadores", JOptionPane.INFORMATION_MESSAGE);
            } else {
                StringBuilder sb = new StringBuilder();
                for (Jugador jugador : jugadores) {
                    sb.append(jugador).append("\n");
                }
                JOptionPane.showMessageDialog(this, sb.toString(), "Jugadores Registrados", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        if (e.getSource() == Informacion_del_Programa) {
            JOptionPane.showMessageDialog(this, "Este programa registra y muestra información de jugadores.", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
