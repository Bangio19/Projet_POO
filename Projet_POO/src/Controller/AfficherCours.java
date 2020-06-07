/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author adrie
 */



import Projet_POO.*;
import DAO.*;
import Model.*;
import java.util.*;
import java.sql.*;
import Projet_POO.DBConnect;
import java.text.*;
import javax.swing.*;
import java.awt.*;
import Model.Seance;


public class AfficherCours extends JPanel{
    
    public AfficherCours(){}
    
    public JPanel  Afi(Seance a ){
        
        JPanel NotreCour = new JPanel(new GridLayout(4,1));
         JPanel infoSal = new JPanel();
          JPanel etat = new JPanel();
       
       
         DBConnect conn = new DBConnect();
        Connection connect=conn.getCon(); 
        SeanceSalleDAO Ss = new SeanceSalleDAO(connect);
        SeanceGroupeDAO Sg = new SeanceGroupeDAO(connect);
        SeanceDAO sean = new SeanceDAO(connect);
        SalleDAO sal = new SalleDAO(connect);
        CoursDAO c =new CoursDAO(connect);
        EnseignantDAO e = new EnseignantDAO(connect);
        UtilisateurDAO u = new UtilisateurDAO(connect);
        SiteDAO si = new SiteDAO(connect);
        GroupeDAO g = new GroupeDAO(connect);
        
        SeanceSalle seancesalle = Ss.trouver(a.getId());
        Salle salle = sal.trouver(seancesalle.getIdSalle());
        Cours cour = c.trouver(a.getIdCours());
        
        SeanceGroupe sg = Sg.trouver(a.getId());
        Groupe grp = g.trouver(sg.getIdGroupe());
        
        Enseignant ensei = e.trouverEnseignant(cour.getId());
        Utilisateur utilisateur = u.trouver(ensei.getId());
        Site sit = si.trouver(salle.getIdSite());
        
       JLabel nomEnseignant = new JLabel(utilisateur.getNom(), JLabel.CENTER);
        JLabel affichsalle = new JLabel(salle.getNom(),JLabel.CENTER);
        JLabel capacite = new JLabel ("("+salle.getCapacite()+")",JLabel.CENTER);
        JLabel site = new JLabel(sit.getNom(),JLabel.CENTER);
        JLabel groupe = new JLabel(grp.getNom(),JLabel.CENTER);
         JLabel nomCour =new JLabel(cour.getNom(),JLabel.CENTER);
         
        nomCour.setFont(nomCour.getFont().deriveFont(15f));
       
        
         if (a.getEtat() == 0){
       
           JLabel Annule = new JLabel("ANNULE");
           Annule.setForeground(new Color(255, 51, 51));
           
           etat.add(Annule);
         NotreCour.add(etat);
       }
         else if (a.getEtat() == 2){
           
          
           JLabel vali = new JLabel("EN COUR DE VALIDATION");
           
           etat.add(vali);
           NotreCour.add(etat);

       } else{
             NotreCour.add(nomCour); 
         }
         
        NotreCour.add(nomEnseignant);
        
        NotreCour.add(groupe);
        infoSal.add(site);
        infoSal.add(affichsalle);
        infoSal.add(capacite);
        NotreCour.add(infoSal);
       
        if (cour.getId()== 1){
            NotreCour.setBackground(Color.yellow);
            infoSal.setBackground(Color.yellow);
        }
        else if (cour.getId()==2){
            NotreCour.setBackground(Color.CYAN);
               infoSal.setBackground(Color.CYAN);
        }
        else if (cour.getId()== 3){
            NotreCour.setBackground(Color.ORANGE);
               infoSal.setBackground(Color.ORANGE);
        }
        else if (cour.getId()== 4){
            NotreCour.setBackground(Color.GRAY);
               infoSal.setBackground(Color.GRAY);
        }
        else if (cour.getId()== 10){
            NotreCour.setBackground(Color.WHITE);
               infoSal.setBackground(Color.white);
        }
        else if (cour.getId()== 5){
            NotreCour.setBackground(Color.MAGENTA);
               infoSal.setBackground(Color.magenta);
        }
        else if (cour.getId()== 6){
            NotreCour.setBackground(Color.PINK);
               infoSal.setBackground(Color.pink);
        }
        else if (cour.getId()== 7){
            NotreCour.setBackground(Color.GREEN);
               infoSal.setBackground(Color.green);
        }
        else if (cour.getId()== 8){
            NotreCour.setBackground(Color.BLUE);
               infoSal.setBackground(Color.blue);
        }
        else if (cour.getId()== 9){
            NotreCour.setBackground(Color.LIGHT_GRAY);
               infoSal.setBackground(Color.LIGHT_GRAY);
        }  
      return NotreCour;  
    }
}
