package fr.erwan.front;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import fr.erwan.erreurs.OpenerException;

/**
 * Affichage de la fenêtre d'ouverture de fichier csv
 */
public class Opener {
    
    public File op() throws OpenerException{
        File selectedFile = null;
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        jfc.setDialogTitle("Select a csv");

        // filtre csv
		jfc.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Csv files", "csv");
        jfc.addChoosableFileFilter(filter);

        // affichage fenêtre
        int returnValue = jfc.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            selectedFile = jfc.getSelectedFile();
        } else {
            throw new OpenerException("Le fichier n'a pas pu être ouvert !");
        }
        return selectedFile;
    }
}
