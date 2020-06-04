/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Groupe;
import java.sql.*;
import java.util.*;
/**
 *
 * @author adrie
 */
public class GroupeDAO extends DAO<Groupe>{
    public GroupeDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean creer(Groupe obj) {
        
        return false;
    }
    
    @Override
    public boolean supprimer(Groupe obj) {
        
        return false;
    }

    @Override
    public boolean modifier(Groupe obj) 
    {
        return false;
    }

    @Override
    public Groupe trouver(int id) {
        Groupe groupe = null;

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM groupe WHERE ID = " + id);
            if (result.first()) 
            {
                groupe = new Groupe(id, result.getString("NOM"), result.getInt("ID_PROMOTION"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return groupe;
    }
}
