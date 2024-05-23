/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bbdd;

import com.mysql.jdbc.Connection;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.CitaDgonzalez;
import modelo.ConsultaDgonzalez;
import modelo.ConsultaEnfermeriaDgonzalez;
import modelo.PacienteDgonzalez;
import utilidades.EncriptadoDgonzalez;

/**
 *
 * @author David
 */
public class ConexionDgonzalez {
    
    static java.sql.Connection conn;

    /**
     * parametro de la url para entrar a la base de datos
     */
    public static final String URL = "jdbc:mysql://145.14.151.1/u812167471_consultorioDaw";

    /**
     * parametro de el nombre para entrar a la base de datos
     */
    public static final String USERNAME = "u812167471_consultorioDaw";

    /**
     * parametro de la contraseña para entrar a la base de datos
     */
    public static final String PASSWORD = "2024-Daw";
    
    public static Connection conectarDgonzalez() {
        try {

            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        } catch (SQLException ex) {
            Logger.getLogger(ConexionDgonzalez.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;  
    }
    
    public static void cerrarConexionDgonzalez(){
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDgonzalez.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static boolean accederDgonzalez(String user,String pass) throws InvalidKeyException, NoSuchAlgorithmException, IllegalBlockSizeException, NoSuchPaddingException, BadPaddingException{
      try {
            String consulta = "SELECT usuario, contrasenya FROM personal WHERE usuario=? AND contrasenya=?";

            PreparedStatement pst = conn.prepareCall(consulta);
            ResultSet rs;

            pst.setString(1, user);
            pst.setString(2, EncriptadoDgonzalez.encriptarDgonzalez(pass));

            rs = pst.executeQuery();

            return rs.next();

        } catch (SQLException ex) {
            Logger.getLogger(ConexionDgonzalez.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;  
    }
    
    public static String[] recuperarDatosUserLogado(String user) {
       try {
        String[] datos = new String[3];
        String consulta = "SELECT CONCAT(nombre, ' ', apellidos) AS nombre_completo, numero_colegiado, tipo FROM personal WHERE usuario=?";
        PreparedStatement pst = conn.prepareCall(consulta);
        pst.setString(1, user);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            datos[0] = rs.getString("nombre_completo");
            datos[1] = Integer.toString(rs.getInt("numero_colegiado"));
            datos[2] = rs.getString("tipo");
            return datos;
        }
    } catch (SQLException ex) {
        Logger.getLogger(ConexionDgonzalez.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
    } 
    
    public static void recuperaCitasMedicasDgonzalez(DefaultTableModel modelo) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
       try {
            String SSQL = "SELECT nombre as NOMBRE, dia as DIA, Hora as hora FROM citas WHERE dia = CURDATE()";
            
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(SSQL);
            
           while (rs.next()) {
                Object[] registro = new Object[3]; 
                
                registro[0] = EncriptadoDgonzalez.desencriptarDgonzalez(rs.getString("NOMBRE"));
                registro[1] = rs.getString("DIA");
                registro[2] = rs.getString("HORA");

                modelo.addRow(registro);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDgonzalez.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public static void recuperaCitasEnfermeriaDgonzalez(DefaultTableModel modelo) {
        try {
            String SSQL = "SELECT nombre as NOMBRE, dia as DIA, Hora as hora FROM citas WHERE dia = CURDATE()";
            
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(SSQL);
            
           while (rs.next()) {
                Object[] registro = new Object[3]; 
                
                try {
                    registro[0] = EncriptadoDgonzalez.desencriptarDgonzalez(rs.getString("NOMBRE"));
                } catch (InvalidKeyException | NoSuchAlgorithmException | IllegalBlockSizeException | NoSuchPaddingException | BadPaddingException ex) {
                    Logger.getLogger(ConexionDgonzalez.class.getName()).log(Level.SEVERE, null, ex);
                }
                registro[1] = rs.getString("DIA");
                registro[2] = rs.getString("HORA");

                modelo.addRow(registro);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDgonzalez.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    
    public static boolean registrarCitaMedicaDgonzalez(CitaDgonzalez c) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        try {
            String consulta = "INSERT INTO citas(dniPaciente, nombre , dia, hora) VALUES (?, ?, ?, ?)";

            PreparedStatement pst = conn.prepareStatement(consulta);

            pst.setString(1, EncriptadoDgonzalez.encriptarDgonzalez(c.getDniPacienteDgonzalez()));
            pst.setString(2, EncriptadoDgonzalez.encriptarDgonzalez(c.getNombreDgonzalez()));
            pst.setDate(3,  new java.sql.Date(c.getDiaDgonzalez().getTime()));
            pst.setDouble(4,  c.getHoraDgonzalez());

            pst.execute();

        } catch (SQLException ex) {
            Logger.getLogger(ConexionDgonzalez.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false; 
    }
    /*
    public static boolean registrarCitaEnfermeriaDgonzalez(Cita c) {
        
    }
    */
    
    
    public static boolean compruebaDniDgonzalez(String dni) {
    String SSQL = "SELECT dni FROM paciente WHERE dni =?";

        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conn.prepareStatement(SSQL);

            pst.setString(1, dni);
            rs = pst.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDgonzalez.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public static PacienteDgonzalez recuperaDatosPacienteDgonzalez(String dni) {

        String consultaRecuperaTipo = "SELECT nombre, apellidos, telefono, email "
                + "from paciente where dni='" + dni + "'";

        PacienteDgonzalez p = null;

        try {

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(consultaRecuperaTipo);

            if (rs.next()) {
                p = new PacienteDgonzalez(
                        rs.getString("nombre"),
                        rs.getString("apellidos"),
                        rs.getInt("telefono"),
                        rs.getString("email")
                );
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConexionDgonzalez.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }
    
    
    public static void cargaTablaConsultasMedicasDgonzalez(DefaultTableModel modelo,String dni) {
        try {
            String SSQL = "SELECT fechaConsulta as FECHA, diagnostico as DIAGNOSTICO, tratamiento as TRATAMIENTO, observaciones as OBSERVACIONES FROM consultas WHERE dniPaciente = '" + dni +"'";
            
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(SSQL);
            
           while (rs.next()) {
                Object[] consultaDgonzalez = new Object[4]; 
                
                consultaDgonzalez[0] = rs.getString("FECHA");
                consultaDgonzalez[1] = rs.getString("DIAGNOSTICO");
                consultaDgonzalez[2] = rs.getString("TRATAMIENTO");
                consultaDgonzalez[3] = rs.getString("OBSERVACIONES");
                
                
                modelo.addRow(consultaDgonzalez);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDgonzalez.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static void cargaTablaConsultasEnfermeriaDgonzalez(DefaultTableModel modelo,String dni) {
      try {
            String SSQL = "SELECT fechaConsulta as FECHA, tensionMax as MAXIMA, tensionMin as MINIMA, glucosa as GLUCOSA, peso as PESO  FROM enfermeria WHERE dniPaciente = '" + dni +"'";
            
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(SSQL);
            
           while (rs.next()) {
                Object[] consultaDgonzalez = new Object[5]; 
                
                consultaDgonzalez[0] = rs.getString("FECHA");
                consultaDgonzalez[1] = rs.getString("MAXIMA");
                consultaDgonzalez[2] = rs.getString("MINIMA");
                consultaDgonzalez[3] = rs.getString("GLUCOSA");
                consultaDgonzalez[4] = rs.getString("PESO");
                
                modelo.addRow(consultaDgonzalez);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDgonzalez.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    
    
    public static boolean registrarConsultaMedicaDgonzalez(ConsultaDgonzalez c) {
       try {
            String consulta = "INSERT INTO consultas(dniPaciente, fechaConsulta , diagnostico, tratamiento, observaciones, codigofacultativo) VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement pst = conn.prepareStatement(consulta);

            pst.setString(1, c.getDniPacienteDgonzalez());
            pst.setDate(2, new java.sql.Date(c.getFechaConsultaDgonzalez().getTime()));
            pst.setString(3, c.getDiagnosticoDgonzalez());
            pst.setString(4, c.getTratamientoDgonzalez());
            pst.setString(5, c.getObservacionesDgonzalez());
            pst.setInt(6, c.getCodigofacultativoDgonzalez());

            pst.execute();

        } catch (SQLException ex) {
            Logger.getLogger(ConexionDgonzalez.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false; 
    }
    
    
    public static boolean registrarConsultaEnfermeriaDgonzalez(ConsultaEnfermeriaDgonzalez ce) {
     try {
            String consulta = "INSERT INTO enfermeria(dniPaciente, fechaConsulta , tensionMax, tensionMin, glucosa, peso, codigoFacultativo) VALUES (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement pst = conn.prepareStatement(consulta);

            pst.setString(1, ce.getDniPacienteDgonzalez());
            pst.setDate(2, new java.sql.Date(ce.getFechaConsultaDgonzalez().getTime()));
            pst.setDouble(3, ce.getMaximaDgonzalez());
            pst.setDouble(4, ce.getMinimaDgonzalez());
            pst.setInt(5, ce.getGlucosaDgonzalez());
            pst.setDouble(6, ce.getPesoDgonzalez());
            pst.setInt(7, ce.getCodigofacultativoDgonzalez());

            pst.execute();

        } catch (SQLException ex) {
            Logger.getLogger(ConexionDgonzalez.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;    
    }
    
    public static void cargasComboCpDgonzalez(JComboBox combo){
        
        String consulta = "SELECT codigopostal FROM codigospostales";

        try {
            Statement st = conn.createStatement();
            try (ResultSet rs = st.executeQuery(consulta)) {
                while (rs.next()) {
                    combo.addItem(rs.getString("codigopostal"));
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConexionDgonzalez.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static boolean registrarPacienteDgonzalez(PacienteDgonzalez p) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException{
        try {
            String consulta = "INSERT INTO paciente(dni, nombre , apellidos, fechaNacimiento, telefono, email, cp, sexo, tabaquismo, consumoAlcohol,"
                    + "antecedentesSalud, datosSaludGeneral, fechaRegistro) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement pst = conn.prepareStatement(consulta);

            pst.setString(1, EncriptadoDgonzalez.encriptarDgonzalez(p.getDniDgonzalez()));
            pst.setString(2, EncriptadoDgonzalez.encriptarDgonzalez(p.getNombreDgonzalez()));
            pst.setString(3, EncriptadoDgonzalez.encriptarDgonzalez(p.getApellidosDgonzalez()));
            pst.setDate(4, new java.sql.Date(p.getFechaNacimientoDgonzalez().getTime()));
            pst.setInt(5, p.getTelefonoDgonzalez());
            pst.setString(6, p.getEmailDgonzalez()); /* */
            pst.setInt(7, p.getCpDgonzalez());
            pst.setString(8, p.getSexoDgonzalez());
            pst.setString(9, p.getTabaquismoDgonzalez());
            pst.setString(10, p.getConsumoalcoholDgonzalez());
            pst.setString(11, p.getAntecedentesSaludDgonzalez());
            pst.setString(12, p.getDatosSaludGeneralDgonzalez());
            pst.setDate(13,  new java.sql.Date(p.getFechaRegistroDgonzalez().getTime()));
            

            pst.execute();

        } catch (SQLException ex) {
            Logger.getLogger(ConexionDgonzalez.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false; 
    }
    
    /*
    public static void cargaTablaPacientesDgonzalez(DefaultTableModel modelo) {
        
    }
    
    public static boolean compruebaUserDgonzalez(String user) {
        
    }
    
    public static boolean compruebaNumeroColegiadoDgonzalez(long numero) {
        
    }
    
    public static boolean registrarPersonalDgonzalez(Personal p) {
        
    } 
    */

    
}
