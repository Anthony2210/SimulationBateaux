package Ressources;

import Pathfinding.*;

import java.awt.*;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PointDePeche {
    private static int compteurPointsDePeche = 0;
    private int numeroPointDePeche;
    private Point position;
    private static Lock verrou = new ReentrantLock();

    public PointDePeche(int x, int y, Grille grille) {
        this.position = new Point(x, y);
        this.numeroPointDePeche = ++compteurPointsDePeche;
        grille.placerPointDePeche(x, y);
    }

    public int getNumeroPointDePeche() {
        return numeroPointDePeche;
    }

    public Point getPosition() {
        return position;
    }

    public Ressource estPecher() {
        // Logique pour générer une ressource aléatoire (Poisson, Tresor, Algue)
        Random random = new Random();
        int randomValue = random.nextInt(3); // Génère un nombre aléatoire entre 0 (inclus) et 3 (exclus)

        switch (randomValue) {
            case 0:
                return new Algues();
            case 1:
                return new Poisson();
            case 2:
                return new Tresor();
            default:
                // En cas de problème, retourne null
                return null;
        }
    }
    public static boolean essayerPecher() {
        return verrou.tryLock();
    }
    public static void relacherVerrou() {
        verrou.unlock();
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        PointDePeche that = (PointDePeche) obj;
        return numeroPointDePeche == that.numeroPointDePeche;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroPointDePeche);
    }
    @Override
    public String toString() {
        return "PointDePeche n°"+ numeroPointDePeche +
                ": "+ position ;
    }

}