package modelo;

import java.time.LocalDate;
import utilerias.GeneracionAleatoria;

/**
 * Representa una consulta médica agendada para una mascota.
 */
public class Cita {

	private String motivo;
	private LocalDate fecha;
	private String diagnostico;
	private String tratamiento;
	private String observaciones;

	public Cita(String motivo, LocalDate fecha) {
		this.motivo = motivo;
		this.fecha = fecha;
		generarDiagnostico();
		generarTratamiento();
		generarObservaciones();
	}

	//aleatorizadores
	public String generarDiagnostico() {
		this.diagnostico = GeneracionAleatoria.diagnostico();
		return this.diagnostico;
	}

	public String generarTratamiento() {
		this.tratamiento = GeneracionAleatoria.tratamiento();
		return this.tratamiento;
	}

	public String generarObservaciones() {
		this.observaciones = GeneracionAleatoria.observacion();
		return this.observaciones;
	}

	//getters y setters
	public String getMotivo() { return motivo; }
	public void setMotivo(String motivo) { this.motivo = motivo; }

	public LocalDate getFecha() { return fecha; }
	public void setFecha(LocalDate fecha) { this.fecha = fecha; }

	public String getDiagnostico() { return diagnostico; }
	public String getTratamiento() { return tratamiento; }
	public String getObservaciones() { return observaciones; }

	@Override
	public String toString() {
		return String.format(
				"\n\tFecha: %s \n\tMotivo: %s\n\tDiagnóstico: %s\n\tTratamiento: %s\n\tObservaciones: %s\n",
				fecha, motivo, diagnostico, tratamiento, observaciones);
	}
}
