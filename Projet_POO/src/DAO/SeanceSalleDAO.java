/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.SeanceSalle;
import java.sql.*;
import java.util.Scanner;
/**
 *
 * @author Bauti
 */
public class SeanceSalleDAO extends DAO<SeanceSalle>{
    public SeanceSalleDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean creer(SeanceSalle obj) {
        
        Scanner sc = new Scanner(System.in);
        try {
            Statement statement = this.connect.createStatement();
            
            System.out.println("Saisir Id Seance");
            int id_seance = sc.nextInt();
            
            System.out.println("Saisir Id de l'Enseignatn");
            int id_salle = sc.nextInt();
            

            int insertCount = statement.executeUpdate("INSERT INTO seance_salle VALUES('" +id_seance+ "','"+id_salle+"')");

            System.out.println("Inserted test_value successfully : " + insertCount);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return false;
    }
    
    @Override
    public boolean modifier(SeanceSalle obj){
        try {
            Statement statement = this.connect.createStatement();
            int id_salle = obj.getIdSalle();
            int id_seance = obj.getIdSeance();

            int insertCount = statement.executeUpdate("INSERT INTO seance_salle VALUES('" +id_seance+ "','"+id_salle+"')");

            System.out.println("Inserted test_value successfully : " + insertCount);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return false;
    }
    
    @Override
    public boolean supprimer(SeanceSalle obj){
        try {
            PreparedStatement st = this.connect.prepareStatement("DELETE FROM seance_salle WHERE ID=?");
            st.setInt(1, obj.getIdSeance());
            st.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return false;
    }
    
    @Override
    public SeanceSalle trouver(int id_s){
        SeanceSalle seanceSal = null;

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM seance_salle WHERE ID = " + id_s);
            if (result.first()) {
                seanceSal = new SeanceSalle(
                        id_s,
                        result.getInt("ID_SALLE")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seanceSal;
    }
}