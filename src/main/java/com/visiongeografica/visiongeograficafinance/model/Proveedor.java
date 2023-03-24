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
public class Proveedor {
    public String id_proveedor;
    public String nombre;
    public String descripcion;
    public String ruc;

    public Proveedor(String id_proveedor, String nombre, String descripcion, String ruc) {
        this.id_proveedor = id_proveedor;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.ruc = ruc;
    }

    public String getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(String id_proveedor) {
        this.id_proveedor = id_proveedor;
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

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }
    
    static public List<Proveedor> listarProveedores(String[][] lista) {
        List<Proveedor> Res = new ArrayList<>();
        for (String[] Objeto : lista) {
            try {
                String id_proveedor = Objeto[0];
                String nombre = Objeto[1];
                String descripcion = Objeto[2];
                String ruc = Objeto[3];
                
                Proveedor p = new Proveedor(id_proveedor, nombre, descripcion, ruc);
                Res.add(p);
            } catch (Exception ex) {
                System.out.println(ex.toString());
            }

        }
        return Res;
    }
    
}
