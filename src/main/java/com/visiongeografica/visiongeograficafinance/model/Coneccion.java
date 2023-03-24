/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.visiongeografica.visiongeograficafinance.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Henrry
 */
public class Coneccion {

    Connection con = null;
    //127.0.0.1 
    /*
     private String url = "jdbc:mysql://50.87.144.120/hnavarre_visigeo_finance?serverTimezone=UTC";
    private String user = "hnavarre_xavier";
    private String clave = "q85o?0h69Yyg";
    MySQLvisgeo22
    */
    private String url =   "jdbc:mysql://127.0.0.1/visigeo_finance?serverTimezone=UTC";
    private String user = "root";
    private String clave = "1234567";
    
  

    public Coneccion() {
    }

    public void login() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //?serverTimezone=UTC UTC es la hora mundial estándar unificada
            con = DriverManager.getConnection("jdbc:mysql://50.87.144.120/hnavarre_visigeo_finance?serverTimezone=UTC", "hnavarre_xavier", "q85o?0h69Yyg");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Coneccion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String Login(String user_log, String clave_log) {
        Statement st = null;
        Connection conectar;
        String idUser = "-1";
        int i = 1;
        i += 1;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conectar = DriverManager.getConnection(url, user, clave);
            st = conectar.createStatement();
            ResultSet rs = st.executeQuery("select id_user from User where username='" + user_log + "' and password='" + clave_log + "'");
            while (rs.next()) {
                //respuesta = rs.getString("NOMBRE_USUARIO");
                idUser = rs.getString("id_user");
            }
            conectar.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Coneccion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idUser;
    }

