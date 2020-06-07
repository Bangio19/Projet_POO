
package View;
import javax.swing.*;
import java.awt.*;
import DAO.SeanceDAO;
import Model.Seance;
import java.sql.Time;
import java.util.ArrayList;

/**
 *
 * @author antoi
 */
public class Planning extends JFrame {
    
    private final JPanel container;
    private final JLabel lundi, mardi, mercredi, jeudi, vendredi,heure1,heure2,heure3,heure4,heure5,heure6,heure7, seance; 
            
  public Planning(ArrayList<Seance> listeSeance, int[] tab){
      super();
      setTitle("Mon planning");
      setSize(1000,600);
      setLocationRelativeTo(null);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
       container = new JPanel();
       
       lundi = new JLabel("Lundi");
       mardi= new JLabel("Mardi");
       mercredi = new JLabel("Mercredi");
       jeudi = new JLabel("Jeudi");
       vendredi = new JLabel("Vendredi");
       heure1= new JLabel("8h / 10h");
       heure2= new JLabel("10h15 / 11H45");
       heure3= new JLabel("12h / 13h30");
       heure4= new JLabel("13h45 / 15h15");
       heure5= new JLabel("15h30 / 17h");
       heure6= new JLabel("17h15 / 18h45");
       heure7= new JLabel("19h / 20h30");

        seance= new JLabel("YEs");
       
        container.setLayout(new GridLayout(8,6));
      
      String h1 = "08:00:00";
      Time h11 = Time.valueOf(h1);
      String h2 = "10:15:00";
      Time h22 = Time.valueOf(h2);
      String h3 = "12:00:00";
      Time h33 = Time.valueOf(h3);
      String h4 = "13:45:00";
      Time h44 = Time.valueOf(h4);
      String h5 = "15:30:00";
      Time h55 = Time.valueOf(h5);
      String h6 = "17:15:00";
      Time h66 = Time.valueOf(h6);
      String h7 = "19:00:00";
      Time h77 = Time.valueOf(h7);
      
      
        System.out.println(listeSeance.size());
        for(int i=0; i<listeSeance.size(); i++)
        {
            System.out.println(listeSeance.get(i).getId());
            System.out.println(listeSeance.get(i).getHeureDebut());
            System.out.println("Valeur du tab : "+tab[i]);
        }
        
      int[] tab_case = new int[listeSeance.size()];
      System.out.println("taille de la liste"+listeSeance.size());
      
      for(int i=0; i<listeSeance.size(); i++)
      {
          
        Time h_debut= listeSeance.get(i).getHeureDebut();
        System.out.println("heure_debut   "+h_debut);
        
        if(h_debut.equals(h11)); 
        {
            System.out.println(" On rentre en h1: ");
            tab_case[i] = 6 + tab[i]-1;
        }
        if(h_debut.equals(h22))
        {
            System.out.println("On rentre en h2: ");
            tab_case[i] = 12 + tab[i]-1;
        }
        if(h_debut.equals(h33))
        {
            System.out.println("On rentre en h3: ");
            tab_case[i] = 18 + tab[i]-1;
        }
         if(h_debut.equals(h44))
        {
            System.out.println("On rentre en h4: ");
            tab_case[i] = 24 + tab[i]-1;
        }
        if(h_debut.equals(h55))
        {
            System.out.println("On rentre en h5: ");
            tab_case[i] = 30 + tab[i]-1;
        }
        if(h_debut.equals(h66))
        {
            tab_case[i] = 36 + tab[i]-1;
        }
        if(h_debut.equals(h77))
        {
            tab_case[i] = 42 + tab[i]-1;
        }
      }
      System.out.println(tab_case.length);
      for(int i=0; i<tab_case.length; i++)
      {
          System.out.println("YEs"+tab_case[i]);
      }
      
      for(int i=0; i<48 ; i++){
          
            JPanel nouveau = new JPanel();
          
         
          // Jour de la semaine affichage
          if(i == 1){
              nouveau.add(lundi);
          }
          if(i == 2){
              nouveau.add(mardi);
          }
          if(i == 3){
              nouveau.add(mercredi);
          }
          if(i == 4){
              nouveau.add(jeudi);
          }
          if(i == 5){
              nouveau.add(vendredi);
          }
          
          // Horaire affichage 
          
           if(i == 6){
              nouveau.add(heure1);
          }
          if(i == 12){
              nouveau.add(heure2);
          }
          if(i == 18){
              nouveau.add(heure3);
          }
          if(i == 24){
              nouveau.add(heure4);
          }
          if(i == 30){
              nouveau.add(heure5);
          }
           if(i == 36){
              nouveau.add(heure6);
          }
          if(i == 42){
              nouveau.add(heure7);
          }
          for(int j=0; j<tab_case.length; j++)
          {
            if(i == tab_case[j])
            {
                JLabel cours = new JLabel(" reussi  ");
                nouveau.add(cours);
            }
          }
          
          nouveau.setBorder(BorderFactory.createLineBorder(Color.black,1));
          container.add(nouveau);
     
     setContentPane(container);
      
      setVisible(true);
      
     
  }
  
      
      

}
}

