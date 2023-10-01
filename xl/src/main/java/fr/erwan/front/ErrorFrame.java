package fr.erwan.front;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

/**
 * affichage d'une fenêtre d'erreur si besoin
 */
public class ErrorFrame extends JFrame{
    private int windowsWidth = 400, WindowsHeight = 200;

    public ErrorFrame(String mess) {
        this.setTitle("erreur");
        this.setPreferredSize(new Dimension(this.windowsWidth, this.WindowsHeight));
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel lab = new JLabel(mess);
        lab.setHorizontalAlignment(SwingConstants.CENTER);
        lab.setVerticalAlignment(SwingConstants.CENTER);
        getContentPane().add(new JScrollPane(lab));

        pack();
        setVisible(true);
    }
}