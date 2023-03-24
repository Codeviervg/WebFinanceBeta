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
public class Tipo_Gasto {

    public String id_tipo_gasto;
    public String nombre;
    public String descripcion;

    public Tipo_Gasto() {
    }

    public Tipo_Gasto(String id_tipo_gasto, String nombre, String descripcion) {
        this.id_tipo_gasto = id_tipo_gasto;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getId_tipo_gasto() {
        return id_tipo_gasto;
    }

    public void setId_tipo_gasto(String id_tipo_gasto) {
        this.id_tipo_gasto = id_tipo_gasto;
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
        
    static public List<Tipo_Gasto> listarTiposGastos(String[][] lista) {
        List<Tipo_Gasto> Res = new ArrayList<>();
        for (String[] Objeto : lista) {
            try {                              
                String id_tipo_gasto= Objeto[0];
                String nombre= Objeto[1];
                String descripcion= Objeto[2];                
                Tipo_Gasto c = new Tipo_Gasto(id_tipo_gasto, nombre, descripcion);
                Res.add(c);
            } catch (Exception ex) {
                System.out.println(ex.toString());
            }

        }
        return Res;
    }
}
