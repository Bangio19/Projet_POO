/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Promotion;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Bauti
 */
public class PromotionDAO extends DAO<Promotion>{
    
    public PromotionDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean creer(Promotion obj) {
        try {
            Statement statement = this.connect.createStatement();
            String NOM = obj.getNom();
            
            int insertCount = statement.executeUpdate("INSERT INTO promotion(NOM) VALUES('"+NOM+"')");

            System.out.println("Inserted test_value successfully : " + insertCount);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return false;
    }
    
    @Override
    public boolean supprimer(Promotion obj) {
        
        return false;
    }

    @Override
    public boolean modifier(Promotion obj) 
    {
        return false;
    }

    @Override
    public Promotion trouver(int id) {
        Promotion promo = null;

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM promotion WHERE ID = " + id);
            if (result.first()) 
            {
                promo = new Promotion(id, result.getString("NOM"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return promo;
    }
}
