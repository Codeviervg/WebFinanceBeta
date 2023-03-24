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
public class Proyecto {

    public String id_proyecto;
    public String nombre_proyecto;
    public String fk_user;
    public String name_user;
    public String descripcion;
    public String fecha_creacion;
    public String fecha_inicio;
    public String fecha_terminado;
    public String estado;

    public String getNombre_proyecto() {
        return nombre_proyecto;
    }

    public void setNombre_proyecto(String nombre_proyecto) {
        this.nombre_proyecto = nombre_proyecto;
    }

    public String getId_proyecto() {
        return id_proyecto;
    }

    public void setId_proyecto(String id_proyecto) {
        this.id_proyecto = id_proyecto;
    }

    public String getFk_user() {
        return fk_user;
    }

    public void setFk_user(String fk_user) {
        this.fk_user = fk_user;
    }

    public String getName_user() {
        return name_user;
    }

    public void setName_user(String name_user) {
        this.name_user = name_user;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(String fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_terminado() {
        return fecha_terminado;
    }

    public void setFecha_terminado(String fecha_terminado) {
        this.fecha_terminado = fecha_terminado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    static public List<Proyecto> listarProyectos(String[][] lista) {
        List<Proyecto> Res = new ArrayList<>();
        for (String[] Objeto : lista) {
            try {
                Proyecto p = new Proyecto();
                p.setId_proyecto(Objeto[0]);
                p.setFk_user(Objeto[1]);
                p.setName_user(Objeto[2]);
                p.setNombre_proyecto(Objeto[3]);
                p.setFecha_creacion(Objeto[4]);
                p.setFecha_inicio(Objeto[5]);
                p.setFecha_terminado(Objeto[6]);
                p.setEstado(Objeto[7]);
                p.setDescripcion(Objeto[8]);
                Res.add(p);
            } catch (Exception ex) {
                System.out.println(ex.toString());
            }

        }
        return Res;
    }
}
