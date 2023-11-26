package Bateaux;

import Pathfinding.*;
import Ressources.*;
//import GUI.PointDePeche;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BateauxPecheurs extends Bateau {
    private static final long tempsDePeche = 3000; //3sec
    private List<PointDePeche> pointsDejaPeche = new ArrayList<>();

    public BateauxPecheurs(int positionX, int positionY, double vitesse) {
        super(positionX, positionY, vitesse);
        this.capaciteMaxInventaire = 50;

    }
    // Méthode pour trouver le point de pêche le plus proche
    public static PointDePeche trouverPointPecherLePlusProche(Point positionBateau, List<PointDePeche> pointsDePeches) {
        PointDePeche pointLePlusProche = null;
        double distanceMinimale = Double.MAX_VALUE;

        for (PointDePeche pointDePeche : pointsDePeches) {
            double distance = AStar.calculerDistance(positionBateau, pointDePeche.getPosition());
            if (distance < distanceMinimale) {
                distanceMinimale = distance;
                pointLePlusProche = pointDePeche;
            }
        }

        return pointLePlusProche;
    }
    public void pecher(PointDePeche pointDePeche) {
        // Vérifier si le point de pêche peut être pêché
        if (pointDePeche.essayerPecher()) {
            try {
                // Bateau reste sur le point de pêche pendant 3 secondes puis gagne une ressource
                Thread.sleep(tempsDePeche);

                // Bateau gagne une ressource aléatoire
                Ressource ressource = pointDePeche.estPecher();

                // Ajouter la ressource à l'inventaire du bateau
                if (ressource != null) {
                    this.ajouterRessource(ressource);
                    System.out.println("Le bateau pêcheur a gagné une ressource !");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                // Relâcher le verrou une fois que le processus de pêche est terminé
                pointDePeche.relacherVerrou();
            }
        } else {
            System.out.println("Le point de pêche est déjà en train d'être pêché par un autre bateau.");
        }
    }

    private void afficherItineraire(List<Point> chemin) {
        if (chemin.isEmpty()) {
            System.out.println("Aucun chemin trouvé.");
            return;
        }

        System.out.println("Itinéraire :");
        for (Point point : chemin) {
            System.out.println("(" + point.x + ", " + point.y + ")");
        }
        System.out.println("Arrivé au point de pêche.");
    }


    /*public void seDeplacerVersPointDePeche(List<PointDePeche> pointsDePeche, Grille grille) {
        if (!pointsDePeche.isEmpty()) {
            PointDePeche pointCible = trouverPointDePecheLePlusProche(pointsDePeche);
            seDeplacerVersDestination(pointCible.getPosition(), grille);
        } else {
            System.out.println("Bateau " + getNumeroBateau() + ": Aucun point de pêche disponible.");
        }
    }


    // Méthode pour réinitialiser les points de pêche choisis

    // Méthode pour trouver le point de pêche le plus proche
    private PointDePeche trouverPointDePecheLePlusProche(List<PointDePeche> pointsDePeche) {
        if (pointsDePeche.isEmpty()) {
            return null; // Aucun point de pêche disponible
        }

        PointDePeche pointLePlusProche = pointsDePeche.get(0);
        double distanceMin = calculerDistance(pointLePlusProche.getPosition());

        for (PointDePeche point : pointsDePeche) {
            double distance = calculerDistance(point.getPosition());
            if (distance < distanceMin) {
                distanceMin = distance;
                pointLePlusProche = point;
            }
        }

        return pointLePlusProche;
    }

    private double calculerDistance(Point pointDePeche) {
        // Utilisez la méthode Point.distance pour calculer la distance entre deux points
        return position.distance(pointDePeche);
    }*/
    @Override
    public String toString() {
        return "BateauxPecheurs n°" + numeroBateau +
                ": " + position;
                //", vitesse=" + vitesse +
                //", inventaire=" + inventaire +
                //", pointsDejaPeche=" + pointsDejaPeche +
                //'}';
    }

}