    public String[][] List_TiposGastos() {
        String[][] respuesta = new String[0][0];
        Statement st = null;
        Connection conectar;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al registrar el driver de PostgreSQL: " + ex);
        }
        try {
            conectar = DriverManager.getConnection(url, user, clave);
            st = conectar.createStatement();
            ResultSet rs = st.executeQuery("select count(id_tipo_gasto) as cantidad from Tipo_gasto;");
            Integer dimension = 0;
            while (rs.next()) {
                dimension = Integer.parseInt(rs.getString("cantidad"));
            }
            respuesta = new String[dimension][7];
            rs = st.executeQuery("select id_tipo_gasto, nombre, descripcion from Tipo_gasto");
            dimension = 0;
            System.out.println("Consultando...");
            while (rs.next()) {
                respuesta[dimension][0] = rs.getString("id_tipo_gasto");
                respuesta[dimension][1] = rs.getString("nombre");
                respuesta[dimension][2] = rs.getString("descripcion");
                dimension += 1;
            }
            conectar.close();

        } catch (SQLException ex) {
            //Logger.getLogger(MethodRemote.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }

    public String[][] List_Proveedores() {
        String[][] respuesta = new String[0][0];
        Statement st = null;
        Connection conectar;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al registrar el driver de PostgreSQL: " + ex);
        }
        try {
            conectar = DriverManager.getConnection(url, user, clave);
            st = conectar.createStatement();
            ResultSet rs = st.executeQuery("select count(id_proveedor) as cantidad   from Proveedor");
            Integer dimension = 0;
            while (rs.next()) {
                dimension = Integer.parseInt(rs.getString("cantidad"));
            }
            respuesta = new String[dimension][4];
            rs = st.executeQuery("select id_proveedor, nombre, descripcion, ruc from Proveedor;");
            dimension = 0;
            System.out.println("Consultando...");
            while (rs.next()) {
                respuesta[dimension][0] = rs.getString("id_proveedor");
                respuesta[dimension][1] = rs.getString("nombre");
                respuesta[dimension][2] = rs.getString("descripcion");
                respuesta[dimension][3] = rs.getString("ruc");
                dimension += 1;
            }
            conectar.close();

        } catch (SQLException ex) {
            //Logger.getLogger(MethodRemote.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }

    public String[][] List_Equipos() {
        String[][] respuesta = new String[0][0];
        Statement st = null;
        Connection conectar;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al registrar el driver de PostgreSQL: " + ex);
        }
        try {
            conectar = DriverManager.getConnection(url, user, clave);
            st = conectar.createStatement();
            ResultSet rs = st.executeQuery("select count(id_equipo) as cantidad   from Equipo;");
            Integer dimension = 0;
            while (rs.next()) {
                dimension = Integer.parseInt(rs.getString("cantidad"));
            }
            respuesta = new String[dimension][3];
            rs = st.executeQuery("select id_equipo, nombre, descripcion from Equipo;");
            dimension = 0;
            System.out.println("Consultando...");
            while (rs.next()) {
                respuesta[dimension][0] = rs.getString("id_equipo");
                respuesta[dimension][1] = rs.getString("nombre");
                respuesta[dimension][2] = rs.getString("descripcion");
                dimension += 1;
            }
            conectar.close();

        } catch (SQLException ex) {
            //Logger.getLogger(MethodRemote.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }

    public String[][] List_Pagos() {
        String[][] respuesta = new String[0][0];
        Statement st = null;
        Connection conectar;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al registrar el driver de Mysql: " + ex);
        }
        try {
            conectar = DriverManager.getConnection(url, user, clave);
            st = conectar.createStatement();
            ResultSet rs = st.executeQuery("select count(id_gasto) as cantidad from Gasto;");
            Integer dimension = 0;
            while (rs.next()) {
                dimension = Integer.parseInt(rs.getString("cantidad"));
            }
            respuesta = new String[dimension][12];
            rs = st.executeQuery("select G.id_gasto, TG.nombre as tipo_gasto, PR.nombre as procedencia, \n"
                    + "PRV.nombre as proveedor, U.nombre_completo as usuario_registro,\n"
                    + "G.comentario, G.tipo_pago, G.fecha__registro, G.fecha__pago,G.iva, G.valor_iva ,  G.valor   \n"
                    + "from Gasto as G \n"
                    + "inner join Tipo_gasto as TG on G.fk_tipo_gasto=TG.id_tipo_gasto \n"
                    + "inner join Procedencia_gasto as PR on G.fk_procedencia=PR.id_procedencia \n"
                    + "inner join Proveedor as PRV ON G.fk_proveedor=PRV.id_proveedor \n"
                    + "inner join User as U on G.fk_user=U.id_user;");
            dimension = 0;
            System.out.println("Consultando...");
            while (rs.next()) {
                respuesta[dimension][0] = rs.getString("id_gasto");
                respuesta[dimension][1] = rs.getString("tipo_gasto");
                respuesta[dimension][2] = rs.getString("procedencia");
                respuesta[dimension][3] = rs.getString("proveedor");
                respuesta[dimension][4] = rs.getString("usuario_registro");
                respuesta[dimension][5] = rs.getString("comentario");
                respuesta[dimension][6] = rs.getString("tipo_pago");
                respuesta[dimension][7] = rs.getString("fecha__registro");
                respuesta[dimension][8] = rs.getString("fecha__pago");
                respuesta[dimension][9] = rs.getString("iva");
                respuesta[dimension][10] = rs.getString("valor_iva");
                respuesta[dimension][11] = rs.getString("valor");
                dimension += 1;
            }
            conectar.close();

        } catch (SQLException ex) {
            //Logger.getLogger(MethodRemote.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }

    public String[][] List_Mis_Pagos_Hoy(String id_user) {
        String[][] respuesta = new String[0][0];
        Statement st = null;
        Connection conectar;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al registrar el driver de Mysql: " + ex);
        }
        try {
            conectar = DriverManager.getConnection(url, user, clave);
            st = conectar.createStatement();
            ResultSet rs = st.executeQuery("select count(id_gasto) as cantidad from Gasto "
                    + "where fecha__registro=CURDATE() AND fk_user=" + id_user + ";");
            Integer dimension = 0;
            while (rs.next()) {
                dimension = Integer.parseInt(rs.getString("cantidad"));
            }
            respuesta = new String[dimension][13];
            rs = st.executeQuery("select G.id_gasto, TG.nombre as tipo_gasto, PR.nombre as procedencia, \n"
                    + "PRV.nombre as proveedor, U.nombre_completo as usuario_registro,\n"
                    + "G.comentario, G.tipo_pago, G.fecha__registro, G.fecha__pago,G.iva, G.valor_iva ,  G.valor  ,G.dir_respaldo_pago \n"
                    + "from Gasto as G \n"
                    + "inner join Tipo_gasto as TG on G.fk_tipo_gasto=TG.id_tipo_gasto \n"
                    + "inner join Procedencia_gasto as PR on G.fk_procedencia=PR.id_procedencia \n"
                    + "inner join Proveedor as PRV ON G.fk_proveedor=PRV.id_proveedor \n"
                    + "inner join User as U on G.fk_user=U.id_user "
                    + "where G.fecha__registro=CURDATE() AND G.fk_user=" + id_user + ";");
            dimension = 0;
            System.out.println("Consultando...");
            while (rs.next()) {
                respuesta[dimension][0] = rs.getString("id_gasto");
                respuesta[dimension][1] = rs.getString("tipo_gasto");
                respuesta[dimension][2] = rs.getString("procedencia");
                respuesta[dimension][3] = rs.getString("proveedor");
                respuesta[dimension][4] = rs.getString("usuario_registro");
                respuesta[dimension][5] = rs.getString("comentario");
                respuesta[dimension][6] = rs.getString("tipo_pago");
                respuesta[dimension][7] = rs.getString("fecha__registro");
                respuesta[dimension][8] = rs.getString("fecha__pago");
                respuesta[dimension][9] = rs.getString("iva");
                respuesta[dimension][10] = rs.getString("valor_iva");
                respuesta[dimension][11] = rs.getString("valor");
                respuesta[dimension][12] = rs.getString("dir_respaldo_pago");
                dimension += 1;
            }
            conectar.close();

        } catch (SQLException ex) {
            Logger.getLogger(ex.toString());
        }
        return respuesta;
    }

    public String[][] List_Mis_Pagos(String id_user) {
        String[][] respuesta = new String[0][0];
        Statement st = null;
        Connection conectar;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al registrar el driver de Mysql: " + ex);
        }
        try {
            conectar = DriverManager.getConnection(url, user, clave);
            st = conectar.createStatement();

            ResultSet rs = st.executeQuery("select fk_tipo_user from User where id_user=" + id_user + ";");
            Integer fk_tipo = 0;
            while (rs.next()) {
                fk_tipo = Integer.parseInt(rs.getString("fk_tipo_user"));
            }

            //verificar el tipo de user
            //tipo 3 es administracion
            Integer dimension = 0;
            if (fk_tipo.equals(3)) {
                //se enlista TODOS los gastos
                rs = st.executeQuery("select count(id_gasto) as cantidad from Gasto "
                        + "where  estado!=\"eliminado\";");
                
                while (rs.next()) {
                    dimension = Integer.parseInt(rs.getString("cantidad"));
                }
                rs = st.executeQuery("select G.id_gasto, TG.nombre as tipo_gasto, PR.nombre as procedencia, \n"
                        + "PRV.nombre as proveedor, U.nombre_completo as usuario_registro,\n"
                        + "G.comentario, G.tipo_pago,G.estado, G.fecha__registro, G.fecha__pago,G.iva, G.valor_iva ,  G.valor , G.dir_respaldo_pago  \n"
                        + "from Gasto as G \n"
                        + "inner join Tipo_gasto as TG on G.fk_tipo_gasto=TG.id_tipo_gasto \n"
                        + "inner join Procedencia_gasto as PR on G.fk_procedencia=PR.id_procedencia \n"
                        + "inner join Proveedor as PRV ON G.fk_proveedor=PRV.id_proveedor \n"
                        + "inner join User as U on G.fk_user=U.id_user  and G.estado!=\"eliminado\" order by G.id_gasto;");
            } else {
                
                //filtro de otros usuario
                rs = st.executeQuery("select count(id_gasto) as cantidad from Gasto "
                        + "where fk_user=" + id_user + " and estado!=\"eliminado\";");
                
                while (rs.next()) {
                    dimension = Integer.parseInt(rs.getString("cantidad"));
                }
                rs = st.executeQuery("select G.id_gasto, TG.nombre as tipo_gasto, PR.nombre as procedencia, \n"
                        + "PRV.nombre as proveedor, U.nombre_completo as usuario_registro,\n"
                        + "G.comentario, G.tipo_pago,G.estado, G.fecha__registro, G.fecha__pago,G.iva, G.valor_iva ,  G.valor , G.dir_respaldo_pago  \n"
                        + "from Gasto as G \n"
                        + "inner join Tipo_gasto as TG on G.fk_tipo_gasto=TG.id_tipo_gasto \n"
                        + "inner join Procedencia_gasto as PR on G.fk_procedencia=PR.id_procedencia \n"
                        + "inner join Proveedor as PRV ON G.fk_proveedor=PRV.id_proveedor \n"
                        + "inner join User as U on G.fk_user=U.id_user "
                        + "where  G.fk_user=" + id_user + "  and G.estado!=\"eliminado\" order by G.id_gasto;");
            }

            respuesta = new String[dimension][14];

            dimension = 0;
            System.out.println("Consultando...");
            while (rs.next()) {
                respuesta[dimension][0] = rs.getString("id_gasto");
                respuesta[dimension][1] = rs.getString("tipo_gasto");
                respuesta[dimension][2] = rs.getString("procedencia");
                respuesta[dimension][3] = rs.getString("proveedor");
                respuesta[dimension][4] = rs.getString("usuario_registro");
                respuesta[dimension][5] = rs.getString("comentario");
                respuesta[dimension][6] = rs.getString("tipo_pago");
                respuesta[dimension][7] = rs.getString("fecha__registro");
                respuesta[dimension][8] = rs.getString("fecha__pago");
                respuesta[dimension][9] = rs.getString("iva");
                respuesta[dimension][10] = rs.getString("valor_iva");
                respuesta[dimension][11] = rs.getString("valor");
                respuesta[dimension][12] = rs.getString("dir_respaldo_pago");
                respuesta[dimension][13] = rs.getString("estado");
                dimension += 1;
            }
            conectar.close();

        } catch (SQLException ex) {
            Logger.getLogger(ex.toString());
        }
        return respuesta;
    }

    public String[][] List_Proyectos() {
        String[][] respuesta = new String[0][0];
        Statement st = null;
        Connection conectar;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al registrar el driver de Mysql: " + ex);
        }
        try {
            conectar = DriverManager.getConnection(url, user, clave);
            st = conectar.createStatement();
            ResultSet rs = st.executeQuery("select count(id_proyecto) as cantidad  from Proyectos;");
            Integer dimension = 0;
            while (rs.next()) {
                dimension = Integer.parseInt(rs.getString("cantidad"));
            }
            respuesta = new String[dimension][9];
            rs = st.executeQuery("select P.id_proyecto, P.fk_user,P.descripcion ,U.nombre_completo as nombreuser, P.nombre as nombreproyecto, "
                    + "P.fecha_creacion, P.fecha_inicio, fecha_terminado, P.estado from Proyectos as P \n"
                    + "inner join User as U on P.fk_user=U.id_user;");
            dimension = 0;
            System.out.println("Consultando...");
            while (rs.next()) {
                respuesta[dimension][0] = rs.getString("id_proyecto");
                respuesta[dimension][1] = rs.getString("fk_user");
                respuesta[dimension][2] = rs.getString("nombreuser");
                respuesta[dimension][3] = rs.getString("nombreproyecto");
                respuesta[dimension][4] = rs.getString("fecha_creacion");
                respuesta[dimension][5] = rs.getString("fecha_inicio");
                respuesta[dimension][6] = rs.getString("fecha_terminado");
                respuesta[dimension][7] = rs.getString("estado");
                respuesta[dimension][8] = rs.getString("descripcion");
                dimension += 1;
            }
            conectar.close();

        } catch (SQLException ex) {
            Logger.getLogger(ex.toString());
        }
        return respuesta;
    }

    public String[][] List_User() {
        String[][] respuesta = new String[0][0];
        Statement st = null;
        Connection conectar;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al registrar el driver de PostgreSQL: " + ex);
        }
        try {
            conectar = DriverManager.getConnection(url, user, clave);
            st = conectar.createStatement();
            ResultSet rs = st.executeQuery("select count(id_user) as cantidad  from User;");
            Integer dimension = 0;
            while (rs.next()) {
                dimension = Integer.parseInt(rs.getString("cantidad"));
            }
            respuesta = new String[dimension][5];
            rs = st.executeQuery("select U.id_user, U.username, U.nombre_completo,  U.fk_tipo_user, T.nombre from User as U inner join Tipe_user as T on U.fk_tipo_user=T.id_tipo_user;");
            dimension = 0;
            System.out.println("Consultando...");
            while (rs.next()) {
                respuesta[dimension][0] = rs.getString("id_user");
                respuesta[dimension][1] = rs.getString("username");
                respuesta[dimension][2] = rs.getString("nombre_completo");
                respuesta[dimension][3] = rs.getString("fk_tipo_user");
                respuesta[dimension][4] = rs.getString("nombre");
                dimension += 1;
            }
            conectar.close();

        } catch (SQLException ex) {
            //Logger.getLogger(MethodRemote.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }

    public String[][] List_Procedencias() {
        String[][] respuesta = new String[0][0];
        Statement st = null;
        Connection conectar;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al registrar el driver de PostgreSQL: " + ex);
        }
        try {
            conectar = DriverManager.getConnection(url, user, clave);
            st = conectar.createStatement();
            ResultSet rs = st.executeQuery("select count(id_procedencia) as cantidad  from Procedencia_gasto;");
            Integer dimension = 0;
            while (rs.next()) {
                dimension = Integer.parseInt(rs.getString("cantidad"));
            }
            respuesta = new String[dimension][3];
            rs = st.executeQuery("select id_procedencia, nombre, descripcion from Procedencia_gasto;");
            dimension = 0;
            System.out.println("Consultando...");
            while (rs.next()) {
                respuesta[dimension][0] = rs.getString("id_procedencia");
                respuesta[dimension][1] = rs.getString("nombre");
                respuesta[dimension][2] = rs.getString("descripcion");
                dimension += 1;
            }
            conectar.close();

        } catch (SQLException ex) {
            //Logger.getLogger(MethodRemote.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }

    public Boolean Insert_Proveedor(Proveedor p, String fk_user) {
        Boolean resp = false;
        Statement st = null;
        Connection conectar;
        int lineas_modi = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al registrar el driver de PostgreSQL: " + ex);
        }
        try {
            conectar = DriverManager.getConnection(url, user, clave);
            st = conectar.createStatement();
            PreparedStatement consulta;
            consulta = conectar.prepareStatement("insert into Proveedor (nombre , descripcion, ruc, fecha__registro, fk_user) "
                    + "values(?,?,?,?,?);");
            long now = System.currentTimeMillis();
            Date sqlDate = new Date(now);
            consulta.setString(1, p.getNombre());
            consulta.setString(2, p.getDescripcion());
            consulta.setString(3, p.getRuc());
            consulta.setDate(4, sqlDate);
            int fkuser = Integer.valueOf(fk_user);
            consulta.setInt(5, fkuser);
            lineas_modi = consulta.executeUpdate();
            resp = true;
            System.out.println("Los datos se guardaron correctamente");
            conectar.close();

        } catch (SQLException ex) {
            System.out.println("Problema al consultar la base de datos ");
            //Logger.getLogger(MethodRemote.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resp;
    }

    public int MaxiPago() {
        int id_gasto = 1;
        Statement st;
        Connection conectar;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al registrar el driver de PostgreSQL: " + ex);
        }
        try {
            conectar = DriverManager.getConnection(url, user, clave);
            st = conectar.createStatement();
            ResultSet rs = st.executeQuery("select MAX(id_gasto) as cantidad  from Gasto;");
            while (rs.next()) {
                id_gasto = Integer.parseInt(rs.getString("cantidad"))+1;
            }
            System.out.println("Los datos se guardaron correctamente");
            conectar.close();

        } catch (SQLException ex) {
            System.out.println("Problema al consultar la base de datos ");
            id_gasto = -1;
            //Logger.getLogger(MethodRemote.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id_gasto;
    }

    public String UriImg(String idGasto) {
        String URL = null;
        Statement st;
        Connection conectar;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al registrar el driver de PostgreSQL: " + ex);
        }
        try {
            conectar = DriverManager.getConnection(url, user, clave);
            st = conectar.createStatement();
            ResultSet rs = st.executeQuery("select dir_respaldo_pago from Gasto where id_gasto=" + idGasto + ";");
            while (rs.next()) {
                URL = rs.getString("dir_respaldo_pago");
            }
            System.out.println("Los datos se guardaron correctamente");
            conectar.close();

        } catch (SQLException ex) {
            System.out.println("Problema al consultar la base de datos ");

            //Logger.getLogger(MethodRemote.class.getName()).log(Level.SEVERE, null, ex);
        }
        return URL;
    }

    public Boolean Insert_Gastos(Pago p, String fk_user, String[] usuarios, String[] equipos) {
        Boolean resp = false;
        Statement st;
        Connection conectar;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al registrar el driver de PostgreSQL: " + ex);
        }
        try {
            conectar = DriverManager.getConnection(url, user, clave);
            st = conectar.createStatement();
            ResultSet rs = st.executeQuery("select count(id_gasto) as cantidad  from Gasto;");
            int id_gasto = 1;
            while (rs.next()) {
                id_gasto = Integer.parseInt(rs.getString("cantidad"));
                id_gasto += 1;
            }
            PreparedStatement consulta;
            consulta = conectar.prepareStatement("insert into Gasto (id_gasto,fk_proveedor, fk_user, fk_tipo_gasto, \n"
                    + "fk_procedencia, comentario,  valor, tipo_pago, fecha__registro, fecha__pago, "
                    + "iva,valor_iva,estado,dir_respaldo_pago, fk_proyecto)\n"
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            consulta.setInt(1, id_gasto);
            consulta.setString(2, p.getFk_proveedor());
            consulta.setString(3, fk_user);
            consulta.setString(4, p.getFk_tipo_gasto());
            consulta.setString(5, p.getFk_procedencia());
            consulta.setString(6, p.getComentario());
            double valortotal = Double.valueOf(p.getValor());
            consulta.setDouble(7, valortotal);
            consulta.setString(8, p.getTipo_pago());
            long now = System.currentTimeMillis();
            //fecha actual
            Date sqlDate = new Date(now);
            consulta.setDate(9, sqlDate);
            //fecha pago            
            Date datePago = Date.valueOf(p.getFecha__pago());
            consulta.setDate(10, datePago);
            consulta.setString(11, p.getIva());

            consulta.setString(12, p.getValor_iva());
            consulta.setString(13, "nuevo");
            consulta.setString(14, p.getImg_respaldo());
            consulta.setString(15, p.getFk_proyecto());
            //int lineas_modi = consulta.executeUpdate();           
            consulta.executeUpdate();

            //registrar usuarios involucrados
            //primero al usuario logeado
            consulta = conectar.prepareStatement("insert Gastos_users (fk_gasto,fk_user) values(?,?);");
            consulta.setInt(1, id_gasto);
            consulta.setString(2, fk_user);
            consulta.executeUpdate();
            if (usuarios != null) {
                for (String usuario : usuarios) {
                    consulta.setString(2, usuario);
                    consulta.executeUpdate();
                }
            }
            consulta = conectar.prepareStatement("insert Gastos_equipos (fk_gasto,fk_equipo) values(?,?);");
            consulta.setInt(1, id_gasto);
            if (equipos != null) {
                for (String equipo : equipos) {
                    consulta.setString(2, equipo);
                    consulta.executeUpdate();
                }
            }
            resp = true;
            System.out.println("Los datos se guardaron correctamente");
            conectar.close();

        } catch (SQLException ex) {
            System.out.println("Problema al consultar la base de datos ");
            resp = false;
            //Logger.getLogger(MethodRemote.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resp;
    }

    public Boolean Insert_Proyectos(Proyecto p, String fk_user) {
        Boolean resp;
        //Statement st;
        Connection conectar;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al registrar el driver de Mysql: " + ex);
        }
        try {
            conectar = DriverManager.getConnection(url, user, clave);
            //st = conectar.createStatement();            
            PreparedStatement consulta;
            consulta = conectar.prepareStatement("insert into Proyectos (fk_user,nombre,descripcion,fecha_creacion,"
                    + "fecha_inicio,estado) values(?,?,?,?,?,?);");
            consulta.setString(1, fk_user);
            consulta.setString(2, p.getNombre_proyecto());
            consulta.setString(3, p.getDescripcion());
            //fecha actual
            long now = System.currentTimeMillis();
            Date sqlDate = new Date(now);
            consulta.setDate(4, sqlDate);
            //fecha ingesada            
            Date dateInicio = Date.valueOf(p.getFecha_inicio());
            consulta.setDate(5, dateInicio);
            consulta.setString(6, "activo");
            consulta.executeUpdate();
            resp = true;
            System.out.println("Los datos se guardaron correctamente");
            conectar.close();

        } catch (SQLException ex) {
            System.out.println("Problema al consultar la base de datos ");
            resp = false;
            //Logger.getLogger(MethodRemote.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resp;
    }

    public Boolean Eliminar_Proveedor(String id_proveedor) {
        Boolean resp = false;
        Statement st = null;
        Connection conectar;
        int lineas_modi = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al registrar el driver de PostgreSQL: " + ex);
        }
        try {
            conectar = DriverManager.getConnection(url, user, clave);
            PreparedStatement consulta;
            st = conectar.createStatement();
            //SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
            consulta = conectar.prepareStatement("DELETE FROM Proveedor WHERE id_proveedor=?;");
            int idProveedor = Integer.valueOf(id_proveedor);
            consulta.setInt(1, idProveedor);
            lineas_modi = consulta.executeUpdate();
            if (lineas_modi > 0) {

                System.out.println("Los datos se borraron correctamente");
            }
            resp = true;
            conectar.close();

        } catch (SQLException ex) {
            System.out.println("Problema al consultar la base de datos ");
            //Logger.getLogger(MethodRemote.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resp;
    }

    public Boolean Anular_Gasto(String idGasto) {
        Boolean resp = false;
        Statement st = null;
        Connection conectar;
        int lineas_modi = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al registrar el driver de PostgreSQL: " + ex);
        }
        try {
            conectar = DriverManager.getConnection(url, user, clave);
            PreparedStatement consulta;
            st = conectar.createStatement();
            //SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
            consulta = conectar.prepareStatement("UPDATE  Gasto set estado='eliminado' where id_gasto=?;");
            int id_Gasto = Integer.valueOf(idGasto);
            consulta.setInt(1, id_Gasto);
            lineas_modi = consulta.executeUpdate();
            if (lineas_modi > 0) {
                System.out.println("Los datos se borraron correctamente");
            }
            resp = true;
            conectar.close();

        } catch (SQLException ex) {
            System.out.println("Problema al consultar la base de datos ");
            //Logger.getLogger(MethodRemote.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resp;
    }

    public Boolean Eliminar_Proyecto(String id_proyecto) {
        Boolean resp = false;
        Statement st = null;
        Connection conectar;
        int lineas_modi;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al registrar el driver de PostgreSQL: " + ex);
        }
        try {
            conectar = DriverManager.getConnection(url, user, clave);
            PreparedStatement consulta;
            st = conectar.createStatement();
            //SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
            consulta = conectar.prepareStatement("DELETE FROM Proyectos WHERE id_proyecto=?;");
            int idProyecto = Integer.valueOf(id_proyecto);
            consulta.setInt(1, idProyecto);
            lineas_modi = consulta.executeUpdate();
            if (lineas_modi > 0) {

                System.out.println("Los datos se borraron correctamente");
            }
            resp = true;
            conectar.close();

        } catch (SQLException ex) {
            System.out.println("Problema al consultar la base de datos ");
            //Logger.getLogger(MethodRemote.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resp;
    }

}
