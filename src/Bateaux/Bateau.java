package Bateaux;

import Pathfinding.*;
import Ressources.Ressource;

import java.awt.*;
import java.util.ArrayList;


public abstract class Bateau {
    //protected int bateauLargeur = 40;
    //protected int bateauLongueur = 20;
    protected Point position;
    protected Point vectorDeplacement;
    protected double vitesse;
    private static int compteurBateau = 0;
    protected int numeroBateau;
    protected ArrayList<Ressource> inventaire;    // Inventaire des ressources
    protected int capaciteMaxInventaire;         // Capacité maximale de l'inventaire
    private int valeurTotaleRessources = 0;
    private Grille grille;


    public Bateau(int positionX, int positionY, double vitesse) {
        this.position = new Point(positionX, positionY);
        this.vectorDeplacement = new Point(0, 0);
        //this.vitesse = vitesse;
        this.numeroBateau = ++compteurBateau;
        this.inventaire = new ArrayList<>();

    }
    public ArrayList<Ressource> getInventaire() {
        return inventaire;
    }
    public double getVitesse() {
        return vitesse;
    }

    // Méthode pour ajouter une ressource à l'inventaire du bateau
    public void ajouterRessource(Ressource ressource) {
        if (ressource != null) {
            // Vérifier si l'inventaire du bateau n'est pas plein
            if (inventaire.size() < capaciteMaxInventaire) {
                // Ajouter la ressource à l'inventaire du bateau
                inventaire.add(ressource);
                // Mettre à jour la valeur totale des ressources
                valeurTotaleRessources += ressource.getValeur();
                System.out.println("Ressource ajoutée à l'inventaire du bateau.");
            } else {
                System.out.println("L'inventaire du bateau est plein. La ressource n'a pas été ajoutée.");
            }
        }
    }
    // Méthode pour obtenir la valeur totale des ressources du bateau
    public int getValeurTotaleRessources() {
        return valeurTotaleRessources;
    }


    /*public void seDeplacerFluidement() {
        double deplacementX = vectorDeplacement.getX() * vitesse;
        double deplacementY = vectorDeplacement.getY() * vitesse;

        this.position.setLocation(this.position.getX() + deplacementX, this.position.getY() + deplacementY);
        System.out.println("Le bateau se déplace à la position (" + this.position.getX() + ", " + this.position.getY() + ")");
    }
    public void seDeplacerVersDestination(Point destination, Grille grille) {
        List<Point> chemin = AStar.trouverChemin(getPosition(), destination, grille);
        System.out.println(chemin);

        if (chemin != null && !chemin.isEmpty()) {
            Point prochainePosition = chemin.get(0);
            setVectorDeplacement(prochainePosition.x - position.x, prochainePosition.y - position.y);
            seDeplacerFluidement();
        }
    }
    public void setGrille(Grille grille) {
        this.grille = grille;
    }
    protected Grille getGrille() {
        return grille;
    }


    public void setVectorDeplacement(int deltaX, int deltaY) {
        this.vectorDeplacement.setLocation(deltaX, deltaY);
    }
    /*public int getBateauLargeur() {
        return bateauLargeur;
    }

    public int getBateauLongueur() {
        return bateauLongueur;
    }*/

    public void setPosition(Point position) {
        this.position = position;
    }

    public Point getPosition() {
        return position;
    }

    public int getNumeroBateau() {
        return numeroBateau;
    }

    public static int getCompteurBateau() {
        return compteurBateau;
    }

    public int getCapaciteMaxInventaire() {
        return capaciteMaxInventaire;
    }

    public static void setCompteurBateau(int compteurBateau) {
        Bateau.compteurBateau = compteurBateau;
    }

    public void setValeurTotaleRessources(int valeurTotaleRessources) {
        this.valeurTotaleRessources = valeurTotaleRessources;
    }

    public Grille getGrille() {
        return grille;
    }

    public void setGrille(Grille grille) {
        this.grille = grille;
    }
}