package vista;

import java.time.LocalDate;
import java.util.Scanner;

import modelo.Dueno;
import modelo.Mascota;
import sistema.Clinica;
import utilerias.CargadorDatos;

public class Menu {

	private final Scanner sc;
	private final Clinica clinica;

	public Menu() {
		this.sc = new Scanner(System.in);
		this.clinica = new Clinica();
		CargadorDatos.cargar(this.clinica);
	}

	public void iniciar() {
		int opcion;
		do {
			mostrarMenu();
			opcion = leerEntero("Opción: ");
			System.out.println("");

			switch (opcion) {
				case 1->
					registrarDueno();
				case 2->
					registrarMascota();
				case 3->
					modificarMascota();
				case 4->
					eliminarMascota();
				case 5->
					consultarDueno();
				case 6->
					agendarCita();
				case 7->
					cancelarCita();
				case 8->
					mostrarHistorial();
				case 9->
					listarMascotas();
				case 10->
					agregarAlergia();
				case 11->
					eliminarAlergia();
				case 0->
					System.out.println("Adios tonotos...");
				default->
					System.out.println("Lea bien");
			}
		} while (opcion != 0);
	}

	private void mostrarMenu() {
		System.out.println("\n\tClinica veterinaria");
		System.out.println("1. Registrar dueño");
		System.out.println("2. Registrar mascota");
		System.out.println("3. Modificar mascota");
		System.out.println("4. Eliminar mascota");
		System.out.println("5. Consultar dueño");
		System.out.println("6. Agendar cita");
		System.out.println("7. Cancelar cita");
		System.out.println("8. Mostrar historial de mascota");
		System.out.println("9. Listar todas las mascotas");
		System.out.println("10. Agregar alergia a mascota");
		System.out.println("11. Eliminar alergia a mascota");
		System.out.println("0. Salir");
	}

	private void registrarDueno() {
		String nom = leerCadena("Nombre:    ");
		String tel = leerCadena("Teléfono:  ");
		String dir = leerCadena("Dirección: ");

		clinica.registrarDueno(new Dueno(nom, tel, dir));
	}

	private void registrarMascota() {
		String nom = leerCadena("Nombre mascota: ");
		String esp = leerCadena("Especie:        ");
		String raza = leerCadena("Raza:           ");
		int edad = leerEntero("Edad:           ");
		String dueno = leerCadena("Nombre del dueño: ");

		clinica.registrarMascota(new Mascota(nom, esp, raza, edad, dueno), dueno);
	}

	private void modificarMascota() {
		String nom = leerCadena("Nombre de la mascota: ");
		String raza = leerCadena("Nueva raza (enter = no cambiar): ");
		int edad = leerEntero("Nueva edad (0 = no cambiar): ");
		String dueno = leerCadena("Nuevo dueño (enter = no cambiar): ");

		clinica.modificarMascota(nom,
				raza.isEmpty() ? null : raza,
				edad,
				dueno.isEmpty() ? null : dueno);
	}

	private void eliminarMascota() {
		String nom = leerCadena("Nombre de la mascota a eliminar: ");
		clinica.eliminarMascota(nom);
	}

	private void consultarDueno() {
		String nom = leerCadena("Nombre del dueño: ");
		Dueno d = clinica.buscarDueno(nom);
		if (d == null) {
			System.out.println("No existe ese dueño.");
			return;
		}
		System.out.println("\n==== " + d + " ====");
		System.out.println("Mascotas:");
		for (Mascota m : d.getMascotas())
			System.out.println("  - " + m);
	}

	private void agendarCita() {
		String nom = leerCadena("Nombre mascota: ");
		String motivo = leerCadena("Motivo: ");
		int anio = leerEntero("Año:  ");
		int mes  = leerEntero("Mes:  ");
		int dia  = leerEntero("Día:  ");

		clinica.agendarCita(nom, motivo, LocalDate.of(anio, mes, dia));
	}

	private void cancelarCita() {
		String nom = leerCadena("Nombre mascota: ");
		int anio = leerEntero("Año:  ");
		int mes  = leerEntero("Mes:  ");
		int dia  = leerEntero("Día:  ");

		clinica.cancelarCita(nom, LocalDate.of(anio, mes, dia));
	}

	private void mostrarHistorial() {
		String nom = leerCadena("Nombre mascota: ");
		clinica.mostrarHistorial(nom);
	}

	private void listarMascotas() {
		System.out.println("==== Mascotas en el sistema ====");
		for (Mascota m : clinica.listarMascotas())
			System.out.println("\n\t- " + m);
	}

	private void agregarAlergia() {
		String nom = leerCadena("Nombre de la mascota: ");
		Mascota m = clinica.buscarMascota(nom);
		if (m != null) {
			String alergia = leerCadena("Alergia a agregar: ");
			m.agregarAlergia(alergia);
		}
		else
			System.out.println("Mascota no encontrada");
	}
	
	private void eliminarAlergia() {
		String nom = leerCadena("Nombre de la mascota: ");
		Mascota m = clinica.buscarMascota(nom);
		if (m != null) {
			String alergia = leerCadena("Alergia a eliminar: ");
			m.eliminarAlergia(alergia);
		}
		else
			System.out.println("Mascota no encontrada");
	}

	private String leerCadena(String mensaje) {
		System.out.print(mensaje);
		return sc.nextLine().trim();
	}

	private int leerEntero(String mensaje) {
		System.out.print(mensaje);
		return Integer.parseInt(sc.nextLine().trim());	}
}
