package Pathfinding;

import java.awt.Point;

public class Noeud implements Comparable<Noeud> {
    private int x;
    private int y;
    private boolean chemin;
    private double cout; // Coût pour accéder à ce nœud
    private boolean obstacle; // Indique si le nœud est un obstacle
    private Noeud noeudPrecedent; // Nœud précédent sur le chemin optimal

    public Noeud(int x, int y) {
        this.x = x;
        this.y = y;
        this.chemin = false;
        this.obstacle = false; // Par défaut, le nœud est un obstacle
        this.cout = 0;

        this.noeudPrecedent = null;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public boolean isChemin() {
        return chemin;
    }

    public void setChemin(boolean chemin) {
        this.chemin = chemin;
    }
    public Point getPosition() {
        return new Point(x, y);
    }

    public boolean estObstacle() {
        return obstacle;
    }

    public void setObstacle(boolean obstacle) {
        this.obstacle = obstacle;
    }

    public double getCout() {
        return cout;
    }

    public void setCout(double cout) {
        this.cout = cout;
    }



    public Noeud getNoeudPrecedent() {
        return noeudPrecedent;
    }

    public void setNoeudPrecedent(Noeud noeudPrecedent) {
        this.noeudPrecedent = noeudPrecedent;
    }

    @Override
    public int compareTo(Noeud autre) {
        // Comparaison basée sur la somme du coût
        double sommeCoutHeuristique = this.cout ;
        double sommeCoutHeuristiqueAutre = autre.cout;

        return Double.compare(sommeCoutHeuristique, sommeCoutHeuristiqueAutre);
    }
}