package Main;

import Pathfinding.*;
import Bateaux.*;
import Ressources.*;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

;


public class Main {
    //private BateauxGUI bateauxGUI;
    private BateauxPecheurs bateauPecheur;
    private BateauxPirates bateauPirate;
    private BateauxMarines bateauMarine;
    private List<BateauxPecheurs> bateauxPecheurs;
    private List<BateauxPirates> bateauxPirates;
    private List<BateauxMarines> bateauxMarines;
    private List<PointDePeche> pointsDePeches;
    private List<PointDePeche> pointsDejaPeche;

    //private ApparitionRessources apparitionRessources;
    private Timer timer;
    private Grille grille;

    public Main() {
        //this.apparitionRessources = new ApparitionRessources();
        initGrille();
        //this.bateauxGUI = new BateauxGUI(this);
        //initTimer();
        //startSimulation();



    }
    private void initGrille() {
        grille = new Grille(10, 10);    }
    private void initTimer() {
        int delaiActualisation = 40;
        ActionListener taskPerformer = new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                for (BateauxPecheurs bateauPecheur : bateauxPecheurs) {
                    // Rechercher le point de pêche le plus proche
                    PointDePeche pointCible = BateauxPecheurs.trouverPointPecherLePlusProche(bateauPecheur.getPosition(), pointsDePeches);

                    if (pointCible != null) {
                        // Calculer le chemin le plus court vers le point de pêche
                        grille.placerPointDePeche(pointCible.getPosition().x, pointCible.getPosition().y);
                        List<Point> chemin = AStar.trouverChemin(bateauPecheur.getPosition(), pointCible.getPosition(), grille);

                        // Afficher l'itinéraire (vous pouvez commenter cette ligne si vous ne souhaitez pas l'afficher)
                        afficherItineraire(chemin);

                        // Déplacer le bateau vers le point de pêche
                        /*bateauPecheur.seDeplacerVersPoint(chemin);

                        // Pêcher au point de pêche
                        if (!PointDePeche.essayerPecher()) {
                            bateauPecheur.pecher(pointCible);
                            // Ajouter le point de pêche à la liste des points déjà pêchés
                            pointsDejaPeche.add(pointCible);}*/

                    }
                }
            }
        };

        timer = new Timer(delaiActualisation, taskPerformer);
        timer.start();;
    }


    // Méthode pour afficher l'itinéraire (à des fins de débogage)
    private void afficherItineraire(List<Point> chemin) {
        System.out.println("Itinéraire :");
        for (Point point : chemin) {
            System.out.println("(" + point.x + ", " + point.y + ")");
        }
        System.out.println("Arrivé au point de pêche.");
    }




    /*private void initBateaux(int nbrePecheurs,int nbrePirates,int nbreMarines) {
        bateauxPecheurs = ApparitionBateaux.initBateauxPecheurs(nbrePecheurs,grille);
        bateauxPirates = ApparitionBateaux.initBateauxPirates(nbrePirates,grille);
        bateauxMarines = ApparitionBateaux.initBateauxMarines(nbrePecheurs,grille);

    }*/
    private void startSimulation() {
        // Logique de simulation ici
        timer.start();
    }



    public List<BateauxPecheurs> getBateauxPecheurs() {
        return bateauxPecheurs;
    }
    public List<BateauxPirates> getBateauxPirates() {
        return bateauxPirates;
    }

    public List<BateauxMarines> getBateauxMarines() {
        return bateauxMarines;
    }
    public Bateau getBateauPecheur() {
        return bateauPecheur;
    }

    public Bateau getBateauPirate() {
        return bateauPirate;
    }

    public Bateau getBateauMarine() {
        return bateauMarine;
    }

    public Grille getGrille() {
        return grille;
    }

    public static void main(String[] args) {
        Main simulation = new Main();
    }
}