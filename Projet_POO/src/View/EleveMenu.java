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
    
    private final JPanel container = new JPanel();
    
    private int id_Eleve;

    private JButton btn_emploi_du_temps = new JButton("Emploi du temps");
    private JButton btn_recap_cours = new JButton("Récapitulatif des cours");
        
    public EleveMenu(int id){
        
        super();
        
        id_Eleve=id;
        
        setVisible(true);
        build();
    }
    
    private void build()
    {
        Connexion connexion = new Connexion();
        String nom_etudiant= connexion.get_nom_etudiant(id_Eleve);
        setTitle("Emploi du temps de "+nom_etudiant);
        setSize(1000,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setContentPane(buildContentPane());
    }
    
    private JPanel buildContentPane()
    {
        container.setLayout(new BorderLayout());
		
	btn_emploi_du_temps.addActionListener(this);
	container.add("North", btn_emploi_du_temps);
				
	btn_recap_cours.addActionListener(this);
	container.add("North", btn_recap_cours);;
		
	return container;
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


