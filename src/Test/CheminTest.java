package Test;

import Bateaux.*;
import Pathfinding.*;
import Ressources.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;


class CheminTest {
    private List<BateauxPecheurs> bateauxPecheurs;
    private List<PointDePeche> pointsDePeches;
    private List<PointDePeche> pointsDejaPeche;
    private Grille grille;

    @Test
    void test() {
        grille = new Grille(10, 10);
        // Ajouter des exemples d'objets à la liste des bateaux de pêcheurs
        bateauxPecheurs = new ArrayList<BateauxPecheurs>();
        bateauxPecheurs.add(new BateauxPecheurs(0, 0, 1));
        bateauxPecheurs.add(new BateauxPecheurs(1, 1, 1));
        bateauxPecheurs.add(new BateauxPecheurs(5, 5, 1));
        bateauxPecheurs.add(new BateauxPecheurs(7, 7, 1));



        // Ajouter des exemples d'objets à la liste des points de pêche
        pointsDePeches = new ArrayList<PointDePeche>();
        pointsDePeches.add(new PointDePeche(2, 2, grille));
        pointsDePeches.add(new PointDePeche(1, 1, grille));
        pointsDePeches.add(new PointDePeche(0, 1, grille));
        pointsDePeches.add(new PointDePeche(1,0, grille));
        pointsDePeches.add(new PointDePeche(6,6, grille));
        pointsDePeches.add(new PointDePeche(9,9, grille));



        pointsDejaPeche = new ArrayList<PointDePeche>();

        for (BateauxPecheurs bateauPecheur : bateauxPecheurs) {
            System.out.println("\n"+bateauPecheur);
            System.out.println(BateauxPecheurs.trouverPointPecherLePlusProche(bateauPecheur.getPosition(),pointsDePeches));



        }
    }
}
