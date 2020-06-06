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
import java.util.Calendar;
import java.util.TimeZone;

/**
 *
 * @author adrie
 */
public class Mise_a_jour {

    public void affecter_enseignant_a_seance(Enseignant prof, Seance seance) {
        DBConnect conn = new DBConnect();
        Connection connect = conn.getCon();
        SeanceDAO seanceDAO = new SeanceDAO(connect);

    }

    public void affecter_groupe_a_seance(Groupe grp, Seance seance) {
        DBConnect conn = new DBConnect();
        Connection connect = conn.getCon();
        SeanceDAO seanceDAO = new SeanceDAO(connect);

    }

    public void modif_nom_cours_dans_seance(Cours cours, Seance seance) {
        DBConnect conn = new DBConnect();
        Connection connect = conn.getCon();
        SeanceDAO seanceDAO = new SeanceDAO(connect);

        seance.setIdCours(cours.getId());
        seanceDAO.modifier(seance);
    }

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

    public void deplacer_seance(Seance seance) {
        DBConnect conn = new DBConnect();
        Connection connect = conn.getCon();
        SeanceDAO seanceDAO = new SeanceDAO(connect);

    }

    public void ajouter_seance(int semaine, java.util.Date date, Time heure_debut, Time heure_fin, int etat, int id_cours, int id_type) throws DateTimeException {
        DBConnect conn = new DBConnect();
        Connection connect = conn.getCon();
        SeanceDAO seanceDAO = new SeanceDAO(connect);

       // TimeZone tz = 
        Calendar c1 = Calendar.getInstance();
        c1.setTimeZone(TimeZone.getTimeZone("Europe/Paris"));
        c1.setTime(date);
        System.out.println(c1.get(Calendar.DAY_OF_WEEK));

        String refD = "08:30:00";
        String refF = "20:30:00";
        Time refDebut = Time.valueOf(refD);
        Time refFin = Time.valueOf(refF);
        System.out.println(c1.toString());
        System.out.println(date.toString());
        
        if ((c1.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY)
                || (c1.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
                || (heure_debut.before(refDebut) || heure_fin.after(refFin))) {  //or sunday   
            throw new DateTimeException("Les horaires ou date rentrés ne sont pas autorisés");
        } else {
            System.out.println("WEEKDAY");
            seanceDAO.creer(semaine, date, heure_debut, heure_fin, etat, id_cours, id_type);
        }
       // seanceDAO.creer(semaine, date, heure_debut, heure_fin, etat, id_cours, id_type);
    }

    public void ajouter_enseignant_a_seance(Enseignant Ens, Seance seance) {
        DBConnect conn = new DBConnect();
        Connection connect = conn.getCon();
        //SeanceDAO seanceDAO = new SeanceDAO(connect);
        //EnseignantDAO profDAO = new EnseignantDAO(connect);
        SeanceEnseignantDAO seanEnsDAO = new SeanceEnseignantDAO(connect);

        SeanceEnseignant newSeanEns = seanEnsDAO.trouver(Ens.getId(), seance.getId());
        System.out.println("On a passe la methode trouve");
        if (newSeanEns == null) {
            System.out.println("On a passe la condition if");
            boolean verif = seanEnsDAO.check_libre(Ens, seance);
            System.out.println("On a passe la methode check");
            System.out.println("verif egal a :" + verif);

            if (verif == true) {
                seanEnsDAO.creer(Ens, seance);
                System.out.println("Tout s'est bien passe");
            }
        }

    }

    public void ajouter_groupe_a_seance(Groupe grp, Seance seance) {
        DBConnect conn = new DBConnect();
        Connection connect = conn.getCon();
        SeanceDAO seanceDAO = new SeanceDAO(connect);

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

    public void enlever_groupe_a_seance(SeanceGroupe seancegrp) {
        DBConnect conn = new DBConnect();
        Connection connect = conn.getCon();
        SeanceGroupeDAO seancegrpDAO = new SeanceGroupeDAO(connect);

        seancegrpDAO.supprimer(seancegrp);

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
