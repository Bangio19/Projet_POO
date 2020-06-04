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
    
    
    public void consulter_cours_enseignant(Enseignant prof, int semaine)
    {
        
        DAO<Seance> SeanceDao = new SeanceDAO(connect);
 
    }
    
    public void consulter_cours_etudiant(Etudiant eleve, int semaine)
    {
        
        DAO<Seance> SeanceDao = new SeanceDAO(connect);
 
    }   
    public void consulter_cours_annule_etudiant(Etudiant eleve, int semaine)
    {
        
        DAO<Seance> SeanceDao = new SeanceDAO(connect);
 
    } 
    
    public void consulter_cours_groupe(Groupe grp, int semaine)
    {
        
        DAO<Seance> SeanceDao = new SeanceDAO(connect);
 
    } 
    
    public void consulter_cours_promo(Promotion promo, int semaine)
    {
        
        DAO<Seance> SeanceDao = new SeanceDAO(connect);
 
    } 
    
    public void consulter_cours_salle(Salle salle, int semaine)
    {
        
        DAO<Seance> SeanceDao = new SeanceDAO(connect);
 
    } 
    
    public void recapitulatif_cours_enseignant(Enseignant prof, java.util.Date d_debut, java.util.Date d_fin)
    {
        
        DAO<Seance> SeanceDao = new SeanceDAO(connect);
 
    } 
    
}
