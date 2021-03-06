/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.*;
import Model.Utilisateur;
import Projet_POO.DBConnect;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Bauti
 */
public class UtilisateurDAO {

    private Connection connect;

    public UtilisateurDAO(Connection conn) {
        this.connect = conn;
    }

    public boolean creer(Utilisateur obj) {
        //Reste à modifier
//        try {
//            String NOM = obj.getNom();
//            String EMAIL=obj.getEmail();
//            String MDP=obj.getMdp();
//            String PRENOM=obj.getPrenom();
//            int DROIT = obj.getDroit();
//            
//            PreparedStatement prepare = this.connect.prepareStatement("INSERT INTO utilisateur(EMAIL,MDP,NOM,PRENOM,DROIT) VALUES('"+EMAIL+"','"+MDP+"','"+NOM+"','"+PRENOM+"','"+DROIT+"')");
//            System.out.println("Inserted test_value successfully");
//        } catch (Exception ex) {
//            System.out.println(ex);
//        }
        return false;
    }

    public boolean supprimer(Utilisateur obj) {
        try {
            PreparedStatement st = this.connect.prepareStatement("DELETE FROM utilisateur WHERE ID=?");
            st.setInt(1, obj.getId());
            st.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return false;
    }

    public boolean modifier(Utilisateur obj) {
        return false;
    }

    public Utilisateur trouver(String email) {
        Utilisateur user = null;

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM utilisateur WHERE EMAIL = '" + email + "'");
            if (result.first()) {
                user = new Utilisateur(
                        result.getInt("ID"),
                        email,
                        result.getString("MDP"),
                        result.getString("NOM"),
                        result.getString("PRENOM"),
                        result.getInt("DROIT")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public Utilisateur trouver(int id) {
        Utilisateur user = null;

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM utilisateur WHERE ID = '" + id + "'");
            if (result.first()) {
                user = new Utilisateur(
                        id,
                        result.getString("EMAIL"),
                        result.getString("MDP"),
                        result.getString("NOM"),
                        result.getString("PRENOM"),
                        result.getInt("DROIT")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public ArrayList trouverTous() {
        ArrayList<Utilisateur> enseignants = new ArrayList<>();
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM utilisateur WHERE DROIT = 3 ");

            while (result.next()) {
                for (int i = 1; i < 2; i++) {
                    Utilisateur ens = this.trouver(result.getInt("ID"));//new Utilisateur(result.getInt("ID"),result.getString("EMAIL"), result.getString("MDP"), result.getString("NOM"), result.getString("PRENOM"), result.getInt("DROIT"));
                    enseignants.add(ens);
                }
            }
        } catch (SQLException ex) {
            //Logger.getLogger(EleveDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return enseignants;
    }
}
