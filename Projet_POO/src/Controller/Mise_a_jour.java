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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author adrie
 */
public class Mise_a_jour {

    public void affecter_enseignant_a_seance(Enseignant prof, Seance seance) {
        DBConnect conn = new DBConnect();
        Connection connect = conn.getCon();       
        
        //SeanceDAO seanceDAO = new SeanceDAO(connect);
        //EnseignantDAO profDAO = new EnseignantDAO(connect);
        SeanceEnseignantDAO seanEnsDAO = new SeanceEnseignantDAO(connect);

        boolean verif = seanEnsDAO.check_libre(prof, seance);
        System.out.println("On a passe la methode check");
        System.out.println("verif egal a :" + verif);

        if (verif == true) {
            seanEnsDAO.creer(prof, seance);
            System.out.println("Tout s'est bien passe");
        }

    }
    

    public void affecter_groupe_a_seance(Groupe grp, Seance seance) {
        DBConnect conn = new DBConnect();
        Connection connect = conn.getCon();
        SeanceDAO seanceDAO = new SeanceDAO(connect);

    }

    /**
     * Modifie le nom d'un cours dans une séance
     * @param cours
     * @param seance 
     */
    public void modif_nom_cours_dans_seance(Cours cours, Seance seance) {
        DBConnect conn = new DBConnect();
        Connection connect = conn.getCon();
        SeanceDAO seanceDAO = new SeanceDAO(connect);

        seance.setIdCours(cours.getId());
        seanceDAO.modifier(seance);
    }

    /**
     * Modifie le type d'un cours dans une séance
     * @param typeCours
     * @param seance 
     */
    public void modif_type_cours_dans_seance(TypeCours typeCours, Seance seance) {
        DBConnect conn = new DBConnect();
        Connection connect = conn.getCon();
        SeanceDAO seanceDAO = new SeanceDAO(connect);

        seance.setIdType(typeCours.getId());
        seanceDAO.modifier(seance);
    }

    public void affecter_salle_a_seance(Salle salle, Seance seance) {
        DBConnect conn = new DBConnect();
        Connection connect = conn.getCon();
        SeanceDAO seanceDAO = new SeanceDAO(connect);

    }

