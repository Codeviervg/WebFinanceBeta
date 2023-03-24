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
public class User {
    public String id_user;
    public String username;
    public String nombre_completo;
    public String fk_tipo_user;
    public String tipo_user;

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }



    
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNombre_completo() {
        return nombre_completo;
    }

    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
    }

    public String getFk_tipo_user() {
        return fk_tipo_user;
    }

    public void setFk_tipo_user(String fk_tipo_user) {
        this.fk_tipo_user = fk_tipo_user;
    }

    public String getTipo_user() {
        return tipo_user;
    }

    public void setTipo_user(String tipo_user) {
        this.tipo_user = tipo_user;
    }
    
    static public List<User> listarUsers(String[][] lista) {
        List<User> Res = new ArrayList<>();
        for (String[] Objeto : lista) {
            try {
                User u = new User();
                u.setId_user(Objeto[0]);
                u.setUsername(Objeto[1]);
                u.setNombre_completo(Objeto[2]);
                u.setFk_tipo_user(Objeto[3]);
                u.setTipo_user(Objeto[4]);
                Res.add(u);

            } catch (Exception ex) {
                System.out.println(ex.toString());
            }
        }
        return Res;
    }
    
}
