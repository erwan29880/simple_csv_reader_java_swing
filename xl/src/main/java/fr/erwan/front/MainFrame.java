package fr.erwan.front;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import fr.erwan.csv.Fichier;


/**
 * Classe de l'affichage du tableau
 */
public class MainFrame extends JFrame{
    private int windowsWidth = 600, WindowsHeight = 600;
    private Fichier fichier;

    public MainFrame(Fichier fichier) {
        this.fichier = fichier;
        this.setTitle("csv reader");
        this.setSize(this.windowsWidth, this.WindowsHeight);
        this.setLocationRelativeTo(null);
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTable tableau = new JTable(this.fichier.getCorps(), this.fichier.getEntete());
        tableau.setAutoCreateRowSorter(true);
        getContentPane().add(tableau.getTableHeader(), BorderLayout.NORTH);
        getContentPane().add(new JScrollPane(tableau), BorderLayout.CENTER);
 
        pack();
    }
}
