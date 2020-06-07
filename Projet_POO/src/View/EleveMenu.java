/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import Controller.Connexion;
import Controller.Recherche;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import DAO.*;
import Model.*;
import Projet_POO.DBConnect;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author antoi
 */
public class EleveMenu extends JFrame implements ActionListener {
    
    private Connexion connexion = new Connexion();
    private Recherche recherche = new Recherche();
    private Planning planning;

    private final JLabel requeteSemaine, requeteSemaineAnnule, requeteDate;
    private final JPanel bouton, semaine, semaine_annule, nord;
    private final JTextField numeroSemaine, numeroSemaineAnnule, DateDebut, DateFin;
    private int id_Eleve;

    private final JButton btn_recap_cours, btn_exe_semaine, btn_exe_semaine_annule;
        
    public EleveMenu(int id){
        
        super();
        id_Eleve=id;
        setVisible(true);
        
        nord = new JPanel();
        bouton = new JPanel();
        semaine = new JPanel();
        semaine_annule = new JPanel();

        btn_recap_cours = new JButton("Voir le recapitulatif des cours");
        btn_exe_semaine = new JButton("Rechercher les cours de la semaine");
        btn_exe_semaine_annule = new JButton("Rechercher les cours de la semaine annule");

        btn_recap_cours.addActionListener(this);
        btn_exe_semaine.addActionListener(this);
        btn_exe_semaine_annule.addActionListener(this);

        String nom_etudiant= connexion.get_nom(id_Eleve);
        setTitle("Emploi du temps de "+nom_etudiant);
        
        setLayout(new BorderLayout());
        setSize(1000,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        numeroSemaine = new JTextField();
        numeroSemaineAnnule = new JTextField();
        DateDebut = new JTextField();
        DateFin = new JTextField();
        
        requeteDate = new JLabel("Entrez 1. la date de debut et 2. Date de fin", JLabel.CENTER);
        requeteSemaine = new JLabel("Selectionnez la semaine :", JLabel.CENTER);
        requeteSemaineAnnule = new JLabel("Selectionnez la semaine annule :", JLabel.CENTER);

        bouton.setLayout(new GridLayout(1,4));
        semaine.setLayout(new GridLayout(1,3));
        semaine_annule.setLayout(new GridLayout(1,3));
        nord.setLayout(new GridLayout(3,1));
        
        
        semaine.add(requeteSemaine);
        semaine.add(numeroSemaine);
        semaine.add(btn_exe_semaine);
        
        semaine_annule.add(requeteDate);
        semaine_annule.add(requeteSemaineAnnule);
        semaine_annule.add(numeroSemaineAnnule);
        semaine_annule.add(btn_exe_semaine_annule);
        
        bouton.add(requeteDate);
        bouton.add(DateDebut);
        bouton.add(DateFin);
        bouton.add(btn_recap_cours);
        
        nord.add("North", bouton);
	nord.add("North", semaine);
        nord.add("North", semaine_annule);

        add("North", nord);
        
        
    }
    
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if(source == btn_recap_cours)
        {
            System.out.println("Voici votre récapitulatif de cours");
            
            String d_debut = DateDebut.getText();
            String d_fin = DateFin.getText();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        java.util.Date dateDebut;
        java.util.Date dateFin;
        try {
            dateDebut = format.parse(d_debut);
            java.sql.Date dateDB = new java.sql.Date(dateDebut.getTime());
            dateFin = format.parse(d_fin);
            java.sql.Date dateFN = new java.sql.Date(dateFin.getTime());            
		
            
            ArrayList<Seance> maListe = new ArrayList<Seance>();
            
            maListe = recherche.recapitulatif_cours_etudiant(id_Eleve, dateDB, dateFN);
            
            RecapCours recap = new RecapCours(maListe);
            
            } catch (ParseException ex) {
                Logger.getLogger(EleveMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
            

        }
        
        else if(source == btn_exe_semaine_annule)
        {
            int numero_semaine_annule=0;
            try{
                String semaine_select = numeroSemaineAnnule.getText();
                numero_semaine_annule = Integer.parseInt(semaine_select);
                System.out.println("La semaine : "+numero_semaine_annule);
            }catch(NumberFormatException a)
            {
		System.out.println("c'est une lettre");;					
            }
                        
            ArrayList<Seance> maListe = new ArrayList<Seance>();
            
            maListe = recherche.consulter_cours_annule_etudiant(id_Eleve, numero_semaine_annule);
            
            System.out.println(maListe.size());

            int[] tab =new int[maListe.size()];
            for(int i=0; i<maListe.size();i++)
            {
                tab[i] = recherche.jourSemaine(maListe.get(i));
            }
            
            planning = new Planning(maListe, tab);
        }
        
        else if(source == btn_exe_semaine)
        {
            int numero_semaine=0;
            try{
                String semaine_select = numeroSemaine.getText();
                numero_semaine = Integer.parseInt(semaine_select);
                System.out.println("La semaine : "+numero_semaine);
            }catch(NumberFormatException a)
            {
		System.out.println("c'est une lettre");;					
            }
                        
            ArrayList<Seance> maListe = new ArrayList<Seance>();
            
            maListe = recherche.consulter_cours__etudiant(id_Eleve, numero_semaine);
            
            System.out.println(maListe.size());

            int[] tab =new int[maListe.size()];
            for(int i=0; i<maListe.size();i++)
            {
                tab[i] = recherche.jourSemaine(maListe.get(i));
            }
            
            planning = new Planning(maListe, tab);
            
        }
    }
    
}


