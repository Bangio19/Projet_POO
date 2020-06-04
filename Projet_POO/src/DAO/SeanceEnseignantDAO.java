/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.SeanceEnseignant;
import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author Bauti
 */
public class SeanceEnseignantDAO extends DAO<SeanceEnseignant> {

    public SeanceEnseignantDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean creer(SeanceEnseignant obj) {
        
        Scanner sc = new Scanner(System.in);
        try {
            Statement statement = this.connect.createStatement();
            
            System.out.println("Saisir Id Seance");
            int id_seance = sc.nextInt();
            
            System.out.println("Saisir Id de l'Enseignatn");
            int id_enseignant = sc.nextInt();
            

            int insertCount = statement.executeUpdate("INSERT INTO seance_enseignant VALUES('" +id_seance+ "','"+id_enseignant+"')");

            System.out.println("Inserted test_value successfully : " + insertCount);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return false;
    }
    
    @Override
    public boolean modifier(SeanceEnseignant obj){
        try {
            Statement statement = this.connect.createStatement();
            int id_enseignant = obj.getIdEnseignant();
            int id_seance = obj.getIdSeance();

            int insertCount = statement.executeUpdate("INSERT INTO seance_enseignant VALUES('" +id_seance+ "','"+id_enseignant+"')");

            System.out.println("Inserted test_value successfully : " + insertCount);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return false;
    }
    
    @Override
    public boolean supprimer(SeanceEnseignant obj){
        try {
            PreparedStatement st = this.connect.prepareStatement("DELETE FROM seance_enseignant WHERE ID=?");
            st.setInt(1, obj.getIdSeance());
            st.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return false;
    }
    
    @Override
    public SeanceEnseignant trouver(int id_s){
        SeanceEnseignant seanceEns = null;

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM seance_enseignant WHERE ID = " + id_s);
            if (result.first()) {
                seanceEns = new SeanceEnseignant(
                        id_s,
                        result.getInt("ID_ENSEIGNANT")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seanceEns;
    }
}
