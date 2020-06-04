/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Etudiant;
import java.sql.*;
import java.util.*;
/**
 *
 * @author Bauti
 */
public class EtudiantDAO extends DAO<Etudiant>{
    
    public EtudiantDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean creer(Etudiant obj) {
        //Reste à modifier
        
        return false;
    }
    
    @Override
    public boolean supprimer(Etudiant obj) {
        
        return false;
    }

    @Override
    public boolean modifier(Etudiant obj) 
    {
        return false;
    }

    @Override
    public Etudiant trouver(int id) {
        Etudiant etudiant = null;

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM etudiant WHERE ID_UTILISATEUR = " + id);
            if (result.first()) 
            {
                etudiant = new Etudiant(id, result.getInt("NUMERO"), result.getInt("ID_GROUPE"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return etudiant;
    }
}
