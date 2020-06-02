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
        try {
            Statement statement = this.connect.createStatement();
            int ID_UTILISATEUR = obj.getId();
            ArrayList<Cours> ID_COURS = obj.getCours();
            int insertCount = statement.executeUpdate("INSERT INTO PROMOTION VALUES('NUMERO','ID_GROUPE')");

            System.out.println("Inserted test_value successfully : " + insertCount);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return false;
    }
    
    @Override
    public boolean supprimer(Enseignant obj) {
        try {
            Statement statement = this.connect.createStatement();

            PreparedStatement st = this.connect.prepareStatement("DELETE FROM ETUDIANT WHERE ID=?");
            st.setInt(1, obj.getId());
            st.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex);
        }
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
                etudiant = new Etudiant(id, result.getInt("NUMERO"), result.getInt("ID_GROUPE"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return enseignant;
    }
}
