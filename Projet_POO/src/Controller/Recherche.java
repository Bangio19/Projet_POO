/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Projet_POO.*;
import DAO.*;
import Model.*;
import java.util.*;
import java.sql.*;
import Projet_POO.DBConnect;
import java.text.*;


/**
 *
 * @author adrie
 */
public class Recherche {
    //ArrayList<Seance> listSeance= new ArrayList<Seance>();
    
    /**
     * Consulte les cours d'un enseignant
     * @param id 
     */
    public void consulter_cours_enseignant(int id)
    {
        DBConnect conn = new DBConnect();
        Connection connect=conn.getCon(); 
        
        EnseignantDAO e = new EnseignantDAO(connect);
        SeanceDAO Se = new SeanceDAO(connect);
        SeanceEnseignantDAO sg = new SeanceEnseignantDAO(connect);
        
        Enseignant en;
        Seance sea;
        SeanceEnseignant seen;        
        
    }
  
    public void consulter_cours_annule_etudiant(Etudiant eleve, int semaine)
    {
        DBConnect conn = new DBConnect();
        Connection connect=conn.getCon(); 

        SeanceDAO SeanceDao = new SeanceDAO(connect);
 
    } 
    
    public void consulter_cours_groupe(Groupe grp, int semaine)
    {
        DBConnect conn = new DBConnect();
        Connection connect=conn.getCon(); 

        SeanceDAO SeanceDao = new SeanceDAO(connect);
 
    } 
    
    public void consulter_cours_promo(Promotion promo, int semaine)
    {
        DBConnect conn = new DBConnect();
        Connection connect=conn.getCon(); 

        SeanceDAO SeanceDao = new SeanceDAO(connect);
 
    } 
    
    public void consulter_cours_salle(Salle salle, int semaine)
    {
        DBConnect conn = new DBConnect();
        Connection connect=conn.getCon(); 

        SeanceDAO SeanceDao = new SeanceDAO(connect);
 
    } 
    
    public void recapitulatif_cours_enseignant(Enseignant prof, java.util.Date d_debut, java.util.Date d_fin)
    {
        DBConnect conn = new DBConnect();
        Connection connect=conn.getCon(); 

        SeanceDAO SeanceDao = new SeanceDAO(connect);
 
    } 
    
    /**
     * renvoie le jour de la semaine. Le compteur commence par Dimanche à 1
     * @param seance
     * @return int
     */
    public int jourSemaine(Seance seance){
        DBConnect conn = new DBConnect();
        Connection connect = conn.getCon();
        SeanceDAO seanceDAO = new SeanceDAO(connect);
        
        Calendar c1 = Calendar.getInstance();
        c1.setTimeZone(TimeZone.getTimeZone("Europe/Paris"));
        c1.setTime(seance.getDate());
        
        return c1.get(Calendar.DAY_OF_WEEK);
    }
    
    /**
     * renvoie tous les utilisateurs
     * @return ArrayList
     */
    public ArrayList getAllUsers(){
        DBConnect conn = new DBConnect();
        Connection connect = conn.getCon();
        UtilisateurDAO user = new UtilisateurDAO(connect);
        
       ArrayList<Utilisateur> users = user.trouverTous();
       return users;
    }
    
    /**
     * renvoie toutes les seances existantes
     * @return ArrayList
     */
    public ArrayList getAllSeances(){
        DBConnect conn = new DBConnect();
        Connection connect = conn.getCon();
        SeanceDAO seanceDAO = new SeanceDAO(connect);
        
       ArrayList<Seance> seances = seanceDAO.trouverTous();
       return seances;
    }
    
    /**
     * Renvoie le nom d'un cours
     * @param id
     * @return String
     */
    public String getCoursName(int id){
        DBConnect conn = new DBConnect();
        Connection connect = conn.getCon();
        CoursDAO coursDAO = new CoursDAO(connect);
        Cours cours = coursDAO.trouver(id);
        
        return cours.getNom();
        
    }

    public ArrayList<Groupe> getAllGroups() {
         DBConnect conn = new DBConnect();
        Connection connect = conn.getCon();
        GroupeDAO groupeDAO = new GroupeDAO(connect);
        
       ArrayList<Groupe> groups = groupeDAO.trouverTous();
       return groups;
    }
    
    public String getPromoName(int id){
        DBConnect conn = new DBConnect();
        Connection connect = conn.getCon();
        PromotionDAO promoDAO = new PromotionDAO(connect);
        Promotion promo = promoDAO.trouver(id);
        
        return promo.getNom();
        
    }
}
