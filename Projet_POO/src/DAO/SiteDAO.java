/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.*;
import Model.Site;
import Projet_POO.DBConnect;
import java.util.Scanner;
/**
 *
 * @author Bauti
 */
public class SiteDAO {
    private Connection connect;

    public SiteDAO(Connection conn) {
        this.connect = conn;
    }

      
    public boolean creer(Site obj) {
        //Reste à modifier
        
        // TODO : vider la méthode
        try {
            Statement statement = this.connect.createStatement();
            String NOM = obj.getNom();
            
            int insertCount = statement.executeUpdate("INSERT INTO salle(NOM) VALUES('"+NOM+"')");

            System.out.println("Inserted test_value successfully : " + insertCount);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return false;
    }

      
    public boolean supprimer(Site obj) {
        try {
            PreparedStatement st = this.connect.prepareStatement("DELETE FROM site WHERE ID=?");
            st.setInt(1, obj.getId());
            st.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return false;
    }

      
    public boolean modifier(Site obj) {


        return false;
    }

      
    public Site trouver(int id) {
        Site site = null;

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM site WHERE ID = " + id);
            if (result.first()) {
                site = new Site(
                        id,
                        result.getString("NOM")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return site;
    }
}
