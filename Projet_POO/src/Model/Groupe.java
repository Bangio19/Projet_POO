/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Bauti
 */
public class Groupe {
    private int m_id;
    private String m_nom;
    private int m_idPromotion;
    
    public Groupe(int id, String nom, int idPromotion){
        m_id=id;
        m_nom=nom;
        m_idPromotion=idPromotion;
    }
    
    public int getId(){return m_id;}
    public String getNom(){return m_nom;}
    public int getIdPromotion(){return m_idPromotion;}

    public void setNom(String nom){m_nom=nom;}
    public void setIdPromotion(int idPromotion){m_idPromotion=idPromotion;}
    
     public String toString(String nom){
        return "Id: "+m_id+", Groupe: "+nom+", Promotion: "+nom;
    }
}
