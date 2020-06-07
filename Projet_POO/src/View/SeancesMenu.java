/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
   import Controller.Connexion;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

/**
 *
 * @author antoi
 */
/**
 *
 * @author Bauti
 */
public class SeancesMenu extends JFrame{

    private final JPanel container, nord;



    private final JButton  btnAffectEns, btnAffectGroupe, btnModifTypeCours,btnModifNomCours, btnAffectSalle, btnSuprEns, btnSuprGrpEns; 
    private final JButton btnDeplacerSeance, btnAjoutSeance, btnAjoutEns, btnAjoutGroupe, btnAnnValSeance, btnSuprGroupe; ;

    public SeancesMenu() {
        super();
        
        nord = new JPanel();
        container = new JPanel();
        
        setLayout(new BorderLayout());
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

   
        btnAffectEns = new JButton("Affecter un enseignant dans une séance de cours");
        btnAffectGroupe = new JButton("Affecter un groupe dans une séance de cours");
        btnModifNomCours = new JButton("Modifier le nom d'un cours d'une séance ");
        btnModifTypeCours = new JButton("Modifier le type d'un cours d'une séance");
        btnAffectSalle = new JButton("Affecter une salle à une séance de cours");
        btnDeplacerSeance = new JButton("Déplacer une séance de cours vers un autre créneau");
        btnAjoutSeance = new JButton("Ajouter une séance de cours");
        btnAjoutEns = new JButton("Ajouter un enseignant à une séance de cours");
        btnAjoutGroupe = new JButton("Ajouter un groupe à une séance de cours");
        btnAnnValSeance = new JButton("Annuler/Valider une séance de cours ");
        btnSuprGroupe = new JButton("Enlever un groupe à une séance de cours");
        btnSuprEns = new JButton("Enlever un enseignant à une séance de cours");
        btnSuprGrpEns = new JButton("Enlever un groupe et un enseignant à une séance de cours");


        btnAffectEns.addActionListener(new SeancesMenu.affectEnsListener());
        btnAffectGroupe.addActionListener(new SeancesMenu.affectGroupeListener());
        btnModifNomCours.addActionListener(new SeancesMenu.modifNomCoursListener());
        btnModifTypeCours.addActionListener(new SeancesMenu.modifTypeCoursListener());
        btnAffectSalle.addActionListener(new SeancesMenu.affectSalleListener());
        btnDeplacerSeance.addActionListener(new SeancesMenu.deplacerSeanceListener());
        btnAjoutSeance.addActionListener(new SeancesMenu.ajoutSeanceListener());
        btnAjoutEns.addActionListener(new SeancesMenu.ajoutEnsListener());
        btnAjoutGroupe.addActionListener(new SeancesMenu.ajoutGroupeListener());
        btnAnnValSeance.addActionListener(new SeancesMenu.annValSeanceListener());
        btnSuprGroupe.addActionListener(new SeancesMenu.suprGroupeListener());
        btnSuprEns.addActionListener(new SeancesMenu.suprEnsListener());
        btnSuprGrpEns.addActionListener(new SeancesMenu.suprGrpEnsListener());

        
        

        nord.setLayout(new GridLayout(8,1));


        nord.add("North", btnAffectEns);
        nord.add("North", btnAffectGroupe);
        nord.add("North", btnModifNomCours);
        nord.add("North", btnModifTypeCours);
        nord.add("North", btnAffectSalle);
        nord.add("North", btnDeplacerSeance);
        nord.add("North", btnAjoutSeance);
        nord.add("North", btnAjoutEns);
        nord.add("North", btnAjoutGroupe);
        nord.add("North", btnAnnValSeance);
        nord.add("North", btnSuprGroupe);

        add("North", nord);
    
        setVisible(true);
    }
    
    
    private class affectEnsListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            AffectEnseignants affecEns= new AffectEnseignants();
        }

    }
    
    private class affectGroupeListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            AffectGroupe affectGrp = new AffectGroupe();
        }

    }
    
    private class modifNomCoursListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            ModifNomCours modif= new ModifNomCours();
        }

    }
    
    private class modifTypeCoursListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            ModifTypeCours seances= new ModifTypeCours();
        }

    }
    
    private class affectSalleListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            //Planning planning = new Planning();
        }

    }
    
    private class deplacerSeanceListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            SeancesMenu seances= new SeancesMenu();
        }

    }
    
    private class ajoutSeanceListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            //Planning planning = new Planning();
        }

    }
    
    private class ajoutEnsListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            SeancesMenu seances= new SeancesMenu();
        }

    }
    
    private class ajoutGroupeListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            //Planning planning = new Planning();
        }

    }
    
    private class annValSeanceListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            SeancesMenu seances= new SeancesMenu();
        }

    }
    
    private class suprGroupeListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            //Planning planning = new Planning();
        }

    }
    
    private class suprEnsListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            //Planning planning = new Planning();
        }

    }
    
    private class suprGrpEnsListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            //Planning planning = new Planning();
        }

    }
  
}
