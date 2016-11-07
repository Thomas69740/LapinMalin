package lapinmalin;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Gildasftw on 11/10/2016.
 */
public class Renard extends Objet {
    protected static double PAS = 2;
    protected static double PROB_CHGT_DIRECTION = 0.05;
    protected static int GAIN_LIFE = 200;
    protected static int TURN_BEFORE_DIE = 400;

    protected double vitesseX;
    protected double vitesseY;
    protected boolean estMort = false;
    protected int turnBeforeDie = TURN_BEFORE_DIE;

    protected void Normaliser() {
        double longueur = Math.sqrt(vitesseX * vitesseX + vitesseY * vitesseY);
        vitesseX /= longueur;
        vitesseY /= longueur;
    }

    public Renard(double _posX, double _posY) {
        posX = _posX;
        posY = _posY;
        vitesseX = Environnement.getInstance().generateur.nextDouble() - 0.5;
        vitesseY = Environnement.getInstance().generateur.nextDouble() - 0.5;
        Normaliser();
    }

    public void MiseAJourPosition() {
        posX += PAS * vitesseX;
        posY += PAS * vitesseY;
        double largeur = Environnement.getInstance().getLargeur();
        double hauteur = Environnement.getInstance().getHauteur();
        if (posX < 0) {
            posX = 0;
        }
        else if (posX > largeur) {
            posX = largeur;
        }
        if (posY < 0) {
            posY = 0;
        }
        else if (posY > hauteur) {
            posY = hauteur;
        }
        ArrayList<Lapin> lapins = Environnement.getInstance().lapins;

        for(Lapin lapin : lapins) {
            if ((lapin.posX < posX + 5 && lapin.posX > posX - 5) && (lapin.posY < posY + 5 && lapin.posY > posY - 5)) {
                lapin.estMort = true;
                turnBeforeDie += GAIN_LIFE;
                System.out.println("Un lapin a été mangé !");
            }
        }
    }

    protected void MiseAJourDirection(ArrayList<Lapin> lapins) {
        // Déplacement aléatoire
        ArrayList<Lapin> dansZone = new ArrayList();
        dansZone.addAll(lapins);
        dansZone.removeIf(l -> (Distance(l) > l.zoneInfluence()));
        Collections.sort(dansZone, (Lapin l1, Lapin l2) -> (Distance(l1) < Distance(l2) ? -1: 1));
        Lapin but = null;
        if (!dansZone.isEmpty())
                but = dansZone.get(0);
        if (but == null) {
            if (Environnement.getInstance().generateur.nextDouble() < PROB_CHGT_DIRECTION) {
                vitesseX = Environnement.getInstance().generateur.nextDouble() - 0.5;
                vitesseY = Environnement.getInstance().generateur.nextDouble() - 0.5;
            }
        }
        else {
            vitesseX = but.posX - posX;
            vitesseY = but.posY - posY;
        }
        Normaliser();
    }
    public boolean estVivant() {
        return !estMort;
    }

    public void updateAndCheckIfDead() {
        turnBeforeDie--;
        if (turnBeforeDie == 0) {
            estMort = true;
        }
    }

    public void setPas(double pas) { this.PAS = pas; }
    public double getPas() { return this.PAS; }

    public void setTurnBeforeDie(int nbTurn) { this.turnBeforeDie = nbTurn; }
    public int getTurnBeforeDie() { return this.turnBeforeDie; }

    public void setProbChgtDirection( double probChgtDirection) { this.PROB_CHGT_DIRECTION = probChgtDirection; }
    public double getProbChgtDirection() { return this.PROB_CHGT_DIRECTION; }
}
