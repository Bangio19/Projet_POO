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
    public boolean creer(int semaine, java.util.Date date, Time heure_debut, Time heure_fin, int etat, int id_cours, int id_type) throws SQLException {
        PreparedStatement pst = null;
        try {

            pst = this.connect.prepareStatement("INSERT INTO `seance` (`ID`, `SEMAINE`, `DATE`, `HEURE_DEBUT`, `HEURE_FIN`, `ETAT`, `ID_COURS`, `ID_TYPE`) "
                    + "VALUES (NULL, ?, ?,?,?,?,?,?) ");
            pst.setInt(1, semaine);
            pst.setDate(2, (java.sql.Date) date);
            pst.setTime(3, heure_debut);
            pst.setTime(4, heure_fin);
            pst.setInt(5, etat);
            pst.setInt(6, id_cours);
            pst.setInt(7, id_type);

            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            if (pst != null) {
                pst.close();
            }
        }
        return false;
    }

    //SUPPRIMER UNE SEANCE
    public boolean supprimer(Seance obj) throws SQLException {
        PreparedStatement st = null;
        try {
            st = this.connect.prepareStatement("DELETE FROM seance WHERE ID=?");
            st.setInt(1, obj.getId());
            st.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            if (st != null) {
                st.close();
            }
        }
        return false;
    }

    public int getId(java.util.Date date, Time heureD, Time heureF, int id_cours, int id_type) throws SQLException {

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT ID FROM seance WHERE DATE='" + date + "' AND HEURE_DEBUT='" + heureD + "' "
                            + "AND HEURE_FIN='" + heureF + "' AND ID_COURS='" + id_cours + "' AND ID_TYPE='" + id_type + "' ");
            System.out.println("Infos du result: " + result);

            if (result.next()) {
                System.out.println("ce qu'on recup normalement " + result.getInt("ID"));

                return result.getInt("ID");
            }
            System.out.println("LOLOLOL");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.connect.close();
        }
        return 0;
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
            pst.setInt(1, semaine);
            pst.setDate(2, (java.sql.Date) date);
            pst.setTime(3, heure_debut);
            pst.setTime(4, heure_fin);
            pst.setInt(5, etat);
            pst.setInt(6, id_cours);
            pst.setInt(7, id_type);
            pst.setInt(8, id);
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
            if (result.next()) {
                seance = new Seance(
                        id,
                        result.getInt("Semaine"),
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

    public Seance trouver(int id, Connection con) {
        Seance seance = null;
        System.out.println("l'id reçu: " + id);
        this.connect = con;
        try {
            ResultSet result = null;
            Statement st = this.connect.createStatement();
            result = st.executeQuery("SELECT * FROM seance WHERE ID = " + id);
            System.out.println("Infos du result: " + result);

            if (result.next()) {
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
                System.out.println("Dans seance trouver:" + result.getInt("ID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seance;
    }
    
    public ArrayList trouverTous() {
        ArrayList<Seance> seances = new ArrayList<>();
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM seance ");

            while (result.next()) {
                for (int i = 1; i < 2; i++) {
                    Seance uneSeance = this.trouver(result.getInt("ID"));//new Utilisateur(result.getInt("ID"),result.getString("EMAIL"), result.getString("MDP"), result.getString("NOM"), result.getString("PRENOM"), result.getInt("DROIT"));
                    seances.add(uneSeance);
                }
            }
        } catch (SQLException ex) {
            //Logger.getLogger(EleveDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return seances;
    }
}
