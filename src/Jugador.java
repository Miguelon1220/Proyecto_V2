// Clase Jugador que almacena la información de cada jugador
public class Jugador {
    private String nombre;
    private String apellido;
    private String equipo;

    // Constructor de la clase Jugador
    public Jugador(String nombre, String apellido, String equipo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.equipo = equipo;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Apellido: " + apellido + ", Equipo: " + equipo;
    }
}