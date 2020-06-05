/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.*;
import Model.*;
import Projet_POO.DBConnect;
import java.sql.*;


/**
 *
 * @author adrie
 */
public class Mise_a_jour {
    
    public void affecter_enseignant_a_seance(Enseignant prof, Seance seance)
    {
        DBConnect conn = new DBConnect();
        Connection connect=conn.getCon();        
        SeanceDAO seanceDAO = new SeanceDAO(connect);
 
    }
    public void affecter_groupe_a_seance(Groupe grp, Seance seance)
    {
        DBConnect conn = new DBConnect();
        Connection connect=conn.getCon();        
        SeanceDAO seanceDAO = new SeanceDAO(connect);
 
    }
    
    public void modif_nom_cours_dans_seance(Cours cours, Seance seance)
    {
        DBConnect conn = new DBConnect();
        Connection connect=conn.getCon();        
        SeanceDAO seanceDAO = new SeanceDAO(connect);
 
        seance.setIdCours(cours.getId());
        seanceDAO.modifier(seance);
    }
    
    public void modif_type_cours_dans_seance(TypeCours typeCours, Seance seance)
    {
        DBConnect conn = new DBConnect();
        Connection connect=conn.getCon();        
        SeanceDAO seanceDAO = new SeanceDAO(connect);
 
        seance.setIdType(typeCours.getId());
        seanceDAO.modifier(seance);
    }
    
    public void affecter_salle_a_seance(Salle salle, Seance seance)
    {
        DBConnect conn = new DBConnect();
        Connection connect=conn.getCon();        
        SeanceDAO seanceDAO = new SeanceDAO(connect);
 
    }    
    
    public void deplacer_seance(Seance seance)
    {
        DBConnect conn = new DBConnect();
        Connection connect=conn.getCon();        
        SeanceDAO seanceDAO = new SeanceDAO(connect);
 
    } 
    
    public void ajouter_seance(Seance seance)
    {
        DBConnect conn = new DBConnect();
        Connection connect=conn.getCon();        
        SeanceDAO seanceDAO = new SeanceDAO(connect);
 
    }
    
    public void ajouter_enseignant_a_seance(Enseignant prof, Seance seance)
    {
        DBConnect conn = new DBConnect();
        Connection connect=conn.getCon();        
        SeanceDAO seanceDAO = new SeanceDAO(connect);
 
    }
    public void ajouter_groupe_a_seance(Groupe grp, Seance seance)
    {
        DBConnect conn = new DBConnect();
        Connection connect=conn.getCon();        
        SeanceDAO seanceDAO = new SeanceDAO(connect);
 
    }
    public void annuler_seance(Seance seance)
    {
        DBConnect conn = new DBConnect();
        Connection connect=conn.getCon();        
        SeanceDAO seanceDAO = new SeanceDAO(connect);
        
        seance.setEtat(0);
        seanceDAO.modifier(seance);
 
    }
    public void valider_seance(Seance seance)
    {
        DBConnect conn = new DBConnect();
        Connection connect=conn.getCon();        
        SeanceDAO seanceDAO = new SeanceDAO(connect);
 
        seance.setEtat(1);
        seanceDAO.modifier(seance);
    }
    public void enlever_groupe_a_seance(SeanceGroupe seancegrp)
    {
        DBConnect conn = new DBConnect();
        Connection connect=conn.getCon();        
        SeanceGroupeDAO seancegrpDAO = new SeanceGroupeDAO(connect);
        
        seancegrpDAO.supprimer(seancegrp);
 
    }
    public void enlever_enseignant_a_seance(SeanceEnseignant seanceEns)
    {
        DBConnect conn = new DBConnect();
        Connection connect=conn.getCon();        
        SeanceEnseignantDAO seanceEnsDAO = new SeanceEnseignantDAO(connect);
        
        seanceEnsDAO.supprimer(seanceEns);
 
    }
    public void enlever_groupe_et_enseignant_a_seance(SeanceGroupe seancegrp, SeanceEnseignant seanceEns)
    {
        DBConnect conn = new DBConnect();
        Connection connect=conn.getCon();         
        SeanceGroupeDAO seancegrpDAO = new SeanceGroupeDAO(connect);
        
        seancegrpDAO.supprimer(seancegrp);
       
        SeanceEnseignantDAO seanceEnsDAO = new SeanceEnseignantDAO(connect);
        
        seanceEnsDAO.supprimer(seanceEns);
    }
}
