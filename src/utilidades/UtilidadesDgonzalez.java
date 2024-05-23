/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilidades;

import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author David
 */
public class UtilidadesDgonzalez {

    static String patronTlfFijoDgonzalez = "^[98]{1}[0-8]{1}[0-9]{7}$";
    static String patronTlfMovilDgonzalez = "^[5-6-7]{1}[0-9]{8}$";
    

    public static boolean formatoDniCorrectoDgonzalez(JTextField campo) {

        String modeloDni = "^[0-9]{8}[A-HJ-NP-Z]{1}$";

        return campo.getText().toUpperCase().matches(modeloDni);
    }

    /**
     * Lanza alerta si el formato indicado arriba no es correcto.
     *
     * @param c
     * @param campo
     */
    public static void lanzaAlertaDniDgonzalez(Component c, JTextField campo) {

        JOptionPane.showMessageDialog(c, "El formato del DNI no es correcto.");
    }

    /**
     * Comprueba que la letra del dni sea la correspondiente.
     *
     * @param campo
     * @return
     */
    public static boolean letraDniCorrectaDgonzalez(JTextField campo) {

        int dni = Integer.parseInt(campo.getText().substring(0, 8));

        int resto = dni % 23;

        char letra = campo.getText().toUpperCase().charAt(8);

        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";

        return letra == letras.charAt(resto);
    }

    /**
     * Lanza alerta en caso de que el dni no tenga la letra que corresponde.
     *
     * @param c
     * @param campo
     */
    public static void lanzaAlertaLetraDniDgonzalez(Component c, JTextField campo) {

        JOptionPane.showMessageDialog(c, "La letra no corresponde al DNI.");
    }

    public static boolean compruebaVacioDgonzalez(JTextField campo) {
        return campo.getText().trim().isEmpty();
    }

    public static void lanzaAlertaVacioDgonzalez(JTextField campo) {

        JOptionPane.showMessageDialog(null, "El campo " + campo.getName() + " es obligatorio");

    }

    public static boolean compruebaTextAreaVacioDgonzalez(JTextArea campo) {
        return campo.getText().trim().isEmpty();
    }

    public static void lanzaAlertaTextAreaVacioDgonzalez(JTextArea campo) {

        JOptionPane.showMessageDialog(null, "El campo " + campo.getName() + " es obligatorio");

    }

    public static boolean enteroCorrectoDgonzalez(JTextField campo) {
        try {
            Integer.valueOf(campo.getText());
            return true;

        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    public static void LanzaAlertaEnteroDgonzalez(JTextField campo) {
        JOptionPane.showMessageDialog(null, "El campo " + campo.getName() + " es numerico");
    }

    public static boolean doubleCorrectoDgonzalez(JTextField campo) {
        try {
            String texto = campo.getText();

            double numero = Double.parseDouble(texto);

            if (numero > 0) {
                return true;
            }
        } catch (NumberFormatException e) {
        }
        return false;
    }

    public static void lanzaAlertaDoubleDgonzalez(JTextField campo) {
        JOptionPane.showMessageDialog(null, "El campo " + campo.getName() + " debe ser un n�mero.");
    }
    
    public static boolean comboNoSeleccionado(JComboBox combo) {
        return combo.getSelectedIndex() == 0;

    }

    public static void alertaComboNoSeleccioando(Component padre, JComboBox combo) {
        JOptionPane.showMessageDialog(null, "Debe seleccionar " + combo.getName());
    }

    public static boolean formatoTlf(JTextField campo) {
        return !campo.getText().matches(patronTlfFijoDgonzalez) && !campo.getText().matches(patronTlfMovilDgonzalez);
    }

    public static void lanzaAlertaFormatoTlf(Component c, JTextField campo) {
        JOptionPane.showMessageDialog(c, "El telefono no se corresponde con el formato establecido");
    }

    
    

    public static void lanzaAlertaRangoTlf(Component c, JTextField campo) {
        JOptionPane.showMessageDialog(c, "El telefono es superior al rango establecido");
    }

    public static boolean formatoEmailCorrecto(JTextField campo) {
        String modeloEmail = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.com";
        return campo.getText().matches(modeloEmail);
    }
    
    public static void lanzaAlertaEmail(Component c, JTextField campo){
        JOptionPane.showMessageDialog(c, "El correo no esta escrito de manera correcta");
    }
    
}
