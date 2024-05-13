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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
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
            pst.setString(2, EncriptadoDgonzalez.encriptar(pass));

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
    /*
    public static void recuperaCitasMedicasDgonzalez(DefaultTableModel modelo) {
        
    }
    
    public static void recuperaCitasEnfermeriaDgonzalez(DefaultTableModel modelo) {
        
    }
    
    public static boolean registrarCitaMedicaDgonzalez(Cita c) {
        
    }
    
    public static boolean registrarCitaEnfermeriaDgonzalez(Cita c) {
        
    }
    
    public static boolean compruebaDniDgonzalez(String dni) {
        
    }
    
    public static Paciente recuperaDatosPacienteDgonzalez(String dni){
        
    }
    
    public static void cargaTablaConsultasMedicasDgonzalez(DefaultTableModel modelo,String dni) {
        
    }
    
    public static void cargaTablaConsultasEnfermeriaDgonzalez(DefaultTableModel modelo,String dni) {
        
    }
    
    public static boolean registrarConsultaMedicaDgonzalez(Consulta c) {
        
    }
    
    public static boolean registrarConsultaEnfermeriaDgonzalez(ConsultaEnfermeria c) {
        
    }
    
    public static void cargasComboCpDgonzalez(JComboBox combo){
        
    }
    
    public static boolean registrarPacienteDgonzalez(Paciente p){
        
    }
    
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
