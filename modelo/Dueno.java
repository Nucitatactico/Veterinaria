package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Dueno {

    private String nombre;
    private String telefono;
    private String direccion;
    private final List<Mascota> mascotas;

    public Dueno(String nombre, String telefono, String direccion) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.mascotas = new ArrayList<>();
    }

    public void agregarMascota(Mascota mascota) {
        if (!mascotas.contains(mascota)) {
            mascotas.add(mascota);
        }
    }

    public void eliminarMascota(Mascota mascota) {
        mascotas.remove(mascota);
    }

    public void describirMascota(Mascota mascota) {
        System.out.println("=== Datos de la mascota ===");
        System.out.println(mascota);
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public List<Mascota> getMascotas() { return mascotas; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dueno)) return false;
        Dueno d = (Dueno) o;
        return nombre.equalsIgnoreCase(d.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre.toLowerCase());
    }

    @Override
    public String toString() {
        return String.format("Dueño: %s | Tel: %s | Dir: %s | Mascotas: %d",
                nombre, telefono, direccion, mascotas.size());
    }
}
