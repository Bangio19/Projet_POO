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
    

    
    public ArrayList<Seance> consulter_cours_enseignant(int id_utilisateur, int semaine)
    {
        DBConnect conn = new DBConnect();
        Connection connect=conn.getCon(); 

        SeanceEnseignantDAO seanceEnsDao = new SeanceEnseignantDAO(connect);
        SeanceDAO seanceDAO = new SeanceDAO(connect);
        
        ArrayList<SeanceEnseignant> listSeanEns = new ArrayList<SeanceEnseignant>();
        int compteur=0;

        listSeanEns = seanceEnsDao.trouver_tous_les_groupes(id_utilisateur);
        

        ArrayList<Seance> listeSeance = new ArrayList<Seance>();
        for(int i=0; i< listSeanEns.size(); i++){
            Seance s = seanceDAO.trouver(listSeanEns.get(i).getIdSeance());
            listeSeance.add(s);
        }
        for(int i=0 ; i< listeSeance.size(); i++){
            if(listeSeance.get(i).getSemaine()!= semaine)
            {
                listeSeance.remove(i);
            }
        }
        
        System.out.println("size de seancegroupe : "+listeSeance.size());
        for(int i=0 ; i< listeSeance.size(); i++){
            
            //System.out.println("la semaine du "+i+" eme seance de la liste est egale a  : "+listeSeance.get(i).getSemaine());
            if(listeSeance.get(i).getSemaine()!= semaine)
            {
                //listeSeance.remove(i);
                compteur++;
            }
            else
                compteur++;
            //System.out.println("la semaine du "+i+" eme seance de la liste est egale a  : "+listeSeance.get(i).getSemaine());
            
        }
        
        int[] tab_supprimer= new int[compteur];
            System.out.println("compteur : "+compteur);
        for(int i=0 ; i< tab_supprimer.length; i++){
            
            //System.out.println("la semaine du "+i+" eme seance de la liste est egale a  : "+listeSeance.get(i).getSemaine());
            if(listeSeance.get(i).getSemaine()!= semaine)
            {
                //listeSeance.remove(i);
                tab_supprimer[i] = i ;
            }
            else
                tab_supprimer[i]=-1;
            //System.out.println("la semaine du "+i+" eme seance de la liste est egale a  : "+listeSeance.get(i).getSemaine());
            
        }
        for(int i = tab_supprimer.length -1 ; i>-1; i--)
        {
            
            System.out.println("tab_supprimer valeur :"+i+" : "+tab_supprimer[i]);

            if(tab_supprimer[i] != -1)
                listeSeance.remove(i);
        }


        System.out.println("size de seancegroupe : "+listeSeance.size());
        return listeSeance;
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
        int compteur=0;
        ArrayList<SeanceGroupe> listSeanGrp = new ArrayList<SeanceGroupe>();
        
        listSeanGrp = seancegrpDao.trouver_tous_les_groupes(id_groupe);
        
        ArrayList<Seance> listeSeance = new ArrayList<Seance>();
        for(int i=0; i< listSeanGrp.size(); i++){
            Seance s = seanceDAO.trouver(listSeanGrp.get(i).getIdSeance());
            listeSeance.add(s);
        }
        System.out.println("size de seancegroupe : "+listeSeance.size());
        for(int i=0 ; i< listeSeance.size(); i++){
            
            //System.out.println("la semaine du "+i+" eme seance de la liste est egale a  : "+listeSeance.get(i).getSemaine());
            if(listeSeance.get(i).getSemaine()!= semaine)
            {
                //listeSeance.remove(i);
                compteur++;
            }
            else
                compteur++;
            //System.out.println("la semaine du "+i+" eme seance de la liste est egale a  : "+listeSeance.get(i).getSemaine());
            
        }
        
        int[] tab_supprimer= new int[compteur];
            System.out.println("compteur : "+compteur);
        for(int i=0 ; i< tab_supprimer.length; i++){
            
            //System.out.println("la semaine du "+i+" eme seance de la liste est egale a  : "+listeSeance.get(i).getSemaine());
            if(listeSeance.get(i).getSemaine()!= semaine)
            {
                //listeSeance.remove(i);
                tab_supprimer[i] = i ;
            }
            else
                tab_supprimer[i]=-1;
            //System.out.println("la semaine du "+i+" eme seance de la liste est egale a  : "+listeSeance.get(i).getSemaine());
            
        }
        for(int i = tab_supprimer.length -1 ; i>-1; i--)
        {
            
            System.out.println("tab_supprimer valeur :"+i+" : "+tab_supprimer[i]);

            if(tab_supprimer[i] != -1)
                listeSeance.remove(i);
        }


        System.out.println("size de seancegroupe : "+listeSeance.size());
        return listeSeance;
        
    }
    
    public ArrayList<Seance> consulter_cours_annule_etudiant(int id_utilisateur, int semaine)
    {
        DBConnect conn = new DBConnect();
        Connection connect=conn.getCon(); 

        SeanceGroupeDAO seancegrpDao = new SeanceGroupeDAO(connect);
        SeanceDAO seanceDAO = new SeanceDAO(connect);
        
        EtudiantDAO eleveDAO = new EtudiantDAO(connect);
        Etudiant eleve = eleveDAO.trouver(id_utilisateur);
        int id_groupe = eleve.getIdGroupe();
        int compteur=0;
        int compteur_annule=0;
        ArrayList<SeanceGroupe> listSeanGrp = new ArrayList<SeanceGroupe>();
        
        listSeanGrp = seancegrpDao.trouver_tous_les_groupes(id_groupe);
        
        ArrayList<Seance> listeSeance = new ArrayList<Seance>();
        for(int i=0; i< listSeanGrp.size(); i++){
            Seance s = seanceDAO.trouver(listSeanGrp.get(i).getIdSeance());
            listeSeance.add(s);
        }
        System.out.println("size de seancegroupe : "+listeSeance.size());
        for(int i=0 ; i< listeSeance.size(); i++){
            
            //System.out.println("la semaine du "+i+" eme seance de la liste est egale a  : "+listeSeance.get(i).getSemaine());
            if(listeSeance.get(i).getSemaine()!= semaine)
            {
                //listeSeance.remove(i);
                compteur++;
            }
            else
                compteur++;
            //System.out.println("la semaine du "+i+" eme seance de la liste est egale a  : "+listeSeance.get(i).getSemaine());
            
        }
        
        int[] tab_supprimer= new int[compteur];
            System.out.println("compteur : "+compteur);
        for(int i=0 ; i< tab_supprimer.length; i++){
            
            //System.out.println("la semaine du "+i+" eme seance de la liste est egale a  : "+listeSeance.get(i).getSemaine());
            if(listeSeance.get(i).getSemaine()!= semaine)
            {
                //listeSeance.remove(i);
                tab_supprimer[i] = i ;
            }
            else
                tab_supprimer[i]=-1;
            //System.out.println("la semaine du "+i+" eme seance de la liste est egale a  : "+listeSeance.get(i).getSemaine());
            
        }
        for(int i = tab_supprimer.length -1 ; i>-1; i--)
        {
            
            System.out.println("tab_supprimer valeur :"+i+" : "+tab_supprimer[i]);

            if(tab_supprimer[i] != -1)
                listeSeance.remove(i);
        }


        System.out.println("size de seancegroupe : "+listeSeance.size());
 /*----------------------------------------------------------------------------------------------------*/
        for(int i=0 ; i< listeSeance.size(); i++){
            
            //System.out.println("la semaine du "+i+" eme seance de la liste est egale a  : "+listeSeance.get(i).getSemaine());
            if(listeSeance.get(i).getSemaine()!= semaine)
            {
                //listeSeance.remove(i);
                compteur_annule++;
            }
            else
                compteur_annule++;
            //System.out.println("la semaine du "+i+" eme seance de la liste est egale a  : "+listeSeance.get(i).getSemaine());
            
        }
        
        int[] tab_supprimer_annule= new int[compteur_annule];
            System.out.println("compteur : "+compteur_annule);
        for(int i=0 ; i< tab_supprimer_annule.length; i++){
            
            if(listeSeance.get(i).getEtat()!= 0)
            {
                //listeSeance.remove(i);
                tab_supprimer_annule[i] = i ;
            }
            else
                tab_supprimer_annule[i]=-1;
            //System.out.println("la semaine du "+i+" eme seance de la liste est egale a  : "+listeSeance.get(i).getSemaine());
            
        }
        for(int i = tab_supprimer_annule.length -1 ; i>-1; i--)
        {
            
            System.out.println("tab_supprimer valeur :"+i+" : "+tab_supprimer_annule[i]);

            if(tab_supprimer_annule[i] != -1)
                listeSeance.remove(i);
        }
        
        System.out.println("size de seancegroupe : "+listeSeance.size());

        
        return listeSeance;
 
    } 
    
    public ArrayList<Seance> consulter_cours_annule_enseignant(int id_utilisateur, int semaine)
    {
         DBConnect conn = new DBConnect();
        Connection connect=conn.getCon(); 

        SeanceEnseignantDAO seanceEnsDao = new SeanceEnseignantDAO(connect);
        SeanceDAO seanceDAO = new SeanceDAO(connect);
        
        ArrayList<SeanceEnseignant> listSeanEns = new ArrayList<SeanceEnseignant>();
        int compteur=0;
        int compteur_annule=0;
        listSeanEns = seanceEnsDao.trouver_tous_les_groupes(id_utilisateur);
        

        ArrayList<Seance> listeSeance = new ArrayList<Seance>();
        for(int i=0; i< listSeanEns.size(); i++){
            Seance s = seanceDAO.trouver(listSeanEns.get(i).getIdSeance());
            listeSeance.add(s);
        }
        for(int i=0 ; i< listeSeance.size(); i++){
            if(listeSeance.get(i).getSemaine()!= semaine)
            {
                listeSeance.remove(i);
            }
        }
        System.out.println("size de seancegroupe : "+listeSeance.size());
        for(int i=0 ; i< listeSeance.size(); i++){
            
            //System.out.println("la semaine du "+i+" eme seance de la liste est egale a  : "+listeSeance.get(i).getSemaine());
            if(listeSeance.get(i).getSemaine()!= semaine)
            {
                //listeSeance.remove(i);
                compteur++;
            }
            else
                compteur++;
            //System.out.println("la semaine du "+i+" eme seance de la liste est egale a  : "+listeSeance.get(i).getSemaine());
            
        }
        
        int[] tab_supprimer= new int[compteur];
            System.out.println("compteur : "+compteur);
        for(int i=0 ; i< tab_supprimer.length; i++){
            
            //System.out.println("la semaine du "+i+" eme seance de la liste est egale a  : "+listeSeance.get(i).getSemaine());
            if(listeSeance.get(i).getSemaine()!= semaine)
            {
                //listeSeance.remove(i);
                tab_supprimer[i] = i ;
            }
            else
                tab_supprimer[i]=-1;
            //System.out.println("la semaine du "+i+" eme seance de la liste est egale a  : "+listeSeance.get(i).getSemaine());
            
        }
        for(int i = tab_supprimer.length -1 ; i>-1; i--)
        {
            
            System.out.println("tab_supprimer valeur :"+i+" : "+tab_supprimer[i]);

            if(tab_supprimer[i] != -1)
                listeSeance.remove(i);
        }


        System.out.println("size de seancegroupe : "+listeSeance.size());
 /*----------------------------------------------------------------------------------------------------*/
        for(int i=0 ; i< listeSeance.size(); i++){
            
            //System.out.println("la semaine du "+i+" eme seance de la liste est egale a  : "+listeSeance.get(i).getSemaine());
            if(listeSeance.get(i).getSemaine()!= semaine)
            {
                //listeSeance.remove(i);
                compteur_annule++;
            }
            else
                compteur_annule++;
            //System.out.println("la semaine du "+i+" eme seance de la liste est egale a  : "+listeSeance.get(i).getSemaine());
            
        }
        
        int[] tab_supprimer_annule= new int[compteur_annule];
            System.out.println("compteur : "+compteur_annule);
        for(int i=0 ; i< tab_supprimer_annule.length; i++){
            
            if(listeSeance.get(i).getEtat()!= 0)
            {
                //listeSeance.remove(i);
                tab_supprimer_annule[i] = i ;
            }
            else
                tab_supprimer_annule[i]=-1;
            //System.out.println("la semaine du "+i+" eme seance de la liste est egale a  : "+listeSeance.get(i).getSemaine());
            
        }
        for(int i = tab_supprimer_annule.length -1 ; i>-1; i--)
        {
            
            System.out.println("tab_supprimer valeur :"+i+" : "+tab_supprimer_annule[i]);

            if(tab_supprimer_annule[i] != -1)
                listeSeance.remove(i);
        }
        
        System.out.println("size de seancegroupe : "+listeSeance.size());

        
        return listeSeance;
 
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

    public ArrayList<SeanceGroupe> getAllSeanceGroups() {
         DBConnect conn = new DBConnect();
        Connection connect = conn.getCon();
        SeanceGroupeDAO groupeDAO = new SeanceGroupeDAO(connect);
        
       ArrayList<SeanceGroupe> groups = groupeDAO.trouvertous();
       return groups;
    }
}
