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
    
    private final JPanel container, nord;
    
    private int id_Eleve;

    private final JButton btn_emploi_du_temps, btn_recap_cours;
        
    public EleveMenu(int id){
        
        super();
        id_Eleve=id;
        setVisible(true);
        
        nord = new JPanel();
        container = new JPanel();
        
        btn_emploi_du_temps = new JButton("Voir emploi du temps");
        btn_recap_cours = new JButton("Voir le recapitulatif des cours");
        
        btn_emploi_du_temps.addActionListener(this);
        btn_recap_cours.addActionListener(this);
        
        Connexion connexion = new Connexion();
        String nom_etudiant= connexion.get_nom_etudiant(id_Eleve);
        setTitle("Emploi du temps de "+nom_etudiant);
        setLayout(new BorderLayout());
        setSize(1000,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
        nord.setLayout(new GridLayout(1,8));

	nord.add("North", btn_emploi_du_temps);
	nord.add("North", btn_recap_cours);

        add("North", nord);
    }
    
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if(source == btn_emploi_du_temps)
        {
            System.out.println("Voici votre emploi du temps de la semaine 1.");
            
        } 
        else if(source == btn_recap_cours)
        {
            System.out.println("Voici votre récapitulatif de cours");
        }
    }
    
}


