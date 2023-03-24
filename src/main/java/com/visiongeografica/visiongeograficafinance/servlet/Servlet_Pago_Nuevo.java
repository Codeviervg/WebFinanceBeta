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
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Henrry
 */
@MultipartConfig
public class Servlet_Pago_Nuevo extends HttpServlet {

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
            out.println("<title>Servlet Servlet_Pago_Nuevo</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Servlet_Pago_Nuevo at " + request.getContextPath() + "</h1>");
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
        Pago pago = new Pago();
        String select_tipo_gasto = request.getParameter("select_tipo_gasto");
        pago.setFk_tipo_gasto(select_tipo_gasto);
        
        String select_procedencia = request.getParameter("select_procedencia");
        pago.setFk_procedencia(select_procedencia);
        
        String select_proveedores = request.getParameter("select_proveedores");
        pago.setFk_proveedor(select_proveedores);
        
        String select_proyecto = request.getParameter("select_proyecto");
        pago.setFk_proyecto(select_proyecto);
        
        String select_tipo_pago = request.getParameter("select_tipo_pago");
        pago.setTipo_pago(select_tipo_pago);
        
        String fecha_pago = request.getParameter("fecha_pago");
        pago.setFecha__pago(fecha_pago);

        String[] usuarios = request.getParameterValues("checks1[]");
        String[] equipos = request.getParameterValues("checks2[]");
        String sn_iva = request.getParameter("select_ivasn");
        pago.setIva(sn_iva);
        String detalle_gastos = request.getParameter("detalle_gastos");
        pago.setComentario(detalle_gastos);
        String valor_total = request.getParameter("valor_total");
        pago.setValor(valor_total);
        double IvaValor = 0;
        if ("Si".equals(sn_iva)) {
            double TotalValor = Double.parseDouble(valor_total);
            double iva = 1.12;
            double ValorSinIVA=TotalValor/iva;
            BigDecimal bd = new BigDecimal(ValorSinIVA).setScale(2, RoundingMode.HALF_UP);
            ValorSinIVA=bd.doubleValue();
            IvaValor = TotalValor -ValorSinIVA;
            bd = new BigDecimal(IvaValor).setScale(2, RoundingMode.HALF_UP);
            IvaValor=bd.doubleValue();                                   
        }
        String valor_iva = Double.toString(IvaValor);
        pago.setValor_iva(valor_iva);
        String id_user = (String) request.getSession().getAttribute("id_user");
        String str = request.getParameter("str");
        String checkedCheckboxesValues = request.getParameter("checkedCheckboxesValues");
        PrintWriter out = response.getWriter();
        List<String> listUsuarios = null;

        //List<String> listEquipos = Arrays.asList(equipos);
        //guardar foto
        Coneccion c = new Coneccion();
        int idPago = c.MaxiPago();
        //int idPago =0;
        idPago += 1;
        Part filePart = request.getPart("file");
        // Retrieves <input type="file" name="file">
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
        String dir_respaldo;
        if ("".equals(fileName)) {
            dir_respaldo = "sin respaldo";
        } else {
            String extension = fileName.substring(fileName.lastIndexOf("."));
            InputStream fileContent = filePart.getInputStream();
            //Image image = ImageIO.read(fileContent);

            //String aaa=Arrays.toString(encoded);
            byte[] bs = new byte[1024];
            // La longitud de los datos leídos  
            int len;
            // flujo de archivo de salida  
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            String fecha = dtf.format(LocalDateTime.now());
            String nombreArchivo = "P" + idPago + "-U" + id_user + extension;
            //File dir = new File(getServletContext().getResource(ruta).getPath());        
            File directorio = new File("C:\\img_finance\\" + fecha);
            //File directorio = new File("/ruta/directorio_nuevo");
            if (!directorio.exists()) {
                if (directorio.mkdirs()) {
                    System.out.println("Directorio creado");
                } else {
                    System.out.println("Error al crear directorio");
                }
            }
            OutputStream os = new FileOutputStream(directorio.getPath() + "/" + nombreArchivo);
            // empieza a leer  
            while ((len = fileContent.read(bs)) != -1) {
                os.write(bs, 0, len);
            }
            dir_respaldo = directorio.getPath() + "\\" + nombreArchivo;

        }

        //String dir_respaldo = "/img_finance/"+fecha+"/" + nombreArchivo;
        pago.setImg_respaldo(dir_respaldo);
        //registrar en la base de datos

        c = new Coneccion();
        boolean registro;
        registro = c.Insert_Gastos(pago, id_user, usuarios, equipos);
        if (registro) {
            String[][] listpagosHoy = c.List_Mis_Pagos_Hoy(id_user);
            String[][] listusuarios = c.List_User();
            String[][] listequipos = c.List_Equipos();
            List<Pago> listaPagosHoy;
            List<User> listaUsarios;
            List<Equipo> listaEquipos;
            listaPagosHoy = Pago.listarPagos(listpagosHoy);
            listaUsarios = User.listarUsers(listusuarios);
            listaEquipos = Equipo.listarPagos(listequipos);

            String[][] tipos = c.List_TiposGastos();
            List<Tipo_Gasto> listaGastos_tipos ;
            listaGastos_tipos = Tipo_Gasto.listarTiposGastos(tipos);

            String[][] procedencias = c.List_Procedencias();
            List<Procedencia> listaProcedencias ;
            listaProcedencias = Procedencia.listarProcedencias(procedencias);

            String[][] proveedores = c.List_Proveedores();
            List<Proveedor> listaProveedores;
            listaProveedores = Proveedor.listarProveedores(proveedores);

            String[][] proyectos = c.List_Proyectos();
            List<Proyecto> listaProyectos;
            listaProyectos = Proyecto.listarProyectos(proyectos);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/User_pagos.jsp");
            int cantPagos = listaPagosHoy.size();

            request.setAttribute("cantPagos", cantPagos);
            request.setAttribute("lista", listaPagosHoy);
            request.setAttribute("listaUser", listaUsarios);
            request.setAttribute("listaEquipo", listaEquipos);
            request.setAttribute("message", "1");
            request.setAttribute("userID", id_user);

            request.setAttribute("listaGastos_tipos", listaGastos_tipos);
            request.setAttribute("listaProcedencias", listaProcedencias);
            request.setAttribute("listaProveedores", listaProveedores);
            request.setAttribute("listaProyectos", listaProyectos);

            dispatcher.forward(request, response);
        } else {
            String[][] listpagosHoy = c.List_Mis_Pagos_Hoy(id_user);
            String[][] listusuarios = c.List_User();
            String[][] listequipos = c.List_Equipos();
            List<Pago> listaPagosHoy;
            List<User> listaUsarios;
            List<Equipo> listaEquipos;
            listaPagosHoy = Pago.listarPagos(listpagosHoy);
            listaUsarios = User.listarUsers(listusuarios);
            listaEquipos = Equipo.listarPagos(listequipos);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/User_pagos.jsp");
            int cantPagos = listaPagosHoy.size();
            request.setAttribute("cantPagos", cantPagos);
            request.setAttribute("lista", listaPagosHoy);
            request.setAttribute("listaUser", listaUsarios);
            request.setAttribute("listaEquipo", listaEquipos);
            request.setAttribute("message", "2");
            dispatcher.forward(request, response);

        }
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
