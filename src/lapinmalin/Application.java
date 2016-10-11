package lapinmalin;

import javax.swing.JFrame;
/**
 * Created by Gildasftw on 11/10/2016.
 */
public class Application {
    public static void main(String[] args) {
        JFrame fenetre = new JFrame();
        fenetre.setTitle("Lapin Malin");
        fenetre.setSize(600, 400);
        fenetre.setLocationRelativeTo(null);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setResizable(false);

        LapinPanel panel = new LapinPanel();
        fenetre.setContentPane(panel);
        fenetre.setVisible(true);
        panel.Lancer();
    }
}
