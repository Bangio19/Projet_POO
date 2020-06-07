
package View;
import Controller.AfficherCours;
import javax.swing.*;
import java.awt.*;
import DAO.SeanceDAO;
import Model.Seance;
import java.sql.Time;
import java.util.ArrayList;
import java.text.SimpleDateFormat;

/**
 *
 * @author antoi
 */
public class RecapCours extends JFrame {
    
    private final JPanel Titre, Analyse, TraitementSignal, English, Italien, Thermo, Robotique, Anthropologie, Ethique, PSTE, POO_Java, container; 
    //private final JLabel seance; 
    
    private final JLabel Matiere, Duree, Nb, Analyse_, TraitementSignal_, English_, Italien_, Thermo_, Robotique_, Anthropologie_, Ethique_, PSTE_, POO_Java_;

            
    public RecapCours(ArrayList<Seance> listeSeance){
      super();
      setTitle("Mon recap");
      setLayout(new BorderLayout());
      setSize(1000,600);
      setLocationRelativeTo(null);
      
      int compteur_Ana=0;
      int compteur_Tra=0;
      int compteur_Eng=0;
      int compteur_Ita=0;
      int compteur_The=0;
      int compteur_Rob=0;
      int compteur_Ant=0;
      int compteur_Eth=0;
      int compteur_Pst=0;
      int compteur_POO=0;
      


        int taille = listeSeance.size();
      int check=0;
      for(int i=0; i<taille; i++)
      {
          check= listeSeance.get(i).getIdCours();
          if(check == 1)
              compteur_Ana ++;
          else if(check == 2)
              compteur_Tra ++;
          else if(check == 3)
              compteur_Eng ++;
          else if(check == 4)
              compteur_Ita ++;
          else if(check == 5)
              compteur_The ++;
          else if(check == 6)
              compteur_Rob ++;
          else if(check == 7)
              compteur_Ant ++;
          else if(check == 8)
              compteur_Eth ++;
          else if(check == 9)
              compteur_Pst ++;
          else if(check == 10)
              compteur_POO ++;
          
      }

        String duree_Ana= nbHeure(compteur_Ana);
        String duree_Tra= nbHeure(compteur_Tra);
        String duree_Eng= nbHeure(compteur_Eng);
        String duree_Ita= nbHeure(compteur_Ita);
        String duree_The= nbHeure(compteur_The);
        String duree_Rob= nbHeure(compteur_Rob);
        String duree_Ant= nbHeure(compteur_Ant);
        String duree_Eth= nbHeure(compteur_Eth);
        String duree_Pst= nbHeure(compteur_Pst);
        String duree_POO= nbHeure(compteur_POO);

        Titre = new JPanel();
       Analyse = new JPanel();
       TraitementSignal = new JPanel();
       English = new JPanel();
       Italien = new JPanel();
       Thermo = new JPanel();
       Robotique = new JPanel();
       Anthropologie = new JPanel();
       Ethique = new JPanel();
       PSTE = new JPanel();
       POO_Java = new JPanel();
       container = new JPanel();
       
       Titre.setLayout(new GridLayout(1,3));
       Analyse.setLayout(new GridLayout(1,3));
       TraitementSignal.setLayout(new GridLayout(1,3));
       English.setLayout(new GridLayout(1,3));
       Italien.setLayout(new GridLayout(1,3));
       Thermo.setLayout(new GridLayout(1,3));
       Robotique.setLayout(new GridLayout(1,3));
       Anthropologie.setLayout(new GridLayout(1,3));
       Ethique.setLayout(new GridLayout(1,3));
       PSTE.setLayout(new GridLayout(1,3));
       POO_Java.setLayout(new GridLayout(1,3));
       container.setLayout(new GridLayout(11,1));

       Matiere = new JLabel("Matieres", JLabel.CENTER);
        Duree = new JLabel("Duree", JLabel.CENTER);
        Nb = new JLabel("Nombre de cours.", JLabel.CENTER);
        Analyse_ = new JLabel("Analyse", JLabel.CENTER);
        TraitementSignal_ = new JLabel("TraitementSignal ", JLabel.CENTER);
        English_ = new JLabel("English", JLabel.CENTER);
       Italien_ = new JLabel("Italien", JLabel.CENTER);
        Thermo_ = new JLabel("Thermo", JLabel.CENTER);
        Robotique_ = new JLabel("Robotique", JLabel.CENTER);
        Anthropologie_ = new JLabel("Anthropologie", JLabel.CENTER);
        Ethique_ = new JLabel("Ethique", JLabel.CENTER);
        PSTE_ = new JLabel("PSTE", JLabel.CENTER);
        POO_Java_ = new JLabel("POO_Java", JLabel.CENTER);
        
        Titre.add(Matiere);
        Titre.add(Duree);
        Titre.add(Nb);
        
       Analyse.add(Analyse_);
       Analyse.add(new Label("'" +duree_Ana+"'"));
       Analyse.add(new Label("'"+compteur_Ana+"'"));
       TraitementSignal.add(TraitementSignal_);
       TraitementSignal.add(new Label("'" +duree_Tra+"'"));
       TraitementSignal.add(new Label("'"+compteur_Tra+"'"));
       English.add(English_);
       English.add(new Label("'" +duree_Eng+"'"));
       English.add(new Label("'"+compteur_Eng+"'"));
       Italien.add(Italien_);
       Italien.add(new Label("'" +duree_Ita+"'"));
       Italien.add(new Label("'"+compteur_Ita+"'"));
       Thermo.add(Thermo_);
       Thermo.add(new Label("'" +duree_The+"'"));
       Thermo.add(new Label("'"+compteur_The+"'"));
       Robotique.add(Robotique_);
       Robotique.add(new Label("'" +duree_Rob+"'"));
       Robotique.add(new Label("'"+compteur_Rob+"'"));
       Anthropologie.add(Anthropologie_);
       Anthropologie.add(new Label("'" +duree_Ant+"'"));
       Anthropologie.add(new Label("'"+compteur_Ant+"'"));
       Ethique.add(Ethique_);
       Ethique.add(new Label("'" +duree_Eth+"'"));
       Ethique.add(new Label("'"+compteur_Eth+"'"));
       PSTE.add(PSTE_);
       PSTE.add(new Label("'" +duree_Pst+"'"));
       PSTE.add(new Label("'"+compteur_Pst+"'"));
       POO_Java.add(POO_Java_);
       POO_Java.add(new Label("'" +duree_POO+"'"));
       POO_Java.add(new Label("'"+compteur_POO+"'"));     //setContentPane(container);
       
       container.add(Titre);
       container.add(Analyse);
       container.add(TraitementSignal);
       container.add(English);
       container.add(Italien);
       container.add(Thermo);
       container.add(Robotique);
       container.add(Anthropologie);
       container.add(Ethique);
       container.add(PSTE);
       container.add(POO_Java);
       
       container.setBorder(BorderFactory.createLineBorder(Color.black,1));
       
       add("North", container);

      setVisible(true);
      
     
  }
    
    public String nbHeure(int compteur)
    {
        String a = "";
        
       
        if (compteur == 1)
        {    
            a = "1h30";
        }
        else if(compteur == 2)
        {    
            a = "3H00";
        }
        else if(compteur == 3)
        {   
            a="4H30";
        }
        else if(compteur == 4)
        {   
            a="6H00";
        }
        else if(compteur == 5)
        {    
            a = "7H30";
        }
        else
            a = "00H00";
        return a;
        
    }
}


