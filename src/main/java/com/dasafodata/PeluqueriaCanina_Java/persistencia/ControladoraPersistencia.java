package com.dasafodata.PeluqueriaCanina_Java.persistencia;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.dasafodata.PeluqueriaCanina_Java.logica.Duenio;
import com.dasafodata.PeluqueriaCanina_Java.logica.Mascota;

public class ControladoraPersistencia {

    DuenioJpaController duenioJpa = new DuenioJpaController();
    MascotaJpaController mascotaJpa = new MascotaJpaController();

    public ControladoraPersistencia() {

    }

    public void guardar(Duenio duenio, Mascota mascota) {
        // Creamos en la bbdd la info que nos llega de la logica de Controladora.java
        duenioJpa.create(duenio);
        mascotaJpa.create(mascota);
    }

    public List<Mascota> traerMascotas() {
    	//que busqye todos los registros de la tabla Mascota y lo devuelva
        return mascotaJpa.findMascotaEntities();
    }

    public void borrarMascota(int id_mascota) {
        try {
            mascotaJpa.destroy(id_mascota);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modificarMascota(Mascota mascota) {
        try {
            mascotaJpa.edit(mascota);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Mascota traerMascota(int id_mascota) {
        return mascotaJpa.findMascota(id_mascota);
    }

    public Duenio traerDuenio(int id_duenio) {
        return duenioJpa.findDuenio(id_duenio);
    }

    public void modificarDuenio(Duenio duenio) {
        try {
            duenioJpa.edit(duenio);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}