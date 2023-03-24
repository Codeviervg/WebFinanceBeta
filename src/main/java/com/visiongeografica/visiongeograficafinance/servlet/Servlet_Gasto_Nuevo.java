/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.visiongeografica.visiongeograficafinance.servlet;

import com.visiongeografica.visiongeograficafinance.model.Coneccion;
import com.visiongeografica.visiongeograficafinance.model.Equipo;
import com.visiongeografica.visiongeograficafinance.model.Pago;
import com.visiongeografica.visiongeograficafinance.model.Procedencia;
import com.visiongeografica.visiongeograficafinance.model.Proveedor;
import com.visiongeografica.visiongeograficafinance.model.Proyecto;
import com.visiongeografica.visiongeograficafinance.model.Tipo_Gasto;
import com.visiongeografica.visiongeograficafinance.model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Henrry
 */
public class Servlet_Gasto_Nuevo extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Coneccion cone;
        try ( PrintWriter out = response.getWriter()) {
            cone = new Coneccion();
            String id_user = (String) request.getSession().getAttribute("id_user");
            String[][] pagosHoy = cone.List_Mis_Pagos_Hoy(id_user);
            String[][] usuarios = cone.List_User();
            String[][] equipos = cone.List_Equipos();
            List<Pago> listaPagosHoy;
            List<User> listaUsarios;
            List<Equipo> listaEquipos;
            listaPagosHoy = Pago.listarPagos(pagosHoy);
            listaUsarios = User.listarUsers(usuarios);
            listaEquipos = Equipo.listarPagos(equipos);

            String[][] tipos = cone.List_TiposGastos();
            List<Tipo_Gasto> listaGastos_tipos;
            listaGastos_tipos = Tipo_Gasto.listarTiposGastos(tipos);

            String[][] procedencias = cone.List_Procedencias();
            List<Procedencia> listaProcedencias ;
            listaProcedencias = Procedencia.listarProcedencias(procedencias);

            String[][] proveedores = cone.List_Proveedores();
            List<Proveedor> listaProveedores;
            listaProveedores = Proveedor.listarProveedores(proveedores);

            String[][] proyectos = cone.List_Proyectos();
            List<Proyecto> listaProyectos;
            listaProyectos = Proyecto.listarProyectos(proyectos);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/User_pagos.jsp");
            int cantPagos = listaPagosHoy.size();
            request.setAttribute("cantPagos", cantPagos);
            request.setAttribute("lista", listaPagosHoy);
            request.setAttribute("listaUser", listaUsarios);
            request.setAttribute("listaEquipo", listaEquipos);
            request.setAttribute("userID", id_user);

            request.setAttribute("listaGastos_tipos", listaGastos_tipos);
            request.setAttribute("listaProcedencias", listaProcedencias);
            request.setAttribute("listaProveedores", listaProveedores);
            request.setAttribute("listaProyectos", listaProyectos);
            dispatcher.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
