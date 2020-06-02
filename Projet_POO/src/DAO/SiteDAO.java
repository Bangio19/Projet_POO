/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.*;
import Model.Site;
import Projet_POO.DBConnect;
import java.util.Scanner;
/**
 *
 * @author Bauti
 */
public class SiteDAO extends DAO<Site>{
    public SiteDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean creer(Site obj) {
        //Reste à modifier
        try {
            Statement statement = this.connect.createStatement();
            String NOM = obj.getNom();
            
            int insertCount = statement.executeUpdate("INSERT INTO salle(NOM) VALUES('"+NOM+"')");

            System.out.println("Inserted test_value successfully : " + insertCount);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return false;
    }

    @Override
    public boolean supprimer(Site obj) {
        try {
            PreparedStatement st = this.connect.prepareStatement("DELETE FROM site WHERE ID=?");
            st.setInt(1, obj.getId());
            st.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return false;
    }

    @Override
    public boolean modifier(Site obj) {
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
    public Site trouver(int id) {
        Site site = null;

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM site WHERE ID = " + id);
            if (result.first()) {
                site = new Site(
                        id,
                        result.getString("NOM")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return site;
    }
}
