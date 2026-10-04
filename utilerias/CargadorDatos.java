package utilerias;

import modelo.Dueno;
import modelo.Mascota;
import sistema.Clinica;

public class CargadorDatos {

	/**
	 * Carga dueños y mascotas de ejemplo en la clínica proporcionada.
	 * @param clinica La instancia de ClinicaVeterinaria donde se cargarán los datos.
	 */
	public static void cargar(Clinica clinica) {
		// Registra Dueños
		clinica.registrarDueno(new Dueno("Ana Lopez", "555-1234", "Av. Reforma 100"));
		clinica.registrarDueno(new Dueno("Luis Perez", "555-5678", "Calle Sol 42"));

		//Registra Mascotas
		Mascota m1 = new Mascota("Firulais", "Perro", "Labrador", 3, "Ana López");
		m1.agregarAlergia("Pollo");
		clinica.registrarMascota(m1, "Ana López");

		Mascota m2 = new Mascota("Michi", "Gato", "Siamés", 2, "Luis Pérez");
		clinica.registrarMascota(m2, "Luis Pérez");

	}
}
