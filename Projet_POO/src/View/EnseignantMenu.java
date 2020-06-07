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
import java.util.ArrayList;


/**
 *
 * @author antoi
 */
public class EnseignantMenu extends JFrame implements ActionListener {
    
    private Connexion connexion = new Connexion();
    private Recherche recherche = new Recherche();
    private Planning planning;

    private final JLabel requeteSemaine, requeteSemaineAnnule;
    private final JPanel bouton, semaine, semaine_annule, nord;
    private final JTextField numeroSemaine, numeroSemaineAnnule;
    private int id_Enseignant;

    private final JButton btn_emploi_du_temps, btn_recap_cours, btn_exe_semaine, btn_exe_semaine_annule;
        
    public EnseignantMenu(int id){
        
        super();
        id_Enseignant=id;
        setVisible(true);
        
        nord = new JPanel();
        bouton = new JPanel();
        semaine = new JPanel();
        semaine_annule = new JPanel();

        btn_emploi_du_temps = new JButton("Voir emploi du temps");
        btn_recap_cours = new JButton("Voir le recapitulatif des cours");
        btn_exe_semaine = new JButton("Executer");
        btn_exe_semaine_annule = new JButton("Rechercher les cours de la semaine annule");

        btn_emploi_du_temps.addActionListener(this);
        btn_recap_cours.addActionListener(this);
        btn_exe_semaine.addActionListener(this);
        btn_exe_semaine_annule.addActionListener(this);

        String nom_prof= connexion.get_nom(id_Enseignant);
        setTitle("Emploi du temps de "+nom_prof);
        
        setLayout(new BorderLayout());
        setSize(1000,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        numeroSemaine = new JTextField();
        numeroSemaineAnnule = new JTextField();

        requeteSemaine = new JLabel("Selectionnez la semaine :", JLabel.CENTER);
        requeteSemaineAnnule = new JLabel("Selectionnez la semaine annule :", JLabel.CENTER);

        bouton.setLayout(new GridLayout(1,2));
        semaine.setLayout(new GridLayout(1,3));
        semaine_annule.setLayout(new GridLayout(1,3));
        nord.setLayout(new GridLayout(3,1));
        
        
        semaine.add(requeteSemaine);
        semaine.add(numeroSemaine);
        semaine.add(btn_exe_semaine);
        
        semaine_annule.add(requeteSemaineAnnule);
        semaine_annule.add(numeroSemaineAnnule);
        semaine_annule.add(btn_exe_semaine_annule);
        
        bouton.add(btn_emploi_du_temps);
        bouton.add(btn_recap_cours);

        nord.add("North", bouton);
	nord.add("North", semaine);
        nord.add("North", semaine_annule);

        add("North", nord);
        
        
    }
    
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if(source == btn_emploi_du_temps)
        {
            //System.out.println("Voici votre emploi du temps de la semaine 1.");
            //Planning planning = new Planning();
        } 
        else if(source == btn_recap_cours)
        {
            System.out.println("Voici votre récapitulatif de cours");
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
		System.out.println("c'est une lettre");					
            }
                        
            ArrayList<Seance> maListe = new ArrayList<Seance>();
            
            maListe = recherche.consulter_cours_annule_enseignant(id_Enseignant, numero_semaine_annule);
            
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
            maListe = recherche.consulter_cours_enseignant(id_Enseignant, numero_semaine);
            
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


