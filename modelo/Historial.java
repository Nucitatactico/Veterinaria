package modelo;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Historial {

	private String nombreMascota;
	private final Map<LocalDate, Cita> citas;

	public Historial(String nombreMascota) {
		this.nombreMascota = nombreMascota;
		this.citas = new TreeMap<>();
	}

	public void agendarCita(String nombreMascota, Cita cita) {
		citas.put(cita.getFecha(), cita);
		System.out.println("Cita agendada para "+nombreMascota+" el "+cita.getFecha());
	}

	public void cancelarCita(String nombreMascota, LocalDate fecha) {
		if (citas.remove(fecha) != null) {
			System.out.println("Cita del " + fecha + " cancelada para " + nombreMascota);
		} else {
			System.out.println("No había cita en " + fecha + " para " + nombreMascota);
		}
	}

	public String getNomMascota() { return nombreMascota; }
	
	public Map<LocalDate, Cita> getCitas() {
		return Collections.unmodifiableMap(citas);
	}
}
