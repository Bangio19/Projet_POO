/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Model.*;
import java.sql.*;
import java.util.*;
/**
 *
 * @author Bauti
 */
public class CoursDAO extends DAO<Cours>{
    public CoursDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean creer(Cours obj) {
        //Reste à modifier
        
        return false;
    }
    
    @Override
    public boolean supprimer(Cours obj) {
        
        return false;
    }

    @Override
    public boolean modifier(Cours obj) 
    {
        return false;
    }

    @Override
    public Cours trouver(int id) {
        Cours cours = null;

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM cours WHERE ID = " + id);
            if (result.first()) 
            {
                cours = new Cours(id, result.getString("NOM"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cours;
    }
}
