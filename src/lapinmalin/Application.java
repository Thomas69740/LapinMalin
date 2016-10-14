package lapinmalin;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Gildasftw on 11/10/2016.
 */
public class Application {
    public static void main(String[] args) {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        JFrame fenetre = new JFrame();
        fenetre.setTitle("Lapin Malin");
        fenetre.setSize(600, 400);
        fenetre.setLocation(dim.width/2-fenetre.getSize().width/2 - 205, dim.height/2-fenetre.getSize().height/2);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setResizable(false);

        JFrame paramFrame = new JFrame();
        paramFrame.setTitle("Paramètres");
        paramFrame.setSize(400, 400);
        paramFrame.setLocation(dim.width/2-paramFrame.getSize().width/2 + 305, dim.height/2-paramFrame.getSize().height / 2);
        paramFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        paramFrame.setResizable(false);


        JPanel paramPanel = new JPanel();
        paramPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        paramPanel.setBackground(Color.WHITE);
        paramPanel.setLayout(new GridBagLayout());

        GridBagConstraints left = new GridBagConstraints();
        GridBagConstraints right = new GridBagConstraints();
        left.anchor = GridBagConstraints.EAST;
        right.weightx = 2.0;
        right.fill = GridBagConstraints.HORIZONTAL;
        right.gridwidth = GridBagConstraints.REMAINDER;

        JLabel nbRenardsStartLabel = new JLabel("Nombre renards début : ");
        JLabel nbLapinsStartLabel = new JLabel("Nombre lapins début : ");
        JLabel frequenceLapinsLabel = new JLabel("Nb tours création d'un lapin : ");
        JLabel zoneInfluenceLapinLabel = new JLabel("Zone d'influence d'un lapin : ");
        JLabel pasLapinLabel = new JLabel("Pas d'un lapin : ");
        JLabel pasRenardLabel = new JLabel("Pas d'un renard : ");
        JLabel gainVieLabel = new JLabel("Regain PV renard : ");
        JLabel vieLabel = new JLabel("Vie d'un renard : ");
        JLabel periodRateLabel = new JLabel("Durée d'une période : ");
        JLabel nbRenardsLabel = new JLabel("Nombre de renards en vie : ");
        JLabel nbLapinsLabel = new JLabel("Nombre de lapins en vie : ");

        JTextField nbRenardsStartText = new JTextField();
        JTextField nbLapinsStartText = new JTextField();
        JTextField frequenceLapinText = new JTextField();
        JTextField zoneInfluenceLapinText = new JTextField();
        JTextField pasLapinText = new JTextField();
        JTextField pasRenardText = new JTextField();
        JTextField gainVieText = new JTextField();
        JTextField vieText = new JTextField();
        JTextField periodRateText = new JTextField();
        JTextField nbRenardsText = new JTextField();
        JTextField nbLapinsText = new JTextField();

        nbRenardsText.setEditable(false);
        nbLapinsText.setEditable(false);

        paramPanel.add(nbRenardsStartLabel, left);
        paramPanel.add(nbRenardsStartText, right);
        paramPanel.add(nbLapinsStartLabel, left);
        paramPanel.add(nbLapinsStartText, right);
        paramPanel.add(frequenceLapinsLabel, left);
        paramPanel.add(frequenceLapinText, right);
        paramPanel.add(zoneInfluenceLapinLabel, left);
        paramPanel.add(zoneInfluenceLapinText, right);
        paramPanel.add(pasLapinLabel, left);
        paramPanel.add(pasLapinText, right);
        paramPanel.add(pasRenardLabel, left);
        paramPanel.add(pasRenardText, right);
        paramPanel.add(gainVieLabel, left);
        paramPanel.add(gainVieText, right);
        paramPanel.add(vieLabel, left);
        paramPanel.add(vieText, right);
        paramPanel.add(periodRateLabel, left);
        paramPanel.add(periodRateText, right);
        paramPanel.add(nbRenardsLabel, left);
        paramPanel.add(nbRenardsText, right);
        paramPanel.add(nbLapinsLabel, left);
        paramPanel.add(nbLapinsText, right);





        paramFrame.setContentPane(paramPanel);
        paramFrame.setVisible(true);

        LapinPanel panel = new LapinPanel();
        fenetre.setContentPane(panel);
        fenetre.setVisible(true);
        panel.Lancer();
    }
}
