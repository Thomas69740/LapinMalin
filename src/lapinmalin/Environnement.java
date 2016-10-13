package lapinmalin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;
import java.util.Random;

/**
 * Created by Gildasftw on 11/10/2016.
 */
public class Environnement extends Observable {
    private static Environnement instance;
    protected Random generateur;
    protected double largeur;
    protected double hauteur;
    protected ArrayList<Lapin> lapins;
    protected ArrayList<Renard> renards;
    protected int nbIterations = 0;

    private Environnement() {
        lapins = new ArrayList();
        renards = new ArrayList();
        generateur = new Random();
    }

    public static Environnement getInstance() {
        if (instance == null) {
            instance = new Environnement();
        }
        return instance;
    }
    public void Initialiser(int _nbLapins, int _nbRenards, double _largeur, double _hauteur) {
        largeur = _largeur;
        hauteur = _hauteur;

        lapins.clear();
        for (int i = 0; i < _nbLapins; i++) {
            Lapin lapin = new Lapin(generateur.nextDouble() * largeur, generateur.nextDouble() * hauteur);
            lapins.add(lapin);
        }

        renards.clear();
        for (int i = 0; i < _nbRenards; i++) {
            Renard renard = new Renard(generateur.nextDouble() * largeur, generateur.nextDouble() * hauteur);
            renards.add(renard);
        }
    }

    public void MiseAJour() {
        for (Lapin lapin : lapins) {
            if (!lapin.estVivant())
                lapins.remove(lapin);
            else {
                lapin.MiseAJourDirection(lapins);
                lapin.MiseAJourPosition();
            }
        }

        for (Renard renard : renards) {
            if (!renard.estVivant())
                renards.remove(renard);
            else {
                renard.MiseAJourDirection(renards);
                renard.MiseAJourPosition();
            }
        }
        nbIterations++;
        if (nbIterations % 500 == 0) {
            Collections.reverse(lapins);
            Collections.reverse(renards);
        }

        setChanged();
        notifyObservers();
    }

    public double getLargeur() {
        return largeur;
    }
    public double getHauteur() {
        return hauteur;
    }
}
