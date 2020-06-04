/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.*;
import java.util.*;
import Model.Seance;



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

        try {
            Statement statement = this.connect.createStatement();
            int semaine = obj.getSemaine();
            java.util.Date date= obj.getDate();
            Time heure_d = obj.getHeureDebut(); 
            Time heure_f = obj.getHeureFin(); 
            int etat = obj.getEtat();
            int id_cours = obj.getIdCours();
            int id_type = obj.getIdType();
            System.out.println("La date" +date);
            int insertCount = statement.executeUpdate("INSERT INTO seance(SEMAINE, DATE, HEURE_DEBUT, HEURE_FIN, ETAT, ID_COURS, ID_TYPE) VALUES('"+semaine+"', '"+date+"','"+heure_d+"','"+heure_f+"','"+etat+"','"+id_cours+"','"+id_type+"')");
            System.out.println("Inserted test_value successfully : " + insertCount);
            
        } catch (SQLException ex) {
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
        } catch (SQLException ex) {
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

    public boolean modifier_seance(Seance obj)
    {
        
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
        return seance;
    }
}
