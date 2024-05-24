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
public class PacienteDgonzalez {
    private String dniDgonzalez;
    private String nombreDgonzalez;
    private String apellidosDgonzalez;
    private Date fechaNacimientoDgonzalez;
    private int telefonoDgonzalez;
    private String emailDgonzalez;
    private int cpDgonzalez;
    private String sexoDgonzalez;
    private String tabaquismoDgonzalez;
    private String consumoalcoholDgonzalez;
    private String antecedentesSaludDgonzalez;
    private String datosSaludGeneralDgonzalez;
    private Date fechaRegistroDgonzalez;

    public PacienteDgonzalez(String dniDgonzalez, String nombreDgonzalez, String apellidosDgonzalez, Date fechaNacimientoDgonzalez, int telefonoDgonzalez, String emailDgonzalez, int cpDgonzalez, String sexoDgonzalez, String tabaquismoDgonzalez, String consumoalcoholDgonzalez, String antecedentesSaludDgonzalez, String datosSaludGeneralDgonzalez, Date fechaRegistroDgonzalez) {
        this.dniDgonzalez = dniDgonzalez;
        this.nombreDgonzalez = nombreDgonzalez;
        this.apellidosDgonzalez = apellidosDgonzalez;
        this.fechaNacimientoDgonzalez = fechaNacimientoDgonzalez;
        this.telefonoDgonzalez = telefonoDgonzalez;
        this.emailDgonzalez = emailDgonzalez;
        this.cpDgonzalez = cpDgonzalez;
        this.sexoDgonzalez = sexoDgonzalez;
        this.tabaquismoDgonzalez = tabaquismoDgonzalez;
        this.consumoalcoholDgonzalez = consumoalcoholDgonzalez;
        this.antecedentesSaludDgonzalez = antecedentesSaludDgonzalez;
        this.datosSaludGeneralDgonzalez = datosSaludGeneralDgonzalez;
        this.fechaRegistroDgonzalez = fechaRegistroDgonzalez;
    }

    public PacienteDgonzalez(String nombreDgonzalez, String apellidosDgonzalez, int telefonoDgonzalez, String emailDgonzalez) {
        this.nombreDgonzalez = nombreDgonzalez;
        this.apellidosDgonzalez = apellidosDgonzalez;
        this.telefonoDgonzalez = telefonoDgonzalez;
        this.emailDgonzalez = emailDgonzalez;
    }

    public PacienteDgonzalez(String nombreDgonzalez, String apellidosDgonzalez, int telefonoDgonzalez, int cpDgonzalez) {
        this.nombreDgonzalez = nombreDgonzalez;
        this.apellidosDgonzalez = apellidosDgonzalez;
        this.telefonoDgonzalez = telefonoDgonzalez;
        this.cpDgonzalez = cpDgonzalez;
    }

    
    
    
    public String getDniDgonzalez() {
        return dniDgonzalez;
    }

    public void setDniDgonzalez(String dniDgonzalez) {
        this.dniDgonzalez = dniDgonzalez;
    }

    public String getNombreDgonzalez() {
        return nombreDgonzalez;
    }

    public void setNombreDgonzalez(String nombreDgonzalez) {
        this.nombreDgonzalez = nombreDgonzalez;
    }

    public String getApellidosDgonzalez() {
        return apellidosDgonzalez;
    }

    public void setApellidosDgonzalez(String apellidosDgonzalez) {
        this.apellidosDgonzalez = apellidosDgonzalez;
    }

    public Date getFechaNacimientoDgonzalez() {
        return fechaNacimientoDgonzalez;
    }

    public void setFechaNacimientoDgonzalez(Date fechaNacimientoDgonzalez) {
        this.fechaNacimientoDgonzalez = fechaNacimientoDgonzalez;
    }

    public int getTelefonoDgonzalez() {
        return telefonoDgonzalez;
    }

    public void setTelefonoDgonzalez(int telefonoDgonzalez) {
        this.telefonoDgonzalez = telefonoDgonzalez;
    }

    public String getEmailDgonzalez() {
        return emailDgonzalez;
    }

    public void setEmailDgonzalez(String emailDgonzalez) {
        this.emailDgonzalez = emailDgonzalez;
    }

    public int getCpDgonzalez() {
        return cpDgonzalez;
    }

    public void setCpDgonzalez(int cpDgonzalez) {
        this.cpDgonzalez = cpDgonzalez;
    }

    public String getSexoDgonzalez() {
        return sexoDgonzalez;
    }

    public void setSexoDgonzalez(String sexoDgonzalez) {
        this.sexoDgonzalez = sexoDgonzalez;
    }

    public String getTabaquismoDgonzalez() {
        return tabaquismoDgonzalez;
    }

    public void setTabaquismoDgonzalez(String tabaquismoDgonzalez) {
        this.tabaquismoDgonzalez = tabaquismoDgonzalez;
    }

    public String getConsumoalcoholDgonzalez() {
        return consumoalcoholDgonzalez;
    }

    public void setConsumoalcoholDgonzalez(String consumoalcoholDgonzalez) {
        this.consumoalcoholDgonzalez = consumoalcoholDgonzalez;
    }

    public String getAntecedentesSaludDgonzalez() {
        return antecedentesSaludDgonzalez;
    }

    public void setAntecedentesSaludDgonzalez(String antecedentesSaludDgonzalez) {
        this.antecedentesSaludDgonzalez = antecedentesSaludDgonzalez;
    }

    public String getDatosSaludGeneralDgonzalez() {
        return datosSaludGeneralDgonzalez;
    }

    public void setDatosSaludGeneralDgonzalez(String datosSaludGeneralDgonzalez) {
        this.datosSaludGeneralDgonzalez = datosSaludGeneralDgonzalez;
    }

    public Date getFechaRegistroDgonzalez() {
        return fechaRegistroDgonzalez;
    }

    public void setFechaRegistroDgonzalez(Date fechaRegistroDgonzalez) {
        this.fechaRegistroDgonzalez = fechaRegistroDgonzalez;
    }
    
    
    
    
}
