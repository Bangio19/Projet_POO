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
public class Etudiant {
    private int m_id;
    private int m_numero;
    private int m_idGroupe;
    
    public Etudiant(int id, int numero, int idGroupe){
        m_id=id;
        m_numero=numero;
        m_idGroupe=idGroupe;
    }
    
    public int getId(){return m_id;}
    public int getNumero(){return m_numero;}
    public int getIdGroupe(){return m_idGroupe;}

    public void setNumero(int numero){m_numero=numero;}
    public void setIdGroupe(int idGroupe){m_idGroupe=idGroupe;}
}
