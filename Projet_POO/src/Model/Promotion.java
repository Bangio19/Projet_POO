/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author adrie
 */
public class Promotion {
    private int m_id;
    private String m_nom;
  
    
    public Promotion(int id, String nom){
        m_id=id;
        m_nom=nom;
    }
    
    public int getId(){return m_id;}
    public String getNom(){return m_nom;}
    
    public void setNom(String nom){m_nom=nom;}
}
