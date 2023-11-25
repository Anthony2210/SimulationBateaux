package Pathfinding;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Grille {
    private Noeud[][] grille;
    private int largeur;
    private int hauteur;

    public Grille(int largeur, int hauteur) {
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.grille = new Noeud[largeur][hauteur];

        // Initialiser la grille avec des nœuds
        for (int x = 0; x < largeur; x++) {
            for (int y = 0; y < hauteur; y++) {
                grille[x][y] = new Noeud(x, y);
            }
        }
    }
    public void afficherGrille() {
        for (int y = 0; y < hauteur; y++) {
            for (int x = 0; x < largeur; x++) {
                System.out.print(grille[x][y].estObstacle() ? "X" : "O");
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public Noeud getNoeud(int x, int y) {
        return grille[x][y];
    }

    public List<Noeud> getVoisins(Noeud noeud) {
        List<Noeud> voisins = new ArrayList<>();

        // Ajouter les voisins horizontaux et verticaux
        ajouterVoisin(voisins, noeud.getX() - 1, noeud.getY());
        ajouterVoisin(voisins, noeud.getX() + 1, noeud.getY());
        ajouterVoisin(voisins, noeud.getX(), noeud.getY() - 1);
        ajouterVoisin(voisins, noeud.getX(), noeud.getY() + 1);

        // Ajouter les voisins diagonaux
        //ajouterVoisin(voisins, noeud.getX() - 1, noeud.getY() - 1);
        //ajouterVoisin(voisins, noeud.getX() - 1, noeud.getY() + 1);
        //ajouterVoisin(voisins, noeud.getX() + 1, noeud.getY() - 1);
       // ajouterVoisin(voisins, noeud.getX() + 1, noeud.getY() + 1);

        return voisins;
    }

    private void ajouterVoisin(List<Noeud> voisins, int x, int y) {
        if (estDansLaGrille(x, y)) {
            System.out.println("Voisin potentiel à : " + x + ", " + y);
            Noeud voisin = grille[x][y];
            if (!voisin.estObstacle()) {
                voisins.add(voisin);
            } else {
                System.out.println("Obstacle trouvé à : " + x + ", " + y);
            }
        }
    }

    private boolean estDansLaGrille(int x, int y) {
        return x >= 0 && x < largeur && y >= 0 && y < hauteur;
    }

}