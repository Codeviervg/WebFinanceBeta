/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.visiongeografica.visiongeograficafinance.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Henrry
 */
public class Equipo {
    public String id_equipo;
    public String nombre;
    public String descripcion;

    public String getId_equipo() {
        return id_equipo;
    }

    public void setId_equipo(String id_equipo) {
        this.id_equipo = id_equipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    static public List<Equipo> listarPagos(String[][] lista) {
        List<Equipo> Res = new ArrayList<>();
        for (String[] Objeto : lista) {
            try {
                Equipo e = new Equipo();
                e.setId_equipo(Objeto[0]);
                e.setNombre(Objeto[1]);
                e.setDescripcion(Objeto[2]);
                Res.add(e);
            } catch (Exception ex) {
                System.out.println(ex.toString());
            }

        }
        return Res;
    }
    
}
