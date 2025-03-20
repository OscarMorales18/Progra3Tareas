/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author Home
 */
public class RondaVotos {

    private int idRondavotos;
    private String nombreCandidato;
    private int rondaUno;
    private int rondaDos;
    private int rondaTres;
    private int rondaCuatro;
    private int rondaCinco;
    private int rondaTotal;

    public int getIdRondavotos() {
        return idRondavotos;
    }

    public void setIdRondavotos(int idRondavotos) {
        this.idRondavotos = idRondavotos;
    }

    public String getNombreCandidato() {
        return nombreCandidato;
    }

    public void setNombreCandidato(String nombreCandidato) {
        this.nombreCandidato = nombreCandidato;
    }

    public int getRondaUno() {
        return rondaUno;
    }

    public void setRondaUno(int rondaUno) {
        this.rondaUno = rondaUno;
    }

    public int getRondaDos() {
        return rondaDos;
    }

    public void setRondaDos(int rondaDos) {
        this.rondaDos = rondaDos;
    }

    public int getRondaTres() {
        return rondaTres;
    }

    public void setRondaTres(int rondaTres) {
        this.rondaTres = rondaTres;
    }

    public int getRondaCuatro() {
        return rondaCuatro;
    }

    public void setRondaCuatro(int rondaCuatro) {
        this.rondaCuatro = rondaCuatro;
    }

    public int getRondaCinco() {
        return rondaCinco;
    }

    public void setRondaCinco(int rondaCinco) {
        this.rondaCinco = rondaCinco;
    }

    public int getRondaTotal() {
        return rondaTotal;
    }

    public void setRondaTotal(int rondaTotal) {
        this.rondaTotal = rondaTotal;
    }

    public RondaVotos(int idRondavotos, String nombreCandidato, int rondaUno, int rondaDos, int rondaTres, int rondaCuatro, int rondaCinco, int rondaTotal) {
        this.idRondavotos = idRondavotos;
        this.nombreCandidato = nombreCandidato;
        this.rondaUno = rondaUno;
        this.rondaDos = rondaDos;
        this.rondaTres = rondaTres;
        this.rondaCuatro = rondaCuatro;
        this.rondaCinco = rondaCinco;
        this.rondaTotal = rondaTotal;
    }

    @Override
    public String toString() {
        return "RondaVotos{" + "idRondavotos=" + idRondavotos + ", nombreCandidato=" + nombreCandidato + ", rondaUno=" + rondaUno + ", rondaDos=" + rondaDos + ", rondaTres=" + rondaTres + ", rondaCuatro=" + rondaCuatro + ", rondaCinco=" + rondaCinco + ", rondaTotal=" + rondaTotal + '}';
    }
   
    
    public RondaVotos() {
    }
}
