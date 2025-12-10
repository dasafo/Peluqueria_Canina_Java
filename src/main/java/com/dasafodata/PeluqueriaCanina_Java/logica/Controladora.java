package com.dasafodata.PeluqueriaCanina_Java.logica;

import java.util.List;

import com.dasafodata.PeluqueriaCanina_Java.persistencia.ControladoraPersistencia;

public class Controladora {

	ControladoraPersistencia controlPersis = new ControladoraPersistencia();

	public void guardar(String nombreMasco, String raza, String color, String observaciones, String alergico,
			String atemEsp, String nombreDuenio, String movil) {

		//Creamos el dueño y asignamos sus valores
		Duenio duenio = new Duenio();
		duenio.setNombre(nombreDuenio);
		duenio.setMovil(movil);

		//Creamos la mascota y asignamos sus valores
		Mascota masco = new Mascota();
		masco.setNombre(nombreMasco);
		masco.setRaza(raza);
		masco.setColor(color);
		masco.setAlergico(alergico);
		masco.setAtencion_especial(atemEsp);
		masco.setObservaciones(observaciones);
		masco.setUnDuenio(duenio);

		//llamamos a la persistencia desde esta logica y que lo guarde en la bbdd
		controlPersis.guardar(duenio, masco);

	}

	public List<Mascota> traerMascotas() {
		// TODO Auto-generated method stub
		return controlPersis.traerMascotas();
	}

	public void borrarMascota(int num_cliente) {
		controlPersis.borrarMascota(num_cliente);
		
	}

	public Mascota traerMascota(int num_cliente) {
		return controlPersis.traerMascota(num_cliente);
	}

	public void modificarMascota(Mascota masco, String nombreMasco, String raza, String color, String observaciones,
			String alergico, String atemEsp, String nombreDuenio, String movil) {

		//a masco que son los datos viejos antes de editarios le vamos a asociar los nuevos cambios
		masco.setNombre(nombreMasco);
		masco.setRaza(raza);
		masco.setColor(color);
		masco.setObservaciones(observaciones);
		masco.setAlergico(alergico);
		masco.setAtencion_especial(atemEsp);
		
		//PAra los campos del dueño hacemos:
		//modifico la mascota
		controlPersis.modificarMascota(masco);
		//creo un objeto de tipo dueño que busque en el metodo el id del dueño
		Duenio duegno = this.buscarDuenio(masco.getUnDuenio().getId_duenio());
		duegno.setMovil(movil);
		duegno.setNombre(nombreDuenio);
		
		//llamamos a modificarDueno()
		this.modificarDuenio();
		
		
		
		
	}

	private void modificarDuenio() {
		controlPersis.modificarDuenio(null);
		
	}

	private Duenio buscarDuenio(int id_duenio) {
		// TODO Auto-generated method stub
		return controlPersis.traerDuenio(id_duenio);
	}

}
