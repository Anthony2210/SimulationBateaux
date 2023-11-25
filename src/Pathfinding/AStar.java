package Pathfinding;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Collections;



public class AStar {
    public static List<Point> trouverChemin(Point depart, Point arrivee, Grille grille) {

        List noeudDejaCalcule = new ArrayList();


        PriorityQueue<Noeud> filePriorite = new PriorityQueue<>();
        filePriorite.add(grille.getNoeud(depart.x, depart.y));

        while (!filePriorite.isEmpty()) {
            Noeud noeudCourant = filePriorite.poll();
            noeudDejaCalcule.add(noeudCourant);
            System.out.println("Noeud actuel : " + noeudCourant.getPosition());

            if (noeudCourant.getPosition().equals(arrivee)) {

                // Le chemin a été trouvé, reconstruire le chemin
                return reconstruireChemin(noeudCourant);
            }

            List<Noeud> voisins = grille.getVoisins(noeudCourant);
            System.out.println("Voisins trouvés : " + voisins.size());

            for (Noeud voisin : voisins) {
                System.out.println("Voisin : " + voisin.getPosition() + ", Obstacle : " + voisin.estObstacle());
                double nouveauCout = noeudCourant.getCout() + calculerDistance(noeudCourant.getPosition(), voisin.getPosition());
                System.out.println(nouveauCout);
                System.out.println(voisin.getCout());



                if (nouveauCout > voisin.getCout()) {


                    if (noeudDejaCalcule.contains(voisin)) {

                        System.out.println("noeudDejaCalcule");


                    }else{
                    filePriorite.add(voisin);
                    voisin.setCout(nouveauCout);
                    voisin.setNoeudPrecedent(noeudCourant);
                }
                    System.out.println("Voisin ajouté : " + voisin.getPosition() +
                            ", Nouveau coût : " + voisin.getCout() +
                            ", Noeud précédent : " + (voisin.getNoeudPrecedent() != null ? voisin.getNoeudPrecedent().getPosition() : "null"));
                }
            }
        }

        // Aucun chemin trouvé
        System.out.println("Aucun chemin trouvé.");
        return new ArrayList<>();
    }



    private static List<Point> reconstruireChemin(Noeud arrivee) {
        List<Point> chemin = new ArrayList<>();
        Noeud noeudCourant = arrivee;
        System.out.println("construction du chemin");

        while (noeudCourant != null) {
            chemin.add(noeudCourant.getPosition());
            noeudCourant = noeudCourant.getNoeudPrecedent();
            System.out.println(noeudCourant);
        }

        System.out.println("Taille du chemin avant inversion : " + chemin.size());

        // Inverser le chemin pour qu'il soit du départ à l'arrivée
        Collections.reverse(chemin);
        return chemin;
    }
    public static double calculerDistance(Point point1, Point point2) {
        int deltaX = Math.abs(point2.x - point1.x);
        int deltaY = Math.abs(point2.y - point1.y);
        return (deltaX + deltaY);
    }
}




