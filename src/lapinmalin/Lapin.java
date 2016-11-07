package lapinmalin;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Gildasftw on 11/10/2016.
 */
public class Lapin extends Objet {
    protected static double PAS = 2;
    protected static double PROB_CHGT_DIRECTION = 0.05;
    protected static int ZONE_INFLUENCE_LAPIN = 70;

    protected double vitesseX;
    protected double vitesseY;
    protected boolean estMort = false;

    protected void Normaliser() {
        double longueur = Math.sqrt(vitesseX * vitesseX + vitesseY * vitesseY);
        vitesseX /= longueur;
        vitesseY /= longueur;
    }

    public Lapin(double _posX, double _posY) {
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
    }

    protected void MiseAJourDirection() {
        // Déplacement aléatoire
        if (Environnement.getInstance().generateur.nextDouble() < PROB_CHGT_DIRECTION) {
            vitesseX = Environnement.getInstance().generateur.nextDouble() - 0.5;
            vitesseY = Environnement.getInstance().generateur.nextDouble() - 0.5;
        }
        Normaliser();
    }

    public int zoneInfluence() {
        return ZONE_INFLUENCE_LAPIN;
    }

    public boolean estVivant() {
        return !estMort;
    }

    public void setPas(double pas) {this.PAS = pas;}
    public double getPas() { return this.PAS;}

    public void setProbChgtDirection(double probChgtDirection) { this.PROB_CHGT_DIRECTION = probChgtDirection;}
    public double getProbChgtDirection() {return this.PROB_CHGT_DIRECTION;}
}
