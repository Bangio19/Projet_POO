/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
/**
 *
 * @author Bauti
 */
public class Enseignant {
    private int m_id;
    
    //Quelle méthode faire? Une liste ou faire des associations 1:1?
    //private ArrayList<Cours> listCours;
    private int m_idCours;
  
    
    public Enseignant(int id, int idCours){
        m_id=id;
        m_idCours=idCours;
    }
    
    public int getId(){return m_id;}
    public int getCours(){return m_idCours;}

    //public void setCours(String nom){m_nom=nom;}
}
