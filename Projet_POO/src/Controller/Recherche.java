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
    
    
    public ArrayList<Seance> consulter_cours_enseignant(int id, int semaine)
    {
        DBConnect conn = new DBConnect();
        Connection connect=conn.getCon(); 
      
        SeanceDAO Se = new SeanceDAO(connect);
        SeanceEnseignantDAO sg = new SeanceEnseignantDAO(connect);
        
        Seance sea;
        SeanceEnseignant seen;
       
        ArrayList<SeanceEnseignant> L1 = new  ArrayList<SeanceEnseignant>();
        L1 = sg.toutSelect(id);
        
        ArrayList<Seance> L2 = new ArrayList<Seance>();
        Seance s;
        for(int i=0; i< L1.size(); i++){
            s = Se.trouver(L1.get(i).getIdSeance());
            L2.add(s);
        }
        for(int i=0 ; i< L2.size(); i++){
            if(L2.get(i).getSemaine()!= semaine){
                L2.remove(i);
            }
        }
        
      return L2;     
    }
    
    public int getPosition(Seance a){
        int position =  0;
        int jour = jourSemaine(a);
        if (jour == 2){
            
            
        }
        if (jour == 3){
            
        }
        if (jour == 4){
            
        }
        if (jour == 5){
            
        }
        if (jour == 6){
            
        }
        return position;
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
