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
public class Pago {

    public String id_gasto;
    public String fk_proveedor;
    public String proveedor;
    public String usuario_registro;
    public String fk_tipo_gasto;
    public String tipo_gasto;
    public String fk_procedencia;
    public String fk_proyecto;
    public String procedencia;
    public String comentario;
    public String valor;
    public String tipo_pago;
    public String fecha__registro;
    public String fecha__pago;
    public String valor_iva;
    public String iva;
    public String estado;
    public String img_respaldo;

    public String getImg_respaldo() {
        return img_respaldo;
    }

    public void setImg_respaldo(String img_respaldo) {
        this.img_respaldo = img_respaldo;
    }

    public String getFk_proyecto() {
        return fk_proyecto;
    }

    public void setFk_proyecto(String fk_proyecto) {
        this.fk_proyecto = fk_proyecto;
    }

    
    
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFk_proveedor() {
        return fk_proveedor;
    }

    public void setFk_proveedor(String fk_proveedor) {
        this.fk_proveedor = fk_proveedor;
    }

    public String getFk_tipo_gasto() {
        return fk_tipo_gasto;
    }

    public void setFk_tipo_gasto(String fk_tipo_gasto) {
        this.fk_tipo_gasto = fk_tipo_gasto;
    }

    public String getFk_procedencia() {
        return fk_procedencia;
    }

    public void setFk_procedencia(String fk_procedencia) {
        this.fk_procedencia = fk_procedencia;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getUsuario_registro() {
        return usuario_registro;
    }

    public void setUsuario_registro(String usuario_registro) {
        this.usuario_registro = usuario_registro;
    }

    public String getTipo_gasto() {
        return tipo_gasto;
    }

    public void setTipo_gasto(String tipo_gasto) {
        this.tipo_gasto = tipo_gasto;
    }

    public String getProcedencia() {
        return procedencia;
    }

    public void setProcedencia(String procedencia) {
        this.procedencia = procedencia;
    }

    public Pago() {
    }

    public String getId_gasto() {
        return id_gasto;
    }

    public void setId_gasto(String id_gasto) {
        this.id_gasto = id_gasto;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getTipo_pago() {
        return tipo_pago;
    }

    public void setTipo_pago(String tipo_pago) {
        this.tipo_pago = tipo_pago;
    }

    public String getFecha__registro() {
        return fecha__registro;
    }

    public void setFecha__registro(String fecha__registro) {
        this.fecha__registro = fecha__registro;
    }

    public String getFecha__pago() {
        return fecha__pago;
    }

    public void setFecha__pago(String fecha__pago) {
        this.fecha__pago = fecha__pago;
    }

    public String getValor_iva() {
        return valor_iva;
    }

    public void setValor_iva(String valor_iva) {
        this.valor_iva = valor_iva;
    }

    public String getIva() {
        return iva;
    }

    public void setIva(String iva) {
        this.iva = iva;
    }

    static public List<Pago> listarPagos(String[][] lista) {
        List<Pago> Res = new ArrayList<>();
        for (String[] Objeto : lista) {
            try {
                Pago p = new Pago();
                p.setId_gasto(Objeto[0]);
                p.setTipo_gasto(Objeto[1]);
                p.setProcedencia(Objeto[2]);
                p.setProveedor(Objeto[3]);
                p.setUsuario_registro(Objeto[4]);
                p.setComentario(Objeto[5]);
                p.setTipo_pago(Objeto[6]);
                p.setFecha__registro(Objeto[7]);
                p.setFecha__pago(Objeto[8]);
                p.setIva(Objeto[9]);
                p.setValor_iva(Objeto[10]);
                p.setValor(Objeto[11]);
                p.setImg_respaldo(Objeto[12]);
                p.setEstado(Objeto[13]);
                Res.add(p);

            } catch (Exception ex) {
                System.out.println(ex.toString());
            }

        }
        return Res;
    }
    
    
}
