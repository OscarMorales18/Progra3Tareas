/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import domain.RondaVotos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class RondaVotosDAO {
 //constantes que guardan el codigo lmd o sql
    private static final String SQL_SELECT = "SELECT id_rondavotos, nombre_candidato, ronda_uno, ronda_dos, ronda_tres, ronda_cuatro, ronda_cinco, ronda_total FROM rondavotos";
    private static final String SQL_INSERT = "INSERT INTO rondavotos(nombre_candidato, ronda_uno, ronda_dos, ronda_tres, ronda_cuatro, ronda_cinco, ronda_total) VALUES(?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE rondavotos SET nombre_candidato=?, ronda_uno=?, ronda_dos=?, ronda_tres=?, ronda_cuatro=?, ronda_cinco=?, ronda_total=? WHERE id_rondavotos=?";
    private static final String SQL_DELETE = "DELETE FROM rondavotos WHERE id_rondavotos=?";
    private static final String SQL_QUERY = "SELECT id_rondavotos, nombre_candidato, ronda_uno, ronda_dos, ronda_tres, ronda_cuatro, ronda_cinco, ronda_total FROM rondavotos WHERE id_rondavotos=?";
//
   public List<RondaVotos> select() {
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        RondaVotos rondaVotos = null;
        List<RondaVotos> rondaVotoss = new ArrayList<RondaVotos>(); 
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idRondavotos = rs.getInt("id_rondavotos");
                String nombreCandidato = rs.getString("nombre_candidato");
                int rondaUno = rs.getInt("ronda_uno");
                int rondaDos = rs.getInt("ronda_dos");
                int rondaTres = rs.getInt("ronda_tres");
                int rondaCuatro = rs.getInt("ronda_cuatro");
                int rondaCinco = rs.getInt("ronda_cinco");
                int rondaTotal = rs.getInt("ronda_total");
                
                rondaVotos = new RondaVotos();
                
                rondaVotos.setIdRondavotos(idRondavotos);
                rondaVotos.setNombreCandidato(nombreCandidato);
                rondaVotos.setRondaUno(rondaUno);
                rondaVotos.setRondaDos(rondaDos);
                rondaVotos.setRondaTres(rondaTres);
                rondaVotos.setRondaCuatro(rondaCuatro);
                rondaVotos.setRondaCinco(rondaCinco);
                rondaVotos.setRondaTotal(rondaTotal);

                rondaVotoss.add(rondaVotos);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rondaVotoss;
    }
    public int insert(RondaVotos rondaVotos) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, rondaVotos.getNombreCandidato());
            stmt.setInt(2, rondaVotos.getRondaUno());
            stmt.setInt(3, rondaVotos.getRondaDos());
            stmt.setInt(4, rondaVotos.getRondaTres());
            stmt.setInt(5, rondaVotos.getRondaCuatro());
            stmt.setInt(6, rondaVotos.getRondaCinco());
            stmt.setInt(7, rondaVotos.getRondaTotal());
            
            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
    public int update(RondaVotos rondaVotos) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);

            stmt.setString(1, rondaVotos.getNombreCandidato());
            stmt.setInt(2, rondaVotos.getRondaUno());
            stmt.setInt(3, rondaVotos.getRondaDos());
            stmt.setInt(4, rondaVotos.getRondaTres());
            stmt.setInt(5, rondaVotos.getRondaCuatro());
            stmt.setInt(6, rondaVotos.getRondaCinco());
            stmt.setInt(7, rondaVotos.getRondaTotal());
            
            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int delete(RondaVotos rondaVotos) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, rondaVotos.getIdRondavotos());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public RondaVotos query(RondaVotos rondaVotos) { 
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<RondaVotos> rondaVotoss = new ArrayList<RondaVotos>();
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, rondaVotos.getIdRondavotos());
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idRondavotos = rs.getInt("id_rondavotos");
                String nombreCandidato = rs.getString("nombre_candidato");
                int rondaUno = rs.getInt("ronda_uno");
                int rondaDos = rs.getInt("ronda_dos");
                int rondaTres = rs.getInt("ronda_tres");
                int rondaCuatro = rs.getInt("ronda_cuatro");
                int rondaCinco = rs.getInt("ronda_cinco");
                int rondaTotal = rs.getInt("ronda_total");
                
                rondaVotos = new RondaVotos();
                
                rondaVotos.setIdRondavotos(idRondavotos);
                rondaVotos.setNombreCandidato(nombreCandidato);
                rondaVotos.setRondaUno(rondaUno);
                rondaVotos.setRondaDos(rondaDos);
                rondaVotos.setRondaTres(rondaTres);
                rondaVotos.setRondaCuatro(rondaCuatro);
                rondaVotos.setRondaCinco(rondaCinco);
                rondaVotos.setRondaTotal(rondaTotal);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rondaVotos;
    }
        
}