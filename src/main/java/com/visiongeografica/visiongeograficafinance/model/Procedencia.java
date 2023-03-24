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
public class Procedencia {
    public String id_procedencia;
    public String nombre;
    public String descripcion;

    public Procedencia(String id_procedencia, String nombre, String descripcion) {
        this.id_procedencia = id_procedencia;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getId_procedencia() {
        return id_procedencia;
    }

    public void setId_procedencia(String id_procedencia) {
        this.id_procedencia = id_procedencia;
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
    
    static public List<Procedencia> listarProcedencias(String[][] lista) {
        List<Procedencia> Res = new ArrayList<>();
        for (String[] Objeto : lista) {
            try {
                String id_procedencia = Objeto[0];
                String nombre = Objeto[1];
                String descripcion = Objeto[2];
                Procedencia p = new Procedencia(id_procedencia, nombre, descripcion);
                Res.add(p);
            } catch (Exception ex) {
                System.out.println(ex.toString());
            }

        }
        return Res;
    }
    
}
