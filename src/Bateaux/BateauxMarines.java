package Bateaux;

public class BateauxMarines extends Bateau {
    public BateauxMarines(int positionX, int positionY, double vitesse) {
        super(positionX, positionY, vitesse);
        this.capaciteMaxInventaire = 50;

    }
    // Ajoutez des méthodes spécifiques aux bateaux marins ici
}