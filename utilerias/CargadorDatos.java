package utilerias;

import modelo.Dueno;
import modelo.Mascota;
import sistema.Clinica;

public class CargadorDatos {

	public static void cargar(Clinica clinica) {
		clinica.registrarDueno(new Dueno("Ana Lopez", "555-1234", "Av. Reforma 100"));
		clinica.registrarDueno(new Dueno("Luis Perez", "555-5678", "Calle Sol 42"));

		Mascota m1 = new Mascota("Firulais", "Perro", "Labrador", 3, "Ana Lopez");
		m1.agregarAlergia("Pollo");
		clinica.registrarMascota(m1, "Ana Lopez");

		Mascota m2 = new Mascota("Michi", "Gato", "Siamés", 2, "Luis Perez");
		clinica.registrarMascota(m2, "Luis Perez");

	}
}
