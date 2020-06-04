/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.SeanceGroupe;
import java.sql.*;
import java.util.Scanner;
/**
 *
 * @author Bauti
 */
public class SeanceGroupeDAO extends DAO<SeanceGroupe>{
    public SeanceGroupeDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean creer(SeanceGroupe obj) {
        
        Scanner sc = new Scanner(System.in);
        try {
            Statement statement = this.connect.createStatement();
            
            System.out.println("Saisir Id Seance");
            int id_seance = sc.nextInt();
            
            System.out.println("Saisir Id de l'Enseignatn");
            int id_groupe = sc.nextInt();
            

            int insertCount = statement.executeUpdate("INSERT INTO seance_groupes VALUES('" +id_seance+ "','"+id_groupe+"')");

            System.out.println("Inserted test_value successfully : " + insertCount);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return false;
    }
    
    @Override
    public boolean modifier(SeanceGroupe obj){
        try {
            Statement statement = this.connect.createStatement();
            int id_groupe = obj.getIdGroupe();
            int id_seance = obj.getIdSeance();

            int insertCount = statement.executeUpdate("UPDATE seance_groupes SET ID_GROUPE='"+id_groupe+"' WHERE ID_SEANCE='" +id_seance+ "'");

            System.out.println("Inserted test_value successfully : " + insertCount);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return false;
    }
    
    @Override
    public boolean supprimer(SeanceGroupe obj){
        try {
            PreparedStatement st = this.connect.prepareStatement("DELETE FROM seance_groupes WHERE ID=?");
            st.setInt(1, obj.getIdSeance());
            st.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return false;
    }
    
    @Override
    public SeanceGroupe trouver(int id_s){
        SeanceGroupe seanceGr = null;

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM seance_groupes WHERE ID_SEANCE = " + id_s);
            if (result.first()) {
                seanceGr = new SeanceGroupe(
                        id_s,
                        result.getInt("ID_GROUPE")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seanceGr;
    }
}
