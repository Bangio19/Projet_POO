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
public class Salle {
    private int m_id;
    private String m_nom;
    private int m_capacite;
    private int m_idSite;
    
    public Salle(int id, String nom, int capacite, int id_site){
        m_id=id;
        m_nom=nom;
        m_capacite=capacite;
        m_idSite=id_site;
    }
    
    public int getId(){return m_id;}
    public String getNom(){return m_nom;}
    public int getCapacite(){return m_capacite;}
    public int getIdSite(){return m_idSite;}

    public void setNom(String nom){m_nom=nom;}
    public void setCapacite(int capacite){m_capacite=capacite;}
    public void setIdSite(int id_site){m_idSite=id_site;}
}
