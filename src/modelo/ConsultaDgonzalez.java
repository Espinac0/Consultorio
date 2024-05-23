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
public class ConsultaDgonzalez {
    
    private String dniPacienteDgonzalez;
    private Date fechaConsultaDgonzalez;
    private String diagnosticoDgonzalez;
    private String tratamientoDgonzalez;
    private String observacionesDgonzalez;
    private int codigofacultativoDgonzalez;

    public ConsultaDgonzalez(String dniPacienteDgonzalez, Date fechaConsultaDgonzalez, String diagnosticoDgonzalez, String tratamientoDgonzalez, String observacionesDgonzalez, int codigofacultativoDgonzalez) {
        this.dniPacienteDgonzalez = dniPacienteDgonzalez;
        this.fechaConsultaDgonzalez = fechaConsultaDgonzalez;
        this.diagnosticoDgonzalez = diagnosticoDgonzalez;
        this.tratamientoDgonzalez = tratamientoDgonzalez;
        this.observacionesDgonzalez = observacionesDgonzalez;
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

    public String getDiagnosticoDgonzalez() {
        return diagnosticoDgonzalez;
    }

    public void setDiagnosticoDgonzalez(String diagnosticoDgonzalez) {
        this.diagnosticoDgonzalez = diagnosticoDgonzalez;
    }

    public String getTratamientoDgonzalez() {
        return tratamientoDgonzalez;
    }

    public void setTratamientoDgonzalez(String tratamientoDgonzalez) {
        this.tratamientoDgonzalez = tratamientoDgonzalez;
    }

    public String getObservacionesDgonzalez() {
        return observacionesDgonzalez;
    }

    public void setObservacionesDgonzalez(String observacionesDgonzalez) {
        this.observacionesDgonzalez = observacionesDgonzalez;
    }

    public int getCodigofacultativoDgonzalez() {
        return codigofacultativoDgonzalez;
    }

    public void setCodigofacultativoDgonzalez(int codigofacultativoDgonzalez) {
        this.codigofacultativoDgonzalez = codigofacultativoDgonzalez;
    }
    
    
}
