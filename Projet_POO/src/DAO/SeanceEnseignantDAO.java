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
public class SeanceEnseignantDAO  {

    private Connection connect;

    public SeanceEnseignantDAO(Connection conn) {
        this.connect = conn;
    }

      
    public boolean creer(SeanceEnseignant obj) {

        Scanner sc = new Scanner(System.in);
        try {
            Statement statement = this.connect.createStatement();

            System.out.println("Saisir Id Seance");
            int id_seance = sc.nextInt();

            System.out.println("Saisir Id de l'Enseignatn");
            int id_enseignant = sc.nextInt();

            int insertCount = statement.executeUpdate("INSERT INTO seance_enseignants VALUES('" + id_seance + "','" + id_enseignant + "')");

            System.out.println("Inserted test_value successfully : " + insertCount);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return false;
    }

      
    public boolean modifier(SeanceEnseignant obj) {
        try {
            Statement statement = this.connect.createStatement();
            int id_enseignant = obj.getIdEnseignant();
            System.out.println(id_enseignant);
            int id_seance = obj.getIdSeance();

            int insertCount = statement.executeUpdate("UPDATE seance_enseignants SET ID_ENSEIGNANT='" + id_enseignant + "' WHERE ID_SEANCE='" + id_seance + "' ");

            System.out.println("Inserted test_value successfully : " + insertCount);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return false;
    }

      
    public boolean supprimer(SeanceEnseignant obj) {
        try {
            PreparedStatement st = this.connect.prepareStatement("DELETE FROM seance_enseignants WHERE ID_SEANCE=? AND ID_ENSEIGNANT=?");
            st.setInt(1, obj.getIdSeance());
            st.setInt(2, obj.getIdEnseignant());
            st.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return false;
    }

      
    public SeanceEnseignant trouver(int id_s) {
        SeanceEnseignant seanceEns = null;

        try {
//            ResultSet result = this.connect.createStatement(
//                    ResultSet.TYPE_SCROLL_INSENSITIVE,
//                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM seance_enseignants WHERE ID_SEANCE = " + id_s);
//            if (result.first()) {
//                seanceEns = new SeanceEnseignant(
//                        id_s,
//                        result.getInt("ID_ENSEIGNANT")
//                );
//                
//                System.out.println("id seance: "+id_s);
//                System.out.println("id seance: "+result.getInt("ID_ENSEIGNANT"));
//            }
            PreparedStatement pst = null;
            ResultSet rs = null;
            System.out.println("le int"+id_s);
            pst = this.connect.prepareStatement("select * from seance_enseignants where ID_SEANCE=? ");
            pst.setInt(1, id_s);
            rs = pst.executeQuery();
            System.out.println("rs: "+rs.getFetchSize());
            if (rs.next()) {
                seanceEns = new SeanceEnseignant( id_s, rs.getInt("ID_ENSEIGNANT")
                );
                System.out.println("le id enseig:"+rs.getInt("ID_ENSEIGNANT"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seanceEns;
    }
}
