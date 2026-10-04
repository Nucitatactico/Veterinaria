package modelo;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Mascota {

	private String nombre;
	private String especie;
	private String raza;
	private int edad;
	private String nombreDueno;
	private Historial historial;
	private Set<String> alergias;

	public Mascota(String nombre, String especie, String raza,int edad, String nombreDueno) {
		this.nombre = nombre;
		this.especie = especie;
		this.raza = raza;
		this.edad = edad;
		this.nombreDueno = nombreDueno;
		this.historial = new Historial(nombre);
		this.alergias = new HashSet<>();
	}

	public void agregarAlergia(String alergia) {
		alergias.add(alergia);
	}
	public void eliminarAlergia(String alergia) {
		alergias.remove(alergia);
	}

	//getters y setters
	public String getNombre() { 
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEspecie() { 
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getRaza() { 
		return raza;
	}
	public void setRaza(String raza) {
		this.raza = raza;
	}

	public int getEdad() { 
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getNomDueno() { 
		return nombreDueno;
	}
	public void setNomDueno(String nombreDueno) {
		this.nombreDueno = nombreDueno;
	}

	public Historial getHistorial() { 
		return historial;
	}

	public Set<String> getAlergias() { 
		return alergias;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) 
			return true;
		if (!(o instanceof Mascota)) 
			return false;
		Mascota m = (Mascota) o;
		return nombre.equalsIgnoreCase(m.nombre);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(nombre.toLowerCase());
	}

	@Override
	public String toString() {
		return String.format(
				"Mascota: %s\nEspecie: %s\nRaza: %s\nEdad: %d\nDueño: %s\nAlergias: %s",
				nombre, especie, raza, edad, nombreDueno,
				alergias.isEmpty() ? "ninguna" : alergias);
	}
}
