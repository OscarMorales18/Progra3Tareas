/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author Home
 */
public class Candidato {

    public Candidato(int idCandidato, String nombreCandidato, String estatusCandidato) {
        this.idCandidato = idCandidato;
        this.nombreCandidato = nombreCandidato;
        this.estatusCandidato = estatusCandidato;
    }

    public int getIdCandidato() {
        return idCandidato;
    }

    public String getNombreCandidato() {
        return nombreCandidato;
    }

    public String getEstatusCandidato() {
        return estatusCandidato;
    }

    public void setIdCandidato(int idCandidato) {
        this.idCandidato = idCandidato;
    }

    public void setNombreCandidato(String nombreCandidato) {
        this.nombreCandidato = nombreCandidato;
    }

    public void setEstatusCandidato(String estatusCandidato) {
        this.estatusCandidato = estatusCandidato;
    }

    @Override
    public String toString() {
        return "Candidatos{" + "idCandidato=" + idCandidato + ", nombreCandidato=" + nombreCandidato + ", estatusCandidato=" + estatusCandidato + '}';
    }
    private int idCandidato;
    private String nombreCandidato;
    private String estatusCandidato;

    public Candidato() {
    }
}
