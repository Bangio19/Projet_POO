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
public class Utilisateur {
    private int m_id;
    private String m_email;
    private String m_mdp;
    private String m_nom;
    private String m_prenom;
    private int m_droit;
    
    public Utilisateur(int id, String email, String mdp, String nom, String prenom, int droit)
    {
        m_id = id;
        m_email = email;
        m_mdp = mdp;
        m_nom = nom;
        m_prenom = prenom;
        m_droit = droit;
    }
    
    public int getId(){return m_id;}
    
    public String getEmail(){return m_email;}
    public String getMdp(){return m_mdp;}
    public String getNom(){return m_nom;}
    public String getPrenom(){return m_prenom;}
    public int getDroit(){return m_droit;}
    

    public void setEmail(String email){m_email=email;}
    public void setMdp(String mdp){m_mdp=mdp;}
    public void setNom(String nom){m_nom=nom;}
    public void setPrenom(String prenom){m_prenom=prenom;}
    public void setDroit(int droit){m_droit=droit;}
    
}
