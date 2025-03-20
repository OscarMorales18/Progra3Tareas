/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author Home
 */
public class Votacion {

    public Votacion(int id_votacion, int id_candidato, int no_ronda, int votos_ronda) {
        this.id_votacion = id_votacion;
        this.id_candidato = id_candidato;
        this.no_ronda = no_ronda;
        this.votos_ronda = votos_ronda;
    }

    public int getId_votacion() {
        return id_votacion;
    }

    public int getId_candidato() {
        return id_candidato;
    }

    public int getNo_ronda() {
        return no_ronda;
    }

    public int getVotos_ronda() {
        return votos_ronda;
    }

    public void setId_votacion(int id_votacion) {
        this.id_votacion = id_votacion;
    }

    public void setId_candidato(int id_candidato) {
        this.id_candidato = id_candidato;
    }

    public void setNo_ronda(int no_ronda) {
        this.no_ronda = no_ronda;
    }

    public void setVotos_ronda(int votos_ronda) {
        this.votos_ronda = votos_ronda;
    }

    @Override
    public String toString() {
        return "Votacion{" + "id_votacion=" + id_votacion + ", id_candidato=" + id_candidato + ", no_ronda=" + no_ronda + ", votos_ronda=" + votos_ronda + '}';
    }

    int id_votacion;
    int id_candidato;
    int no_ronda;
    int votos_ronda;

    public Votacion() {
    }
}
