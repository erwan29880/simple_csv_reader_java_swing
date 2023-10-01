package fr.erwan;
import fr.erwan.csv.Fichier;
import fr.erwan.erreurs.CsvException;
import fr.erwan.erreurs.OpenerException;

import java.io.File;
import fr.erwan.csv.Csv;
import fr.erwan.front.MainFrame;
import fr.erwan.front.Opener;
import fr.erwan.front.ErrorFrame;

public class Main {
    public static void main(String[] args) {
        try {
            // fenêtre d'ouverture de fichier
            Opener o = new Opener();
            File file = o.op();
            
            // lecture du fichier
            Csv f = new Csv(file);
            Fichier fichier = f.getCsv();
            
            // affichage du tableau
            MainFrame frame = new MainFrame(fichier);
            frame.setVisible(true);
        
        } catch (OpenerException e) {
            ErrorFrame efa = new ErrorFrame(e.getMessage());
        } catch (CsvException e) {
            ErrorFrame efb = new ErrorFrame(e.getMessage());
        } catch (Exception e) {
            ErrorFrame efc = new ErrorFrame(e.getMessage());
        } 
    }
}