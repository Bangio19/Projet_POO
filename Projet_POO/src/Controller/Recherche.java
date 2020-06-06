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
   
    
    public void consulter_cours_etudiant(int id, int semaine)
    {
         
       DBConnect conn = new DBConnect();
      Connection connect=conn.getCon();
      
      EtudiantDAO e = new EtudiantDAO(connect);
      SeanceGroupeDAO sg = new SeanceGroupeDAO(connect);
      SeanceDAO s = new SeanceDAO(connect);
      
      Etudiant etud;
      Seance sean;
      SeanceGroupe seangrou;
      
      etud = e.trouver(id);
 
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
    
    public int jourSemaine(Seance seance){
        DBConnect conn = new DBConnect();
        Connection connect = conn.getCon();
        SeanceDAO seanceDAO = new SeanceDAO(connect);
        
        Calendar c1 = Calendar.getInstance();
        c1.setTimeZone(TimeZone.getTimeZone("Europe/Paris"));
        c1.setTime(seance.getDate());
        
        return c1.get(Calendar.DAY_OF_WEEK);
    }
}
