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
public class ConsultaEnfermeriaDgonzalez {
    
    private String dniPacienteDgonzalez;
    private Date fechaConsultaDgonzalez;
    private double maximaDgonzalez , minimaDgonzalez;
    private int glucosaDgonzalez;
    private double pesoDgonzalez;
    private int codigofacultativoDgonzalez;

    public ConsultaEnfermeriaDgonzalez(String dniPacienteDgonzalez, Date fechaConsultaDgonzalez, double maximaDgonzalez, double minimaDgonzalez, int glucosaDgonzalez, double pesoDgonzalez, int codigofacultativoDgonzalez) {
        this.dniPacienteDgonzalez = dniPacienteDgonzalez;
        this.fechaConsultaDgonzalez = fechaConsultaDgonzalez;
        this.maximaDgonzalez = maximaDgonzalez;
        this.minimaDgonzalez = minimaDgonzalez;
        this.glucosaDgonzalez = glucosaDgonzalez;
        this.pesoDgonzalez = pesoDgonzalez;
        this.codigofacultativoDgonzalez = codigofacultativoDgonzalez;
    }

    public String getDniPacienteDgonzalez() {
        return dniPacienteDgonzalez;
    }

    public void setDniPacienteDgonzalez(String dniPacienteDgonzalez) {
        this.dniPacienteDgonzalez = dniPacienteDgonzalez;
    }

    public Date getFechaConsultaDgonzalez() {
        return fechaConsultaDgonzalez;
    }

    public void setFechaConsultaDgonzalez(Date fechaConsultaDgonzalez) {
        this.fechaConsultaDgonzalez = fechaConsultaDgonzalez;
    }

    public double getMaximaDgonzalez() {
        return maximaDgonzalez;
    }

    public void setMaximaDgonzalez(double maximaDgonzalez) {
        this.maximaDgonzalez = maximaDgonzalez;
    }

    public double getMinimaDgonzalez() {
        return minimaDgonzalez;
    }

    public void setMinimaDgonzalez(double minimaDgonzalez) {
        this.minimaDgonzalez = minimaDgonzalez;
    }

    public int getGlucosaDgonzalez() {
        return glucosaDgonzalez;
    }

    public void setGlucosaDgonzalez(int glucosaDgonzalez) {
        this.glucosaDgonzalez = glucosaDgonzalez;
    }

    public double getPesoDgonzalez() {
        return pesoDgonzalez;
    }

    public void setPesoDgonzalez(double pesoDgonzalez) {
        this.pesoDgonzalez = pesoDgonzalez;
    }

    public int getCodigofacultativoDgonzalez() {
        return codigofacultativoDgonzalez;
    }

    public void setCodigofacultativoDgonzalez(int codigofacultativoDgonzalez) {
        this.codigofacultativoDgonzalez = codigofacultativoDgonzalez;
    }
    
    
    
}
