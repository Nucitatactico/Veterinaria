package sistema;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import modelo.Cita;
import modelo.Dueno;
import modelo.Mascota;

/**
 * Servicio central. Mantiene todos los dueños y mascotas registrados
 * y coordina las operaciones entre ellos.
 *
 * Colecciones usadas:
 *   - Map<String, Dueno>   - dueños indexados por nombre
 *   - Map<String, Mascota> - mascotas indexadas por nombre
 *   - List<Mascota>        - dentro de cada Dueno
 *   - Set<String>          - alergias dentro de Mascota
 *   - Map<LocalDate, Cita> - dentro de Historial
 */
public class Clinica{

    private final Map<String, Dueno> duenos;
    private final Map<String, Mascota> mascotas;

    public Clinica() {
        this.duenos = new HashMap<>();
        this.mascotas = new HashMap<>();
    }

    //Duenos

    public void registrarDueno(Dueno dueno) {
        duenos.put(dueno.getNombre().toLowerCase(), dueno);
        System.out.println("Dueño registrado: " + dueno.getNombre());
    }

    public Dueno buscarDueno(String nombre) {
        return duenos.get(nombre.toLowerCase());
    }

    //Mascotas

    public void registrarMascota(Mascota mascota, String nomDueno) {
        Dueno dueno = buscarDueno(nomDueno);
        if (dueno != null) {
            mascota.setNomDueno(dueno.getNombre());
            dueno.agregarMascota(mascota);
            mascotas.put(mascota.getNombre().toLowerCase(), mascota);
            System.out.println("Mascota registrada: " + mascota.getNombre());
        }
    }

    public Mascota buscarMascota(String nombre) {
        return mascotas.get(nombre.toLowerCase());
    }

    public void modificarMascota(String nombre, String nuevaRaza,
                                 int nuevaEdad, String nuevoDueno) {
        Mascota m = buscarMascota(nombre);
        if (m == null) return;

        if (nuevaRaza != null)  m.setRaza(nuevaRaza);
        if (nuevaEdad > 0)      m.setEdad(nuevaEdad);

        if (nuevoDueno != null && !nuevoDueno.equalsIgnoreCase(m.getNomDueno())) {
            Dueno viejo = buscarDueno(m.getNomDueno());
            if (viejo != null) viejo.eliminarMascota(m);

            Dueno nuevo = buscarDueno(nuevoDueno);
            if (nuevo != null) {
                nuevo.agregarMascota(m);
                m.setNomDueno(nuevo.getNombre());
            }
        }
    }

    public void eliminarMascota(String nombre) {
        Mascota m = mascotas.remove(nombre.toLowerCase());
        if (m != null) {
            Dueno d = buscarDueno(m.getNomDueno());
            if (d != null) d.eliminarMascota(m);
            System.out.println("Mascota eliminada: " + nombre);
        }
    }

    public List<Mascota> listarMascotas() {
        return new ArrayList<>(mascotas.values());
    }

    //Citas

    public void agendarCita(String nomMascota, String motivo, LocalDate fecha) {
        Mascota m = buscarMascota(nomMascota);
        if (m == null) return;
        Cita cita = new Cita(motivo, fecha);
        m.getHistorial().agendarCita(nomMascota, cita);
    }

    public void cancelarCita(String nomMascota, LocalDate fecha) {
        Mascota m = buscarMascota(nomMascota);
        if (m == null) return;
        m.getHistorial().cancelarCita(nomMascota, fecha);
    }

    public void mostrarHistorial(String nomMascota) {
        Mascota m = buscarMascota(nomMascota);
        if (m == null) return;

        System.out.println("\n===== HISTORIAL DE " + m.getNombre().toUpperCase() + " =====");
        System.out.println("Dueño: " + m.getNomDueno());
        if (m.getHistorial().getCitas().isEmpty()) {
            System.out.println("(sin citas registradas)");
            return;
        }
        for (Cita c : m.getHistorial().getCitas().values()) {
            System.out.println(c);
        }
    }
}
