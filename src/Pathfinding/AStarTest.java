package Pathfinding;

import com.sun.source.tree.NewArrayTree;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class AStarTest {
    @Test
    void testCalculerDistance(){
        Point depart = new Point(0, 0);
        Point arrivee = new Point(1, 1);
        double resultat = AStar.calculerDistance(depart, arrivee);
        assertEquals(resultat,2.0);
        System.out.println(resultat);

    }
    @Test
    void testCalculerDistanceHorizontale(){
        Point depart = new Point(0, 0);
        Point arrivee = new Point(0, 1);
        double resultat = AStar.calculerDistance(depart, arrivee);
        assertEquals(resultat,1.0);
        System.out.println(resultat);

    }

    @Test
    void testTrouverCheminGrille2x2Diagonalgauche()
    {Grille grille = new Grille(2, 2);
        Point depart = new Point(0, 0);
        Point arrivee = new Point(1, 1);

        ArrayList<Point> resultats = new ArrayList<>();
        resultats.add(depart);
        resultats.add(new Point(0,1));
        resultats.add(arrivee);

        List<Point> chemin = AStar.trouverChemin(depart, arrivee, grille);

        System.out.println("Chemin trouvé : " + chemin);
        assertEquals(chemin, resultats );

    }

    @Test
    void testTrouverCheminGrille2x2Diagonaldroit() {

        Grille grille = new Grille(2, 2);
        Point depart = new Point(0, 1);
        Point arrivee = new Point(1, 0);

        ArrayList<Point> resultats = new ArrayList<>();
        resultats.add(depart);
        resultats.add(new Point(0,0));
        resultats.add(arrivee);

        List<Point> chemin = AStar.trouverChemin(depart, arrivee, grille);
        System.out.println("Chemin trouvé : " + chemin);
        assertEquals(chemin, resultats );


    }
    @Test
    void testTrouverCheminGrille2x2droit() {

        Grille grille = new Grille(2, 2);
        Point depart = new Point(0, 0);
        Point arrivee = new Point(1, 0);

        ArrayList<Point> resultats = new ArrayList<>();
        resultats.add(depart);
        resultats.add(new Point(0,1));
        resultats.add(new Point(1,1));
        resultats.add(arrivee);

        List<Point> chemin = AStar.trouverChemin(depart, arrivee, grille);
        System.out.println("Chemin trouvé : " + chemin);
        assertEquals(chemin, resultats );


    }
    @Test
    void testTrouverCheminGrille3x3() {

        Grille grille = new Grille(3, 3);
        Point depart = new Point(0, 0);
        Point arrivee = new Point(2, 2);

        ArrayList<Point> resultats = new ArrayList<>();
        resultats.add(depart);
        resultats.add(new Point(0,1));
        resultats.add(new Point(0,2));
        resultats.add(new Point(1,2));
        resultats.add(arrivee);

        List<Point> chemin = AStar.trouverChemin(depart, arrivee, grille);
        System.out.println("Chemin trouvé : " + chemin);
        assertEquals(chemin, resultats );


    }
    @Test
    void testTrouverCheminGrille10x10() {

        Grille grille = new Grille(10, 10);
        Point depart = new Point(0, 0);
        Point arrivee = new Point(0, 9);

        ArrayList<Point> resultats = new ArrayList<>();
        resultats.add(depart);
        resultats.add(new Point(0,1));
        resultats.add(new Point(0,2));
        resultats.add(new Point(0,3));
        resultats.add(new Point(0,4));
        resultats.add(new Point(0,5));
        resultats.add(new Point(0,6));
        resultats.add(new Point(0,7));
        resultats.add(new Point(0,8));

        resultats.add(arrivee);

        List<Point> chemin = AStar.trouverChemin(depart, arrivee, grille);
        System.out.println("Chemin trouvé : " + chemin);
        assertEquals(chemin, resultats );


    }
    void testreconstruireChemin(){

    }


    private void marquerCheminSurGrille(List<Point> chemin, Grille grille) {
        for (Point point : chemin) {
            grille.getNoeud(point.x, point.y).setChemin(true);
        }
    }


}