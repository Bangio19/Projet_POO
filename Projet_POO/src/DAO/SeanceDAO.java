/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.*;
import java.util.*;
import Model.Seance;

/**
 *
 * @author Bauti
 */
public class SeanceDAO {

    private Connection connect = null;

    public SeanceDAO(Connection conn) {
        this.connect = conn;
    }

    //CREER UNE SEANCE
    public boolean creer(int semaine, java.util.Date date, Time heure_debut, Time heure_fin, int etat, int id_cours, int id_type) {

        try {
            PreparedStatement pst = null;
            
            pst  = this.connect.prepareStatement("INSERT INTO `seance` (`ID`, `SEMAINE`, `DATE`, `HEURE_DEBUT`, `HEURE_FIN`, `ETAT`, `ID_COURS`, `ID_TYPE`) "
                    + "VALUES (NULL, ?, ?,?,?,?,?,?) ");
            pst.setInt(1, semaine);
            pst.setDate(2, (java.sql.Date) date);
            pst.setTime(3, heure_debut);
            pst.setTime(4, heure_fin);
            pst.setInt(5, etat);
            pst.setInt(6, id_cours);
            pst.setInt(7, id_type);
            System.out.println(pst.toString());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return false;
    }

    //SUPPRIMER UNE SEANCE
    public boolean supprimer(Seance obj) {
        try {
            PreparedStatement st = this.connect.prepareStatement("DELETE FROM seance WHERE ID=?");
            st.setInt(1, obj.getId());
            st.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return false;
    }

    //MODIFIER UNE SEANCE
    public boolean modifier(Seance obj) {
        try {
            PreparedStatement pst = null;
            ResultSet rs = null;

            int id = obj.getId();
            int semaine = obj.getSemaine();
            java.util.Date date = obj.getDate();
            Time heure_debut = obj.getHeureDebut();
            Time heure_fin = obj.getHeureFin();
            int etat = obj.getEtat();
            int id_cours = obj.getIdCours();
            int id_type = obj.getIdType();
            
            pst = this.connect.prepareStatement("update seance set SEMAINE=?, DATE=?, HEURE_DEBUT=?, HEURE_FIN=?, ETAT=?, ID_COURS=?, ID_TYPE=? where ID=? ");
            pst.setInt(1,semaine);
            pst.setDate(2, (java.sql.Date) date);
            pst.setTime(3,heure_debut);
            pst.setTime(4,heure_fin);
            pst.setInt(5,etat);
            pst.setInt(6,id_cours);
            pst.setInt(7,id_type);
            pst.setInt(8,id);
            pst.executeUpdate();
            
            System.out.println("Inserted test_value successfully ");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    //TROUVER UNE SEANCE
    public Seance trouver(int id) {
        Seance seance = null;

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM seance WHERE ID = " + id);
            if (result.first()) {
                seance = new Seance(
                        id,
                        result.getInt("SEMAINE"),
                        result.getDate("DATE"),
                        result.getTime("HEURE_DEBUT"),
                        result.getTime("HEURE_FIN"),
                        result.getInt("ETAT"),
                        result.getInt("ID_COURS"),
                        result.getInt("ID_TYPE")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seance;
    }
}
