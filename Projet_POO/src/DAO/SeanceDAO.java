/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.*;
import java.util.*;
import Model.Seance;
import Projet_POO.DBConnect;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bauti
 */
public class SeanceDAO extends DAO<Seance> {

    public SeanceDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean creer(Seance obj) {

        Scanner sc = new Scanner(System.in);
        int semaine = sc.nextInt();

        String dateString = sc.nextLine();

        SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");

        try {
            java.util.Date date = format.parse(dateString);
        } catch (ParseException ex) {
            Logger.getLogger(SeanceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        java.util.Date date = sc.next();

        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        java.sql.Time sqlTime = new java.sql.Time(date.getTime());

        int semaine = sc.nextInt();

        int semaine = sc.nextInt();

        int semaine = sc.nextInt();

        int semaine = sc.nextInt();

        try {

            int insertCount = statement.executeUpdate("INSERT INTO SEANCE VALUES('NOM','CAPACITE','ID_SITE')");

            PreparedStatement pstmt = this.connect.prepareStatement("INSERT INTO SEANCE VALUES(?,?,?,?,?,?,?)");

            //On affiche la requête exécutée
            System.out.println(pstmt.toString());

            System.out.println("Inserted test_value successfully : " + insertCount);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return false;
    }

    @Override
    public boolean supprimer(Seance obj) {
        try {
            PreparedStatement st = this.connect.prepareStatement("DELETE FROM seance WHERE ID=?");
            st.setInt(1, obj.getId());
            st.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return false;
    }

    @Override
    public boolean modifier(Seance obj) {
//        Scanner sc=new Scanner(System.in);
//        String NOM=obj.getNom();
//        int CAPACITE, ID_SITE;
//        
//        System.out.println("Entrez le nouveau nom de la salle. Si pas de changement, n'entrez aucune valeur");
//        NOM = sc.nextLine();
//        if(NOM == "")
//            NOM=obj.getNom();
//        else
//            obj.setNom(NOM);
//       
//        System.out.println("Entrez la nouvelle capacité de la salle");
//        int CAPACITE = sc.nextInt();
//        System.out.println("Entrez le nouvel ID du site de la salle");
//        int ID_SITE = sc.nextInt();    
//        
//        try {
//            Statement statement = this.connect.createStatement();
//
//            int insertCount = statement.executeUpdate("INSERT INTO SALLE VALUES('NOM','CAPACITE','ID_SITE')");
//
//            System.out.println("Inserted test_value successfully : " + insertCount);
//        } catch (Exception ex) {
//            System.out.println(ex);
//        }

        return false;
    }

    @Override
    public Seance trouver(int id) {
        Seance seance = null;

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM seance WHERE ID = " + id);
            if (result.first()) {
                seance = new Seance(
                        id,
                        result.getInt("SEMAINE"),
                        result.getDate("DATE"),
                        result.getTime("HEURE_DEBUT"),
                        result.getTime("HEURE_FIN"),
                        result.getInt("ETAT"),
                        result.getInt("ID_COURS"),
                        result.getInt("ID_TYPE")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return salle;
    }
}
