package lapinmalin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;
import java.util.Timer;

/**
 * Created by Gildasftw on 11/10/2016.
 */
public class LapinPanel extends JPanel implements Observer, MouseListener {

    Timer timer;
    boolean enCours = false;
    TimerTask tache;
    Environnement env;
    static int PERIOD = 10;
    static int DELAY = 0;
    static int NB_RENARDS_START = 3;
    static int NB_LAPINS_START = 10;
    protected JTextField nbLapinsField;
    protected JTextField nbRenardsField;

    public LapinPanel() {
        this.setBackground(Color.WHITE);
        this.addMouseListener(this);
    }

    public void Lancer(JTextField nbl, JTextField nbr) {
        env = Environnement.getInstance();
        nbLapinsField = nbl;
        nbRenardsField = nbr;
        env.Initialiser(NB_LAPINS_START, NB_RENARDS_START, getWidth() - 10, getHeight() - 5);
        env.addObserver(this);
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if (enCours) {
            // On arrête le timer
            timer.cancel();
            timer = null;
            enCours = false;
        }
        else {
            // On lance le timer
            timer = new java.util.Timer();
            tache = new TimerTask() {
                @Override
                public void run() {
                    env.MiseAJour();
                }
            };
            timer.scheduleAtFixedRate(tache, DELAY, PERIOD);
            enCours = true;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void update(Observable o, Object arg) {
        this.repaint();
        int lapinsVivant = 0;
        int renardsVivant = 0;
        for (Lapin a : env.lapins) {
            if (a.estVivant()) {
                lapinsVivant++;
            }
        }

        for (Renard a : env.renards) {
            if (a.estVivant()) {
                renardsVivant++;
            }
        }
        nbLapinsField.setText(Integer.toString(lapinsVivant));
        nbRenardsField.setText(Integer.toString(renardsVivant));
        //System.out.println(env.lapins.size() + " - " + lapinsVivant + "       " + env.renards.size() + " - " + renardsVivant);
    }

    public void DessinerAgent(Objet obj, Graphics g) {
        if (obj instanceof Lapin) {
            if (((Lapin)obj).estVivant()) {
                Color lapinColor = new Color(17, 145, 55);
                g.setColor(lapinColor);
            }
        }
        else {
            if (((Renard)obj).estVivant()) {
                Color renardColor = new Color(255, 35, 0);
                g.setColor(renardColor);
            }
        }

        g.fillRect((int) obj.posX - 1, (int) obj.posY - 1, 5, 5);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Lapin lapin : env.lapins) {
            DessinerAgent(lapin, g);
        }
        for (Renard renard : env.renards) {
            DessinerAgent(renard, g);
        }
    }

    public int getPeriod() {return PERIOD;}
    public void setPeriod(int period) {this.PERIOD = period;}
    public int getDelay() {return DELAY;}
    public void setDelay(int delay) {this.DELAY = delay;}
}
