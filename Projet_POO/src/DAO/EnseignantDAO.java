/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Cours;
import Model.Enseignant;
import java.sql.*;
import java.util.*;
/**
 *
 * @author Bauti
 */
public class EnseignantDAO extends DAO<Enseignant>{
    
    public EnseignantDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean creer(Enseignant obj) {
        //Reste à modifier
        
        return false;
    }
    
    @Override
    public boolean supprimer(Enseignant obj) {
        
        return false;
    }

    @Override
    public boolean modifier(Enseignant obj) 
    {
        return false;
    }

    @Override
    public Enseignant trouver(int id) {
        Enseignant enseignant = null;

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM promotion WHERE ID = " + id);
            if (result.first()) 
            {
                enseignant = new Enseignant(result.getInt("ID_UTILISATEUR"), result.getInt("ID_COURS"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return enseignant;
    }
}
