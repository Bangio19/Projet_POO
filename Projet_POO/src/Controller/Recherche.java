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
    
    public ArrayList<Seance> consulter_cours__etudiant(int id_utilisateur, int semaine)
    {
        DBConnect conn = new DBConnect();
        Connection connect=conn.getCon(); 

        SeanceGroupeDAO seancegrpDao = new SeanceGroupeDAO(connect);
        SeanceDAO seanceDAO = new SeanceDAO(connect);
        
        EtudiantDAO eleveDAO = new EtudiantDAO(connect);
        Etudiant eleve = eleveDAO.trouver(id_utilisateur);
        int id_groupe = eleve.getIdGroupe();
        
        ArrayList<SeanceGroupe> listSeanGrp = new ArrayList<SeanceGroupe>();
        
        listSeanGrp = seancegrpDao.trouver_tous_les_groupes(id_groupe);
        
        ArrayList<Seance> listeSeance = new ArrayList<Seance>();
        for(int i=0; i< listSeanGrp.size(); i++){
            Seance s = seanceDAO.trouver(listSeanGrp.get(i).getIdSeance());
            listeSeance.add(s);
        }
        for(int i=0 ; i< listeSeance.size(); i++){
            if(listeSeance.get(i).getSemaine()!= semaine)
            {
                listeSeance.remove(i);
            }
        }
        return listeSeance;
        
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
