/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.*;
import Model.*;
import Projet_POO.DBConnect;
import View.*;
import java.sql.*;
import javax.swing.*;
import java.util.*;


/**
 *
 * @author adrie
 */
public class Connexion {
    
    public void verif_utilisateur_lancement_menu_correspondant(String email, String mdp) {
        
        DBConnect conn = new DBConnect();
        Connection connect = conn.getCon();
        
        UtilisateurDAO utilisateurDAO = new UtilisateurDAO(connect);
        Utilisateur utilisateur = utilisateurDAO.trouver(email);
  
          
        if (email.equals(utilisateur.getEmail()) && mdp.equals(utilisateur.getMdp()) ){
              
            int droit = utilisateur.getDroit();
             // sélection du menu en fonction du droit de l'utilisateur 
            if (droit == 1)
            {
                AdminMenu nouveau = new AdminMenu(utilisateur.getId());
            }
            if (droit == 2){
                  
                ResponsableMenu nouveau = new ResponsableMenu();
            }
            if (droit == 3)
            {
                EnseignantMenu nouveau = new EnseignantMenu(utilisateur.getId());
            }
            if (droit == 4)
            {
                EleveMenu nouveau = new EleveMenu(utilisateur.getId());
            }
                
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Mot de passe incorect");
        }
    }
    
    public String get_nom(int id_utilisateur)
    {
        DBConnect conn = new DBConnect();
        Connection connect = conn.getCon();
        
        UtilisateurDAO utilisateurDAO = new UtilisateurDAO(connect);
        Utilisateur utilisateur = utilisateurDAO.trouver(id_utilisateur);
        String nom_complet = utilisateur.getPrenom()+utilisateur.getNom();
        return nom_complet;
    }
    
    
    
}
