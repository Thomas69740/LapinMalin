package lapinmalin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        GridBagConstraints bottom = new GridBagConstraints();
        left.anchor = GridBagConstraints.EAST;
        right.weightx = 2.0;
        right.fill = GridBagConstraints.HORIZONTAL;
        right.gridwidth = GridBagConstraints.REMAINDER;

        JLabel nbRenardsStartLabel = new JLabel("Nombre renards début ");
        JLabel nbLapinsStartLabel = new JLabel("Nombre lapins début ");
        JLabel frequenceLapinsLabel = new JLabel("Nb tours création d'un lapin ");
        JLabel frequenceRenardsLabel = new JLabel("Nb tours création d'un renard ");
        JLabel zoneInfluenceLapinLabel = new JLabel("Distance de visibilité d'un renard ");
        JLabel pasLapinLabel = new JLabel("Pas d'un lapin ");
        JLabel pasRenardLabel = new JLabel("Pas d'un renard ");
        JLabel gainVieLabel = new JLabel("Regain PV renard ");
        JLabel vieLabel = new JLabel("Nb tours avant mort d'un renard ");
        JLabel nbRenardsLabel = new JLabel("<html>Nombre de <font color='#FF2300'>renards</font> en vie </html> ");
        JLabel nbLapinsLabel = new JLabel("<html>Nombre de <font color='#119137'>lapins</font> en vie </html> ");

        JTextField nbRenardsStartText = new JTextField();
        JTextField nbLapinsStartText = new JTextField();
        JTextField frequenceLapinText = new JTextField();
        JTextField frequenceRenardText = new JTextField();
        JTextField zoneInfluenceLapinText = new JTextField();
        JTextField pasLapinText = new JTextField();
        JTextField pasRenardText = new JTextField();
        JTextField gainVieText = new JTextField();
        JTextField vieText = new JTextField();
        JTextField nbRenardsText = new JTextField();
        JTextField nbLapinsText = new JTextField();

        JButton submitButton = new JButton("Recharger");

        nbRenardsText.setEditable(false);
        nbLapinsText.setEditable(false);

        paramPanel.add(nbRenardsStartLabel, left);
        paramPanel.add(nbRenardsStartText, right);
        paramPanel.add(nbLapinsStartLabel, left);
        paramPanel.add(nbLapinsStartText, right);
        paramPanel.add(frequenceLapinsLabel, left);
        paramPanel.add(frequenceLapinText, right);
        paramPanel.add(frequenceRenardsLabel, left);
        paramPanel.add(frequenceRenardText, right);
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
        paramPanel.add(nbRenardsLabel, left);
        paramPanel.add(nbRenardsText, right);
        paramPanel.add(nbLapinsLabel, left);
        paramPanel.add(nbLapinsText, right);
        paramPanel.add(submitButton, left);

        nbRenardsStartText.setText(Integer.toString(LapinPanel.NB_RENARDS_START));
        nbLapinsStartText.setText(Integer.toString(LapinPanel.NB_LAPINS_START));
        frequenceLapinText.setText(Integer.toString(Environnement.getInstance().FREQUENCE_APPARITION_LAPIN));
        frequenceRenardText.setText(Integer.toString(Environnement.getInstance().FREQUENCE_APPARITION_RENARD));
        zoneInfluenceLapinText.setText(Integer.toString(Lapin.ZONE_INFLUENCE_LAPIN));
        pasLapinText.setText(Double.toString(Lapin.PAS));
        pasRenardText.setText(Double.toString(Renard.PAS));
        gainVieText.setText(Integer.toString(Renard.GAIN_LIFE));
        vieText.setText(Integer.toString(Renard.TURN_BEFORE_DIE));

        paramFrame.setContentPane(paramPanel);
        paramFrame.setVisible(true);

        LapinPanel panel = new LapinPanel();
        fenetre.setContentPane(panel);
        fenetre.setVisible(true);
        panel.Lancer(nbLapinsText, nbRenardsText);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LapinPanel.NB_LAPINS_START = Integer.parseInt(nbLapinsStartText.getText());
                LapinPanel.NB_RENARDS_START = Integer.parseInt(nbRenardsStartText.getText());
                Environnement.getInstance().FREQUENCE_APPARITION_LAPIN = Integer.parseInt(frequenceLapinText.getText());
                Environnement.getInstance().FREQUENCE_APPARITION_RENARD = Integer.parseInt(frequenceRenardText.getText());
                Lapin.ZONE_INFLUENCE_LAPIN = Integer.parseInt(zoneInfluenceLapinText.getText());
                Lapin.PAS = Double.parseDouble(pasLapinText.getText());
                Renard.PAS = Double.parseDouble(pasRenardText.getText());
                Renard.GAIN_LIFE = Integer.parseInt(gainVieText.getText());
                Renard.TURN_BEFORE_DIE = Integer.parseInt(vieText.getText());

                panel.Lancer(nbLapinsText, nbRenardsText);
                panel.revalidate();
                panel.repaint();
            }
        });
    }
}
