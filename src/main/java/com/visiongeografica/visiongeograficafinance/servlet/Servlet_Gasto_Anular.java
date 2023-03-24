/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.visiongeografica.visiongeograficafinance.servlet;

import com.visiongeografica.visiongeograficafinance.model.Coneccion;
import com.visiongeografica.visiongeograficafinance.model.Pago;
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
public class Servlet_Gasto_Anular extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        /* TODO output your page here. You may use following sample code. */
        String idGasto = request.getParameter("idGasto");
        Coneccion cone = new Coneccion();
        Boolean exito;
        exito = cone.Anular_Gasto(idGasto);
        response.setContentType("text/html;charset=UTF-8");
        if (exito) {
            out.println("<script type=\"text/javascript\">");
            out.println("Swal.fire({\n"
                    + "  position: 'top-end',\n"
                    + "  icon: 'success',\n"
                    + "  title: 'Se elimino al gasto : " + idGasto + "',\n"
                    + "  showConfirmButton: false,\n"
                    + "  timer: 1500\n"
                    + "})");
            out.println("</script>");
        } else {
            out.println("<script type=\"text/javascript\">");
            out.println("Swal.fire({\n"
                    + "  icon: 'error',\n"
                    + "  title: 'Oops...',\n"
                    + "  text: 'Hubo problemas, no se pudo eliminar el gasto " + idGasto + "! Reporte el problema.'\n"
                    + "})");
            out.println("</script>");
        }
        String id_user = (String) request.getSession().getAttribute("id_user");
        String[][] pagos = cone.List_Mis_Pagos(id_user);
        List<Pago> listaPagos;
        listaPagos = Pago.listarPagos(pagos);
        
        out.println("<table  class=\"u-table-entity u-table-entity-1\" width=\"100%\">");
        out.println("<thead class=\"u-gradient u-table-header u-table-header-1\">");
        out.println("<tr>");
        out.println("<th ><strong>ID</strong></th>");
        out.println("<th ><strong>ESTADO</strong></th>");
        out.println("<th ><strong>PROVEEDOR</strong></th>");
        out.println("<th ><strong>USUARIO</strong></th>");
        out.println("<th ><strong>PROCEDENCIA</strong></th>");
        out.println("<th ><strong>COMENTARIO</strong></th>");
        out.println("<th ><strong>TIPO</strong></th>");
        out.println("<th ><strong>REGISTRO</strong></th>");
        out.println("<th ><strong>FECHA DE GASTO</strong></th>");
        out.println("<th ><strong>IVA</strong></th>");
        out.println("<th ><strong>VALOR IVA</strong></th>");
        out.println("<th ><strong>VALOR TOTAL</strong></th>");
        out.println("<td colspan=1><strong>ACCIONES</strong></td>");
        out.println("</tr>");
        out.println("</thead>");
        out.println("<tbody class=\"u-table-alt-palette-3-light-3 u-table-body u-table-body-1\">");
        for (Pago pag : listaPagos) {
            out.println("<tr>");
            out.println("<td  style=\"text-align: justify;\" >" + pag.getId_gasto() + "</td>");
            out.println("<td style=\"text-align: justify; \">" + pag.getEstado()+ "</td>");
            out.println("<td style=\"text-align: justify; \">" + pag.getProveedor() + "</td>");
            out.println("<td style=\"text-align: justify; \">" + pag.getUsuario_registro()  + "</td>");
            out.println("<td style=\"text-align: justify;\">" + pag.getProcedencia() + "</td>");
            out.println("<td style=\"text-align: justify;\">" + pag.getComentario() + "</td>");
            out.println("<td style=\"text-align: justify;\">" + pag.getTipo_pago() + "</td>");
            out.println("<td style=\"text-align: justify;\">" + pag.getFecha__registro() + "</td>");
            out.println("<td style=\"text-align: justify;\">" + pag.getFecha__pago() + "</td>");
            out.println("<td style=\"text-align: justify;\">" + pag.getIva() + "</td>");
            out.println("<td style=\"text-align: justify;\">" + pag.getValor_iva() + "</td>");
            out.println("<td style=\"text-align: justify;\">" + pag.getValor() + "</td>");
            
            out.println("<td><input   type=\"button\" id=\"button_cambiar\" name=\"button_cambiar\" class=\"u-btn u-btn-submit u-button-style\" onclick = \"AnularGasto(" + pag.getId_gasto() + ")\"  value=\"Eliminar proveedor\"/></td>");
            out.println("</tr>");
            //imprimimos el objeto pivote                
        }
        out.println("</tbody>");
        out.println("</table> ");
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
