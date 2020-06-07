/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import Controller.Connexion;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import DAO.*;
import Model.*;
import Projet_POO.DBConnect;
import java.sql.Connection;


/**
 *
 * @author antoi
 */
public class EleveMenu extends JFrame implements ActionListener {
    
    private Connexion connexion = new Connexion();
    private Planning planning = new Planning();

    private final JLabel requeteSemaine;
    private final JPanel bouton, semaine, nord;
    private final JTextField numeroSemaine;
    private int id_Eleve;

    private final JButton btn_emploi_du_temps, btn_recap_cours, btn_exe_semaine;
        
    public EleveMenu(int id){
        
        super();
        id_Eleve=id;
        setVisible(true);
        
        nord = new JPanel();
        bouton = new JPanel();
        semaine = new JPanel();

        btn_emploi_du_temps = new JButton("Voir emploi du temps");
        btn_recap_cours = new JButton("Voir le recapitulatif des cours");
        btn_exe_semaine = new JButton("Executer");

        btn_emploi_du_temps.addActionListener(this);
        btn_recap_cours.addActionListener(this);
        btn_exe_semaine.addActionListener(this);

        String nom_etudiant= connexion.get_nom_etudiant(id_Eleve);
        setTitle("Emploi du temps de "+nom_etudiant);
        
        setLayout(new BorderLayout());
        setSize(1000,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        numeroSemaine = new JTextField();

        requeteSemaine = new JLabel("Selectionnez la semaine :", JLabel.CENTER);
        
        bouton.setLayout(new GridLayout(1,2));
        semaine.setLayout(new GridLayout(1,3));
        nord.setLayout(new GridLayout(2,1));
        
        
        semaine.add(requeteSemaine);
        semaine.add(numeroSemaine);
        semaine.add(btn_exe_semaine);
        
        bouton.add(btn_emploi_du_temps);
        bouton.add(btn_recap_cours);
        
        nord.add("North", bouton);
	nord.add("North", semaine);

        add("North", nord);

    }
    
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if(source == btn_emploi_du_temps)
        {
            //System.out.println("Voici votre emploi du temps de la semaine 1.");
            Planning planning = new Planning();
        } 
        else if(source == btn_recap_cours)
        {
            System.out.println("Voici votre récapitulatif de cours");
        }
        else if(source == btn_exe_semaine)
        {
            try{
                String semaine_select = numeroSemaine.getText();
                int numero_semaine = Integer.parseInt(semaine_select);
                System.out.println("La semaine : "+numero_semaine);
            }catch(NumberFormatException a)
            {
		System.out.println("c'est une lettre");;					
            }
	
        }
    }
    
}


