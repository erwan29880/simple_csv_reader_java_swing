package fr.erwan.csv;
import java.util.Vector;

/**
 * Classe du modèle du tableau
 */
public class Fichier {
    private Vector<Vector> corps;
    private Vector entete; 
    private int nbLignes;
    private int nbColonnes;

    public Vector<Vector> getCorps() {
        return this.corps;
    }

    public void setCorps(Vector<Vector> corps) {
        this.corps = corps;
    }

    public int getNbLignes() {
        return this.nbLignes;
    }

    public void setNbLignes(int nbLignes) {
        this.nbLignes = nbLignes;
    }

    public int getNbColonnes() {
        return this.nbColonnes;
    }

    public void setNbColonnes(int nbColonnes) {
        this.nbColonnes = nbColonnes;
    }
    
    public Vector getEntete() {
        return this.entete;
    }

    public void setEntete(Vector entete) {
        this.entete = entete;
    }
   


}
