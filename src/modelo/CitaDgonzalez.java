/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Date;

/**
 *
 * @author David
 */
public class CitaDgonzalez {
    
    private String dniPacienteDgonzalez;
    private String nombreDgonzalez;
    private Date diaDgonzalez;
    private double horaDgonzalez;

    public CitaDgonzalez(String dniPacienteDgonzalez, String nombreDgonzalez, Date diaDgonzalez, double horaDgonzalez) {
        this.dniPacienteDgonzalez = dniPacienteDgonzalez;
        this.nombreDgonzalez = nombreDgonzalez;
        this.diaDgonzalez = diaDgonzalez;
        this.horaDgonzalez = horaDgonzalez;
    }

    public String getDniPacienteDgonzalez() {
        return dniPacienteDgonzalez;
    }

    public void setDniPacienteDgonzalez(String dniPacienteDgonzalez) {
        this.dniPacienteDgonzalez = dniPacienteDgonzalez;
    }

    public String getNombreDgonzalez() {
        return nombreDgonzalez;
    }

    public void setNombreDgonzalez(String nombreDgonzalez) {
        this.nombreDgonzalez = nombreDgonzalez;
    }

    public Date getDiaDgonzalez() {
        return diaDgonzalez;
    }

    public void setDiaDgonzalez(Date diaDgonzalez) {
        this.diaDgonzalez = diaDgonzalez;
    }

    public double getHoraDgonzalez() {
        return horaDgonzalez;
    }

    public void setHoraDgonzalez(double horaDgonzalez) {
        this.horaDgonzalez = horaDgonzalez;
    }
    
    @Override
    public String toString() {
        return "<h2>------------------------Datos de la cita-------------------------</h2>"
                + "\nDni del Paciente: <b>" + this.dniPacienteDgonzalez + "</b>"
                + "\nNombre: <b>"+ this.nombreDgonzalez + "</b>"
                + "\nDía: <b>" + this.diaDgonzalez + "</b>"
                + "\nHora: <b>" + this.horaDgonzalez + "</b>"
                + "<h2>--------------------------------------------------------------</h2>"
                + "<br/><br/><img scr=http://reynaldomd.com/firmacorreo/firmacorreo.png>"
                + "<br/><br/>Has recibido este email porque has solicitado una cita en el centro médico. Por favor, no responda a este correo"
                + "<br><br/>electronico ha sido generado automáticamente.";
    }
    
}
