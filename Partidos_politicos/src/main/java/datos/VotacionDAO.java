/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import domain.Votacion;
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
public class VotacionDAO {
 //constantes que guardan el codigo lmd o sql
    private static final String SQL_SELECT = "SELECT no_ronda, id_candidato, votos_ronda, id_votacion FROM votaciones";
    private static final String SQL_INSERT = "INSERT INTO votaciones(no_ronda, id_candidato, votos_ronda) VALUES(?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE votaciones SET no_ronda=?, id_candidato=?, votos_ronda=? WHERE id_votacion=?";
    private static final String SQL_DELETE = "DELETE FROM votaciones WHERE id_votacion=?";
    private static final String SQL_QUERY = "SELECT no_ronda, id_candidato, votos_ronda, id_votacion FROM votaciones WHERE id_votacion=?";
//
    public List<Votacion> select() {
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        Votacion votacion = null;
       
        List<Votacion> votaciones = new ArrayList<>(); 
        try {
            
            conn = Conexion.getConnection();
            //trasladamos el comando que vamos a ejecutar para este metodo es select
            stmt = conn.prepareStatement(SQL_SELECT);
            //ejecuta el comando sql y trae todos los registros
            rs = stmt.executeQuery();
            //ciclo que mientras haya otro registro al ya no haber se termina el ciclo
            while (rs.next()) {
                
                int noRonda = rs.getInt("no_ronda");
                int idCandidato = rs.getInt("id_candidato");
                int votosRonda = rs.getInt("votos_ronda");
                int idVotacion = rs.getInt("id_votacion");
                
                
                votacion = new Votacion(noRonda, idCandidato, votosRonda, idVotacion);
                votaciones.add(votacion);
              
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        
        return votaciones;
    }

    public int insert(Votacion votaciones) {
       
        Connection conn = null;        
        PreparedStatement stmt = null;
        int rows = 0;        
        try {            
            conn = Conexion.getConnection();
           
            stmt = conn.prepareStatement(SQL_INSERT);
            
            stmt.setInt(1, votaciones.getNo_ronda());
            stmt.setInt(2, votaciones.getVotos_ronda());            
            System.out.println("ejecutando query:" + SQL_INSERT);            
            rows = stmt.executeUpdate();
            
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            //cerramos conexiones
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        //retorna el numero de columnas que seria "1"
        return rows;
    }

//metodo que actualiza en la base de datos
    public int update(Votacion votaciones) {
        //conecta a base de datos
        Connection conn = null;
        //prepara la instruciion sql que recibe los registros de la base de datos
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            
            conn = Conexion.getConnection();
            
            System.out.println("ejecutando query: " + SQL_UPDATE);
            
            stmt = conn.prepareStatement(SQL_UPDATE);
            
            stmt.setInt(1, votaciones.getNo_ronda());
            stmt.setInt(2, votaciones.getId_candidato());
            stmt.setInt(3, votaciones.getVotos_ronda());
            stmt.setInt(4, votaciones.getId_votacion());
            
           
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

    public int delete(Votacion votaciones) {
        //conecta a base de datos
        Connection conn = null;
        //prepara stmt de instruccion de sql que se pasa a base de datos
        PreparedStatement stmt = null;
        int rows = 0;
         //try y catch que evita errores
        try {
            //abre base de datos
            conn = Conexion.getConnection();
            //imprimimos en consola que se ejecutara un delete
            System.out.println("Ejecutando query:" + SQL_DELETE);
            //preparamos el stmt para delete, aqui se pasa la info
            stmt = conn.prepareStatement(SQL_DELETE);
            //delete solo tiene un comodin porque aqui con el carnet elimina todo el registro
            stmt.setInt(1, votaciones.getId_votacion());
            //ejecuta comando y borra registro
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            //cierra conexion
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public Votacion query(Votacion votaciones) { 
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, votaciones.getId_votacion());
            rs = stmt.executeQuery();
            if (rs.next()) {
                votaciones.setNo_ronda(rs.getInt("no_ronda"));
                votaciones.setId_candidato(rs.getInt("id_candidato"));
                votaciones.setVotos_ronda(rs.getInt("votos_ronda"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return votaciones;
    }
}
