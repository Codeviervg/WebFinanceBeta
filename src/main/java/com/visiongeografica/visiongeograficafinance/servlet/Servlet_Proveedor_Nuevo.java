/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.visiongeografica.visiongeograficafinance.servlet;

import com.visiongeografica.visiongeograficafinance.model.Coneccion;
import com.visiongeografica.visiongeograficafinance.model.Proveedor;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Henrry
 */
public class Servlet_Proveedor_Nuevo extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlet_Proveedor_Nuevo</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Servlet_Proveedor_Nuevo at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        response.setContentType("text/html;charset=UTF-8");
        String nombre_proveedor = request.getParameter("nombre_proveedor");
        String ruc = request.getParameter("n_ruc");
        String descripcion_proveedor = request.getParameter("descripcion_proveedor");
        String id_user = (String) request.getSession().getAttribute("id_user");
        Proveedor p = new Proveedor("0", nombre_proveedor, descripcion_proveedor, ruc);
        Coneccion c = new Coneccion();
        boolean resp = c.Insert_Proveedor(p, id_user);
        PrintWriter out = response.getWriter();
        if (resp) {
            out.println("<script type=\"text/javascript\">");
            out.println("Swal.fire({\n"
                    + "  position: 'top-end',\n"
                    + "  icon: 'success',\n"
                    + "  title: 'Se registro correctamente',\n"
                    + "  showConfirmButton: false,\n"
                    + "  timer: 1500\n"
                    + "})");
            out.println("</script>");
        } else {
            out.println("<script type=\"text/javascript\">");
            out.println("Swal.fire({\n"
                    + "  icon: 'error',\n"
                    + "  title: 'Oops...',\n"
                    + "  text: 'Hubo problemas, no se pudo registrar el proveedor!'\n"                    
                    + "})");
            out.println("</script>");
        }
        String[][] proveedores = c.List_Proveedores();
        List<Proveedor> listaProveedores;
        listaProveedores = Proveedor.listarProveedores(proveedores);
        out.println("<table id=\"datos\" class=\"u-table-entity u-table-entity-1\" width=\"100%\">");
        out.println("<thead class=\"u-gradient u-table-header u-table-header-1\">");
        out.println("<tr>");
        out.println("<th ><strong>ID</strong></th>");
        out.println("<th ><strong>RUC</strong></th>");
        out.println("<th ><strong>NOMBRE</strong></th>");
        out.println("<th ><strong>DESCRIPCION</strong></th>");
        out.println("<td colspan=1><strong>ACCIONES</strong></td>");
        out.println("</tr>");
        out.println("</thead>");
        out.println("<tbody class=\"u-table-alt-palette-3-light-3 u-table-body u-table-body-1\">");
        for (Proveedor pro : listaProveedores) {
            out.println("<tr>");
            out.println("<td  style=\"text-align: justify;\" >" + pro.getId_proveedor() + "</td>");
            out.println("<td style=\"text-align: justify; \">" + pro.getRuc() + "</td>");
            out.println("<td style=\"text-align: justify; \">" + pro.getNombre() + "</td>");
            out.println("<td style=\"text-align: justify;\">" + pro.getDescripcion() + "</td>");
            out.println("<td><input   type=\"button\" id=\"button_cambiar\" name=\"button_cambiar\" class=\"u-btn u-btn-submit u-button-style\" onclick = \"BorrarCliente(" +pro.getId_proveedor() + ")\"  value=\"Eliminar proveedor\"/></td>");
            out.println("</tr>");
            //imprimimos el objeto pivote                
        }
        out.println("</tbody>");
        out.println("</table> ");
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
