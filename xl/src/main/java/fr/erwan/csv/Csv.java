package fr.erwan.csv;

import java.io.FileReader;
import java.nio.charset.Charset;
import java.util.Vector;
import java.io.BufferedReader;
import java.io.File;
import fr.erwan.csv.Fichier;
import fr.erwan.erreurs.CsvException;

/**
 * Classe de lecture d'un csv, et mise en forme en vecteurs pour affichage par swing JTable
 */
public class Csv {
    
    private File file = null;

    public Csv() {}

    public Csv(File file) {
        this.file = file;
    }

    private Fichier readCsv() {
        FileReader fr = null;
        Fichier fichier = new Fichier();
        Vector<Vector> data = new Vector<Vector>();
        try {   
            fr = new FileReader(this.file, Charset.forName("utf-8"));  
           
            // parcourir les lignes
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();

            long compte = line.chars().filter(c -> c == ',').count();
            if (compte == 0) {
                return fichier;
            }

            // entête
            String s = line.replace("\"", "");
            fichier.setEntete(this.sousVecteur(s));
            line = br.readLine();

            // corps
            while(line!=null) {
                data.add(this.sousVecteur(line));
                line = br.readLine();
            }
            fichier.setCorps(data);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                fr.close();
            } catch (Exception e) {
                System.out.println("problème de fermeture de fichier");
            }
        }
        return fichier;
    }


    /**
     * Séparer la chaîne de caractère selon le séparateur "virgule" et mise en vecteur
     * @param s une ligne de fichier csv au format chaîne de caractères
     * @return un vecteur
     */
    private Vector sousVecteur(String s) {
        Vector v = new Vector();
        String[] prov = s.split(",");
        for (int i=0; i < prov.length; i++) {
            v.add(prov[i]);
        }    
        return v;
    }

    public Fichier getCsv() throws CsvException{
        Fichier fichier = this.readCsv();
        if (fichier.getEntete() == null || fichier.getCorps() == null) {
            throw new CsvException("le fichier ne semble pas être un fichier csv");
        }
        return fichier;
    }

}