    /**
     * Déplace une séance à la date, horaire souhaité
     * @param seance
     * @param semaine
     * @param date
     * @param heure_debut
     * @param heure_fin
     * @throws DateTimeException 
     */
    public void deplacer_seance(Seance seance,int semaine, java.util.Date date, Time heure_debut,
            Time heure_fin) throws DateTimeException {
        DBConnect conn = new DBConnect();
        Connection connect = conn.getCon();
        SeanceDAO seanceDAO = new SeanceDAO(connect);
        
        Calendar c1 = Calendar.getInstance();
        c1.setTimeZone(TimeZone.getTimeZone("Europe/Paris"));
        c1.setTime(date);

        String refD = "08:30:00";
        String refF = "20:30:00";
        Time refDebut = Time.valueOf(refD);
        Time refFin = Time.valueOf(refF);
        
        if ((c1.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY)
                || (c1.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
                || (heure_debut.before(refDebut) || heure_fin.after(refFin))) {  //or sunday   
            throw new DateTimeException("Les horaires ou date rentrés ne sont pas autorisés");
        } else {
            System.out.println("WEEKDAY");
           
            seance.setDate(date);
            seance.setHeureDebut(heure_debut);
            seance.setHeureFin(heure_fin);
             seanceDAO.modifier(seance);
        }
    }

    /**
     * Ajoute une séance avec tous les paramètre souhaités
     * @param semaine
     * @param date
     * @param heure_debut
     * @param heure_fin
     * @param etat
     * @param id_cours
     * @param id_type
     * @param groupe
     * @param enseignant
     * @param salle
     * @throws DateTimeException 
     */
    public void ajouter_seance(int semaine, java.util.Date date, Time heure_debut,
            Time heure_fin, int etat, int id_cours, int id_type, Groupe groupe, Enseignant enseignant, Salle salle) throws DateTimeException {
        DBConnect conn = new DBConnect();
        Connection connect = conn.getCon();
        SeanceDAO seanceDAO = new SeanceDAO(connect);

        // TimeZone tz = 
        Calendar c1 = Calendar.getInstance();
        c1.setTimeZone(TimeZone.getTimeZone("Europe/Paris"));
        c1.setTime(date);

        String refD = "08:30:00";
        String refF = "20:30:00";
        Time refDebut = Time.valueOf(refD);
        Time refFin = Time.valueOf(refF);

        if ((c1.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY)
                || (c1.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
                || (heure_debut.before(refDebut) || heure_fin.after(refFin))) {  //or sunday   
            throw new DateTimeException("Les horaires ou date rentrés ne sont pas autorisés");
        } else {
            try {
                System.out.println("WEEKDAY");
                seanceDAO.creer(semaine, date, heure_debut, heure_fin, etat, id_cours, id_type);
//                int id_seance = seanceDAO.getId(date, heure_debut, heure_fin, id_cours, id_type);
//                System.out.println("l'id envoyé: "+id_seance);
//                conn = new DBConnect();
//                connect = conn.getCon();
//                Seance seance = seanceDAO.trouver(id_seance, connect);
//                
//                SeanceEnseignantDAO seanEnsDAO = new SeanceEnseignantDAO(connect);
//                System.out.println(seance.toString());
//                boolean verifE = seanEnsDAO.check_libre(enseignant, seance);
//                System.out.println("On a passe la methode check");
//                System.out.println("verif egal a :" + verifE);
//                
//                if (verifE == true) {
//                    seanEnsDAO.creer(enseignant, seance);
//                    System.out.println("Seance ajoutée à l'enseignant");
//                    
//                    SeanceGroupeDAO seanGrpDAO = new SeanceGroupeDAO(connect);
//                    //SeanceSalleDAO seanSalDAO = new SeanceSalleDAO(connect);
//                    //int capacite_mini=0;
//                    
//                    boolean verifG = seanGrpDAO.check_libre(groupe, seance);
//                    
//                    if (verifG == true) {
//                        seanGrpDAO.creer(groupe, seance);
//                        System.out.println("Seance ajoutée au groupe");
//                    }
//                }

            } catch (SQLException ex) {
                Logger.getLogger(Mise_a_jour.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void ajouter_enseignant_a_seance(Enseignant Ens, Seance seance) {
        DBConnect conn = new DBConnect();
        Connection connect = conn.getCon();
        //SeanceDAO seanceDAO = new SeanceDAO(connect);
        //EnseignantDAO profDAO = new EnseignantDAO(connect);
        SeanceEnseignantDAO seanEnsDAO = new SeanceEnseignantDAO(connect);

        boolean verif = seanEnsDAO.check_libre(Ens, seance);
        System.out.println("On a passe la methode check");
        System.out.println("verif egal a :" + verif);

        if (verif == true) {
            seanEnsDAO.creer(Ens, seance);
            System.out.println("Tout s'est bien passe");
        }

    }

    public void ajouter_groupe_a_seance(Groupe grp, Seance seance) {
        DBConnect conn = new DBConnect();
        Connection connect = conn.getCon();

        SeanceGroupeDAO seanGrpDAO = new SeanceGroupeDAO(connect);
        //SeanceSalleDAO seanSalDAO = new SeanceSalleDAO(connect);
        //int capacite_mini=0;

        boolean verif = seanGrpDAO.check_libre(grp, seance);

        if (verif == true) {
            seanGrpDAO.creer(grp, seance);
            System.out.println("Tout s'est bien passe");
        }

    }

    public void annuler_seance(Seance seance) {
        DBConnect conn = new DBConnect();
        Connection connect = conn.getCon();
        SeanceDAO seanceDAO = new SeanceDAO(connect);

        seance.setEtat(0);
        seanceDAO.modifier(seance);

    }

    public void valider_seance(Seance seance) {
        DBConnect conn = new DBConnect();
        Connection connect = conn.getCon();
        SeanceDAO seanceDAO = new SeanceDAO(connect);

        seance.setEtat(1);
        seanceDAO.modifier(seance);
    }

    public void enlever_groupe_a_seance(SeanceGroupe sgrp) {
        DBConnect conn = new DBConnect();
        Connection connect = conn.getCon();
        SeanceGroupeDAO seancegrpDAO = new SeanceGroupeDAO(connect);

        seancegrpDAO.supprimer(sgrp);

    }

    public void enlever_enseignant_a_seance(SeanceEnseignant seanceEns) {
        DBConnect conn = new DBConnect();
        Connection connect = conn.getCon();
        SeanceEnseignantDAO seanceEnsDAO = new SeanceEnseignantDAO(connect);

        seanceEnsDAO.supprimer(seanceEns);

    }

    public void enlever_groupe_et_enseignant_a_seance(SeanceGroupe seancegrp, SeanceEnseignant seanceEns) {
        DBConnect conn = new DBConnect();
        Connection connect = conn.getCon();
        SeanceGroupeDAO seancegrpDAO = new SeanceGroupeDAO(connect);

        seancegrpDAO.supprimer(seancegrp);

        SeanceEnseignantDAO seanceEnsDAO = new SeanceEnseignantDAO(connect);

        seanceEnsDAO.supprimer(seanceEns);
    }
}
